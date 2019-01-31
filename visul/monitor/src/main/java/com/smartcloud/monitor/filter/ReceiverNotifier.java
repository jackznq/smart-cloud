package com.smartcloud.monitor.filter;

import com.smartcloud.common.constant.MqQueueConstant;
import com.smartcloud.common.constant.enums.EnumSmsChannel;
import com.smartcloud.common.pojo.MobileMsgTemplate;
import com.smartcloud.common.utils.DateUtil;
import com.smartcloud.monitor.config.MonitorReceiverPropertiesConfig;
import de.codecentric.boot.admin.event.ClientApplicationEvent;
import de.codecentric.boot.admin.event.ClientApplicationStatusChangedEvent;
import de.codecentric.boot.admin.notify.AbstractStatusChangeNotifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

/**
 * 服务下线手机邮件通知
 */
public class ReceiverNotifier extends AbstractStatusChangeNotifier {

    public static final String STATUS_CHANGE = "STATUS_CHANGE";
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private RabbitTemplate rabbitTemplate;
    private MonitorReceiverPropertiesConfig monitorReceiverPropertiesConfig;

    public ReceiverNotifier(MonitorReceiverPropertiesConfig monitorReceiverPropertiesConfig, RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
        this.monitorReceiverPropertiesConfig = monitorReceiverPropertiesConfig;
    }

    /**
     * 通知逻辑
     *
     * @param event 事件
     * @throws Exception 异常
     */
    @Override
    protected void doNotify(ClientApplicationEvent event) throws Exception {
        if (event instanceof ClientApplicationStatusChangedEvent) {
            logger.info("Application {} ({}) is {}", event.getApplication().getName(),
                    event.getApplication().getId(), ((ClientApplicationStatusChangedEvent) event).getTo().getStatus());
            String text = String.format("应用:%s 服务ID:%s 下线，时间：%s", event.getApplication().getName(), event.getApplication().getId(), DateUtil.date(event.getTimestamp()));
            rabbitTemplate.convertAndSend(MqQueueConstant.SERVICE_STATUS_CHANGE,
                    new MobileMsgTemplate(String.join(",", monitorReceiverPropertiesConfig.getMobiles()),
                            text, EnumSmsChannel.ALIYUN.getName()));
        } else {
            logger.info("Application {} ({}) {}", event.getApplication().getName(),
                    event.getApplication().getId(), event.getType());
        }
    }

    /**
     * 判断是否通知
     *
     * @param event 事件
     * @return 是、否
     */
    @Override
    protected boolean shouldNotify(ClientApplicationEvent event) {
        boolean shouldNotify = false;
        if (STATUS_CHANGE.equals(event.getType())
                && event.getApplication().getStatusInfo().isOffline()
                || event.getApplication().getStatusInfo().isDown()) {
            shouldNotify = true;
        }
        return shouldNotify;
    }
}

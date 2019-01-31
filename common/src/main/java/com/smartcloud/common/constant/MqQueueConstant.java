package com.smartcloud.common.constant;

public interface MqQueueConstant {
    /**
     * log rabbit队列名称
     */
    String LOG_QUEUE = "log";

    /**
     * 发送手机短信队列
     */
    String MOBILE_QUEUE = "mobile__queue";

    /**
     * 服务状态队列
     */
    String SERVICE_STATUS_CHANGE = "service_status_change";

    /**
     * zipkin 队列
     */
    String ZIPKIN_NAME_QUEUE = "zipkin";
}

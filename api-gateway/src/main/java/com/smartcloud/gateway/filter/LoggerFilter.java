package com.smartcloud.gateway.filter;

/**
 * 网关日志
 */
/*@Component
public class LoggerFilter extends ZuulFilter {

    @Autowired
    private LogSendService logSendService;

    @Override
    public String filterType() {
        return POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return SEND_RESPONSE_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        logSendService.send(RequestContext.getCurrentContext());
        return null;
    }
}*/

package com.keenness.gateway.config;

import com.keenness.common.util.CookieUtil;
import com.keenness.common.util.jwt.JWTHelper;
import com.keenness.common.util.jwt.JWTInfo;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author cj
 * @create 2018-01-18 11:40
 **/
@Component
public class PrincipalFilter extends ZuulFilter{

    private String zuulPrefix = "/api";

    private String startWith ="/static,/auth/token";

    private String tokenHeader = "Authorization";

    static final String jwtTokenCookieName = "JWT-TOKEN";

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        final String requestUri = request.getRequestURI().substring(zuulPrefix.length());
        final String method = request.getMethod();
        // 不进行拦截的地址
        if (isStartWith(requestUri)) {
            return null;
        }
        JWTInfo jwtInfo = null;
        try{
            jwtInfo = getJWTUser(request, ctx);
        }catch (Exception e){
            failed("{\"result\":\"username is not correct!\"}",401);
            return null;
        }
        return null;
    }

    private JWTInfo getJWTUser(HttpServletRequest request, RequestContext ctx) throws Exception {
        String authToken = CookieUtil.getCookie(request,jwtTokenCookieName);
        if (StringUtils.isBlank(authToken)) {
            authToken = request.getParameter("token");
        }
        ctx.addZuulRequestHeader(tokenHeader, authToken);
        return JWTHelper.parseJWTInfo(authToken);
    }

    /**
     * 不进行拦截的URL
     * @param requestUri
     * @return
     */
    private boolean isStartWith(String requestUri) {
        boolean flag = false;
        for (String s : startWith.split(",")) {
            if (requestUri.startsWith(s)) {
                return true;
            }
        }
        return flag;
    }

    private void failed(String body,int code){
        RequestContext requestContext = RequestContext.getCurrentContext();
        requestContext.setResponseStatusCode(code);
        if (requestContext.getResponseBody() == null) {
            requestContext.setResponseBody(body);
            requestContext.setSendZuulResponse(false);
        }
    }

}

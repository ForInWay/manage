package com.morgan.manage.common.config;

import com.morgan.manage.common.utils.AjaxResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.io.File;


/**
 * @Author:morgan.b.chen
 * @Description: 返回结果统一处理类
 * @Date:2018/7/8
 */
//@ControllerAdvice
/*public class MyResponseBodyAdvice implements ResponseBodyAdvice<Object>{

    private static Logger log = LoggerFactory.getLogger(MyResponseBodyAdvice.class);

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        log.debug("MyResponseBodyAdvice==>supports:" + converterType);
        log.debug("MyResponseBodyAdvice==>supports:" + returnType.getClass());
        log.debug("MyResponseBodyAdvice==>supports:"
                + MappingJackson2HttpMessageConverter.class.isAssignableFrom(converterType));
        return MappingJackson2HttpMessageConverter.class.isAssignableFrom(converterType);
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if (body == null) {
            return body;
        }
        if (body instanceof AjaxResult || body instanceof String || body instanceof ModelAndView) {
            return body;
        } else if (body instanceof File) {
            return body;
        } else {
            log.debug("MyResponseBodyAdvice==>beforeBodyWrite:" + returnType + "," + body);
            AjaxResult result = new AjaxResult(true);
//            result.setCode(StatusCode.OK);
            result.setData(body);
            body = (Object) result;
            return body;
        }
    }
}*/

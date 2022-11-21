package com.example.alertspoc;

import com.example.alertspoc.model.ResponseAbstractClass;
import com.example.alertspoc.model.ResultTagAttribute;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;

@Component
@ControllerAdvice
public class MetricsControllerAdvice implements ResponseBodyAdvice<ResponseAbstractClass> {

    public static final String RESULT_METRICS_ATTRIBUTE = "RESULT_METRICS_ATTRIBUTE";

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return ResponseAbstractClass.class.isAssignableFrom(returnType.getParameterType());
    }

    @Override
    public ResponseAbstractClass beforeBodyWrite(ResponseAbstractClass body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (request instanceof ServletServerHttpRequest servletServerHttpRequest) {
            HttpServletRequest servletRequest = servletServerHttpRequest.getServletRequest();
            servletRequest.setAttribute(RESULT_METRICS_ATTRIBUTE, new ResultTagAttribute(body.user.name));
        }
        return body;
    }

}

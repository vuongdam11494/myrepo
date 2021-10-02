package com.datn.topfood.authen;

import com.datn.topfood.dto.response.Response;
import com.datn.topfood.util.constant.Message;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthenticationEntryPointFilter implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException {
        httpServletResponse.setStatus(HttpStatus.OK.value());
        Response<?> response = new Response<>(false, Message.OTHER_ACTION_IS_DENIED);
        httpServletResponse.setHeader("Content-Type", "Application/Json; charset=UTF-8");
        httpServletResponse.getWriter().write(new ObjectMapper().writeValueAsString(response));
    }
}

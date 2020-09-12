package com.example.demo.config.authenticationhandler.jwt;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component("jwtAuthenticationFailHander")
public class JwtAuthenticationFailHander extends SimpleUrlAuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse
            httpServletResponse, AuthenticationException e) throws IOException, ServletException, IOException {

        httpServletRequest.setCharacterEncoding("UTF-8");
        String username = httpServletRequest.getParameter("uname");
        String password = httpServletRequest.getParameter("pwd");

        httpServletResponse.setContentType("application/json;charset=utf-8");
        PrintWriter out = httpServletResponse.getWriter();
        out.write("{\"status\":\"error\",\"message\":\"incorrect username or password\"}");
        out.flush();
        out.close();
    }
}
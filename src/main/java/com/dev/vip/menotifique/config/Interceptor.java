package com.dev.vip.menotifique.config;

import com.dev.vip.menotifique.model.Tokens;
import com.dev.vip.menotifique.service.TokensService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class Interceptor implements HandlerInterceptor {

    @Autowired
    private TokensService tokensService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (request.getHeader("apikey") == null){
            response.setContentType("application/json;charset=UTF-8");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("{\"status\":401,\"message\":\"Sem permissão\"}");
            return false;
        }
        String token = request.getHeader("apikey");
        List<Tokens> tokens = tokensService.findByToken(token);
        if (tokens.stream().count() == 1 && tokens != null) {
            return true;
        } else {
            response.setContentType("application/json;charset=UTF-8");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("{\"status\":401,\"message\":\"Sem permissão\"}");
            return false;
        }
    }
}

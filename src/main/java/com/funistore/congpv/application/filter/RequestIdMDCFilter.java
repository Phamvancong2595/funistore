package com.funistore.congpv.application.filter;

import com.funistore.congpv.infrastruture.AppConstants;
import org.slf4j.MDC;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

public class RequestIdMDCFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String requestId = UUID.randomUUID().toString();
            MDC.put(AppConstants.REQUEST_ID_KEY,requestId);
            response.setHeader(AppConstants.REQUEST_ID_KEY,requestId);
            filterChain.doFilter(request,response);
        } finally {
            MDC.remove(AppConstants.REQUEST_ID_KEY);
        }
    }
}

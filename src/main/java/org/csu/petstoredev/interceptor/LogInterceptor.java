package org.csu.petstoredev.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.csu.petstoredev.persistence.UserMapper;
import org.csu.petstoredev.persistence.ViewLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@Component
public class LogInterceptor implements HandlerInterceptor {

    private static Logger log= Logger.getLogger(String.valueOf(LogInterceptor.class));


    @Autowired
    ViewLogMapper viewLogMapper;
    @Autowired
    UserMapper userMapper;


    private final Map<String, KeywordHandler> keywordHandlers = new HashMap<>();

    public LogInterceptor(){
        keywordHandlers.put("categoryId", this::insertIntoViewlog);
        keywordHandlers.put("productId", this::insertIntoViewlog);
        keywordHandlers.put("itemId", this::insertIntoViewlog);
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);

        if (request.getRequestURI().startsWith("/static/") ||
                request.getRequestURI().startsWith("/public/") ||
                request.getRequestURI().startsWith("/resources/") ||
                request.getRequestURI().startsWith("/META-INF/resources/")) {

            return true;
        }

        try {
            System.out.println("进入拦截器，路径: " + request.getRequestURI());
            Map<String, String> parameters = new HashMap<>();
            String keyword = request.getParameter("act");

            if (keyword != null) {
                for (String handlersKeyword : keywordHandlers.keySet()) {
                    String value = request.getParameter(handlersKeyword);
                    if (value != null) {
                        parameters.put(handlersKeyword, value);
                    }
                }

                for (Map.Entry<String, String> entry : parameters.entrySet()) {
                    String handlersKeyword = entry.getKey();
                    String value = entry.getValue();
                    try {
                        // 使用 keywordHandlers 处理对应的业务逻辑
                        keywordHandlers.get(handlersKeyword).handle(value);
                        System.out.println("插入到表: " + handlersKeyword + ", 值: " + value);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR); // 返回 500 错误
            return true; // 阻止请求继续
             }

    }


    public void insertIntoViewlog(String history){
        viewLogMapper.viewInsert(history);
        System.out.println("日志插入成功");
        return;
    }

    interface KeywordHandler {
        void handle(String value) throws SQLException;
    }

}





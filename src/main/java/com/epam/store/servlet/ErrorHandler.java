package com.epam.store.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/ErrorHandler")
public class ErrorHandler extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(ErrorHandler.class);
    private static final String ERROR_PAGE = "WEB-INF/jsp/error.jsp";
    private static final String NO_ACCESS_ERROR_PAGE = "WEB-INF/jsp/no-access-error.jsp";

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Throwable throwable = (Throwable) req.getAttribute("javax.servlet.error.exception");
        Integer statusCode = (Integer) req.getAttribute("javax.servlet.error.status_code");
        String requestUri = (String) req.getAttribute("javax.servlet.error.request_uri");

        if (requestUri != null) log.warn("Error when accessing: " + requestUri);
        if (throwable != null) log.warn("Handled exception:", throwable);

        if (statusCode != null) {
            log.warn("Error status code:" + statusCode);
            req.setAttribute("statusCode", statusCode);
            if (statusCode == 403) { //forbidden
                req.getRequestDispatcher(NO_ACCESS_ERROR_PAGE).forward(req, resp);
                return;
            }
        }
        req.getRequestDispatcher(ERROR_PAGE).forward(req, resp);
    }
}

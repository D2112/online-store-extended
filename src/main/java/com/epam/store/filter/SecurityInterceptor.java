package com.epam.store.filter;

import com.epam.store.model.Role;
import com.epam.store.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecurityInterceptor extends HandlerInterceptorAdapter {
    private static final Logger log = LoggerFactory.getLogger(SecurityInterceptor.class);
    private static final String ADMIN_PAGE_PREFIX = "/admin";
    private static final String USER_PAGE_PREFIX = "/user";
    private static final String LOGIN_PAGE_NAME = "/login";

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object o) throws Exception {
        String path = req.getRequestURI();
        User user = (User) req.getSession().getAttribute("user");

        log.debug("Detected access to path: " + path);

        //if path is not secret and available for all just go further
        if (!path.startsWith(ADMIN_PAGE_PREFIX) && !path.startsWith(USER_PAGE_PREFIX)) {
            log.debug("Path is not protected, passing further");
            return true;
        }
        if (user == null) {
            resp.sendRedirect(LOGIN_PAGE_NAME);
            log.debug("Can't find user, redirect to login page");
            return false;
        } else {
            String roleName = user.getRole().getName();
            if (roleName.equals(Role.ADMIN_ROLE_NAME)) {
                log.debug("Request has admin role, let it go");
                return true;
            }
            if (roleName.equals(Role.USER_ROLE_NAME) && path.startsWith(ADMIN_PAGE_PREFIX)) {
                log.debug("User has been rejected in access to admin page");
                resp.sendError(HttpServletResponse.SC_FORBIDDEN);
                return false;
            }
        }
        return true;
    }
}

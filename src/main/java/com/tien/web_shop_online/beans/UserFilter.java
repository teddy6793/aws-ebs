package com.tien.web_shop_online.beans;

import com.tien.web_shop_online.entities.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UserFilter implements Filter {
    private final static Integer CUSTOMER_ROLE_ID = 3;
    private final static Integer STAFF_ROLE_ID = 2;
    private final static Integer ADMIN_ROLE_ID = 1;
    private final static Logger LOG = LoggerFactory.getLogger(RequestResponseLoggingFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        Customer customer = (Customer) session.getAttribute("user");
        if(customer != null){
            if(customer.getRole().getId() == ADMIN_ROLE_ID || customer.getRole().getId() == STAFF_ROLE_ID){
                chain.doFilter(request,response);
            }else{
                LOG.info("User is not admin/staff");
                res.sendRedirect(req.getContextPath()+"/index");
            }
        }else{
            LOG.info("User is null");
            res.sendRedirect(req.getContextPath()+"/sign_in_sign_up");
        }
    }
}

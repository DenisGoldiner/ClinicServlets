package com.denis.servlets;

import com.denis.store.UserCache;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * Created by Denis on 09.11.2015.
 */
public class UserViewServlet extends HttpServlet{

    private final UserCache USER_CACHE = UserCache.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("clients", this.USER_CACHE.values());
        RequestDispatcher dispatcher = req.getRequestDispatcher("views/user/UserView.jsp");
        dispatcher.forward(req, resp);
    }
}

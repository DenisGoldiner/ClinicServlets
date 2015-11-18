package com.denis.servlets;

import com.denis.models.Client;
import com.denis.models.Pet;
import com.denis.store.UserCache;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * Created by Denis on 09.11.2015.
 */
public class UserEditServlet extends HttpServlet {

    final AtomicInteger ids = new AtomicInteger();

    private static final UserCache USER_CACHE = UserCache.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("user", this.USER_CACHE.getClient(Integer.valueOf(req.getParameter("id"))));
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/user/EditUser.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.USER_CACHE.editClient(new Client(this.ids.incrementAndGet(), req.getParameter("clientName"), new Pet(req.getParameter("petName"), Integer.valueOf(req.getParameter("petAge")))));
        resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/user/view"));
    }
}

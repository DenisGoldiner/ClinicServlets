package com.denis.servlets;

import com.denis.Client;
import com.denis.Clinic;
import com.denis.Pet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * Created by Denis on 05.11.2015.
 */
public class ClinicServlet extends HttpServlet {

    Clinic clinic = new Clinic();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.append(
                "<!DOCTYPE html>" +
                        "<html>" +
                        "<head>" +
                        "   <title>Clinic Pets</title>" +
                        "</head>" +
                        "   <form action='" + req.getContextPath() + "/' method='post'>" +
                        "       Client Name...: <input type='text' name='clientName'><br></br>" +
                        "       Pet's Name.....: <input type='text' name='petName'><br></br>" +
                        "       Pet's Age.......: <input type='integer' name='petAge'><br></br>" +
                        "       <input type='submit' value='Add Pet'><br>" +
                        "   <form>" +
                        this.viewPets() +
                        "   <form action='" + req.getContextPath() + "/' method='post'><br>" +
                        "       Search Name..: <input type='text' name='searchName'><br></br>" +
                        "       <input type='submit' value='Search Pet'>" +
                        "   <form>" +
                        this.viewSearchRes() +
                        "</body>" +
                        "</html>"
        );
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!req.getParameter("clientName").isEmpty() && !req.getParameter("petAge").isEmpty() && !req.getParameter("petName").isEmpty()){
            this.clinic.addClient(new Client(req.getParameter("clientName"), new Pet(req.getParameter("petName"), Integer.valueOf(req.getParameter("petAge")))));
        }
        if (!req.getParameter("searchName").isEmpty()){
            clinic.findClient(req.getParameter("searchName"));
        }
        doGet(req, resp);
    }

    private String viewPets(){
        StringBuilder sb = new StringBuilder();
        sb.append("<p>Pets</p>");
        sb.append("<table style='border : 1px solid black'>");
        for(Client client : clinic.clients){
            sb.append("<tr>" +
                        "<td style=border : 1px solid black'>").append(client.getClientName()).append("</td>" +
                    "<td style=border : 1px solid black'>").append(client.getPet().getPetName()).append("</td>" +
                        "<td style=border : 1px solid black'>").append(client.getPet().getPetAge()).append("</td>" +
                    "</tr>");
        }
        sb.append("</table>");
        return sb.toString();
    }

    private String viewSearchRes(){
        StringBuilder sb = new StringBuilder();
        sb.append("<p>Search result</p>");
        sb.append("<table style='border : 1px solid black'>");
        for(Client client : clinic.searchList){
            sb.append("<tr>" +
                    "<td style=border : 1px solid black'>").append(client.getClientName()).append("</td>" +
                    "<td style=border : 1px solid black'>").append(client.getPet().getPetName()).append("</td>" +
                    "<td style=border : 1px solid black'>").append(client.getPet().getPetAge()).append("</td>" +
                    "</tr>");
        }
        sb.append("</table>");
        return sb.toString();
    }


}

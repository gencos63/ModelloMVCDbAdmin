package controller;

import model.Customer;
import model.CustomerDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/show-all"})
public class ShowAll extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Customer> customers;

        CustomerDAO cd = new CustomerDAO();

        String address = "/WEB-INF/results/showAll.jsp";

        RequestDispatcher rd;

        customers = cd.doRetrieveAll();

        req.setAttribute("customers", customers);

        rd = req.getRequestDispatcher(address);

        rd.forward(req, resp);
    }
}

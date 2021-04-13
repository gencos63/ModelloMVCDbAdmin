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

@WebServlet("/update-customer")
public class UpdateCustomer extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher rd;

        CustomerDAO cd = new CustomerDAO();

        String address;

        Customer c = cd.doRetrieveById(Integer.parseInt(req.getParameter("id")));

        if(c != null) {

            address = "/WEB-INF/results/updateCustomer.jsp";

            req.setAttribute("customer", c);
        }

        else

            address = "/WEB-INF/results/unknown-customer.jsp";

        rd = req.getRequestDispatcher(address);

        rd.forward(req, resp);
    }
}

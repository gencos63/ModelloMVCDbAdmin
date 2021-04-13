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


/**
 * Servlet that reads a customer ID and displays
 * information on the account balance of the customer
 * who has that ID.
 * <p>
 * From <a href="http://courses.coreservlets.com/Course-Materials/">the
 * coreservlets.com tutorials on servlets, JSP, Struts, JSF, Ajax, GWT,
 * Spring, Hibernate/JPA, and Java programming</a>.
 */

@WebServlet("/show-balance")
public class ShowBalance extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException , NumberFormatException {
        String address;
        // reading parameters from the request
        String cID=request.getParameter("customerId");

        // visto che il form index.html non permette l'inserimento di una stringa nel campo customerId (input type= "number), questo controllo sembrerebbe inutile
        // Bisogna per� tener conto che questa servlet potrebbe essere chiamata non tramite il mio form
        // ma da una url inserita nel browser : http://localhost:8080/modelloMVCdb_war_exploded/show-balance?customerId=ciao
        // si noti  che cusotmerId = ciao
        // In questo caso questo controllo � necessario: nel progetto va sempre fatto il doppio controllo (sia lato client che lato server) come fatto in questa applicazione
        int customerId=0;
        try {
            customerId = Integer.parseInt(cID);
        }
        catch (NumberFormatException e){
            address="/WEB-INF/results/unknown-customer.jsp";
            RequestDispatcher dispatcher =
                    request.getRequestDispatcher(address);
            dispatcher.forward(request, response);
        }

        CustomerDAO service = new CustomerDAO();

        Customer customer = service.doRetrieveById(customerId);

        request.setAttribute("customer", customer);

        if (customer == null) {
            request.setAttribute("badId", customerId);
            address = "/WEB-INF/results/unknown-customer.jsp";
        } else if (customer.getBalance() < 0) {
            address = "/WEB-INF/results/negative-balance.jsp";
        } else if (customer.getBalance() < 10000) {
            address = "/WEB-INF/results/normal-balance.jsp";
        } else {
            address = "/WEB-INF/results/high-balance.jsp";
        }

        // The servlet dispatches the control to the chosen jsp (through its address)
        // and passes it both the reference to the javabean (stored in the "request") and
        // the response where the jsp will store the final page.
        RequestDispatcher dispatcher =
                request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }
}

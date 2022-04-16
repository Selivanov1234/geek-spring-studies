package ru.geekbrains;

import ru.geekbrains.product.Product;
import ru.geekbrains.product.ProductRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/product/*")

public class ProductServlet extends HttpServlet {
    private ProductRepository pr;

    @Override
    public void init() throws ServletException {
        this.pr = new ProductRepository();
        this.pr.insert(new Product("Paper", 10));
        this.pr.insert(new Product("Cola", 5));
        this.pr.insert(new Product("Sand", 3));
        this.pr.insert(new Product("Iron", 20));
        this.pr.insert(new Product("Cooker", 50));
        this.pr.insert(new Product("Salmon", 15));
        this.pr.insert(new Product("Rice", 5));
        this.pr.insert(new Product("Water", 1));
        this.pr.insert(new Product("Lemonade", 4));
        this.pr.insert(new Product("Marmelade", 14));

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("<h1>Привет от продуктов!!!</h1>");
//        resp.getWriter().println("<p>contextPath: " + req.getContextPath() + "</p>");
//        resp.getWriter().println("<p>servletPath: " + req.getServletPath() + "</p>");
//        resp.getWriter().println("<p>pathInfo: " + req.getPathInfo() + "</p>");
//        resp.getWriter().println("<p>queryString: " + req.getQueryString() + "</p>");
//        resp.getWriter().println("<p>param1: " + req.getParameter("param1") + "</p>");
//        resp.getWriter().println("<p>param2: " + req.getParameter("param2") + "</p>");

        PrintWriter wr = resp.getWriter();
        wr.println("<table>");
        wr.println("<tr>");
        wr.println("<th>Id</th>");
        wr.println("<th>Username</th>");
        wr.println("<th>Price</th>");
        wr.println("</tr>");

        for (Product product : pr.findAll()) {
            wr.println("<tr>");
            wr.println("<td><a href='" + req.getPathInfo() + "'>" + product.getId() + "</a></td>");
            wr.println("<td>" + product.getProductname() + "</td>");
            wr.println("<td>" + product.getPrice() + "</td>");
            wr.println("</tr>");
        }
    }
}

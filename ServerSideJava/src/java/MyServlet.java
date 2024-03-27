/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Gamers zone
 */
@WebServlet(urlPatterns = {"/Servlet"})
public class MyServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        
        
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        
        boolean isAuthenticated = false;
        
        String filePath = getServletContext().getRealPath("./users.txt");
          try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
 
                if (parts.length == 3 && parts[1].trim().equals(id) && parts[2].trim().equals(password)) {
                    isAuthenticated = true;
                    break;
                }
            }
            br.close();
        }
          catch (IOException e) {
            System.out.println(e.toString());
        }

        if (isAuthenticated) {
            try (PrintWriter out = response.getWriter()) {
                out.write("OK");
            }
            
        } else {
             try (PrintWriter out = response.getWriter()) {
                 out.write("NO");
             }
            
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

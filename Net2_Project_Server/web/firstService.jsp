<%@ page import="java.io.BufferedReader" %>
<%@ page import="java.io.FileReader" %>
<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    boolean isAuthenticated = false;

    String filePath = getServletContext().getRealPath("/WEB-INF/accounts.txt");

    try {
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 3 && parts[0].trim().equals(username) && parts[2].trim().equals(password)) {
                isAuthenticated = true;
                
                break;
            }
        }
        br.close();
    } catch (Exception e) {
        e.printStackTrace();
    }

    if (isAuthenticated) {
        out.write("OK");
    } else {
        out.write("NO");
    }
%>

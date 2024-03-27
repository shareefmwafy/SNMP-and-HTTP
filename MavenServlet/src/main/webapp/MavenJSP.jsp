<%@ page import="java.io.BufferedReader" %>
<%@ page import="java.io.FileReader" %>
<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    boolean isAuthenticated = false;

    // File path to users.txt
    String filePath = getServletContext().getRealPath("./users.txt");
    String m = "23";
    
    try {
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            m=parts[0]+" "+parts[2];
            
            if (parts.length >= 3 && parts[0].trim().equals(username) && parts[2].trim().equals(password)) {
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
    } else if(!isAuthenticated){
        out.write("NO");
        
    }
%>

<%@ page import="java.util.ArrayList" %>
<%@ page import="java.io.*,java.util.*" %>

<%
    ArrayList<String> userListforJSP = new ArrayList<>();
    userListforJSP.add("101234");
    userListforJSP.add("205678");
    userListforJSP.add("301212");
    userListforJSP.add("402020");

    String IdJSP = request.getParameter("IDJSP");
    String PassJSP = request.getParameter("PassJSP");

    int flag = 0;

    for (String user : userListforJSP) {
       String storedid = user.substring(0, 2);
       String storedPassword = user.substring(2);

        if (PassJSP.equals(storedPassword) && IdJSP.equals(storedid)) {
            flag = 1;
            break; // Exit the loop if a match is found
        }
    }

    if (flag == 1) {
        out.println("OK");
    } else {
        out.println("NO");
    }
%>

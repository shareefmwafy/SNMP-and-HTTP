<%@ page import = "java.io.*,java.util.*" %>
<%
    Enumeration headerNames = request.getHeaderNames();
    while (headerNames.hasMoreElements()) {
        String paramName = (String) headerNames.nextElement();
        out.print("" + paramName + "\n");
        String paramValue = request.getHeader(paramName);
        out.println("" + paramValue + "\n");
        out.println("-------------\n");

    }
        Enumeration ParameterNames = request.getParameterNames();
    while (ParameterNames.hasMoreElements()) {
        String paramName = (String)ParameterNames.nextElement();
        out.print("" + paramName + "\n");
        String paramValue = request.getParameter(paramName);
        out.println("" + paramValue + "\n");
        out.println("-------------\n");

    }
%>

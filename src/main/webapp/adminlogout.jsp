<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" %>
<%@ page import="java.io.*" %>

<%
    // Invalidate session to logout
    session.invalidate();
    response.sendRedirect("index.html");
%>

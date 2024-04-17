<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, javax.servlet.http.HttpSession" %>
<%

    Connection conn = (Connection) session.getAttribute("connection");
    
    // Retrieve student ID from request parameter
    int studentId = Integer.parseInt(request.getParameter("id"));
    
    // Initialize variable to track deletion status
    boolean deletionSuccessful = false;
    
    // Check if student ID is provided
    if (studentId != 0 && studentId > 0) {
        try {
            // Create prepared statement to delete student record
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM studentmgmt.student WHERE id = ?");
            pstmt.setInt(1, studentId);
            
            // Execute the delete query
            int rowsAffected = pstmt.executeUpdate();
            
            // Check if deletion was successful
            if (rowsAffected > 0) {
                deletionSuccessful = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Redirect to a page indicating deletion status
    if (deletionSuccessful) {
        response.sendRedirect("index.html");
    } else {
        response.sendRedirect("error.jsp");
    }
%>
</html>
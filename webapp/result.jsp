<!DOCTYPE html>
<html>
<head>
    <title>Registration Result</title>
</head>
<body>
    <h2>Registration Successful</h2>
    <%
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        if (name == null || email == null ||
            phone == null || password == null ||
            name.trim().isEmpty() || password.isEmpty()) {
    %>
        <p>Please submit the registration form first.</p>
        <a href="register.jsp">Go to Registration Form</a>
    <%
        } else {
    %>
        <h3>Submitted Information</h3>
        <p>Name: <%= name %></p>
        <p>Email: <%= email %></p>
        <p>Phone Number: <%= phone %></p>
        <p>Password: Received successfully (hidden for security)</p>
        <a href="register.jsp">Back to Registration</a>
    <%
        }
    %>
</body>
</html>

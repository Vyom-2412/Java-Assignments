<%@ page import="java.sql.*" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String message = "";
    String action = request.getParameter("action");

    String url = "jdbc:mysql://localhost:3306/ass30";
    String dbUser = "root";
    String dbPassword = "vyom@2412";

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");

        if ("add".equals(action)) {
            try (Connection con = DriverManager.getConnection(url, dbUser, dbPassword);
                 PreparedStatement ps = con.prepareStatement(
                     "insert into employee values (?, ?, ?, ?)")) {

                ps.setInt(1, Integer.parseInt(request.getParameter("employee_id")));
                ps.setString(2, request.getParameter("name"));
                ps.setString(3, request.getParameter("department"));
                ps.setDouble(4, Double.parseDouble(request.getParameter("salary")));

                ps.executeUpdate();
                message = "Employee added successfully.";
            }
        } else if ("update".equals(action)) {
            try (Connection con = DriverManager.getConnection(url, dbUser, dbPassword);
                 PreparedStatement ps = con.prepareStatement(
                     "update employee set name=?, department=?, salary=? where employee_id=?")) {

                ps.setString(1, request.getParameter("name"));
                ps.setString(2, request.getParameter("department"));
                ps.setDouble(3, Double.parseDouble(request.getParameter("salary")));
                ps.setInt(4, Integer.parseInt(request.getParameter("employee_id")));

                int rows = ps.executeUpdate();
                message = rows > 0 ? "Employee updated successfully."
                                   : "Employee ID not found.";
            }
        } else if ("delete".equals(action)) {
            try (Connection con = DriverManager.getConnection(url, dbUser, dbPassword);
                 PreparedStatement ps = con.prepareStatement(
                     "delete from employee where employee_id=?")) {

                ps.setInt(1, Integer.parseInt(request.getParameter("employee_id")));

                int rows = ps.executeUpdate();
                message = rows > 0 ? "Employee deleted successfully."
                                   : "Employee ID not found.";
            }
        }
    } catch (Exception e) {
        message = "Error: " + e.getMessage();
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Employee Management</title>
</head>
<body>
    <h2>Employee Management System</h2>
    <p><%= message %></p>
    <h3>Add Employee</h3>
    <form method="post" action="employee.jsp">
        <input type="hidden" name="action" value="add">
        Employee ID:
        <input type="number" name="employee_id" required><br><br>
        Name:
        <input type="text" name="name" required><br><br>
        Department:
        <input type="text" name="department" required><br><br>
        Salary:
        <input type="number" name="salary" step="0.01" min="0" required><br><br>
        <input type="submit" value="Add Employee">
    </form>
    <hr>
    <h3>Update Employee</h3>
    <form method="post" action="employee.jsp">
        <input type="hidden" name="action" value="update">
        Employee ID:
        <input type="number" name="employee_id" required><br><br>
        New Name:
        <input type="text" name="name" required><br><br>
        New Department:
        <input type="text" name="department" required><br><br>
        New Salary:
        <input type="number" name="salary" step="0.01" min="0" required><br><br>
        <input type="submit" value="Update Employee">
    </form>
    <hr>
    <h3>Delete Employee</h3>
    <form method="post" action="employee.jsp">
        <input type="hidden" name="action" value="delete">
        Employee ID:
        <input type="number" name="employee_id" required><br><br>
        <input type="submit" value="Delete Employee">
    </form>
    <hr>
    <h3>Employee Records</h3>
    <table border="1" cellpadding="8">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Department</th>
            <th>Salary</th>
        </tr>
        <%
            try (Connection con = DriverManager.getConnection(url, dbUser, dbPassword);
                 Statement st = con.createStatement();
                 ResultSet rs = st.executeQuery("select * from employee order by employee_id")) {

                while (rs.next()) {
        %>
        <tr>
            <td><%= rs.getInt("employee_id") %></td>
            <td><%= rs.getString("name") %></td>
            <td><%= rs.getString("department") %></td>
            <td><%= rs.getBigDecimal("salary") %></td>
        </tr>
        <%
                }
            } catch (Exception e) {
        %>
        <tr>
            <td colspan="4">Unable to load employees: <%= e.getMessage() %></td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>

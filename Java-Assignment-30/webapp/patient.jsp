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
                     "insert into patient values (?, ?, ?, ?, ?)")) {

                ps.setInt(1, Integer.parseInt(request.getParameter("patient_id")));
                ps.setString(2, request.getParameter("name"));
                ps.setInt(3, Integer.parseInt(request.getParameter("age")));
                ps.setString(4, request.getParameter("disease"));
                ps.setString(5, request.getParameter("treatment_status"));

                ps.executeUpdate();
                message = "Patient added successfully.";
            }
        } else if ("update".equals(action)) {
            try (Connection con = DriverManager.getConnection(url, dbUser, dbPassword);
                 PreparedStatement ps = con.prepareStatement(
                     "update patient set name=?, age=?, disease=?, treatment_status=? where patient_id=?")) {

                ps.setString(1, request.getParameter("name"));
                ps.setInt(2, Integer.parseInt(request.getParameter("age")));
                ps.setString(3, request.getParameter("disease"));
                ps.setString(4, request.getParameter("treatment_status"));
                ps.setInt(5, Integer.parseInt(request.getParameter("patient_id")));

                int rows = ps.executeUpdate();
                message = rows > 0 ? "Patient updated successfully."
                                   : "Patient ID not found.";
            }
        } else if ("delete".equals(action)) {
            try (Connection con = DriverManager.getConnection(url, dbUser, dbPassword);
                 PreparedStatement ps = con.prepareStatement(
                     "delete from patient where patient_id=?")) {

                ps.setInt(1, Integer.parseInt(request.getParameter("patient_id")));

                int rows = ps.executeUpdate();
                message = rows > 0 ? "Patient deleted successfully."
                                   : "Patient ID not found.";
            }
        }
    } catch (Exception e) {
        message = "Error: " + e.getMessage();
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Patient Management</title>
</head>
<body>
    <h2>Patient Management System</h2>
    <p><%= message %></p>
    <h3>Add Patient</h3>
    <form method="post" action="patient.jsp">
        <input type="hidden" name="action" value="add">
        Patient ID:
        <input type="number" name="patient_id" required><br><br>
        Name:
        <input type="text" name="name" required><br><br>
        Age:
        <input type="number" name="age" min="0" required><br><br>
        Disease:
        <input type="text" name="disease" required><br><br>
        Treatment Status:
        <select name="treatment_status" required>
            <option value="under treatment">Under Treatment</option>
            <option value="recovered">Recovered</option>
            <option value="discharged">Discharged</option>
        </select><br><br>
        <input type="submit" value="Add Patient">
    </form>
    <hr>
    <h3>Update Patient</h3>
    <form method="post" action="patient.jsp">
        <input type="hidden" name="action" value="update">
        Patient ID:
        <input type="number" name="patient_id" required><br><br>
        New Name:
        <input type="text" name="name" required><br><br>
        New Age:
        <input type="number" name="age" min="0" required><br><br>
        New Disease:
        <input type="text" name="disease" required><br><br>
        Treatment Status:
        <select name="treatment_status" required>
            <option value="under treatment">Under Treatment</option>
            <option value="recovered">Recovered</option>
            <option value="discharged">Discharged</option>
        </select><br><br>
        <input type="submit" value="Update Patient">
    </form>
    <hr>
    <h3>Delete Patient</h3>
    <form method="post" action="patient.jsp">
        <input type="hidden" name="action" value="delete">
        Patient ID:
        <input type="number" name="patient_id" required><br><br>
        <input type="submit" value="Delete Patient">
    </form>
    <hr>
    <h3>Patient Records</h3>
    <table border="1" cellpadding="8">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Age</th>
            <th>Disease</th>
            <th>Treatment Status</th>
        </tr>
        <%
            try (Connection con = DriverManager.getConnection(url, dbUser, dbPassword);
                 Statement st = con.createStatement();
                 ResultSet rs = st.executeQuery("select * from patient order by patient_id")) {

                while (rs.next()) {
        %>
        <tr>
            <td><%= rs.getInt("patient_id") %></td>
            <td><%= rs.getString("name") %></td>
            <td><%= rs.getInt("age") %></td>
            <td><%= rs.getString("disease") %></td>
            <td><%= rs.getString("treatment_status") %></td>
        </tr>
        <%
                }
            } catch (Exception e) {
        %>
        <tr>
            <td colspan="5">Unable to load patients: <%= e.getMessage() %></td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>

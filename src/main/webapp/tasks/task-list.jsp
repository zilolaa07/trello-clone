<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="uz.pdp.dto.TaskDto" %>
<html>
<head>
  <title>Task List</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="container mt-4">

<h2>Task List</h2>
<a href="task-form.jsp" class="btn btn-primary mb-3">+ Add New Task</a>

<table class="table table-bordered table-hover">
  <thead class="table-light">
  <tr>
    <th>ID</th>
    <th>Title</th>
    <th>Description</th>
    <th>Status</th>
    <th>Workspace ID</th>
    <th>Actions</th>
  </tr>
  </thead>
  <tbody>
  <%
    List<TaskDto> tasks = (List<TaskDto>) request.getAttribute("tasks");
    if (tasks != null) {
      for (TaskDto task : tasks) {
  %>
  <tr>
    <td><%= task.getId() %></td>
    <td><%= task.getName() %></td>
    <td><%= task.getDescription() %></td>
    <td><%= task.getSortOrder() %></td>
    <td><%= task.getWorkspaceId() %></td>
    <td>
      <a href="tasks?action=edit&id=<%= task.getId() %>" class="btn btn-sm btn-warning">Edit</a>
      <a href="tasks?action=delete&id=<%= task.getId() %>" class="btn btn-sm btn-danger"
         onclick="return confirm('Are you sure to delete this task?');">Delete</a>
    </td>
  </tr>
  <%
      }
    }
  %>
  </tbody>
</table>

</body>
</html>

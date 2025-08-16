<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import=" uz.pdp.dto.TaskDto" %>
<html>
<head>
    <title>Task Form</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="container mt-4">

<%
    TaskDto task = (TaskDto) request.getAttribute("task");
    boolean isEdit = (task != null);
%>

<h2><%= isEdit ? "Edit Task" : "Create Task" %></h2>

<form action="tasks" method="post">
    <% if (isEdit) { %>
    <input type="hidden" name="id" value="<%= task.getId() %>"/>
    <input type="hidden" name="action" value="update"/>
    <% } %>

    <div class="mb-3">
        <label class="form-label">Title</label>
        <input type="text" name="title" class="form-control" value="<%= isEdit ? task.getName() : "" %>" required/>
    </div>

    <div class="mb-3">
        <label class="form-label">Description</label>
        <textarea name="description" class="form-control"><%= isEdit ? task.getDescription() : "" %></textarea>
    </div>

    <div class="mb-3">
        <label class="form-label">Status</label>
        <select name="status" class="form-select" required>
            <option value="TODO" <%= isEdit && "TODO".equals(task.getSortOrder()) ? "selected" : "" %>>TODO</option>
            <option value="IN_PROGRESS" <%= isEdit && "IN_PROGRESS".equals(task.getSortOrder()) ? "selected" : "" %>>IN_PROGRESS</option>
            <option value="DONE" <%= isEdit && "DONE".equals(task.getSortOrder()) ? "selected" : "" %>>DONE</option>
        </select>
    </div>

    <div class="mb-3">
        <label class="form-label">Workspace ID</label>
        <input type="number" name="workspaceId" class="form-control"
               value="<%= isEdit ? task.getWorkspaceId() : "" %>" required/>
    </div>

    <button type="submit" class="btn btn-success"><%= isEdit ? "Update" : "Create" %></button>
    <a href="tasks" class="btn btn-secondary">Cancel</a>
</form>

</body>
</html>

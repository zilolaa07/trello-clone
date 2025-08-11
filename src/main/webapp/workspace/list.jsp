<%@ page contentType="text/html;charset=UTF-8" language="java" %>
 <!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Workspace'lar ro‘yxati</title>
    <link href="https://fonts.googleapis.com/css2?family=Inter&display=swap" rel="stylesheet">
    <style>
        body {
            font-family: 'Inter', sans-serif;
            background-color: #f7f9fc;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 800px;
            margin: 60px auto;
            background-color: #fff;
            padding: 30px 40px;
            border-radius: 10px;
            box-shadow: 0 2px 12px rgba(0, 0, 0, 0.08);
        }

        h1 {
            font-size: 28px;
            color: #2c3e50;
            margin-bottom: 30px;
        }

        .workspace {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 14px 0;
            border-bottom: 1px solid #e1e4e8;
        }

        .workspace-name {
            font-size: 18px;
            font-weight: 500;
            color: #34495e;
        }

        .actions a {
            margin-left: 10px;
            text-decoration: none;
            padding: 6px 12px;
            font-size: 14px;
            border-radius: 6px;
            color: #fff;
        }

        .view-btn {
            background-color: #3498db;
        }

        .edit-btn {
            background-color: #f39c12;
        }

        .add-btn {
            display: inline-block;
            margin-top: 30px;
            padding: 10px 18px;
            background-color: #2ecc71;
            color: white;
            text-decoration: none;
            border-radius: 6px;
            font-size: 16px;
        }

    </style>
</head>
<body>
<div class="container">
    <h1>Workspace'lar ro‘yxati</h1>

    <c:forEach var="w" items="${workspaces}">
        <div class="workspace">
            <div class="workspace-name">${w.name}</div>
            <div class="actions">
                <a class="view-btn" href="/workspace/${w.id}">Ko‘rish</a>
                <a class="edit-btn" href="/workspace?action=update&id=${w.id}">Tahrirlash</a>
            </div>
        </div>
    </c:forEach>

    <a href="/workspace?action=add" class="add-btn">+ Yangi Workspace</a>
</div>
</body>
</html>

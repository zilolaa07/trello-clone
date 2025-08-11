<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Workspace tahrirlash</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f9f9f9;
            padding: 40px;
        }
        .container {
            background: white;
            max-width: 450px;
            padding: 30px;
            margin: auto;
            border-radius: 10px;
            box-shadow: 0 0 15px rgba(0,0,0,0.1);
        }
        label {
            display: block;
            margin-bottom: 8px;
            font-weight: bold;
        }
        input[type="text"] {
            width: 100%;
            padding: 8px 12px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 6px;
            font-size: 16px;
        }
        button {
            background-color: #3498db;
            color: white;
            padding: 10px 18px;
            border: none;
            border-radius: 6px;
            font-size: 16px;
            cursor: pointer;
        }
        a {
            margin-left: 15px;
            color: #555;
            text-decoration: none;
            font-size: 14px;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Workspace tahrirlash</h2>

    <form action="/workspace" method="post">
        <input type="hidden" name="action" value="update">
        <input type="hidden" name="id" value="${workspace.id}">

        <label for="name">Workspace nomi:</label>
        <input type="text" id="name" name="name" value="${workspace.name}" required>

        <button type="submit">Saqlash</button>
        <a href="/workspace">Bekor qilish</a>
    </form>
</div>
</body>
</html>

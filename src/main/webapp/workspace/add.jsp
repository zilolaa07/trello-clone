<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Yangi Workspace</title>
    <link href="https://fonts.googleapis.com/css2?family=Inter&display=swap" rel="stylesheet">
    <style>
        body {
            font-family: 'Inter', sans-serif;
            background-color: #f4f6f8;
            margin: 0;
            padding: 0;
        }
        .container {
            max-width: 500px;
            margin: 80px auto;
            background-color: #fff;
            padding: 35px 40px;
            border-radius: 12px;
            box-shadow: 0 4px 15px rgba(0,0,0,0.1);
        }
        h1 {
            font-size: 26px;
            margin-bottom: 25px;
            color: #2c3e50;
        }
        label {
            display: block;
            font-weight: 600;
            margin-bottom: 8px;
            color: #34495e;
        }
        input[type="text"] {
            width: 100%;
            padding: 10px 12px;
            font-size: 16px;
            border: 1px solid #ccc;
            border-radius: 6px;
            margin-bottom: 20px;
        }
        .buttons {
            display: flex;
            justify-content: flex-start;
            gap: 10px;
        }
        .btn {
            padding: 10px 18px;
            font-size: 16px;
            text-decoration: none;
            border-radius: 6px;
            cursor: pointer;
            border: none;
        }
        .btn-submit {
            background-color: #27ae60;
            color: #fff;
        }
        .btn-cancel {
            background-color: #bdc3c7;
            color: #2c3e50;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Yangi Workspace yaratish</h1>

    <form action="/workspace" method="post">
        <input type="hidden" name="action" value="add">

        <label for="name">Workspace nomi:</label>
        <input type="text" id="name" name="name" placeholder="Masalan: My Project" required>

        <div class="buttons">
            <button type="submit" class="btn btn-submit">Yaratish</button>
            <a href="/workspace" class="btn btn-cancel">Bekor qilish</a>
        </div>
    </form>
</div>
</body>
</html>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <style>
        a {
            padding: 0px;
            text-decoration: none;
            background-color: #4CAF50;
            color: white;
            padding: 16px;
            font-size: 16px;
            border: none;
            cursor: pointer;
        }

        a:hover {
            background-color: #3e8e41;
        }
    </style>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/all.css">
</head>

<body topmargin="7%">
    <center>
        <h1 style="color: #0d9fe2;">请选择身份</h1>
        <br>
        <br>
        <br>
        <a href="doctor_log.html">医 生</a>
        <br>
        <br>
        <br>
        <br>
        <a href="patient_log.html">患 者</a>
        <br>
        <br>
        <br>
        <br>
        <a href="admin_log.html">管理员</a>
        <br>
        <br>
        <br>
        <br>
    </center>

</body>

</html>
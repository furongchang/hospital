<%@ page import="org.example.domain.doctor" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 付荣畅
  Date: 2021/12/21
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<doctor> doctors = (List) request.getAttribute("doctor");
%>
<html>
<head>
    <title>Title</title>
    <style>
        table.tftable,
        table.table-count {
            font-size: 12px;
            color: #333333;
            width: 100%;
            border-width: 1px;
            border-collapse: collapse;
        }

        table.table-count th,
        table.table-count td {
            font-weight: 400;
            font-style: normal;
            font-size: 12px;
            border-width: 1px;
            border-style: solid;
            border-color: #e4e4e4;
            text-align: center;
        }

        table.tftable th,
        table.tftable td {
            font-weight: 400;
            font-style: normal;
            font-size: 12px;
            border-width: 1px;
            padding: 8px;
            border-style: solid;
            border-color: #e4e4e4;
            text-align: left;
            text-align: center;
        }

        .tftable {
            margin-left: 1%;
            margin-bottom: 10px;
            margin-top: 10px;
        }

        table.tftable tr:hover {
            background: #C3ECFF;
        }

        .tftable>thead>tr:hover {
            background: white;
        }
    </style>
</head>
<body topmargin="7%">
<center>
    <table class="tftable" style="width: 98%;">
        <tr>
            <th>用户名</th>
            <th>密码</th>
            <th>姓名</th>
            <th>科室</th>
            <th>性别</th>
            <th>电话</th>
        </tr>
        <%
            for (doctor d:doctors) {
        %>
        <tr>
            <td><%=d.getUsername()%></td>
            <td><%=d.getPassword()%></td>
            <td><%=d.getName()%></td>
            <td><%=d.getOffice()%></td>
            <td><%=d.getSex()%></td>
            <td><%=d.getPhone()%></td>
        </tr>
        <%
            }
        %>
    </table>
</center>
</body>
</html>

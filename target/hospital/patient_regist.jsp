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
    List<doctor> doctors = (List) request.getAttribute("doctors");
%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>查找</title>
    <style type="text/css">
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
        tbody {
            font-size: 25px;
            color: #3e8e41;
            background: EBD3E8;
            height: 50px;
            width: 500px;
        }

        .button {
            background-color: #4CAF50;
            border: none;
            color: white;
            padding: 15px 32px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 4px 2px;
            cursor: pointer;
        }
    </style>
</head>

<body topmargin="7%">
<center>
    <table class="tftable" style="width: 98%;">
        <tr>
            <th>姓名</th>
            <th>科室</th>
            <th>性别</th>
        </tr>
        <%
            for (doctor d:doctors) {
        %>
        <tr>
            <td><%=d.getName()%></td>
            <td><%=d.getOffice()%></td>
            <td><%=d.getSex()%></td>
        </tr>
        <%
            }
        %>
    </table>
    <form action="/patient_regist" method="post">
        <table>
            <tbody>
            <tr>
                <td>医生姓名:</td>
                <td><input type="text" name="dname"></input></td>
            </tr>
            <tr>
                <td>病情信息:</td>
                <td><input type="text" name="massage"></input></td>
            </tr>
            <tr>
                <td></td>
                <td><button class="button" type="submit" value="确定">确认</button></td>
            </tr>
            </tbody>
        </table>
    </form>
    <br />
    <br />
    <a href="patient.html">跳转到病人页</a>
</center>
</body>

</html>
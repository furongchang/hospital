<%@ page import="java.util.List" %>
<%@ page import="org.example.domain.prescription" %><%--
  Created by IntelliJ IDEA.
  User: 付荣畅
  Date: 2021/12/24
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%List<prescription> prescriptions=(List)request.getAttribute("prescriptions");%>
<html>
<head>
    <title>Title</title>
    <style>
        .button {
            background-color: #0d9fe2; /* Green */
            border: none;
            color: white;
            padding: 15px 32px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
        }
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
<body>
<center>
    <h1 style="color: #0d9fe2;">处方信息</h1>
    <table class="tftable" style="width: 98%;">
        <tr>
            <th>医生</th>
            <th>患者</th>
            <th>处方</th>
            <th>时间</th>
            <th>编号</th>
        </tr>
        <%
            for (prescription p:prescriptions) {
        %>
        <tr>
            <td><%=p.getDname()%></td>
            <td><%=p.getPname()%></td>
            <td><%=p.getPrescription()%></td>
            <td><%=p.getTime()%></td>
            <td><%=p.getId()%></td>
        </tr>
        <%
            }
        %>
    </table>

    <br>
    <br>
    <button class="button" onclick="zhuayao()" >抓药</button>
    <br>
    <form name="form1" action="/evaluate" method="post">
        <table style="margin:auto">
            <tr>
                <td>已治愈，请输入要评价的id：</td>
                <td><input type="text" name="id"></input></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <button class="button" type="submit">评价</button>
                </td>
            </tr>
        </table>
    </form>
</center>

</body>
<script>
    function zhuayao() {
        alert("请去二楼大厅西药房五号窗口拿药")
    }
</script>
</html>

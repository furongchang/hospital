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
<%
    List<doctor> duty_doctors = (List) request.getAttribute("duty_doctors");
%>
<html>

<head>
    <style>
        button {
            width: 100px;
            text-align: center;
            border: #dddddd solid 1px;
            height: 40px;
            line-height: 40px;
            color: #666666;
            user-select: none;
            overflow: hidden;
            position: relative;
        }

        .label_box>label {
            display: block;
            float: left;
            margin: 0 10px 10px 0;
            position: relative;
            overflow: hidden;
        }

        .label_box>label>input {
            position: absolute;
            top: 0;
            left: -20px;
        }

        .label_box>label>div {
            width: 100px;
            text-align: center;
            border: #dddddd solid 1px;
            height: 40px;
            line-height: 40px;
            color: #666666;
            user-select: none;
            overflow: hidden;
            position: relative;
        }

        .label_box>label>input:checked+div {
            border: #d51917 solid 1px;
            color: #d51917;
        }

        .label_box>label>input:checked+div:after {
            content: '';
            display: block;
            width: 20px;
            height: 20px;
            background-color: #d51917;
            transform: skewY(-45deg);
            position: absolute;
            bottom: -10px;
            right: 0;
            z-index: 1;
        }

        .label_box>label>input:checked+div:before {
            content: '';
            display: block;
            width: 3px;
            height: 8px;
            border-right: #ffffff solid 2px;
            border-bottom: #ffffff solid 2px;
            transform: rotate(35deg);
            position: absolute;
            bottom: 2px;
            right: 4px;
            z-index: 2;
        }
    </style>

</head>

<body topmargin="7%">
    <center>
        <form action="/duty_choice" method="post" name="formName">
            <h2 style="color: #d51917">从休班医生中选择值班医生：</h2>
            <br>
            <div class="label_box">
                <%
                    for (doctor d:doctors) {
                %>
                <label>
                    <input type="checkbox" name="name" value="<%=d.getName()%>">
                    <div><%=d.getName()%></div>
                </label>
                <%
                    }
                %>
                <button class="button" type="submit" value="确定">确认</button>
            </div>
        </form>
        <form action="/unduty_choice" method="post" name="formName">
            <h2 style="color: #d51917">从值班医生中选择休班医生：</h2>
            <br>
            <div class="label_box">
                <%
                    for (doctor d:duty_doctors) {
                %>
                <label>
                    <input type="checkbox" name="name" value="<%=d.getName()%>">
                    <div><%=d.getName()%></div>
                </label>
                <%
                    }
                %>
                <button class="button" type="submit" value="确定">确认</button>
            </div>
        </form>
    </center>
</body>

</html>
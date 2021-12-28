<%--
  Created by IntelliJ IDEA.
  User: 付荣畅
  Date: 2021/12/27
  Time: 14:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%String[] autu=(String[])request.getAttribute("autu_medicines");%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table class="tftable" style="width: 98%;">
    <%
        for (String a:autu) {
    %>
    <tr>
        <td><%=a%></td>
    </tr>
    <%
        }
    %>
</table>

</body>
</html>

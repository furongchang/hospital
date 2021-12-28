<%@ page import="java.util.List" %>
<%@ page import="org.example.domain.registration" %>
<%@ page import="org.example.domain.medicine" %><%--
  Created by IntelliJ IDEA.
  User: 付荣畅
  Date: 2021/12/23
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%List<registration> registrations=(List)request.getAttribute("registrations");%>
<%List<medicine> medicines=(List)request.getAttribute("medicines");%>
<%String[] autu=(String[])request.getAttribute("autu_medicines");%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>查找</title>
    <style type="text/css">
        #myInput {
            background-image: url(/img/sou.svg);
            /* 搜索按钮 */
            background-position: 10px 12px;
            /* 定位搜索按钮 */
            background-repeat: no-repeat;
            /* 不重复图片 */
            width: 100%;
            font-size: 16px;
            padding: 12px 20px 12px 40px;
            border: 1px solid #ddd;
            margin-bottom: 12px;
        }

        #myTable {
            border-collapse: collapse;
            width: 100%;
            border: 1px solid #ddd;
            font-size: 18px;
        }

        #myTable th,
        #myTable td {
            text-align: left;
            padding: 12px;
        }

        #myTable tr {
            /* 表格添加边框 */
            border-bottom: 1px solid #C3ECFF;
        }

        #myTable tr.header,
        #myTable tr:hover {
            /* 表头及鼠标移动过 tr 时添加背景 */
            background-color: #C3ECFF;
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
            <th>病情</th>
            <th>时间</th>
        </tr>
        <%
            for (registration r:registrations) {
        %>
        <tr>
            <td><%=r.getPname()%></td>
            <td><%=r.getMassage()%></td>
            <td><%=r.getTime()%></td>
        </tr>
        <%
            }
        %>
    </table>
    <form action="/doctor_prescription" method="post">
        <table>
            <tbody>
            <tr>
                <td>患者姓名:</td>
                <td><input type="text" name="pname"></input></td>
            </tr>
            <tr>
                <td>处方内容:</td>
                <td><input type="text" name="prescription"></input></td>
            </tr>
            <tr>
                <td></td>
                <td><button class="button" type="submit" value="确定">确认</button></td>
            </tr>
            </tbody>
        </table>
    </form>
    <button class="button" onclick="window.location.href='/autu'">自动生成药品</button>
    <br />
    <br />
    <h1 style="color: #0d9fe2;">药品信息</h1>
    <table class="tftable" style="width: 98%;">
        <tr>
            <th>编号</th>
            <th>药名</th>
            <th>介绍</th>
        </tr>
        <% for (medicine m:medicines) { %>
        <tr>
            <td>
                <%=m.getId()%>
            </td>
            <td>
                <%=m.getName()%>
            </td>
            <td>
                <%=m.getIntroduce()%>
            </td>
        </tr>
        <% } %>
    </table>
    <script>
        function myFunction() {
            // 声明变量
            var input, filter, table, tr, td, i;
            input = document.getElementById("myInput");
            filter = input.value.toUpperCase();
            table = document.getElementById("myTable");
            tr = table.getElementsByTagName("tr");

            // 循环表格每一行，查找匹配项
            for (i = 0; i < tr.length; i++) {
                td = tr[i].getElementsByTagName("td")[0];
                if (td) {
                    if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
                        tr[i].style.display = "";
                    } else {
                        tr[i].style.display = "none";
                    }
                }
            }
        }
    </script>
    <h1 style="margin-left: 3%;color:#912ea5;">快速检索</h1>
    <input type="text" id="myInput" onkeyup="myFunction()" placeholder="搜索...">
    <table id="myTable">
        <tr class="header">
            <th style="width:60%;">药物</th>
            <th style="width:40%;">介绍</th>
        </tr>
        <tr>
            <td>Abamectin</td>
            <td>抗寄生虫药</td>
        </tr>
        <tr>
            <td>Abciximab</td>
            <td>抗血栓药</td>
        </tr>
        <tr>
            <td>Azipramine</td>
            <td>抗抑郁药</td>
        </tr>
        <tr>
            <td>Azlocillin</td>
            <td>抗生素类药</td>
        </tr>
        <tr>
            <td>Omeprazole</td>
            <td>奥美拉唑 </td>
        </tr>
        <tr>
            <td>Sildenafil</td>
            <td>西地那非</td>
        </tr>
        <tr>
            <td> 罗红霉素</td>
            <td>消炎</td>
        </tr>
        <tr>
            <td> 布地奈德</td>
            <td>抗过敏</td>
        </tr>
        <tr>
            <td> Running Over</td>
            <td>JustinBieber</td>
        </tr>
        <tr>
            <td>Take It Out On Me</td>
            <td>JustinBieber</td>
        </tr>
        <tr>
            <td>Second Emotion</td>
            <td>JustinBieber</td>
        </tr>
        <tr>
            <td>Get Me</td>
            <td>JustinBieber</td>
        </tr>
        <tr>
            <td>E.T.A.</td>
            <td>JustinBieber</td>
        </tr>
        <tr>
            <td>Alfreds Futterkiste</td>
            <td>Germany</td>
        </tr>
        <tr>
            <td>Berglunds snabbkop</td>
            <td>Sweden</td>
        </tr>
        <tr>
            <td>Island Trading</td>
            <td>UK</td>
        </tr>
        <tr>
            <td>Koniglich Essen</td>
            <td>Germany</td>
        </tr>
    </table>
    <a href="patient.html">跳转到病人页</a>
</center>
</body>

</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/1/12
  Time: 8:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName()
            + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>普通用户</title>
</head>
<style>

    body{
        background-repeat: no-repeat;
        background-size:100%;
        background-position: 0px -50px;
    }

    *{
        margin: 0px;
        padding: 0px;
    }
    video{
        position: fixed;
        right: 0px;
        bottom: 0px;
        min-width: 100%;
        min-height: 100%;
        height: auto;
        width: auto;
        /*加滤镜*/
        /*filter: blur(15px); //背景模糊设置 */
        /*-webkit-filter: grayscale(100%);*/
        /*filter:grayscale(100%); //背景灰度设置*/
        z-index:-11
    }
    source{
        min-width: 100%;
        min-height: 100%;
        height: auto;
        width: auto;
    }


</style>
</head>
<body leftMargin=0 topMargin=0 marginwidth="0" marginheight="0">
<video id="v1" autoplay loop muted>
    <source src="${pageContext.request.contextPath}/images/vm2.mp4" type="video/mp4"  />
</video>


<div style="height: 20%">
    <h1>普通用户<b style="color: #a6e1ec">${customer_names}</b> 您好,你的账户余额:${customer_count},驾照分数为${customer_license}</h1>
</div>
<form action="/volation/user_list" method="post">
    车牌号:<input type="text" name="cno">    <input type="submit" value="提交"><b style="color: red">${msg}</b>

</form>
<table border="1" style="text-align: center;margin: auto;border-color: green" >
    <tr>
        <thead>
        <th>罚单号</th>
        <th>违章地址</th>
        <th>违章事件</th>
        <th>罚款金额</th>
        <th>违规日期</th>
        <th>扣除分数</th>
        <th>车编号</th>
        <th>处理情况</th>
        <th>执行操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${page1.rows}" var="row">
        <tr>
            <td>${row.vid}</td>
            <td>${row.vaddress}</td>
            <td>${row.vthing}</td>
            <td>${row.vmoney}</td>
            <td>${row.vtime.year+1898}年${row.vtime.month}月${row.vtime.day}日${row.vtime.hours}:${row.vtime.minutes}:${row.vtime.seconds}</td>
            <td>${row.vlicense}</td>
            <td>${row.cid}</td>
            <td>${row.vstare}</td>
            <td>
                <a href="/toUser_VIP" class="btn btn-primary btn-xs" data-toggle="modal" data-target="#customerEditDialog" >处理</a>
            </td>
        </tr>
        </c:forEach>

</table>
</body>
<script>

</script>


</html>
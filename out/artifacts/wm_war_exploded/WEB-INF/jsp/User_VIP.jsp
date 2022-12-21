<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/1/12
  Time: 8:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>交通人员管理</title>
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
    <source src="${pageContext.request.contextPath}/images/vm4.mp4" type="video/mp4"  />
</video>


<div id="login-box">

    <h1>尊敬的<b style="color: #a6e1ec">${customer_names}</b> 您好</h1>
    <form action="/car/carsign" method="post" style="text-align: center ">

        <div style="width: 40%" style="text-align:center;margin:0 auto">
            <h3 style="color: red;"> 车辆登记</h3>${carms}<br/>
        车品牌名<input type="text" name=cname ><br/>
        车辆型号<input type="text" name=cuser ><br/>
        车辆颜色<input type="text" name=ccolor><br/>
        车牌号&nbsp;&nbsp;&nbsp;<input type="text" name=cno><br/>
        人员姓名<input type="text" name=cust_name><br/>
        手机号码<input type="text" name="mobile"><br/>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="清除">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="提交"> </div>
    </form>
</div>
<form action="/violation/sign" method="post" style="text-align: center ">

    <div style="width: 40%" style="text-align:center;margin:0 auto">
        <h3 style="color: red;"> 违章登记</h3>${carms}<br/>
        ${vms}<br/>
        违章地址<input type="text" name=vaddress ><br/>
        违章事件<input type="text" name=vthing ><br/>
        车牌号&nbsp;&nbsp;&nbsp;<input type="text" name=cno><br/>
        处罚金额<input type="text" name=vmoney><br/>
        应扣分数<input type="text" name=vlicense><br/>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="清除">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="提交"> </div>
</form>




</body>
</html>

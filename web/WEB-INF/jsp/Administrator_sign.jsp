<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/1/12
  Time: 18:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员注册</title>
    <style>
        body{
            margin: 0;
            padding: 0;

            background-repeat: no-repeat;
            background-size:100%;
            background-position: 0px -50px;
        }
        .box{
            width: 300px;
            padding: 40px;
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%,-50%);
            background-color: #00000068;
            text-align: center;
        }

        .box input[type = "text"],.box input[type = "password"]{
            border: 0;
            background: none;
            display: block;
            margin: 20px auto;
            text-align: center;
            border: 2px solid #c8d6e5;
            padding: 14px 10px;
            outline: none;
            color: #ffffff;
            border-radius: 24px;
            transition: 0.25s;
        }
        h1{
            color: #FFFFFF;
            text-transform: uppercase;
            font-weight: 500;
        }

        .box input[type = "text"]:focus, .box input[type = "password"]:focus{
            width: 280px;
            border-color: #FFFFFF;
        }
        .box input[type = "submit"]{
            border: 0;
            font-size: 17px;
            background: none;
            display: block;
            margin: 20px auto;
            text-align: center;
            border: 2px solid #FFFFFF;
            padding: 14px 40px;
            outline: none;
            color: #ffffff;
            border-radius: 24px;
            transition: 0.25s;
            cursor: pointer;
        }
        .box input[type = "submit"]:hover {
            font-size: x-large;

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

        input[type = text]::placeholder{
            color: pink;
        }
        input[type = password]::placeholder{
            color: pink;
        }
    </style>
</head>
<body>
<video id="v1" autoplay loop muted>
    <source src="${pageContext.request.contextPath}/images/yinghuashu.mp4" type="video/mp4"  />
</video>
<form class="box" action="/Adminstrator_sign"method="post">
    <h1>管理员注册</h1>
    <b style="color: red">${sign_msg}</b>
    <input type="text"name="user_code" placeholder="管理员名" />
    <input type="password"name="user_password" placeholder="管理员密码" />
    <input type="text"name="user_name" placeholder="管理员真实姓名" />
    <input type="submit"  value="注册" />

</form>
</body>
</html>

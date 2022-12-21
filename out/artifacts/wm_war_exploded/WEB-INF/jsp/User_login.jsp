<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/1/11
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
    <meta http-equiv=Content-Type content="text/html; charset=utf-8">
    <link href="${pageContext.request.contextPath}/css/style.css"
          type=text/css rel=stylesheet>
    <link href="${pageContext.request.contextPath}/css/boot-crm.css"
          type=text/css rel=stylesheet>
    <script src=
                    "${pageContext.request.contextPath}/js/jquery-1.11.3.min.js">
    </script>
    <meta content="MSHTML 6.00.2600.0" name=GENERATOR>
    <script>
        // 判断是登录账号和密码是否为空
        function check(){
            var usercode = $("#usercode").val();
            var password = $("#password").val();
            if(usercode=="" || password=="" && type==""){
                $("#message").text("账号或密码不能为空！");
                return false;
            }
            return true;
        }


    </script>
    <style>
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
    <script>
    </script>
</head>
<body leftMargin=0 topMargin=0 marginwidth="0" marginheight="0">
<video id="v1" autoplay loop muted>
    <source src="${pageContext.request.contextPath}/images/vm3.mp4" type="video/mp4"  />
</video>
<div ALIGN="center">
    <table border="0" width="1140px" cellspacing="0" cellpadding="0"
           id="table1">
        <tr>
            <td height="93"></td>
            <td></td>
        </tr>
        <tr>
            <%--<td background="${pageContext.request.contextPath}/images/rights.jpg"--%>
            <%--width="240" height="256">--%>
            </td>
            <td width="430px"> <marquee direction="lift" ><b style="color: red;font-size: 32px">福州市第三交通委员会提醒您：道路千万条，安全第一条。行车不规范，亲人两行泪。</b>  </marquee></td>       <!--滚动提示字幕-->
            <td class="login_msg" width="400" align="center">
                <!-- margin:0px auto; 控制当前标签居中 -->
                <fieldset style="width: auto; margin: 0px auto;color: cyan">
                    <legend>
                        <font style="font-size:15px" face="宋体">
                            <b style="color: darkorchid">欢迎使用交通管理系统</b>
                        </font>
                    </legend>
                    <font color="red">
                        <%-- 提示信息--%>
                        <span id="message">${Use_message}</span>
                    </font>
                    <%-- 提交后的位置：/WEB-INF/jsp/customer.jsp--%>
                    <form action="${pageContext.request.contextPath }/Customer_login_OK"
                          method="post" onsubmit="return check()">
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br /><br />
                        姓&nbsp;名：<input id="cust_name" type="text" name="cust_name" placeholder="姓名"/>
                        <br /><br />
                        密&nbsp;码：<input id="cust_mobile" type="password" name="cust_mobile" placeholder="手机号"/>
                        <br/><br/>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <center><input type="button" value="用户注册" onclick="window.location='/login_null'"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  <input type="submit" value="登录" /></center>
                    </form>
                </fieldset>
            </td>
        </tr>
    </table>
</div>

</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/1/12
  Time: 11:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>罚单处理</title>
</head>
<style>

    body{
        background-repeat: no-repeat;
        background-size:100%;
        background-position: 0px -50px;
    }
    #login-box{
        background-color: #00000068;
        border-radius: 13px;
        text-align: center;
        margin: 0px auto;
        margin-top: 80px;
        width: 350px;
        height: 460px;
    }

    #login-box h1{
        padding-top: 60px;
        color: #ffffff;
    }

    #login-box .input-box{
        margin-top: 30px;
    }
    #login-box .input-box input{
        border: none;
        background: none;
        border-bottom: #FFFFFF 2px solid;
        padding: 5px 10px;
        outline: none;
        color: #FFFFFF;
    }

    #login-box button{
        line-height:30px;
        margin-top: 30px;
        width: 130px;
        height: 30px;
        border-radius:13px ;
        outline: none;
        border: none;
        background-image: linear-gradient(120deg, #a6c0fe 0%, #f68084 100%);
        color: #FFFFFF;
    }

    #login-box button:hover{
        background-image: linear-gradient(to top, #30cfd0 0%, #330867 100%);
    }
    #login-box .input-box i{
        color: #FFFFFF;
    }


    @font-face {font-family: "iconfont";
    url('data:application/x-font-woff2;charset=utf-8;base64,d09GMgABAAAAAAO8AAsAAAAAB6wAAANvAAEAAAAAAAAAAAAAAAAAAAAAAAAAAAAAHEIGVgCDBgqDFIJ/ATYCJAMMCwgABCAFhG0HNxvGBsiemjxBRAhmg9koBWDBEY/gaezbvN09E2tu9cATkUQo4k2s0cgQGo1MJGn3Ev6hzjw/EOq5GNxK4DwA+R3JcUiuIpdxLk/9seUZAA1Tfy7h3JxCAM/H3P+Lw2nTw3A+UE5zbIy6AOOAAhp7URpggSToDWM3ETTE1QTqDVtEOBbb+yFFAToF4paqSJCSUSgN6aFWqK4YWcQbSFSbnsa9APCafz/+gydSSKoy0PP85no/rPqV+Cs1P/q/2zhFAHM6HYxxZCwChbhRabguPgosilfvCRKa46sVIU3lrgxn+Lxq+IdHEkQ1kNoIZpVg4lciZiTCVJl11StlUI0aPAE+ApLOoT2rlnJzctIzmu5a1mCRbQ+y/H7D6N9tdhQY+hzHG9LfFtv2ytf2MbPjpjlwvDCba5Gj1jtrj/2+5AVvzd3GG2PbsZt9cbtv1Gc9u9Uff/Z2A816YKC4c+b67Md2XfysRY49fXsNoDG+2kNjeiEzHlvg7cSko+dDeHzh+Qfw6P36nWnUoesdCHq2PTeaJhaMXxr258lFW08COVuxcRA6RnV91UmhL34gfr2WLBx6N81l3/Me3eat/uHZJKxO1ipqXLzQM0+s2FwhdiH8JrGyW7Ap2XWzWAGuL8+qT2ePV12vqq2+kDmefRrVtNb+Ims8i+B+1o6rGq+6UVde3SfhXZ08JgstktTSpgrHjoV6+edlT8PIenGkPicrZ13OcSxAtD5MA1TKl+MHeEiejd/w437j88f37qnsZf9qKODnt8xfsq2iQLdkUCvRmfmbmB2Lis8GylxcBmaE4exY4kugyTRT6OdkQru54aYukOhCrcmUIakxBFmtSWTBLkKVBstQrdYe1FvgG9+gAxMvSh3mHZAgtLoCSbNPkLV6iSzYD1Cl2zeo1hrxUO9q5M/YYDrUtLUMSxz70cwWpMo0SpCap4n0XqzoYYml2ZwwiFlMdSO3w5UP+3AUsyn6xDYqHs4JIoxGkCith8NhijRGg1jmjgDn2hKnk1Q9ySHTCKQ5wmASDvNDZmyBqGRUFKHlubTC53thCl2YhDUU9KgHYUyMWj3i5uDqgPQJop0KbuWcmI0UHhxHIARDRSCipMPCMEAhWnWzIEzGOQQG+DRLOJVSpKvAsbwo8n4roB5YMEeKHEX1bRpVAnpCRI1IAAA=') format('woff2'),
    }

    .iconfont {
        font-family: "iconfont" !important;
        font-size: 16px;
        font-style: normal;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
    }

    .icon-yonghu:before {
        content: "\e609";
    }

    .icon-mima:before {
        content: "\e605";
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
    <source src="${pageContext.request.contextPath}/images/star.mp4" type="video/mp4"  />
</video>
<div id="login-box">
    <h1>普通用户<b style="color: #a6e1ec">${customer_names}</b> 您好</h1>
    <div class="input-box">
        <b style="color: red">${ms}</b>
        <div class="input-box" >
            <img src="${pageContext.request.contextPath}/images/zhifu1.jpg"/>
            <marquee direction="lift" ><b style="color: red;">输入罚单号进行处理</b>  </marquee>
        </div>
        <form action="/violation/Vbill" method="post" style="align-items: center">
            罚单号:<input type="text" name="vid">
            <input type="submit" value="处理罚单">
        </form>


        <a href="/violation/createcount"><button>账户充值￥100</button></a>
    </div>
</div>

</body>
</html>

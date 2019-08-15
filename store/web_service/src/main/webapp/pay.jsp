<%--
  Created by IntelliJ IDEA.
  User: Leebx
  Date: 2019/8/13
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
    <title>乐优商城--微信支付页</title>
    <link rel="icon" href="${pageContext.request.contextPath}/assets/img/favicon.ico">


    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/webbase.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/pages-weixinpay.css" />
</head>

<body>

<!--页面顶部白条条，由js动态加载-->
<script type="text/javascript" src="${pageContext.request.contextPath}/plugins/jquery/jquery.min.js"></script>
<div class="top"></div>
<script type="text/javascript">$(".top").load("shortcut.html");</script>

<div class="cart py-container">
    <!--logoArea-->
    <div class="logoArea">
        <div class="fl logo"><span class="title">收银台</span></div>
    </div>
    <!--主内容-->
    <div class="checkout py-container  pay">
        <div class="checkout-tit">
            <h4 class="fl tit-txt"><span class="success-icon"></span><span  class="success-info" id="orderId">订单提交成功，请您及时付款！订单号：${order.orderId}</span></h4>
            <span class="fr"><em class="sui-lead">应付金额：</em><em  class="orange money">￥${order.totalPay}</em>元</span>
            <div class="clearfix"></div>
        </div>
        <div class="checkout-steps">
            <div class="fl weixin">微信支付</div>
            <div class="fl sao">
                <%--<p class="red">二维码已过期，刷新页面重新获取二维码。</p>--%>
                <div class="fl code">
                    <input id="text" type="hidden" value="${code_url}"/>
                    <div id="qrcode" style="width:300px; height:300px; margin-top:15px;"></div>
                    <div class="saosao">
                        <p>请使用微信扫一扫</p>
                        <p>扫描二维码支付</p>
                    </div>
                </div>
                <div class="fl phone">

                </div>

            </div>
            <div class="clearfix"></div>
            <p><a href="#" target="_blank">> 其他支付方式</a></p>
        </div>
    </div>

</div>


<!-- 底部栏位 -->
<!--页面底部，由js动态加载-->
<div class="clearfix footer"></div>
<script type="text/javascript">$(".footer").load("foot.html");</script>
<!--页面底部END-->


<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/jquery/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/jquery/qrcode.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/jquery.easing/jquery.easing.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/sui/sui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/widget/nav.js"></script>
<script type="text/javascript">
    var t=self.setInterval("clock()",2000);
    function clock(){
        var orderid=${order.orderId}
        $.get("${pageContext.request.contextPath}/order-web/paySuccess",{"oid":orderid},function (rs) {
            if(rs.trim()=="1".trim()){
                int=window.clearInterval(t);//关闭定时器
                window.location.href="${pageContext.request.contextPath}/paysuccess.html";
            }
        });
    }

    $(function(){
        $("ul.payType li").click(function(){
            $(this).css("border","2px solid #E4393C").siblings().css("border-color","#ddd");
        })
    })
    var qrcode = new QRCode(document.getElementById("qrcode"), {
        width : 300,
        height : 300
    });

    function makeCode () {
        var elText = document.getElementById("text");

        if (!elText.value) {
            alert("Input a text");
            elText.focus();
            return;
        }

        qrcode.makeCode(elText.value);
    }

    makeCode();

    $("#text").
    on("blur", function () {
        makeCode();
    }).
    on("keydown", function (e) {
        if (e.keyCode == 13) {
            makeCode();
        }
    });

</script>
</body>

</html>
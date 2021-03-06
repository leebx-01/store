<%--
  Created by IntelliJ IDEA.
  User: Leebx
  Date: 2019/8/9
  Time: 11:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <title>乐优商城--购物车页面</title>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/webbase.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/pages-cart.css"/>
</head>

<body>

<div id="cartApp">

    <div class="top">
        <shortcut/>
    </div>

    <div class="cart py-container">

        <!--logoArea-->
        <div class="logoArea">
            <div class="fl logo"><span class="title">购物车</span></div>
        </div>

        <!--All goods-->
        <div class="allgoods">
            <h4>全部商品<span>11</span></h4>
            <div class="cart-main">
                <div class="yui3-g cart-th">
                    <div class="yui3-u-1-4"><input type="checkbox"/> 全部</div>
                    <div class="yui3-u-1-4">商品</div>
                    <div class="yui3-u-1-8">单价（元）</div>
                    <div class="yui3-u-1-8">数量</div>
                    <div class="yui3-u-1-8">小计（元）</div>
                    <div class="yui3-u-1-8">操作</div>
                </div>

                <div class="cart-item-list">

                    <div class="cart-body">
                        <div class="cart-list">
                            <c:forEach var="l" items="${list}" varStatus="vs">
                            <ul class="goods-list yui3-g">
                                <li class="yui3-u-1-24">
                                    <input type="checkbox" name="cb" value="${l.id}" />
                                </li>
                                <li class="yui3-u-11-24">
                                    <div class="good-item">
                                        <div class="item-img"><img src="${pageContext.request.contextPath}/img/goods.png" width="80px" height="80px"/></div>
                                        <div class="item-msg">
												<span style="line-height:70px ">
													    ${l.title}<br>
														${l.own_spec}
												</span>
                                        </div>
                                    </div>
                                </li>

                                <li class="yui3-u-1-8"><span style="line-height:70px " class="price">${l.price}</span></li>
                                <li class="yui3-u-1-8" style="padding-top: 20px">
                                    <a href="javascript:changeNum(-1,${vs.index},${l.price},${l.id})" id="jian${vs.index}" class="increment mins">-</a>
                                    <input id="num${vs.index}" autocomplete="off" type="text" value="${l.num}" minnum="1" class="itxt" />
                                    <a href="javascript:changeNum(1,${vs.index},${l.price},${l.id})" id="jia${vs.index}" class="increment plus">+</a>
                                </li>
                                <li class="yui3-u-1-8"><span style="line-height:70px " class="sum" name="xj" id="xj${vs.index}">${l.total}</span></li>
                                <li class="yui3-u-1-8">
                                    <a href="/cart/del?userId=${user.id}&skuId=${l.id}">删除</a><br />
                                    <a href="#none">移到我的关注</a>
                                </li>
                            </ul>
                            </c:forEach>
                        </div>
                    </div>
                </div>

            </div>

            <div class="cart-tool">
                <div class="select-all">
                    <input type="checkbox" name="" id="" value=""/>
                    <span>全选</span>
                </div>
                <div class="option">
                    <a href="#none">删除选中的商品</a>
                    <a href="#none">移到我的关注</a>
                    <a href="#none">清除下柜商品</a>
                </div>
                <div class="toolbar">
                    <div class="chosed">已选择<span>0</span>件商品</div>
                    <div class="sumprice">
                        <span ><em>总价（不含运费） ：</em><i class="summoney"><span id="total">${sum}</span></i></span>
                        <span><em>已节省：</em><i>-¥20.00</i></span>
                    </div>
                    <div class="sumbtn">
                        <a class="sum-btn" href="javascript:show()" target="_blank">结算</a>
                    </div>
                </div>
            </div>
            <div class="clearfix"></div>
            <div class="deled">
                <span>已删除商品，您可以重新购买或加关注：</span>
                <div class="cart-list del">
                    <ul class="goods-list yui3-g">
                        <li class="yui3-u-1-2">
                            <div class="good-item">
                                <div class="item-msg">Apple Macbook Air 13.3英寸笔记本电脑 银色（Corei5）处理器/8GB内存</div>
                            </div>
                        </li>
                        <li class="yui3-u-1-6"><span class="price">8848.00</span></li>
                        <li class="yui3-u-1-6">
                            <span class="number">1</span>
                        </li>
                        <li class="yui3-u-1-8">
                            <a href="#none">重新购买</a>
                            <a href="#none">移到我的关注</a>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="liked">
                <ul class="sui-nav nav-tabs">
                    <li class="active">
                        <a href="#index" data-toggle="tab">猜你喜欢</a>
                    </li>
                    <li>
                        <a href="#profile" data-toggle="tab">特惠换购</a>
                    </li>
                </ul>
                <div class="clearfix"></div>
                <div class="tab-content">
                    <div id="index" class="tab-pane active">
                        <div id="myCarousel" data-ride="carousel" data-interval="4000" class="sui-carousel slide">
                            <div class="carousel-inner">
                                <div class="active item">
                                    <ul>
                                        <li>
                                            <img src="${pageContext.request.contextPath}/img/like1.png"/>
                                            <div class="intro">
                                                <i>Apple苹果iPhone 6s (A1699)</i>
                                            </div>
                                            <div class="money">
                                                <span>$29.00</span>
                                            </div>
                                            <div class="incar">
                                                <a href="#" class="sui-btn btn-bordered btn-xlarge btn-default"><i
                                                        class="car"></i><span class="cartxt">加入购物车</span></a>
                                            </div>
                                        </li>
                                        <li>
                                            <img src="${pageContext.request.contextPath}/img/like2.png"/>
                                            <div class="intro">
                                                <i>Apple苹果iPhone 6s (A1699)</i>
                                            </div>
                                            <div class="money">
                                                <span>$29.00</span>
                                            </div>
                                            <div class="incar">
                                                <a href="#" class="sui-btn btn-bordered btn-xlarge btn-default"><i
                                                        class="car"></i><span class="cartxt">加入购物车</span></a>
                                            </div>
                                        </li>
                                        <li>
                                            <img src="${pageContext.request.contextPath}/img/like3.png"/>
                                            <div class="intro">
                                                <i>Apple苹果iPhone 6s (A1699)</i>
                                            </div>
                                            <div class="money">
                                                <span>$29.00</span>
                                            </div>
                                            <div class="incar">
                                                <a href="#" class="sui-btn btn-bordered btn-xlarge btn-default"><i
                                                        class="car"></i><span class="cartxt">加入购物车</span></a>
                                            </div>
                                        </li>
                                        <li>
                                            <img src="${pageContext.request.contextPath}/img/like4.png"/>
                                            <div class="intro">
                                                <i>Apple苹果iPhone 6s (A1699)</i>
                                            </div>
                                            <div class="money">
                                                <span>$29.00</span>
                                            </div>
                                            <div class="incar">
                                                <a href="#" class="sui-btn btn-bordered btn-xlarge btn-default"><i
                                                        class="car"></i><span class="cartxt">加入购物车</span></a>
                                            </div>
                                        </li>
                                    </ul>
                                </div>
                                <div class="item">
                                    <ul>
                                        <li>
                                            <img src="${pageContext.request.contextPath}/img/like1.png"/>
                                            <div class="intro">
                                                <i>Apple苹果iPhone 6s (A1699)</i>
                                            </div>
                                            <div class="money">
                                                <span>$29.00</span>
                                            </div>
                                            <div class="incar">
                                                <a href="#" class="sui-btn btn-bordered btn-xlarge btn-default"><i
                                                        class="car"></i><span class="cartxt">加入购物车</span></a>
                                            </div>
                                        </li>
                                        <li>
                                            <img src="${pageContext.request.contextPath}/img/like2.png"/>
                                            <div class="intro">
                                                <i>Apple苹果iPhone 6s (A1699)</i>
                                            </div>
                                            <div class="money">
                                                <span>$29.00</span>
                                            </div>
                                            <div class="incar">
                                                <a href="#" class="sui-btn btn-bordered btn-xlarge btn-default"><i
                                                        class="car"></i><span class="cartxt">加入购物车</span></a>
                                            </div>
                                        </li>
                                        <li>
                                            <img src="${pageContext.request.contextPath}/img/like3.png"/>
                                            <div class="intro">
                                                <i>Apple苹果iPhone 6s (A1699)</i>
                                            </div>
                                            <div class="money">
                                                <span>$29.00</span>
                                            </div>
                                            <div class="incar">
                                                <a href="#" class="sui-btn btn-bordered btn-xlarge btn-default"><i
                                                        class="car"></i><span class="cartxt">加入购物车</span></a>
                                            </div>
                                        </li>
                                        <li>
                                            <img src="${pageContext.request.contextPath}/img/like4.png"/>
                                            <div class="intro">
                                                <i>Apple苹果iPhone 6s (A1699)</i>
                                            </div>
                                            <div class="money">
                                                <span>$29.00</span>
                                            </div>
                                            <div class="incar">
                                                <a href="#" class="sui-btn btn-bordered btn-xlarge btn-default"><i
                                                        class="car"></i><span class="cartxt">加入购物车</span></a>
                                            </div>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                            <a href="#myCarousel" data-slide="prev" class="carousel-control left">‹</a>
                            <a href="#myCarousel" data-slide="next" class="carousel-control right">›</a>
                        </div>
                    </div>
                    <div id="profile" class="tab-pane">
                        <p>特惠选购</p>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>
<script src="${pageContext.request.contextPath}/js/vue/vue.js"></script>
<script src="${pageContext.request.contextPath}/js/axios.min.js"></script>
<script src="${pageContext.request.contextPath}/js/common.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-1.11.1.js"></script>
<script type="text/javascript">
    var cartVm = new Vue({
        el: "#cartApp",
        data: {
        },
        components: {
            shortcut: () => import("${pageContext.request.contextPath}/js/pages/shortcut.js")
    }
    })
    function changeNum(a,index,price,skuId){
        var num=parseInt(document.getElementById("num"+index).value)+a;
        document.getElementById("num"+index).value=num;
        document.getElementById("xj"+index).innerText=num*price;
        var total=0;
        var array=document.getElementsByName("xj");
        for(var i=0;i<array.length;i++){
            total+=parseInt(array[i].innerText);
        }
        document.getElementById("total").innerText=total;
        $.get("${pageContext.request.contextPath}/cart/update",{"userId":${user.id},"num":num,"skuId":skuId});
    }
    function show(){
        obj = document.getElementsByName("cb");
        check_val = [];
        for(k in obj){
            if(obj[k].checked)
                check_val.push(obj[k].value);
        }
        location.href="${pageContext.request.contextPath}/order-web/showOrder?skuId="+check_val+"&userId=${user.id}";
    }
</script>
<!-- 底部栏位 -->
<!--页面底部，由js动态加载-->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/jquery/jquery.min.js"></script>
<div class="clearfix footer"></div>
<script type="text/javascript">$(".footer").load("foot.html");</script>
<!--页面底部END-->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/jquery.easing/jquery.easing.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/sui/sui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/widget/nav.js"></script>

</body>

</html>
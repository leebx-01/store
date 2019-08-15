<%--
  Created by IntelliJ IDEA.
  User: Leebx
  Date: 2019/8/8
  Time: 9:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <title>乐优商城--注册页面</title>


    <link rel="stylesheet" type="text/css" href="css/webbase.css"/>
    <link rel="stylesheet" type="text/css" href="css/pages-register.css"/>
    <style type="text/css">
        .code-span {
            display: inline-block;
            border: 1px solid #999;
            text-align: center;
            line-height: 35px;
            width: 118px;
            height: 35px;
            float: right;
            margin-left: 10px
        }
        .code-span:hover{
            background-color: #c0ccda;
        }
    </style>
</head>

<body>
<div class="register py-container ">
    <!--head-->
    <div class="logoArea">
        <a href="" class="logo"></a>
    </div>
    <!--register-->
    <div class="registerArea" id="registerApp">
        <h3>注册新用户<span class="go">我有账号，去<a href="login.html" target="_blank">登陆</a></span></h3>
        <div class="info" style="width: 650px">
            <form class="sui-form form-horizontal" action="/user-web/regist" method="post">
                <div class="control-group">
                    <label class="control-label">用户名：</label>
                    <div class="controls">
                        <input type="text" placeholder="请输入你的用户名" class="input-xfat input-xlarge"
                               v-model.lazy="user.username" name="username" data-vv-as="用户名"
                               v-validate="'required|alpha_dash|min:4|max:30|useful:1'">
                    </div>
                    <span style="color: red;">{{ errors.first('username') }}</span>
                </div>
                <div class="control-group">
                    <label class="control-label">登录密码：</label>
                    <div class="controls">
                        <input type="password" placeholder="设置登录密码" class="input-xfat input-xlarge"
                               v-model="user.password" name="password" data-vv-as="密码"
                               v-validate="'required|alpha_dash|min:4|max:30'">
                    </div>
                    <span style="color: red;">{{ errors.first('password') }}</span>
                </div>
                <div class="control-group">
                    <label class="control-label">确认密码：</label>
                    <div class="controls">
                        <input type="password" placeholder="再次确认密码" class="input-xfat input-xlarge"
                               v-model="user.confirmPassword" name="confirmPass" data-vv-as="确认密码"
                               v-validate="{required:true,confirm:user.password}">
                    </div>
                    <span style="color: red;">{{ errors.first('confirmPass') }}</span>
                </div>

                <div class="control-group">
                    <label class="control-label">手机号：</label>
                    <div class="controls">
                        <input type="text" placeholder="请输入你的手机号" class="input-xfat input-xlarge"
                               v-model="user.phone" name="phone" data-vv-as="手机号"
                               v-validate="{required:true,regex:/^1[35678]\d{9}$/,useful:2}">
                    </div>
                    <span style="color: red;">{{ errors.first('phone') }}</span>
                </div>
                <div class="control-group">
                    <label class="control-label">电子邮箱：</label>
                    <div class="controls">
                        <input type="text" placeholder="请输入你的电子邮箱" class="input-xfat input-xlarge"
                               v-model="user.emily" name="emily" data-vv-as="电子邮箱"
                               v-validate="{required:true,regex:/^1[35678]\d{9}$/,useful:2}">
                    </div>
                    <span style="color: red;">{{ errors.first('phone') }}</span>
                </div>
                <div class="control-group">
                    <label class="control-label">短信验证码：</label>
                    <div class="controls">
                        <input type="text" placeholder="短信验证码" class="input-xfat input-xlarge" style="width: 120px;"
                               v-model="user.code" name="code" v-validate="'required'" data-vv-as="验证码">
                        <span class="code-span" @click="createVerifyCode">
                               获取短信验证码
                        </span>
                    </div>
                    <span style="color: red;">{{ errors.first('code') }}</span>
                </div>

                <div class="control-group">
                    <label class="control-label">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                    <div class="controls">
                        <input name="m1" type="checkbox" value="2" checked=""><span>同意协议并注册《乐优用户协议》</span>
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label"></label>
                    <div class="controls btn-reg">
                        <input type="submit" class="sui-btn btn-block btn-xlarge btn-danger" target="_blank" value="完成注册">
                    </div>
                </div>
            </form>
            <div class="clearfix"></div>
        </div>
    </div>

    <script type="text/javascript" src="js/plugins/jquery/jquery.min.js"></script>
    <!-- 底部栏位 -->
    <!--页面底部版权信息，由js动态加载-->
    <div class="Mod-copyright"></div>
    <script type="text/javascript">$(".Mod-copyright").load("copyright.html");</script>
    <!--页面底部END-->

</div>


<script type="text/javascript" src="js/plugins/jquery/jquery.min.js"></script>
<script type="text/javascript" src="js/plugins/jquery.easing/jquery.easing.min.js"></script>
<script type="text/javascript" src="js/plugins/sui/sui.min.js"></script>
<script type="text/javascript" src="js/plugins/jquery-placeholder/jquery.placeholder.min.js"></script>
<script type="text/javascript" src="js/pages/register.js"></script>
<script src="./js/vue/vue.js"></script>
<script src="./js/axios.min.js"></script>
<script src="./js/common.js"></script>
<script src="./js/validate.js"></script>
<script type="text/javascript">
    Vue.use(VeeValidate, {
        events: 'blur',
        dictionary: {
            zh: {
                messages: {
                    required: (field) => field + '不能为空！',
                min: (field, args) => field + '长度不能小于' + args[0],
            max: (field, args) => field + '长度不能大于' + args[0],
        alpha_dash: (field) => field + '只能包含数字、字母或下划线',
        regex: (field) => field + "格式不正确",
        is: () => "两次密码不一致"
    }
    }
    },
    locale: 'zh'
    });
    var registerVm = new Vue({
        el: "#registerApp",
        data: {
            user: {
                username: '',
                password: '',
                confirmPassword: '',
                phone: '',
                code: ''
            },
            check: {
                username: false
            }
        },
        created() {
            this.$validator.extend('useful', {
                getMessage(field, args, data) {
                    return args[0] === '1' ? '用户名' + data : '手机' + data;
                },
                validate(value, args) {
                    return new Promise(resolve => {
                        leyou.http.get("/user/check/" + value + "/" + args[0])
                            .then(resp => {
                            resolve({
                                        valid: resp.data,
                                        data: "已存在!"
                                    })
                        })
                });
                }
            })
            this.$validator.extend('confirm', {
                getMessage() {
                    return "两次密码不一致"
                },
                validate(val, args) {
                    return val === args[0]
                }
            })
        },
        methods: {
            createVerifyCode() {// 生成短信验证码
                this.$validator.validate("phone").then(r => {
                    if (r) {
                        leyou.http.post("/user/send", "phone=" + this.user.phone);
                    }
                });

            },
            submit() {
                this.$validator.validateAll().then(d => {
                    if (d) {
                        // 校验通过，提交表单
                        leyou.http.post("/user/register", leyou.stringify(this.user))
                            .then(resp => {
                            if (resp.status === 201) {
                            // 注册成功
                            alert("注册成功,即将跳转到登录页！");
                            setTimeout(() => window.location = '/login.html', 2000);
                        }
                    })
                    .catch(() => alert("注册失败！"))
                    }
                })
            }
        }
    });
</script>
</body>

</html>
//layui模块的定义
layui.define(['layer','form'],function (exports) {
    var $ = layui.jquery,form = layui.form;

    //表单验证
    form.verify({
        length:function (value) {
            if (value.length<6 || value.length>20){
                return "字符长度在6~20位之间";
            }
        },
        password:function (value) {
            if (!new RegExp(/^[a-zA-Z0-9_\u4e00-\u9fa5\\s.]+$/).test(value)){
                return "不能包含特殊字符";
            }
        },
        eqPwd: function (value) {
            //获取密码
            var pwd = $("#password").val();
            if (pwd != value) {
                return '两次输入的密码不一致';
            }
        },
    });



    exports('xform',{});
})
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
        }
    });


    //表单提交
    form.on('submit(submit)',function (data) {
        var values = data.field, fm = data.form;
        //获取checkbox选中的值
        /*var $ch = $("input:checkbox:checked");
        var name = {};
        var chvs = [];
        if ($ch && $ch[0] && !$ch.attr('lay-skin')) {
            name = $ch[0].name;
            $ch.each(function () {
                chvs.push($(this).val());
            });
            values[name] = chvs;
        }*/
        $.post($(fm).attr('action'), values, function (result) {
            if (result.success) {

                layer.msg(
                    result.message,
                    {
                        icon:1,
                        time: 2000
                    },
                    function () {
                        // 获得当前frame索引,并关闭
                        // layer.close(layer.index);
                        parent.window.location.reload();
                    }
                );

                /*if($(fm).attr("data-id") == 'reload'){
                    parent.window.location.reload();
                }*/

                /*// 刷新父table
                if (parent.layui.table){
                    parent.layui.table.reload('table');
                }*/
            } else {
                layer.msg(
                    result.message,
                    {
                        time:2000,
                        icon:2
                    }
                );
            }

        });
        return false;
    });

    exports('xform',{});
});
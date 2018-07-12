//绑定导航点击事件
$("body").on("click",".layui-nav .layui-nav-item a",function () {
    //一级菜单
    if ($(this).siblings().length==0){
        var url = $(this).attr("data-url");
        loadHtml(url);
    }
    $(this).parent("li").siblings().removeClass("layui-nav-itemed");
});

/**
 * 根据url地址加载html页面
 * @param url 功能界面地址
 */
function loadHtml(url) {
    var $content = $('#main-content');
    $.ajax({
       url:url,
       type:'GET',
       dataType:'html',
       success:function (html) {
           $content.fadeOut(500, function () {
               $content.empty();
               $content.append(html);
               $content.fadeIn(1500);
           });
       },
       error:function () {
          alert("打开错误");
       }
    });
}
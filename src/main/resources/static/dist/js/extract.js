$(function(){
    loadMyHomepageurls();

    //鼠标移动事件
    $(".hover").hover(function(){
        $(".hoverinfo").stop().animate({
            opacity: "show"
        },"slow");
        $(this).find(".fa-plus").css("color","#e64620");
    },function(){
        $(".hoverinfo").stop().animate({
            opacity: "hide"
        },"slow");
        $(this).find(".fa-plus").css("color","#000");
    });
});

function loadMyHomepageurls(){
    var url = "/getWebsiteUrl";
    $.ajax({
        url : url,
        type : 'post',
        dataType : 'json',
        data : {

        },
        success:function(data){
            var str = "";
            for(var i = 0 ;i<data.length;i++){
                if( i == 0){
                    str += "<li class=\"active\">";
                    str += "<a href = "+data[i].url+" >";
                    str +=  data[i].urlTitle;
                    str += "</a></li>";
                }else{
                    str += "<li>";
                    str += "<a href = "+data[i].url+">";
                    str +=  data[i].urlTitle;
                    str += "</a></li>";
                }
            }
            $(".home-list").html(str);
        }
    });
}
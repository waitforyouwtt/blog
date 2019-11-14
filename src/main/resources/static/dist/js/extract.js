$(function(){
    //我的主页
    loadMyHomepageurls();

    //首页top left url
    homePageTopUrlLeft();

    //首页头部url right 链接
    homePageTopUrlRight();

   //鼠标悬浮事件
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
   })

});

//我的主页
function loadMyHomepageurls(){
    var url = "/my-homepage";
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

//首页头部url left 链接
function homePageTopUrlLeft(){
    var url = "/homePageTopUrlLeft";
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
            $("#home-page-top-url-left").html(str);
        }
    });
}

//首页头部url right 链接
function homePageTopUrlRight(){
    var url = "/homePageTopUrlRight";
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
                    str += "<li class=\"fa fa-share-alt\" aria-hidden=\"true\">";
                    str += "<a href = "+data[i].url+" target=\"_blank\">";
                    str +=  data[i].urlTitle;
                    str += "</a></li>";
                }else if(i == 1){
                    str += "<li class=\"fa fa-question-circle\" aria-hidden=\"true\">";
                    str += "<a href = "+data[i].url+" target=\"_blank\">";
                    str +=  data[i].urlTitle;
                    str += "</a></li>";
                }else if(i == 2){
                    str += "<li class=\"fa fa-comments\" aria-hidden=\"true\">";
                    str += "<a href = "+data[i].url+" target=\"_blank\">";
                    str +=  data[i].urlTitle;
                    str += "</a></li>";
                }else{
                    str += "<li class=\"fa fa-heartbeat\" aria-hidden=\"true\">";
                    str += "<a href = "+data[i].url+" target=\"_blank\">";
                    str +=  data[i].urlTitle;
                    str += "</a></li>";
                }
            }
            $("#home-page-top-url-right").html(str);
        }
    });
}
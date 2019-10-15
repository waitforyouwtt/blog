$(function(){
    loadMyHomepageurls();
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
$(function() {

    $("#movieButton").bind( "click", function() {
        if($("#movieButtonForm").val().length<1){
            $("#movieButtonForm").css("borderColor", "red");
        }else{
            window.location="/movie/"+$("#movieButtonForm").val();
            $("#movieButtonForm").css("borderColor", "black");
        }
        console.log($("#movieButtonForm").val());
    });

});
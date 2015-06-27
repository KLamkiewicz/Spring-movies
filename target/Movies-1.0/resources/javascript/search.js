$(function() {

    console.log("works");
    $.ajax({
        url: "/searchie",
        data: {"genres" : ["alla","rrr"]},
        type: "POST",
        success: function(data){
            console.log(data);
        }
    });
});
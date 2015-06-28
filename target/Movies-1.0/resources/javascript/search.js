var x;
$(function() {

    console.log("works");
    $.ajax({
        url: "/searchie",
        data: {"genres" : ["Action","Adventure"], "rating":7.5},
        type: "POST",
        success: function(data){
            x = data;
            console.log(data);
        }
    });
});
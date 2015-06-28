
console.log(movies);

$(function() {
    $("#showInfo").show().delay(5000).fadeOut();

    var populateMovies = function(value, title){
            $.ajax({
                url: "//www.omdbapi.com/?t="+title,
                dataType: "jsonp",
                success: function( data ) {
                    if(data.hasOwnProperty('Error')){
                        addToTable(value, title, "No movie plot found");
                    }else{
                        addToTable(value, title, data.Plot);
                    }
                }
            });
    }

    var addToTable = function(value, title, plot){
        $("#movieTable").
            append("<tr><th>"+ title +"<\/th>" + "<th>"+ value.rating +"<\/th>" + "<th>"+ plot +"<\/th>"

                +"<\/tr>");
    }

    $.each(movies, function(key, value){
        populateMovies(value, value.title);
    });
})


$(function() {

    console.log(movie);

    var displayMovie = function(){
        $.ajax({
            url: "//www.omdbapi.com/?t="+movie.title,
            dataType: "jsonp",
            success: function( data ) {

                $("#movieJumb :nth-child(1)").append(movie.title);
                $("#movieJumb :nth-child(2)").append("Genres: ");
                $.each(movie.genres, function (key, value) {
                    $("#movieJumb :nth-child(2)").append(value + ", ");
                })
                $("#movieJumb :nth-child(3)").append("Rating: " + movie.average);
                if (data.hasOwnProperty('Error')) {
                    $("#movieJumb :nth-child(4)").append("No movie plot found");
                } else {
                    $("#movieJumb :nth-child(4)").append(data.Plot);
                }
            }
        });
    }
    if($.isEmptyObject(movie)){
        $("#movieJumb :nth-child(1)").append("Movie not found");
    }else {
        displayMovie();
    }

});
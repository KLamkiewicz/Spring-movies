var x;
$(function() {

    var genresToSend = [];
    var ratingToSend;

    $.each(genres.genres, function(key, value){
        $("#movieGenresRadio").append(" <label> <input type=\"checkbox\" value=" + value+ " option1\" >"+ value +" <\/label><br/>");
    });

    $("#findMoviesButton").bind( "click", function() {
        searchForMovies();
    });

    var searchForMovies = function(){
        var send = false;
        if($("#movieRating").val().length<1){
            $("#movieButtonForm").css("borderColor", "red");
        }else if($("#movieRating").val().length>0){
            $("#movieButtonForm").css("borderColor", "black");
            ratingToSend = $("#movieRating").val();
            send = true;
        }
        genresToSend = [];
        if($('input[type=checkbox]:checked').length>0 && send) {
            $.each($('input[type=checkbox]:checked'), function () {
                genresToSend.push($(this).val());
            });
            console.log("Sending ");
            console.log(genresToSend);
            console.log(ratingToSend);
            getMovies();
        }

    }

    var showMovies = function(data){
        $("#foundMovies").empty();
        $("#foundMovies").append("Found movies: ");
        $.each(data, function(key, value){
            $("#foundMovies").append(value.title + ", ");
        });
    }

    var getMovies = function(){
        $.ajax({
            url: "/searchie",
            data: {"genres" : genresToSend, "rating":ratingToSend},
            type: "POST",
            success: function(data){
                showMovies(data);
            }
        });
    }




});
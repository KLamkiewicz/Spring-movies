$(function() {
    console.log("working jquery");
    console.log(movie);
    //pstr
   // $.get( "http://www.omdbapi.com/?t="+someValue.title, function( data ) {
   //     console.log(data.Plot);
   // });

    $.ajax({
	url: "//www.omdbapi.com/?t="+movie.title,
	dataType: "jsonp",
	success: function( data ) {
        	console.log(data.Plot);
    	}
    });
});
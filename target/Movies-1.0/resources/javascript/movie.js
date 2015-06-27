$(function() {
    console.log("working jquery");
    console.log(someValue);

    $.get( "http://www.omdbapi.com/?t="+someValue.title, function( data ) {
        console.log(data.Plot);
    });
});
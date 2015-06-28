$(function() {

    //http://stackoverflow.com/questions/25594478/different-color-for-each-bar-in-a-bar-chart-chartjs
    var randomColorGenerator = function () {
        return '#' + (Math.random().toString(16) + '0000000').slice(2, 8);
    };


    var data = [];
    $.each(genres, function(key, value){
        data.push({
            "value": value,
            "label": key,
            "color":randomColorGenerator()
        })
    });

    var ctx = $("#myChart").get(0).getContext("2d");

    var myPieChart = new Chart(ctx).Pie(data,
        {
            animationSteps: 100,
            animationEasing: 'easeInOutQuart'
        }
    );
});
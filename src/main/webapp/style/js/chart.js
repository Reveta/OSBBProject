//var test = 1;

var google, document;
google.charts.load('current', {
    callback: function () {
        drawChart(status);
    }, packages: ['corechart']
});

// Set a callback to run when the Google Visualization API is loaded.
//google.charts.setOnLoadCallback(drawChart);

// Callback that creates and populates a data table,
// instantiates the pie chart, passes in the data and
// draws it.
function drawChart(status) {

    // var st = status;
    // Create the data table.
    "use strict";

    var data = new google.visualization.DataTable();
    data.addColumn('string', 'Topping');
    data.addColumn('number', 'Slices');
    data.addRows([['Yes', tr], ['No', fal]]);

    // Set chart options
    var options = {
        'backgroundColor': 'transparent',
        'width': 500,
        'height': 300,
        'colors': ['#d68a46', '#d79c6a'],
        'legend': {position: 'top', alignment: 'center', textStyle: {color: 'white', fontName: 'Arial', fontSize: 14}},
        'pieSliceBorderColor': 'transparent',
        'pieSliceText': 'none'
    };

    // Instantiate and draw our chart, passing in some options.
    var a = status;
    // var tmp = tmp;
    var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
    chart.draw(data, options);

    var addTitle = function () {
        $('.chart_div').prepend('<h6>' + votingText + '</h6>');
    };
    var addButtons = function () {
        $('.chart_div').append(
            '<form action="/addVote" method="post">'+
            '<div class="chart-buttons">' +
            '<input type="hidden" name="votingId" value=' + votingId + '>' +
            '<button class="btn btn-chart btn-chart-yes" type="submit" name="vote" value="true"> Yes </button>' +
            '<button class="btn btn-chart btn-chart-yes" type="submit" name="vote" value="false"> No </button>' +
            '</form>'
        );
    };

    if (a == 1 && checkUser == 42) {
        $(".bg-grey").css({"display": "block"});
        chart.draw(data, options);
        addTitle();
        addButtons();
    // } else if (a == 2) {
    //     $(".bg-grey").css({"display": "block"});
    //     chart.draw(data, options);
    //     addTitle();
    } else {
        $(".bg-grey").css({"display": "none"});
    }
}

//$(document).on('click', function(){
//    var b = Number(prompt("Enter status number:"));
//    drawChart(2);
//});


/*global $ */

// Get Date
function getTopDate() {
    "use strict";
    
    Date.prototype.getMonthName = function () {
        var monthName = ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'];
        return monthName[this.getMonth()];
    };
    
    var topDate = new Date();
    
    $('#nav-date').append(
        '<span class="date-day">' + topDate.getDate() + '</span>' + '<span class="date-meta">' +
            '<span class="date-month">' + topDate.getMonthName() + '</span>' + '<br>' +
            '<span class="date-year">' + topDate.getFullYear() + '</span>' + '</span>'
    );
}


// Header dropdown animation
function vissibleCategory() {
    "use strict";
    
    var oH = 0, hH = 52, speed = 1000;
    
    function fadeOutDownAnimate() {
        $('#categories').stop().animate({'max-height': oH, 'owerflow': 'hidden'}, speed);
    }
    
    function fadeInDownAnimate() {
        $('#categories').stop().animate({'max-height': hH, 'owerflow': 'vissible'}, speed);
    }
    
    $('#vissible-category, #categories').hover(fadeInDownAnimate, fadeOutDownAnimate);
}

// Document ready function
$(document).ready(function () {
    "use strict";
    
    getTopDate();
    vissibleCategory();
    $('.carousel').carousel({
    interval: 3000,
    pause: "true"
    });
});
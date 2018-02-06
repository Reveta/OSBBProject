/*global $ */

// Get Date
function getTopDate() {
    "use strict";
    
    Date.prototype.getMonthName = function () {
        var monthName = ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'];
        return monthName[this.getMonth()];
    };
    
    var topDate = new Date();
    
    $("#nav-date").append(
        '<span class="date-day">' + topDate.getDate() + '</span>' + '<span class="date-meta">' +
            '<span class="date-month">' + topDate.getMonthName() + '</span>' + '<br>' +
            '<span class="date-year">' + topDate.getFullYear() + '</span>' + '</span>'
    );
}

function carouselStart() {
    "use strict";
    
    function prevCarousel(carousel, itemWidth, speed) {
        $(carousel).find(".carousel-items .carousel-item").eq(-1).clone().prependTo($(carousel).find(".carousel-items"));
        $(carousel).find(".carousel-items").css({"left": "-" + itemWidth + "px"});
        $(carousel).find(".carousel-items .carousel-item").eq(-1).remove();
        $(carousel).find(".carousel-items").animate({left: "0px"}, speed);
    }
    
    function nextCarousel(carousel, itemWidth, speed) {
        $(carousel).find(".carousel-items .carousel-item").eq(0).clone().appendTo($(carousel).find(".carousel-items"));
        $(carousel).find(".carousel-items").css({"left": "0px"});
        $(carousel).find(".carousel-items .carousel-item").eq(0).remove();
        $(carousel).find(".carousel-items").animate({left: "-" + itemWidth + "px"}, speed);
    }
    
    $(".carousel-button").on("click", function () {
        var id = $(this).attr("id"), speed = 800, carousel = $(this).parents(".carousel"), itemWidth = $(carousel).find(".carousel-item").outerWidth();
        
        if (id === "carousel-button-prev") {
            prevCarousel(carousel, itemWidth, speed);
            return false;
            
        } else if (id === "carousel-button-next") {
            nextCarousel(carousel, itemWidth, speed);
        }
    });
}

// Document ready function
$(document).ready(function () {
    "use strict";
    
    getTopDate();
    carouselStart();
});
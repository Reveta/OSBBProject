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

function deleteStatus() {
    "use strict";
    
    $('.more-info-about-status').remove();
    $(".delete-status-verification").fadeIn();
        
    function closeStatusDeleteVerification() {
        $('.delete-status-verification').fadeOut();
    }
        
    $('#delete').on('click', closeStatusDeleteVerification);
    $('#cancel').on('click', closeStatusDeleteVerification);
}

function getStatusInfo() {
    "use strict";
    //function for getting data from database
}

function GetStatusMore() {
    "use strict";
    
    getStatusInfo();
    
    $('.more-info-about-status').remove();
    
    $(this).parent('.status').parent('li').append(
        '<div class="more-info-about-status">' + '<span class="close-info">' +
                '<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>' +
            '</span>' +
            '<ul>' + '<li><span>Адрес:</span> буд. 2, кв. 15</li>' +
                '<li><span>Дата: </span>21.01.2018</li>' +
                '<li><p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Nesciunt iste corporis autem debitis dolorum officiis tenetur officia ipsa recusandae ipsam assumenda alias nam esse nisi, eius vero soluta aliquid voluptas.</p></li>' +
                '<!-- <li><input type="submit" class="btn btn-delete" value="Видалити"></li>-->' +
            '</ul>' + '</div>'
    );
        
    $('.delete-status-verification').fadeOut();
        
    $(".close-info").on("click", function () {
        $(this).parent(".more-info-about-status").remove();
    });
}

function closeReview() {
    "use strict";
    
    $("#closeReviews").hide();
    $("#openReviews").show();
    $(".news-slider-section, .news-slider-header").css({"opacity": "1"});
    $(".news-slider-reviews").css({"display": "none"});
}

function openReview() {
    "use strict";
    
    $("#openReviews").hide();
    $("#closeReviews").show();
    $(".news-slider-section, .news-slider-header").css({"opacity": "0"});
    $(".news-slider-reviews").css({"display": "block"});
}

// Document ready function
$('document').ready(function () {
    "use strict";
    
    getTopDate();
    carouselStart();
//    createDiagram();
    
    $(".get-more-info-about-status").on("click", GetStatusMore);
    $(".delete-status").on("click", deleteStatus);
    $("#openReviews").on("click", openReview);
    $("#closeReviews").on("click", closeReview);
});
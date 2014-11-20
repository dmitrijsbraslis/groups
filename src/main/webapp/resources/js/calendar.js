var months = ['январь', 'февраль', 'март', 'апрель','май', 'июнь', 'июль', 'август','сентябрь', 'октябрь', 'ноябрь', 'декабрь'];
var dayNames = ['Пн', 'Вт', 'Ср', 'Чт', 'Пт', 'Сб', 'Вс'];

var today = new Date();

var thisYear = today.getFullYear();
var thisMonth = today.getMonth();
var thisDay = today.getDate();

createCalendar();

function changeCalendar(move) {
    if (move == "prev") {
        today.setMonth(thisMonth - 1);
    } else {
        today.setMonth(thisMonth + 1);
    }
    thisMonth = today.getMonth();
    thisYear = today.getFullYear();
    createCalendar();
}

function createCalendar() {

    var output = "<div class=\"cal_w\">";
    output = output + "<div class=\"month_w\"><a onclick=\"changeCalendar('prev')\"><</a> " + months[thisMonth] + "<a onclick=\"changeCalendar('next')\">></a></div>";

    for (y=0; y<7; y++) {
        output = output + "<div class=\"day\">" + dayNames[y] + "</div>";
    }

    var dayNum = new Date(thisYear, thisMonth, 1).getDay();
    var emptyDays = 6;

    if (dayNum > 0) {
        emptyDays = dayNum - 1;
    }

    for (y=0; y<emptyDays; y++) {
        output = output + "<div class=\"day\">-</div>";
    }

    var dayCount = 32 - new Date(thisYear, thisMonth, 32).getDate();
    if (thisDay > dayCount) {
        thisDay = dayCount;
    }
    for (i=1; i<=dayCount; i++) {
        if (i == thisDay) {
            output = output + "<div id=\"" + i + "\" class=\"day_t\" onClick=\"changeDay(" + i + ");\">" + i + "</div>";
        } else {
            output = output + "<div id=\"" + i + "\" class=\"day\" onClick=\"changeDay(" + i + ");\">" + i + "</div>";
        }
    }
    output = output + "</div>";
    document.getElementById("calendar").innerHTML = output;
}

function changeDay(changeTo) {
    document.getElementById(thisDay).className = "day";
    thisDay = changeTo;
    document.getElementById(changeTo).className = "day_t";
}

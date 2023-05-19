let SalesByGenre = function () {
}

SalesByGenre.prototype = {
    genre: '',
    sale: 0.0,
    build: function (genre, sale) {
        this.genre = genre;
        this.sale = sale;
    }
}

let SalesByMonth = function () {
}

SalesByMonth.prototype = {
    month: '',
    sale: 0.0,
    build: function (month, sale) {
        this.month = month;
        this.sale = sale;
    }
}
jQuery(document).ready(function ($) {
    getSalesByGenre()
    getSalesByMonth()
});

function generateReportSalesByGenre(salesByGenre) {
    let labels = [];
    let sales = [];
    let colors = [];
    $.each(salesByGenre, function (ind, el) {
        let sale = new SalesByGenre();
        sale.build(el.genre, el.sale);
        labels.push(sale.genre);
        sales.push(sale.sale);
        colors.push(getRandomColor());
    });
    new Chart(
        document.getElementById('sales-by-genre'),
        {
            type: 'pie',
            data: {
                labels: labels,
                datasets: [{
                    label: 'Продажи',
                    data: sales,
                    backgroundColor: colors,
                    hoverOffset: 4
                }]
            },
            options: {
                responsive: true,
                plugins: {
                    legend: {
                        position: 'top',
                    },
                    title: {
                        display: true,
                        text: 'Отчёт по продажам в разрезе жанров'
                    }
                }
            },
        })
}

function getSalesByGenre() {

    $.ajax({
        type: "POST",
        contentType: "application/json;charset=utf-8",
        url: "report/sales-by-genre",
        timeout: 100000,
    })
        .done(function (data) {
            generateReportSalesByGenre(data);
        })
        .fail(function (e) {
            console.log(e);
        });
}

function generateReportSalesByMonth(salesByMonth) {
    let labels = [];
    let sales = [];
    let colors = [];
    $.each(salesByMonth, function (ind, el) {
        let sale = new SalesByMonth();
        sale.build(getMonthName(el.month), el.sale);
        labels.push(sale.month);
        sales.push(sale.sale);
        colors.push(getRandomColor());
    });
    new Chart(
        document.getElementById('sales-by-month'),
        {
            type: 'pie',
            data: {
                labels: labels,
                datasets: [{
                    label: 'Продажи',
                    data: sales,
                    backgroundColor: colors,
                    hoverOffset: 4
                }]
            },
            options: {
                responsive: true,
                plugins: {
                    legend: {
                        position: 'top',
                    },
                    title: {
                        display: true,
                        text: 'Отчёт по продажам по месяцам'
                    }
                }
            },
        })
}

function getSalesByMonth() {

    $.ajax({
        type: "POST",
        contentType: "application/json;charset=utf-8",
        url: "report/sales-by-month",
        timeout: 100000,
    })
        .done(function (data) {
            generateReportSalesByMonth(data);
        })
        .fail(function (e) {
            console.log(e);
        });
}

function getRandomColor() {
    let colorR = Math.floor((Math.random() * 256));
    let colorG = Math.floor((Math.random() * 256));
    let colorB = Math.floor((Math.random() * 256));
    return "rgb(" + colorR + "," + colorG + "," + colorB + ")";
}

function getMonthName(monthNumber) {
    switch (monthNumber) {
        case 1:
            return 'Январь'
        case 2:
            return 'Февраль'
        case 3:
            return 'Март'
        case 4:
            return 'Апрель'
        case 5:
            return 'Май'
        case 6:
            return 'Июнь'
        case 7:
            return 'Июль'
        case 8:
            return 'Август'
        case 9:
            return 'Сентябрь'
        case 10:
            return 'Октябрь'
        case 11:
            return 'Ноябрь'
        case 12:
            return 'Декабрь'
    }
}
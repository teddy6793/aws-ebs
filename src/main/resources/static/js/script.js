
let sevenDay, valueOfTotal, fourStatus, valueOfEachStatus
$.ajax({
    url: '/api/web_shop/admin/revenue',
    type: 'GET',
    dataType: "json",
    success: getDataprofitLineChart
});

$.ajax({
    url: '/api/web_shop/admin/number_of_status_order',
    type: 'GET',
    dataType: "json",
    success: displayAll
});

const lineChartProfit = {
    chart: {
        type: "line",
        height: "280px",
        fontFamily: "Nunito",
        toolbar: {
            show: true,
        },
    },
    stroke: {
        curve: "straight",
        width: 6,
        colors: ["#6E00FF"],
    },
    markers: {
        size: 7,
        colors: ["#6E00FF"],
    },
    grid: {
        strokeDashArray: 10,
    },
    series: [
        {
            name: "Doanh thu",
            data: [8,12,56,21,43,56,12],
        },
    ],
    xaxis: {
        categories: ['28-04','27-04','26-04','25-04','24-04','23-04','22-04'],
    },
};

const colors = ['#495dd6','#1b9ef8','#26a848','#e32d53']

let columnChartOrder = {
    series: [{
        data: [21, 22, 10, 28]
    }],
    chart: {
        height: 255,
        type: 'bar',
        toolbar: {
            show: true,
        },
    },
    colors: colors,
    plotOptions: {
        bar: {
            columnWidth: '40%',
            distributed: true,
        }
    },
    dataLabels: {
        enabled: false
    },
    legend: {
        show: false
    },
    xaxis: {
        categories: [
            ['John', 'Doe'],
            ['Joe', 'Smith'],
            ['Jake', 'Williams'],
            'Amber'
        ],
        labels: {
            style: {
                colors: colors,
                fontSize: '12px'
            }
        }
    }
};


function displayAll(data){
    fourStatus = data.statusOrder
    valueOfEachStatus = data.numberOfOrder
}

function getDataprofitLineChart(data){
    sevenDay = data.date
    valueOfTotal = data.value
}

function statisFunction(){
    const series = [
        {
            name: "Doanh thu",
            data: valueOfTotal,
        },
    ]

    const seriesBar = [
        {
            name: "Số đơn",
            data: valueOfEachStatus
        },
    ]

    columnChartOrder.xaxis.categories = fourStatus;
    columnChartOrder.series = seriesBar;


    lineChartProfit.xaxis.categories = sevenDay;
    lineChartProfit.series = series;
    const chart = new ApexCharts(document.querySelector("#chart"), lineChartProfit);
    chart.render();

    const chartStat = new ApexCharts(document.querySelector("#chart-line-profit"), lineChartProfit);
    chartStat.render();

    const columnChartOrderRender = new ApexCharts(document.querySelector("#chart-column-order"), columnChartOrder);
    columnChartOrderRender.render()
}
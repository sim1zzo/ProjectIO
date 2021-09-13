var chartDataStr = decodeHtml(chartData);
const chartJsonArray = JSON.parse(chartDataStr);

var arrLength = chartJsonArray.length;
const numbericData = [];
const labelData = [];

for (var i = 0; i < arrLength; i++) {
  numbericData[i] = chartJsonArray[i].value;
  labelData[i] = chartJsonArray[i].label;
}

new Chart(document.getElementById('myPieChart'), {
  type: 'pie',
  data: {
    labels: labelData,
    datasets: [
      {
        label: 'My First dataset',
        backgroundColor: ['#0d6efd', '#198754', '#dc3545'],
        data: numbericData,
      },
    ],
  },
  options: {
    title: {
      display: true,
      text: 'Project Statuses',
    },
  },
});

function decodeHtml(html) {
  const text = document.createElement('textarea');
  text.innerHTML = html;
  return text.value;
}

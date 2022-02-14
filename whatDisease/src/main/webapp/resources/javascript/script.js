google.charts.load('current', { packages: ['corechart', 'bar'] });
google.charts.setOnLoadCallback(drawStacked);

function drawStacked() {
	google.charts.load("current", { packages: ["corechart"] });
	google.charts.setOnLoadCallback(drawChart);
	function drawChart() {
		var data = google.visualization.arrayToDataTable([
			["Doença", "Sintoma", { role: "style" }],
			["Covid-19", 40.00, "#b87333"],
			["Gripe", 30.00, "silver"],
			["Resfriado", 20.00, "gold"],
			["Dengue", 10.00, "color: #e5e4e2"]
		]);

		var view = new google.visualization.DataView(data);
		view.setColumns([0, 1,
			{
				calc: "stringify",
				sourceColumn: 1,
				type: "string",
				role: "annotation"
			},
			2]);

		var options = {
			title: "Doenças mais comuns no site",
			width: 600,
			height: 400,
			bar: { groupWidth: "95%" },
			legend: { position: "none" },
		};
		var chart = new google.visualization.BarChart(document.getElementById("chart_div"));
		chart.draw(view, options);
	}
}
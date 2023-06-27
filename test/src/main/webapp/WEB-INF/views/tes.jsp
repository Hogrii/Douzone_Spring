<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.net.URLConnection"%>
<%@page import="java.net.URL"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
<link rel='stylesheet'
	href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,700'>
<link rel='stylesheet'
	href='https://raubarrera.neocities.org/cdpn/style.css'>
<link rel="stylesheet" href="css/style.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/export-data.js"></script>
<script type="text/javascript">
	$(function() {
		$.load = function() {
			var data1 = new Array();
			var name = $('#slct option:selected').text();
			$.getJSON("Ajax_Request.jsp?", {
				no : name
			}, function(data) {
				var list = data.list;
				$.each(list, function(index, value) {
					if (value.sidoName == $('#slct option:selected').text()) {
						data1[index] = [ value.cityName,
								parseInt(value.pm10Value) ];
					}
				});
				Highcharts.chart('container', {
					chart : {
						type : 'column'
					},
					title : {
						text : '미세먼지 시/군/구별 실시간 농도'
					},
					subtitle : {
						text : '서울, 부산, 대구, 인천, 광주, 대전, 울산, 경기'
					},
					xAxis : {
						type : 'category',
						labels : {
							rotation : -45,
							style : {
								fontSize : '13px',
								fontFamily : 'Verdana, sans-serif'
							}
						}
					},
					yAxis : {
						min : 0,
						title : {
							text : '실시간 미세먼지농도 (㎍/㎥)'
						}
					},
					legend : {
						enabled : false
					},
					tooltip : {
						pointFormat : '실시간 미세먼지: <b>{point.y:.1f} ㎍/㎥</b>'
					},
					series : [ {
						name : '미세먼지 농도',
						data : data1,
						dataLabels : {
							enabled : true,
							rotation : -90,
							color : '#FFFFFF',
							align : 'right',
							format : '{point.y:.1f}', // one decimal
							y : 10, // 10 pixels down from the top
							style : {
								fontSize : '13px',
								fontFamily : 'Verdana, sans-serif'
							}
						}
					} ]
				});
			});
		};
		$.load();
		$('#slct').change(function() {
			$.load();
		});
	});
</script>
</head>
<body>
	<h1>실시간 미세먼지 농도</h1>
	<div class="select">
		<select id="slct" name="slct">
			<option>서울</option>
			<option>인천</option>
			<option>경기</option>
			<option>부산</option>
			<option>대구</option>
			<option>광주</option>
			<option>대전</option>
			<option>울산</option>
		</select>
	</div>
	<div class="chart"></div>
	<div id="container"
		style="min-width: 300px; height: 400px; margin: 0 auto"></div>
</body>
</html>
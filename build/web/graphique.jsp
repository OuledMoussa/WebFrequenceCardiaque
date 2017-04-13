<%-- 
    Document   : graphique
    Created on : 16-Mar-2017, 19:36:26
    Author     : sacha
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
    <html>
        <head>
            <title>Mon Activité</title>
            <!-- Materialize CSS -->
            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/css/materialize.min.css">
            <!-- surcharge pour le thème material-->
            <link rel="stylesheet" href="css/theme.css">
            <link rel="stylesheet" href="css/coeur.css">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <!-- material-icons -->
            <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
           
        </head>
        <body>

            <!-- Entête du site -->
            <%@include file="entete.jsp" %>
            


            <!-- Contenu du site -->
            <main>
                <div class="section no-pad-bot" id="index-banner">
                    <div class="container">
                        <div class="col s12 m6">
                            
                            <div id="curve_chart" style="width: 900px; height: 500px; margin: 0 auto;"></div>

                        </div>
                </div>
            </main>

            <!-- Pied de page du site -->
            <%@include file="pied.jsp" %>

    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
        <script type="text/javascript">
        google.charts.load('current', {'packages':['corechart']});
        google.charts.setOnLoadCallback(drawChart);

        function drawChart() {
            var data = google.visualization.arrayToDataTable([
            ['Heure', 'bpm', 'seuil minimal', 'seuil maximal'],
            ['8:00',  80,      65, 140],
            ['9:00',  70,      65, 140],
            ['10:00',  120,       65, 140],
            ['11:00',  130,      65, 140],
            ['12:00',  90,      65, 140],
            ['13:00',  100,      65, 140],
            ['14:00',  90,       65, 140],
            ['15:00',  70,      65, 140]
            ]);
/*
            var options = {
            title: 'Company Performance',
            curveType: 'function',
            legend: { position: 'bottom' }
            series: {}
            };
*/
            var options = {
                    chart: {
                        title: 'Average Temperatures and Daylight in Iceland Throughout the Year'
                    },
                    width: 900,
                    height: 500,
                    
                    series: {
                        // Gives each series an axis name that matches the Y-axis below.
                        0: {axis: 'Frequence', color: '#2196f3'},
                        1: {axis: 'minimum', color: '#e65100'},
                        2: {axis: 'Frequence', color: '#e65100'}
                    
                    },
                    axes: {
                        // Adds labels to each axis; they don't have to match the axis names.
                        y: {
                            Frequence: {label: 'Fréquence'}
                        }
                    }        
                };




            var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));

            chart.draw(data, options);
        }
        </script>

        </body>
    </html>
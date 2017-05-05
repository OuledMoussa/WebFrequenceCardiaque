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
                    <form class="col s12 m12 l12" method="post" action="graphiquePeriode.jsp" id="date">

                        <div id="curve_chart" style="width: 900px; height: 500px; margin: 0 auto;"></div>
                        <div class="row center">
                            <div class="col s12 m12 l12">
                                <br />
                                Vos indicateurs statistiques<br />
                                Valeur max : <div id="max"></div>
                                Valeur moyenne : <div id="moy"></div>
                                Valeur min : <div id="min"></div>
                                <br />
                            </div>
                        </div>
                        <div class="row center">                            
                            <!-- Mise en page -->
                            <div class="col s12 m12 l2"></div>
                                <!-- Conteneur du texte et du choix des dates -->
                            <div class="col s12 m12 l8">
                                <div class="input-field col s12 m6 l6">
                                    <input id="d1" name="d1" type="date" class="datepicker">
                                    <label for="d1" id="dp" class="active">Début de la période</label>
                                </div>
                                <div class="input-field col s12 m6 l6">
                                    <input id="d2" name="d2" type="date" class="datepicker">
                                    <label for="d2" id="dp" class="active">Fin de la période</label>
                                </div>
                            </div>
                            <!-- Mise en page -->
                            <div class="col s12 m12 l2"></div>
                            <br />
                        </div>
                        <div class="row center">
                            <input class="waves-effect waves-light btn blue center" type="submit" value="Envoyer">
                        </div>
                        

                    </form>
                </div>
        </main>

        <!-- Pied de page du site -->
        <%@include file="pied.jsp" %>

        <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
        <script type="text/javascript">
            // Attent que la page soit chargée avant d'afficher les informations
            $(document).ready(function () {
                // Instancie les composants du tableau
                google.charts.load('current', {'packages': ['corechart']});
                // Créé le tableau
                google.charts.setOnLoadCallback(drawChart);

                // Données du tableau à afficher
                var donnees = new Array();

                // Requete Ajax Permettant de récupérer les données du tableau
                jQuery.ajax({
                    type: 'GET',
                    dataType: 'json',
                    url: "FrequenceCJsonServlet",
                    success: function (data) {
                        /*
                         // Inscrit chaque donnée dans le tableau de données Code pour JDBC2JSON
                         $(data).each(function () {
                         // Création de l'objet 
                         //var obj = new Array((this)[2], $(this)[1]);
                         var obj = new Array((this)[0], $(this)[1], $(this)[2], $(this)[3]);
                         // Ajout du nouvel objet dans le tableau
                         donnees.push(obj);
                         */
                        // Inscrit chaque donnée dans le tableau de données Code pour Servlet
                         $(data).each(function () {
                         // Création de l'objet avec les valeurs
                         var obj = new Array($(this).get(0).dateEnr, $(this).get(0).freq, $(this).get(0).fmin, $(this).get(0).fmax);
                         // Ajout du nouvel objet dans le tableau
                         donnees.push(obj);
                        });
                    }
                });


                // Requete Ajax Permettant de récupérer les stats de la personne
                jQuery.ajax({
                    type: 'GET',
                    dataType: 'json',
                    url: "Stat",
                    success: function (data) {
                        // Inscrit chaque donnée dans le tableau de données Code pour Servlet
                         $('#max').html(data[0]);
                         $('#moy').html(data[1]);
                         $('#min').html(data[2]);
                    }
                });


                /* 
                 * Permet de faire afficher dans le tableau toutes les données
                 * qui ont étés récupérées grâce à la requête Ajax
                 */
                function drawChart() {
                    // Oobjet qui va contenir l'ensembles des éléments à afficher
                    var data = new google.visualization.DataTable();
                    /*
                     *  Entête Du tableau +
                     *  Nom de chacune des données
                     */
                    data.addColumn('string', 'Heure');
                    data.addColumn('number', 'Battement');
                    data.addColumn('number', 'Seuil max');
                    data.addColumn('number', 'Seuil min');

                    // Données principales
                    data.addRows(donnees);

                    // Paramètre supplémentaires
                    var options = {
                        title: 'Votre Activité Cardiaque',
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
                                Batement: {label: 'Fréquence'}
                            }
                        }
                    };

                    // Cherche l'objet qui va recevoir le tableau
                    var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));
                    // Affiche toutes les données avec les options des configuration
                    chart.draw(data, options);
                }

            });

        </script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.16.0/jquery.validate.js"></script>
        <script src="js/verifIns.js"></script>
    </body>
</html>
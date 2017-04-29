<%-- 
    Document   : index
    Created on : 16-Mar-2017, 19:36:26
    Author     : sacha
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Mon Dossier</title>
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
                            <!-- 
                                Texte à inserer Ici
                                Le texte sera en dessous du header
                                Consseillé pour un titre
                            -->
                        </div>
                    </div>
                </div>


                <div class="container">
                    <div class="row">
                        <!-- Déco -->
                        <div class="col s12 m2 l2"></div>
                        <!-- Partie contenant les données -->
                        <form class="col s12 m8 l8"  action="EnrDossier" method="POST">
                            <div class="row">
                                <!-- Partie gauche -->
                                <div class="col s6 m6 l6">
                                    <p class="center-align"> Habitudes </p>
                                    <p>
                                        <input type="checkbox" id="fumeur" name="fumeur" class="blue" disabled> 
                                        <label for="fumeur">Vous fumez</label>
                                    </p>
                                    <p>
                                        <input type="checkbox" id="hta" name="hta" disabled>
                                        <label for="hta">Vous avez des problèmes d'hypertension</label>
                                    </p>
                                    <p>
                                        <input type="checkbox" id="diabete" name="diabete" disabled>
                                        <label for="diabete">Vous êtes diabétique</label>
                                    </p>
                                    
                                </div>
                                <!-- Partie droite -->
                                <div class="col s6 m6 l6">
                                    <p class="center-align"> Seuils fixés par votre médecin </p>
                                    <div class="row">
                                        <div class="input-field col s12 m12 l12">
                                            <input id="smax" name="smax" type="number" class="validate" min="40" max="220" data-error=".errorTxt1" disabled>
                                            <label for="smax" class="active">Seuil Maxinimum</label>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="input-field col s12 m12 l12">
                                            <input id="smin" name="smin" type="number" class="validate" min="40" max="220" data-error=".errorTxt2" disabled>
                                            <label for="smin" class="active">Seuil Minimum</label>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="row">
                                <!-- Déco -->
                                <div class="col s12 m3 l3"></div>
                                <div class="col s12 m6 l6 center">
                                    <input id="mod" type="button" class="waves-effect waves-light btn blue"value="Modifier">
                                    <br />
                                    <br />
                                    <input id="val" type="submit" class="waves-effect waves-light btn blue"value="Valider">
                                </div>
                                <!-- Déco -->
                                <div class="col s12 m3 l3"></div>
                            </div>
                        </form>
                        <!-- Déco -->
                        <div class="col s12 m2 l2"></div>
                    </div>
                </div>
            </main>

            <!-- Pied de page du site -->
            <%@include file="pied.jsp" %>
            
    <script>
        $(document).ready(function(){
            
                /* 
                 * Requete Ajax Permettant de récupérer les données du tableau
                 * et de modifier les valeurs des cases à cocher
                 */
                jQuery.ajax({
                    type: 'GET',
                    dataType: 'json',
                    url: "AffichageDossierServlet",
                    success: function (data) {
                        // Met les données dans les inputs correspondant
                        var fume = $(data).get(0).smoke.toString();
                        var hta = $(data).get(0).hta.toString();
                        var diabete = $(data).get(0).diabete.toLocaleString();
                        
                        /* 
                         * Vérifie les valeurs de la base de données
                         * pour cocher les cases du formulaire
                         */
                        if (fume.search("true") >= 0) {
                            $('#fumeur').prop('checked', true);                            
                        }
                        if (hta.search("true") >= 0) {
                            $('#hta').prop('checked', true);
                        }
                        if (diabete.search("true") >= 0){
                            $('#diabete').prop('checked', true);
                        }

                        // Modifie la valeur des inputs des seuils
                        $('#smin').val($(data).get(0).tMin);
                        $('#smin').next().addClass("active");
                        $('#smax').val($(data).get(0).tMax);
                        $('#smax').next().addClass("active");         
                        
                    }
                });
                       
           // Cache le bouton de validation
           $("#val").hide();
           
           /*
            * Active / Désactive les composants du formulaire
            */
           $("#mod").click(function(){
               if ($("#fumeur").attr("disabled") == "disabled") {
                   // Désactive les composants
                    $("#fumeur").removeAttr("disabled");
                    $("#hta").removeAttr("disabled");
                    $("#diabete").removeAttr("disabled");
                    $("#smin").removeAttr("disabled");
                    $("#smax").removeAttr("disabled");
                    /* Affiche l'intégralité du bouton
                     * à cause de la classe i du bouton de Materialize
                     */
                    $("#val").parent().show();
               } else {
                   // Active les composants
                   $("#fumeur").attr("disabled",true);
                    $("#hta").attr("disabled", true);
                    $("#diabete").attr("disabled", true);
                    $("#smin").attr("disabled", true);
                    $("#smax").attr("disabled", true);
                    /* Cache l'intégralité du bouton
                     * à cause de la classe i du bouton de Materialize
                     */
                    $("#val").parent().hide();
               }
           });
        });
    </script>

        </body>
    </html>
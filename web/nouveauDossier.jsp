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
                        <form class="col s12 m8 l8" action="AjoutDossier" method="POST">
                            <div class="row">
                                <!-- Partie gauche -->
                                <div class="col s6 m6 l6">
                                    <p class="center-align"> Habitudes </p>
                                    <p>
                                        <input type="checkbox" id="fumeur" name="fumeur" class="blue"> 
                                        <label for="fumeur">Vous fumez</label>
                                    </p>
                                    <p>
                                        <input type="checkbox" id="hta" name="hta">
                                        <label for="hta">Vous avez des problèmes d'hypertension</label>
                                    </p>
                                    <p>
                                        <input type="checkbox" id="diabete" name="diabete">
                                        <label for="diabete">Vous êtes diabétique</label>
                                    </p>
                                    
                                </div>
                                <!-- Partie droite -->
                                <div class="col s6 m6 l6">
                                    <p class="center-align"> Seuils fixés par votre médecin </p>
                                    <div class="row">
                                        <div class="input-field col s12 m12 l12">
                                            <input id="smax" name="smax" type="number" class="validate" min="40" max="220" data-error=".errorTxt1">
                                            <label for="smax" class="active">Seuil Maxinimum</label>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="input-field col s12 m12 l12">
                                            <input id="smin" name="smin" type="number" class="validate" min="40" max="220" data-error=".errorTxt2">
                                            <label for="smin" class="active">Seuil Minimum</label>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="row">
                                <!-- Déco -->
                                <div class="col s12 m3 l3"></div>
                                <div class="col s12 m6 l6 center">
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
        </body>
    </html>
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
        <title>Mon Compte</title>
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
                        <h3 class="deep-orange-text">Mon Compte</h3>
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
                    <!-- 
                        Texte à inserer Ici
                        Le texte à mettre est celui prinicpal
                        Contenu de la page 
                    -->
                    <div class="col s12 m6 l12">
                        <div class="row">

                            <div class="col s12 m6 l6">
                                <div class="card horizontal">
                                    <div class="card-image waves-effect waves-block waves-light">
                                        <img class="activator" src="img/8biticon.jpg">
                                    </div>

                                    <div class="card-stacked">
                                        <div class="card-content">
                                            <span class="card-title">${sessionScope.prenom} ${sessionScope.nom}</span>
                                            <br />
                                            <p>

                                            <div class="input-field col s12 m12 l12">
                                                <!-- Première ligne contenant le sexe de la personne -->
                                                <div class="row">
                                                    <div class="input-field col s12 m12 l12">
                                                        <label for="sexe" class="active">Sexe</label>
                                                        <select id="sexe" name="sexe" class="validate">
                                                            <option value="Homme">Homme</option>
                                                            <option value="Femme">Femme</option>
                                                        </select>
                                                        <div class="errorTxt3"></div>
                                                    </div>
                                                </div>

                                                <!-- Deuxième ligne contenant la date de naissance de la personne -->
                                                <div class="row">
                                                    <div class="input-field col s12 m12 l12">
                                                        <input id="ddn" name="ddn" type="date" class="datepicker" >
                                                        <label for="ddn" class="active">Date de naissance</label>
                                                    </div>
                                                </div>


                                            </div>

                                            </p>
                                        </div>
                                    </div>


                                </div>
                            </div>

                            <div class="col s12 m6">
                                <div class="card white-grey darken-1">
                                    <div class="card-content">
                                        <span class="card-title">Mes informations</span>
                                        <p>
                                        <div class="row">
                                            <div class="input-field col s6 m12 l6">
                                                <input id="poids" name="poids" type="number" class="validate" min="0" max="150" data-error=".errorTxt5">
                                                <label for="poids" class="active">Poids</label>
                                                <div class="errorTxt5"></div>
                                            </div>

                                            <div class="input-field col s6 m12 l6">
                                                <input id="taille" name="taille" type="number" class="validate" min="50" max="250" data-error=".errorTxt6">
                                                <label for="taille" class="active">Taille</label>
                                                <div class="errorTxt6"></div>
                                            </div>
                                        </div>
                                        
                                        <div class="row">
                                            <div class="input-field col s6 m12 l6">
                                                <input id="mail" name="mail" type="text" class="validate" data-error=".errorTxt10">
                                                <label for="mail" class="active">Adresse Mail</label>
                                                <div class="errorTxt10"></div>
                                            </div>
                                            <div class="input-field col s6 m12 l6">
                                                <input id="identifiant" name="login" type="text" class="validate" data-error=".errorTxt7">
                                                <label for="identifiant" class="active">Identifiant</label>
                                                <div class="errorTxt7"></div>
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="input-field col s6 m12 l6">
                                                <input id="mdp" name="mdp" type="password" class="validate" data-error=".errorTxt8">
                                                <label for="mdp" class="active">Mot de passe</label>
                                                <div class="errorTxt8"></div>
                                            </div>

                                            <div class="input-field col s6 m12 l6">
                                                <input id="mdp2" name="mdp2" type="password" class="validate" data-error=".errorTxt9">
                                                <label for="mdp2" class="active">Confirmez votre mot de passe.</label>
                                                <div class="errorTxt9"></div>
                                            </div>
                                        </div>

                                        </p>
                                    </div>
                                    <div class="card-action">
                                        <div class="center">
                                            <input type="button" id="mod" class="waves-effect waves-light btn blue" value="Modifier">
                                            <input type="button" id="val" class="waves-effect waves-light btn blue" value="Valider">
                                        </div>
                                    </div>
                                </div>
                            </div>




                        </div>
                    </div>
                </div>
            </div>
        </main>

        <!-- Pied de page du site -->
        <%@include file="pied.jsp" %>

    </body>
</html>
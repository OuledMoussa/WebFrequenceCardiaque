<%-- 
    Document   : inscription
    Created on : 21-Mar-2017, 13:55:12
    Author     : sacha
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inscription</title>
        <!-- Materialize CSS -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/css/materialize.min.css"> 
        <!-- surcharge pour le thème material-->
        <link rel="stylesheet" href="css/theme.css">
        <!-- Animation pour le coeur -->
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
                        <h1 class="header center deep-orange-text"> Formulaire d'inscription </h1>
                    </div>
                </div>
                <br /><br />
                
                    <div class="row">
                        <!-- Mise en Page -->
                        <div class="input-field col s3 m12 l3"></div>
                        <form id="insc" class="col s12 m12 l6" method="POST" action="Inscription">
                            <div class="row">
                                <div class="col s12 m12 l12">
                                    
                                    <div class="input-field col s6 m12 l6">
                                        <input id="nom" name="nom" type="text" class="validate" data-error=".errorTxt1">
                                        <label for="nom" class="active">Nom</label>
                                        <div class="errorTxt1"></div>
                                    </div>
                            
                                    <div class="input-field col s6 m12 l6">
                                        <input id="prenom" name="prenom" type="text" class="validate" data-error=".errorTxt2">
                                        <label for="prenom" class="active">Prenom</label>
                                        <div class="errorTxt2"></div>
                                    </div>

                                    <div class="input-field col s6 m12 l6">
                                        <label for="sexe" class="active">Sexe</label>
                                        <select id="sexe" name="sexe" class="validate">
                                            <option value="Homme">Homme</option>
                                            <option value="Femme">Femme</option>
                                        </select>
                                        <div class="errorTxt3"></div>
                                    </div>
                                    
                                    <div class="input-field col s6 m12 l6">
                                        <input id="ddn" name="ddn" type="date" class="datepicker validate" >
                                        <label for="ddn" class="active">Date de naissance</label>
                                    </div>
                                    
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

                                <div class="input-field col s12 m12 l12 center">
                                    <input type="button" id="inscription" class="waves-effect waves-light btn blue" value="S'inscrire">
                                </div>
                                
                                
                            </div>
                        </form>
                        <!-- Mise en Page -->
                        <div class="input-field col s3 m12 l3"></div>
                    </div>
                    
            </main>

            <!-- Pied de page du site -->
            <%@include file="pied.jsp" %>
    <!-- Script de vérification de formulaire -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.16.0/jquery.validate.js"></script>
    <script src="js/verifIns.js"></script>
    </body>
</html>

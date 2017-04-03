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
            <header>
                <nav class="blue" role="navigation">
                    <div class="nav-wrapper container">
                        <a href="index.jsp" class="brand-logo" style="font-size: 30px;"><i class="material-icons left deep-orange-text hide-on-med-and-down">favorite</i>Fr&eacute;quence Cardiaque</a>
                        <ul id="" class="right hide-on-med-and-down">
                           
                            <c:choose>
                                <c:when test="${sessionScope.nom != null}">
                                    <li>
                                        <a class="dropdown-button" data-activates="options" data-beloworigin="true">
                                            <div class="chip">

                                                <img src="img/8biticon.jpg" alt="${sessionScope.nom}">
                                                    ${sessionScope.nom} 
                                            </div>
                                        </a>
                                    </li>
                                </c:when>
                                <c:otherwise>
                                    <li><a href="connexion.jsp"><i class="material-icons left">perm_identity</i>Connexion</a></li>
                                </c:otherwise>
                                
                            </c:choose>
                            <!-- Dropdown Structure -->
                            <ul id="options" class="dropdown-content">
                              <li><a href="graphique.jsp">Mon Activit&eacute;</a></li>
                              <li><a href="dossier.jsp">Mon Dossier</a></li>
                              <li><a href="compte.jsp">Mon Compte</a></li>
                              <li class="divider"></li>
                              <li><a href="Deconnexion">D&eacute;connexion</a></li>
                            </ul>
                            
                        </ul>
                        <!-- Vue Mobile -->
                        <ul id="nav-mobile" class="side-nav">
                            <li><a>${sessionScope.nom}</a></li>
                        </ul>
                        <a href="#" data-activates="nav-mobile" class="button-collapse"><i class="material-icons">menu</i></a>
                    </div>
                </nav>
            </header>
            


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
                        <form id="insc" class="col s12 m12 l6">
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
                                        <input id="ddn" name="ddn" type="date" class="datepicker validate" data-error=".errorTxt4">
                                        <label for="ddn" class="active">Date de naissance</label>
                                        <div class="errorTxt4"></div>
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
                                        <input id="mail" name="login" type="text" class="validate" data-error=".errorTxt10">
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
            <footer class="page-footer blue">
                <div class="container">
                    <div class="row">
                        <div class="col s12 m6">
                            <h5 class="white-text">Ptut - V&ecirc;tement Intelligent - Fr&eacute;quence cardiaque</h5>
                            <p class="grey-text text-lighten-4">Projet du semestre 2 </p>
                        </div>
                    <div class="col l4 offset-l2 s12 m12">
                        <h5 class="white-text">Liens</h5>
                        <ul>
                            <li><a class="grey-text text-lighten-3" href="#!">Lien 1</a></li>
                        </ul>
                    </div>
                    </div>
                </div>
                <div class="footer-copyright">
                    <div class="container">
                    © 2017 Copyright
                    <a class="grey-text text-lighten-4 right" href="#!">Plus d'info</a>
                    </div>
                </div>
            </footer>


            
    <!-- Materialize JavaScript -->
    <script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
    <script src="http://materializecss.com/bin/materialize.js"></script> 
    <!--<script src="http://materializecss.com/bin/materialize.min.js"></script> -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.16.0/jquery.validate.js"></script>
    <!-- Thème principal jQuery -->
    <script src="js/main.js"></script>
    <!-- Script de vérification de formulaire -->
    <script src="js/verifIns.js"></script>
    </body>
</html>

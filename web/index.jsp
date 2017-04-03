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
            <title>Acceuil</title>
            <!-- surcharge pour le thème material-->
            <link rel="stylesheet" href="css/theme.css">
            <link rel="stylesheet" href="css/coeur.css">
            <!-- Materialize CSS -->
            <link rel="stylesheet" href="materialize-v0.98.0/materialize/css/materialize.min.css">
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
                            <c:choose>
                                <c:when test="${sessionScope.nom != null}">
                                    <li>
                                        <div class="userView">
                                            <div class="background blue"></div>
                                            <a href="#!photo"><img class="circle" src="img/8biticon.jpg"></a>
                                            <a href="#!nom"><span class="white-text name">${sessionScope.nom}</span></a>
                                            <br />
                                        </div>
                                        </li>
                                    <li><a href="graphique.jsp">Mon Activit&eacute;</a></li>
                                    <li><a href="dossier.jsp">Mon Dossier</a></li>
                                    <li><a href="compte.jsp">Mon Compte</a></li>
                                    <li class="divider"></li>
                                    <li><a href="Deconnexion">D&eacute;connexion</a></li>
                                </c:when>
                                <c:otherwise>
                                    <li><a href="connexion.jsp"><i class="material-icons left">perm_identity</i>Connexion</a></li>
                                </c:otherwise>
                            </c:choose>
                        </ul>
                        <a href="#" data-activates="nav-mobile" class="button-collapse"><i class="material-icons">menu</i></a>
                    </div>
                </nav>
            </header>
            


            <!-- Contenu du site -->
            <main>
                <div class="section no-pad-bot" id="index-banner">
                    <div class="container">
                        <div class="col s12 m6">
                            <h1 class="header center deep-orange-text">Comment va votre rythme cardiaque ? </h1>
                        </div>
                    </div>
                </div>
                <br /><br /><br /><br /><br /><br />


                <div class="container">
                    <div class="row">
                        
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


            
    <!-- Code jQuery -->
    <script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
    <!-- Materialize JavaScript -->
    <!--<script src="http://materializecss.com/bin/materialize.js"></script>-->
    <script src="materialize-v0.98.0/materialize/js/materialize.js"></script>
    <script src="materialize-v0.98.0/materialize/js/materialize.min.js"></script>
    <!-- Thème principal jQuery -->
    <script src="js/main.js"></script>

        </body>
    </html>
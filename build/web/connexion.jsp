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
            <title>Connexion</title>
            <!-- Materialize CSS -->
            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/css/materialize.min.css">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <!-- surcharge pour le thème material-->
            <link rel="stylesheet" href="css/theme.css">
            <link rel="stylesheet" href="css/coeur.css">
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
                        <h1 class="header center deep-orange-text">Bienvenue sur la page de connexion </h1>
                    </div>
                </div>
                <br /><br /><h4>${requestScope.message}</h4><br /><br /><br /><br />


                <div class="container">
                    <div class="row">
                        <form class="col s12" action="Connexion" method="POST">
                            <div class="row">
                                <div class="input-field col s12 m12 l6">
                                    <i class="material-icons prefix">perm_identity</i>
                                    <input id="identifiant" type="text" name="login" class="validate">
                                    <label for="identifiant" class="active">Identifiant</label>
                                </div>
                                <div class="input-field col s12 m12 l6">
                                    <i class="material-icons prefix">vpn_key</i>
                                    <input id="mdp" type="password" name="mdp" class="validate">
                                    <label for="mdp" class="active">Mot de Passe</label>
                                </div>
                            </div>
                            <div class="row">
                                <div class="input-field col s12 m12 l12 center">
                                    <input type="submit" class="waves-effect waves-light btn blue" value="Connexion">
                                    <br />
                                    <p class="center petit">Pas encore inscrit ? inscrivez-vous <a href="inscription.jsp">ici</a>.</p>
                                </div>
                            </div>
                        </form>
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
    <script src="http://materializecss.com/bin/materialize.min.js"></script> 

    <script>
$(document).ready(function(){
    
    // Permet d'animer les champs de formulaire
    Materialize.updateTextFields();
    
    // Permet de faire fonctionner le dropdown
    $(".dropdown-button").dropdown();
    
    // Vue Mobile
    $('.button-collapse').sideNav({
      menuWidth: 300, // Default is 300
      edge: 'left', // Choose the horizontal origin
      closeOnClick: true, // Closes side-nav on <a> clicks, useful for Angular/Meteor
      draggable: true // Choose whether you can drag to open on touch screens
    }
  );
});
  
        
    </script>

        </body>
    </html>
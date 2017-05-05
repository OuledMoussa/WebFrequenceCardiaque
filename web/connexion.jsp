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
        <%@include file="entete.jsp" %>


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
                                <div class="col s12 m12 l3"></div>
                                <div class="col s12 m12 l6" id="error" style="color: red; text-align: center;"></div>
                                <div class="col s12 m12 l3"></div>
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
            <%@include file="pied.jsp" %>
            
    <script>
$(document).ready(function(){
    var url = document.location.href;
    // vérifie si il y a une erreur ou non de connexion
    if (url.substring(url.lastIndexOf("/")+1) == "Connexion") {
        $('#error').html("Login ou mot de passe incorrect")
    }
    
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
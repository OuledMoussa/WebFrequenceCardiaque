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
        <style>
            .parallax-container {
      height: 400px;
    }
        </style>
    </head>
    <body>

        <!-- Entête du site -->
        <%@include file="entete.jsp" %>



        <!-- Contenu du site -->
        <main>
            <div class="section no-pad-bot" id="index-banner">
                <div class="container">
                    <div class="col s12 m6">
                        <h1 class="header center deep-orange-text">Comment va votre rythme cardiaque ? </h1>
                    </div>
                </div>
            </div>
            <br /><br /><br />

                <div class="parallax-container">
                    <div class="parallax"><img src="img/piste_coureurs.jpg"></div>
                </div>
                <div class="container">
                <br />
                <h3 class="header center deep-orange-text">Le meilleur moyen de suivre votre fréquence cardiaque.</h3>
                <br />
                </div>
                <div class="parallax-container">
                    <div class="parallax"><img src="img/vélo_montagne.jpg"></div>
                </div>
                <br />
                <br />
                <br />
                <br />
                <br />
                <br />
                <div id="egg">
                    <div class="parallax-container">
                        <div class="parallax"><img src="img/egg.jpg"></div>
                    </div>
                    <br />
                    <br />
                    <br />
                    <br />
                    <br />
                    <br />
                </div>
            
        </main>

        <!-- Pied de page du site -->
        <%@include file="pied.jsp" %>

        <script>
            $(document).ready(function(){
                $('#egg').hide();
                $('.parallax').parallax();
                // Easter Egg
                if ( window.addEventListener ) {
                        var kkeys = [], konami = "38,38,40,40,37,39,37,39,66,65";
                        window.addEventListener("keydown", function(e){
                                kkeys.push( e.keyCode );
                                if ( kkeys.toString().indexOf( konami ) >= 0 ) {
                                        $('#egg').show();
                                        return false;
                                }
                        }, true);
                }
              });
              
            

    
        </script>
    </body>
</html>
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
            <title>Modification Image</title>
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
                            <h2> Modifier son image de profil </h2>
                        </div>
                    </div>
                </div>


                <div class="container">
                    <div class="row">
                        <form method="POST" action="ModifImage" enctype="multipart/form-data">
                            <div class="file-field input-field">
                                <div class="btn">
                                  <span>File</span>
                                  <input type="file" multiple id="fic" name="fic">
                                </div>

                                    <div class="file-path-wrapper">
                                  <input class="file-path validate" type="text" placeholder="Upload one or more files">
                                </div>
                            </div>
                            <input type="submit" class="waves-effect waves-light btn blue">
                        </form>
                </div>
            </main>

            <!-- Pied de page du site -->
            <%@include file="pied.jsp" %>

        </body>
    </html>
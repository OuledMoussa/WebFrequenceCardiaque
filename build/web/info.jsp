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
            <title>Informations</title>
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
                            <h2 class="header center deep-orange-text">Notre &Eacute;quipe</h2>
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
                        <div class="row">
                            <div class="col s12 m1 l2"></div>
                            <div class="col s12 m10 l8">
                                <div class="row">
                                    <div class="col s12 m4 l4">
                                        <a href="https://www.facebook.com/nicolas.cassajus?fref=ts">
                                            <img  class="responsive-img circle" height="150" widht="150" src="img/equipe/cassa.jpg" alt="Alexandre Le Guelvouit">
                                            <p class="center title">Nicolas Cassajus</p>
                                        </a>
                                    </div>
                                    <div class="col s12 m4 l4">
                                        <a href="https://www.facebook.com/margaux.farenc?fref=ts">
                                            <img  class="responsive-img circle" height="150" widht="150" src="img/equipe/margaux.jpg" alt="Alexandre Le Guelvouit">
                                            <p class="center title">Margaux Farenc</p>
                                        </a>
                                    </div>
                                    <div class="col s12 m4 l4">
                                        <a href="https://www.facebook.com/alexandre.leguelvouit">
                                            <img  class="responsive-img circle" height="150" widht="150" src="img/equipe/lg.jpg" alt="Alexandre Le Guelvouit">
                                            <p class="center title">Alexandre Le Guelvouit</p>
                                        </a>
                                    </div> 
                                </div>
                                <div class="row">
                                    <div class="col s12 m4 l4">
                                        <a href="https://www.facebook.com/corentin.marco.75?fref=ts">
                                            <img  class="responsive-img circle" height="150" widht="150" src="img/equipe/coco.jpg" alt="Alexandre Le Guelvouit">
                                            <p class="center title">Corentin Marco</p>
                                        </a>
                                    </div>
                                    <div class="col s12 m4 l4">
                                        <a href="https://www.facebook.com/alexandre.robert.1428">
                                            <img  class="responsive-img circle" height="150" widht="150" src="img/equipe/1.jpg" alt="Alexandre Le Guelvouit">
                                            <p class="center title">Alexandre Robert</p>
                                        </a>
                                    </div>
                                    <div class="col s12 m4 l4">
                                        <a href="https://www.facebook.com/hamza.ouledmoussa?fref=ts">
                                            <img  class="responsive-img circle" height="150" widht="150" src="img/equipe/hamza.jpg" alt="Alexandre Le Guelvouit">
                                            <p class="center title">Hamza Ouled Moussa</p>
                                        </a>
                                    </div>
                                </div>
                            </div>
                            <div class="col s12 m1 l2"></div>
                        </div>
                    </div>
                </div>
            </main>

            <!-- Pied de page du site -->
            <%@include file="pied.jsp" %>

        </body>
    </html>
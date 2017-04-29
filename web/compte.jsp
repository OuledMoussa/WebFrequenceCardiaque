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
                        <form id="compte" class="row" action="RecupInfoPersonne" method="POST">

                            <div class="col s12 m6 l6">
                                <div class="card horizontal blue lighten-5">
                                    <div class="card-image waves-effect waves-block waves-light">
                                        <img class="activator" src="${sessionScope.persoimg}">
                                    </div>

                                    <div class="card-stacked">
                                        <div class="card-content">
                                            <span class="card-title">${sessionScope.prenom} ${sessionScope.nom}</span>
                                            <p>

                                            <div class="input-field col s12 m12 l12">
                                                <!-- Première ligne contenant le sexe de la personne -->
                                                <div class="row">
                                                    <div class="input-field col s12 m12 l12">
                                                        <label for="sexe" class="active">Sexe</label>
                                                        <select id="sexe" name="sexe" class="validate" disabled>
                                                            <option value="Homme">Homme</option>
                                                            <option value="Femme">Femme</option>
                                                        </select>
                                                        <div class="errorTxt3"></div>
                                                    </div>
                                                </div>

                                                <!-- Deuxième ligne contenant la date de naissance de la personne -->
                                                <div class="row">
                                                    <div class="input-field col s12 m12 l12">
                                                        <input id="ddn" name="ddn" type="date" class="datepicker" disabled>
                                                        <label for="ddn" id="dp" class="active">Date de naissance</label>
                                                    </div>
                                                </div>
                                                
                                            </div>
                                            Changer l'image du profil <a href="changeImage.jsp">ici</a>
                                            </p>
                                        </div>
                                    </div>

                                </div>
                            </div>

                            <div class="col s12 m6">
                                <div class="card blue lighten-5">
                                    <div class="card-content">
                                        <span class="card-title">Mes informations</span>
                                        <p>
                                            <div class="row">
                                                <div class="input-field col s6 m12 l6">
                                                    <input id="poids" name="poids" type="number" class="validate" min="0" max="150" data-error=".errorTxt1" disabled>
                                                    <label for="poids" class="active">Poids</label>
                                                    <div class="errorTxt1"></div>
                                                </div>

                                                <div class="input-field col s6 m12 l6">
                                                    <input id="taille" name="taille" type="number" class="validate" min="50" max="250" data-error=".errorTxt2" disabled>
                                                    <label for="taille" class="active">Taille</label>
                                                    <div class="errorTxt2"></div>
                                                </div>
                                            </div>

                                            <div class="row">
                                                <div class="input-field col s6 m12 l6">
                                                    <input id="mail" name="mail" type="text" class="validate" data-error=".errorTxt3" disabled>
                                                    <label for="mail" class="active">Adresse Mail</label>
                                                    <div class="errorTxt3"></div>
                                                </div>
                                                <div class="input-field col s6 m12 l6">
                                                    <input id="login" name="login" type="text" class="validate" data-error=".errorTxt4" disabled>
                                                    <label for="login" class="active">Identifiant</label>
                                                    <div class="errorTxt4"></div>
                                                </div>
                                            </div>

                                            <div class="row">
                                                <div class="input-field col s6 m12 l6">
                                                    <input id="mdp" name="mdp" type="password" class="validate" data-error=".errorTxt5" disabled>
                                                    <label for="mdp" class="active">Mot de passe</label>
                                                    <div class="errorTxt5"></div>
                                                </div>

                                                <div class="input-field col s6 m12 l6">
                                                    <input id="mdp2" name="mdp2" type="password" class="validate" data-error=".errorTxt6" disabled>
                                                    <label for="mdp2" class="active">Confirmez votre mot de passe.</label>
                                                    <div class="errorTxt6"></div>
                                                </div>
                                            </div>
                                        </p>
                                    </div>
                                    <div class="card-action">
                                        <div class="center">
                                            <input type="button" id="mod" class="waves-effect waves-light btn blue" value="Modifier">
                                            <input type="submit" id="val" class="waves-effect waves-light btn blue" value="Valider">
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </form>
                    </div>
                </div>
            </div>
        </main>

        <!-- Pied de page du site -->
        <%@include file="pied.jsp" %>
<script>
        $(document).ready(function(){
            
                /* 
                 * Requete Ajax permettant de récupérer les données de la base
                 * pour ensuite pouvoir les modifer
                 */
                jQuery.ajax({
                    type: 'GET',
                    dataType: 'json',
                    url: "JsonCompte",
                    success: function (data) {                        
                        /* 
                         * Vérifie les valeurs de la base de données
                         * pour les options values
                         */
                        if (data.sexe == "F") {
                            console.log("test");
                            $("#sexe").val("Femme");
                            // Permet de modifier la valeur de la liste déroulante
                            $('#sexe').material_select();
                        } else {
                            $("#sexe").val("Homme");
                            // Permet de modifier la valeur de la liste déroulante
                            $('#sexe').material_select();
                        }
                        // Gestion de la date de naissance
                        var date = data.date;
                        date = date.substr(0,10);
                        var jour = date.substr(8,9);
                        var mois = date.substr(5,2);
                        var an = date.substr(0,4);
                        date = jour + "/" + mois + "/" + an;
                        //var picker = $input.pickadate('picker');
                        $('#ddn').val(date);
                        $('#dp').addClass("active");
                        // Modifie la valeur des inputss
                        $('#poids').val(data.poids);
                        $('#taille').val(data.taille);
                        $('#mail').val(data.mail);
                        $('#login').val(data.login);                        
                        // Met la classe active pour ne pas avoir 
                        // les informations et le texte les un sur les autres
                        $('#poids').next().addClass("active");
                        $('#taille').next().addClass("active");
                        $('#mail').next().addClass("active");
                        $('#login').next().addClass("active");
                        
                    }
                });
                       
           // Cache le bouton de validation
           $("#val").hide();
           
           /*
            * Active / Désactive les composants du formulaire
            */
           $("#mod").click(function(){
               if ($("#poids").attr("disabled") == "disabled") {
                   // Désactive les composants
                   $("#poids").removeAttr("disabled");
                   $("#taille").removeAttr("disabled");
                   $("#mail").removeAttr("disabled");
                   $("#login").removeAttr("disabled");
                   $("#ddn").removeAttr("disabled");
                   $("#mdp").removeAttr("disabled");
                   $("#mdp2").removeAttr("disabled");
                   /* Affiche l'intégralité du bouton
                    * à cause de la classe i du bouton de Materialize
                    */
                   $("#val").parent().show();
               } else {
                   // Active les composants
                   $("#poids").attr("disabled",true);
                   $("#taille").attr("disabled", true);
                   $("#mail").attr("disabled", true);
                   $("#identifiant").attr("disabled", true);
                   $("#ddn").attr("disabled", true);
                   $("#mdp").attr("disabled", true);
                   $("#mdp2").attr("disabled", true);
                   /* Cache l'intégralité du bouton
                    * à cause de la classe i du bouton de Materialize
                    */
                   $("#val").parent().hide();
               }
           });

// Vérifie le mot de passe pour une personne qui modifie son compte
    $("#compte").validate({
        rules: {
            login: {
                minlength: 5
            },
            mdp: {
                minlength: 5,
                
            },
            mdp2: {
                minlength: 5,
                equalTo: "#mdp"
            },
        
        },
            errorElement: 'div',
            errorPlacement: function (error, element) {
                console.log($(element).val());
                var placement = $(element).toggleClass('invalid');
                var placement = $(element).data('error');
                if (placement) {
                    $(placement).append(error);
                } else {
                    error.insertAfter(element);
                }
            }
        
    });



        });
    </script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.16.0/jquery.validate.js"></script>
    
    </body>
</html>
// Vérifie les valeurs rentrées dans la page
$(document).ready(function () {
    $("#inscription").click(function () {
        $("#insc").submit();
    });

    // Teste si la date est bonne (si elle est bien avant aujourd'hui)
    $("#ddn_root").focusout(function () {
        // Récupère la date
        var date = $("#ddn").val();

    });

    $("#insc").validate({
        rules: {
            nom: {
                required: true
            },
            prenom: {
                required: true
            },
            mail: {
                required: true,
                email: true
            },
            sexe: {
                required: true
            },
            poids: {
                required: true,
                min: 0,
                max: 150
            },
            taille: {
                required: true,
                min: 45,
                max: 250
            },
            login: {
                required: true,
                minlength: 5
            },
            mdp: {
                required: true,
                minlength: 5
            },
            mdp2: {
                required: true,
                minlength: 5,
                equalTo: "#mdp"
            }
        },
        //For custom messages
        messages: {
            nom: {
                required: "Champ Requis"
            },
            prenom: {
                required: "Champ Requis"
            },
            mail: {
                required: "Champ Requis"
            },
            poids: {
                required: "Champ Requis"
            },
            taille: {
                required: "Champ Requis"
            },
            login: {
                required: "Champ Requis"
            },
            mdp: {
                required: "Champ Requis"
            },
            mdp2: {
                required: "Champ Requis"
            }
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

        /// Vérifier les valeurs rentrées ?
    });


    // Méthode pour la vérification de la date
    $.validator.addMethod(
        "dated1",
        function(value, element) {
            var d1 = value.toString();
            var d2 = $("#d2").val();
            var test = true;
            if (parseInt(d1.substring(6,10)) > parseInt(d2.substring(6,10))) {
                test = false;
            } else {
                if (parseInt(d1.substring(6,10)) === parseInt(d2.substring(6,10))) {
                    if (parseInt(d1.substring(3,5)) > parseInt(d2.substring(3,5))) {
                        test = false;
                    } else {
                        if (parseInt(d1.substring(3,5)) === parseInt(d2.substring(3,5))) {
                            if (parseInt(d1.substring(0,2)) > parseInt(d2.substring(0,2))) {
                                test = false;
                            } else {
                                if (parseInt(d1.substring(0,2)) === parseInt(d2.substring(0,2))) {
                                    return true
                                }
                            }
                        }
                    }
                }
            }
            return test;
        },
        "La date doit être plus petite que d2"
    );


    $("#date").validate({
        rules: {
            d1: {
                required: true,
                dated1:true
            },
            d2: {
                required: true
            },
            errorElement: 'div',
            errorPlacement: function (error, element) {
                if (placement) {
                $(placement).append(error);
                } else {
                    error.insertAfter(element);
                }
            }
        }
    });
    
    
    
});
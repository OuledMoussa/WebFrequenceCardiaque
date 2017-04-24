$(document).ready(function(){
    // Vérifie les valeurs rentrées dans la page
    
    /*
    $('#inscription').click(function(){
        $("input").each(function(){
            alert("nom " + $(this).attr("name") + " valeur  = " + $(this).val());
        });
    });
    */

//   function verif() {
//    var form = document.forms[0];
//    // Compteur d'élement du formulaire
//    var i;
//    // Retour si erreur
//    var msg = "";
//    for (i = 0; form.length < i; i++) {
//        switch(form[i].name) {
//            case "poids":
//                if (0 < this.value ) {
//                    msg += "Le poids rentré est incorrect !";
//                } else if (this.value < 150) {
//                    msg += "Le poids rentré est incorrect !";
//                }
//                break;
//            case "taille":
//                if (50 < this.value ) {
//                    msg += "La taille rentrée est incorrecte !";
//                } else if (this.value < 250) {
//                    msg += "La taille rentrée est incorrecte !";
//                }
//                break;
//            case "ddn":
//
//                break;
//            default:
//        }
//    }
//    // Compare si les deux mots de passe sont identiques
//    var mdp1 = document.getElementById("mdp");
//    var mdp2 = document.getElementById("mdp2");
//    if (mdp1.value != mdp2.value) {
//        alert("les mots de passes sont différents");
//    }
//   }
//   document.getElementById("inscription").onclick = verif;
   
   
   $("#inscription").click(function(){
      $("#insc").submit();
   });
   
   $("#ddn_root").focusout(function() {
       // Récupère la date
       var date = $("#ddn").val();
       var ndate = date.split(" ");
       // Traite la date
       // Jour
       var jour = ndate[0];
       if (jour.length == 1) {
           jour = "0" + jour;
       }
       // Mois
       var mois = ndate[1].substr(0,ndate[1].length-1);
       switch(mois) {
           case "January":
               mois = "01";
               break;
           case "Februrary":
               mois = "02";
               break;
           case "March":
               mois = "03";
               break;
           case "April":
               mois = "04";
               break;
           case "May":
               mois = "05";
               break;
           case "June":
               mois = "06";
               break;
           case "July":
               mois = "07";
               break;
           case "August":
               mois = "08";
               break;
           case "September":
               mois = "09";
               break;
           case "October":
               mois = "10";
               break;
           case "November":
               mois = "11";
               break;
           case "December":
               mois = "12";
               break;
       }
       // An
       var an = ndate[2];
       // Date au format Français
       var dateFr = jour + "/" + mois + "/" + an;
       // Date actuelle
       var now = new Date();
       
       // Vérification de fausses dates
       if( Date.parse(dt) > now) {
           console.log("FR : " + Date.parse(dt));
           console.log("now : " + now);
           console.log("Fausse date!")
       } else {
           console.log("FR : " + Date.parse(dt));
           console.log("now : " + now);
           console.log("Bonne date !")
       }
       //console.log(dateFr);
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
                email:true
            },
            sexe: {
                required: true
            },
            poids: {
                required: true ,
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
            nom:{
                required: "Champ Requis"
            },
            prenom:{
                required: "Champ Requis"
            },
            mail:{
                required: "Champ Requis"
            },
            poids:{
                required: "Champ Requis"
            },
            taille:{
                required: "Champ Requis"
            },
            login:{
                required: "Champ Requis"
            },
            mdp:{
                required: "Champ Requis"
            },
            mdp2:{
                required: "Champ Requis"
            }
        },
        errorElement : 'div',
        errorPlacement: function(error, element) {
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
   
});
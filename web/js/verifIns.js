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
            ddn: {
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
            ddn:{
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
          var placement = $(element).toggleClass('invalid');
          var placement = $(element).data('error');
          if (placement) {
            $(placement).append(error);
          } else {
            error.insertAfter(element);
          }
        }
        
        /// Vérifier les valeurs rentrées
     });
   
});
$(document).ready(function(){
    // Anime les champs de formulaire
    Materialize.updateTextFields();

    // Dropdown
    $(".dropdown-button").dropdown();

    // Vue Mobile
    $('.button-collapse').sideNav({
      menuWidth: 300, // Default is 300
      edge: 'left', // Choose the horizontal origin
      closeOnClick: true, // Closes side-nav on <a> clicks, useful for Angular/Meteor
      draggable: true // Choose whether you can drag to open on touch screens
    }
  );
  
  // Calendrier
  $('.datepicker').pickadate({
    selectMonths: true, // Creates a dropdown to control month
    selectYears: 15 // Creates a dropdown of 15 years to control year
  });
  
  // Liste Déroulante
  $(document).ready(function() {
    $('select').material_select();
  }); 
   
   
});
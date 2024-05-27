$(document).ready(function(){
    $("#flip1").click(function(){
      $("#panel1").slideToggle("slow");
    });

    $("#flip2").click(function(){
        $("#panel2").slideToggle("slow");
      });

      $("#flip3").click(function(){
        $("#panel3").slideToggle("slow");
      });
  });

document.addEventListener('DOMContentLoaded', function() {
    var bouton = document.getElementById('parcourir');
    if (bouton) {
        bouton.addEventListener('click', function() {
            window.location.href = 'reservation.html';
        });
    } else {
        console.error('L\'élément avec l\'ID "parcourir" n\'a pas été trouvé.');
    }
});


document.addEventListener('DOMContentLoaded', function() {
    // Vérifier si l'utilisateur est connecté
    if(localStorage.getItem('loggedIn')) {
        // Afficher le bouton Profil
        document.getElementById('btn-profile').style.display = 'inline';
        // Masquer le bouton Se connecter
        document.getElementById('btn-login').style.display = 'none';
        // Afficher le bouton Se déconnecter
        document.getElementById('btn-logout').style.display = 'inline';
    } else {
        // Masquer le bouton Profil
        document.getElementById('btn-profile').style.display = 'none';
        // Afficher le bouton Se connecter
        document.getElementById('btn-login').style.display = 'inline';
        // Masquer le bouton Se déconnecter
        document.getElementById('btn-logout').style.display = 'none';
    }
});


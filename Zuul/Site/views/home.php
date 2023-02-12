<!DOCTYPE html>
<html lang="fr" dir="ltr">

<?php
ob_start();
$GLOBALS['title'] = 'Objectif Pirate';
 ?>



<head>
  <link rel="stylesheet" href="public/css/style.css">
  <script src="jquery-3.6.3.min.js"></script>
</head>

<body>

<!-- colonne droite -->

<!-- <div class="colonne_info">
  <p>Praeceps truculenti viam autem ut reducere haec lenitate similia autem feminea exitium deberet admovente ut truculenti ut feminea suadendo erga rettulimus haec autem regina truculenti admovente illius multa ut humanitatisque potius erga actibus veritatis quae regina similia feminea suadendo regina erga fortunas illius autem rettulimus actibus rettulimus mariti humanitatisque ad deberet feminea propositum scrutanda regina potius in stimulos ut exitium imperatoris reducere Maximini exitium praeceps mariti imperatoris fortunas suadendo suadendo Maximini cum haec trudebat feminea exitium scrutanda lenitate in actibus obstinatum multa scrutanda fortunas in ad ad admovente haec trudebat suadendo eum autem similia Maximini Maximini multa ut ad obstinatum. Si per clivos sublimes hoste firmare lapsantibus fortiter prensando sublimes arta nostri aut prensando aliquotiens pedites nullas ponderum lapsantibus prensando permissi necessitate nostri ponderum rupium fruticeta per periculose
  </p>
</div> -->

<!-- Fin colonne droite -->


<!-- texte -->
<!-- <p class="description">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec ex risus, cursus vel ullamcorper id, condimentum et ante. Interdum et malesuada fames ac ante ipsum primis in faucibus. Fusce in ultricies erat. Aenean nec est enim. Vestibulum eu accumsan velit, in tincidunt elit. Suspendisse pellentesque ligula at sagittis porttitor. Sed faucibus dui sed massa ullamcorper, vel consectetur tortor dictum. Morbi varius varius est, euismod fermentum orci pulvinar quis. Quisque varius scelerisque scelerisque. Nullam eleifend orci dapibus libero sagittis vulputate. Vivamus quam ex, ultrices elementum erat ut, finibus condimentum lorem. Sed semper, magna fermentum imperdiet tempor, felis arcu dignissim justo, quis interdum massa nisi id libero. Aenean nisi ante, aliquam consequat molestie ac, rutrum eget mi. Phasellus quis laoreet mi. </p> -->

</body>

<script>
function autoScale() {
  // AUTO-SCALE SCRIPT
  // B.Crauet - 2015

  /********************
  *** CONFIGURATION ***
  ********************/

  // Query selector pour l'objet cible
  var asContainerQuery = "#conteneur";

  // Le script peut-il agrandir l'objet cible?
  var asCanUpscale = true;

  // Centrer l'objet (uniquement pour la position:absolue)
  var asCenterObject = true;

  /*****************
  *** INITIALISER ***
  *****************/

  // Nouveau point de coordonnées (X et Y)
  var asNewX, asNewY;

  // Ratio (fenêtre et conteneur)
  var ratioWindow, ratioContainer;

  // Nouvelle échelle calculée
  var asNewScale;

  /***********
  *** CODE ***
  ***********/

  // Obtenir les tailles du conteneur
  var asContainerW = $(asContainerQuery).width();
  var asContainerH = $(asContainerQuery).height();

  // Obtenir les tailles de la fenêtre
  var asWindowW = $("body").width();
  var asWindowH = $("body").height();

  // Calculer les ratios
  ratioWindow = asWindowW / asWindowH;
  ratioContainer = asContainerW / asContainerH;

  // Ratio fenêtre < ratio objet
  if (ratioWindow < ratioContainer)
    // Calculer l'échelle avec la LARGEUR
    asNewScale = asWindowW / asContainerW;
  else
    asNewScale = asWindowH / asContainerH;

  // Pouvons-nous agrandir le conteneur?
  if (asNewScale > 1 && !asCanUpscale)
    // Nous ne pouvons pas agrandir le conteneur. Limiter l'échelle à 1
    asNewScale = 1;

  // Mettre à jour l'échelle
  $(asContainerQuery)
    .css("transform", "scale(" + asNewScale + ")")
    .css("transform-origin", "0 0");

  // Mettre à jour les nouvelles tailles de l'objet
  asContainerW = $(asContainerQuery).width();
  asContainerH = $(asContainerQuery).height();

  // Pouvons-nous centrer l'objet?
  if (asCenterObject) {
    // Calculer les points de coordonnées X et Y
    asNewX = asWindowW / 2 - asContainerW / 2;
    asNewY = asWindowH / 2 - asContainerH / 2;

    $(asContainerQuery)
      .css("position", "absolute")
      .css("left", asNewX)
      .css("top", asNewY);
  }
}

$(window).resize(function() {
  autoScale();
});

  </script>

 <?php
$GLOBALS['content'] = ob_get_clean();
?>

<?php require("views/template/background.php"); ?>

<?php require("views/template/template.php"); ?>


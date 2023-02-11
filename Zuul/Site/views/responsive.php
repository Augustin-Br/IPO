<!doctype html>
<html lang="fr">
<?php
ob_start();
$GLOBALS['title'] = 'Responsive';
 ?>
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="public/css/audio.css" />

  </head>
  <body>

    <!-- colonne droite -->

    <div class="colonne_info">
      <p>Praeceps truculenti viam autem ut reducere haec lenitate similia autem feminea exitium deberet admovente ut truculenti ut feminea suadendo erga rettulimus haec autem regina truculenti admovente illius multa ut humanitatisque potius erga actibus veritatis quae regina similia feminea suadendo regina erga fortunas illius autem rettulimus actibus rettulimus mariti humanitatisque ad deberet feminea propositum scrutanda regina potius in stimulos ut exitium imperatoris reducere Maximini exitium praeceps mariti imperatoris fortunas suadendo suadendo Maximini cum haec trudebat feminea exitium scrutanda lenitate in actibus obstinatum multa scrutanda fortunas in ad ad admovente haec trudebat suadendo eum autem similia Maximini Maximini multa ut ad obstinatum. Si per clivos sublimes hoste firmare lapsantibus fortiter prensando sublimes arta nostri aut prensando aliquotiens pedites nullas ponderum lapsantibus prensando permissi necessitate nostri ponderum rupium fruticeta per periculose
      </p>
    </div>

    <!-- Fin colonne droite -->


    <!-- Partie Podcats -->

    <img id="image_presentation" src="public\img\abstract-smooth-dark-blue-with-black-vignette-studio-well-use-as-background-business-report-digital-website-template-backdrop.jpg">

    <audio controls id="player">
        <source src="https://cdn.plyr.io/static/demo/Kishi_Bashi_-_It_All_Began_With_a_Burst.ogg" type="audio/ogg">
        <source src="https://cdn.plyr.io/static/demo/Kishi_Bashi_-_It_All_Began_With_a_Burst.mp3" type="audio/mpeg">
        Your browser does not support the audio element.-- CodeXD - India
    </audio>

    <script src="https://cdn.jsdelivr.net/gh/CDNSFree2/Plyr/plyr.min.js"></script>

    <!-- Fin Partie Podcats -->

    <!-- miniature -->
    <img id="miniature" src="public/img/miniature.png">
    <!-- Fin de la partie miniature -->

    <!-- Description Podcats -->
    <p id="description">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec ex risus, cursus vel ullamcorper id, condimentum et ante. Interdum et malesuada fames ac ante ipsum primis in faucibus. Fusce in ultricies erat. Aenean nec est enim. Vestibulum eu accumsan velit, in tincidunt elit. Suspendisse pellentesque ligula at sagittis porttitor. Sed faucibus dui sed massa ullamcorper, vel consectetur tortor dictum. Morbi varius varius est, euismod fermentum orci pulvinar quis. Quisque varius scelerisque scelerisque. Nullam eleifend orci dapibus libero sagittis vulputate. Vivamus quam ex, ultrices elementum erat ut, finibus condimentum lorem. Sed semper, magna fermentum imperdiet tempor, felis arcu dignissim justo, quis interdum massa nisi id libero. Aenean nisi ante, aliquam consequat molestie ac, rutrum eget mi. Phasellus quis laoreet mi. </p>
    <!-- Fin Description Podcats -->


    <!-- Optional JavaScript; choose one of the two! -->

    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

    <!-- Option 2: Separate Popper and Bootstrap JS -->
    <!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
    -->
  </body>

  <?php
 $GLOBALS['content'] = ob_get_clean();
 ?>

</html>

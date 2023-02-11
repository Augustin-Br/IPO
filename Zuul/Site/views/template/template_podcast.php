<head>
  <!-- Docs styles -->
<link rel="stylesheet" href="public/css/audio.css" />
<title><?= $GLOBALS['title'] ?></title>
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
    <source src=<?= $GLOBALS['src'] ?> type="audio/mpeg">
</audio>

<script src="https://cdn.jsdelivr.net/gh/CDNSFree2/Plyr/plyr.min.js"></script>

<!-- Fin Partie Podcats -->

<!-- miniature -->
<img id="miniature" src="public/img/miniature.png">
<!-- Fin de la partie miniature -->

<!-- Description Podcats -->
<p id="description">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec ex risus, cursus vel ullamcorper id, condimentum et ante. Interdum et malesuada fames ac ante ipsum primis in faucibus. Fusce in ultricies erat. Aenean nec est enim. Vestibulum eu accumsan velit, in tincidunt elit. Suspendisse pellentesque ligula at sagittis porttitor. Sed faucibus dui sed massa ullamcorper, vel consectetur tortor dictum. Morbi varius varius est, euismod fermentum orci pulvinar quis. Quisque varius scelerisque scelerisque. Nullam eleifend orci dapibus libero sagittis vulputate. Vivamus quam ex, ultrices elementum erat ut, finibus condimentum lorem. Sed semper, magna fermentum imperdiet tempor, felis arcu dignissim justo, quis interdum massa nisi id libero. Aenean nisi ante, aliquam consequat molestie ac, rutrum eget mi. Phasellus quis laoreet mi. </p>
<!-- Fin Description Podcats -->

</body>
 <?php
$GLOBALS['content'] = ob_get_clean();
?>

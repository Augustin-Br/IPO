<?php
ob_start();
$GLOBALS['title'] = 'Copyright';
?>

<!-- Animation background html + css réalisée par Goodkatz (codepen) https://codepen.io/goodkatz/pen/LYPGxQz-->
<!-- Menu html + css SthéffaneNunes (codepen) https://codepen.io/StheffaneNunes/pen/oNxzPxE -->
<!-- Police Burger menu : Google Fonts : Raleway, Light 300 -->

<?php
$GLOBALS['content'] = ob_get_clean();
?>


<?php require("views/template/background.php"); ?>
<?php require("views/template/template.php"); ?>
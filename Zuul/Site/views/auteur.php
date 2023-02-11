<?php
ob_start();
$GLOBALS['title'] = 'Équipe';
?>

<?php
$GLOBALS['content'] = ob_get_clean();
?>

<?php require("views/template/template.php"); ?>
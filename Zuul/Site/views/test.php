<?php
ob_start();
$GLOBALS['title'] = 'Test';
?>

<?php
$GLOBALS['content'] = ob_get_clean();
?>


<?php require("views/template/background.php"); ?>
<?php require("views/template/template.php"); ?>

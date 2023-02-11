<?php
ob_start();
$GLOBALS['title'] = 'Page 2';
?>

<!-- recherche d'un fichier dans le dossier audio -->




<?php
if ($handle = opendir('public/audio/')) {
    while (false !== ($entry = readdir($handle))) {
        if ($entry != "." && $entry != "..") {
            echo "$entry\n";
        }
    }
    closedir($handle);
}

?>




<?php
$GLOBALS['content'] = ob_get_clean();
?>

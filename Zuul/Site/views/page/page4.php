<?php
ob_start();
$GLOBALS['title'] = 'Page 4';
?>

<div class="background">
<p>Coucou</p>
</div>

<?php
$GLOBALS['content'] = ob_get_clean();
?>

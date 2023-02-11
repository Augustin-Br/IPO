<?php
ob_start();
$GLOBALS['title'] = 'Page 3';
?>

<div class="background">
<p>Coucou</p>
</div>


<?php
$GLOBALS['content'] = ob_get_clean();
?>

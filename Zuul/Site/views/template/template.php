<!DOCTYPE html>
<html lang="fr" dir="ltr">
  <head>
    <meta charset="utf-8" name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="public/css/style.css">
    <link rel="icon" type="image/png" sizes="16x16" href="https://img.icons8.com/windows/32/null/pirates-of-the-caribbean.png">
    <title><?= $GLOBALS['title'] ?></title>
  </head>
  <header>
      <!-- <div class="logo">Logo</div> -->
      <!-- <div class="bandeau">Bandeau</div> -->
      <h1 class="title">Objectif Pirate</h1>
  </header>
  <body>
    <?php require("views/template/navbar.php"); ?>
    <?= $GLOBALS['content'] ?>


  </body>

</html>



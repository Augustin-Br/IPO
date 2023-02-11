<?php

// URL de base pour les routes
$base_url = '/';

// Tableau associatif qui mappe les URL avec les noms de vues
$routes = [
  '' => 'home.php',
  'auteur' => 'auteur.php',
  'test' => 'test.php',
  'copyright' => 'copyright.php',
];

// Récupère le chemin d'URL après la base
$path = str_replace($base_url, '', $_SERVER['REQUEST_URI']);

// Si la route demandée est trouvée dans le tableau de routes, utilisez la vue associée
if (array_key_exists($path, $routes)) {
  $view = 'views/' . $routes[$path];
  if (file_exists($view)) {
    include $view;
    exit;
  }
}

// Sinon, renvoie une erreur 404
http_response_code(404);
include 'views/404.php';


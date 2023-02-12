<link rel="stylesheet" href="public\css\style.css">
<head>

  <style>
    
    .container {
      position: fixed;
      width: 80px;
      height: 80px;
      top: 50px;
      left:50px;
      z-index: 301;
    }
    @media (orientation: portrait) {
      .container {
        visibility: hidden;
      }
    }

    .sword1 {
      width: 80%;
      height: 80%;
      transform: rotate(-45deg);
      background-image: url("public/img/icons8-saber-weapon-96-1.png");
      background-repeat: no-repeat;
      background-size: contain;
      transition: transform 0.25s ease-in-out;
      margin-right: -20px;
    }

    .sword2 {
      width: 80%;
      height: 80%;
      transform: rotate(45deg);
      background-image: url("public/img/icons8-saber-weapon-96-2.png");
      background-repeat: no-repeat;
      background-size: contain;
      transition: transform 0.25s ease-in-out;
      margin-left: -20px;
    }

    .crossed-swords1 {
      transform: rotate(180deg);
    }
    .crossed-swords2 {
      transform: rotate(0deg);
    }

    button {
      display: flex;
      justify-content: center;
      align-items: center;
      width: 100px;
      height: 100px;
      border: none;
      background-color: transparent;
      cursor: pointer;
    }
   
    
  </style>
</head>
<body>
  <div class="container">
    <button id="cross-swords-button">
      <div class="sword1"></div>
      <div class="sword2"></div>
    </button>
  </div>




<div class="navigation">
      <input type="checkbox" class="navigation__checkbox" id="nav-toggle">
      <label for="nav-toggle" class="navigation__button">
        <span class="navigation__icon" aria-label="toggle navigation menu"></span>
      </label>
      <div class="navigation__background"></div>

      <nav class="navigation__nav" role="navigation">
        <ul class="navigation__list">
          <li class="navigation__item">
            <a href="http://localhost/" class="navigation__link">Accueil</a>
          </li>
          <li class="navigation__item">
            <a href="http://localhost/telechargement" class="navigation__link">Jouer !!!</a>
          </li>
          <li class="navigation__item">
            <a href="http://localhost/test" class="navigation__link">Page 1</a>
          </li>
          <li class="navigation__item">
            <a href="http://localhost/page2" class="navigation__link">Page 2</a>
          </li>
          <li class="navigation__item">
            <a href="http://localhost/responsive" class="navigation__link">Responsive Test</a>
          </li>
          <li class="navigation__item">
            <a href="http://localhost/galerie" class="navigation__link">Galerie</a>
          </li>
          <li class="navigation__item">
            <a href="#" class="navigation__link">Info</a>
          </li>
    </ul>
  </nav>
</div>

<script>
    const button = document.querySelector("#cross-swords-button");
    const swords = document.querySelectorAll(".sword1, .sword2");
    const navigationCheckbox = document.querySelector("input.navigation__checkbox");

    button.addEventListener("click", () => {
      swords.forEach(sword => {
        sword.classList.toggle("crossed-swords1");
        sword.classList.toggle("crossed-swords2");
      });
      navigationCheckbox.checked = !navigationCheckbox.checked;
    });
  </script>


</body>

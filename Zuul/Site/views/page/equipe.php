<?php
ob_start();
$GLOBALS['title'] = 'Équipe';
?>

<link rel="stylesheet" href="public\css\bootstrap.css">

<ul class="list-group">
  <a class="list-group-item list-group-item-action d-flex align-items-center" href="https://github.com/CleZReD">
        <img src="https://avatars.githubusercontent.com/u/83187808?v=4" alt="@CleZReD" width="32" height="32" class="rounded me-2" loading="lazy">
        <span>
          <strong>Bellier Clément</strong> @CleZReD
        </span>
    </a>
    <a class="list-group-item list-group-item-action d-flex align-items-center" href="https://github.com/Neajflow">
          <img src="https://avatars.githubusercontent.com/u/82968018?v=4" alt="@Neajflow" width="32" height="32" class="rounded me-2" loading="lazy">
          <span>
            <strong>Boufort Jean</strong> @Neajflow
          </span>
    </a>
    <a class="list-group-item list-group-item-action d-flex align-items-center" href="https://github.com/tchar829">
          <img src="https://avatars.githubusercontent.com/u/74729782?v=4" alt="@tchar829" width="32" height="32" class="rounded me-2" loading="lazy">
          <span>
            <strong>Gervot--Guerchet Charlie</strong> @tchar829
          </span>
    </a>
    <a class="list-group-item list-group-item-action d-flex align-items-center" href="https://github.com/Augustin-Br">
          <img src="https://avatars.githubusercontent.com/u/78374917?v=4" alt="@tchar829" width="32" height="32" class="rounded me-2" loading="lazy">
          <span>
            <strong>Brenner Augustin</strong> @Augustin-Br
          </span>
    </a>
</ul>


<!--

<a class="list-group-item list-group-item-action d-flex align-items-center" href="https://github.com/mdo">
      <img src="https://github.com/mdo.png" alt="@mdo" width="32" height="32" class="rounded me-2" loading="lazy">
      <span>
        <strong>Mark Otto</strong> @mdo
      </span>
    </a>

-->

<?php
$GLOBALS['content'] = ob_get_clean();
?>

<?php
// tu napisz kody funkcji podanych w zadaniu
?>

<html>

<head>
  <meta charset="utf-8">
  <title>Oblicz cenę</title>
  <style>
    body {
      background-color: yellow;
      color: #000FFF;
    }

    input {
      text-align: center;
    }

    td {
      text-align: center;
    }
  </style>
</head>

<body>
  <br>

  <form method='GET' action=''>
    <table width='70%' border=1>
      <tr>
        <td width=20%>Cena brutto <input type=text name='brutto' size=15> zł </td>
        <td width=15%>VAT [%] <input type=text name='vat' size=5> </td>
        <td width=10%> <input type=submit value='Oblicz'> </td>
      </tr>
      <tr>
        <td colspan=2> <b>

            <?php
            // tu napisz kod rozwiązujący zadanie (wykorzystaj napisane wcześniej funkcje)     
            ?>

          </b> </td>

      </tr>
    </table>
  </form>

</body>

</html>
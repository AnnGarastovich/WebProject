<html>
<head>
<title>Profile</title>
<meta http-equiv="Content-Type" content = "text/jsp;charset=utf-8"/>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<ul>
    <li><a href="Profil.jsp">Main</a></li>
    <li><a href="Menu.jsp">List of food</a>
    <li><a href="Trenirovki.jsp">List of trainings</a></li>
    <li><a href="Dnevnik.jsp">Profil</a></li>
</ul>
<div id="Zapisi">
<p> Date:<%= (String) (request.getAttribute("Data")) %></p>
</div>
<input type="button" name="addzapis" id="AddZapisFood" value="Add a dish"></input>
<input type="button" name="addzapis" id="AddZapisTrenirovka" value="Add a trainig"></input>
<input type="button" name="addwater" id="AddWater" value="Add water"></input>

</body>
</html>

<html>
<head>
<title>Profile</title>
<meta http-equiv="Content-Type" content = "text/jsp;charset=utf-8"/>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<ul>
    <li><a href="http://localhost:8080/Profil" class="menu">Main</a></li>
    <li><a href="http://localhost:8080/Menu" class="menu">List of food</a>
    <li><a href="http://localhost:8080/Trenirovki" class="menu">List of trainings</a></li>
    <li><a href="http://localhost:8080/Dnevnik" class="menu">Profil</a></li>
</ul>
<div id="Zapisi">
<p> Date:<%= (String) (request.getAttribute("Data")) %></p>
</div>
<div id="button">
<a href="http://localhost:8080/AddUserFoodForm" >Add Food</a>
</div>
<div id="buttonTraining">
<a href="http://localhost:8080/AddUserTrainingForm" >Add Training</a>
</div>
<div id="buttonWater">
 <a href="http://localhost:8080/AddWater" >Add Water</a>
 </div>
</body>
</html>

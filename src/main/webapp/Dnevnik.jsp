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
Water:<%
 java.util.List number=(java.util.List)(request.getAttribute("Name"));
 for(int i=0;i<=number.size()-1;i++)
 {
 %>
 <%= ((launch.BD_WaterBalance) number.get(i)).getData()%>
  <%= ((launch.BD_WaterBalance) number.get(i)).getAmountOfDrinks()%>
 <%} %>
 Food:
 <%
  java.util.List numbers=(java.util.List)(request.getAttribute("NameUser"));
  for(int i=0;i<=numbers.size()-1;i++)
  {
  %>
  <%= ((launch.BD_UserFood) numbers.get(i)).getData()%>
   <%= ((launch.BD_UserFood) numbers.get(i)).getNumberOfCalories()%>
  <%} %>
  Trainings:
   <%
    java.util.List numberts=(java.util.List)(request.getAttribute("NameTraining"));
   for(int i=0;i<=numberts.size()-1;i++)
     {
     %>
<%= ((launch.BD_UserTrainings) numberts.get(i)).getData()%>
      <%= ((launch.BD_UserTrainings) numberts.get(i)).getNumbersOfCaloriesBurned()%>
     <%} %>
</div>
<div id="button">
<a href="http://localhost:8080/AddUserFoodForm" >Add Food</a>
</div>
<div id="buttonTraining">
<a href="http://localhost:8080/AddUserTrenirovkiForm" >Add Training</a>
</div>
<div id="buttonWater">
 <a href="http://localhost:8080/AddWater" >Add Water</a>
 </div>
</body>
</html>

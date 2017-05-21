<html>
<head>
<title>List of trainings </title>
<meta http-equiv="Content-Type" content = "text/html;charset=utf-8"/>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<ul>
    <li><a href="http://localhost:8080/Profil" class="menu">Main</a></li>
    <li><a href="http://localhost:8080/Menu" class="menu">List of food</a>
    <li><a href="http://localhost:8080/Trenirovki" class="menu">List of trainings</a></li>
    <li><a href="http://localhost:8080/Dnevnik" class="menu">Profil</a></li>
</ul>
<form name="searchtrenirovkiform" action="/TrenirovkiSearch" method="get">
<input type="text" name="searchtrenirovki"  size="35" id="SearchTrenirovki" placeholder="Name of the training"></input>
<input type="submit" name="searchtrenirovkibutton" id="SearchTrenirovkiButton" value="Search"></input>
<form>
<div id="button">
<a href="http://localhost:8080/AddTrenirovkiForm" >Add</a>
</div>
 <%
 java.util.List number=(java.util.List)(request.getAttribute("Name"));
 for(int i=0;i<=number.size()-1;i++)
 {
 %>
 <%= ((launch.BD_ListOfTrainings) number.get(i)).getName()%>
  <%= ((launch.BD_ListOfTrainings) number.get(i)).getAmountOfCaloriesBurnedIn10min()%>

 <%} %>
</body>
</html>

<html>
<body>
444
 <h2> <%= (String) (request.getAttribute("TestName")) %></h2>
 <%
 java.util.List number=(java.util.List)(request.getAttribute("Name"));
 for(int i=0;i<=number.size()-1;i++)
 {
 %>
 <%= ((launch.BD_User) number.get(i))%>
 <%} %>

</body>
</html>
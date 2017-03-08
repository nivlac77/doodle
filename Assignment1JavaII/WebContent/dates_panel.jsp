<%@ page import="java.util.*, MyBeans.*" %>


<% 
ArrayList<Detail> storedDetails = (ArrayList<Detail>) session.getAttribute("details");
%>
<aside>
<table>
<tr>
<th>Dates:</th>
</tr>
<%
if(storedDetails != null){
	for(Detail d : storedDetails){
		out.print("<tr>");
		out.print("<form action=\"DateDelete\"><td><input type=\"text\" name=\"dateToDelete\" value=\"" + d.getDate() + "\"/> <input type=\"submit\" value=\"delete\"/></td></form>");
		out.print("</tr>");
	}	
}
%>
</table>
</aside>
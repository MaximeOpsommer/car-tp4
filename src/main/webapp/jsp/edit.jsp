<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bibliothèque en ligne : Editer</title>
</head>
<body>

	<h1>Detail d'un livre :</h1>

	<% String titre = (String)request.getAttribute("title"); 
		String auteur = (String)request.getAttribute("author");
		String annee = (String)request.getAttribute("year"); 
		
		
		out.print("<form method=\"POST\" action=\"/edit\">");
		out.print("	<input type=\"text\" name=\"title\" value=\""+  titre  + "\">");
		out.print("	<input type=\"text\" name=\"author\" value=\""+  auteur  + "\">");
		out.print("	<input type=\"text\" name=\"year\" value=\""+  annee  + "\">");
		out.print("	<input type=\"submit\" value=\"Ajouter au panier\">");
		
		out.print("</form>");
		
		
		%>
	
	</form>
</body>
</html>
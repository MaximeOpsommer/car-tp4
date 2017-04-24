<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bibliothèque en ligne : Editer</title>

<link rel="stylesheet" type="text/css" href="css/book.css">

</head>
<body>

	<h1>Detail d'un livre :</h1>

	<% String titre = (String)request.getAttribute("title"); 
		String auteur = (String)request.getAttribute("author");
		String annee = (String)request.getAttribute("year"); 
		int quantity = Integer.parseInt((String)request.getAttribute("quantity"));
		
		
		out.print("<form method=\"POST\" action=\"/ajouterAuPanier\">");
		out.print("	<input readonly type=\"text\" name=\"title\" value=\""+  titre  + "\">");
		out.print("	<input readonly type=\"text\" name=\"author\" value=\""+  auteur  + "\">");
		out.print("	<input readonly type=\"text\" name=\"year\" value=\""+  annee  + "\">");
		if(quantity > 0){
			out.print("	<input type=\"submit\" value=\"Ajouter au panier\">");
		} else {
			out.print("<label class=\"nonDispo\">Ce livre n'est plus disponible actuellement</label>");
		}
		
		out.print("</form>");
		
		
		%>
	
	</form>
</body>
</html>
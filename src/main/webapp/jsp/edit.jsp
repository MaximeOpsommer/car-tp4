<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bibliothèque en ligne : Editer</title>
</head>
<body>

	<h1>Editer un livre :</h1>

	<% String titre = request.getParameter("titre"); %>
	<% String auteur = request.getParameter("auteur"); %>

	<form method="POST" action="edit">
		<label>Titre</label><input type="text" name="titre" value="<%= titre %>"> <br />
		<label>Auteur</label><input type="text" name="auteur" value="<%= auteur %>"> <br />
		<input type="submit" value="Edit" />
	</form>
</body>
</html>
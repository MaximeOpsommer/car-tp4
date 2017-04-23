<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bibliothèque en ligne : Créer</title>
</head>
<body>

	<h1>Créer un livre :</h1>

	<form method="POST" action="create">
		<label>Titre</label><input type="text" name="titre"> <br />
		<label>Auteur</label><input type="text" name="auteur"> <br />
		<label>Année</label><input type="number" name="annee"> <br />
		<input type="submit" value="Créer" />
	</form>
</body>
</html>
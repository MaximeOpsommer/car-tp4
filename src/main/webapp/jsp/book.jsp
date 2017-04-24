<%@page import="car.tp4.entity.Book"%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Set"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap-theme.css">
<link rel="stylesheet" type="text/css"
	href="css/bootstrap-theme.min.css">

<link rel="stylesheet" type="text/css" href="css/book.css">

<script src="../js/bootstrap.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/jquery-3.2.1.js"></script>
<script src="../js/npm.js"></script>


<title>Home</title>
</head>
<body>
	<h2>Existing books</h2>

	<%
		Collection<Book> books = (Collection<Book>) request.getAttribute("books");

		Set<String> auteurs = new HashSet<String>();

		for (Book b : books) {
			auteurs.add(b.getAuthor());
		}
		List<String> auteursTries = new ArrayList<String>(auteurs);
		Collections.sort(auteursTries);
	%>

	<br>

	<div class="row">
		<label>Titre</label> <input type="text" id="recherche-titre">
		<label>Auteur</label> <select id="selectedAuthor">
			<option selected value>-- Choisissez un auteur --</option>
			<%
				for (String str : auteursTries) {
					out.print("<option>" + str + "</option>");
				}
			%>
		</select>
	</div>

	<br>

	<table id="table">
		<thead>
			<tr>
				<th>Author</th>
				<th>Title</th>
				<th><label>Year</label> <a> <span id="yearSorting"
						class="glyphicon glyphicon-chevron-down"></span>
				</a></th>
				<th>Quantité disponible</th>
				<th>Détail</th>
			</tr>
		</thead>
		<tbody>

			<%
				for (Book book : books) {
					out.print("<tr>");
					out.print("<td>" + book.getAuthor() + "</td>");
					out.print("<td>" + book.getTitle() + "</td>");
					out.print("<td>" + book.getYear() + "</td>");
					out.print("<td>" + book.getQuantity() + "</td>");

					// bouton détail
					out.print("<td><form method=\"GET\" action=\"/edit\">");
					out.print("<input hidden name=\"id\" value=\"" + book.getId() + "\"></div>");
					out.print("<input type=\"submit\" value=\"Detail\">");
					out.print("</form></td>");

					out.print("</tr>");
				}
			%>
		</tbody>

	</table>


	<form id="createForm" action="create">
		<input type="submit" value="Create book">
	</form>


	<br>
	<!-- panier -->
	<table>
		<thead>
			<th>PANIER</th>
		</thead>
		<tbody>
			<%
				Collection<Book> panier = (Collection<Book>) request.getAttribute("panier");

				for (Book book : panier) {
					out.print("<tr>");
					out.print("<td>" + book.getAuthor() + ", " + book.getTitle() + ", " + book.getYear() + "</td>");
					out.print("<td><form method=\"POST\" action=\"/supprimerDuPanier\">"+
										"<input hidden name=\"id\" value=\""+ book.getId() +"\">"+
										"<input type=\"submit\" value=\" X \">"+
								   "</form></td>");
					out.print("</tr>");
				}
			%>
		</tbody>
	</table>
	<%
		if(!panier.isEmpty()){
			out.print("<div>"+
					"<form method=\"POST\" action=\"/passerCommande\">"+
					"<input type=\"submit\" value=\"Passer la commande\">"+
				"</form>"+
			"</div>");
		}
	
	%>
	
	


	<script>
        TriParAnnee("desc");

		// Filtrage par titre
		$("#recherche-titre").on("change keydown keypress keyup", function() {
			$("#table > tbody > tr > td:nth-child(2)").each(function() {
				var text = $(this).html();
				if (text.indexOf($("#recherche-titre").val()) >= 0)
					$(this).parent().show();
				else
					$(this).parent().hide();
			});
		});

		// Tri par annee
		$("#yearSorting").click(function() {
			if ($(this).hasClass("glyphicon-chevron-down")) {
				$(this).removeClass("glyphicon-chevron-down");
				$(this).addClass("glyphicon-chevron-up");
				TriParAnnee("asc");
			} else {
				$(this).removeClass("glyphicon-chevron-up");
				$(this).addClass("glyphicon-chevron-down");
				TriParAnnee("desc");
			}
		});

		function TriParAnnee(order) {
			
			var asc = order === "asc";
			var rows = $('#table tbody  tr').get();

			rows.sort(function(a, b) {

				var A = $(a).children('td').eq(2).text();
				var B = $(b).children('td').eq(2).text();

				if (A < B) {
					if (asc)
						return -1;
					else
						return 1;
				}

				if (A > B) {
					if (asc)
						return 1;
					else
						return -1;
				}

				return 0;

			});

			$.each(rows, function(index, row) {
				$('#table').children('tbody').append(row);
			});
		}
		
		$("#selectedAuthor").change(function() {
							
			var author = $(this).find(":selected").text();
			
			$("#table > tbody > tr > td:nth-child(1)").each(function() {
				var selectedIndex = $("#selectedAuthor").find(":selected").index();
				var text = $(this).html();
				if(selectedIndex === 0 || author === text)
					$(this).parent().show();
				else
					$(this).parent().hide();
			});
		});
        	
        
        </script>


</body>
</html>

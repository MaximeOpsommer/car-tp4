<%@page import="car.tp4.entity.Book"%>
<%@page import="java.util.Collection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/book.css">
        <script src="../js/jquery-3.2.1.js"></script>
        <title>Home</title>
    </head>
    <body>
        <h2>Existing books</h2>
        
        <br>
        
        <label>Titre</label><input type="text" id="recherche-titre">
        
        <br>
        
        <table id="table">
        	<thead>
        		<tr>
        			<th>Author</th>
        			<th>Title</th>
        		</tr>
        	</thead>
        	<tbody>
        		<%
		            Collection<Book> books = (Collection<Book>) request.getAttribute("books");
		
		            for (Book book: books) {
		                out.print("<tr>");
		                out.print("<td>" + book.getAuthor() + "</td>");
		                out.print("<td>" + book.getTitle() + "</td>");
		                
		                // bouton Editer
		                out.print("<td><form method=\"GET\" action=\"edit?id=" + book.getId() + "\">");
		                	out.print("<div name=\"id\" value=\"" + book.getId() + "\"></div>");
			    		    out.print("<input type=\"submit\" value=\"Edit\">");
			    		out.print("</form></td>");
			    		
			    		//bouton ajouter au panier
			    		out.print("<td><form method=\"POST\" action=\"ajouterAuPanier?id=" + book.getId() + "\">");
		                	out.print("<div name=\"id\" value=\"" + book.getId() + "\"></div>");
			    		    out.print("<input type=\"submit\" value=\"Ajouter au panier\">");
			    		out.print("</form></td>");
			    		
		                out.print("</tr>");
		            }
		        %>
        	</tbody>
        	
        
        </table>
        
        <form action="create">
		    <input type="submit" value="Create book">
		</form>
		
        
        <a href="/panier">Voir mon panier</a>
        
        <script>
        	
        	$("#recherche-titre").on("change keydown keypress keyup", function() {
        		$("#table > tbody > tr > td:nth-child(2)").each(function() {
        			var text = $(this).html();
        			if(text.indexOf($("#recherche-titre").val()) >= 0)
        				$(this).parent().show();
        			else
        				$(this).parent().hide();
        		});
        	});
        
        </script>
        
        
    </body>
</html>

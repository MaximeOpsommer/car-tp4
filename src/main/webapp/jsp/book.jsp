<%@page import="car.tp4.entity.Book"%>
<%@page import="java.util.Collection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="css/bootstrap-theme.css">
        <link rel="stylesheet" type="text/css" href="css/bootstrap-theme.min.css">
        
        <link rel="stylesheet" type="text/css" href="css/book.css">
        
        <script src="../js/bootstrap.js"></script>
        <script src="../js/bootstrap.min.js"></script>
        <script src="../js/jquery-3.2.1.js"></script>
        <script src="../js/npm.js"></script>
        
        
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
        			<th>
        				<label>Year</label>
        				<a>
        					<span id="yearSorting" class="glyphicon glyphicon-chevron-down"></span>
        				</a>
        			</th>
        			<th>Edit</th>
        		</tr>
        	</thead>
        	<tbody>
        		<%
		            Collection<Book> books = (Collection<Book>) request.getAttribute("books");
		
		            for (Book book: books) {
		                out.print("<tr>");
		                out.print("<td>" + book.getAuthor() + "</td>");
		                out.print("<td>" + book.getTitle() + "</td>");
		                out.print("<td>" + book.getYear() + "</td>");
		                
		                // bouton Editer
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
        		<th>
        			PANIER
        		</th>
        	</thead>
        	<tbody>
        		<%
		            Collection<Book> panier = (Collection<Book>) request.getAttribute("panier");
		
		            for (Book book: panier) {
		                out.print("<tr>");
		                out.print("<td>" + book.getAuthor() + ", "+ book.getTitle() + ", " + book.getYear() + "</td>");
		                out.print("</tr>");
		            }
		        %>
        	</tbody>
        </table>
        
        
        <script>
        	
       		triParAnnee("desc");
        
        	// Filtrage par titre
        	$("#recherche-titre").on("change keydown keypress keyup", function() {
        		$("#table > tbody > tr > td:nth-child(2)").each(function() {
        			var text = $(this).html();
        			if(text.indexOf($("#recherche-titre").val()) >= 0)
        				$(this).parent().show();
        			else
        				$(this).parent().hide();
        		});
        	});
        	
        	// Tri par annee
        	$("#yearSorting").click(function() {
        		if($(this).hasClass("glyphicon-chevron-down")) {
        			$(this).removeClass("glyphicon-chevron-down");
        			$(this).addClass("glyphicon-chevron-up");
        			triParAnnee("asc");
        		} else {
        			$(this).removeClass("glyphicon-chevron-up");
        			$(this).addClass("glyphicon-chevron-down");
        			triParAnnee("desc");
        		}
        	});
        	
        	function triParAnnee(order) {
        		var asc = order === "asc";
        		var tbody = $("#table").find("tbody");
        		
        		tbody.find("tr").sort(function(a, b) {
        			if (asc) {
        	            return $('td:first', a).text().localeCompare($('td:nth-child(3)', b).text());
        	        } else {
        	            return $('td:first', b).text().localeCompare($('td:nth-child(3)', a).text());
        	        }
        		}).appendTo(tbody);
        	}
        	
        	$("#button-addPanier").click(function(){
        	<%-- 	var id = $(this).data("id");
        		<% 
        		
        			for(Book b : books) {
        				if(Long.parseLong(%>id<%).equals(b.getId())) {
        					
        				}
        			}
        		%> --%>
        		
        	});
        
        </script>
        
        
    </body>
</html>

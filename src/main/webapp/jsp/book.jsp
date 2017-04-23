<%@page import="car.tp4.entity.Book"%>
<%@page import="java.util.Collection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/book.css">
        <title>Home</title>
    </head>
    <body>
        <h2>Existing books</h2>
        
        <table>
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
		                out.print("</tr>");
		            }
		        %>
        	</tbody>
        	
        
        </table>
        
        <form action="create">
		    <input type="submit" value="Create book">
		</form>
        
        
    </body>
</html>

<%@page import="car.tp4.entity.Book"%>
<%@page import="java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Panier</h2>
	<table id="panier">
        	<thead>
        		<tr>
        			<th>Author</th>
        			<th>Title</th>
        		</tr>
        	</thead>
        	<tbody>
        		<%
		            Collection<Book> books = (Collection<Book>) request.getAttribute("panier");
		
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
</body>
</html>
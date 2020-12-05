<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="data.Libro" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/index.css">
</head>
<body>
<table> 
         <tr> 
          <th><b>ISBN</b></th> 
          <th><b>Título</b></th> 
          <th><b>Autor</b></th> 
         </tr> 
         <%ArrayList<Libro> libros=(ArrayList<Libro>)request.getAttribute("libros"); 
        for(Libro l:libros){%> 
            <tr> 
                <td><%=l.getIsbn()%></td> 
                <td><%=l.getTitulo()%></td> 
                <td><%=l.getAutor()%></td> 
            </tr> 
            
            <%}%> 
        </table>  



<!--  
<form action="insertar"  method="post">
	ISBN:<input type="text" name="isbn">
	Titulo:<input type="text" name="titulo">
	Autor:<input type="text" name="autor">
	<input type="submit">
</form>
-->
</body>
</html>
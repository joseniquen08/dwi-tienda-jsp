<%@page import="proyecto_final.beans.Articulo"%>
<%@page import="java.util.List"%>
<%@page import="proyecto_final.dao.DAOArticulo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Articulos</title>
<link rel="stylesheet" type="text/css" href="resources/css/global.css" >
<link rel="stylesheet" type="text/css" href="resources/css/clientes.css" >
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" />
<link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
</head>
<body>
	<%
		DAOArticulo dao = new DAOArticulo();
		List<Articulo> lst = dao.infoArticulo();
	%>
    <div class="menu">
		<h1>REGISTRO DE ARTÍCULOS</h1>
		<a href="./" class="btn-back">Regresar</a>
	</div>
	<div class="botonesGestionar">
		<a href="articulo/ingresar.jsp">INGRESAR NUEVO ARTÍCULO</a>
		<a href="articulo/editar.jsp">EDITAR ARTÍCULO</a>
	</div>
    <div class="tablaContenedor">
		<div class="cuerpo">
			<table>
				<thead>
        			<tr>
        				<th>ID</th>
			            <th>Nombre</th>
			            <th>Tipo</th>
			            <th>Talla</th>
			            <th>Color</th>
			            <th>Marca</th>
			            <th>Precio</th>
			            <th>Stock</th>
			        </tr>
				</thead>
				<tbody>
				<% int i = 1; %>
				<% for (Articulo a:lst) { %>
					<% if (i % 2 != 0) { %>
						<tr class="tdImpar">
					<% } else { %>
						<tr class="tdPar">
					<% } %>
							<td><%= a.getId() %></td>
							<td><%= a.getNombre() %></td>
							<td><%= a.getTipo() %></td>
							<td><%= a.getTalla() %></td>
							<td><%= a.getColor() %></td>
							<td><%= a.getMarca() %></td>
							<td><%= a.getPrecio() %></td>
							<td><%= a.getStock() %></td>
						</tr>
				<% i++;} %>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
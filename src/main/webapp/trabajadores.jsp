<%@page import="proyecto_final.beans.Trabajador"%>
<%@page import="proyecto_final.dao.DAOTrabajador"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Trabajadores</title>
<link rel="stylesheet" type="text/css" href="resources/css/global.css" >
<link rel="stylesheet" type="text/css" href="resources/css/clientes.css" >
<link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
</head>
<body>
	<% 
		DAOTrabajador dao = new DAOTrabajador();
		List<Trabajador> lst= dao.infoTrabajadores();
	%>
	<div class="menu">
		<h1>REGISTRO DE TRABAJADORES</h1>
		<a href="./" class="btn-back">Regresar</a>
	</div>
	<div class="botonesGestionar">
		<a href="trabajador/ingresar.jsp">INGRESAR NUEVO TRABAJADOR</a>
		<a href="trabajador/editar.jsp">EDITAR TRABAJADOR</a>
	</div>
	<div class="tablaContenedor">	
		<div class="cuerpo">
			<table>
				<thead>
					<tr>
						<th>ID</th>
						<th>Nombre</th>
						<th>DNI</th>
						<th>Sede</th>
						<th>Cargo</th>
					</tr>
				</thead>
				<tbody>
				<% int i = 1; %>
				<% for (Trabajador c:lst) { %>
					<% if (i % 2 != 0) { %>
						<tr class="tdImpar">
					<% } else { %>
						<tr class="tdPar">
					<% } %>
							<td><%= c.getId() %></td>
							<td><%= c.getNombre() %></td>
							<td><%= c.getDni() %></td>
							<td><%= c.getSede() %></td>
							<td><%= c.getCargo() %></td>
						</tr>
				<% i++;} %>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>


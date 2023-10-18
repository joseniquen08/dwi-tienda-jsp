<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar Artículo</title>
<link rel="stylesheet" type="text/css" href="../resources/css/global.css" >
<link rel="stylesheet" type="text/css" href="../resources/css/clientes.css" >
<link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
</head>
<body>
	<div class="menu">
		<h1>INGRESAR NUEVOS DATOS ACTUALIZADOS</h1>
		<a href="../articulos.jsp" class="btn-back">Regresar</a>
	</div>
	<div class="formContainer">
		<form action="ServletPOSTArticuloEdit" method="POST">
			<div class="form-control">
				<label>Ingrese ID del artículo:</label>
				<input type="text" name="idE"/>
			</div>
			<hr/>
			<div class="form-control">
				<label>NOMBRE:</label>
				<input type="text" name="nombreE"/>
			</div>
			<div class="form-control">
				<label>TIPO:</label>
				<input type="text" name="tipoE"/>
			</div>
			<div class="form-control">
				<label>TALLA:</label>
				<input type="text" name="tallaE"/>
			</div>
			<div class="form-control">
				<label>COLOR:</label>
				<input type="text" name="colorE"/>
			</div>
			<div class="form-control">
				<label>MARCA:</label>
				<input type="text" name="marcaE"/>
			</div>
			<div class="form-control">
				<label>PRECIO:</label>
				<input type="text" name="precioE"/>
			</div>
			<div class="form-control">
				<label>STOCK:</label>
				<input type="text" name="stockE"/>
			</div>
			<div class="form-control">
				<button type="submit">Actualizar</button>
			</div>
		</form>
	</div>
</body>
</html>
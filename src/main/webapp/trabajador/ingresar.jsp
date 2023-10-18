<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ingresar Trabajadador</title>
<link rel="stylesheet" type="text/css" href="../resources/css/global.css" >
<link rel="stylesheet" type="text/css" href="../resources/css/clientes.css" >
<link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
</head>
<body>
	<div class="menu">
		<h1>INGRESAR LOS DATOS PARA AÑADIR UN NUEVO TRABAJADOR</h1>
		<a href="../trabajadores.jsp" class="btn-back">Regresar</a>
	</div>
	<div class="formContainer">
		<form action="ServletPOSTTrabajadorNuevo" method="POST">
			<div class="form-control">
				<label>ID:</label>
				<input type="text" required autocomplete="off" name="id"/>
			</div>
			<div class="form-control">
				<label>NOMBRE:</label>
				<input type="text" required autocomplete="off" name="nombre"/>
			</div>
			<div class="form-control">
				<label>DNI:</label>
				<input type="text" required autocomplete="off" name="dni"/>
			</div>
			<div class="form-control">
				<label>SEDE:</label>
				<input type="text" required autocomplete="off" name="sede"/>
			</div>
			<div class="form-control">
				<label>CARGO:</label>
				<input type="text" required autocomplete="off" name="cargo"/>
			</div>
			<div class="form-control">
				<button type="submit">Ingresar</button>
			</div>
		</form>
	</div>
</body>
</html>
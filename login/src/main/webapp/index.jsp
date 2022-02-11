<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>LOGIN</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <form action="usuario" method="post">
    <section class="form-login">
        <h5>FORMULARIO LOGIN</h5>
        <input class="controls" type="text" name="Usuario" value="" placeholder="Usuario">
        <input class="controls" type="password" name="Contrasena" value="" placeholder="Contrasena">
        <input class="buttons" type="submit" name="" value="Ingresar" >
        <p><a href="#">¿Olvidaste tu Contrasena?</a></p>
    </section>
        <div>
			<p>
				<%
					String resultado = (String)request.getAttribute("mensaje");
					String mensaje = "";
					if (resultado != null) {
						mensaje = resultado;
					}
				%>
				<%=mensaje %>
			</p>
		</div>
    </form>
</body>
</html>
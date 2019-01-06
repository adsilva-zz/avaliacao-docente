<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="./css/efeitos.css" rel="stylesheet" media="screen">
<title>Avaliação Docente</title>
</head>
<body>
	<table class="corpo" width="100%" height="100%">
		<!-- Linha do topo -->
		<tr class="topo">
			<td align="right"><img alt="Logo" src="imagens/logo.png"
				width="200px" height="70px" /></td>

			<td width="500px" class="avaliacao">Avaliação&ensp;Docente</td>

			<td align="left"><img alt="Logo2"
				src="imagens/governo_estado.png" width="200px" height="53px" /></td>
		</tr>
		
		<!-- Corpo do Site / Formulario -->
		<tr class="meio">
			<td colspan="3"><form:form action="logar" method="post"
					commandName="logar">
					<center>
						<table>
							<tr>
								<td style="padding: 8px"><label for="usuario"><b>Usuário:</b></label></td>
								<td style="padding: 8px"><form:input path="login_usuario"
										id="usuario" /> <form:errors path="login_usuario"
										cssClass="erros" element="div" /></td>
							</tr>
							<tr>
								<td style="padding: 8px"><label for="senha"><b>Senha:</b></label></td>
								<td style="padding: 8px"><form:password
										path="senha_usuario" id="senha" /> <form:errors
										path="senha_usuario" cssClass="erros" element="div" /></td>
							</tr>

							<tr align="center">
								<td style="padding: 8px" class="erros" colspan="3">${invalido
									}</td>
							</tr>

							<tr align="center">
								<td colspan="3"><input type="submit" value="Acessar"></td>
							</tr>
						</table>
					</center>
				</form:form></td>
		</tr>
		
		<!-- Linha do Rodape -->
		<tr height="50px" class="rodape">
			<td colspan="3" width="1348px"><img alt="Logo"
				src="imagens/cps.png" width="400px" height="50px" /></td>
		</tr>
		
	</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form:form action="editarcoordenador" commandName="usuario" method="post">
			<table>
				<tr>
					<td><form:input path="id_usuario" value="${usuario.id_usuario}" type="hidden"/></td>
				</tr>
			
				<tr class="meio">
					<td><form:label path="nome_usuario"><b>Nome:</b></form:label></td>
					<td><form:input path="nome_usuario"/>
					<form:errors path="nome_usuario" cssClass="erros" element="div" /></td>
				</tr>
				
				<tr class="meio">
					<td><form:label path="tipo_usuario"><b>Tipo Usuario:</b></form:label></td>
					<td><form:input path="tipo_usuario"/>
					<form:errors path="tipo_usuario" cssClass="erros" element="div"></form:errors></td>
				</tr>
				
				<tr>
					<td><form:label path="curso.id_curso"><b>Código do Curso:</b></form:label></td>
					<td><form:input path="curso.id_curso"/>
					<form:errors path="curso.id_curso" cssClass="erros" element="div"></form:errors></td>
				</tr>
				
				<tr>
					<td><form:label path="curso.nome_curso"><b>Nome do Curso:</b></form:label></td>
					<td><form:input path="curso.nome_curso"/>
					<form:errors path="curso.nome_curso" cssClass="erros" element="div"></form:errors></td>
				</tr>
				
				<tr class="meio">
					<td><form:label path="data_ini"><b>Ano de inicio:</b></form:label></td>
					<td><form:input path="data_ini"/>
					<form:errors path="data_ini" cssClass="erros" element="div"></form:errors></td>
				</tr>
				
				<tr class="meio">
					<td><form:label path="logar.login_usuario"><b>Login:</b></form:label></td>
					<td><form:input path="logar.login_usuario"/>
					<form:errors path="logar.login_usuario" cssClass="erros" element="div"></form:errors></td>
				</tr>
				
				<tr>
					<td><form:label path="logar.senha_usuario"><b>Senha:</b></form:label></td>
					<td><form:password path="logar.senha_usuario"/>
					<form:errors path="logar.senha_usuario" cssClass="erros" element="div"></form:errors></td>
				</tr>
				
				<tr align="center" class="meio">
					<td style="padding: 8px" class="erros" colspan="3">${param.mensagem}</td>
					<td style="padding: 8px" class="erros" colspan="3">${errado}</td>
				</tr>
				
				<tr>
					<td colspan="3">
							<input type="submit" class="btn btn-primary" value="Editar">
							<input type="submit" class="btn btn-default" value="Cancelar"  formaction="./administrador?pagina=cadcoordenador">
					</td>
				</tr>
				
			</table>
		</form:form>
</body>
</html>
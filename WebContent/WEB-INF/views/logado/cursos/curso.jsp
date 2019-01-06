<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Avaliação Docente</title>
</head>
<body>
	<center>
		<!-- Corpo do Site / Formulario -->
		<form:form action="adicionacurso" commandName="curso" method="post">
			<table>
				<tr class="meio">
					<td><form:label path="id_curso"><b>Código do Curso</b></form:label></td>
					<td><form:input path="id_curso" />
					<form:errors path="id_curso" cssClass="erros" element="div"/></td>
					
					<td><form:label path="nome_curso"><b>Nome do Curso:</b></form:label></td>
					<td><form:input path="nome_curso"/> 
					<form:errors path="nome_curso" cssClass="erros" element="div" /></td>
					
					<td colspan="3"><input type="submit" value="Salvar"></td>
				</tr>

				<tr align="center" class="meio">
					<td style="padding: 8px" class="erros" colspan="3">${param.mensagem}</td>
					<td style="padding: 8px" class="erros" colspan="3">${errado}</td>
				</tr>
			</table>
		</form:form>

		<table>
			<tr class="meio">
				<td>Cursos:</td>
				<td>Editar</td>
				<td>Excluir</td>
			</tr>

			<tbody>
				<c:forEach items="${cursos}" var="curso">
					<tr>
						<td>${curso.nome_curso}</td>
						<td><a href = "./administrador?pagina=exibircurso&id_curso=${curso.id_curso}">Editar</a></td>
						<td><a href = "./removercurso?id_curso=${curso.id_curso}">Excluir</a></td>
					<tr>
				</c:forEach>
			</tbody>
		</table>
	</center>
</body>
</html>
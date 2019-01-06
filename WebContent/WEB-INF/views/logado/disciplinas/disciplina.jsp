<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<!-- Corpo do Site / Formulario -->
		<form:form action="adicionadisciplina" commandName="disciplina" method="post">
			<table>
				<tr class="meio">
					<td><form:label path="nome_disciplina"><b>Nome da Disciplina:</b></form:label></td>
					<td><form:input path="nome_disciplina"/> 
					<form:errors path="nome_disciplina" cssClass="erros" element="div" /></td>
					
					<td><form:label path="periodo_disciplina" ><b>Periodo:</b></form:label></td>
					<td><form:select path="periodo_disciplina">
   						<form:options items="${periodos}" />
						</form:select>
						<form:errors path="periodo_disciplina" cssClass="erros" element="div" />
					</td>
					
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
				<td>Disciplina:</td>
				<td>Periodo:</td>
				<td>Editar</td>
				<td>Excluir</td>
			</tr>

			<tbody>
				<c:forEach items="${disciplinas}" var="disciplina">
					<tr>
						<td>${disciplina.nome_disciplina}</td>
						<td>${disciplina.periodo_disciplina}</td>
						<td><a href="./coordenador?pagina=exibirdisciplina&id_disciplina=${disciplina.id_disciplina}">Editar</a></td>
						<td><a href="./removerdisciplina?id_disciplina=${disciplina.id_disciplina}">Excluir</a></td>
					<tr>
				</c:forEach>
			</tbody>
		</table>
	</center>
</body>
</html>
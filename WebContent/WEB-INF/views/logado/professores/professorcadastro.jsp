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
	<form:form action="adicionaprofessor" commandName="professor"
		method="post">
		<table>
			<tr>
				<td>
					<table>
						<tr class="meio">
							<td><form:label path="nome_professor">
									<b>Nome do Professor:</b>
								</form:label></td>
							<td><form:input path="nome_professor" /> <form:errors
									path="nome_professor" cssClass="erros" element="div" /></td>
						</tr>

						<tr align="center" class="meio">
							<td style="padding: 8px" class="erros" colspan="3">${param.mensagem}</td>
							<td style="padding: 8px" class="erros" colspan="3">${errado}</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr class="meio">
				<td>Disciplina:</td>
				<td>Periodo:</td>
			</tr>

			<tbody>
				<c:forEach items="${disciplinas}" var="disciplina">
					<tr>
						<td><input name="disciplina" type="checkbox" value="${disciplina.id_disciplina }" /> 
							${disciplina.nome_disciplina}</td>
						<td>${disciplina.periodo_disciplina}</td>
					<tr>
				</c:forEach>
			</tbody>
			
			<tr>
				<td colspan="3"><input type="submit" value="Salvar"></td>
			</tr>
			
		</table>
	</form:form>
</body>
</html>
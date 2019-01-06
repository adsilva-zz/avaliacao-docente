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
		<form:form action="adicionapergunta" commandName="pergunta" method="post">
			<table>
				<tr class="meio">
					<td><label for="cadastrarpergunta"><b>Pergunta:</b></label></td>
					<td><form:textarea path="pergunta" id="cadastrarpergunta" /></br>
					<form:errors path="pergunta" cssClass="erros" element="div" /></td>
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
				<td>Perguntas:</td>
				<td>Editar</td>
				<td>Excluir</td>
			</tr>

			<tbody>
				<c:forEach items="${perguntas}" var="perg">
					<tr>
						<td>${perg.pergunta}</td>
						<td><a href = "./administrador?pagina=exibirpergunta&id_pergunta=${perg.id_pergunta}">Editar</a></td>
						<td><a href = "./removerpergunta?id_pergunta=${perg.id_pergunta}">Excluir</a></td>
					<tr>
				</c:forEach>
			</tbody>
		</table>
	</center>
</body>
</html>
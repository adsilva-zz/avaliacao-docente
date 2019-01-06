<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Editar Pergunta - ${perg.id_pergunta}</h3>

	<form:form action="editarpergunta" commandName="pergunta" methodo="post">
		<table>
			<tr class="meio">
				<td><input name="id_pergunta" value="${perg.id_pergunta}" type="hidden"/></td>
				<td><label for="editarpergunta"><b>Pergunta:</b></label></td>
				<td><form:errors path="pergunta" cssClass="text-warning"
						element="div" />
					<form:input path="pergunta" cssClass="erros" /></td>
			</tr>
			<tr>
				<td colspan="3">
					<center>
						<input type="submit" class="btn btn-primary" value="Editar">
						<input type="submit" class="btn btn-default" value="Cancelar">
					</center>
				</td>
			</tr>
		</table>
	</form:form>

</body>
</html>
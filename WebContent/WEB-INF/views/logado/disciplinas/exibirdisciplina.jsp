<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Editando Disciplina ${disciplina.id_disciplina }</h3>

	<form:form action="editardisciplina" commandName="disciplina" methodo="post">
		<table>
			<tr class="meio">
				<td><form:input path="id_disciplina" value="${disciplina.id_disciplina}" type="hidden"/></td>
				<td><form:label path="nome_disciplina"><b>Nome da Disciplina:</b></form:label></td>
				<td><form:input path="nome_disciplina" /><br>
					<form:errors path="nome_disciplina" cssClass="erros" element="div" /></td>
			
				<td><form:label path="periodo_disciplina" ><b>Periodo:</b></form:label></td>
				<td><form:select path="periodo_disciplina" >
   					<form:options items="${periodos}"/>
					</form:select>
					<form:errors path="periodo_disciplina" cssClass="erros" element="div" />
				</td>
			</tr>
			
			<tr>
				<td colspan="3">
						<input type="submit" class="btn btn-primary" value="Editar">
						<input type="submit" class="btn btn-default" value="Cancelar"  formaction="./coordenador?pagina=disciplina">
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>
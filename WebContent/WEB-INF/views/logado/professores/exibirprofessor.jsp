<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<form:form action="editarprofessor" commandName="professor" methodo="post">
		<table>
			<tr class="meio">
				<td><form:input path="id_professor" value="${professor.id_professor}" type="hidden"/></td>		
			</tr>
			
			<tr class="meio">
				<td><form:label path="nome_professor"><b>Nome:</b></form:label></td>
				<td><form:input path="nome_professor"/>
				<form:errors path="*" cssClass="erros" element="div"></form:errors></td>
			</tr>
		</table>
		
		<table>
			<tr class="meio">
				<td>Disciplina:</td>
				<td>Periodo:</td>
			</tr>

			<tbody>
				<c:forEach items="${alldisc}" var="disciplina">
					<tr>
						<td><input name="disciplina" type="checkbox" value="${disciplina.id_disciplina }" ${disciplina.contem==true?'checked="checked"':''}/> 
							${disciplina.nome_disciplina}</td>
						<td>${disciplina.periodo_disciplina}</td>
					<tr>
				</c:forEach>
			</tbody>
			
			<tr>
				<td colspan="3"><input type="submit" value="Salvar"></td>
				<td><input type="submit" class="btn btn-default" value="Cancelar"  formaction="./coordenador?pagina=professor"/></td>
			</tr>
			
		</table>
	</form:form>
</body>
</html>

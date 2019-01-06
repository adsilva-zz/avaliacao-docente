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
		<table>
			<tr>
				<td><a href="./coordenador?pagina=professorcadastro">Cadastro de Professores</a></td>
			</tr>
		
			<tr align="center" class="meio">
				<td style="padding: 8px" class="erros" colspan="3">${param.mensagem}</td>
				<td style="padding: 8px" class="erros" colspan="3">${errado}</td>
			</tr>
		
			<tr class="meio">
				<td>Professor:</td>
				<td>Editar</td>
				<td>Excluir</td>
			</tr>

			<tbody>
				<c:forEach items="${professores}" var="professor">
					<tr>
						<td>${professor.nome_professor}</td>
						<td><a href="./coordenador?pagina=exibirprofessor&id_professor=${professor.id_professor}">Editar</a></td>
						<td><a href="./removerprofessor?id_professor=${professor.id_professor}">Excluir</a></td>
					<tr>
				</c:forEach>
			</tbody>
		</table>
</body>
</html>
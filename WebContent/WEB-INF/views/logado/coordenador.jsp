<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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

		<!-- Linha Menu -->
		<tr class="menu">
			<td colspan="3">
				<center>
					<table>
						<tr>
							<td id="menulinha">
								<ul>
									<li>Bem vindo(a):&emsp;${logado.nome_usuario}</li>
									<li>&emsp;&emsp;&emsp;&emsp;<a href="./coordenador?pagina=disciplina">Disciplinas</a></li>
									<li>&emsp;&emsp;&emsp;&emsp;<a href="./coordenador?pagina=professor">Professores</a></li>
									<li>&emsp;&emsp;&emsp;&emsp;<a href="./coordenador?pagina=alunos">Alunos</a></li>
									<li>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
										<a href="sair">Sair</a>
									</li>
								</ul>
							</td>
						</tr>
					</table>
				</center>
			</td>
		</tr>

		<!-- Corpo do Site -->
		<tr class="meio">
			<td colspan="3">

				<center>
					<table>
						<tr>
							<td>
								<%
									String pagina = request.getParameter("pagina");
									if (pagina == null || pagina.isEmpty())
										pagina = "./home.jsp";
									else
										pagina = "/" + pagina;
								%> 
								<jsp:include page="<%=pagina%>">
									<jsp:param name="mensagem" value="${param.mensagem }"/>
								</jsp:include>
							</td>
						</tr>
					</table>
				</center>
			</td>
		</tr>

		<!-- Linha do Rodape -->
		<tr height="50px" class="rodape">
			<td colspan="3" width="1348px"><img alt="Logo"
				src="imagens/cps.png" width="400px" height="50px" /></td>
		</tr>
	</table>
</body>
</html>
<!DOCTYPE html>
<html lang="pt">
    <head>
        <meta charset="UTF-8">
        <title>P�gina restrita</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilo.css">
    </head>
    <body>
        <nav>
            <ul>
                <li><a href="${pageContext.request.contextPath}/index.jsp">P�gina inicial</a></li>
                <!-- <li><a href="${pageContext.request.contextPath}${URL_BASE}/CidadeControlador?opcao=cancelar">Cidade</a></li> -->
                <!-- <li><a href="${pageContext.request.contextPath}${URL_BASE}/FuncionarioControlador?opcao=cancelar">Funcion�rio</a></li> -->
                <li><a href="${pageContext.request.contextPath}${URL_BASE}/VeiculoControlador?opcao=cancelar">Ve�culo</a></li>
                <li><a href="${pageContext.request.contextPath}${URL_BASE}/SeguradoraControlador?opcao=cancelar">Seguradora</a></li>
                <li><a href="${pageContext.request.contextPath}${URL_BASE}/AssistenciaControlador?opcao=cancelar">Assist�ncia</a></li>
                <li><a href="${pageContext.request.contextPath}${URL_BASE}/FormularioSeguradoControlador?opcao=cancelar">Formul�rio Segurado</a></li>
                <li><a href="${pageContext.request.contextPath}${URL_BASE}/BonusControlador?opcao=cancelar">B�nus</a></li>
                <li><a href="${pageContext.request.contextPath}${URL_BASE}/SeguradoControlador?opcao=cancelar">Segurado</a></li>




                <li><a href="${pageContext.request.contextPath}${URL_BASE}/LogoutControlador">Logout</a></li>
            </ul>
        </nav>

        <h1>�rea restrita do sistema, cadastros</h1>

    </body>
</html>

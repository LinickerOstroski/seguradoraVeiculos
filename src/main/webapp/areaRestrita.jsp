<!DOCTYPE html>
<html lang="pt">
    <head>
        <meta charset="UTF-8">
        <title>Página restrita</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilo.css">
    </head>
    <body>
        <nav>
            <ul>
                <li><a href="${pageContext.request.contextPath}/index.jsp">Página inicial</a></li>
                <!-- <li><a href="${pageContext.request.contextPath}${URL_BASE}/CidadeControlador?opcao=cancelar">Cidade</a></li> -->
                <!-- <li><a href="${pageContext.request.contextPath}${URL_BASE}/FuncionarioControlador?opcao=cancelar">Funcionário</a></li> -->
                <li><a href="${pageContext.request.contextPath}${URL_BASE}/VeiculoControlador?opcao=cancelar">Veículo</a></li>
                <li><a href="${pageContext.request.contextPath}${URL_BASE}/SeguradoraControlador?opcao=cancelar">Seguradora</a></li>
                <li><a href="${pageContext.request.contextPath}${URL_BASE}/AssistenciaControlador?opcao=cancelar">Assistência</a></li>
                <li><a href="${pageContext.request.contextPath}${URL_BASE}/FormularioSeguradoControlador?opcao=cancelar">Formulário Segurado</a></li>
                <li><a href="${pageContext.request.contextPath}${URL_BASE}/BonusControlador?opcao=cancelar">Bônus</a></li>
                <li><a href="${pageContext.request.contextPath}${URL_BASE}/SeguradoControlador?opcao=cancelar">Segurado</a></li>




                <li><a href="${pageContext.request.contextPath}${URL_BASE}/LogoutControlador">Logout</a></li>
            </ul>
        </nav>

        <h1>Área restrita do sistema, cadastros</h1>

    </body>
</html>

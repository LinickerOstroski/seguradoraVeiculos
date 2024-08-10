<!DOCTYPE html>
<html lang="pt">
    <head>
        <meta charset="UTF-8">
        <title>Página Principal</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilo.css">
    </head>
    <body>
       
        <nav>
            <ul>
                <li><a href="${pageContext.request.contextPath}/index.jsp">Home</a></li>
                <li><a href="${pageContext.request.contextPath}${URL_BASE}/CidadeControlador?opcao=cancelar">Cidade</a></li>
                <li><a href="${pageContext.request.contextPath}${URL_BASE}/FuncionarioControlador?opcao=cancelar">Funcionário</a></li>
                <li><a href="${pageContext.request.contextPath}/login.jsp">Login</a></li>
                <li><a href="${pageContext.request.contextPath}${URL_BASE}/LogoutControlador">Logout</a></li>
                
            </ul>
        </nav>
    </body>
</html>

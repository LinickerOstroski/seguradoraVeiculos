<!DOCTYPE html>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Área Restrita</title>
    
    <style>
        /* Estilos básicos para o corpo da página */
        
        *{
            font-family: sans-serif, Verdana;
        }
        body {
            
            margin: 0;
            background-color: #f4f4f4;
        }

        /* Estilos para a barra de navegação */
        nav {
            background-color: #333;
            padding: 10px 20px;
            position: sticky;
            top: 0;
            z-index: 1000;
        }

        nav ul {
            font-size: 12px;
            list-style-type: none;
            padding: 0;
            margin: 0;
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
        }

        nav ul li {
            margin: 0 10px;
        }

        nav ul li a {
            color: #fff;
            text-decoration: none;
            font-weight: bold;
            padding: 10px 15px;
            display: block;
            border-radius: 5px;
            transition: background-color 0.1s ease;
        }

        nav ul li a:hover {
            background-color: #555;
            color: #ddd;
        }

        /* Estilos para o conteúdo principal */
        .container {
            max-width: 1200px;
            margin: 20px auto;
            padding: 20px;
            background: #fff;
            border-radius: 8px;
            box-shadow: 0 0 15px rgba(0,0,0,0.1);
            
            border-bottom: 2px solid rgb(27,77,227);
        }

        h1 {
            margin-top: 0;
            font-size: 32px;
            color: #333;
            text-align: center;
            padding-bottom: 10px;
            margin-bottom: 20px;
        }

        p {
            font-size: 18px;
            line-height: 1.6;
            text-align: center;
        }

        /* Estilos para a logo */
        .logo {
            position: fixed;
            bottom: 10px; /* Posiciona a logo a 10px do fundo */
            right: 10px;  /* Posiciona a logo a 10px da direita */
            z-index: 1000; /* Garante que a logo esteja sobre outros elementos */
        }

        .logo img {
            width: 150px; /* Ajuste o tamanho conforme necessário */
            height: auto;
        }
    </style>
</head>
<body>
    <!-- Logo posicionada no canto inferior direito -->
    <div class="logo">
        <img src="${pageContext.request.contextPath}/images/Logo.png" alt="Logo">
    </div>

    <nav>
        <ul>
            <li><a href="${pageContext.request.contextPath}/index.jsp">Página Inicial</a></li>
            <li><a href="${pageContext.request.contextPath}${URL_BASE}/VeiculoControlador?opcao=cancelar">Veículo</a></li>
            <li><a href="${pageContext.request.contextPath}${URL_BASE}/SeguradoraControlador?opcao=cancelar">Seguradora</a></li>
            <li><a href="${pageContext.request.contextPath}${URL_BASE}/AssistenciaControlador?opcao=cancelar">Assistência</a></li>
            <li><a href="${pageContext.request.contextPath}${URL_BASE}/FormularioSeguradoControlador?opcao=cancelar">Formulário Segurado</a></li>
            <li><a href="${pageContext.request.contextPath}${URL_BASE}/BonusControlador?opcao=cancelar">Bônus</a></li>
            <li><a href="${pageContext.request.contextPath}${URL_BASE}/SeguradoControlador?opcao=cancelar">Segurado</a></li>
            <li><a href="${pageContext.request.contextPath}${URL_BASE}/SeguroControlador?opcao=cancelar">Seguro</a></li>
             <li><a href="${pageContext.request.contextPath}${URL_BASE}/SinistroControlador?opcao=cancelar">Sinistro</a></li>
        </ul>
    </nav>
    
    <div class="container">
        <h1>Área Restrita do Sistema</h1>
        <p>Bem-vindo à área restrita. Aqui você pode acessar e gerenciar os diferentes módulos do sistema.</p>
    </div>
</body>
</html>

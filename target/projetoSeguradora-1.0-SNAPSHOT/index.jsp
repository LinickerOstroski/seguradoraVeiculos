<!DOCTYPE html>
<html lang="pt">
    <head>
        <title>Página inicial</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilo.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
        
        <meta charset="UTF-8">
        <meta name="viewport" content = "width=device-width,initial-scale=1.0,maximum-scale=1.0">
         
        
        <title>Barra Horizontal Fina</title>
        <style>
        .barra-horizontal {
            height: 1px; /* Altura da barra */
            width: 100%; /* Largura da barra */
            background-color: #ccc; /* Cor da barra */
            margin-top: 30px;
        }
        </style>
        
        
        
        
        
        
    </head>
    <body>
        <header>
            <div class = "center">
                <div class = "logo"> <img src="${pageContext.request.contextPath}/images/Logo.png" alt="Logo"></div>
                <div class = "menu">
                    <a href="#">Serviços</a>
                    <a href="#">Benefícios</a>
                    <a href="#">Depoimentos</a>
                    <a href="#">Contato</a>
                    <a href="#">FAQ</a>
                    <a href="${pageContext.request.contextPath}/paginaLogin.jsp">Área Restrita</a>
                    
                </div>
                    <div class="barra-horizontal"></div>    
            </div>
        </header>
        <section class = "home">
            
            <div class = "textoHome">
                <img src="${pageContext.request.contextPath}/images/TextoHome.png" alt="Ellipse">
                <br>
                <button class="botaoHome">Entrar em contato</button>
            </div>
                
               
            
            <div class = "carro">
                <img src="${pageContext.request.contextPath}/images/Carro.png" alt="Carro">
                
            </div>          
              
                
        </section >
                        

                
                
        <section class = "outros">
            
            <div class = "imagemOutros">
                <img src="${pageContext.request.contextPath}/images/Outros.png" alt="Informações">
            </div>
        </section>
                
        <section class = "compromisso">
            
            <div class = "imagemCompromisso">
                <img src="${pageContext.request.contextPath}/images/Group 39.png" alt="Informações">
            </div>
        </section>
                
      </body>
</html>

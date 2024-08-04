<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="areaRestrita.jsp" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>

    <script>

        function submitForm(opcaoValue) {

            document.getElementById("opcao").value = opcaoValue;
            document.getElementById("cadastroForm").submit();
        }
    </script>


    <body>
        <h1>Cadastro Seguradora</h1>
        <div>
            <form id="cadastroForm" name="cadastroForm" action="${pageContext.request.contextPath}${URL_BASE}/SeguradoraControlador" method="get">
                <input type="hidden" name="opcao" value="${opcao}" />
                <input type="hidden" name="idSeguradora" value="${idSeguradora}" />
                <p><label>Nome:</label> <input type="text" name="nomeSeguradora" value="${nomeSeguradora}" size="40" /> </p>
                <p><label>CNPJ:</label> <input type="text" name="cnpjSeguradora" value="${cnpjSeguradora}" size="40" /> </p>
                <p><label>Endereco:</label> <input type="text" name="enderecoSeguradora" value="${enderecoSeguradora}" size="40" /> </p>
                <p><label>Telefone:</label> <input type="text" name="telefoneSeguradora" value="${telefoneSeguradora}" size="40" /> </p>
                <p><label>Email:</label> <input type="text" name="emailSeguradora" value="${emailSeguradora}" size="40" /> </p>
                
                <td> 
                    <input type="submit" name="Salvar" value="Salvar"  /> 
                </td>
            </form>
          
                
            <form name="cancelarForm" action="${pageContext.request.contextPath}${URL_BASE}/SeguradoraControlador" method="get">
                <input type="hidden" name="opcao" value="cancelar" />
                <input type="submit" name="Cancelar" value="Cancelar" />
            </form>

            <form name="listarForm" action="${pageContext.request.contextPath}${URL_BASE}/SeguradoraControlador" method="get">
                <input type="hidden" name="opcao" value="listar" />
                <input type="submit" name="Listar" value="Listar" />
            </form>
        </div>
        ${mensagem}




        <h2>Lista de Seguradoras</h2>

        <!-- Exibindo a lista de veículos -->

        <table border="1">

            <!-- Verificando se a lista não está vazia -->

            <c:if test="${not empty seguradoras}">
                <tr>
                    <th>Nome</th>
                    <th>CNPJ</th>
                    <th>Endereço</th>
                    <th>Telefone</th>
                    <th>Email</th>
                    <th>Alterar</th>
                    <th>Excluir</th>
                </tr> 
            </c:if>

            <c:forEach var="seguradora" items="${seguradoras}">
                <tr>
                    <td>${seguradora.nomeSeguradora}</td>
                    <td>${seguradora.cnpjSeguradora}</td>
                    <td>${seguradora.enderecoSeguradora}</td>
                    <td>${seguradora.telefoneSeguradora}</td>
                    <td>${seguradora.emailSeguradora}</td>
                    
                    <td>
                        <form name="cadastroForm" action="${pageContext.request.contextPath}${URL_BASE}/SeguradoraControlador" method="get">
                            <input type="hidden" name="idSeguradora" value="${seguradora.idSeguradora}" >
                            <input type="hidden" name="nomeSeguradora" value="${seguradora.nomeSeguradora}" >
                            <input type="hidden" name="cnpjSeguradora" value="${seguradora.cnpjSeguradora}" >
                            <input type="hidden" name="enderecoSeguradora" value="${seguradora.enderecoSeguradora}" >
                            <input type="hidden" name="telefoneSeguradora" value="${seguradora.telefoneSeguradora}" >
                            <input type="hidden" name="emailSeguradora" value="${seguradora.emailSeguradora}" >
                            <input type="hidden" name="opcao" value="editar" >
                            <button type="submit">Editar</button>
                        </form>    
                    </td>
                    <td>
                        <form name="cadastroForm" action="${pageContext.request.contextPath}${URL_BASE}/SeguradoraControlador" method="get">
                            <input type="hidden" name="idSeguradora" value="${seguradora.idSeguradora}" >
                            <input type="hidden" name="nomeSeguradora" value="${seguradora.nomeSeguradora}" >
                            <input type="hidden" name="cnpjSeguradora" value="${seguradora.cnpjSeguradora}" >
                            <input type="hidden" name="enderecoSeguradora" value="${seguradora.enderecoSeguradora}" >
                            <input type="hidden" name="telefoneSeguradora" value="${seguradora.telefoneSeguradora}" >
                            <input type="hidden" name="emailSeguradora" value="${seguradora.emailSeguradora}" >
                            <input type="hidden" name="opcao" value="excluir" >
                            <button type="submit">Excluir</button>
                        </form>    
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>


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
        <h1>Cadastro de Veiculo</h1>
        <div>
            <form id="cadastroForm" name="cadastroForm" action="${pageContext.request.contextPath}${URL_BASE}/VeiculoControlador" method="get">
                <input type="hidden" name="opcao" value="${opcao}" />
                <input type="hidden" name="idVeiculo" value="${idVeiculo}" />
                <p><label>Placa do Veículo:</label> <input type="text" name="placaVeiculo" value="${placaVeiculo}" size="40" /> </p>
                <p><label>Fabricante do Veículo:</label> <input type="text" name="marcaVeiculo" value="${marcaVeiculo}" size="40" /> </p>
                <p><label>Modelo do Veículo:</label> <input type="text" name="modeloVeiculo" value="${modeloVeiculo}" size="40" /> </p>
                <p><label>Ano do Veículo:</label> <input type="text" name="anoVeiculo" value="${anoVeiculo}" size="40" /> </p>
                <p><label>Chassi do Veículo:</label> <input type="text" name="chassiVeiculo" value="${chassiVeiculo}" size="40" /> </p>
                <p><label>Capacidade total:</label> <input type="text" name="capacidadeVeiculo" value="${capacidadeVeiculo}" size="40" /> </p>
                <p><label>Categoria:</label> <input type="text" name="categoriaVeiculo" value="${categoriaVeiculo}" size="40" /> </p>
                <p><label>Cor predominante</label> <input type="text" name="corVeiculo" value="${corVeiculo}" size="40" /> </p>
                <p><label>Tabela fipe:</label> <input type="text" name="fipeVeiculo" value="${fipeVeiculo}" size="40" /> </p>
                <td> 
                    <input type="submit" name="Salvar" value="Salvar"  /> 
                </td>
            </form>
          
                
            <form name="cancelarForm" action="${pageContext.request.contextPath}${URL_BASE}/VeiculoControlador" method="get">
                <input type="hidden" name="opcao" value="cancelar" />
                <input type="submit" name="Cancelar" value="Cancelar" />
            </form>

        
        </div>
        ${mensagem}




        <h2>Lista de Veículos</h2>

        <!-- Exibindo a lista de veículos -->

        <table border="1">

            <!-- Verificando se a lista não está vazia -->

            <c:if test="${not empty veiculos}">
                <tr>
                    <th>Placa</th>
                    <th>Marca</th>
                    <th>Modelo</th>
                    <th>Ano</th>
                    <th>Chassi</th>
                    <th>Capacidade</th>
                    <th>Categoria</th>
                    <th>Cor</th>
                    <th>Fipe</th>
                    <th>Alterar</th>
                    <th>Excluir</th>
                </tr> 
            </c:if>

            <c:forEach var="veiculo" items="${veiculos}">
                <tr>
                    <td>${veiculo.placaVeiculo}</td>
                    <td>${veiculo.marcaVeiculo}</td>
                    <td>${veiculo.modeloVeiculo}</td>
                    <td>${veiculo.anoVeiculo}</td>
                    <td>${veiculo.chassiVeiculo}</td>
                    <td>${veiculo.capacidadeVeiculo}</td>
                    <td>${veiculo.categoriaVeiculo}</td>
                    <td>${veiculo.corVeiculo}</td>
                    <td>${veiculo.fipeVeiculo}</td>
                    <td>
                        <form name="cadastroForm" action="${pageContext.request.contextPath}${URL_BASE}/VeiculoControlador" method="get">
                            <input type="hidden" name="idVeiculo" value="${veiculo.idVeiculo}" >
                            <input type="hidden" name="placaVeiculo" value="${veiculo.placaVeiculo}" >
                            <input type="hidden" name="marcaVeiculo" value="${veiculo.marcaVeiculo}" >
                            <input type="hidden" name="modeloVeiculo" value="${veiculo.modeloVeiculo}" >
                            <input type="hidden" name="anoVeiculo" value="${veiculo.anoVeiculo}" >
                            <input type="hidden" name="chassiVeiculo" value="${veiculo.chassiVeiculo}" >
                            <input type="hidden" name="capacidadeVeiculo" value="${veiculo.capacidadeVeiculo}" >
                            <input type="hidden" name="categoriaVeiculo" value="${veiculo.categoriaVeiculo}" >
                            <input type="hidden" name="corVeiculo" value="${veiculo.corVeiculo}" >
                            <input type="hidden" name="fipeVeiculo" value="${veiculo.fipeVeiculo}" >
                            <input type="hidden" name="opcao" value="editar" >
                            <button type="submit">Editar</button>
                        </form>    
                    </td>
                    <td>
                        <form name="cadastroForm" action="${pageContext.request.contextPath}${URL_BASE}/VeiculoControlador" method="get">
                            <input type="hidden" name="idVeiculo" value="${veiculo.idVeiculo}" >
                            <input type="hidden" name="placaVeiculo" value="${veiculo.placaVeiculo}" >
                            <input type="hidden" name="marcaVeiculo" value="${veiculo.marcaVeiculo}" >
                            <input type="hidden" name="modeloVeiculo" value="${veiculo.modeloVeiculo}" >
                            <input type="hidden" name="anoVeiculo" value="${veiculo.anoVeiculo}" >
                            <input type="hidden" name="chassiVeiculo" value="${veiculo.chassiVeiculo}" >
                            <input type="hidden" name="capacidadeVeiculo" value="${veiculo.capacidadeVeiculo}" >
                            <input type="hidden" name="categoriaVeiculo" value="${veiculo.categoriaVeiculo}" >
                            <input type="hidden" name="corVeiculo" value="${veiculo.corVeiculo}" >
                            <input type="hidden" name="fipeVeiculo" value="${veiculo.fipeVeiculo}" >
                            <input type="hidden" name="opcao" value="excluir" >
                            <button type="submit">Excluir</button>
                        </form>    
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>


<%-- 
    Document   : CadastroCidade
    Created on : 8 de jul. de 2024, 21:42:09
    Author     : tulio
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="menu.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <h1>Cadastro Cidade</h1>
        <table>
            <form id="cadastroForm" name="cadastroForm" action="${pageContext.request.contextPath}${URL_BASE}/CidadeControlador" method="get">
                <input type="hidden" name="opcao" value="${opcao}" />
                <input type="hidden" name="codigoCidade" value="${codigoCidade}" />
                <p><label>Cidade:</label> <input type="text" name="nomeCidade" value="${nomeCidade}" size="40" /> </p>
                <p><label>UF:</label> <input type="text" name="ufCidade" value="${ufCidade}" size="5" /> </p>
                <td> 
                    <input type="submit" value="Salvar" name="Salvar"  /> 
                </td>
            </form>

            <form  name="cadastroForm" action="${pageContext.request.contextPath}${URL_BASE}/CidadeControlador" method="get">
                <td>
                    <input type="submit" value="Cancelar" name="Cancelar"  />
                </td>
                <input type="hidden" name="opcao" value="cancelar" />
            </form>
        </table>
        ${mensagem}

        <table border="1">
            <c:if test="${not empty cidades}">
                <tr>
                    <th>Código</th>
                    <th>Cidade</th>
                    <th>Uf</th>
                    <th>Alterar</th>
                    <th>Excluir</th>
                </tr> 
            </c:if>

            <c:forEach var="cidade" items="${cidades}">
                <tr>
                    <td>${cidade.codigoCidade}</td>
                    <td>${cidade.nomeCidade}</td>
                    <td>${cidade.ufCidade}</td>
                    <td>
                        <form name="cadastroForm" action="${pageContext.request.contextPath}${URL_BASE}/CidadeControlador" method="get">
                            <input type="hidden" name="codigoCidade" value="${cidade.codigoCidade}" >
                            <input type="hidden" name="nomeCidade" value="${cidade.nomeCidade}" >
                            <input type="hidden" name="ufCidade" value="${cidade.ufCidade}" >
                            <input type="hidden" name="opcao" value="editar" >
                            <button type="submit">Editar</button>
                        </form>    
                    </td>
                    <td>
                        <form name="cadastroForm" action="${pageContext.request.contextPath}${URL_BASE}/CidadeControlador" method="get">
                            <input type="hidden" name="codigoCidade" value="${cidade.codigoCidade}" >
                            <input type="hidden" name="nomeCidade" value="${cidade.nomeCidade}" >
                            <input type="hidden" name="ufCidade" value="${cidade.ufCidade}" >
                            <input type="hidden" name="opcao" value="excluir" >
                            <button type="submit">Excluir</button>
                        </form>    
                    </td>
                </tr>
            </c:forEach>



        </table>

    </body>
</html>

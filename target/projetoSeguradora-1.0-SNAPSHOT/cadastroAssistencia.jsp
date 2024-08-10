<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ include file="areaRestrita.jsp" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
            function submitForm(opcaoValue) {
                document.getElementById("opcao").value = opcaoValue;
                document.getElementById("cadastroForm").submit();
            }
        </script>
    </head>
    <body>
        <h1>Cadastro de Assistência</h1>
        <div>
            <form id="cadastroForm" name="cadastroForm" action="${pageContext.request.contextPath}${URL_BASE}/AssistenciaControlador" method="get">
                <input type="hidden" name="opcao" value="${opcao}" />
                <input type="hidden" name="idAssistencia" value="${idAssistencia}" />
                <p><label>Tipo:</label> <input type="text" name="tipoAssistencia" value="${tipoAssistencia}" size="40" /> </p>
                <p><label>Descrição:</label> <input type="text" name="descricaoAssistencia" value="${descricaoAssistencia}" size="40" /> </p>
                <td>
                    <input type="submit" name="Salvar" value="Salvar" />
                </td>
            </form>

            <form name="cancelarForm" action="${pageContext.request.contextPath}${URL_BASE}/AssistenciaControlador" method="get">
                <input type="hidden" name="opcao" value="cancelar" />
                <input type="submit" name="Cancelar" value="Cancelar" />
            </form>

        </div>
        ${mensagem}

        <h2>Lista de Assistências</h2>

        <!-- Exibindo a lista de assistências -->
        <table border="1">
            <!-- Verificando se a lista não está vazia -->
            <c:if test="${not empty assistencias}">
                <tr>
                    <th>Tipo</th>
                    <th>Descrição</th>
                    <th>Alterar</th>
                    <th>Excluir</th>
                </tr>
            </c:if>

            <c:forEach var="assistencia" items="${assistencias}">
                <tr>
                    <td>${assistencia.tipoAssistencia}</td>
                    <td>${assistencia.descricao}</td>
                    <td>
                        <form name="editarForm" action="${pageContext.request.contextPath}${URL_BASE}/AssistenciaControlador" method="get">
                            <input type="hidden" name="idAssistencia" value="${assistencia.idAssistencia}" />
                            <input type="hidden" name="tipoAssistencia" value="${assistencia.tipoAssistencia}" />
                            <input type="hidden" name="descricaoAssistencia" value="${assistencia.descricao}" />
                            <input type="hidden" name="opcao" value="editar" />
                            <button type="submit">Editar</button>
                        </form>
                    </td>
                    <td>
                        <form name="excluirForm" action="${pageContext.request.contextPath}${URL_BASE}/AssistenciaControlador" method="get">
                            <input type="hidden" name="idAssistencia" value="${assistencia.idAssistencia}" />
                            <input type="hidden" name="opcao" value="excluir" />
                            <button type="submit">Excluir</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>

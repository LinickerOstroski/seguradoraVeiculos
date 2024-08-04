<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ include file="areaRestrita.jsp" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Bônus</title>
        <script>
            function submitForm(opcaoValue) {
                document.getElementById("opcao").value = opcaoValue;
                document.getElementById("cadastroForm").submit();
            }
        </script>
    </head>
    <body>
        <h1>Cadastro de Bônus</h1>
        <div>
            <form id="cadastroForm" name="cadastroForm" action="${pageContext.request.contextPath}${URL_BASE}/BonusControlador" method="get">
                <input type="hidden" name="opcao" value="${opcao}" />
                <input type="hidden" name="idBonus" value="${idBonus}" />
                <p><label>Valor:</label> <input type="text" name="valorBonus" value="${valorBonus}" size="40" /> </p>
                <p><label>Descrição:</label> <input type="text" name="descricaoBonus" value="${descricaoBonus}" size="40" /> </p>
                <td>
                    <input type="submit" name="Salvar" value="Salvar" />
                </td>
            </form>

            <form name="cancelarForm" action="${pageContext.request.contextPath}${URL_BASE}/BonusControlador" method="get">
                <input type="hidden" name="opcao" value="cancelar" />
                <input type="submit" name="Cancelar" value="Cancelar" />
            </form>

        </form>

    </div>

    <c:if test="${not empty mensagem}">
        <p>${mensagem}</p>
    </c:if>

    <h2>Lista de Bônus</h2>
    <table border="1">
        <c:if test="${not empty bonus}">
            <tr>
                <th>Valor</th>
                <th>Descrição</th>
                <th>Alterar</th>
                <th>Excluir</th>
            </tr>
        </c:if>

        <c:forEach var="bonusItem" items="${bonus}">
            <tr>
                <td>${bonusItem.valorBonus}</td>
                <td>${bonusItem.descricaoBonus}</td>
                <td>
                    <form name="editarForm" action="${pageContext.request.contextPath}${URL_BASE}/BonusControlador" method="get">
                        <input type="hidden" name="idBonus" value="${bonusItem.idBonus}" />
                        <input type="hidden" name="valorBonus" value="${bonusItem.valorBonus}" />
                        <input type="hidden" name="descricaoBonus" value="${bonusItem.descricaoBonus}" />
                        <input type="hidden" name="opcao" value="editar" />
                        <button type="submit">Editar</button>
                    </form>
                </td>
                <td>
                    <form name="excluirForm" action="${pageContext.request.contextPath}${URL_BASE}/BonusControlador" method="get">
                        <input type="hidden" name="idBonus" value="${bonusItem.idBonus}" />
                        <input type="hidden" name="valorBonus" value="${bonusItem.valorBonus}" />
                        <input type="hidden" name="descricaoBonus" value="${bonusItem.descricaoBonus}" />
                        <input type="hidden" name="opcao" value="excluir" />
                        <button type="submit">Excluir</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>

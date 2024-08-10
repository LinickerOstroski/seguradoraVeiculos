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
    <h1>Cadastro Formulário Segurado</h1>
    <div>
        <form id="cadastroForm" name="cadastroForm" action="${pageContext.request.contextPath}${URL_BASE}/FormularioSeguradoControlador" method="get">
            <input type="hidden" id="opcao" name="opcao" value="${opcao}" />
            <input type="hidden" name="idFormularioSegurado" value="${idFormularioSegurado}" />
            <p><label>Nome:</label> <input type="text" name="nomeFormularioSegurado" value="${nomeFormularioSegurado}" size="40" /> </p>
            <p><label>Email:</label> <input type="text" name="emailFormularioSegurado" value="${emailFormularioSegurado}" size="40" /> </p>
            <p><label>Telefone:</label> <input type="text" name="telefoneFormularioSegurado" value="${telefoneFormularioSegurado}" size="40" /> </p>
            <td> 
                    <input type="submit" value="Salvar" name="Salvar"  /> 
            </td>
        </form>

        <form name="cancelarForm" action="${pageContext.request.contextPath}${URL_BASE}/FormularioSeguradoControlador" method="get">
            <td>
                    <input type="submit" value="Cancelar" name="Cancelar"  />
                </td>
                <input type="hidden" name="opcao" value="cancelar" />
        </form>
    </div>
    ${mensagem}

    <h2>Lista de Formulário Segurados</h2>

    <table border="1">
        <c:if test="${not empty formulariosSegurados}">
            <tr>
                <th>Nome</th>
                <th>Email</th>
                <th>Telefone</th>
                <th>Alterar</th>
                <th>Excluir</th>
            </tr>
        </c:if>

        <c:forEach var="formularioSegurado" items="${formulariosSegurados}">
            <tr>
                <td>${formularioSegurado.nomeFormularioSegurado}</td>
                <td>${formularioSegurado.emailFormularioSegurado}</td>
                <td>${formularioSegurado.telefoneFormularioSegurado}</td>
                <td>
                    <form action="${pageContext.request.contextPath}${URL_BASE}/FormularioSeguradoControlador" method="get">
                        <input type="hidden" name="idFormularioSegurado" value="${formularioSegurado.idFormularioSegurado}" />
                        <input type="hidden" name="nomeFormularioSegurado" value="${formularioSegurado.nomeFormularioSegurado}" />
                        <input type="hidden" name="emailFormularioSegurado" value="${formularioSegurado.emailFormularioSegurado}" />
                        <input type="hidden" name="telefoneFormularioSegurado" value="${formularioSegurado.telefoneFormularioSegurado}" />
                        <input type="hidden" name="opcao" value="editar" />
                        <button type="submit">Editar</button>
                    </form>
                </td>
                <td>
                    <form action="${pageContext.request.contextPath}${URL_BASE}/FormularioSeguradoControlador" method="get">
                        <input type="hidden" name="idFormularioSegurado" value="${formularioSegurado.idFormularioSegurado}" />
                        <input type="hidden" name="nomeFormularioSegurado" value="${formularioSegurado.nomeFormularioSegurado}" />
                        <input type="hidden" name="emailFormularioSegurado" value="${formularioSegurado.emailFormularioSegurado}" />
                        <input type="hidden" name="telefoneFormularioSegurado" value="${formularioSegurado.telefoneFormularioSegurado}" />
                        <input type="hidden" name="opcao" value="excluir" />
                        <button type="submit">Excluir</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>

<%@page import="java.util.List"%>
<%@page import="com.mycompany.seguradora.modelo.dao.SinistroDao"%>
<%@page import="com.mycompany.seguradora.modelo.dao.SeguroDao"%>
<%@page import="com.mycompany.seguradora.modelo.entidade.Seguro"%>
<%@page import="com.mycompany.seguradora.modelo.entidade.Sinistro"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="areaRestrita.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro Sinistro</title>
    </head>
    <body>
        <h1>Cadastro de Sinistro</h1>
        <form id="cadastroForm" name="cadastroForm" action="${pageContext.request.contextPath}${URL_BASE}/SinistroControlador" method="get">
            <input type="hidden" name="opcao" value="${opcao}" />
            <input type="hidden" name="idSinistro" value="${idSinistro}" />
            <p><label>Data da ocorrência do Sinistro</label> <input type="date" name="dataOcorrenciaSinistro" value="${dataOcorrenciaSinistro}" /> </p>
            <p><label>Valor da reparação:</label> <input type="text" name="valorReparacaoSinistro" value="${valorReparacaoSinistro}" size="40" /></p>
            <p><label>Descrição do Sinistro:</label> <input type="text" name="descricaoSinistro" value="${descricaoSinistro}" size="40" /></p>
            
            
            <p><label>Seguro: </label>
                <select name="seguroSinistro">
                    <c:forEach var="seguro" items="${seguros}">
                        <c:choose>
                            <c:when test="${seguro.idSeguro eq seguroSinistro}">
                                <option selected value="${seguro.idSeguro}">${seguro.tipoSeguro}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${seguro.idSeguro}">${seguro.tipoSeguro}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
            </p>  <td> 
                <input type="submit" value="Salvar" name="Salvar"  /> 
            </td>
        </form>

        <form name="cadastroForm" action="${pageContext.request.contextPath}${URL_BASE}/SinistroControlador" method="get">
            <td>
                <input type="submit" value="Cancelar" name="Cancelar"  />
            </td>
            <input type="hidden" name="opcao" value="cancelar" />
        </form>

        <table border="1">
            <c:if test="${not empty sinistros}">
                <tr>
                    <th>Código do Sinistro</th>
                    <th>Data da ocorrência do Sinistro</th>
                    <th>Valor do Sinistro</th>
                    <th>Descrição do Sinistro</th>
                    <th>Seguro do Sinistro</th>
                   
                    <th>Alterar</th>
                    <th>Excluir</th>
                </tr>
            </c:if>

            <c:forEach var="sinistro" items="${sinistros}">
                <tr>
                    <td>${sinistro.idSinistro}</td>
                    <td>${sinistro.sinistroFormatado}</td>
                    <td>${sinistro.valorReparacaoSinistro}</td>
                    <td>${sinistro.descricaoSinistro}</td>
                    <td>${sinistro.seguroSinistro.tipoSeguro}</td>
                   
                    <td>
                        <form name="cadastroForm" action="${pageContext.request.contextPath}${URL_BASE}/SinistroControlador" method="get">
                            <input type="hidden" name="idSinistro" value="${sinistro.idSinistro}" >
                            <input type="hidden" name="dataOcorrenciaSinistro" value="${sinistro.sinistroFormatado}" >
                            <input type="hidden" name="valorReparacaoSinistro" value="${sinistro.valorReparacaoSinistro}">
                            <input type="hidden" name="descricaoSinistro" value="${sinistro.descricaoSinistro}">
                            <input type="hidden" name="seguroSinistro" value="${sinistro.seguroSinistro}" >
                            <input type="hidden" name="opcao" value="editar" >
                            <button type="submit">Editar</button>
                        </form>    
                    </td>
                    <td>
                          <form name="cadastroForm" action="${pageContext.request.contextPath}${URL_BASE}/SinistroControlador" method="get">
                            <input type="hidden" name="idSinistro" value="${sinistro.idSinistro}" >
                            <input type="hidden" name="dataOcorrenciaSinistro" value="${sinistro.sinistroFormatado}" >
                            <input type="hidden" name="valorReparacaoSinistro" value="${sinistro.valorReparacaoSinistro}">
                            <input type="hidden" name="descricaoSinistro" value="${sinistro.descricaoSinistro}">
                            <input type="hidden" name="seguroSinistro" value="${sinistro.seguroSinistro}" >
                            <input type="hidden" name="opcao" value="excluir" >
                            <button type="submit">Excluir</button>
                        </form>   
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>

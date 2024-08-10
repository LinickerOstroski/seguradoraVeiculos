<%@page import="java.util.List"%>
<%@page import="com.mycompany.seguradora.modelo.dao.SeguradoDao"%>
<%@page import="com.mycompany.seguradora.modelo.dao.CidadeDao"%>
<%@page import="com.mycompany.seguradora.modelo.dao.BonusDao"%>
<%@page import="com.mycompany.seguradora.modelo.dao.VeiculoDao"%>
<%@page import="com.mycompany.seguradora.modelo.entidade.Segurado"%>
<%@page import="com.mycompany.seguradora.modelo.entidade.Cidade"%>
<%@page import="com.mycompany.seguradora.modelo.entidade.Bonus"%>
<%@page import="com.mycompany.seguradora.modelo.entidade.Veiculo"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="areaRestrita.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro Seguro</title>
    </head>
    <body>
        <h1>Cadastro de Seguro</h1>
        <form id="cadastroForm" name="cadastroForm" action="${pageContext.request.contextPath}${URL_BASE}/SeguroControlador" method="get">
            <input type="hidden" name="opcao" value="${opcao}" />
            <input type="hidden" name="idSeguro" value="${idSeguro}" />
            <p><label>Tipo do Seguro:</label> <input type="text" name="tipoSeguro" value="${tipoSeguro}" size="40" /> </p>
            <p><label>Data de inicio da Vigencia do Seguro</label> <input type="date" name="inicioVigenciaSeguro" value="${inicioVigenciaSeguro}"  /> </p>
            <p><label>Data de fim da Vigencia do Seguro</label> <input type="date" name="fimVigenciaSeguro" value="${fimVigenciaSeguro}"  /> </p>
            <p><label>Assistencia do Seguro:</label> <input type="text" name="assistenciaSeguro" value="${assistenciaSeguro}" size="20" /></p>
            <p><label>Valor do Seguro:</label> <input type="text" name="valorSeguro" value="${valorSeguro}" size="20" /></p>
            
            <p><label>Segurado</label>
                <select name="seguradoSeguro">
                    <c:forEach var="segurado" items="${segurados}">
                        <c:choose>
                            <c:when test="${segurado.idSegurado eq seguradoSeguro}">
                                <option selected value="${segurado.idSegurado}">${segurado.nomeSegurado}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${segurado.idSegurado}">${segurado.nomeSegurado}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
            </p>
            
            <p><label>Veículo:</label>
                <select name="veiculoSeguro">
                    <c:forEach var="veiculo" items="${veiculos}">
                        <c:choose>
                            <c:when test="${veiculo.idVeiculo eq veiculoSegurado}">
                                <option selected value="${veiculo.idVeiculo}">${veiculo.placaVeiculo}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${veiculo.idVeiculo}">${veiculo.placaVeiculo}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
            </p>
            <td> 
                <input type="submit" value="Salvar" name="Salvar"  /> 
            </td>
        </form>

        <form name="cadastroForm" action="${pageContext.request.contextPath}${URL_BASE}/SeguroControlador" method="get">
            <td>
                <input type="submit" value="Cancelar" name="Cancelar"  />
            </td>
            <input type="hidden" name="opcao" value="cancelar" />
        </form>

        <table border="1">
            <c:if test="${not empty seguros}">
                <tr>
                    <th>Código do Seguro</th>
                    <th>Tipo do Seguro</th>
                    <th>Inicio da Vigencia</th>
                    <th>Fim da Vigencia</th>
                    <th>Assitencia do Seguro</th>
                    <th>Valor do Seguro</th>
                    <th>Segurado</th>
                    <th>Veículo</th>
                    <th>Alterar</th>
                    <th>Excluir</th>
                </tr>
            </c:if>

            <c:forEach var="seguro" items="${seguros}">
                <tr>
                    <td>${seguro.idSeguro}</td>
                    <td>${seguro.tipoSeguro}</td>
                    <td>${seguro.inicioVigenciaFormatado}</td>
                    <td>${seguro.fimVigenciaFormatado}</td>
                    <td>${seguro.assistenciaSeguro}</td>
                    <td>${seguro.valorSeguro}</td>
                    <td>${seguro.seguradoSeguro.nomeSegurado}</td>
                    <td>${seguro.veiculoSeguro.placaVeiculo}</td>
                    
                    <td>
                        <form name="cadastroForm" action="${pageContext.request.contextPath}${URL_BASE}/SeguroControlador" method="get">
                            <input type="hidden" name="idSeguro" value="${seguro.idSeguro}" >
                            <input type="hidden" name="tipoSeguro" value="${seguro.tipoSeguro}" >
                            <input type="hidden" name="inicioVigenciaSeguro" value="${seguro.inicioVigenciaFormatado}">
                            <input type="hidden" name="fimVigenciaSeguro" value="${seguro.fimVigenciaFormatado}">
                            <input type="hidden" name="assistenciaSeguro" value="${seguro.assistenciaSeguro}" >
                            <input type="hidden" name="valorSeguro" value="${seguro.valorSeguro}" >
                            <input type="hidden" name="seguradoSeguro" value="${seguro.seguradoSeguro.idSegurado}" >
                            <input type="hidden" name="veiculoSeguro" value="${seguro.veiculoSeguro.idVeiculo}" >
                            <input type="hidden" name="opcao" value="editar" >
                            <button type="submit">Editar</button>
                        </form>    
                    </td>
                    <td>
                          <form name="cadastroForm" action="${pageContext.request.contextPath}${URL_BASE}/SeguroControlador" method="get">
                            <input type="hidden" name="idSeguro" value="${seguro.idSeguro}" >
                            <input type="hidden" name="tipoSeguro" value="${seguro.tipoSeguro}" >
                            <input type="hidden" name="inicioVigenciaSeguro" value="${seguro.inicioVigenciaFormatado}">
                            <input type="hidden" name="fimVigenciaSeguro" value="${seguro.fimVigenciaFormatado}">
                            <input type="hidden" name="assistenciaSeguro" value="${seguro.assistenciaSeguro}" >
                            <input type="hidden" name="valorSeguro" value="${seguro.valorSeguro}" >
                            <input type="hidden" name="seguradoSeguro" value="${seguro.seguradoSeguro.idSegurado}" >
                            <input type="hidden" name="veiculoSeguro" value="${seguro.veiculoSeguro.idVeiculo}" >
                            <input type="hidden" name="opcao" value="excluir" >
                            <button type="submit">Excluir</button>
                        </form>   
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>

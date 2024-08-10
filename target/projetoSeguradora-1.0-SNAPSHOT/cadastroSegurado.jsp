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
        <title>Cadastro Segurado</title>
    </head>
    <body>
        <h1>Cadastro Segurado</h1>
        <form id="cadastroForm" name="cadastroForm" action="${pageContext.request.contextPath}${URL_BASE}/SeguradoControlador" method="get">
            <input type="hidden" name="opcao" value="${opcao}" />
            <input type="hidden" name="idSegurado" value="${idSegurado}" />
            <p><label>Nome:</label> <input type="text" name="nomeSegurado" value="${nomeSegurado}" size="40" /> </p>
            <p><label>Data de Nascimento:</label> <input type="date" name="dataNascimentoSegurado" value="${dataNascimentoSegurado}"  /> </p>
            <p><label>CEP:</label> <input type="text" name="cepSegurado" value="${cepSegurado}" size="20" /></p>
            <p><label>Estado:</label> <input type="text" name="estadoSegurado" value="${estadoSegurado}" size="20" /></p>
            <p><label>Endereço:</label> <input type="text" name="enderecoSegurado" value="${enderecoSegurado}" size="40" /></p>
            <p><label>Bairro:</label> <input type="text" name="bairroSegurado" value="${bairroSegurado}" size="40" /></p>
            <p><label>Cidade:</label> <input type="text" name="cidadeSegurado" value="${cidadeSegurado}" size="40" /></p>
            <p><label>Telefone:</label> <input type="text" name="telefoneSegurado" value="${telefoneSegurado}" size="40" /></p>
            <p><label>Email:</label> <input type="text" name="emailSegurado" value="${emailSegurado}" size="40" /></p>

            
            <p><label>Bonus:</label>
                <select name="bonusSegurado">
                    <c:forEach var="bonus" items="${bonuses}">
                        <c:choose>
                            <c:when test="${bonus.idBonus eq bonusSegurado}">
                                <option selected value="${bonus.idBonus}">${bonus.descricaoBonus}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${bonus.idBonus}">${bonus.descricaoBonus}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
            </p>
            
            <p><label>Veículo:</label>
                <select name="veiculoSegurado">
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

        <form name="cadastroForm" action="${pageContext.request.contextPath}${URL_BASE}/SeguradoControlador" method="get">
            <td>
                <input type="submit" value="Cancelar" name="Cancelar"  />
            </td>
            <input type="hidden" name="opcao" value="cancelar" />
        </form>

        <table border="1">
            <c:if test="${not empty segurados}">
                <tr>
                    <th>Código</th>
                    <th>Nome</th>
                    <th>Data de Nascimento</th>
                    <th>CEP</th>
                    <th>Estado</th>
                    <th>Endereço</th>
                    <th>Bairro</th>
                    <th>Cidade</th>
                    <th>Telefone</th>
                    <th>Email</th>
                    <th>Bonus</th>
                    <th>Veículo</th>
                    <th>Alterar</th>
                    <th>Excluir</th>
                </tr>
            </c:if>

            <c:forEach var="segurado" items="${segurados}">
                <tr>
                    <td>${segurado.idSegurado}</td>
                    <td>${segurado.nomeSegurado}</td>
                    <td>${segurado.nascimentoFormatado}</td>
                    <td>${segurado.cepSegurado}</td>
                    <td>${segurado.estadoSegurado}</td>
                    <td>${segurado.enderecoSegurado}</td>
                    <td>${segurado.bairroSegurado}</td>
                    <td>${segurado.cidadeSegurado}</td>
                    <td>${segurado.telefoneSegurado}</td>
                    <td>${segurado.emailSegurado}</td>
                    <td>${segurado.bonusSegurado.descricaoBonus}</td>
                    <td>${segurado.veiculoSegurado.placaVeiculo}</td>
                    
                    
                    <td>
                        <form name="cadastroForm" action="${pageContext.request.contextPath}${URL_BASE}/SeguradoControlador" method="get">
                            <input type="hidden" name="idSegurado" value="${segurado.idSegurado}" >
                            <input type="hidden" name="nomeSegurado" value="${segurado.nomeSegurado}" >
                            <input type="hidden" name="dataNascimentoSegurado" value="${segurado.nascimentoFormatado}">
                            <input type="hidden" name="cepSegurado" value="${segurado.cepSegurado}" >
                            <input type="hidden" name="estadoSegurado" value="${segurado.estadoSegurado}" >
                            <input type="hidden" name="enderecoSegurado" value="${segurado.enderecoSegurado}" >
                            <input type="hidden" name="bairroSegurado" value="${segurado.bairroSegurado}" >
                            <input type="hidden" name="cidadeSegurado" value="${segurado.cidadeSegurado}" >
                            <input type="hidden" name="telefoneSegurado" value="${segurado.telefoneSegurado}" >
                            <input type="hidden" name="emailSegurado" value="${segurado.emailSegurado}" >
                            <input type="hidden" name="bonusSegurado" value="${segurado.bonusSegurado.idBonus}" >
                            <input type="hidden" name="veiculoSegurado" value="${segurado.veiculoSegurado.idVeiculo}" >
                            <input type="hidden" name="opcao" value="editar" >
                            <button type="submit">Editar</button>
                        </form>    
                    </td>
                    <td>
                          <form name="cadastroForm" action="${pageContext.request.contextPath}${URL_BASE}/SeguradoControlador" method="get">
                            <input type="hidden" name="idSegurado" value="${segurado.idSegurado}" >
                            <input type="hidden" name="nomeSegurado" value="${segurado.nomeSegurado}" >
                            <input type="hidden" name="dataNascimentoSegurado" value="${segurado.nascimentoFormatado}">
                            <input type="hidden" name="cepSegurado" value="${segurado.cepSegurado}" >
                            <input type="hidden" name="estadoSegurado" value="${segurado.estadoSegurado}" >
                            <input type="hidden" name="enderecoSegurado" value="${segurado.enderecoSegurado}" >
                            <input type="hidden" name="bairroSegurado" value="${segurado.bairroSegurado}" >
                            <input type="hidden" name="cidadeSegurado" value="${segurado.cidadeSegurado}" >
                            <input type="hidden" name="telefoneSegurado" value="${segurado.telefoneSegurado}" >
                            <input type="hidden" name="emailSegurado" value="${segurado.emailSegurado}" >
                            <input type="hidden" name="bonusSegurado" value="${segurado.bonusSegurado.idBonus}" >
                            <input type="hidden" name="veiculoSegurado" value="${segurado.veiculoSegurado.idVeiculo}" >
                            <input type="hidden" name="opcao" value="excluir" >
                            <button type="submit">Excluir</button>
                        </form>   
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>

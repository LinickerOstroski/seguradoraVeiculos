<%@page import="java.util.List"%>
<%@page import="com.mycompany.seguradora.modelo.dao.CidadeDao"%>
<%@page import="com.mycompany.seguradora.modelo.dao.FuncionarioDao"%>
<%@page import="com.mycompany.seguradora.modelo.entidade.Funcionario"%>
<%@page import="com.mycompany.seguradora.modelo.entidade.Cidade"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="index.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>


    <body>
        <h1>Cadastro Funcionário</h1>
        <table>
            <form id="cadastroForm" name="cadastroForm" action="${pageContext.request.contextPath}${URL_BASE}/FuncionarioControlador" method="get">
                <input type="hidden" name="opcao" value="${opcao}" />
                <input type="hidden" name="codigoFuncionario" value="${codigoFuncionario}" />
                <p><label>Nome:</label> <input type="text" name="nomeFuncionario" value="${nomeFuncionario}" size="40" /> </p>
                <p><label>Salário:</label> <input type="number" name="salarioFuncionario" value="${salarioFuncionario}" size="10" /> </p>
                <p><label>Nascimento:</label> <input type="date" name="nascimentoFuncionario" value="${nascimentoFuncionario}"  /> </p>
                
                
                
                
                <p><label>Cidade:</label>
                    <select name="cidadeFuncionario">
                     <c:forEach var="cidade" items="${cidades}">
                         <c:choose> 
                            
                            <c:when test="${cidade.codigoCidade eq cidadeFuncionario}">
                                <option selected value="${cidade.codigoCidade}">${cidade.nomeCidade}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${cidade.codigoCidade}">${cidade.nomeCidade}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
                </p>
                <td> 
                    <input type="submit" value="Salvar" name="Salvar"  /> 
                </td>
            </form>

            <form  name="cadastroForm" action="${pageContext.request.contextPath}${URL_BASE}/FuncionarioControlador" method="get">
                <td>
                    <input type="submit" value="Cancelar" name="Cancelar"  />
                </td>
                <input type="hidden" name="opcao" value="cancelar" />
            </form>
        </table>
        ${mensagem}

        <table border="1">
            <c:if test="${not empty funcionarios}">
                <tr>
                    <th>Código</th>
                    <th>Nome</th>
                    <th>Salário</th>
                    <th>Nascimento</th>
                    <th>Cidade</th>
                    <th>Alterar</th>
                    <th>Excluir</th>
                </tr> 
            </c:if>

            <c:forEach var="funcionario" items="${funcionarios}">
                <tr>
                    <td>${funcionario.codigoFuncionario}</td>
                    <td>${funcionario.nomeFuncionario}</td>
                    <td>${funcionario.salarioFuncionario}</td>
                    <td>${funcionario.nascimentoFormatado}</td>
                    <td>${funcionario.cidadeFuncionario.nomeCidade}</td>
                    <td>
                        <form name="cadastroForm" action="${pageContext.request.contextPath}${URL_BASE}/FuncionarioControlador" method="get">
                            <input type="hidden" name="codigoFuncionario" value="${funcionario.codigoFuncionario}" >
                            <input type="hidden" name="nomeFuncionario" value="${funcionario.nomeFuncionario}" >
                            <input type="hidden" name="salarioFuncionario" value="${funcionario.salarioFuncionario}" >
                              <input type="hidden" name="nascimentoFuncionario" value="${funcionario.nascimentoFormatado}">
                              <input type="hidden" name="cidadeFuncionario" value="${funcionario.cidadeFuncionario.codigoCidade}" >
                            <input type="hidden" name="opcao" value="editar" >
                            <button type="submit">Editar</button>
                        </form>    
                    </td>
                    <td>
                        <form name="cadastroForm" action="${pageContext.request.contextPath}${URL_BASE}/FuncionarioControlador" method="get">
                            <input type="hidden" name="codigoFuncionario" value="${funcionario.codigoFuncionario}" >
                            <input type="hidden" name="nomeFuncionario" value="${funcionario.nomeFuncionario}" >
                            <input type="hidden" name="salarioFuncionario" value="${funcionario.salarioFuncionario}" >
                              <input type="hidden" name="nascimentoFuncionario" value="${funcionario.nascimentoFormatado}">
                            <input type="hidden" name="cidadeFuncionario" value="${funcionario.cidadeFuncionario.codigoCidade}" >
                            <input type="hidden" name="opcao" value="excluir" >
                            <button type="submit">Excluir</button>
                        </form>    
                    </td>
                </tr>
            </c:forEach>



        </table>

    </body>
</html>

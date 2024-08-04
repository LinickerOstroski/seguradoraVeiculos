package com.mycompany.seguradora.controlador;

import com.mycompany.seguradora.modelo.dao.SeguradoraDao;
import com.mycompany.seguradora.modelo.entidade.Seguradora;
import com.mycompany.seguradora.servico.WebConstantes;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(WebConstantes.BASE_PATH + "/SeguradoraControlador")
public class SeguradoraControlador extends HttpServlet {

    private SeguradoraDao seguradoraDao;
    private Seguradora seguradora;
    String idSeguradora = "";
    String nomeSeguradora = "";
    String cnpjSeguradora = "";
    String enderecoSeguradora = "";
    String telefoneSeguradora = "";
    String emailSeguradora = "";

    String opcao = "";

    @Override
    public void init() throws ServletException {
        seguradoraDao = new SeguradoraDao();
        seguradora = new Seguradora();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            opcao = request.getParameter("opcao");
            idSeguradora = request.getParameter("idSeguradora");
            nomeSeguradora = request.getParameter("nomeSeguradora");
            cnpjSeguradora = request.getParameter("cnpjSeguradora");
            enderecoSeguradora = request.getParameter("enderecoSeguradora");
            telefoneSeguradora = request.getParameter("telefoneSeguradora");
            emailSeguradora = request.getParameter("emailSeguradora");

            if (opcao == null || opcao.isEmpty()) {
                opcao = "cadastrar";
            }
            switch (opcao) {
                case "cadastrar":
                    cadastrar(request, response);
                    break;
                case "editar":
                    editar(request, response);
                    break;
                case "confirmarEditar":
                    confirmarEditar(request, response);
                    break;
                case "excluir":
                    excluir(request, response);
                    break;
                case "confirmarExcluir":
                    confirmarExcluir(request, response);
                    break;
                case "cancelar":
                    cancelar(request, response);
                    break;
                default:
                    throw new IllegalArgumentException("Opção inválida " + opcao);
            }

        } catch (NumberFormatException e) {
            response.getWriter().println("Erro: um ou mais parâmetros não são numeros válidos");
        } catch (IllegalArgumentException e) {
            response.getWriter().println("Erro: " + e.getMessage());
        }
    }

    private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        validaCampos();
        seguradora.setNomeSeguradora(nomeSeguradora);
        seguradora.setCnpjSeguradora(cnpjSeguradora);
        seguradora.setEnderecoSeguradora(enderecoSeguradora);
        seguradora.setTelefoneSeguradora(telefoneSeguradora);
        seguradora.setEmailSeguradora(emailSeguradora);

        seguradoraDao.salvar(seguradora);
        encaminharParaPagina(request, response);
    }

    private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("idSeguradora", idSeguradora);
        request.setAttribute("opcao", "confirmarEditar");
        request.setAttribute("nomeSeguradora", nomeSeguradora);
        request.setAttribute("cnpjSeguradora", cnpjSeguradora);
        request.setAttribute("enderecoSeguradora", enderecoSeguradora);
        request.setAttribute("telefoneSeguradora", telefoneSeguradora);
        request.setAttribute("emailSeguradora", emailSeguradora);

        request.setAttribute("mensagem", "Edite os dados e clique em salvar");
        encaminharParaPagina(request, response);
    }

    private void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Supondo que você já tenha obtido o veículo a ser excluído
        request.setAttribute("idSeguradora", idSeguradora);
        request.setAttribute("opcao", "confirmarExcluir");
        request.setAttribute("nomeSeguradora", nomeSeguradora);
        request.setAttribute("cnpjSeguradora", cnpjSeguradora);
        request.setAttribute("enderecoSeguradora", enderecoSeguradora);
        request.setAttribute("telefoneSeguradora", telefoneSeguradora);
        request.setAttribute("emailSeguradora", emailSeguradora);
        request.setAttribute("mensagem", "Clique em salvar para confirmar a exclusão dos dados");
        encaminharParaPagina(request, response);
    }

    private void confirmarEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            validaCampos(); // Valida os campos recebidos

            // Criação e configuração do objeto Seguradora
            Seguradora seguradora1 = new Seguradora();
            seguradora1.setIdSeguradora(parseInt(request.getParameter("idSeguradora")));
            seguradora1.setNomeSeguradora(request.getParameter("nomeSeguradora"));
            seguradora1.setCnpjSeguradora(request.getParameter("cnpjSeguradora"));
            seguradora1.setEnderecoSeguradora(request.getParameter("enderecoSeguradora"));
            seguradora1.setTelefoneSeguradora(request.getParameter("telefoneSeguradora"));
            seguradora1.setEmailSeguradora(request.getParameter("emailSeguradora"));

            seguradoraDao.alterar(seguradora1);
            cancelar(request, response);
        } catch (IllegalArgumentException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Erro na validação dos campos: " + e.getMessage());
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro inesperado: " + e.getMessage());
        }
    }

// Método auxiliar para conversão de String para int
    private int parseInt(String value) {
        return (value != null && !value.isEmpty()) ? Integer.parseInt(value) : 0;
    }

    private void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        seguradora.setIdSeguradora(Integer.valueOf(request.getParameter("idSeguradora")));
        seguradoraDao.excluir(seguradora);
        cancelar(request, response);
    }

    private void cancelar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("idSeguradora", "0");
        request.setAttribute("opcao", "cadastrar");
        request.setAttribute("nomeSeguradora", "");
        request.setAttribute("cnpjSeguradora", "");
        request.setAttribute("enderecoSeguradora", "");
        request.setAttribute("telefoneSeguradora", "");
        request.setAttribute("emailSeguradora", "");
        encaminharParaPagina(request, response);
    }

    private void encaminharParaPagina(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Seguradora> seguradoras = seguradoraDao.buscarTodas();
        request.setAttribute("seguradoras", seguradoras);
        request.setAttribute(opcao, opcao);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/CadastroSeguradora.jsp");
        dispatcher.forward(request, response);

    }

    public void validaCampos() {
        if (nomeSeguradora == null || nomeSeguradora.isEmpty() || cnpjSeguradora == null || cnpjSeguradora.isEmpty()
                || enderecoSeguradora == null || enderecoSeguradora.isEmpty() || telefoneSeguradora == null || telefoneSeguradora.isEmpty()
                || emailSeguradora == null || emailSeguradora.isEmpty()) {
            throw new IllegalArgumentException("Um ou mais parâmetros estão ausentes");
        }
    }

}

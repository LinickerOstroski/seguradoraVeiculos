package com.mycompany.seguradora.controlador;

import com.mycompany.seguradora.modelo.dao.AssistenciaDao;
import com.mycompany.seguradora.modelo.entidade.Assistencia;
import com.mycompany.seguradora.servico.WebConstantes;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(WebConstantes.BASE_PATH + "/AssistenciaControlador")
public class AssistenciaControlador extends HttpServlet {

    private AssistenciaDao assistenciaDao;
    private Assistencia assistencia;
    String idAssistencia = "";
    String tipoAssistencia = "";
    String descricaoAssistencia = "";

    String opcao = "";

    @Override
    public void init() throws ServletException {
        assistenciaDao = new AssistenciaDao();
        assistencia = new Assistencia();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            opcao = request.getParameter("opcao");
            idAssistencia = request.getParameter("idAssistencia");
            tipoAssistencia = request.getParameter("tipoAssistencia");
            descricaoAssistencia = request.getParameter("descricaoAssistencia");

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
            response.getWriter().println("Erro: um ou mais parâmetros não são números válidos");
        } catch (IllegalArgumentException e) {
            response.getWriter().println("Erro: " + e.getMessage());
        }
    }

    private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        validaCampos();
        assistencia.setTipoAssistencia(tipoAssistencia);
        assistencia.setDescricao(descricaoAssistencia);

        assistenciaDao.salvar(assistencia);
        encaminharParaPagina(request, response);
    }

    private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("idAssistencia", idAssistencia);
        request.setAttribute("opcao", "confirmarEditar");
        request.setAttribute("tipoAssistencia", tipoAssistencia);
        request.setAttribute("descricaoAssistencia", descricaoAssistencia);

        request.setAttribute("mensagem", "Edite os dados e clique em salvar");

        encaminharParaPagina(request, response);
    }

    private void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("idAssistencia", idAssistencia);
        request.setAttribute("opcao", "confirmarExcluir");
        request.setAttribute("tipoAssistencia", tipoAssistencia);
        request.setAttribute("descricaoAssistencia", descricaoAssistencia);
        request.setAttribute("mensagem", "Clique em salvar para confirmar a exclusão dos dados");
        encaminharParaPagina(request, response);
    }

    private void confirmarEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            validaCampos(); // Valida os campos recebidos

            // Criação e configuração do objeto Assistencia
            Assistencia assistencia1 = new Assistencia();
            assistencia1.setIdAssistencia(parseInt(request.getParameter("idAssistencia")));
            assistencia1.setTipoAssistencia(request.getParameter("tipoAssistencia"));
            assistencia1.setDescricao(request.getParameter("descricaoAssistencia"));

            // Atualização da assistência no banco de dados
            assistenciaDao.alterar(assistencia1);

            // Redireciona para o método cancelar após a atualização
            cancelar(request, response);
        } catch (IllegalArgumentException e) {
            // Trata erros relacionados à validação de campos
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Erro na validação dos campos: " + e.getMessage());
        } catch (Exception e) {
            // Trata outros erros inesperados
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro inesperado: " + e.getMessage());
        }
    }

    // Método auxiliar para conversão de String para int
    private int parseInt(String value) {
        return (value != null && !value.isEmpty()) ? Integer.parseInt(value) : 0;
    }

    private void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        assistencia.setIdAssistencia(Integer.valueOf(request.getParameter("idAssistencia")));
        assistenciaDao.excluir(assistencia);
        cancelar(request, response);
    }

    private void cancelar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("idAssistencia", "0");
        request.setAttribute("opcao", "cadastrar");
        request.setAttribute("tipoAssistencia", "");
        request.setAttribute("descricaoAssistencia", "");
        encaminharParaPagina(request, response);
    }

    private void encaminharParaPagina(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Assistencia> assistencias = assistenciaDao.buscarTodas();
        request.setAttribute("assistencias", assistencias);
        request.setAttribute(opcao, opcao);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/CadastroAssistencia.jsp");
        dispatcher.forward(request, response);
    }

    public void validaCampos() {
        if (tipoAssistencia == null || tipoAssistencia.isEmpty() || descricaoAssistencia == null || descricaoAssistencia.isEmpty()) {
            throw new IllegalArgumentException("Um ou mais parâmetros estão ausentes");
        }
    }
}

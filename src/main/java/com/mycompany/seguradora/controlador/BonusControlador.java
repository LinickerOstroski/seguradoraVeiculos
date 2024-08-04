package com.mycompany.seguradora.controlador;

import com.mycompany.seguradora.modelo.dao.BonusDao;
import com.mycompany.seguradora.modelo.entidade.Bonus;
import com.mycompany.seguradora.servico.WebConstantes;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(WebConstantes.BASE_PATH + "/BonusControlador")
public class BonusControlador extends HttpServlet {

    private BonusDao bonusDao;
    private Bonus bonus;
    String idBonus = "";
    String valorBonus = "";
    String descricaoBonus = "";

    String opcao = "";

    @Override
    public void init() throws ServletException {
        bonusDao = new BonusDao();
        bonus = new Bonus();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            opcao = request.getParameter("opcao");
            idBonus = request.getParameter("idBonus");
            valorBonus = request.getParameter("valorBonus");
            descricaoBonus = request.getParameter("descricaoBonus");

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
        bonus.setValorBonus(Double.parseDouble(valorBonus));
        bonus.setDescricaoBonus(descricaoBonus);

        try {
            bonusDao.salvar(bonus);
        } catch (Exception e) {
            throw new ServletException("Erro ao cadastrar bônus: " + e.getMessage(), e);
        }

        encaminharParaPagina(request, response);
    }

    private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("idBonus", idBonus);
        request.setAttribute("opcao", "confirmarEditar");
        request.setAttribute("valorBonus", valorBonus);
        request.setAttribute("descricaoBonus", descricaoBonus);

        request.setAttribute("mensagem", "Edite os dados e clique em salvar");

        encaminharParaPagina(request, response);
    }

    private void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("idBonus", idBonus);
        request.setAttribute("opcao", "confirmarExcluir");
        request.setAttribute("valorBonus", valorBonus);
        request.setAttribute("descricaoBonus", descricaoBonus);
        request.setAttribute("mensagem", "Clique em salvar para confirmar a exclusão dos dados");
        encaminharParaPagina(request, response);
    }

    private void confirmarEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            validaCampos();

            Bonus bonus1 = new Bonus();
            bonus1.setIdBonus(parseInt(request.getParameter("idBonus")));
            bonus1.setValorBonus(Double.parseDouble(request.getParameter("valorBonus")));
            bonus1.setDescricaoBonus(request.getParameter("descricaoBonus"));

            bonusDao.alterar(bonus1);

            cancelar(request, response);
        } catch (IllegalArgumentException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Erro na validação dos campos: " + e.getMessage());
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro inesperado: " + e.getMessage());
        }
    }

    private void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        bonus.setIdBonus(Integer.valueOf(request.getParameter("idBonus")));
        bonusDao.excluir(bonus);
        cancelar(request, response);
    }

    private void cancelar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("idBonus", "0");
        request.setAttribute("opcao", "cadastrar");
        request.setAttribute("valorBonus", "");
        request.setAttribute("descricaoBonus", "");
        encaminharParaPagina(request, response);
    }

    private void encaminharParaPagina(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Bonus> bonusList = bonusDao.buscarTodas();
        request.setAttribute("bonus", bonusList);
        request.setAttribute(opcao, opcao);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/cadastroBonus.jsp");
        dispatcher.forward(request, response);
    }

    public void validaCampos() {
        if (valorBonus == null || valorBonus.isEmpty() || descricaoBonus == null || descricaoBonus.isEmpty()) {
            throw new IllegalArgumentException("Um ou mais parâmetros estão ausentes");
        }
    }

    private int parseInt(String value) {
        return (value != null && !value.isEmpty()) ? Integer.parseInt(value) : 0;
    }
}

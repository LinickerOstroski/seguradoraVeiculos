package com.mycompany.seguradora.controlador;

import com.mycompany.seguradora.modelo.dao.VeiculoDao;
import com.mycompany.seguradora.modelo.entidade.Veiculo;
import com.mycompany.seguradora.servico.WebConstantes;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(WebConstantes.BASE_PATH + "/VeiculoControlador")
public class VeiculoControlador extends HttpServlet {

    private VeiculoDao veiculoDao;
    private Veiculo veiculo;
    String idVeiculo = "";
    String placaVeiculo = "";
    String marcaVeiculo = "";
    String modeloVeiculo = "";
    String anoVeiculo = "";
    String chassiVeiculo = "";
    String capacidadeVeiculo = "";
    String categoriaVeiculo = "";
    String corVeiculo = "";
    String fipeVeiculo = "";

    String opcao = "";

    @Override
    public void init() throws ServletException {
        veiculoDao = new VeiculoDao();
        veiculo = new Veiculo();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            opcao = request.getParameter("opcao");
            idVeiculo = request.getParameter("idVeiculo");
            placaVeiculo = request.getParameter("placaVeiculo");
            marcaVeiculo = request.getParameter("marcaVeiculo");
            modeloVeiculo = request.getParameter("modeloVeiculo");
            anoVeiculo = request.getParameter("anoVeiculo");
            chassiVeiculo = request.getParameter("chassiVeiculo");
            capacidadeVeiculo = request.getParameter("capacidadeVeiculo");
            categoriaVeiculo = request.getParameter("categoriaVeiculo");
            corVeiculo = request.getParameter("corVeiculo");
            fipeVeiculo = request.getParameter("fipeVeiculo");

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
        veiculo.setPlacaVeiculo(placaVeiculo);
        veiculo.setMarcaVeiculo(marcaVeiculo);
        veiculo.setModeloVeiculo(modeloVeiculo);
        veiculo.setAnoVeiculo(anoVeiculo);
        veiculo.setChassiVeiculo(chassiVeiculo);
        veiculo.setCapacidadeVeiculo(capacidadeVeiculo);
        veiculo.setCategoriaVeiculo(categoriaVeiculo);
        veiculo.setCorVeiculo(corVeiculo);

        try {
            double fipeValue = Double.parseDouble(fipeVeiculo);
            veiculo.setFipeVeiculo(fipeValue);
        } catch (NumberFormatException e) {
            // Tratamento de erro, caso o valor de fipeVeiculo não seja um número válido
            throw new ServletException("Valor inválido para FIPE: " + fipeVeiculo, e);
        }

        veiculoDao.salvar(veiculo);
        encaminharParaPagina(request, response);
    }

    private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("idVeiculo", idVeiculo);
        request.setAttribute("opcao", "confirmarEditar");
        request.setAttribute("placaVeiculo", placaVeiculo);
        request.setAttribute("marcaVeiculo", marcaVeiculo);
        request.setAttribute("modeloVeiculo", modeloVeiculo);
        request.setAttribute("anoVeiculo", anoVeiculo);
        request.setAttribute("chassiVeiculo", chassiVeiculo);
        request.setAttribute("capacidadeVeiculo", capacidadeVeiculo);
        request.setAttribute("categoriaVeiculo", categoriaVeiculo);
        request.setAttribute("corVeiculo", corVeiculo);
        request.setAttribute("fipeVeiculo", fipeVeiculo);

        request.setAttribute("mensagem", "Edite os dados e clique em salvar");

        encaminharParaPagina(request, response);
    }

    private void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Supondo que você já tenha obtido o veículo a ser excluído
        request.setAttribute("idVeiculo", idVeiculo);
        request.setAttribute("opcao", "confirmarExcluir");
        request.setAttribute("placaVeiculo", placaVeiculo);
        request.setAttribute("marcaVeiculo", marcaVeiculo);
        request.setAttribute("modeloVeiculo", modeloVeiculo);
        request.setAttribute("anoVeiculo", anoVeiculo);
        request.setAttribute("chassiVeiculo", chassiVeiculo);
        request.setAttribute("capacidadeVeiculo", capacidadeVeiculo);
        request.setAttribute("categoriaVeiculo", categoriaVeiculo);
        request.setAttribute("corVeiculo", corVeiculo);
        request.setAttribute("fipeVeiculo", fipeVeiculo);
        request.setAttribute("mensagem", "Clique em salvar para confirmar a exclusão dos dados");
        encaminharParaPagina(request, response);
    }

    private void confirmarEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            validaCampos(); // Valida os campos recebidos

            // Criação e configuração do objeto Veiculo
            Veiculo veiculo1 = new Veiculo();
            veiculo1.setIdVeiculo(parseInt(request.getParameter("idVeiculo")));
            veiculo1.setPlacaVeiculo(request.getParameter("placaVeiculo"));
            veiculo1.setMarcaVeiculo(request.getParameter("marcaVeiculo"));
            veiculo1.setModeloVeiculo(request.getParameter("modeloVeiculo"));
            veiculo1.setAnoVeiculo(request.getParameter("anoVeiculo"));
            veiculo1.setChassiVeiculo(request.getParameter("chassiVeiculo"));
            veiculo1.setCapacidadeVeiculo(request.getParameter("capacidadeVeiculo"));
            veiculo1.setCategoriaVeiculo(request.getParameter("categoriaVeiculo"));
            veiculo1.setCorVeiculo(request.getParameter("corVeiculo"));

            // Conversão e configuração do valor FIPE
            try {
                double fipeValue = Double.parseDouble(request.getParameter("fipeVeiculo"));
                veiculo1.setFipeVeiculo(fipeValue);
            } catch (NumberFormatException e) {
                throw new ServletException("Valor inválido para FIPE: " + request.getParameter("fipeVeiculo"), e);
            }

            // Atualização do veículo no banco de dados
            veiculoDao.alterar(veiculo1);

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
        veiculo.setIdVeiculo(Integer.valueOf(request.getParameter("idVeiculo")));
        veiculoDao.excluir(veiculo);
        cancelar(request, response);
    }

    private void cancelar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("idVeiculo", "0");
        request.setAttribute("opcao", "cadastrar");
        request.setAttribute("placaVeiculo", "");
        request.setAttribute("marcaVeiculo", "");
        request.setAttribute("modeloVeiculo", "");
        request.setAttribute("anoVeiculo", "");
        request.setAttribute("chassiVeiculo", "");
        request.setAttribute("capacidadeVeiculo", "");
        request.setAttribute("categoriaVeiculo", "");
        request.setAttribute("corVeiculo", "");
        request.setAttribute("fipeVeiculo", "");
        encaminharParaPagina(request, response);
    }

    private void encaminharParaPagina(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Veiculo> veiculos = veiculoDao.buscarTodas();
        request.setAttribute("veiculos", veiculos);
        request.setAttribute(opcao, opcao);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/CadastroVeiculo.jsp");
        dispatcher.forward(request, response);

    }

    public void validaCampos() {
        if (placaVeiculo == null || placaVeiculo.isEmpty() || marcaVeiculo == null || marcaVeiculo.isEmpty()
                || modeloVeiculo == null || modeloVeiculo.isEmpty() || anoVeiculo == null || anoVeiculo.isEmpty()
                || chassiVeiculo == null || chassiVeiculo.isEmpty() || capacidadeVeiculo == null || capacidadeVeiculo.isEmpty()
                || categoriaVeiculo == null || categoriaVeiculo.isEmpty() || corVeiculo == null || corVeiculo.isEmpty()
                || fipeVeiculo == null || fipeVeiculo.isEmpty()) {
            throw new IllegalArgumentException("Um ou mais parâmetros estão ausentes");
        }
    }

}

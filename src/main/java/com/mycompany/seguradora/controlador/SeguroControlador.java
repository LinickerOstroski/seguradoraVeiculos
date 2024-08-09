package com.mycompany.seguradora.controlador;

import com.mycompany.seguradora.modelo.dao.SeguradoDao;
import com.mycompany.seguradora.modelo.dao.SeguroDao;
import com.mycompany.seguradora.modelo.dao.VeiculoDao;
import com.mycompany.seguradora.modelo.entidade.Seguro;
import com.mycompany.seguradora.modelo.entidade.Segurado;
import com.mycompany.seguradora.modelo.entidade.Veiculo;
import com.mycompany.seguradora.servico.WebConstantes;
import com.mycompany.seguradora.servico.ConverteData;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(WebConstantes.BASE_PATH + "/SeguroControlador")
public class SeguroControlador extends HttpServlet {
    
    private SeguradoDao seguradoDao;
    private Segurado segurado;
    private VeiculoDao veiculoDao;
    private Veiculo veiculo;
    
    private SeguroDao seguroDao;
    private Seguro seguro;
    String idSeguro = "";
    String tipoSeguro = "";
    String inicioVigenciaSeguro = "";
    String fimVigenciaSeguro = "";
    String assistenciaSeguro = "";
    String valorSeguro = "";
    String seguradoSeguro = "";
    String veiculoSeguro = "";
    String opcao = "";
    private ConverteData converte = new ConverteData();

    @Override
    public void init() throws ServletException {
        veiculoDao = new VeiculoDao();
        seguradoDao = new SeguradoDao();
        seguroDao = new SeguroDao();
        segurado = new Segurado();
        seguro = new Seguro();
        veiculo = new Veiculo();
    }
    
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            opcao = request.getParameter("opcao");
            idSeguro = request.getParameter("idSeguro");
            tipoSeguro = request.getParameter("tipoSeguro");
            inicioVigenciaSeguro = request.getParameter("inicioVigenciaSeguro");
            fimVigenciaSeguro = request.getParameter("fimVigenciaSeguro");
            assistenciaSeguro = request.getParameter("assistenciaSeguro");
            valorSeguro = request.getParameter("valorSeguro");
            seguradoSeguro = request.getParameter("seguradoSeguro");
            veiculoSeguro = request.getParameter("veiculoSeguro");

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
                    throw new IllegalArgumentException("Opção inválida: " + opcao);
            }

        } catch (NumberFormatException e) {
            response.getWriter().println("Erro: um ou mais parâmetros não são números válidos :/");
        } catch (IllegalArgumentException e) {
            response.getWriter().println("Erro: " + e.getMessage());
        }
    }
    
    private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        validaCampos();

        //String dataNascimentoStr = request.getParameter("dataNascimentoSegurado");
        seguro.setTipoSeguro(tipoSeguro);
        seguro.setInicioVigenciaSeguro(converte.converteCalendario(inicioVigenciaSeguro));
        seguro.setFimVigenciaSeguro(converte.converteCalendario(fimVigenciaSeguro));
        seguro.setAssistenciaSeguro(assistenciaSeguro);
        seguro.setValorSeguro(Double.valueOf(valorSeguro));
        seguro.getSeguradoSeguro().setIdSegurado(Integer.valueOf(seguradoSeguro));
        seguro.getVeiculoSeguro().setIdVeiculo(Integer.valueOf(veiculoSeguro));
        
        seguroDao.salvar(seguro);
        encaminharParaPagina(request, response);
    }
    
    private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("idSeguro", idSeguro);
        request.setAttribute("opcao", "confirmarEditar");
        request.setAttribute("tipoSeguro", tipoSeguro);
        request.setAttribute("inicioVigenciaSeguro", ConverteData.convertDateFormat(inicioVigenciaSeguro));
        request.setAttribute("fimVigenciaSeguro", ConverteData.convertDateFormat(fimVigenciaSeguro));
        request.setAttribute("assistenciaSeguro", assistenciaSeguro);
        request.setAttribute("valorSeguro", valorSeguro);
        request.setAttribute("seguradoSeguro", seguradoSeguro);
        request.setAttribute("veiculoSeguro", veiculoSeguro);
        request.setAttribute("mensagem", "Edite os dados e clique em salvar");
        encaminharParaPagina(request, response);
    }
    private void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("idSeguro", idSeguro);
        request.setAttribute("opcao", "confirmarExcluir");
        request.setAttribute("tipoSeguro", tipoSeguro);
        request.setAttribute("inicioVigenciaSeguro", ConverteData.convertDateFormat(inicioVigenciaSeguro));
        request.setAttribute("fimVigenciaSeguro", ConverteData.convertDateFormat(fimVigenciaSeguro));
        request.setAttribute("assistenciaSeguro", assistenciaSeguro);
        request.setAttribute("valorSeguro", valorSeguro);
        request.setAttribute("seguradoSeguro", seguradoSeguro);
        request.setAttribute("veiculoSeguro", veiculoSeguro);
        request.setAttribute("mensagem", "Clique em salvar para excluir");
        encaminharParaPagina(request, response);
    }
    
    private void confirmarEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        validaCampos();
        
        seguro.setIdSeguro(Integer.valueOf(idSeguro));
        seguro.setTipoSeguro(tipoSeguro);
        seguro.setInicioVigenciaSeguro(converte.converteCalendario(inicioVigenciaSeguro));
        seguro.setFimVigenciaSeguro(converte.converteCalendario(fimVigenciaSeguro));
        seguro.setAssistenciaSeguro(assistenciaSeguro);
        seguro.setValorSeguro(Double.valueOf(valorSeguro));
        seguro.getSeguradoSeguro().setIdSegurado(Integer.valueOf(seguradoSeguro));
        seguro.getVeiculoSeguro().setIdVeiculo(Integer.valueOf(veiculoSeguro));
        
        seguroDao.alterar(seguro);
        cancelar(request, response);
    }
    
     private void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        validaCampos();
        seguro.setIdSeguro(Integer.valueOf(idSeguro));
        seguro.setTipoSeguro(tipoSeguro);
        seguro.setInicioVigenciaSeguro(converte.converteCalendario(inicioVigenciaSeguro));
        seguro.setFimVigenciaSeguro(converte.converteCalendario(fimVigenciaSeguro));
        seguro.setAssistenciaSeguro(assistenciaSeguro);
        seguro.setValorSeguro(Double.valueOf(valorSeguro));
        seguro.getSeguradoSeguro().setIdSegurado(Integer.valueOf(seguradoSeguro));
        seguro.getVeiculoSeguro().setIdVeiculo(Integer.valueOf(veiculoSeguro));
        
        seguroDao.excluir(seguro);
        cancelar(request, response);
    }
     
    private void cancelar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("idSeguro", "0");
        request.setAttribute("opcao", "cadastrar");
        request.setAttribute("tipoSeguro", "");
        request.setAttribute("inicioVigenciaSeguro", "");
        request.setAttribute("fimVigenciaSeguro", "");
        request.setAttribute("assistenciaSeguro", "");
        request.setAttribute("valorSeguro", "");
        request.setAttribute("seguradoSeguro", "");
        request.setAttribute("veiculoSeguro", "");
        encaminharParaPagina(request, response);
    }
    
    private void encaminharParaPagina(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        List<Segurado> segurados = seguradoDao.buscarTodos();
        request.setAttribute("segurados", segurados);
        
        List<Veiculo> veiculos = veiculoDao.buscarTodas();
        request.setAttribute("veiculos", veiculos);

        List<Seguro> seguros = seguroDao.buscarTodos();
        request.setAttribute("seguros", seguros);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/cadastroSeguro.jsp");
        dispatcher.forward(request, response);
    }
    
    public void validaCampos() {
        if (tipoSeguro == null || tipoSeguro.isEmpty()
                || inicioVigenciaSeguro == null || inicioVigenciaSeguro.isEmpty()
                || fimVigenciaSeguro == null || fimVigenciaSeguro.isEmpty()
                || assistenciaSeguro == null || assistenciaSeguro.isEmpty()
                || valorSeguro == null || valorSeguro.isEmpty()
                || seguradoSeguro == null || seguradoSeguro.isEmpty()
                || veiculoSeguro == null || veiculoSeguro.isEmpty()) {
            throw new IllegalArgumentException("Um ou mais parâmetros estão ausentes."
                    + seguradoSeguro + " " + veiculoSeguro);
        }
    }
}

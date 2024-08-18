package com.mycompany.seguradora.controlador;

import com.mycompany.seguradora.modelo.dao.SeguroDao;
import com.mycompany.seguradora.modelo.dao.SinistroDao;
import com.mycompany.seguradora.modelo.entidade.Seguro;
import com.mycompany.seguradora.modelo.entidade.Sinistro;
import com.mycompany.seguradora.servico.WebConstantes;
import com.mycompany.seguradora.servico.ConverteData;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(WebConstantes.BASE_PATH + "/SinistroControlador")
public class SinistroControlador extends HttpServlet{
    
    private SeguroDao seguroDao;
    private Seguro seguro;
    private SinistroDao sinistroDao;
    private Sinistro sinistro;
    String idSinistro = "";
    String dataOcorrenciaSinistro = "";
    String descricaoSinistro = "";
    String valorReparacaoSinistro = "";
    String seguroSinistro = "";
  
    String opcao = "";
    private ConverteData converte = new ConverteData();
    
     @Override
    public void init() throws ServletException {
        seguroDao = new SeguroDao();
        sinistroDao = new SinistroDao();
        sinistro = new Sinistro();
        seguro = new Seguro();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            opcao = request.getParameter("opcao");
            idSinistro = request.getParameter("idSegurado");
            dataOcorrenciaSinistro = request.getParameter("dataOcorrenciaSinistro");
            valorReparacaoSinistro = request.getParameter("valorReparacaoSinistro");
            descricaoSinistro = request.getParameter("descricaoSinistro");
            seguroSinistro = request.getParameter("seguroSinistro");

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
            response.getWriter().println("Erro: um ou mais parâmetros não são números válidos");
        } catch (IllegalArgumentException e) {
            response.getWriter().println("Erro: " + e.getMessage());
        }
    }
    
    private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        validaCampos();

        sinistro.setDataOcorrenciaSinistro(converte.converteCalendario(dataOcorrenciaSinistro));
        sinistro.setValorReparacaoSinistro(Double.valueOf(valorReparacaoSinistro));
        sinistro.setDescricaoSinistro(descricaoSinistro);
       
        sinistro.getSeguroSinistro().setIdSeguro(Integer.valueOf(seguroSinistro));
        
        sinistroDao.salvar(sinistro);
        encaminharParaPagina(request, response);
    }
    
    private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("idSinistro", idSinistro);
        request.setAttribute("opcao", "confirmarEditar");
        request.setAttribute("dataOcorrenciaSinistro", ConverteData.convertDateFormat(dataOcorrenciaSinistro));
        request.setAttribute("valorReparacaoSinistro", valorReparacaoSinistro);
        request.setAttribute("descricaoSinistro", descricaoSinistro);
        request.setAttribute("seguroSinistro", seguroSinistro);
        request.setAttribute("mensagem", "Edite os dados e clique em salvar");
        encaminharParaPagina(request, response);
    }
    private void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("idSinistro", idSinistro);
        request.setAttribute("opcao", "confirmarExcluir");
        request.setAttribute("dataOcorrenciaSinistro", ConverteData.convertDateFormat(dataOcorrenciaSinistro));
        request.setAttribute("valorReparacaoSinistro", valorReparacaoSinistro);
        request.setAttribute("descricaoSinistro", descricaoSinistro);
        request.setAttribute("seguroSinistro", seguroSinistro);
        request.setAttribute("mensagem", "Clique em salvar para excluir");
        encaminharParaPagina(request, response);
    }
    
    private void confirmarEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        validaCampos();
        
        sinistro.setIdSinistro(Integer.valueOf(idSinistro));
        sinistro.setDataOcorrenciaSinistro(converte.converteCalendario(dataOcorrenciaSinistro));
        sinistro.setValorReparacaoSinistro(Double.valueOf(valorReparacaoSinistro));
        sinistro.setDescricaoSinistro(descricaoSinistro);
        sinistro.getSeguroSinistro().setIdSeguro(Integer.valueOf(seguroSinistro));
        
        sinistroDao.alterar(sinistro);
        cancelar(request, response);
    }
    
    private void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        validaCampos();
        
        sinistro.setIdSinistro(Integer.valueOf(idSinistro));
        sinistro.setDataOcorrenciaSinistro(converte.converteCalendario(dataOcorrenciaSinistro));
        sinistro.setValorReparacaoSinistro(Double.valueOf(valorReparacaoSinistro));
        sinistro.setDescricaoSinistro(descricaoSinistro);
        sinistro.getSeguroSinistro().setIdSeguro(Integer.valueOf(seguroSinistro));
        
        sinistroDao.excluir(sinistro);
        cancelar(request, response);
    }
    
    private void cancelar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("idSinistro", "0");
        request.setAttribute("opcao", "cadastrar");
        request.setAttribute("dataOcorrenciaSinistro", "");
        request.setAttribute("descricaoSinistro", "");
        request.setAttribute("valorReparacaoSinistro", "");
        request.setAttribute("seguroSinistro", "");
        
        encaminharParaPagina(request, response);
    }
    
    private void encaminharParaPagina(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        List<Sinistro> sinistros = sinistroDao.buscarTodos();
        request.setAttribute("sinistros", sinistros);
        
        List<Seguro> seguros = seguroDao.buscarTodos();
        request.setAttribute("seguros", seguros);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/cadastroSinistro.jsp");
        dispatcher.forward(request, response);
    }
    
    public void validaCampos() {
        if (dataOcorrenciaSinistro == null || dataOcorrenciaSinistro.isEmpty()
                || valorReparacaoSinistro == null || valorReparacaoSinistro.isEmpty()
                || seguroSinistro == null || seguroSinistro.isEmpty()
                || descricaoSinistro == null || descricaoSinistro.isEmpty()){
            throw new IllegalArgumentException("Um ou mais parâmetros estão ausentes."
                    + seguroSinistro );
        }
    }
}

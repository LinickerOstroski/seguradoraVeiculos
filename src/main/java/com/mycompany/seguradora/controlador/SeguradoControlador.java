package com.mycompany.seguradora.controlador;

import com.mycompany.seguradora.modelo.dao.BonusDao;
import com.mycompany.seguradora.modelo.dao.SeguradoDao;
import com.mycompany.seguradora.modelo.dao.VeiculoDao;
import com.mycompany.seguradora.modelo.entidade.Bonus;
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
import java.sql.Date;
import java.util.List;

@WebServlet(WebConstantes.BASE_PATH + "/SeguradoControlador")
public class SeguradoControlador extends HttpServlet {

    private BonusDao bonusDao;
    private Bonus bonus;
    private VeiculoDao veiculoDao;
    private Veiculo veiculo;
    private SeguradoDao seguradoDao;
    private Segurado segurado;
    String idSegurado = "";
    String nomeSegurado = "";
    String dataNascimentoSegurado = "";
    String cepSegurado = "";
    String estadoSegurado = "";
    String enderecoSegurado = "";
    String bairroSegurado = "";
    String cidadeSegurado = "";
    String telefoneSegurado = "";
    String emailSegurado = "";
    String bonusSegurado = "";
    String veiculoSegurado = "";
    String opcao = "";
    private ConverteData converte = new ConverteData();

    @Override
    public void init() throws ServletException {
        bonusDao = new BonusDao();
        veiculoDao = new VeiculoDao();
        seguradoDao = new SeguradoDao();
        segurado = new Segurado();
        veiculo = new Veiculo();
        bonus = new Bonus();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            opcao = request.getParameter("opcao");
            idSegurado = request.getParameter("idSegurado");
            nomeSegurado = request.getParameter("nomeSegurado");
            dataNascimentoSegurado = request.getParameter("dataNascimentoSegurado");
            cepSegurado = request.getParameter("cepSegurado");
            estadoSegurado = request.getParameter("estadoSegurado");
            enderecoSegurado = request.getParameter("enderecoSegurado");
            bairroSegurado = request.getParameter("bairroSegurado");
            cidadeSegurado = request.getParameter("cidadeSegurado");
            telefoneSegurado = request.getParameter("telefoneSegurado");
            emailSegurado = request.getParameter("emailSegurado");
            bonusSegurado = request.getParameter("bonusSegurado");
            veiculoSegurado = request.getParameter("veiculoSegurado");

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

        String dataNascimentoStr = request.getParameter("dataNascimentoSegurado");
        segurado.setNomeSegurado(nomeSegurado);
        segurado.setDataNascimentoSegurado(converte.converteCalendario(dataNascimentoSegurado));
        segurado.setCepSegurado(cepSegurado);
        segurado.setEstadoSegurado(estadoSegurado);
        segurado.setEnderecoSegurado(enderecoSegurado);
        segurado.setBairroSegurado(bairroSegurado);
        segurado.setCidadeSegurado(cidadeSegurado);
        segurado.setTelefoneSegurado(telefoneSegurado);
        segurado.setEmailSegurado(emailSegurado);
       
        segurado.getBonusSegurado().setIdBonus(Integer.valueOf(bonusSegurado));
        segurado.getVeiculoSegurado().setIdVeiculo(Integer.valueOf(veiculoSegurado));
        
        seguradoDao.salvar(segurado);
        encaminharParaPagina(request, response);
    }

    private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("idSegurado", idSegurado);
        request.setAttribute("opcao", "confirmarEditar");
        request.setAttribute("nomeSegurado", nomeSegurado);
        request.setAttribute("dataNascimentoSegurado", ConverteData.convertDateFormat(dataNascimentoSegurado));
        request.setAttribute("cepSegurado", cepSegurado);
        request.setAttribute("estadoSegurado", estadoSegurado);
        request.setAttribute("enderecoSegurado", enderecoSegurado);
        request.setAttribute("bairroSegurado", bairroSegurado);
        request.setAttribute("cidadeSegurado", cidadeSegurado);
        request.setAttribute("telefoneSegurado", telefoneSegurado);
        request.setAttribute("emailSegurado", emailSegurado);
        request.setAttribute("bonusSegurado", bonusSegurado);
        request.setAttribute("veiculoSegurado", veiculoSegurado);
        request.setAttribute("mensagem", "Edite os dados e clique em salvar");
        encaminharParaPagina(request, response);
    }

    private void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("idSegurado", idSegurado);
        request.setAttribute("opcao", "confirmarExcluir");
        request.setAttribute("nomeSegurado", nomeSegurado);
        request.setAttribute("dataNascimentoSegurado", ConverteData.convertDateFormat(dataNascimentoSegurado));
        request.setAttribute("cepSegurado", cepSegurado);
        request.setAttribute("estadoSegurado", estadoSegurado);
        request.setAttribute("enderecoSegurado", enderecoSegurado);
        request.setAttribute("bairroSegurado", bairroSegurado);
        request.setAttribute("cidadeSegurado", cidadeSegurado);
        request.setAttribute("telefoneSegurado", telefoneSegurado);
        request.setAttribute("emailSegurado", emailSegurado);
        request.setAttribute("bonusSegurado", bonusSegurado);
        request.setAttribute("veiculoSegurado", veiculoSegurado);
        request.setAttribute("mensagem", "Clique em salvar para excluir");
        encaminharParaPagina(request, response);
    }

    private void confirmarEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        validaCampos();
        
        segurado.setIdSegurado(Integer.valueOf(idSegurado));
        segurado.setNomeSegurado(nomeSegurado);
        segurado.setDataNascimentoSegurado(converte.converteCalendario(dataNascimentoSegurado));
         
        segurado.setCepSegurado(cepSegurado);
        segurado.setEstadoSegurado(estadoSegurado);
        segurado.setEnderecoSegurado(enderecoSegurado);
        segurado.setBairroSegurado(bairroSegurado);
        segurado.setCidadeSegurado(cidadeSegurado);
        segurado.setTelefoneSegurado(telefoneSegurado);
        segurado.setEmailSegurado(emailSegurado);
        segurado.getVeiculoSegurado().setIdVeiculo(Integer.valueOf(veiculoSegurado));
        segurado.getBonusSegurado().setIdBonus(Integer.valueOf(bonusSegurado));
        seguradoDao.alterar(segurado);
        cancelar(request, response);
    }

    private void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        validaCampos();
        segurado.setIdSegurado(Integer.valueOf(idSegurado));
        segurado.setNomeSegurado(nomeSegurado);
        segurado.setDataNascimentoSegurado(converte.converteCalendario(dataNascimentoSegurado));
        segurado.setCepSegurado(cepSegurado);
        segurado.setEstadoSegurado(estadoSegurado);
        segurado.setEnderecoSegurado(enderecoSegurado);
        segurado.setBairroSegurado(bairroSegurado);
        segurado.setCidadeSegurado(cidadeSegurado);
        segurado.setTelefoneSegurado(telefoneSegurado);
        segurado.setEmailSegurado(emailSegurado);
        segurado.getVeiculoSegurado().setIdVeiculo(Integer.valueOf(veiculoSegurado));
        segurado.getBonusSegurado().setIdBonus(Integer.valueOf(bonusSegurado));
        seguradoDao.excluir(segurado);
        cancelar(request, response);
    }

    private void cancelar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("idSegurado", "0");
        request.setAttribute("opcao", "cadastrar");
        request.setAttribute("nomeSegurado", "");
        request.setAttribute("dataNascimentoSegurado", "");
        request.setAttribute("cepSegurado", "");
        request.setAttribute("estadoSegurado", "");
        request.setAttribute("enderecoSegurado", "");
        request.setAttribute("bairroSegurado", "");
        request.setAttribute("cidadeSegurado", "");
        request.setAttribute("telefoneSegurado", "");
        request.setAttribute("emailSegurado", "");
        request.setAttribute("bonusSegurado", "");
        request.setAttribute("veiculoSegurado", "");
        encaminharParaPagina(request, response);
    }

    private void encaminharParaPagina(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        List<Bonus> bonuses = bonusDao.buscarTodos();
        request.setAttribute("bonuses", bonuses);
        
        List<Veiculo> veiculos = veiculoDao.buscarTodas();
        request.setAttribute("veiculos", veiculos);

        List<Segurado> segurados = seguradoDao.buscarTodos();
        request.setAttribute("segurados", segurados);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/cadastroSegurado.jsp");
        dispatcher.forward(request, response);
    }

    public void validaCampos() {
        if (nomeSegurado == null || nomeSegurado.isEmpty()
                || dataNascimentoSegurado == null || dataNascimentoSegurado.isEmpty()
                || cepSegurado == null || cepSegurado.isEmpty()
                || estadoSegurado == null || estadoSegurado.isEmpty()
                || enderecoSegurado == null || enderecoSegurado.isEmpty()
                || bairroSegurado == null || bairroSegurado.isEmpty()
                || cidadeSegurado == null || cidadeSegurado.isEmpty()
                || telefoneSegurado == null || telefoneSegurado.isEmpty()
                || emailSegurado == null || emailSegurado.isEmpty()
                || bonusSegurado == null || bonusSegurado.isEmpty()
                || veiculoSegurado == null || veiculoSegurado.isEmpty()) {
            throw new IllegalArgumentException("Um ou mais parâmetros estão ausentes."
                    + bonusSegurado + " " + veiculoSegurado);
            
            
            
        }
    }
}

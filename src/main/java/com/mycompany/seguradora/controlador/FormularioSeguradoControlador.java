package com.mycompany.seguradora.controlador;

import com.mycompany.seguradora.modelo.dao.FormularioSeguradoDao;
import com.mycompany.seguradora.modelo.entidade.FormularioSegurado;
import com.mycompany.seguradora.servico.WebConstantes;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(WebConstantes.BASE_PATH + "/FormularioSeguradoControlador")
public class FormularioSeguradoControlador extends HttpServlet {

    private FormularioSeguradoDao formularioSeguradoDao;
    private FormularioSegurado formularioSegurado;
    String idFormularioSegurado = "";
    String nomeFormularioSegurado = "";
    String emailFormularioSegurado = "";
    String telefoneFormularioSegurado = "";
 
    String opcao = "";

    @Override
    public void init() throws ServletException {
        formularioSeguradoDao = new FormularioSeguradoDao();
        formularioSegurado = new FormularioSegurado();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            opcao = request.getParameter("opcao");
            idFormularioSegurado = request.getParameter("idFormularioSegurado");
            nomeFormularioSegurado = request.getParameter("nomeFormularioSegurado");
            emailFormularioSegurado = request.getParameter("emailFormularioSegurado");
            telefoneFormularioSegurado = request.getParameter("telefoneFormularioSegurado");
          
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
        formularioSegurado.setNomeFormularioSegurado(nomeFormularioSegurado);
        formularioSegurado.setEmailFormularioSegurado(emailFormularioSegurado);
        formularioSegurado.setTelefoneFormularioSegurado(telefoneFormularioSegurado);
        formularioSeguradoDao.salvar(formularioSegurado);
        encaminharParaPagina(request, response);
    }

    private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("idFormularioSegurado", idFormularioSegurado);
        request.setAttribute("opcao", "confirmarEditar");
        request.setAttribute("nomeFormularioSegurado", nomeFormularioSegurado);
        request.setAttribute("emailFormularioSegurado", emailFormularioSegurado);
        request.setAttribute("telefoneFormularioSegurado", telefoneFormularioSegurado);
        request.setAttribute("mensagem", "Edite os dados e clique em salvar");
        encaminharParaPagina(request, response);
    }

    private void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        request.setAttribute("idFormularioSegurado", idFormularioSegurado);
        request.setAttribute("opcao", "confirmarExcluir");
        request.setAttribute("nomeFormularioSegurado", nomeFormularioSegurado);
        request.setAttribute("emailFormularioSegurado", emailFormularioSegurado);
        request.setAttribute("telefoneFormularioSegurado", telefoneFormularioSegurado);
        
        
        request.setAttribute("mensagem", "Clique em salvar para confirmar a exclusão dos dados");
        encaminharParaPagina(request, response);
    }

    private void confirmarEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            validaCampos(); 

            FormularioSegurado formularioSegurado1 = new FormularioSegurado();
            formularioSegurado1.setIdFormularioSegurado(parseInt(request.getParameter("idFormularioSegurado")));
            formularioSegurado1.setNomeFormularioSegurado(request.getParameter("nomeFormularioSegurado"));
            formularioSegurado1.setEmailFormularioSegurado(request.getParameter("emailFormularioSegurado"));
            formularioSegurado1.setTelefoneFormularioSegurado(request.getParameter("telefoneFormularioSegurado"));
            
            formularioSeguradoDao.alterar(formularioSegurado1);
            cancelar(request, response);
        } catch (IllegalArgumentException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Erro na validação dos campos: " + e.getMessage());
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro inesperado: " + e.getMessage());
        }
    }

    
    private int parseInt(String value) {
        return (value != null && !value.isEmpty()) ? Integer.parseInt(value) : 0;
    }
    
    private void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        formularioSegurado.setIdFormularioSegurado(Integer.valueOf(request.getParameter("idFormularioSegurado")));
        formularioSeguradoDao.excluir(formularioSegurado);
        cancelar(request, response);
    }

    private void cancelar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("idFormularioSegurado", "0");
        request.setAttribute("opcao", "cadastrar");
        request.setAttribute("nomeFormularioSegurado", "");
        request.setAttribute("emailFormularioSegurado", "");
        request.setAttribute("telefoneFormularioSegurado", "");
        encaminharParaPagina(request, response);
    }

    private void encaminharParaPagina(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<FormularioSegurado> formulariosSegurados = formularioSeguradoDao.buscarTodas();
        request.setAttribute("formulariosSegurados", formulariosSegurados);
        request.setAttribute(opcao, opcao);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/cadastroFormularioSegurado.jsp");
        dispatcher.forward(request, response);

    }

    public void validaCampos() {
        if (nomeFormularioSegurado == null || nomeFormularioSegurado.isEmpty()
                || emailFormularioSegurado == null || emailFormularioSegurado.isEmpty()
                || telefoneFormularioSegurado == null || telefoneFormularioSegurado.isEmpty()) {
            throw new IllegalArgumentException("Um ou mais parâmetros estão ausentes");
        }
    }

}

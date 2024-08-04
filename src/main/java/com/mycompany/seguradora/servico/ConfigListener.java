/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.seguradora.servico;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

/**
 *
 * @author tulio
 */
@WebListener
public class ConfigListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
      
        sce.getServletContext().setAttribute("URL_BASE", WebConstantes.BASE_PATH);
        // estou usando no .jsp
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // Limpeza, se necessário.
    }
}

/*
A classe ConfigListener, é um exemplo de como utilizar a interface ServletContextListener dentro de uma aplicação Java EE para monitorar eventos 
de ciclo de vida do contexto de um servlet. Essa classe é anotada com @WebListener, o que indica ao servidor web ou ao container de aplicações que 
ela deve ser registrada como um listener de eventos de contexto de servlet.

Aqui está uma explicação de cada parte da classe:

@WebListener: Esta anotação é usada para declarar que a classe é um listener de eventos relacionados ao ciclo de vida de contexto de servlets, 
sessões ou requests dentro de uma aplicação web. Ela informa ao container que a classe deve ser instanciada e chamada em resposta a esses eventos. 
Não é necessário adicionar configurações adicionais no web.xml.
implements ServletContextListener: A classe implementa a interface ServletContextListener, que define dois métodos para lidar com eventos de 
inicialização e destruição do contexto da aplicação (contextInitialized e contextDestroyed, respectivamente).
Método contextInitialized(ServletContextEvent sce): Este método é chamado pelo container quando o contexto da aplicação web é inicializado. 
No exemplo, ele é usado para configurar um atributo no ServletContext, que é um espaço de armazenamento que todos os servlets e JSPs podem 
acessar durante a vida útil da aplicação. sce.getServletContext().setAttribute("URL_BASE", WebConstantes.BASE_PATH); configura uma constante que 
pode ser usada por toda a aplicação para referenciar uma base de URL.
Método contextDestroyed(ServletContextEvent sce): Este método é chamado quando o contexto da aplicação está sendo destruído, ou seja, quando a 
aplicação está sendo encerrada. É o lugar ideal para liberar recursos, parar threads ou realizar qualquer outra limpeza necessária antes da aplicação 
ser completamente desativada.
Essa abordagem é útil para realizar configurações necessárias antes de qualquer servlet ou filtro ser iniciado e para limpar recursos antes da aplicação
ser desmontada, garantindo que a aplicação libere recursos de maneira adequada.


*/
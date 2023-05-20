package web;

import dao.Cadastro;
import service.CadastroService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = "/cadastro")
public class CadastroServlet extends HttpServlet {

    private static final CadastroService cadastroService = new CadastroService();

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/views/cadastro.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("cadastrado", "");

        Long numProcedimento = Long.valueOf(request.getParameter("idProcedimento"));
        String descricao = request.getParameter("descricao");
        Integer idade = Integer.valueOf((request.getParameter("idade")));
        String sexo = request.getParameter("sexo");
        boolean isAutorizado = Boolean.parseBoolean(request.getParameter("isAutorizado"));

        String resposta = cadastrar(numProcedimento, descricao, idade, sexo, isAutorizado);

        request.setAttribute("cadastrado", resposta);
        request.getRequestDispatcher("/WEB-INF/views/cadastro.jsp").forward(request, response);
    }

    private String cadastrar(Long numProcedimento, String descricao, Integer idade, String sexo, boolean isAutorizado) {
        if (cadastroService.cadastrar(new Cadastro(numProcedimento, descricao, idade, sexo, isAutorizado))) {
            return "Cadastrado com Sucesso";
        }
        return "Erro a cadastrar precedimento";
    }
}

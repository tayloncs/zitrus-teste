package web;

import dao.Autorizacao;
import service.AutorizacaoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

import static java.util.Objects.*;

@WebServlet(urlPatterns = "")
public class AutorizacaoServlet extends HttpServlet {
    private static final AutorizacaoService autorizacaoService = new AutorizacaoService();

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException,
        IOException {
        String idProcedimento = request.getParameter("idProcedimento");
        String idade = request.getParameter("idade");
        String sexo = request.getParameter("sexo");
        if (nonNull(idProcedimento) && nonNull(idade) && nonNull(sexo)) {
            String resposta = validarProcedimento(Long.parseLong(idProcedimento), Integer.parseInt(idade), sexo);
            request.setAttribute("autorizacao", resposta);
        }

        request.setAttribute("idProcedimento", idProcedimento);
        request.setAttribute("idade", idade);
        request.setAttribute("sexo", sexo);

        request.getRequestDispatcher("/WEB-INF/views/autorizacao.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {


        request.getRequestDispatcher("/WEB-INF/views/autorizacao.jsp").forward(request, response);
    }

    private String validarProcedimento(Long idProcedimento, Integer idade, String sexo) {
        Autorizacao autorizacao = Autorizacao.builder().idProcedimento(idProcedimento).idade(idade).sexo(sexo).build();
        Autorizacao autorizacaoResponse = autorizacaoService.consultar(autorizacao);
        if (nonNull(autorizacaoResponse)) {
            if (autorizacaoResponse.isPermitido()) {
                return "Autorizado";
            } else {
                return "Não Autorizado";
            }
        } else {
            return "Registro não encontrado";
        }

    }
}


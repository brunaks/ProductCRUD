package core;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeletarProdutoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProdutoRepository repository = new MySQLProdutoRepository();
        UIReceiver receiver = new UIReceiver();
        DeletarProdutoUseCase deletarProduto = new DeletarProdutoUseCase(repository, receiver, request.getParameter("id"));
        deletarProduto.execute();
        if (receiver.produtoFoiDeletado) {
            response.sendRedirect("/index.jsp#deleted");
        }
    }
}

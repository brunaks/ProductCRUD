package core;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateProdutoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Produto produto = new Produto(request.getParameter("nome"));
        String id = request.getParameter("id");
        produto.setId(id);
        ProdutoRepository repository = new MySQLProdutoRepository();
        UIReceiver receiver = new UIReceiver();
        UpdateProdutoUseCase updateProduto = new UpdateProdutoUseCase(repository, receiver, produto);
        updateProduto.execute();
        if (receiver.produtoFoiAtualizado)
            response.sendRedirect("/index.jsp");
        else
            response.sendRedirect(String.format("/editar_produto.jsp?id=%s&erro=nome_em_branco", id));
    }
}

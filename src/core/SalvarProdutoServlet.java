package core;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SalvarProdutoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Produto produto = new Produto(request.getParameter("nome"));
        ProdutoRepository repository = new MySQLProdutoRepository();
        UIReceiver receiver = new UIReceiver();
        RegistrarProduto registrarProduto = new RegistrarProduto(repository, receiver, produto);
        registrarProduto.execute();
        if (receiver.produtoFoiSalvo) {
            response.sendRedirect("/index.jsp");
        } else {
            response.sendRedirect("/registrar_produto.jsp?erro=nome_em_branco");
        }
    }
}

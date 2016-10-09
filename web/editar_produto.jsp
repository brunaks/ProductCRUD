<%@ page import="core.ListarProdutos" %>
<%@ page import="core.ProdutoRepository" %>
<%@ page import="core.MySQLProdutoRepository" %>
<%@ page import="core.Produto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Editar Produto</title>
</head>
<body>
<%

    ProdutoRepository repository = new MySQLProdutoRepository();
    ListarProdutos listarProdutos = new ListarProdutos(repository);
    Produto produto = listarProdutos.obtemPorId(request.getParameter("id"));
    pageContext.setAttribute("produto", produto);

    String erro = request.getParameter("erro");
    if (erro != null && !erro.isEmpty()) {
        pageContext.setAttribute("erro", "Erro: " + erro);
    }
%>
</body>
<form action="/update_produto" method="post">
    <label for="nome">Nome</label>
    <input type="text" name="nome" id="nome" value="${produto.obtemNome()}">
    <input type="text" name="id" value="${produto.obtemId()}" hidden>
    <input type="submit" value="Update">
</form>
<p>${erro}</p>
</html>

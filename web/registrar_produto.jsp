<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registrar Produto</title>
</head>
<body>
<%
    String erro = request.getParameter("erro");
    if (erro != null && !erro.isEmpty())
        pageContext.setAttribute("erro", "Erro: " + erro);
%>
<form action="/salvar_produto" method="post">
    <label for="nome">Nome</label>
    <input type="text" name="nome" id="nome">
    <input type="submit" value="Salvar">
</form>
<p>${erro}</p>
</body>
</html>

<%@ page import="java.util.ArrayList" %>
<%@ page import="core.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Produtos</title>
    <link rel="stylesheet" href="primeui-4.1.15/themes/bootstrap/theme.css" />
    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.css" />
    <link rel="stylesheet" href="primeui-4.1.15/primeui.min.css" />
    <%--<link href="http://www.primefaces.org/css/all.css" rel="stylesheet">--%>
    <script   src="http://code.jquery.com/jquery-3.1.1.js"   integrity="sha256-16cdPddA6VdVInumRGo6IbivbERE8p7CQR3HzTBuELA="   crossorigin="anonymous"></script>
    <script   src="http://code.jquery.com/ui/1.12.1/jquery-ui.js"   integrity="sha256-T0Vest3yCU7pafRw9r+settMBX6JkKN06dqBnpQ8d30="   crossorigin="anonymous"></script>
    <script type="text/javascript" src="primeui-4.1.15/primeui.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/x-tag/1.5.11/x-tag-core.min.js"></script>
    <script type="text/javascript" src="primeui-4.1.15/primeelements.js"></script>
<script>

    function updateMessage() {

        if (window.location.hash === "#deleted") {
            $('#default').puigrowl();
            $('#default').puigrowl('show', [{
                severity: 'info',
                summary: 'Deleção realizada com sucesso',
                detail: 'Deleção realizada com sucesso'
            }]);
        }
    }

</script>
</head>
<body onload="updateMessage()">
<%
    ProdutoRepository repository = new MySQLProdutoRepository();
    ListarProdutos listarProdutos = new ListarProdutos(repository);
    pageContext.setAttribute("produtos", listarProdutos.obtemTodos());
%>
<a href="/registrar_produto.jsp">Registrar novo produto</a>
<table>
    <tr>
        <th>Nome</th>
        <th>Ações</th>
    </tr>
    <%--<p:growl id="growl" showDetail="true" sticky="true" />--%>
    <div id="default" />

    <c:forEach var="produto" items="${produtos}" varStatus="loop">
        <tr>
            <td>${produto.obtemNome()}</td>
            <td>
                <a href="deletar_produto?id=${produto.obtemId()}"">Deletar</a>
                <a href="editar_produto.jsp?id=${produto.obtemId()}">Editar</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

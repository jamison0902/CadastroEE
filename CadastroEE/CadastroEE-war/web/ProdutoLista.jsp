<%-- 
    Document   : ProdutoLista
    Created on : Sep 9, 2023, 10:12:26 AM
    Author     : jsq
--%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="cadastroee.model.Produto"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Listagem de Produtos</title>

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
    </head>
    <body class="container">

        <h1>Listagem de Produtos</h1>

        <div class="text-end"><a class="btn btn-primary m-2" href="ServletProdutoFC?acao=formIncluir">Novo Produto</a></div>

        <table class="table table-striped">
            <thead class="table-dark">
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Quantidade</th>
                    <th>Preço</th>
                    <th>Ações</th>
                </tr>

            </thead>


            <%
                DecimalFormat df = new DecimalFormat("#,##0.00");
                List<Produto> produto = (List<Produto>) request.getAttribute("produtos");
                if (produto != null) {
                    for (Produto e : produto) {
            %>
            <tr>
                <td><%=e.getIdProduto()%></td>
                <td><%=e.getNome()%></td>
                <td><%=e.getQuantidade()%></td>
                <td>R$ <%=df.format(e.getPrecoVenda())%></td>                
                <td>
                    <a class="btn btn-primary btn-sm " href="ServletProdutoFC?acao=formAlterar&id=<%=e.getIdProduto()%>">Alterar</a>
                    <a class="btn btn-danger btn-sm" href="ServletProdutoFC?acao=excluir&id=<%=e.getIdProduto()%>">Excluir</a>
                </td>               
            </tr>
            <% }
            } else {
            %>
            <tr>
                <td colspan="5">Nenhum produto encontrado.</td>
            </tr>
            <% }
            %>   
        </table>

    </body>
</html>

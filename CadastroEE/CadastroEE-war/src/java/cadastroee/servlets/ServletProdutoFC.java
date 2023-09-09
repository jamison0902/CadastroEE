/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package cadastroee.servlets;

import cadastroee.model.Produto;
import cadatroee.controller.ProdutoFacadeLocal;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jsq
 */
@WebServlet(name = "ServletProdutoFC", urlPatterns = {"/ServletProdutoFC"})
public class ServletProdutoFC extends HttpServlet {

    @EJB
    ProdutoFacadeLocal facade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String acao = request.getParameter("acao");

        acao = acao == null ? "index" : acao;

        String destino;

        switch (acao) {
            case "formIncluir":
                destino = "ProdutoDados.jsp";
                break;
            case "incluir":
                String nome = request.getParameter("nome");
                int quantidade = Integer.parseInt(request.getParameter("quantidade"));
                Float precoVenda = Float.valueOf(request.getParameter("precoVenda"));
                Produto newProduto = new Produto();
                newProduto.setNome(nome);
                newProduto.setQuantidade(quantidade);
                newProduto.setPrecoVenda(precoVenda);
                facade.create(newProduto);
                List<Produto> newProdutos = facade.findAll();
                request.setAttribute("produtos", newProdutos);
                destino = "ProdutoLista.jsp";
                break;
            case "excluir":
                int idDel = Integer.parseInt(request.getParameter("id"));
                facade.remove(facade.find(idDel));
                List<Produto> delProdutos = facade.findAll();
                request.setAttribute("produtos", delProdutos);
                destino = "ProdutoLista.jsp";
                break;
            case "formAlterar":
                int id = Integer.parseInt(request.getParameter("id"));
                Produto produto = facade.find(id);
                request.setAttribute("produto", produto);
                destino = "ProdutoDados.jsp";
                break;
            case "alterar":
                Produto alterarProduto = facade.find(Integer.valueOf(request.getParameter("id")));
                String alterarNome = request.getParameter("nome");
                int alterarQuantidade = Integer.parseInt(request.getParameter("quantidade"));
                Float alterarPrecoVenda = Float.valueOf(request.getParameter("precoVenda"));                
                alterarProduto.setNome(alterarNome);
                alterarProduto.setQuantidade(alterarQuantidade);
                alterarProduto.setPrecoVenda(alterarPrecoVenda);
                facade.edit(alterarProduto);
                List<Produto> alterarProdutos = facade.findAll();
                request.setAttribute("produtos", alterarProdutos);
                destino = "ProdutoLista.jsp";
                break;
            default:
                List<Produto> produtos = facade.findAll();
                request.setAttribute("produtos", produtos);
                destino = "ProdutoLista.jsp";
                break;
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(destino);
        dispatcher.forward(request, response);

    }

}

package core;

import java.util.List;

public class ListarProdutos {

    private ProdutoRepository produtoRepository;

    public ListarProdutos(ProdutoRepository repository) {
        produtoRepository = repository;
    }

    public List<Produto> obtemTodos() {
        return produtoRepository.obtemTodos();
    }

    public Produto obtemPorId(String id) {
        return produtoRepository.obtemPorId(id);
    }
}

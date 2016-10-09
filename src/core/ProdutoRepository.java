package core;

import java.util.List;

public interface ProdutoRepository {
    void inserir(Produto produto);

    void deletar(String id);

    List<Produto> obtemTodos();

    Produto obtemPorId(String id);

    void atualizar(Produto produto);
}

package core;

public class RegistrarProduto {
    private Receiver receiver;
    private ProdutoRepository produtoRepository;
    private Produto produto;

    public RegistrarProduto(ProdutoRepository repository, Receiver receiver, Produto produto) {
        this.produto = produto;
        produtoRepository = repository;
        this.receiver = receiver;
    }

    public void execute() {
        if (produto.obtemNome().isEmpty()) {
            receiver.nomeInvalido();
        } else {
            this.produtoRepository.inserir(produto);
            this.receiver.produtoFoiSalvo();
        }
    }
}

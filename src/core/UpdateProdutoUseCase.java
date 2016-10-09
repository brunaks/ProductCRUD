package core;

public class UpdateProdutoUseCase {
    private Produto produto;
    private Receiver receiver;
    private ProdutoRepository productRepository;

    public UpdateProdutoUseCase(ProdutoRepository repository, Receiver receiver, Produto produto) {
        this.productRepository = repository;
        this.receiver = receiver;
        this.produto = produto;
    }

    public void execute() {
        if (produto.obtemNome().isEmpty()) {
            receiver.nomeInvalido();
        } else {
            productRepository.atualizar(produto);
            receiver.produtoFoiAtualizado();
        }
    }
}

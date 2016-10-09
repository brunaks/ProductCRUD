package core;

public class DeletarProdutoUseCase {
    private Receiver receiver;
    private ProdutoRepository repository;
    private String id;

    public DeletarProdutoUseCase(ProdutoRepository repository, Receiver receiver, String id) {
        this.repository = repository;
        this.receiver = receiver;
        this.id = id;
    }

    public void execute() {
        repository.deletar(id);
        receiver.produtoFoiDeletado();
    }
}

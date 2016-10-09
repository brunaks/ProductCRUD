package core;

public class UIReceiver implements Receiver {

    public boolean produtoFoiSalvo;
    public boolean produtoFoiDeletado;
    public boolean produtoFoiAtualizado;
    public boolean nomeInvalido;

    public void produtoFoiSalvo() {
        produtoFoiSalvo = true;
    }

    public void produtoFoiDeletado() {
        produtoFoiDeletado = true;
    }

    public void produtoFoiAtualizado() {
        produtoFoiAtualizado = true;
    }

    public void nomeInvalido() {
        nomeInvalido = true;
    }
}

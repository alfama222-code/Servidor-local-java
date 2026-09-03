package modal;

public class servicoDigital extends Servico {
    public String linkDownload;

    public servicoDigital(String titulo, String descricao, double preco, Boolean estaAtivo, String linkDownload) {
        super(titulo, descricao, preco, estaAtivo);
        this.linkDownload = linkDownload;
    }
}


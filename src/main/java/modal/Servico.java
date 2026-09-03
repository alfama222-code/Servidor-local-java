package modal;

public class Servico {
    private String  titulo;
    public String descricao;
    private Double preco;
    public Boolean estaAtivo;


    public Servico(String Titulo,String Descricao,Double Preco,Boolean Estado) {
        this.titulo = Titulo;
        this.descricao = Descricao;
        this.preco = Preco;
        this.estaAtivo = Estado;
    }
    public Double getPreco () {
        return this.preco;
    }
    public String getTitulo () {
        return this.titulo;
    }


    public void aplicarDesconto(double percentagem ){
        double valorDesconto = (this.preco * percentagem) / 100;

        this.preco = this.preco - valorDesconto;

        System.out.println("Desconto aplicado com sucesso!");
        System.out.println("valor final:" + this.preco);
    }

    public void verificarDesponibilidade(){
        if (this.estaAtivo) {
            System.out.println("servico: " + this.estaAtivo + " Servico esta ativo");

        } else {
            System.out.println("servico: " + this.estaAtivo + " Servico nao esta ativo");
        }
    }
}


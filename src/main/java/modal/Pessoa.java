package modal;

import java.util.ArrayList;
import java.util.List;

public class  Pessoa {
    private String name;
    private String morada;
    private Integer idade;
    private Double saldo;

    List<Servico> servicosComprados;

    public Pessoa(String novoName, String novaMorada, Integer novaIdade,Double novoSaldo) {
        this.name = novoName;
        this.morada = novaMorada;
        this.idade = novaIdade;
        this.saldo = novoSaldo;

        this.servicosComprados = new ArrayList<>();

    }
    public void setName (String name) {
        this.name=name;
    }
    public String getName () {
        return this.name;
    }
    public void setMorada (String morada) {
        this.morada=morada;
    }
    public String getMorada () {
        return this.morada;
    }
    public void setIdade (Integer idade) {
        this.idade=idade;
    }
    public Integer getIdade() {
        return this.idade;
    }
    public void setSaldo (Double saldo) {
        this.saldo=saldo;
    }
    public Double getSaldo () {
        return this.saldo;
    }
    public List getservicoComprados (){
        return this.servicosComprados;
    }


    public void comprarServico(Servico servicoEscolhido) throws Exception{
        if (this.saldo <= servicoEscolhido.getPreco() || !servicoEscolhido.estaAtivo) {
            System.out.println("Erro: Saldo insuficiente.");
            throw new Exception("Erro: Saldo Insuficiente ou Servico Inativo");

        }
        this.saldo -= servicoEscolhido.getPreco();
        this.servicosComprados.add(servicoEscolhido);
        System.out.println("compra efetuada com sucesso");
    }

    public void mostrarHistorico() {
        System.out.println("//--------Lista de servicos comprados------//");

        for(Servico s: this.servicosComprados) {
            System.out.println("Servico: " + s.getTitulo());

        }
    }
}

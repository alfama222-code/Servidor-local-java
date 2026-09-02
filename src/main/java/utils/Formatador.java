package utils;

import modal.Pessoa;
import modal.Servico;
import modal.Vendedor;
import modal.servicoDigital;

import java.util.List;

public class Formatador {

    public void imprimirPessoa(Pessoa pessoa) {
        System.out.println("//-------Dados de:  " + pessoa.getName() + "-------//");

        System.out.println("Name: " + pessoa.getName());
        System.out.println("Morada: " + pessoa.getMorada());
        System.out.println("Idade: " + pessoa.getIdade());
        System.out.println("Saldo: " + pessoa.getSaldo());

        System.out.println("//-------------------------//");
    }

    public void imprimirServico(Servico servico) {
        System.out.println("//-------Dados de:  " + servico.getTitulo() + "-------//");

        System.out.println("Name: " + servico.getTitulo());
        System.out.println("Descricao: " + servico.descricao);
        System.out.println("Preco: " + servico.getPreco());
        System.out.println("Estado: " + servico.estaAtivo);

        System.out.println("//-------------------------//");
    }

    public void imprimirVendedor(Vendedor vendedor) {
        System.out.println("//-------Dados de:  " + vendedor.getName() + "-------//");

        System.out.println("Name: " + vendedor.getName());
        System.out.println("Morada: " + vendedor.getMorada());
        System.out.println("Idade: " + vendedor.getIdade());
        System.out.println("Saldo: " + vendedor.getSaldo());
        System.out.println("Taxacomissao: " + vendedor.getTaxaComissao());


        System.out.println("//-------------------------//");

    }
    public void imprimirservicoDigital(servicoDigital servicoDigital) {
        System.out.println("//-------Dados de: " + servicoDigital.getTitulo() + "------//");

        System.out.println("Titulo: " + servicoDigital.getTitulo());
        System.out.println( "Descricao: " + servicoDigital.descricao);
        System.out.println("Preco: " + servicoDigital.getPreco());
        System.out.println("Estado: " + servicoDigital.estaAtivo);
        System.out.println("linkDownload: " + servicoDigital.linkDownload);
    }




    public void imprimirListaDeServicosComprados(Pessoa pessoa) {
        List<Servico> ListaDeServicos = pessoa.getservicoComprados();

        System.out.println("//-----Servicos Comprados por: " + pessoa.getName() + "-----//");

        if (!ListaDeServicos.isEmpty()) {
           for (Servico s:ListaDeServicos) {
               System.out.println("Servico " + s.getTitulo());
           }
        }
        System.out.println("//------------------//");
    }

   public void imprimirListaDeServicosAvenda(Vendedor vendedor) {
        List<Servico> ListaDeservicosAvenda = vendedor.getservicosAVenda();

       System.out.println("//------Servicos Vendidos por: " + vendedor.getservicosAVenda() + "-----//");

       if (!ListaDeservicosAvenda.isEmpty()) {
           for (Servico s:ListaDeservicosAvenda) {
               System.out.println("Vendedor " + vendedor.getservicosAVenda());
           }
       }
       System.out.println("//------------------//");
   }


}
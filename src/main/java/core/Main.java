package core;

import com.google.gson.Gson;
import modal.*;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import utils.ExportadorDados;
import utils.Formatador;


public class Main {
    public static void main(String[] args) {
        Formatador impressora = new Formatador();

        //------Pessoa------//
        Pessoa pessoa1 = new Pessoa("ismar", "S.Pedro", 21, 7000.00);
        Pessoa pessoa2 = new Pessoa("javaismar","baguida",23,3000.0);
        impressora.imprimirPessoa(pessoa1);
        impressora.imprimirPessoa(pessoa2);

        //------Servico--------//
        Servico servico1 = new Servico("Website aplications", "Website descricao", 3000.00, true);
        Servico servico2 = new Servico("frontend developer","manutencao de frint",5000.00,true);
        impressora.imprimirServico(servico1);
        impressora.imprimirServico(servico2);


        //-------SevicoDigital-------//
        servicoDigital servicoDigital = new servicoDigital("Servico digital", "teste digital", 100.00, true,
                "http://download.com");
        impressora.imprimirservicoDigital(servicoDigital);

        //--------Vendedor--------//
        Vendedor vendedor = new Vendedor("ismar","Safende",21,3000.0,20.0,9860051,"http://download.com");
        impressora.imprimirVendedor(vendedor);

        try {
            pessoa1.comprarServico(servico1);
            impressora.imprimirListaDeServicosComprados(pessoa1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }



    // Criar a Pessoa
    Pessoa pessoa3 =  new Pessoa("djoka","Tratxa",50,200000.0 ) ;

    //Criar 3 Serviços diferentes
    Servico servico3 = new Servico("canalizacao","cano entuoido",15.00, true);
    Servico servico4 = new Servico("Pintura","remudelaçao da cosinha",200.00,true);
    Servico servico5= new Servico("Vendas","produtos quimicos",10.0,true);



        try{
            pessoa3.comprarServico(servico3);
            pessoa3.comprarServico(servico4);
            pessoa3.comprarServico(servico5);

        }catch (Exception e){
            System.out.println(e.getMessage());
            }

        ExportadorDados.exportarCarrinhoParaJson(pessoa3);

        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest pedido = HttpRequest.newBuilder()
                    .uri(URI.create("https://dummyjson.com/products/1"))
                    .GET()
                    .build();

             HttpResponse<String> resposta = client.send(pedido, HttpResponse.BodyHandlers.ofString());

            System.out.println("Codigo de resosta: " + resposta.statusCode());
            System.out.println("Codigo de resposta: " + resposta.body());


            //exercico 7
            System.out.println("Exercicio 7");
            Gson tradutor = new Gson();

            ProdutosExternos  produto = tradutor.fromJson(resposta.body(),ProdutosExternos.class);
            System.out.println("produto importado e o " + produto.getTitle() + "e custa " + produto.getPrice()  + " dólares");

        }catch (Exception e) {
              System.out.println("ERRO ao chamar api: " + e.getMessage());
        }
    }

}



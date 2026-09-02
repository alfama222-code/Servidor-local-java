package modal;

import java.util.ArrayList;
import java.util.List;

public class Vendedor extends  Pessoa{


        private List<Servico> servicosAVenda;

        public double taxaComissao;
        public int telefone ;
        public String linkDonload;

        public Vendedor(String nome, String morada, int idade, double saldo, double taxaComissao, int telefone, String linkDonload) {
            super(nome, morada, idade, saldo);

            this.telefone = telefone;
            this.taxaComissao = taxaComissao;

            this.linkDonload = linkDonload;

            this.servicosAVenda = new ArrayList<>();
        }

        public double getTaxaComissao() {
            return taxaComissao;
        }
        public List getservicosAVenda() {
            return  servicosAVenda;
        }

        public void setTaxaComissao(double taxaComissao) {
            if (taxaComissao <= 0){
                System.out.println("A Taxa de comissão não pode ser menor ou igual a zero!");
                return;
            }
            this.taxaComissao = taxaComissao;
        }
        public void publicarServico(Servico novoServico) throws Exception {
            // Passo 4: SE o preço for <= 0, lançar exceção
            if (novoServico.getPreco() <= 0) {
                throw new Exception("O preço tem de ser superior a zero!");
            }
            // Passo 5: SENÃO, adicionar à lista
            this.servicosAVenda.add(novoServico);
            System.out.println("compra efetuada com sucesso");
        }
    }


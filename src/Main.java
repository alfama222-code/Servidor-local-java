//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class Pessoa {
       String name;
       String morada;
       int idade;

       public Pessoa(String novoName,String novaMorada,int novaIdade) {
            this.name = novoName;
            this.morada = novaMorada;
            this.idade = novaIdade;
    }
}

public class Main {
    public static void main(String[] args) {
        Pessoa pessoa1 = new Pessoa("Ismar", "S.Pedro", 21);

        System.out.println("/-------------------Pessoa 1---------------------/");
        System.out.println("name da pessoa1: " + pessoa1.name);
        System.out.println("morada da pessoa1: " + pessoa1.morada);
        System.out.println("idade da pessoa1: " + pessoa1.idade);

        System.out.println("/------------------------/");

        System.out.println("Hello Word");

        String name = "Ismar";
        String morada = "S.Pedro";
        int idade = 21;

        System.out.println("Name: " + name);
        System.out.println("Morada: " + morada);
        System.out.println("Idade: " + idade);

        System.out.println("/-------------------Servico---------------------/");

        Servico servico1 = new Servico("Formaçao de java", "criaçao de logotipo", 50.90, true);
        System.out.println("Titulo: " + servico1.titulo);
        System.out.println("Descricao: " + servico1.descricao);
        System.out.println("Preco: " + servico1.preco);
        System.out.println("Ativo: " + servico1.estaAtivo);

    }
       public static class Servico {
            String  titulo;
            String descricao;
            Double preco;
            Boolean estaAtivo;

            public Servico(String novoTitulo,String novaDescricao,Double novoPreco,Boolean novaEstado) {
                this.titulo = novoTitulo;
                this.descricao = novaDescricao;
                this.preco = novoPreco;
                this.estaAtivo = novaEstado;
            }
        }
    }

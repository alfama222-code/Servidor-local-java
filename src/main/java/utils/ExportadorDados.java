package utils;

import modal.Pessoa;
import com.google.gson.Gson;

public class ExportadorDados {

    public static void exportarCarrinhoParaJson(Pessoa cliente) {
        Gson tradutor = new Gson();

        String json = tradutor.toJson(cliente.getservicoComprados());

        System.out.println(json);

    }
}
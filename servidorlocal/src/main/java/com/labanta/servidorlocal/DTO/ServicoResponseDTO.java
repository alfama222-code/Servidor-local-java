package com.labanta.servidorlocal.DTO;

public class ServicoResponseDTO {

    private String Titulo;
    private Double precoFinal;

    public ServicoResponseDTO(String Titulo, Double precoFinal) {
        this.Titulo=Titulo;
        this.precoFinal=precoFinal;
    }

    public String getTitulo() {
        return Titulo;
    }
    public void setTitulo(String titulo) {
        this.Titulo= titulo;
    }
    public Double getPrecoFinal() {
        return  precoFinal;
    }
    public void setPrecoFinal(Double precoFinal){
        this.precoFinal=precoFinal;
    }
}

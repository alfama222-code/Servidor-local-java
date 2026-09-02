package com.labanta.servidorlocal.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ServicoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String linkDonload;
    private String titulo;
    private String descricao;
    private Double preco;
    private Boolean estaAtivo;
    private Double precoComDesconto;
    private String imagemCapa;

    public ServicoModel() {
    }

    public ServicoModel(
            String titulo,
            String descricao,
            Double preco,
            Boolean estaAtivo,
            Double precoComDesconto,
            String imagemCapa) {

        this.titulo = titulo;
        this.descricao = descricao;
        this.preco = preco;
        this.estaAtivo = estaAtivo;
        this.precoComDesconto = precoComDesconto;
        this.imagemCapa = imagemCapa;
    }

    public Long getId() {
        return id;
    }

    public String getLinkDonload() {
        return linkDonload;
    }

    public void setLinkDonload(String linkDonload) {
        this.linkDonload = linkDonload;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Boolean getEstaAtivo() {
        return estaAtivo;
    }

    public void setEstaAtivo(Boolean estaAtivo) {
        this.estaAtivo = estaAtivo;
    }

    public Double getPrecoComDesconto() {
        return precoComDesconto;
    }

    public void setPrecoComDesconto(Double precoComDesconto) {
        this.precoComDesconto = precoComDesconto;
    }

    public String getImagemCapa() {
        return imagemCapa;
    }
    public void setImagemCapa(String imagemCapa) {
        this.imagemCapa = imagemCapa;
    }

    public void criarServico(ServicoModel servico) {
    }
}



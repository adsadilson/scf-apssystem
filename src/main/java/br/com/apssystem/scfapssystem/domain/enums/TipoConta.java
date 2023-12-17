package br.com.apssystem.scfapssystem.domain.enums;

public enum TipoConta {
    CC("C/CORRENTE","CC"),
    R("Receita","R"),
    D("Despesa","D");

    private String descricao;
    private String sigla;

    private TipoConta(String descricao, String sigla) {
        this.descricao = descricao;
        this.sigla = sigla;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
}

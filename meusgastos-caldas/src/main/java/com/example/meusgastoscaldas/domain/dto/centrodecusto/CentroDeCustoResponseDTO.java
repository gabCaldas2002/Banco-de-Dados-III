package com.example.meusgastoscaldas.domain.dto.centrodecusto;

public class CentroDeCustoResponseDTO {
    private long id;
    private String descricao;
    private String observacao;

    public long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getObservacao() {
        return observacao;
    }
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}

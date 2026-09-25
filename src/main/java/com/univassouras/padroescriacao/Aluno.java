package com.univassouras.padroescriacao;

public class Aluno {

    private final String nome;
    private final Historico historico;
    private final Diploma diploma;

    public Aluno(String nome, FabricaAbstrata fabrica) {
        this.nome = nome;
        this.historico = fabrica.criarHistorico();
        this.diploma = fabrica.criarDiploma();
    }

    public String emitirHistorico() {
        return historico.gerar(nome);
    }

    public String emitirDiploma() {
        return diploma.gerar(nome);
    }

    public String getNome() {
        return nome;
    }
}

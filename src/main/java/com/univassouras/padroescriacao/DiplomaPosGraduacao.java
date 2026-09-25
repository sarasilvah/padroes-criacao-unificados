package com.univassouras.padroescriacao;

public class DiplomaPosGraduacao implements Diploma {

    @Override
    public String gerar(String nomeAluno) {
        return "Diploma de Pos-Graduacao emitido para: " + nomeAluno;
    }
}

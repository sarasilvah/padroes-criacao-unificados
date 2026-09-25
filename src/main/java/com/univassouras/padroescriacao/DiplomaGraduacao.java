package com.univassouras.padroescriacao;

public class DiplomaGraduacao implements Diploma {

    @Override
    public String gerar(String nomeAluno) {
        return "Diploma de Graduacao emitido para: " + nomeAluno;
    }
}

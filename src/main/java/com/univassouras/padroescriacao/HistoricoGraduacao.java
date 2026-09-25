package com.univassouras.padroescriacao;

public class HistoricoGraduacao implements Historico {

    @Override
    public String gerar(String nomeAluno) {
        return "Historico Escolar [Graduacao] - Aluno: " + nomeAluno + " | Curso: Bacharelado";
    }
}

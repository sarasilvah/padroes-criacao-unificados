package com.univassouras.padroescriacao;

public class HistoricoPosGraduacao implements Historico {

    @Override
    public String gerar(String nomeAluno) {
        return "Historico Escolar [Pos-Graduacao] - Aluno: " + nomeAluno + " | Curso: Mestrado";
    }
}

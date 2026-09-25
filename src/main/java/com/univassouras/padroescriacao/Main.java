package com.univassouras.padroescriacao;

public class Main {
    public static void main(String[] args) {
        FabricaAbstrata fabricaGraduacao = FactoryMethod.getInstance().criarFabrica(FabricaGraduacao.class);
        Aluno alunoGraduacao = new Aluno("Ana Souza", fabricaGraduacao);
        System.out.println(alunoGraduacao.emitirHistorico());
        System.out.println(alunoGraduacao.emitirDiploma());

        System.out.println();

        FabricaAbstrata fabricaPosGraduacao = FactoryMethod.getInstance().criarFabrica(FabricaPosGraduacao.class);
        Aluno alunoPosGraduacao = new Aluno("Carlos Lima", fabricaPosGraduacao);
        System.out.println(alunoPosGraduacao.emitirHistorico());
        System.out.println(alunoPosGraduacao.emitirDiploma());
    }
}

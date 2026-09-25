package com.univassouras.padroescriacao;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AlunoTest {

    @Test
    void alunoDeGraduacaoNaoDeveMisturarDocumentosDePosGraduacao() {
        FabricaAbstrata fabrica = FactoryMethod.getInstance().criarFabrica(FabricaGraduacao.class);
        Aluno aluno = new Aluno("Ana Souza", fabrica);

        assertTrue(aluno.emitirHistorico().contains("Graduacao"));
        assertTrue(aluno.emitirDiploma().contains("Graduacao"));
        assertFalse(aluno.emitirHistorico().contains("Pos-Graduacao"));
    }

    @Test
    void alunoDePosGraduacaoDeveReceberDocumentosCorretos() {
        FabricaAbstrata fabrica = FactoryMethod.getInstance().criarFabrica(FabricaPosGraduacao.class);
        Aluno aluno = new Aluno("Carlos Lima", fabrica);

        assertTrue(aluno.emitirHistorico().contains("Pos-Graduacao"));
        assertTrue(aluno.emitirDiploma().contains("Pos-Graduacao"));
    }

    @Test
    void documentosDoAlunoDevemConterONomeInformado() {
        FabricaAbstrata fabrica = FactoryMethod.getInstance().criarFabrica(FabricaGraduacao.class);
        Aluno aluno = new Aluno("Beatriz Rocha", fabrica);

        assertTrue(aluno.emitirHistorico().contains("Beatriz Rocha"));
        assertTrue(aluno.emitirDiploma().contains("Beatriz Rocha"));
    }
}

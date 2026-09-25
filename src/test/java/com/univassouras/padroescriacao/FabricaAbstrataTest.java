package com.univassouras.padroescriacao;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class FabricaAbstrataTest {

    @Test
    void fabricaGraduacaoDeveCriarHistoricoGraduacao() {
        FabricaAbstrata fabrica = new FabricaGraduacao();

        Historico historico = fabrica.criarHistorico();

        assertInstanceOf(HistoricoGraduacao.class, historico);
    }

    @Test
    void fabricaGraduacaoDeveCriarDiplomaGraduacao() {
        FabricaAbstrata fabrica = new FabricaGraduacao();

        Diploma diploma = fabrica.criarDiploma();

        assertInstanceOf(DiplomaGraduacao.class, diploma);
    }

    @Test
    void fabricaPosGraduacaoDeveCriarHistoricoPosGraduacao() {
        FabricaAbstrata fabrica = new FabricaPosGraduacao();

        Historico historico = fabrica.criarHistorico();

        assertInstanceOf(HistoricoPosGraduacao.class, historico);
    }

    @Test
    void fabricaPosGraduacaoDeveCriarDiplomaPosGraduacao() {
        FabricaAbstrata fabrica = new FabricaPosGraduacao();

        Diploma diploma = fabrica.criarDiploma();

        assertInstanceOf(DiplomaPosGraduacao.class, diploma);
    }
}

package com.univassouras.padroescriacao;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertSame;

class FactoryMethodTest {

    @Test
    void getInstanceDeveRetornarSempreAMesmaInstancia() {
        FactoryMethod instancia1 = FactoryMethod.getInstance();
        FactoryMethod instancia2 = FactoryMethod.getInstance();

        assertSame(instancia1, instancia2);
    }

    @Test
    void criarFabricaDeveInstanciarFabricaGraduacaoPorReflexao() {
        FabricaAbstrata fabrica = FactoryMethod.getInstance().criarFabrica(FabricaGraduacao.class);

        assertInstanceOf(FabricaGraduacao.class, fabrica);
    }

    @Test
    void criarFabricaDeveInstanciarFabricaPosGraduacaoPorReflexao() {
        FabricaAbstrata fabrica = FactoryMethod.getInstance().criarFabrica(FabricaPosGraduacao.class);

        assertInstanceOf(FabricaPosGraduacao.class, fabrica);
    }

    @Test
    void criarDeveFuncionarParaQualquerClasseComConstrutorPadrao() {
        Object objeto = FactoryMethod.getInstance().criar(HistoricoGraduacao.class);

        assertInstanceOf(HistoricoGraduacao.class, objeto);
    }
}

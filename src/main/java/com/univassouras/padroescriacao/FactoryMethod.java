package com.univassouras.padroescriacao;

public class FactoryMethod {

    private static FactoryMethod instancia = new FactoryMethod();

    private FactoryMethod() {
    }

    public static FactoryMethod getInstance() {
        return instancia;
    }

    public Object criar(Class<?> classe) {
        try {
            return classe.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Nao foi possivel criar uma instancia de " + classe.getName(), e);
        }
    }

    public FabricaAbstrata criarFabrica(Class<? extends FabricaAbstrata> classeFabrica) {
        return (FabricaAbstrata) criar(classeFabrica);
    }
}

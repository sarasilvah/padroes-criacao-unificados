# Unificação dos Padrões de Criação: Abstract Factory, Factory Method e Singleton

Trabalho da disciplina Arquitetura e Projeto de Software — implementação que integra os três padrões de projeto criacionais (Abstract Factory, Factory Method e Singleton) em uma única aplicação coerente, seguindo o diagrama de classes fornecido pelo professor.

## O que a aplicação faz

Um sistema acadêmico que emite dois documentos para cada aluno — **Histórico Escolar** e **Diploma** — mas o conteúdo desses documentos muda de acordo com o tipo de curso: **Graduação** ou **Pós-Graduação**. Os três padrões resolvem partes diferentes desse problema e trabalham juntos:

- **Abstract Factory** (`FabricaAbstrata`): garante que o Histórico e o Diploma criados para um aluno sejam sempre do mesmo tipo de curso (nunca um histórico de graduação com um diploma de pós, por exemplo). As fábricas concretas são `FabricaGraduacao` e `FabricaPosGraduacao`.
- **Factory Method genérico** (`FactoryMethod`): em vez de escrever `new FabricaGraduacao()` ou `new FabricaPosGraduacao()` espalhado pelo código, existe um único método (`criarFabrica`) que recebe a *classe* desejada (`Class<?>`) e usa reflexão para instanciá-la, devolvendo o objeto já no tipo abstrato (`FabricaAbstrata`).
- **Singleton**: a própria classe `FactoryMethod` é de instância única — só existe um ponto de acesso a esse mecanismo de criação em toda a aplicação, obtido por `FactoryMethod.getInstance()`.

Na prática: `Aluno` recebe uma `FabricaAbstrata` (obtida através do `FactoryMethod`, que é Singleton) e usa essa fábrica para criar seu próprio Histórico e Diploma — sem nunca precisar conhecer as classes concretas de nenhum dos dois.

## Estrutura do projeto

```
padroes-criacao-unificados/
├── src/
│   ├── main/java/com/univassouras/padroescriacao/
│   │   ├── FactoryMethod.java               (Singleton + Factory Method genérico via reflexão)
│   │   ├── FabricaAbstrata.java             (Abstract Factory)
│   │   ├── FabricaGraduacao.java
│   │   ├── FabricaPosGraduacao.java
│   │   ├── Historico.java
│   │   ├── HistoricoGraduacao.java
│   │   ├── HistoricoPosGraduacao.java
│   │   ├── Diploma.java
│   │   ├── DiplomaGraduacao.java
│   │   ├── DiplomaPosGraduacao.java
│   │   ├── Aluno.java
│   │   └── Main.java
│   └── test/java/com/univassouras/padroescriacao/
│       ├── FactoryMethodTest.java
│       ├── FabricaAbstrataTest.java
│       └── AlunoTest.java
├── diagrama/
│   └── diagrama-classes-padroes-criacao.png
├── pom.xml
└── README.md
```

## Papéis dos padrões nesta implementação

| Padrão            | Papel                        | Classe neste projeto                                              |
|--------------------|-------------------------------|----------------------------------------------------------------------|
| Singleton          | Instância única                | `FactoryMethod`                                                     |
| Factory Method      | Criador genérico (via reflexão) | `FactoryMethod.criar()` / `FactoryMethod.criarFabrica()`             |
| Abstract Factory    | Fábrica abstrata               | `FabricaAbstrata`                                                    |
| Abstract Factory    | Fábricas concretas             | `FabricaGraduacao`, `FabricaPosGraduacao`                            |
| Abstract Factory    | Produtos abstratos              | `Historico`, `Diploma`                                                |
| Abstract Factory    | Produtos concretos              | `HistoricoGraduacao`, `HistoricoPosGraduacao`, `DiplomaGraduacao`, `DiplomaPosGraduacao` |
| Cliente             | Usa a fábrica sem conhecer os concretos | `Aluno`                                                |

## Como executar

Pré-requisitos: JDK 17+ e Maven (ou usar o Maven embutido do IntelliJ).

```bash
mvn compile exec:java -Dexec.mainClass="com.univassouras.padroescriacao.Main"
```

A saída mostra um aluno de Graduação recebendo histórico e diploma nesse formato, e um aluno de Pós-Graduação recebendo os documentos no formato correspondente — ambos criados através do mesmo mecanismo genérico (`FactoryMethod`), sem nenhum `new FabricaGraduacao()` escrito diretamente no código cliente.

## Como rodar os testes

```bash
mvn test
```

Os testes cobrem:
- o Singleton sempre retorna a mesma instância;
- `criarFabrica` instancia corretamente cada fábrica concreta por reflexão;
- cada fábrica concreta cria o par correto de Histórico e Diploma;
- o aluno nunca recebe uma mistura de documentos de tipos diferentes.

## Autor

Trabalho individual — disciplina Arquitetura e Projeto de Software.

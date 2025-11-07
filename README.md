# DesafioWebJava

Este é um projeto de automação de testes web utilizando Java, Selenium WebDriver e Cucumber.

## Descrição

O DesafioWebJava é um projeto de automação de testes para o site Sauce Demo (https://www.saucedemo.com/). 
Ele utiliza o padrão Page Object Model (POM) e a abordagem Behavior Driven Development (BDD) com Cucumber para criar testes legíveis e manuteníveis.

## Escopo do Projeto

O projeto abrange a criação e automação de testes para as seguintes funcionalidades:
1. Login
2. Checkout (Pagamento)

Todos os testes são escritos em Gherkin e automatizados seguindo o padrão Page Object.

## Tecnologias Utilizadas

- Java 11
- Selenium WebDriver 4.9.1
- Cucumber 6.10.4
- JUnit 4.13.2
- Maven 3.8.1
- WebDriverManager 5.6.2

## Estrutura do Projeto
DesafioWebJava
├── screenshots
├── src
│   ├── main/java
│   │   ├── hooks
│   │   │   └── Hooks.java
│   │   ├── pageobject
│   │   │   ├── InventoryPage.java
│   │   │   ├── CheckoutPage.java
│   │   │   ├── CartPage.java
│   │   │   └── LoginPage.java
│   │   └── utils
│   │       └── Utils.java
│   └── test/java
│       ├── runner
│       │   └── TestRunner.java
│       ├── stepdefinitions
│       │   ├── CheckoutSteps.java
│       │   └── LoginSteps.java
│       └── resources/features
│           ├── checkout.feature
│           └── login.feature
├── pom.xml
└── README.md

## Funcionalidades Testadas

- Login: Testes de login bem-sucedido e malsucedido.
- Checkout: Processo completo de checkout, incluindo adição de itens ao carrinho e preenchimento de informações de pagamento.

## Como Executar os Testes

1. Clone este repositório
2. Navegue até a pasta do projeto
3. Execute o comando: `mvn test`

## Relatórios

Os relatórios dos testes são gerados na pasta `target/cucumber-reports` após a execução.

## Screenshots

Screenshots de falhas são salvas na pasta `screenshots`.

## Configuração do Projeto

O projeto utiliza o Maven para gerenciamento de dependências. As principais dependências e plugins estão configurados no arquivo `pom.xml`.

## Estrutura dos Testes

- `src/test/resources/features`: Contém os arquivos .feature com os cenários de teste escritos em Gherkin.
- `src/test/java/stepdefinitions`: Contém as implementações dos passos definidos nos arquivos .feature.
- `src/test/java/runner`: Contém a classe TestRunner que configura e executa os testes.

## Page Objects

Os Page Objects estão localizados em `src/main/java/pageobject` e representam as páginas da aplicação web sendo testada:
- LoginPage: Representa a página de login
- InventoryPage: Representa a página de inventário de produtos
- CartPage: Representa a página do carrinho de compras
- CheckoutPage: Representa as páginas do processo de checkout

## Utilitários

A classe `Utils.java` em `src/main/java/utils` contém métodos utilitários para interação com elementos web, como espera explícita e ações de clique.

## Hooks

A classe `Hooks.java` em `src/main/java/hooks` contém métodos que são executados antes e depois de cada cenário de teste.

## Contribuindo

Contribuições são bem-vindas! Por favor, sinta-se à vontade para submeter um Pull Request.

## Autora

Nathalia Fonseca Bim


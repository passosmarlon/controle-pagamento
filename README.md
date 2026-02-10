# Controle de Pagamentos

Sistema para controlar debito e crédito de clientes, desenvolvido por Java e Spring Boot para o back end e o front end será em React Native

## Sobre o Projeto

Esse projeto tem como objetivo automatizar a forma com que é registrado os pagamentos dos clientes de uma loja,
como forma de pagamento, créditos, data de pagamentos, etc. Atualmente tudo é feito manualmente em um papel,
esse projeto trará velocidade e mais organização para a empresa.

## Funcionalidades

- Cadastro de clientes
- Registro de faturas
- Pagamentos parciais
- Cálculo automático de saldo devedor
- Controle de crédito (vale)
- Histórico de pagamentos

## Tecnologias

- Java 21
- Spring Boot
- Spring Data JPA
- Banco de dados MySQL
- Lombok
- MapStruct

## Estrutura do projeto

- controller → Camada de controllers (API REST)
- service → Regras de negócio
- repository → Acesso ao banco de dados
- entity → Entidades JPA
- dto → Objetos de transferência de dados
- mapper → Conversão entre Entity e DTO

##  Próximos passos

- Autenticação com Spring Security e JWT
- Envio de comprovantes por e-mail
- Relatórios financeiros
- Front-end com React Native

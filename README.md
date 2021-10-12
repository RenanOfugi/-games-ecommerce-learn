# Games E-commerce

## Introdução

Este projeto visa implementar um processo de checkout simples relacionado a um e-commerce de games fictício, com o objetivo de observar e aprender sobre a arquitetura de microsserviços e orientado a eventos.

## Tecnologias utilizadas

* Java 11
* Spring
* PostgreSQL
* Apache Kafka
* Docker (com docker-compose)
* Zookeeper

## Visão Geral

O sistema deste repositório será responsável por processar os dados do usuário via **POST**, salvar em um banco de dados PostegreSQL e disponibilizar somente os dados necessários para um outro serviço de pagamento fictício consumir via **Kafka** utilizando um ***Data Transfer Object* (DTO)**.

## Repositório do serviço fictício de pagamento

[games-payment](https://github.com/RenanOfugi/games-payment.git)

## Como Executar

1. Clone este repositório e o repositório acima (games-payment) em sua máquina local
2. Abra ambos em uma IDE (recomendado utilizar Intellij) **ou** abra dois terminais se estiver utilizando linux e mude o diretório corrente de cada um para os repositórios clonados.
3. Se estiver utilizando IDE, apenas execute os projetos normalmente. Caso esteja utilizando os terminais,  verifique se possui o maven instalado e execute `mvn spring-boot:run`
4. Abra um terminal e navegue até a pasta **/docker** deste projeto e execute `docker-compose up -d` se estiver utilizando Linux, ou verifique como executar o docker-compose se estiver utilizando um sistema operacional diferente.
5. Após tudo estiver inicializado no docker e nos projetos spring, envie uma requisição via POST (Json) utilizando Postman ou Insomnia para a URL **localhost:8080/v1/games-checkout**
   1. Exemplo de requisição para uso:
      `{
      	"firstName":"Julia",
      	"lastName": "Okari",
      	"email": "dogshow@hotmail.com",
      	"games": [
      		{
      			"nameGame":"Battlefield 5",
      			"value": "55,00"
      		},
      		{
      			"nameGame":"Tomb Raider",
      			"value":"70,00"
      		}
      	],
      	"value": "125,00"
      }`
6. Clique em **Send** e observe as saídas geradas nos terminais dos projetos


# MK Data Back-End Project

Esse é o projeto Front-End para o desafio do MK Data. Aqui escreverei o meu processo de desenvolvimento
com alguns detalhes sobre o projeto.

## Executar

Para instalar o projeto rode `mvn install` na pasta raiz, e logo após rode `mvn spring-boot:run` para executá-lo.

## Estrutura

Esse projeto foi feito em Spring Data REST. As Entidades Customer e CustomerGroup foram mapeadas nos seus respectivos
Repositórios e os seguintes endpoints foram expostos.

Alguns dados bases foram inseridos via Command Line Runner.

### Cliente

*  **GET**         /api/customers/          - Todos Clientes
*  **GET**         /api/customers/{id}      - Cliente Específico
*  **POST**        /api/customers           - Insere Cliente
*  **DELETE**      /api/customers/{id}      - Exclui Cliente
*  **PATCH**       /api/customers/{id}      - Atualiza Cliente

### Grupo de Cliente
*  **GET**         /api/customer-groups/cliente   - Todos Grupo de Clientes
*  **GET**         /api/customer-groups/{id}      - Grupo de Clientes Específico
*  **POST**        /api/customer-groups           - Insere Grupo de Clientes
*  **DELETE**      /api/customer-groups/{id}      - Exclui Grupo de Clientes
*  **PATCH**       /api/customer-groups/{id}      - Atualiza Grupo de Clientes

### Pesquisa
* **GET**       api/customer-groups/search/searchByName?name=Nome do Grupo de Cliente
* **GET**       api/customer-groups/search/findAnyByNameAndStatus?name='nome do grupode clientes'&status=true
* **GET**       api/customers/search/searchByCpfCnpj?cpfCnpj=00000000000
* **GET**       api/customers/search/findAnyByNameAndStatus?name='nome do cliente'&status=true

## Ferramentas

* **[Java](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)** - 11
* **[Spring Boot](https://spring.io/projects/spring-boot)** - 2.3.0.RELEASE
* **[Sring Data REST](https://spring.io/projects/spring-data-rest)** - 6.5.4

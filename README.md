

# spring-rest-api-vendas-example
API Rest com vários exemplos de utilização de recursos do Spring.

## Requisitos 

 - IDE para desenvolvimento Java (utilizado IntelliJ IDEA para desenvolvimento do projeto)
 - Gradle - Gerenciamento dos pacotes
 - MySQL Server - Base de dados da API
 - MongoDB Server - Base de dados dos Logs

## Recursos utilizados no projeto

 - Spring Data - Conexão com banco de dados, utilizando MySQL e HSQLDB para os testes unitários e integração, no padrão de Repository (Interface CrudRepository) e Service utilizando DI 
 - JPA Hibernate - persistência de objetos no banco de dados 
 - Testes Unitários e Integração utilizando banco de dados na memória (HSQLDB)
 - MockMVC para testes de integração de chamadas HTTP no padrão REST
 - Mockito para testes unitários 
 - Dois arquivos de configuração da aplicação, um para a aplicação em si, e outro para trabalho com os testes
 - Interceptors e Handlers - Customização de Excessões (Exception Handler) e tratamento de requisições especificas antes do handler.
 - Relacionamento entre entidades
 - Swagger para documentação da API
 - Log4j2 para criação de logs personalizados, utilizando 3 appenders : Console, RollingFile e NoSql com MongoDB
 	
## Estrutura do projeto
Pacote principal : **com.smn.apivendas** : *Contem as classes de configuração da aplicação, Swagger e WebMvc para utilização dos interceptors*


----------

Pacotes internos : 
 - **contracts** : Contem as classes que definem contratos que podem ser retornados pela API.
 - **controllers** : Contem os controladores da API, que recebem as requisições e fazem a comunicação com a camada de serviços da aplicação. Os controllers já estão anotados com Swagger para geração da documentação
 - **exceptions** : Contem as Exceptions personalizadas da API.
 - **models** : Contem as entidades que representam a estrutura da base de dados e os relacionamentos. O projeto é uma representação básica de venda, portanto possui 3 : Produto, Venda e VendaItem que tem relação com as duas anteriores.
 - **repositories**: Contem as interfaces que extendem a CrudRepository do spring data que fazem a comunicação com o banco de dados. A VendaItemRepository possui um exemplo de criação de consulta personalizada utilizando a assinatura de método.
 - **serializers** : Contem um deserialize customizado que extende JsonDeserializer<?>, que é responsavel por passar a string json para a entidade. No exemplo, foi utilizado para injetar o produto na instancia de acordo com produto_id passado na string json.
 - **services** : Contem as classes de serviço, as quais que por injeção de dependência possuem a logica de negócios e utilizam através de DI os repositórios que fazem a comunicação com o banco de dados.

## Estrutura Testes

Pacotes teste :

 - **controllers** : Contem os testes de integração que se comunicam com a API e testam o retorno das chamas HTTP seguindo o padrão REST, utilizando o MockMvc.
 - **services** : Contem os testes unitários das classes de serviço utilizando Mockito para simular a criação das instancias utilizadas pelos serviços, para que o teste utilize apenas a unidade a ser testada.

## Links referencia 
https://spring.io/

http://hibernate.org/orm/

https://springfox.github.io/springfox/docs/current/

https://logging.apache.org/log4j/2.x/

http://www.baeldung.com/spring-mvc-handlerinterceptor

http://site.mockito.org/

https://medium.com/@josevieiraneto/tdd-com-spring-boot-b5bf7ec725e

https://springframework.guru/mockito-mock-vs-spy-in-spring-boot-tests/

http://www.baeldung.com/global-error-handler-in-a-spring-rest-api


----------
## Autor
Thalles Mendes

thalles@smnti.com.br

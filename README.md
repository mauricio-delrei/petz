# petz
São Bernardo do Campo, 13 de Novembro de 2020.
Maurício de Araújo Del Rei.
mauricioaraujodelrei@gmail.com


Desenvolvimento de API Rest para integrar os sistemas com outros parceiros.


Utilizado:
SpringBoot
Maven
Banco de Dados em memória H2

Para compilar a aplicação:
mvn test
mvn spring-boot:run



Verbos Http da App Cliente:

GET 
http://localhost:8081/clientes/    (Consulta Todos os Clientes)
http://localhost:8081/clientes/{id} (Consulta Todos os Clientes pelo seu Id.
http://localhost:8081/clientes/?nome={nome} (Consulta Todos os Clientes pelo nome;

POST
http://localhost:8081/clientes/   
{
  "id": "",
  "nome": "String",
  "idade": "Integer",
  "email": "String",
  "endereco":"String",
  "telefone": "String",
  "cpf":"String",
  "sexo":"ENUM"
}

PUT
http://localhost:8081/clientes/   
{
  "id": "Long",
  "nome": "String",
  "idade": "Integer",
  "email": "String",
  "endereco":"String",
  "telefone": "String",
  "cpf":"String",
  "sexo":"ENUM"
}
DELETE
http://localhost:8081/clientes/{id} 


Verbos Http da App Pet:

GET 
http://localhost:8081/pets/    (Consulta Todos os pets)
http://localhost:8081/pets/{id} (Consulta Todos os pets pelo seu Id.
http://localhost:8081/pets/?nome={nome} (Consulta Todos os pets pelo nome;

POST
http://localhost:8081/pets/   
{
  "id": "",
  "nome": "String",
  "raca": "String",
  "idade": Integer,
  "sexo": "ENUM",
  "tamanho": "ENUM"
}

PUT
http://localhost:8081/pets/   
{
  "id": "Long",
  "nome": "String",
  "raca": "String",
  "idade": Integer,
  "sexo": "ENUM",
  "tamanho":"ENUM"
}
DELETE
http://localhost:8081/pets/{id}   

Obs: Pelo tempo parco e por outros compromissos, faltou implementar :
- Cache
- Security
- Testes Com Junit5
- Actuator
- Paginação e Ordenação
- Não foi descrito a necessidade de relacionamento entre o Pet e seu Dono.




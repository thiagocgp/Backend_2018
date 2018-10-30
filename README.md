# Backend_2018
Repositório do trabalho final da matéria "Programação Back-End Avançada" do curso de Especialização em Desenvolvimento Web e Mobile - full stack.

Alunos:
- Thiago de Castro G. Pereira
- Ítalo Tavares
- Axel Miguez

# SAPATARIA - Vendas e Controle de Estoque

__Descrição do trabalho__

O trabalho consiste no desenvolvimento de duas API's independentes, uma para o controle de estoque e outra para o controle de vendas de uma loja de sapatos. Uma suposta UI consome dados da API de vendas, a qual consome dados fornecidos pela API de Estoque. A UI também pode ser capaz de alterar os dados da API de estoque diretamente.


## API de Controle do Estoque

__Descrição__

API responsável por fornecer e guardar dados relativos ao estoque da Sapataria. Esta API foi feita usando a linguagem JAVA na Eclipse IDE. Foi utilizado o Maven para o gerenciamento de repositórios e a biblioteca Jersey para os serviços REST. O banco de dados utilizado foi o MySql e fazendo a conexão com mesmo através do JDBC. O servidor utilizado para testes foi o Tomcat.

O projeto desta API está na pasta (Estoque).

O arquivo (MySql_Criar_Popular_BD.txt) contém queries para a criação do banco, da tabela e também adiciona algúns dados na tabela afim de facilitar os testes. A tabela contém 5 colunas (id, nome, quantidade, preco, numero) os quais contém os dados para cada modelo de sapato no estoque.

Esta API retorna os dados através de JSON.

_Exemplo:_
   
   ```json
   {
      "id":6,
      "nome":"Tenis de Corrida",
      "quantidade":2,
      "preco":345.90,
      "numero":40
   }
   ```

__Obter dados do estoque__

- Todo estoque

  GET - http://localhost:8080/Estoque
  
- Por ID

  GET - http://localhost:8080/Estoque/id/[id]
  
- Por Nome

  GET - http://localhost:8080/Estoque/nome/[nome]
  
 __Adicionar produto no estoque__
  
  POST - http://localhost:8080/Estoque
   
   _Exemplo:_
   
   ```json
   {
      "nome":"Sapato Social",
      "quantidade":3,
      "preco":169.90,
      "numero":41
   }  
   ```

__Editar um produto no estoque__

   PUT - http://localhost:8080/Estoque/id/[id]
  
   _Exemplo:_
   
   http://localhost:8080/Estoque/id/6
   
  ```json
   {
      "nome":"Tenis de Corrida",
      "quantidade":1,
      "preco":129.80,
      "numero":40
   }
   ```
   
__Deletar um produto no estoque__

  DELETE - http://localhost:8080/Estoque/id/[id]
  
  
  ## API de Loja
  
  __Descrição__

API responsável por fornecer e guardar dados relativos as vendas da Sapataria. Esta API foi feita usando a linguagem javascript utilizando nodejs. Foi utilizado os pacotes ExpressJS, Mongoose e Body-parser. O banco de dados utilizado foi o mongodb utilizando o serviço do mLab (https://mlab.com).

O projeto desta API está na pasta (loja).

Esta API retorna os dados através de JSON. 

### Pré Requisitos

Este projeto utiliza algumas tecnologias que devem ser instaladas antes de ser executado.

* [Node](https://nodejs.org/en/download/package-manager/) - Node.js® is a JavaScript runtime built on Chrome's V8 JavaScript engine.
* [NPM](https://docs.npmjs.com/cli/install) - NPM is the package manager for JavaScript and the world’s largest software registry.

__Instalação__

Através do terminal dentro da pasta loja

```
npm install
```
Para instalar as dependências citadas anteriormente (ExpressJS, Mongoose e Body-parser)
```
npm install --save express body-parser mongoose
```
Para iniciar o serviço loja
```
node app.js
```
Acesso ao serviço pelo navegador
```
https://localhost:1234/
```

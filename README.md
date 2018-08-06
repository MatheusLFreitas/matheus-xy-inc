# matheus-xy-inc


Projeto criado utilizando spring-boot rest e mongodb.
O Projeto está configurado para subir na porta 9090.
É necessário possuir instalado um servidor local do mongodb, ou configurar para apontar para um servidor remoto.

Um controller é publicado com a url /poi, esse controller é restfull. Portanto, para:

- Criar novo ponto de interesse:
	Deve ser emitida uma requisição POST para a URL http://localhost:9090/poi, o documento vai no body. O Objeto retornado possuirá o id do documento gerado.
		
- Atualizar ponto de interesse:
    Deve ser emitida uma requisição PUT para a URL http://localhost:9090/poi/{docId}, o documento vai no body.
	
- Remover ponto de interesse 	
    Deve ser emitida uma requisição DELETE para a URL http://localhost:9090/poi/{docId}, retorna o documento removido.

- Listar todos os documentos	
    Deve ser emitida uma requisição GET para a URL http://localhost:9090/poi.
	
- Listar todos os documentos dentro da proximidade.
    Deve ser emitida uma requisição GET para a URL http://localhost:9090/poi/search/findByLocationNear?locationX&locationY&distance.
	
Para executar o projeto, basta possuir o maven e rodar o comando "mvn spring-boot:run".

TODO LIST:

- Web: 
   
    1. Implementar completamente HATEOAS. Começei a criar, mas não deu tempo. Reparem que a url da busca é /search/findByLocationNear, 
  um padrão utilizado pelo HATEOAS.

- Testes: 
	1. Faltam muitos testes, principalmente unitários, os testes atualmente implementados são de integração, pois envolvem diversas rotinas.
    2. Ainda nos testes, eu queria ter colocado para rodar os testes com o mockito, mas também não deu tempo.
		  
- Documentação:
    1. Faltou documentar com o padrão JavaDoc. Normalmente, em produção, esses códigos sairiam documentados.

Design Choices:

- Decisão sobre o banco:
	
	1. Escolhi o mongodb por se tratar de integração com dispositivos móveis, visto que é uma prática comum do mercado a 
	utilização dessa tecnologia atrelada a dispositivos móveis. 
	
	2. A facilidade para se trabalhar com geolocalização também foi levada em consideração, visto que a formula da distancia entre dois pointos,
	que é baseada no teorema de pitágoras, não é muito elegante resolver por linguagem sql. 
		Embora os bancos sql também possuam tipo de dado para geolocalização atualmente.
	
	3. Geralmente, esses bancos são bem escalares, além de possibilitar trabalhar offline muito mais facilmente.
	
Nota final:

	Para seguir a especificação, utilizei um DTO para receber coordenadas em inteiro não negativo, entretanto, a camada interna de banco de dados,
está preparada para trabalhar com geolocalização nativa. 
	O java não possui um tipo de dado unassigned para inteiro, portanto utilizei o long.

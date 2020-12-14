# language: pt

@CadastrarProfessor
	Funcionalidade: Validar a o cadastro de professor
	Como usuario
	Eu gostaria de cadastrar um novo professor
	Para que eu consiga cadastrar um novo professor
	
	Contexto:
	Dado que o usuario tenha acesso a pagina de admin e a de cadastro de professor
	
	@CadastrarNovoProfessor
	Esquema do Cenario: Cadastrar um novo professor no sistema
		Quando eu informar os campos "<siape>", "<nome>", "<ingresso>", "<nascimento>", "<regime>", "<cargahoraria>", "<lotacao>", "<Cnome>"
		Entao o sistema ira cadastrar um novo professor de acordo com o "<siape>", "<nome>", "<ingresso>", "<nascimento>", "<regime>", "<cargahoraria>", "<lotacao>", "<Cnome>" informados
	
		Exemplos:
		|		siape	|					 nome		 		  |			ingresso	|		nascimento		|	regime|cargahoraria|	lotacao|		Cnome		|
		|		1313	|				Guilherme				|	05/07/2020		|		04/05/1996		|		DE	|		8				 |		UDI	 |	Fernandes	|
		
	@ExcluirProfessor
	Esquema do Cenario: Escluir um professor cadastrado
	Quando pesquisa um professor pelo "<nome>" e clicar no botao excluir
	Entao o professor que foi pesquisado pelo "<nome>" sera excluido
	
	Exemplos:
	|		nome		|
	| Guilherme	|
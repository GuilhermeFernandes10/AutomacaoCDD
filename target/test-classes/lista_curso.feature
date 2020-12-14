# language: pt

@ListaCurso
	Funcionalidade: Validar a pesquisa de cursos
	Como usuario
	Eu gostaria de logar no Sistema e pesquisar um curso
	Para que eu possa pesquisar um curso cadastrado
	
	Contexto:
		Dado que o usuario tenha acesso a tela de pesquisa de curso
	
	@PesquisaNomeIncompleto
	Esquema do Cenario: Pesquisa um curso pelo seu nome incompleto
		Quando eu informar o nome de um "<curso>"
		Entao o sistema ira trazer o curso de acordo com o "<curso>" da pesquisa
	
		Exemplos:
		|		curso		|
		| 	gestao	|
		
	@PesquisaNomeCompleto
	Esquema do Cenario: Pesquisar um curso informando seu nome completo
		Quando eu informar na poesquisa o nome de um "<curso>" completo
		Entao o sistema apresentara os registros de acordo com o "<curso>" informado na pesquisa
		
		Exemplos:
		|										curso										|
		|	engenharia de Alimentos (Patos de Minas)	|
# language: pt

@FilaProfComTurma
Funcionalidade: exibir a fila de um professor com as turmas
	Como usuario
	Eu gostaria de pesquisar pelo nome do professor
	Para que eu possa validar a pesquisa feita pelo usuário
	
	Contexto:
		Dado que o usuario tenha acesso a tela inicial do sistema de disciplinas
	
	@filaProfComTurmaNomeCompleto
	Esquema do Cenario: Validacao da pesquisa por nome completo
		Quando pesquisa pelo nome completo do "<professor>"
		Entao o sistema retornara os resultados de acordo com o "<professor>" informado
	
		Exemplos:
		|				professor				|
		| 	Rivalino Matias Jr	|
		
	@filaProfComTurmaNomeIncompleto
	Esquema do Cenario: Validacao da pesquisa com nome do professor incompleto
		Quando pesquisa pelo nome incompleto do "<professor>"
		Entao o sistema retornara os resultado de acordo com o "<professor>" informado no filtro	
	
		Exemplos:
		|		professor		|
		| 	Maria Adri	|
		
	@filaProfComTurmaComDados
	Esquema do Cenario: Validacao da exibicao da fila de disciplinas com dados
		Quando pesquisar por um "<professor>" que possui fila
		Entao o sistema retornara a fila com as disciplinas do "<professor>"
	
		Exemplos:
		|			professor			|
		| 	Maria Adriana		|
		
	@filaProfComTurmaSemDados
	Esquema do Cenario: Validacao da fila sem dados
		Quando buscar pelo professor"<professor>" que nao possui fila de disciplina
		Entao o sistema nao exibira uma fila de disciplinas para o "<professor>"
	
		Exemplos:
		|			professor			|
		| 	Sara Luzia			|
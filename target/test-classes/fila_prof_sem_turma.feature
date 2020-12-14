# language: pt

@FilaProfSemTurma
Funcionalidade: exibir a fila de um professor (sem as turmas)
	Como usuario
	Eu gostaria de fazer uma pesquisa pelo professor
	Para que eu possa validar a funcionalidade de exibicao
	
	Contexto:
		Dado que o usuario esteja logado
	
	@filaProfSemTurmaNomeCompleto
	Esquema do Cenario: Validacao da exibicao digitando o nome completo
		Quando buscar pelo professor"<professor>" digitando o nome completo
		Entao o sistema mostrara a fila do professor"<professor>" buscado com o nome completo
	
		Exemplos:
		|						professor							|
		| 	Alessandra Aparecida Paulino	|
		
	@filaProfSemTurmaNomeIncompleto
	Esquema do Cenario: Validacao da exibicao nao digitando o nome completo
		Quando buscar pelo professor"<professor>" nao digitando o nome completo
		Entao o sistema mostrara a fila do professor"<professor>" buscado com o nome incompleto
	
		Exemplos:
		|						professor						|
		| 	Bruno Augusto Nassif Traven	|
		
	@filaProfSemTurmaComDados
	Esquema do Cenario: Validacao da exibicao com dados
		Quando buscar pelo professor"<professor>" que possui fila
		Entao o sistema mostrara a fila do professor"<professor>"
	
		Exemplos:
		|						professor						|
		| 	Bruno Augusto Nassif Traven	|
		
	@filaProfSemTurmaSemDados
	Esquema do Cenario: Validacao da exibicao sem dados
		Quando buscar pelo professor"<professor>" que nao possui fila
		Entao o sistema nao mostrara a fila do professor"<professor>"
	
		Exemplos:
		|			professor			|
		| 	Adriano Mendon	|
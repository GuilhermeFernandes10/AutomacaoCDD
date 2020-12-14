# language: pt

@CadastrarNovoCurso
	Funcionalidade: Validar novo cadastro de curso
	Como usuario
	Eu gostaria de cadastrar um novo curso
	Para que eu consiga cadastrar um novo curso
	
	Contexto:
		Dado que o usuario acesse a tela de cadastrar um novo curso
	
	@CadastrarNovoCurso
	Esquema do Cenario: Cadastrar um novo curso no sistema
		Quando eu informar os dados de "<codigo>", "<nome>", "<unidade>", "<campus>"
		Entao o sistema ira realizar o cadastro de acordo com o "<codigo>", "<nome>", "<unidade>", "<campus>"
	
		Exemplos:
		|		codigo		|			nome			|	unidade		|		campus	|
		| 		TST			| 	Curso Teste	| 	FAGEM		| 		UDI		|
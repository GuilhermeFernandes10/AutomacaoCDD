# language: pt

@AtribuirTurmaProfessor
	Funcionalidade: Validar a atribuicao de disciplina
	Como usuario
	Eu gostaria de atribuir uma disciplina para um professor
	Para que eu consiga atribuir uma disciplina
	
	Contexto:
	Dado que o usuario tenha acesso a tela de atribuicao de disciplina
	
	@AtribuirTurma
	Esquema do Cenario: Atribuir uma nova turma para o professor
		Quando eu informar os campos de "<nome>", "<turma>"
		Entao o sistema ira atribuir a turma de acordo com o "<nome>", "<turma>"
	
		Exemplos:
		|						nome				|							turma						|
		| 		Bruno Augusto			| 	Sistema de Banco de Dados	|
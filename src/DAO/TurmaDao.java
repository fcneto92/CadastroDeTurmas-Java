package DAO;

import Beans.Turma;

public class TurmaDao {

	Turma vetTurma[];
	int quantTurmasCadastradas;

	public void inicializaVetor(int quantidadeTurmas) {
		vetTurma = new Turma[quantidadeTurmas];
		quantTurmasCadastradas = 0;
	}

	public void insere(Turma t) {
		vetTurma[quantTurmasCadastradas] = t;
		quantTurmasCadastradas = quantTurmasCadastradas + 1;
	}

	public Turma buscaTurma(int idBuscado) {

		Turma tEncontrada = null;

		for (int contador = 0; contador < quantTurmasCadastradas && tEncontrada == null; contador = contador + 1) {

			Turma tAtual = vetTurma[contador];
			int idAtual = tAtual.getid();

			if (idAtual == (idBuscado)) {
				tEncontrada = tAtual;
			}
		}
		if (tEncontrada == null) {
			return null;
		} else {
			return tEncontrada;
		}
	}

	public Turma[] lista() {
		return vetTurma;
	}

	public boolean remover(int idTurmaRemovida) {

		int posicaoEncontrada = -1;
		for (int contador = 0; contador < quantTurmasCadastradas && posicaoEncontrada == -1; contador = contador + 1) {

			Turma tAtual = vetTurma[contador];
			int idAtual = tAtual.getid();

			if (idAtual == (idTurmaRemovida)) {
				posicaoEncontrada = contador;
			}
		}

		if (posicaoEncontrada != -1) {
			int contador;
			for (contador = posicaoEncontrada; contador < quantTurmasCadastradas - 1; contador = contador + 1) {
				vetTurma[contador] = vetTurma[contador + 1];
			}
			vetTurma[contador] = null;
			quantTurmasCadastradas = quantTurmasCadastradas - 1;
			return true;
		} else {
			return false;
		}
	}

	public void altera(int idLido, String dataIniLido, String turnoLido, int capacidadeAlunosLido, Turma t) {
		t.setid(idLido);
		t.setdataIni(dataIniLido);
		t.setturno(turnoLido);
		t.setcapacidadeAlunos(capacidadeAlunosLido);
	}

	public int getQuantTurmasCadastradas() {
		return quantTurmasCadastradas;
	}

	public void setQuantTurmasCadastradas(int quantTurmasCadastradas) {
		this.quantTurmasCadastradas = quantTurmasCadastradas;
	}

}
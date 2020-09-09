package View;

import java.util.Scanner;
import Beans.Turma;
import DAO.TurmaDao;

public class Teste {


	public static void main(String[] args) {

		System.out.println("***** Bem vindo ao Sistema *****");
		String menu = "\n1. Inserir" + "\n2. Buscar" + "\n3. Relatório" + "\n4. Remover" + "\n5. Alterar"
				+ "\n6. Sair\n";

		int opcao = 0;
		Scanner input = new Scanner(System.in);
		System.out.print(menu);
		opcao = input.nextInt();

		TurmaDao tDao = new TurmaDao();
		tDao.inicializaVetor(100);

		while (opcao != 6) {
			switch (opcao) {
			case 1: {
				System.out.printf("\n\nDigite o ID da Turma: ");
				int idLido = input.nextInt();

				System.out.printf("Digite a data de início da Turma: ");
				String dataIniLido = input.next();

				System.out.printf("Digite o turno da Turma: ");
				String turnoLido = input.next();

				System.out.printf("Digite a capacidade de alunos da Turma: ");
				int capacidadeAlunosLido = input.nextInt();

				Turma t = new Turma(idLido, dataIniLido, turnoLido, capacidadeAlunosLido);
				tDao.insere(t);
				break;
			}

			case 2: {
				System.out.println("\n\nDigite o ID buscado: ");
				int idBuscado = input.nextInt();

				Turma t = tDao.buscaTurma(idBuscado);

				if (t == null) {
					System.out.println("ID não encontrado!!!");
				} else {
					System.out.println("\n***** TURMA ENCONTRADA, SEGUEM OS DADOS: ***********");
					System.out.println(t.getid());
					System.out.println(t.getdataIni());
					System.out.println(t.getturno());
					System.out.println(t.getcapacidadeAlunos());
				}
				break;
			}

			case 3: {
				Turma vetT[] = tDao.lista();
				System.out.println("****** Relatório de turmas *****");
				for (int contador = 0; contador < tDao.getQuantTurmasCadastradas(); contador++) {
					Turma t = vetT[contador];
					System.out.printf("\nID: %d", t.getid());
					System.out.printf("\nData de início: %s", t.getdataIni());
					System.out.printf("\nTurno: %s", t.getturno());
					System.out.printf("\nCapacidade de alunos: %s\n", t.getcapacidadeAlunos());

				}
				break;
			}

			case 4: {
				System.out.print("\n\nDigite o ID da Turma que deseja remover: ");
				int idTurmaRemovida = input.nextInt();

				boolean retorno = tDao.remover(idTurmaRemovida);

				if (retorno == false) {
					System.out.println("\nID não encontrado!!!");
				} else {
					System.out.println("\nTurma removida com sucesso!!!");
				}
				break;
			}

			case 5: {
				System.out.print("\n\nDigite o ID da Turma que deseja alterar: ");
				int idTurmaAlterada = input.nextInt();

				Turma t = tDao.buscaTurma(idTurmaAlterada);

				if (t == null) {
					System.out.println("Email não encontrado!!!");
				} else {
					System.out.printf("\nID: %d", t.getid());
					System.out.printf("\nData de início: %s", t.getdataIni());
					System.out.printf("\nTurno: %s\n", t.getturno());
					System.out.printf("\nTurno: %s\n", t.getcapacidadeAlunos());

					System.out.println("\n ***Digite os novos valores***");
					System.out.printf("\nDigite o id da Turma: ");
					int idLido = input.nextInt();
					System.out.printf("Digite data de início da Turma: ");
					String dataIniLido = input.next();
					System.out.printf("Digite o turno da Turma: ");
					String turnoLido = input.next();
					System.out.printf("\nDigite a capacidade de alunos da Turma: ");
					int capacidadeAlunosLido = input.nextInt();

					tDao.altera(idLido, dataIniLido, turnoLido, capacidadeAlunosLido, t);
					System.out.println("\nAlteração realizada!");
				}
				break;

			}
			default: {
				System.out.print("\nOpção inválida!");
				break;
			}
			}
			System.out.print("\n\n" + menu);
			opcao = input.nextInt();
		}

		input.close();
	}
}
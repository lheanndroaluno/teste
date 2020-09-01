package programajava.executavel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

import programajava.classes.Aluno;
import programajava.classes.Diretor;
import programajava.classes.Disciplina;
import programajava.classesAuxiliares.FuncaoAutenticacao;
import programajava.constantes.StatusAluno;
import programajava.excessoes.ExcessaoProcessarNota;

public class Main {

	public static void main(String[] args) {

		try {

			lerArquivo();

			/* Acessano o sistema com login e senha */
			String login = JOptionPane.showInputDialog("Informe o Login");
			String senha = JOptionPane.showInputDialog("Informe a Senha");

			/* FuncaoAutenticacao funcaoAutenticacao = new FuncaoAutenticacao(); */

			// interface do tipo secretário
			// PermitirAcesso permitirAcesso = new Secretario(login, senha);

			/*
			 * Trabalhando diretamente com objeto, usando interface Secretario secretario =
			 * new Secretario(); secretario.setLogin(login); secretario.setSenha(senha);
			 */

			// Outra forma de fazer
			// PermitirAcesso secretario = new Secretario();

			// Outra maneira, é inicializar new Secretario()
			// if (new FuncaoAutenticacao(new Secretario(login, senha)).autenticar()) {//Vou
			// travar o contrato para autorizar somente quem realmente tem o contrato 100%
			// legitimo

			if (new FuncaoAutenticacao(new Diretor(login, senha)).autenticar()) {// Vou travar o contrato para autorizar
																					// somente quem realmente tem o
																					// contrato
																					// 100% legitimo

				/* Listas */
				List<Aluno> alunos = new ArrayList<Aluno>();

				// Exemplo de erros, inicializando a lista de alunos como null
				// List<Aluno> alunos = null;

				/*
				 * É uma lista que dentro dela tem uma chave que indica uma sequencia de valores
				 */
				HashMap<String, List<Aluno>> maps = new HashMap<String, List<Aluno>>();

				/*
				 * substituindo essas listas por hashMap List<Aluno> alunosAprovadosExcelencia =
				 * new ArrayList<Aluno>(); List<Aluno> alunosAprovados = new ArrayList<Aluno>();
				 * List<Aluno> alunosRecuperacao = new ArrayList<Aluno>(); List<Aluno>
				 * alunosReprovados = new ArrayList<Aluno>();
				 */

				for (int qtd = 1; qtd <= 3; qtd++) {
					String nomeAlu = JOptionPane.showInputDialog("Informe o nome do aluno." + qtd);
					// String cpfAlu = JOptionPane.showInputDialog("Informe o CPF do aluno." + qtd);
					String idadeAlu = JOptionPane.showInputDialog("Informe a idade do aluno." + qtd);


					Aluno aluno = new Aluno();
					aluno.setNome(nomeAlu);
					// aluno.setCpf(cpfAlu);
					aluno.setIdade(Integer.valueOf(idadeAlu));

					for (int posicao = 1; posicao <= 1; posicao++) {
						String nomeDisciplina = JOptionPane.showInputDialog("Disciplina: " + posicao + " ?");
						String notaDisciplina = JOptionPane.showInputDialog("Nota das disciplina: " + posicao + " ?");

						Disciplina disciplina = new Disciplina();
						disciplina.setDisciplina(nomeDisciplina);
						disciplina.setNota(Double.valueOf(notaDisciplina));

						aluno.getDisciplinas().add(disciplina);
					}

					int escolha = JOptionPane.showConfirmDialog(null, "Deseja remover alguma disciplina?");

					if (escolha == 0) {// se a a variável 'escolha' for 0, quer dizer que quer remover uma disciplina,
										// caso contrário ele sai do método

						int continuarRemover = 0;
						int posicao = 1;

						while (continuarRemover == 0) {
							String disciplinaRemover = JOptionPane.showInputDialog("Qual a disciplina 1, 2, 3 ou 4?");
							aluno.getDisciplinas().remove(Integer.valueOf(disciplinaRemover).intValue() - posicao);
							posicao++;// soma + 1
							continuarRemover = JOptionPane.showConfirmDialog(null, "Continuar a remover?");
							// Enquanto a condição continuarRemover for verdadeira, o while vai repetir o
							// processo de remoção
						}

					}

					alunos.add(aluno);
				}

				// primeiro tem que inicializara a chave e depois tem uma lista vazia para
				// guardar os objetos criados
				maps.put(StatusAluno.APROVADOEXCELENCIA, new ArrayList<Aluno>());
				maps.put(StatusAluno.APROVADO, new ArrayList<Aluno>());
				maps.put(StatusAluno.RECUPERACAO, new ArrayList<Aluno>());
				maps.put(StatusAluno.REPROVADO, new ArrayList<Aluno>());

				for (Aluno aluno : alunos) {/* Separado em listas */

					if (aluno.getAlunoAprovadoReprovado().equalsIgnoreCase(StatusAluno.APROVADOEXCELENCIA)) {
						maps.get(StatusAluno.APROVADOEXCELENCIA).add(aluno);
					} else if (aluno.getAlunoAprovadoReprovado().equalsIgnoreCase(StatusAluno.APROVADO)) {
						maps.get(StatusAluno.APROVADO).add(aluno);
					} else if (aluno.getAlunoAprovadoReprovado().equalsIgnoreCase(StatusAluno.RECUPERACAO)) {
						maps.get(StatusAluno.RECUPERACAO).add(aluno);
					} else {// última posição é reprovado
						maps.get(StatusAluno.REPROVADO).add(aluno);
					}
				}

				System.out.println("---------------------Lista de Aprovados------------------------------");
				System.out.println("Lista de alunos aprovados com excelência: ");
				for (Aluno aluno : maps.get(StatusAluno.APROVADOEXCELENCIA)) {
					System.out.println("Aluno: " + aluno.getNome());
					System.out.println("Média Parcial: " + aluno.getMediaParcial());
					System.out.println("Resultado Final: " + aluno.getAlunoAprovadoReprovado());
				}

				System.out.println("---------------------Lista de Aprovados------------------------------");
				System.out.println("Lista de alunos aprovados: ");
				for (Aluno aluno : maps.get(StatusAluno.APROVADO)) {
					System.out.println("Aluno: " + aluno.getNome());
					System.out.println("Média Parcial: " + aluno.getMediaParcial());
					System.out.println("Resultado Final: " + aluno.getAlunoAprovadoReprovado());
				}

				System.out.println("---------------------Lista de Recuperação------------------------------");
				System.out.println("Lista de alunos em recuperação: ");
				for (Aluno aluno : maps.get(StatusAluno.RECUPERACAO)) {
					System.out.println("Aluno: " + aluno.getNome());
					System.out.println("Média Parcial: " + aluno.getMediaParcial());
					System.out.println("Resultado Final: " + aluno.getAlunoAprovadoReprovado());
				}

				System.out.println("---------------------Lista de Reprovados------------------------------");
				System.out.println("Lista de alunos reprovados: ");
				for (Aluno aluno : maps.get(StatusAluno.REPROVADO)) {
					System.out.println("Aluno: " + aluno.getNome());
					System.out.println("Média Parcial: " + aluno.getMediaParcial());
					System.out.println("Resultado Final: " + aluno.getAlunoAprovadoReprovado());
				}

			} else {
				JOptionPane.showInternalMessageDialog(null, "Acesso não permitido. \nLogin e/ou Senha inválidos");
			}

			/**/
		} catch (Exception erro) {

			StringBuilder saida = new StringBuilder();

			/* Imprime o erro no console Java */
			erro.printStackTrace();

			/* Mensagem do erro ou causa */
			System.out.println("\nMensagem: " + erro.getMessage());

			/*
			 * Lista erros, posição do erro, pega de 0 até a quantidade de mensagens que
			 * tiver
			 */
			for (int pos = 0; pos < erro.getStackTrace().length; pos++) {/* O 'LENGTH' identifica o tamanho do array */

				saida.append("\n Classe de erro: " + erro.getStackTrace()[pos].getClassName());
				saida.append("\n Método de erro: " + erro.getStackTrace()[pos].getMethodName());
				saida.append("\n Linha de erro: " + erro.getStackTrace()[pos].getLineNumber());
				saida.append("\n Class/Name de erro: " + erro.getClass().getName());
			}

			JOptionPane.showMessageDialog(null, "Erro ao processar notas: " + saida.toString());
		} finally {/*
					 * sempre executado ocorrendo erro ou não. É muito utilizado quando precisa
					 * executar um processo, acontecendo erro ou não
					 */
			JOptionPane.showMessageDialog(null, "Obrigado por aprender Java");
		}

	}
	
	public static void lerArquivo() throws ExcessaoProcessarNota {
		
		/*try {
			File file = new File("lines.txt");
			Scanner scan = new Scanner(file);
		} catch (FileNotFoundException e) {
			
			throw new ExcessaoProcessarNota(e.getMessage());
		}*/
	}
}

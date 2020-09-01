package programajava.classes;

import java.util.ArrayList;
import java.util.List;

import programajava.constantes.StatusAluno;
/*Classe filha de pessoa*/
public class Aluno extends Pessoa{

	private String dataMatricula;
	private String nomeEscola;
	private String serieMatriculado;

	private List<Disciplina> disciplinas = new ArrayList<Disciplina>();

	public String getDataMatricula() {
		return dataMatricula;
	}

	public void setDataMatricula(String dataMatricula) {
		this.dataMatricula = dataMatricula;
	}

	public String getNomeEscola() {
		return nomeEscola;
	}

	public void setNomeEscola(String nomeEscola) {
		this.nomeEscola = nomeEscola;
	}

	public String getSerieMatriculado() {
		return serieMatriculado;
	}

	public void setSerieMatriculado(String serieMatriculado) {
		this.serieMatriculado = serieMatriculado;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	/**
	 * Método para calcular a média das notas
	 * 
	 * @return
	 */
	public double getMediaParcial() {

		double somaNotas = 0.0;
		/**
		 * Percorrer a lista de disciplinas e depois somar as notas e dividir pela
		 * quantidade de disciplinas
		 */
		for (Disciplina disciplina : disciplinas) {
			somaNotas += disciplina.getNota();
		}

		return somaNotas / disciplinas.size();// o 'size' ele verifica a quantidade de disciplinas contém na lista
	}

	/**
	 * Método que verifica se o aluno foi aprovado ou não
	 * 
	 * @return
	 */
	public boolean getAprovadoReprovado() {
		double mediaFinal = this.getMediaParcial();

		if (mediaFinal >= 70) {
			return true;
		} else {
			return false;
		}
	}

	public String getAlunoAprovadoReprovado() {
		double mediaFinal = this.getMediaParcial();

		if (mediaFinal >= 50) {
			if (mediaFinal >= 70) {
				if (mediaFinal >= 95) {
					return StatusAluno.APROVADOEXCELENCIA;
				} else {
					return StatusAluno.APROVADO;
				}
			} else {
				return StatusAluno.RECUPERACAO;
			}
		} else {
			return StatusAluno.REPROVADO;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataMatricula == null) ? 0 : dataMatricula.hashCode());
		result = prime * result + ((disciplinas == null) ? 0 : disciplinas.hashCode());
		result = prime * result + ((nomeEscola == null) ? 0 : nomeEscola.hashCode());
		result = prime * result + ((serieMatriculado == null) ? 0 : serieMatriculado.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (dataMatricula == null) {
			if (other.dataMatricula != null)
				return false;
		} else if (!dataMatricula.equals(other.dataMatricula))
			return false;
		if (disciplinas == null) {
			if (other.disciplinas != null)
				return false;
		} else if (!disciplinas.equals(other.disciplinas))
			return false;
		if (nomeEscola == null) {
			if (other.nomeEscola != null)
				return false;
		} else if (!nomeEscola.equals(other.nomeEscola))
			return false;
		if (serieMatriculado == null) {
			if (other.serieMatriculado != null)
				return false;
		} else if (!serieMatriculado.equals(other.serieMatriculado))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Aluno [dataMatricula=" + dataMatricula + ", nomeEscola=" + nomeEscola + ", serieMatriculado="
				+ serieMatriculado + ", disciplinas=" + disciplinas + ", nome=" + nome + ", cpf=" + cpf + ", rg=" + rg
				+ ", dataNascimento=" + dataNascimento + ", idade=" + idade + ", nomePai=" + nomePai + ", nomeMae="
				+ nomeMae + "]";
	}
	
	@Override/*identifica método sobreescrito, ou seja, o método já existe na superclasse 'Pessoa'*/
	public boolean getPessoaMaiorIdade() {
		//return super.getPessoaMaiorIdade();
		return idade >= 21;
	}
	
	public String msgmaiorIdade() {
		return this.getPessoaMaiorIdade() ? "Oba, aluno é maior de idade" : "Ixi, aluno é menor de idade";
	}

	@Override
	public double salario() {
		return 1500;
	}

	

}

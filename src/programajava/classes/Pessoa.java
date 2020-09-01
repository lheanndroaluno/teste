package programajava.classes;

/*Herança -> Classe pai, ou classe master, ou superclasse - Atributos comuns a todos os objetos filhos*/
public abstract class Pessoa {

	protected String nome;
	protected String cpf;
	protected String rg;
	protected String dataNascimento;
	protected int idade;
	protected String nomePai;
	protected String nomeMae;
	
	/*Método abstrato é que fica na classe pai, é obrigatório para as classes filhas*/
	public abstract double salario();

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getNomePai() {
		return nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	/**
	 * Retorna true se for maior de idade
	 * @return
	 */
	public boolean getPessoaMaiorIdade() {
		return this.idade >= 18;
	}
	
	

}

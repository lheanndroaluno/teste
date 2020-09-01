package programajava.classes;

import programajava.interfaces.PermitirAcesso;

/*Classe filha de pessoa*/
public class Secretario extends Pessoa implements PermitirAcesso {

	private String registro;
	private String nivelCargo;
	private String experiencia;
	
	private String login;
	private String senha;
	
	
	public Secretario() {/*construtor padrão*/
		
	}

	public Secretario(String login, String senha) {/*construtor passando como parâmetros login e senha*/
		this.login = login;
		this.senha = senha;
	}

	public String getRegistro() {
		return registro;
	}

	public void setRegistro(String registro) {
		this.registro = registro;
	}

	public String getNivelCargo() {
		return nivelCargo;
	}

	public void setNivelCargo(String nivelCargo) {
		this.nivelCargo = nivelCargo;
	}

	public String getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(String experiencia) {
		this.experiencia = experiencia;
	}

	

	@Override
	public String toString() {
		return "Secretario [registro=" + registro + ", nivelCargo=" + nivelCargo + ", experiencia=" + experiencia
				+ ", nome=" + nome + ", cpf=" + cpf + ", rg=" + rg + ", dataNascimento=" + dataNascimento + ", idade="
				+ idade + ", nomePai=" + nomePai + ", nomeMae=" + nomeMae + "]";
	}

	@Override
	public double salario() {
		return 1800 + (1800 * 0.2);
	}

	/*Esse é o método do contrato de autenticação do secretário
	 * Caso o login e senha sejam admin, então tem acesso, caso contrário não tem
	@Override
	public boolean autenticar() {
		return login.equals("admin") && senha.equals("admin");
	}*/

	@Override
	public boolean autenticar(String login, String senha) {
		this.login = login;
		this.senha = senha;
		return autenticar();
	}

	@Override
	public boolean autenticar() {
		
		return login.equals("admin") && senha.equals("admin");
	}

}

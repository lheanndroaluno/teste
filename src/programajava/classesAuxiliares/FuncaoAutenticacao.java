package programajava.classesAuxiliares;

import programajava.interfaces.PermitirAcesso;

/*Realmente e somente receber alguém que tem o contrato de interface de 'PermitirAcesso' e chamar o autenticar*/
public class FuncaoAutenticacao {

	//outra forma de amarrar mais o código
	//1º passo declara 
	private PermitirAcesso permitirAcesso;
	
	public boolean autenticar() {
		return permitirAcesso.autenticar();
	}
	
	public FuncaoAutenticacao(PermitirAcesso acesso) {
		this.permitirAcesso = acesso;
	}
}

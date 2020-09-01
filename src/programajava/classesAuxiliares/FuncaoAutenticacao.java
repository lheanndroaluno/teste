package programajava.classesAuxiliares;

import programajava.interfaces.PermitirAcesso;

/*Realmente e somente receber algu�m que tem o contrato de interface de 'PermitirAcesso' e chamar o autenticar*/
public class FuncaoAutenticacao {

	//outra forma de amarrar mais o c�digo
	//1� passo declara 
	private PermitirAcesso permitirAcesso;
	
	public boolean autenticar() {
		return permitirAcesso.autenticar();
	}
	
	public FuncaoAutenticacao(PermitirAcesso acesso) {
		this.permitirAcesso = acesso;
	}
}

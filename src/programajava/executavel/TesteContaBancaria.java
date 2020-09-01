package programajava.executavel;

import programajava.principioresponsabilidade.ContaBancaria;

public class TesteContaBancaria {

	public static void main(String[] args) {
		
		ContaBancaria cb = new ContaBancaria();
		cb.setDescricao("Conta bancaria do Leandro");
		
		
		System.out.println(cb);
		
		cb.diminuirSaldo();
		System.out.println(cb);
		
		cb.deposito(500);
		System.out.println(cb);
		
		cb.sacarDinheiro(500);
		System.out.println(cb);
	}

}

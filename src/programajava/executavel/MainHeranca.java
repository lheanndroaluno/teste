package programajava.executavel;

import programajava.classes.Aluno;
import programajava.classes.Diretor;
import programajava.classes.Pessoa;
import programajava.classes.Secretario;

public class MainHeranca {

	public static void main(String[] args) {

		Aluno aluno = new Aluno();
		aluno.setNome("Leandro");
		aluno.setIdade(30);

		Diretor diretor = new Diretor();
		diretor.setNome("Alex");
		diretor.setTitulacao("Mestre");
		diretor.setIdade(50);

		Secretario secretario = new Secretario();
		secretario.setNome("Jorge");
		secretario.setExperiencia("5 anos de experi�ncia");
		secretario.setIdade(28);
		
		System.out.println(aluno);
		System.out.println(diretor);
		System.out.println(secretario);
		
		System.out.println(aluno.getPessoaMaiorIdade() + " - " + aluno.msgmaiorIdade());
		System.out.println(diretor.getPessoaMaiorIdade());
		System.out.println(secretario.getPessoaMaiorIdade());
		
		System.out.println("Sal�rio do aluno: " + aluno.salario());
		System.out.println("Sal�rio do diretor: " + diretor.salario());
		System.out.println("Sal�rio do secret�rio: " + secretario.salario());
		
		Pessoa pessoa = new Aluno();//isso � polimorfismo
		pessoa = secretario;//isso � polimorfismo
		
		teste(aluno);
		teste(diretor);
		teste(secretario);
		
	}
	
	public static void teste(Pessoa pessoa) {
		System.out.println("Essa pessoa � demais: " + pessoa.getNome() + " e o sal�rio � de = " + pessoa.salario());
	}
}

package programajava.excessoes;

public class ExcessaoProcessarNota extends Exception{
	
	public ExcessaoProcessarNota(String erro) {
		super("Vixi um erro no processamento do arquivo ao processar as notas do aluno " + erro);
	}
}

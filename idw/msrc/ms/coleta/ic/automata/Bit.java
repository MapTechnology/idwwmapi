package ms.coleta.ic.automata;

public class Bit {
	
	private final static int TAMANHO = 16;
	
	private int valor;
	private String valorBinario;
	
	public Bit(String valor) {
		try {
			this.valor = Integer.parseInt(valor);
		} catch (NumberFormatException numberFormatException) {
			numberFormatException.printStackTrace();
			this.valor = 0;
		}		
		iniciarObjeto();
	}
	
	public Bit(int valor) {
		this.valor = valor;
		iniciarObjeto();
	}
	
	private void iniciarObjeto() {
		converterInteiroParaBinario();
		completarValorBinarioComZero();
	}
	
	private void converterInteiroParaBinario() {
		valorBinario = Integer.toBinaryString(valor);
	}
	
	private void completarValorBinarioComZero() {
		valorBinario = ms.util.UtilsString.adicionaZero(valorBinario, TAMANHO);
	}
	
	public boolean getValorDaPosicao(int posicao) {
		char[] array = valorBinario.toCharArray();
		return converteParaBoolean(array[posicao]);
	}
	
	private boolean converteParaBoolean(char umOuZero) {
		char um = "1".charAt(0);
	    if (um == umOuZero) {
	    	return true;
	    }
	    return false;
	}

	public int getValor() {
		return valor;
	}

	public String getValorBinario() {
		return valorBinario;
	}

	public static void main(String[] args) {
		Bit bit = new Bit(983);
		System.out.println(bit.getValorBinario());
		
		for(int i=0; i<16; i++) {
			System.out.println("posicao "+i+" = "+bit.getValorDaPosicao(i));
		}
	}

}

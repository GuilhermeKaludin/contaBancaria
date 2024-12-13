package conta.model;

public class ContaCorrente extends Conta { // extends => herança/herda

	// atributos / variaveis
	private float limite;

	// metodo especial - metodo construtor

	public ContaCorrente(int numero, int agencia, int tipo, String titular, float saldo, float limite) {

		super(numero, agencia, tipo, titular, saldo); // invocando o metodo construtor conta
		this.limite = limite;
	}

	public ContaCorrente(int numero, int agencia, int tipo, String titular, float saldo) {
		super(numero, agencia, tipo, titular, saldo);
		this.limite = 5000.0f;
	}

	// metodos de acesso

	public float getLimite() {
		return limite;
	}

	public void setLimite(float limite) {
		this.limite = limite;
	}

	// polimorfismo de sobrescrita => add mais logica a um metodo ja existente

	@Override
	public boolean sacar(float valor) {

		if (this.getSaldo() + this.getLimite() < valor) {
			System.out.println("\n Saldo Insuficiente!");
			return false;
		}

		this.setSaldo(this.getSaldo() - valor);
		return true;

	}

	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Limite de Crédito: " + this.limite);
	}
}

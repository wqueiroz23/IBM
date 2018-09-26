package br.com.studybot.beans;

public class ItemPedido {

	private int codigo;
	private double valor;
	private int numero;
	private int qtVendida;
	private Pedido pedido;
	private Curso curso;
	
	
	
	public ItemPedido(int i, double d, int j, int k, Pedido pedido2, Pagamento pagamento2) {
		super();
	}
	public ItemPedido(int codigo, double valor, int numero, int qtVendida, Pedido pedido, Curso curso) {
		super();
		this.codigo = codigo;
		this.valor = valor;
		this.numero = numero;
		this.qtVendida = qtVendida;
		this.pedido = pedido;
		this.curso = curso;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getQtVendida() {
		return qtVendida;
	}
	public void setQtVendida(int qtVendida) {
		this.qtVendida = qtVendida;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}

}
	
	
	
	
	
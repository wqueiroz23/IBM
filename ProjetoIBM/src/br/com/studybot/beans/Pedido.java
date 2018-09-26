package br.com.studybot.beans;
public class Pedido {

	private int codigo;
	private String data;
	private double valor;
	private Aluno aluno;
	private Pagamento pagamento;
	
	
	public Pedido(int codigo, String data, double valor, Aluno aluno, Pagamento pagamento) {
		
		this.codigo = codigo;
		this.data = data;
		this.valor = valor;
		this.aluno = aluno;
		this.pagamento = pagamento;
		
	}
	public Pedido() {
		super();
	}
	public Pedido(int int1, String string, double double1, Aluno aluno2) {
		// TODO Auto-generated constructor stub
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	public Pagamento getPagamento() {
		return pagamento;
	}
	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}
	
	


}
	
	
	
	
	
	
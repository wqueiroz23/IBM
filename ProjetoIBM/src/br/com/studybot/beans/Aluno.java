package br.com.studybot.beans;

public class Aluno {

	private int codigo;
	private String nome;
	private String apelido;
	private String rg;
	private String cpf;
	private String email;
	private int telefone;
	private String senha;
	private String sexo;
	private int idade;
	private String data;
	private String historico;
	private String grauEscolaridade;
	private String dataFormacao;
	
	public Aluno(){
		super();
	}
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHistorico() {
		return historico;
	}

	public void setHistorico(String historico) {
		this.historico = historico;
	}

	public String getGrauEscolaridade() {
		return grauEscolaridade;
	}

	public void setGrauEscolaridade(String grauEscolaridade) {
		this.grauEscolaridade = grauEscolaridade;
	}

	public String getDataFormacao() {
		return dataFormacao;
	}

	public void setDataFormacao(String dataFormacao) {
		this.dataFormacao = dataFormacao;
	}

	public Aluno(int i, String string, String string2, String string3, String string4, String string5, int j, String string6, String string7, int k, String string8, String string9, String string10, String string11, Pagamento pagamento) {
		super();
	}

	public Aluno(int codigo, String nome, String apelido, String rg, String cpf, String email, int telefone,
			String senha, String sexo, int idade, String data, String historico, String grauEscolaridade,
			String dataFormacao) {
		
		this.codigo = codigo;
		this.nome = nome;
		this.apelido = apelido;
		this.rg = rg;
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
		this.senha = senha;
		this.sexo = sexo;
		this.idade = idade;
		this.data = data;
		this.historico = historico;
		this.grauEscolaridade = grauEscolaridade;
		this.dataFormacao = dataFormacao;
	}
}
	
	
	
	
	

package br.com.studybot.beans;

public class Aula {

	private int codigo;
	private String nome;
	private String descricao;
	private Disciplina disciplina;
	private Curso curso;
	private Professor professor;
	

	
	
	public Aula() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Aula(int codigo, String nome, String descricao, Disciplina disciplina, Curso curso, Professor professor) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;
		this.disciplina = disciplina;
		this.curso = curso;
		this.professor = professor;
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
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public Disciplina getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	
}

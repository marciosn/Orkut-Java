package br.ufc.si.orkut.usuario;

public abstract class Usuario {
	private String nome;
	private int idade;
	
	public Usuario() {
		this.nome = "";
		this.idade = 0;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

}
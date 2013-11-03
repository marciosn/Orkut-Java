package br.ufc.si.orkut.comunidade;

import java.util.ArrayList;
import br.ufc.si.orkut.usuario.*;

public abstract class Comunidade {
	private String titulo;
	private int categoria;
	private String desCategoria;
	protected ArrayList<Usuario> usuarios;
	
	public Comunidade() {
		this.titulo = "";
		this.categoria = 0;
		this.usuarios = new ArrayList<Usuario>();
	}
	
	public abstract boolean adicionarUsuario(Usuario usuario);
	
	public abstract void removerUsuario(int posicao);

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	
	public String getDesCategoria() {
		return desCategoria;
	}

	public void setDesCategoria(String desCategoria) {
		this.desCategoria = desCategoria;
	}

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

}

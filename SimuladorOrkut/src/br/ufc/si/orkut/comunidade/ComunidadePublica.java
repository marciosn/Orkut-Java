package br.ufc.si.orkut.comunidade;

import javax.swing.JOptionPane;
import br.ufc.si.orkut.usuario.Usuario;
import br.ufc.si.orkut.util.Exibivel;

public class ComunidadePublica extends Comunidade 
								implements Exibivel {
	
	public ComunidadePublica() {
		super();
	}

	public boolean adicionarUsuario(Usuario usuario) {
		this.usuarios.add(usuario);	
		return true;
	}

	public void removerUsuario(int posicao) {
		this.usuarios.remove(posicao);
	}
	
	public void exibir() {
		String users = "";
		
		if(this.usuarios.isEmpty()) users = "Nenhum usuario...\n";
		else{
			for(Usuario u:this.usuarios){
				users = users + "Nome: " + u.getNome() + "\n";
			}
		}
		JOptionPane.showMessageDialog(null,toString() + "Usuarios da Comunidade " + "'" + getTitulo() + "'.---------------\n" + users + "\n");
	}

	public String toString() {
		return "Comunidade Publica---------------\n\nTitulo: " + getTitulo() + ", Categoria: " + 
		getDesCategoria() + "\n";
	}
}
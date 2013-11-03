package br.ufc.si.orkut.comunidade;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import br.ufc.si.orkut.usuario.Usuario;
import br.ufc.si.orkut.usuario.UsuarioVip;
import br.ufc.si.orkut.util.Exibivel;

public class ComunidadePrivada extends Comunidade
								implements Exibivel{
	
	private ArrayList<Forum> foruns;
	
	public ComunidadePrivada() {
		super();
		this.foruns = new ArrayList<Forum>();
	}

	public boolean adicionarUsuario(Usuario usuario) {
		if(usuario instanceof UsuarioVip){
			this.usuarios.add(usuario);
			return true;
		}else
			JOptionPane.showMessageDialog(null, "Usuario não possui privilégios para " +
					"participar da comunidade");
		return false;
	}

	public void removerUsuario(int posicao) {
		getUsuarios().remove(posicao);
	}

	public void adicionarForum(Forum forum){
		this.foruns.add(forum);
	}
	
	public void removerForum(int posicao){
		this.foruns.remove(posicao);
	}

	public void exibir() {
		String users="";
		String ffo = "";
				
		if(this.usuarios.isEmpty())	users = "Nenhum usuario...\n";
		else{
			for(Usuario u:this.usuarios){
			users = users + "Nome: " + u.getNome() + "\n";
			}
		}
		if(this.foruns.isEmpty())	ffo = "Nenhum forum...\n";
		else{
			for(Forum f:this.foruns){
			ffo = ffo + "Forum: " + f.getTitulo()+ "\n";
			}
		}
		JOptionPane.showMessageDialog(null, toString()+ "Usuarios da Comunidade " +
				"' " + getTitulo() + " '.---------------\n" + users + "Foruns da Comunidade " + "'" + 
				getTitulo() + "'.---------------\n" + ffo + "\n");
	}
	
	public ArrayList<Forum> getForuns() {
		return foruns;
	}

	public void setForuns(ArrayList<Forum> foruns) {
		this.foruns = foruns;
	}

	public String toString() {
		return "     Comunidade Privada\n\nTitulo: " + getTitulo() +", Categoria: " + 
		getDesCategoria() + "\n";
	}		
}
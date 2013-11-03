package br.ufc.si.orkut.usuario;

import java.util.ArrayList;
import javax.swing.JOptionPane;

import br.ufc.si.orkut.util.Exibivel;

public class UsuarioVip extends Usuario implements Exibivel{
	private ArrayList<String> recados;

	public UsuarioVip() {
		this.recados = new ArrayList<String>();
	}

	public  void exibir() {
		String recado ="";
		
		if(this.recados.isEmpty())	recado = "Nenhum recado...\n";
		else{
			for(String r:this.recados){
				recado = recado + r +"\n";
			}
		}
		JOptionPane.showMessageDialog(null,toString() + "\n" +"recados---------------\n " + recado);
	}
	
	public void adicionarRecado(String recado){
		this.recados.add(recado);
	}
	
	public void removerRecado(int posicao){
		this.recados.remove(posicao);
	}
	
	public ArrayList<String> getRecados() {
		return recados;
	}

	public void setRecados(ArrayList<String> recados) {
		this.recados = recados;
	}

	public String toString() {
		return "Usuario Vip---------------\n\nNome: " + getNome() + ", Idade: " + getIdade() + "\n";
	}	
	
}

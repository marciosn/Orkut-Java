package br.ufc.si.orkut.comunidade;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import br.ufc.si.orkut.util.Exibivel;

public class Forum implements Exibivel {
	private String titulo;
	private ArrayList<String> mensagens;
	
	public Forum() {
		this.titulo = "";
		this.mensagens = new ArrayList<String>();
	}
	
	public void adicionarMensagem(String mensagem){
		this.mensagens.add(mensagem);
	}
	
	public void removerMensagem(int posicao){
		if(this.mensagens.isEmpty())
			JOptionPane.showMessageDialog(null, "não existe mensagens neste forum");
		else
			this.mensagens.remove(posicao);
	}
	
	public void exibir() {
		String msg = "";
		
		if(this.mensagens.isEmpty())	msg = "Nenhuma mensagem...\n";
		else{
			for(String m:this.mensagens){
				msg = msg + m + "\n";
			}
		}
		JOptionPane.showMessageDialog(null,toString()+ "mensagens :\n" + msg);
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public ArrayList<String> getMensagens() {
		return mensagens;
	}

	public void setMensagens(ArrayList<String> mensagens) {
		this.mensagens = mensagens;
	}

	public String toString() {
		return "Titulo: " + getTitulo() + "\n";
	}
}

package br.ufc.si.orkut.usuario;

import javax.swing.JOptionPane;

import br.ufc.si.orkut.util.Exibivel;

public class UsuarioComum extends Usuario implements Exibivel{

	public UsuarioComum() {
		super();
	}

	public void exibir() {
		JOptionPane.showMessageDialog(null,toString());
	}

	public String toString() {
		return "     Usuario Comum\n\nNome: " + getNome() + ", Idade: "
				+ getIdade() + "\n";
	}
}

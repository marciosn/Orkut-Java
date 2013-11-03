package br.ufc.si.orkut.principal;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import javax.swing.JOptionPane;
import br.ufc.si.orkut.comunidade.Comunidade;
import br.ufc.si.orkut.comunidade.ComunidadePrivada;
import br.ufc.si.orkut.comunidade.ComunidadePublica;
import br.ufc.si.orkut.comunidade.Forum;
import br.ufc.si.orkut.usuario.Usuario;
import br.ufc.si.orkut.usuario.UsuarioComum;
import br.ufc.si.orkut.usuario.UsuarioVip;
import br.ufc.si.orkut.util.*;

public class Orkut {
	private static Map<String, Comunidade> comunidades = new Hashtable<String, Comunidade>();
	private static Map<String, Usuario> usuarios = new Hashtable<String, Usuario>();
	private static Map<String, Forum> foruns = new Hashtable<String, Forum>();

	/*
	 * Método adicionarUsuario, cria um novo usuario no sistema Orkut, 
	 * este usuario pode ser Comum ou VIP,um usuario comum possui nome 
	 * e idade, o usario VIP alem de nome e idade pode receber recados 
	 * de outros usuarios.		
	 */
	private static void adicionarUsuario(){
		int opcao = 1;
		Object[] opcaoTipo = {"VOLTAR", "COMUM", "VIP"};
		
		while(opcao!=0){
			opcao = JOptionPane.showOptionDialog(null,"Escolha um TIPO: ",
					"--------------- USUARIO ----------------",
					JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,
					opcaoTipo,opcaoTipo[0]);
	
			switch(opcao){
			
			case Menu.VOLTAR:
				break;
			case Opcao.USUARIOCOMUM:
				Usuario user = new UsuarioComum();
				
				String nome = JOptionPane.showInputDialog("Digite o NOME de usuario");
				user.setNome(nome);
				String idad = JOptionPane.showInputDialog("Digite sua IDADE " + nome);
				int idade = Integer.parseInt(idad);
				user.setIdade(idade);
				usuarios.put(nome, user);
				
				break;
			case Opcao.USUARIOVIP:
				Usuario userVip = new UsuarioVip();
				
				String nomeVip = JOptionPane.showInputDialog("Digite o NOME de usuario");
				userVip.setNome(nomeVip);
				String idadVip = JOptionPane.showInputDialog("Digite sua IDADE " + nomeVip);
				int idadeVip = Integer.parseInt(idadVip);
				userVip.setIdade(idadeVip);
				usuarios.put(nomeVip, userVip);
				
				break;
				
			default:
				JOptionPane.showMessageDialog(null, "Clique em VOLTAR");
			}
		}
	}
	
	/*
	 * Metodo adicionarComunidade, cria nova comunidade no sistema orkut,
	 * comnidade pode ser pública ou privada, um comunidade possui,
	 * titulo e categoria, somente a comunidade privada permite a inclusao de foruns. 
	 */
	private static void adicionarComunidade(){
		int opcao = 1;
		Object[] opcaoTipo = {"VOLTAR", " PUBLICA ", " PRIVADA "};
		Object[] opcaoCat = {"NENHUMA", "ESPORTE", "EDUCACAO"};
		
		while(opcao!=0){
			opcao = JOptionPane.showOptionDialog(null,"Escolha um TIPO: ",
					"-------------- COMUNIDADE ---------",
					JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,
					opcaoTipo,opcaoTipo[0]);

			switch(opcao){
			
			case Menu.VOLTAR:
				break;
			case Opcao.COMUNIDADEPUBLICA:
				Comunidade novaComunidade = new ComunidadePublica();
				int cat = 1;
				
				String titulo = JOptionPane.showInputDialog("Digite o TITULO da COMUNIDADE");
				novaComunidade.setTitulo(titulo);
				cat = JOptionPane.showOptionDialog(null,"Escolha uma CATEGORIA: ",
						"--------------- CATEGORIA ----------------",
						JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,
						opcaoCat,opcaoCat[0]);

				switch (cat){
				
				case Categoria.CODSEMCATEGORIA:
					JOptionPane.showMessageDialog(null,"Titulo: " + titulo + "\nCategoria: " + Categoria.DESCSEMCATEGORIA);
					novaComunidade.setCategoria(cat);
					novaComunidade.setDesCategoria(Categoria.DESCSEMCATEGORIA);
					comunidades.put(titulo, novaComunidade);
					break;
					
				case Categoria.CODCATEGORIAESPORTE:
					JOptionPane.showMessageDialog(null,"Titulo: " + titulo + "\nCategoria: " + Categoria.DESCCATEGORIAESPORTE);
					novaComunidade.setCategoria(cat);
					novaComunidade.setDesCategoria(Categoria.DESCCATEGORIAESPORTE);
					comunidades.put(titulo, novaComunidade);
					break;
				
				case Categoria.CODCATEGORIAEDUCACAO:
					JOptionPane.showMessageDialog(null,"Titulo: " + titulo + "\nCategoria: " + Categoria.DESCCATEGORIAEDUCACAO);
					novaComunidade.setCategoria(cat);
					novaComunidade.setDesCategoria(Categoria.DESCCATEGORIAEDUCACAO);
					comunidades.put(titulo, novaComunidade);
					break;
					
				default:
					break;
				}
								
				break;
			case Opcao.COMUNIDADEPRIVADA:
				Comunidade novaComunidadePrivada = new ComunidadePrivada();
				int catP = 1;
				
				String tituloPrivado = JOptionPane.showInputDialog("Digite o TITULO da COMUNIDADE");
				novaComunidadePrivada.setTitulo(tituloPrivado);
				catP = JOptionPane.showOptionDialog(null,"Escolha uma CATEGORIA: ",
						"--------------- CATEGORIA ----------------",
						JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,
						opcaoCat,opcaoCat[0]);
				
				switch (catP){
				
				case Categoria.CODSEMCATEGORIA:
					JOptionPane.showMessageDialog(null,"Titulo: " + tituloPrivado + "\nCategoria: " + Categoria.DESCSEMCATEGORIA);
					novaComunidadePrivada.setCategoria(catP);
					novaComunidadePrivada.setDesCategoria(Categoria.DESCSEMCATEGORIA);
					comunidades.put(tituloPrivado, novaComunidadePrivada);
					break;
					
				case Categoria.CODCATEGORIAESPORTE:
					JOptionPane.showMessageDialog(null,"Titulo: " + tituloPrivado + "\nCategoria: " + Categoria.DESCCATEGORIAESPORTE);
					novaComunidadePrivada.setCategoria(catP);
					novaComunidadePrivada.setDesCategoria(Categoria.DESCCATEGORIAESPORTE);
					comunidades.put(tituloPrivado, novaComunidadePrivada);
					break;
				
				case Categoria.CODCATEGORIAEDUCACAO:
					JOptionPane.showMessageDialog(null,"Titulo: " + tituloPrivado + "\nCategoria: " + Categoria.DESCCATEGORIAEDUCACAO);
					novaComunidadePrivada.setCategoria(catP);
					novaComunidadePrivada.setDesCategoria(Categoria.DESCCATEGORIAEDUCACAO);
					comunidades.put(tituloPrivado, novaComunidadePrivada);
					break;
					
				default:
					break;
				}
				break;
			default:
				break;
			}
		}
	}
	
	/*
	 * Metodo adicionarForum, cria um novo forum no sistema orkut,
	 * o forum permite que somente usuarios Vip postem mensagens.
	 */
	private static void adicionarForum(){
		Forum novoForum = new Forum();
		
		String titulo = JOptionPane.showInputDialog("Digite o TITULO do FORUM");
		novoForum.setTitulo(titulo);
		foruns.put(titulo, novoForum);	
	}

	/*
	 * Metodo adicionarMensagem, cria um nova mensagem em um forum
	 * especifico.
	 */
	private static void adicionarMensagem(){
		String keyNome = JOptionPane.showInputDialog("SEU nome de usuario\n");
		if(usuarios.containsKey(keyNome)){
					
			String keyTitulo = JOptionPane.showInputDialog("Digite o TITULO do forum\n");
				if(foruns.containsKey(keyTitulo)){
					Forum forumTemp = foruns.get(keyTitulo);
					String de = keyNome;
					String mensagem = JOptionPane.showInputDialog("Digite sua MENSAGEM\n");
					String mensagemFinal = ">>> " + de + " diz:\n" + "- " + mensagem + "\n";
					forumTemp.adicionarMensagem(mensagemFinal);
					}else
						JOptionPane.showMessageDialog(null, "Forum NAO cadastrado!!");
				}else
					JOptionPane.showMessageDialog(null, "Usuario NAO cadastrado!!");
		}
	
	/*
	 * Metodo adicionarRecado, permite que qualquer usuario envie recado 
	 * para qualquer usuario VIP.
	 */
	private static void adicionarRecado(){
		String de;
		String keyNomeDe = JOptionPane.showInputDialog("SEU NOME de usuario\n");
		if(usuarios.containsKey(keyNomeDe)){
			
			String keyNomePara = JOptionPane.showInputDialog("Digite o usuario DESTINATARIO\n");
			if(usuarios.containsKey(keyNomePara)){
				Usuario usuarioTemp = usuarios.get(keyNomePara);
				if(usuarioTemp instanceof UsuarioVip){
					de = keyNomeDe;
					String recado = JOptionPane.showInputDialog("Digite seu RECADO\n");
					String recadoFinal = ">>> " + de + " diz:\n" + "- " + recado + "\n";

					((UsuarioVip)usuarioTemp).adicionarRecado(recadoFinal);
				}else
					JOptionPane.showMessageDialog(null, "Usuario NAO e VIP!!");
			}else
				JOptionPane.showMessageDialog(null, "Usuario NAO cadastrado!!");
		}else
			JOptionPane.showMessageDialog(null, "Usuario NAO cadastrado!!");
	}

	/*
	 * Metodo adicionarUsuarioComunidade, permite que um usuario participe
	 * de um comunidade.
	 */
	private static void adicionarUsuarioComunidade(){
				
		String keyNome = JOptionPane.showInputDialog("Digite SEU NOME de usuario\n");
		if(usuarios.containsKey(keyNome)){
			Usuario usuarioTemp = usuarios.get(keyNome);
		
			String keyTitulo = JOptionPane.showInputDialog("Digite o TITULO da COMUNIDADE\n");
			if(comunidades.containsKey(keyTitulo)){
				Comunidade comunidadeTemp = comunidades.get(keyTitulo);
				if(comunidadeTemp.adicionarUsuario(usuarioTemp))
				JOptionPane.showMessageDialog(null, "Usuario " + usuarioTemp.getNome() + 
						", esta na Comunidade "+ comunidadeTemp.getTitulo() + ".");
			}else{
				JOptionPane.showMessageDialog(null, "Comunidade NAO existe!!");
				int resp = JOptionPane.showConfirmDialog(null,"Deseja CRIAR comunidade '" + keyTitulo + " ' ?",
						"----------- COMUNIDADE ----------", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);
				if(resp==0)
					adicionarComunidade();
			}
		}else
			JOptionPane.showMessageDialog(null, "Usuario nao cadastrado!!");						
	}
	
	/*
	 * Metodo adicionarForumComunidade, permite a inclusao de um forum previamente criado
	 * a um comunidade Privada.
	 */
	private static void adicionarForumComunidade(){
		
		String keyTitulo = JOptionPane.showInputDialog("Digite o TITULO do FORUM\n");
		if(foruns.containsKey(keyTitulo)){
			Forum forumTemp = foruns.get(keyTitulo);
			
			String keyTituloC = JOptionPane.showInputDialog("Digite o TITULO da COMUNIDADE\n");
			if(comunidades.containsKey(keyTituloC)){
				Comunidade comunidadeTemp = comunidades.get(keyTituloC);
				if(comunidadeTemp instanceof ComunidadePrivada){
				((ComunidadePrivada) comunidadeTemp).adicionarForum(forumTemp);
				JOptionPane.showMessageDialog(null, "Forum " + forumTemp.getTitulo() + 
						", esta na Comunidade "+ comunidadeTemp.getTitulo() + ".");
				}else 
					JOptionPane.showMessageDialog(null, "Comunidade NAO permite CRIAR forum!!");
			}else{
				JOptionPane.showMessageDialog(null, "Comunidade NAO EXISTE!!");
				int resp = JOptionPane.showConfirmDialog(null,"Deseja CRIAR comunidade '" + keyTitulo + " ' ?",
						"----------- COMUNIDADE ----------", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);

				if(resp==0)
					adicionarComunidade();
			}
		}else{
			JOptionPane.showMessageDialog(null, "Forum NAO cadastrado!!");
			adicionarForum();
		}
	}

	/*
	 * Metodo exibirUsuario, permite exibir usuarios por nome ou usarios cadastrados em um comunidade
	 * que voce escolher.
	 */
	private static void exibirUsuario(){
		Object[] opcaoTipo = {"Nome", "Comunidade"};
		
		int escolhi = JOptionPane.showOptionDialog(null,"EXIBIR POR: ",
				"--------------- COMUNIDADE ----------------",
				JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,
				opcaoTipo,opcaoTipo[0]);
		
		if(escolhi == 0){
			String keyNome = JOptionPane.showInputDialog("Digite o NOME de USUARIO\n");
			if(usuarios.containsKey(keyNome)){
				Usuario usuarioTemp = usuarios.get(keyNome);
				((Exibivel) usuarioTemp).exibir();
			}
		}
		else if(escolhi == 1){
			String keyTitulo = JOptionPane.showInputDialog("Digite o TITULO da COMUNIDADE\n");
			if(comunidades.containsKey(keyTitulo)){
				Comunidade comunidadeTemp = comunidades.get(keyTitulo);
			
				for(int i=0;i<comunidadeTemp.getUsuarios().size();i++){
					Usuario uRef = comunidadeTemp.getUsuarios().get(i);
					JOptionPane.showMessageDialog(null, "Usuario: " + uRef.getNome());
				} 
			}
		}
	}
	
	/*
	 * Metodo exibirComunidade, permite exibir comunidades e seus atribtos como titulo,
	 * descricao dad categoria, e foruns, se possuir.
	 */
	private static void exibirComunidade(){
		Object[] opcaoTipo = {"por NOME", "TODAS"};
		
		int opcao = JOptionPane.showOptionDialog(null,"EXIBIR: ",
				"--------------- COMUNIDADE ----------------",
				JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,
				opcaoTipo,opcaoTipo[0]);
		
		if(opcao == 0){
			String keyTitulo = JOptionPane.showInputDialog("Digite o TITULO da COMUNIDADE\n");
			if(comunidades.containsKey(keyTitulo)){
				Comunidade comunidadeTemp = comunidades.get(keyTitulo);
				((Exibivel) comunidadeTemp).exibir();
			}
		}
		else if(opcao == 1){
			Iterator<Comunidade> comunid = comunidades.values().iterator();
			while(comunid.hasNext()){
				Comunidade c = comunid.next();
				((Exibivel)c).exibir();
			}
		}
	}
	
	/*
	 * Metodo exibirForum, exibe titulo do forum e as mensagens, se possuir.
	 */
	private static void exibirForum(){
		Object[] opcaoTipo = {"voltar", "Por TITULO","Por COMUNIDADE","TODOS"};
		int opcao = 5;
		
		while(opcao!=0){
				opcao = JOptionPane.showOptionDialog(null,"EXIBIR: ",
					"--------------- COMUNIDADE ----------------",
					JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,
					opcaoTipo,opcaoTipo[0]);
			
			switch(opcao){					
			case 0:
				break;
			case 1:
				String keyTitulo = JOptionPane.showInputDialog("Digite o TITULO do FORUM\n");
				if(foruns.containsKey(keyTitulo)){
					Forum forumTemp = foruns.get(keyTitulo);
					((Exibivel) forumTemp).exibir();
				}
				break;
			case 2:
				String keyTituloC = JOptionPane.showInputDialog("Digite o TITULO da COMUNIDADE\n");
				if(comunidades.containsKey(keyTituloC)){
					Comunidade comunidadeTemp = comunidades.get(keyTituloC);
					if(comunidadeTemp instanceof ComunidadePrivada){
						for(int i=0;i<((ComunidadePrivada) comunidadeTemp).getForuns().size();i++){
						Forum fRef = ((ComunidadePrivada) comunidadeTemp).getForuns().get(i);
						((Exibivel) fRef).exibir();
					} 
				}else
					JOptionPane.showMessageDialog(null, "NAO E uma Comunidade PRIVADA!!");
			}

				break;
			case 3:
				Iterator<Forum> forunsTemp = foruns.values().iterator();
				while(forunsTemp.hasNext()){
					Forum f = forunsTemp.next();
					((Exibivel) f).exibir();
				}
				break; 
			
			default:
				break;
			}
		}
	}
	
	/*
	 * Metodo removerUsuarioComunidade, remove o usuario somente da comunidade desejada,
	 * e nao do sistema.
	 */
	private static void removerUsuarioComunidade(){
		
		String keyTitulo = JOptionPane.showInputDialog("Digite a COMUNIDADE");
		if(comunidades.containsKey(keyTitulo)){
			Comunidade comunidadeTemp = comunidades.get(keyTitulo);
			((Exibivel) comunidadeTemp).exibir();
			
			String keyNome = JOptionPane.showInputDialog("Digite o NOME do USUARIO\n");
			if(usuarios.containsKey(keyNome)){
				ArrayList<Usuario> usuariosTemps = comunidadeTemp.getUsuarios();
										
			for(int i=0;i<usuariosTemps.size();i++){
				Usuario usuarioTemp = usuariosTemps.get(i);
				if(usuarioTemp.getNome().equals(keyNome)){
				comunidadeTemp.removerUsuario(i);
				JOptionPane.showMessageDialog(null, "Usuario REMOVIDO com sucesso!");
				}
			} 
		}else
			JOptionPane.showMessageDialog(null, "Nome INVALIDO!");

	}else
		JOptionPane.showMessageDialog(null, "Comunidade INVALIDA!");
	}
	
	/*
	 * Metodo removerForum, remove forum somente da comunidade e nao do sistema.
	 */
	private static void removerForum(){
		
		String keyTituloC = JOptionPane.showInputDialog("Digite a COMUNIDADE");
		if(comunidades.containsKey(keyTituloC)){
			Comunidade comunidadeTemp = comunidades.get(keyTituloC);
			
			String keyTitulo = JOptionPane.showInputDialog("Digite o TITULO do FORUM\n");
			if(foruns.containsKey(keyTitulo)){
				ArrayList<Forum> forumTemps = ((ComunidadePrivada)comunidadeTemp).getForuns();
				
				for(int i=0;i<forumTemps.size();i++){
					Forum forumTemp = forumTemps.get(i);
					if(forumTemp.getTitulo().equals(keyTitulo)){
						((ComunidadePrivada)comunidadeTemp).removerForum(i);
					JOptionPane.showMessageDialog(null, "Forum REMOVIDO com SUCESSO!");
					}
					}
				}else
					JOptionPane.showMessageDialog(null, "Titulo INVALIDO!");
			}else
				JOptionPane.showMessageDialog(null, "Titulo INVALIDO!");
		}

	private static void removerRecado(){
		String msg = "";
		String keyNome = JOptionPane.showInputDialog("Digite seu NOME de USUARIO");
		if(usuarios.containsKey(keyNome)){
			Usuario usuarioTemp = usuarios.get(keyNome);
			if(usuarioTemp instanceof UsuarioVip){
								
				ArrayList<String> recadosTemp = ((UsuarioVip)usuarioTemp).getRecados();
										
			for(int i=0;i<recadosTemp.size();i++){
				String recado = recadosTemp.get(i);
				msg = msg + "recado- " + i + " - " + recado + "\n";			
			}
			String posicao = JOptionPane.showInputDialog("recados\n" + msg + "Digite o NUMERO do recado para APAGAR");
			int num = Integer.parseInt(posicao);
				((UsuarioVip)usuarioTemp).removerRecado(num);
				JOptionPane.showMessageDialog(null, "Recado REMOVIDO com SUCESSO!");
				}else
					JOptionPane.showMessageDialog(null, "Usuario NAO e VIP"); 
		}else
			JOptionPane.showMessageDialog(null, "Nome INVALIDO!");
	}
	
	private static void removerMensagem(){
		String msg = "";
		String keyTitulo = JOptionPane.showInputDialog("Digite o TTULO do FORUM");
		if(foruns.containsKey(keyTitulo)){
			Forum forumTemp = foruns.get(keyTitulo);
											
				ArrayList<String> mensagemTemp = forumTemp.getMensagens();
										
			for(int i=0;i<mensagemTemp.size();i++){
				String mensagem = mensagemTemp.get(i);
				msg = msg + "mensagem- " + i + " - " + mensagem + "\n";			
			}
			String posicao = JOptionPane.showInputDialog("mensagem\n" + msg + "Digite o NUMERO da mensagem para APAGAR");
			int num = Integer.parseInt(posicao);
				forumTemp.removerMensagem(num);
				JOptionPane.showMessageDialog(null, "Mensagem REMOVIDA com SUCESSO!");
			}else
			JOptionPane.showMessageDialog(null, "Titulo INVALIDO!");
	}

	public static void main(String args[]){
		int op=5;
		Object[] menuPrincipal = {"Sair", "Usuario", "Comunidade", "Forum"};
		Object[] menuUsuario = {"Voltar", "Novo", "Exibir", "Enviar Recado", "Remover Recado"};
		Object[] menuComunidade = {"Voltar", "Criar", "Exibir", "Participar", "Deixar"};
		Object[] menuForum = {"Voltar", "Criar", "Exibir", "Adicionar", "Remover", "Postar", "Remover Postagem"};
				
		while(op!=0){
			op = JOptionPane.showOptionDialog(null,"Escolha uma opcao: ",
					"--------------------------------- ORKUT ----------------------",
					JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,
					menuPrincipal,menuPrincipal[0]);
			
			switch(op){
			
			case Menu.SAIR:
				break;
			case Menu.OPCOESDEUSUARIO:
				while(op!=0){
					op = JOptionPane.showOptionDialog(null,"Escolha uma opcao: ",
							"--------------------------------- USUARIO --------------------------",
							JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,
							menuUsuario,menuUsuario[0]);
					
					switch(op){					
					case Menu.VOLTAR:
						break;
					case Menu.ADICIONARUSUARIO:
						adicionarUsuario();
						break;
					case Menu.EXIBIRUSUARIO:
						exibirUsuario();
						break;
					case Menu.ADICIONARRECADO:
						adicionarRecado();
						break;
					case Menu.REMOVERRECADO:
						removerRecado();
						break;
					default:
						JOptionPane.showMessageDialog(null, "Clique em Voltar");
					}
				}
				op = 5;
				break;
			case Menu.OPCOESDECOMUNIDADE:
				while(op!=0){
					op = JOptionPane.showOptionDialog(null,"Escolha uma opcao: ",
							"--------------------------------- COMUNIDADE --------------------------",
							JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,
							menuComunidade,menuComunidade[0]);
					
					switch(op){					
					case Menu.VOLTAR:
						break;
					case Menu.ADICIONARCOMUNIDADE:
						adicionarComunidade();
						break;
					case Menu.EXIBIRCOMUNIDADE:
						exibirComunidade();
						break;
					case Menu.ADICIONARUSUARIOCOMUNIDADE:
						adicionarUsuarioComunidade();
						break;
					case Menu.REMOVERUSUARIO:
						removerUsuarioComunidade();
						break;
					default:
						JOptionPane.showMessageDialog(null, "Clique em Voltar");
					}
				}
				op = 5;
				break;
			case Menu.OPCOESDEFORUM:
				while(op!=0){
					op = JOptionPane.showOptionDialog(null,"Escolha uma opcao: ",
							"---------------------------------- FORUM -----------------------------------",
							JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,
							menuForum,menuForum[0]);
					
					switch(op){					
					case Menu.VOLTAR:
						break;
					case Menu.ADICIONARFORUM:
						adicionarForum();
						break;
					case Menu.EXIBIRFORUM:
						exibirForum();
						break;
					case Menu.ADICIONARFORUMCOMUNIDADE:
						adicionarForumComunidade();
						break;
					case Menu.REMOVERFORUM:
						removerForum();
						break;
					case Menu.ADICIONARMENSAGEM:
						adicionarMensagem();
						break;
					case Menu.REMOVERMENSAGEM:
						removerMensagem();
						break;
					default:
						JOptionPane.showMessageDialog(null, "Clique em Voltar");
					}
				}
				op = 5;
				break;
			default:
				JOptionPane.showMessageDialog(null, "Clique em Sair");
				break;
			}
		}
	}
}

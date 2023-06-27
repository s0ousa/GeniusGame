package Controller;

import Model.Jogador;

public class DAOGenius  {

	public interface DAOAgenda {
		
		public void addJogador(Jogador jogador) throws Exception;
		public Jogador buscarJogador(String nome)throws Exception;
		public void initAgenda()throws Exception;
		
		

	}
	
}

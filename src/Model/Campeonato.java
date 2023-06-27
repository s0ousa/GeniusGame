package Model;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Controller.GeniusGame;

public class Campeonato {
	
	private String nome;
	private LocalDate data;
	private ArrayList<Jogador> jogadores;
	private int dificuldade; 
	private boolean empatado;
	
	
	public Campeonato(String nome,int dificuldade) {
		this.nome = nome;
		this.dificuldade = dificuldade;
		this.empatado = false;
		this.jogadores = new ArrayList <Jogador>();
		this.data = LocalDate.now();
				
	}
	public int getDificuldade() {
		if(this.dificuldade == 1) {
			return 1000;
		}
		else if(this.dificuldade ==2) {
			return 600;
		}
		return 300;
	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public ArrayList<Jogador> getJogadores() {
		return jogadores;
	}




	public void iniciarCampeonato() {
        Rodada rodadaAtual;

        	//como vou alternar os jogadores...
        	rodadaAtual = jogadores.get(0).criaNovaRodada();       	
        	rodadaAtual.iniciarRodada(this.getDificuldade());   	

    }
	
	public void continuarCampeonato(int indexJodador) {
		 Rodada rodadaAtual;

     	//como vou alternar os jogadores...
     	rodadaAtual = jogadores.get(indexJodador).criaNovaRodada();
     	
     	rodadaAtual.iniciarRodada(this.getDificuldade());
	}

    public Jogador passaVez(Jogador jogadorAnterior) {
    	//qual index meu usuario esta 
    	int posicao = jogadores.indexOf(jogadorAnterior) + 1; 
    	//qual tamanho da minha lista
    	int qtdJogadores = jogadores.size(); 
    	 
    	if(posicao == qtdJogadores) {
    		
    		
    		boolean empatou = GeniusGame.houveEmpate();
    		
    		if(empatou) {
    			JOptionPane.showMessageDialog(null,"Houve Empate" ,"Vamos continuar??",3);
    			posicao = 0;
    			
        		
    			this.continuarCampeonato(posicao);//continua o campeonato começando do primeiro jogador
    		}else {
    			GeniusGame.parabenizaJogadorVencedor();
    			JOptionPane.showMessageDialog(null,"Fim de Jogo" ,"The end",0);
        		
    			System.exit(0);

    		}
    	}
    	JOptionPane.showMessageDialog(null,"Passando a vez para " + jogadores.get(posicao).getApelido() ,"Falhou...",0);
    	this.continuarCampeonato(posicao);
    	return jogadores.get(posicao);
    }

  
    
	
    public void continuarCampeonatoComMesmoJogador(Jogador jogador) {
    	  Rodada rodadaAtual;

      	//como vou alternar os jogadores...
      	rodadaAtual = jogador.criaNovaRodada();  
      	
      	rodadaAtual.iniciarRodada(this.getDificuldade());   	

		
	}

	
	
	

}



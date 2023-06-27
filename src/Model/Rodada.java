package Model;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.Timer;

import Services.ViewService;
import View.TesteP;



public class Rodada {
	private int id;
	private ArrayList <Integer> sequencia;
	private ArrayList <Jogada> jogadas; 
	private int indice;
	
	
	public Rodada() {
		this.sequencia = new ArrayList <Integer>();
		this.jogadas = new  ArrayList <Jogada>();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<Integer> getSequencia() {
		return sequencia;
	}

	public void setSequencia(ArrayList<Integer> sequencia) {
		this.sequencia = sequencia;
	}
	
	
	public ArrayList <Integer> geraSequencia() {
		
		Random random = new Random();
		this.sequencia.add(random.nextInt(4));
		return sequencia;				
	}
	
	// Método para iniciar uma rodada
    public void iniciarRodada(int tempodificuldade) {
    	

    	brilharSequencia(sequencia, tempodificuldade);
    	

        // Aguardar a jogada do jogador
    	
        // Implemente a lógica para esperar a resposta do jogador
    	
        // e chamar o método comparaJogada() quando a jogada for feita
    }

    
    private void brilharSequencia(ArrayList <Integer> sequencia, int tempodificuldade) {
    	// Exibir a sequência atual na tela para o jogador ver
    	 // Intervalo de tempo entre os brilhos (em milissegundos)
    	
    	indice = 0;
    	Timer timer = new Timer(tempodificuldade, e -> {
    		
    	    if (indice < sequencia.size()) {
    	        int botao = sequencia.get(indice);
    	        
    	        switch (botao) {
    	            case 0:
    	                ViewService.brilharBotao(TesteP.lblAmareloOn, 500, "/view/sound/sound1.wav");
    	                break;
    	            case 1:
    	                ViewService.brilharBotao(TesteP.lblVerdeOn, 500, "/view/sound/sound2.wav");
    	                break;
    	            case 2:
    	                ViewService.brilharBotao(TesteP.lblAzulOn, 500, "/view/sound/sound3.wav");
    	                break;
    	            case 3:
    	                ViewService.brilharBotao(TesteP.lblVermelhoOn, 500, "/view/sound/sound5.wav");
    	                break;
    	        }
    	        
    	        indice++;
    	    } else {
    	        ((Timer) e.getSource()).stop(); // Interrompe o timer quando a sequência terminar
    	    }
    	});

    	timer.start(); // Inicia o timer para agendar os brilhos sequenciais
    }

    
    public Jogada criaJogada(Jogador jogador) {

    	Jogada jogadaCriada = new Jogada(jogador);
		return jogadaCriada;
	}

}

package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.Timer;

import Model.Campeonato;
import Model.Jogada;
import Model.Jogador;

public class GeniusGame {
	
	private ArrayList<Integer> sequencia = new ArrayList<Integer>();
	private static Campeonato novoCampeonato;
	
	public GeniusGame() {
		
	}
	
	public void criarCampeonato(String nome, int dificuldade) {
		this.novoCampeonato = new Campeonato(nome, dificuldade);
	}

	public Campeonato getNovoCampeonato() {
		return this.novoCampeonato;
	}
	//pensar se isso deve estar em campeonato.
	public void criarListaJogadores(ArrayList<JTextField> dadosJogadores) {
		//adicionando jogadors na lista -- podemos encapsular no sistema
		for  (int i = 0; i<dadosJogadores.size(); i+=2) {
			Jogador novoJogador = new Jogador(dadosJogadores.get(i).getText(), dadosJogadores.get(i+1).getText());
			novoCampeonato.getJogadores().add(novoJogador);	
		}
	}
	
	public  int obterDificuldade (JRadioButton radioFacil, JRadioButton radioMedio, JRadioButton radioDificil) {
	    if (radioFacil.isSelected()) {
	        return 1;
	    } else if (radioMedio.isSelected()) {
	        return 2;
	    } 
	    
	    return 3;
	   
	}
	
	public Jogada receberResposta(int cor, Jogador jogador) {
		//recebe cor na lista da sequencia
		sequencia.add(cor);
		
		//verifica se é a hora de pegar o jogador atual entrar na sua ultima rodada e adicionar uma nova jogada a esse jogador
		if(jogador.getListaRodadas().size() == sequencia.size()) {
			Jogada novaJogada = jogador.getRodadaAtual().criaJogada(jogador); //fazer esse método para armazenar a jogada do jogador
			
			//criar esse método, a lista de sequencia da jogada vai receber essa sequencia
			novaJogada.addSequenciaCompleta(sequencia);
			return novaJogada; //recebeu resposta
		}
		
		return null;
	}
	
	public boolean compararSequencia(Jogador jogador, Jogada novaJogada) {
		//compara sequencia do jogador com a da rodada
		boolean acertou = jogador.getRodadaAtual().getSequencia().equals(sequencia);
		//continuar o jogo
		
		sequencia.removeAll(sequencia);
		
		return acertou;
	}
	
	// Método para imprimir o relatório final
    private void imprimirRelatorio() {
        
    }

    public static boolean houveEmpate() {
        int pontuacaoPrimeiroJogador = novoCampeonato.getJogadores().get(0).getPontuacaoTotal();

        for (int i = 1; i <novoCampeonato.getJogadores().size(); i++) {
            if (novoCampeonato.getJogadores().get(i).getPontuacaoTotal() != pontuacaoPrimeiroJogador) {
                return false; // Pontuações diferentes, não houve empate
            }
        }

        return true; // Todas as pontuações são iguais, houve empate
    }
    


    public static void parabenizaJogadorVencedor() {
     int pontuacaoMaxima = 0;
     Jogador jogadorMaximo = null;

     for (Jogador jogador : novoCampeonato.getJogadores()) {
         if (jogador.getPontuacaoTotal() > pontuacaoMaxima) {
             pontuacaoMaxima = jogador.getPontuacaoTotal();
             jogadorMaximo = jogador;
         }
     }

     if (jogadorMaximo != null) {
         String mensagem = "Parabéns, " + jogadorMaximo.getApelido() + "! Sua pontuação máxima foi: " + pontuacaoMaxima;
         JOptionPane.showMessageDialog(null, mensagem);
     }
 }



}

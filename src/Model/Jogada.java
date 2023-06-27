package Model;

import java.util.ArrayList;
import java.util.UUID;

public class Jogada {
	private UUID id;
	private Jogador jogador;
	private int pontuacao;
	private int tempo;
	private ArrayList<Integer> sequencia;//lembrar de 
	private boolean errou;
	
	
	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}

	public ArrayList<Integer> getSequencia() {
		return sequencia;
	}

	public void setSequencia(ArrayList<Integer> sequencia) {
		this.sequencia = sequencia;
	}

	public boolean isErrou() {
		return errou;
	}

	public void setErrou(boolean errou) {
		this.errou = errou;
	}

	public Jogada(Jogador jogador) {
		this.id = UUID.randomUUID();
		this.jogador = jogador;
		this.pontuacao = 0;
		this.tempo = 0;
		this.errou = false;
	}
	
	// Método para calcular a pontuação do jogador
    private void calcularPontuacao() {
       jogador.setPontuacaoTotal(jogador.getPontuacaoTotal() + pontuacao);
    }

	public void addSequenciaCompleta(ArrayList<Integer> sequencia) {
		
		this.sequencia = sequencia;
	}
	
	
}

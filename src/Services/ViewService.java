package Services;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JLabel;
import javax.swing.Timer;



public class ViewService {
	
	public static void brilharBotao(JLabel lbl, int time, String sound ) {
		lbl.setVisible(true);	
		Timer timer;
		
		reproduzirSom(sound);
			
		ActionListener tarefaAgendada = new ActionListener() {
		    public void actionPerformed(ActionEvent evt) {
		    	lbl.setVisible(false);
		    	
		    }
		};

		timer = new Timer(time, tarefaAgendada);
		timer.setRepeats(false); //faz rodar apenas 1 vez, sem isso ele ficar invocando a action de 2 em 2 minutos
		timer.start(); //inicia a task
		
	}

	public static void reproduzirSom(String sound) {
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(ViewService.class.getResource(sound));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

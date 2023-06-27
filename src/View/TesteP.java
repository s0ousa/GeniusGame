package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import Controller.GeniusGame;
import Model.Jogada;
import Model.Jogador;
import Services.ViewService;


public class TesteP {

	private JFrame frame;
	private JTextField txtNomeCampeonato;
	private JTextField txtFieldNome1;
	private JTextField txtFieldApelido1;
	private JTextField txtFieldNome2;
	private JTextField txtFieldNome3;
	private JTextField txtFieldApelido2;
	private JTextField txtFieldApelido3;
	public static JLabel lblAmareloOn;
	public static JLabel lblVermelhoOn;
	public static JLabel lblAzulOn;
	public static JLabel lblVerdeOn;
	private GeniusGame sistema = new GeniusGame();
	private Jogador jogadorAtual;
	Jogada novaJogada = null;
	boolean comecou = false;
	
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TesteP window = new TesteP();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TesteP() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setEnabled(true);
		frame.setBounds(100, 100, 1640, 924);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		
		tabbedPane.setBounds(0, 0, 1640, 924);
		frame.getContentPane().add(tabbedPane);
		
		
	
		//Teste
		JPanel panelInicio = new JPanel();
		tabbedPane.addTab("", null, panelInicio, null);
		panelInicio.setLayout(null);
		
		JPanel panelCadCampeonato = new JPanel();
		tabbedPane.addTab("", null, panelCadCampeonato, null);
		panelCadCampeonato.setLayout(null);
		
		ButtonGroup grupoDificuldade = new ButtonGroup();
		ButtonGroup grupoJogadores = new ButtonGroup();
		

		JLabel lblDificilSelected = new JLabel("New label");
		lblDificilSelected.setVisible(false);
		
		txtNomeCampeonato = new JTextField();
		txtNomeCampeonato.setForeground(new Color(245, 255, 250));
		txtNomeCampeonato.setFont(new Font("Consolas", Font.PLAIN, 20));
		txtNomeCampeonato.setBackground(new Color(94, 0, 94));
		txtNomeCampeonato.setBounds(597, 255, 453, 35);
		panelCadCampeonato.add(txtNomeCampeonato);
		txtNomeCampeonato.setColumns(10);
		txtNomeCampeonato.setOpaque(false);
		txtNomeCampeonato.setBorder(null);
		
		lblDificilSelected.setIcon(new ImageIcon(TesteP.class.getResource("/view/img/circleJogadores.png")));
		lblDificilSelected.setBounds(1093, 547, 103, 109);
		panelCadCampeonato.add(lblDificilSelected);
		
		JLabel lblMedioSelected = new JLabel("New label");
		lblMedioSelected.setIcon(new ImageIcon(TesteP.class.getResource("/view/img/circleJogadores.png")));
		lblMedioSelected.setBounds(958, 547, 103, 109);
		panelCadCampeonato.add(lblMedioSelected);
		
		lblMedioSelected.setVisible(false);
		
		JLabel lblFacilSelected = new JLabel("New label");
		lblFacilSelected.setIcon(new ImageIcon(TesteP.class.getResource("/view/img/circleJogadores.png")));
		lblFacilSelected.setBounds(811, 547, 103, 109);
		panelCadCampeonato.add(lblFacilSelected);
		
		lblFacilSelected.setVisible(false);
		
		JRadioButton radioDificil = new JRadioButton("Dificil");
		radioDificil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblDificilSelected.setVisible(true);
				lblMedioSelected.setVisible(false);
				lblFacilSelected.setVisible(false);
			}
			
		});
		radioDificil.setBackground(new Color(94, 0, 94));
		radioDificil.setBounds(1132, 663, 21, 21);
		panelCadCampeonato.add(radioDificil);
		grupoDificuldade.add(radioDificil);
		radioDificil.setVisible(true);
		
		JRadioButton radioMedio = new JRadioButton("Medio");
		radioMedio.setBackground(new Color(94, 0, 94));
		radioMedio.setForeground(new Color(94, 0, 94));
		radioMedio.setBounds(997, 663, 21, 21);
		panelCadCampeonato.add(radioMedio);
		grupoDificuldade.add(radioMedio);
		radioMedio.setVisible(true);
		radioMedio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblDificilSelected.setVisible(false);
				lblMedioSelected.setVisible(true);
				lblFacilSelected.setVisible(false);
			}
			
		});
		
		
		
		JRadioButton radioFacil = new JRadioButton("Facil");
		radioFacil.setBackground(new Color(94, 0, 94));
		radioFacil.setBounds(852, 663, 21, 21);
		
		radioFacil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblDificilSelected.setVisible(false);
				lblMedioSelected.setVisible(false);
				lblFacilSelected.setVisible(true);
			}
			
		});
		panelCadCampeonato.add(radioFacil);
		grupoDificuldade.add(radioFacil);
		
		
		radioFacil.setVisible(true);
		
		
		
		
		JLabel lbl3PlayersSelected = new JLabel("label3Players");
		lbl3PlayersSelected.setIcon(new ImageIcon(TesteP.class.getResource("/view/img/circleJogadores.png")));
		lbl3PlayersSelected.setBounds(1036, 352, 109, 125);
		panelCadCampeonato.add(lbl3PlayersSelected);
		
		JLabel lbl2PlayersSelected = new JLabel("label2Players");
		
		
		lbl2PlayersSelected.setIcon(new ImageIcon(TesteP.class.getResource("/view/img/circleJogadores.png")));
		lbl2PlayersSelected.setBounds(862, 352, 109, 125);
		panelCadCampeonato.add(lbl2PlayersSelected);
		
		boolean selected = false;
		lbl2PlayersSelected.setVisible(selected);
		lbl3PlayersSelected.setVisible(selected);
		
		
		JRadioButton radio2Jogadores = new JRadioButton("2jogadores");
		radio2Jogadores.setBackground(new Color(94, 0, 94));
		radio2Jogadores.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//colocar radio como off
				lbl3PlayersSelected.setVisible(selected);
				lbl2PlayersSelected.setVisible(!selected);

			}
		});
				
				JRadioButton radio3Jogadores = new JRadioButton("3jogadores");
				radio3Jogadores.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						lbl3PlayersSelected.setVisible(!selected);
						lbl2PlayersSelected.setVisible(selected);
					}
				});
				radio3Jogadores.setBackground(new Color(94, 0, 94));
				radio3Jogadores.setBounds(1076, 472, 21, 21);
				panelCadCampeonato.add(radio3Jogadores);
				grupoJogadores.add(radio3Jogadores);
				radio3Jogadores.setVisible(true);
		
				radio2Jogadores.setBounds(903, 472, 21, 21);
				panelCadCampeonato.add(radio2Jogadores);
				grupoJogadores.add(radio2Jogadores);
				
				radio2Jogadores.setVisible(true);
		
		JLabel lblFundoCampeonatoCad = new JLabel("");
		lblFundoCampeonatoCad.setBackground(new Color(59, 19, 70));
		
		
		lblFundoCampeonatoCad.setIcon(new ImageIcon(TesteP.class.getResource("/view/img/fundoCampeonatoCad.png")));
		lblFundoCampeonatoCad.setBounds(0, 0, 1640, 924);
		panelCadCampeonato.add(lblFundoCampeonatoCad);
		
		JPanel panelCadJogadores = new JPanel();
		tabbedPane.addTab("New tab", null, panelCadJogadores, null);
		panelCadJogadores.setLayout(null);
		
		txtFieldApelido3 = new JTextField();
		txtFieldApelido3.setForeground(new Color(255, 255, 255));
		txtFieldApelido3.setFont(new Font("Source Code Pro Medium", Font.PLAIN, 28));
		txtFieldApelido3.setColumns(10);
		txtFieldApelido3.setBounds(932, 727, 471, 68);
		panelCadJogadores.add(txtFieldApelido3);
		txtNomeCampeonato.setColumns(10);
		txtFieldApelido3.setOpaque(false);
		txtFieldApelido3.setBorder(null);
		
		txtFieldApelido2 = new JTextField();
		txtFieldApelido2.setForeground(new Color(255, 255, 255));
		txtFieldApelido2.setFont(new Font("Source Code Pro Medium", Font.PLAIN, 28));
		txtFieldApelido2.setColumns(10);
		txtFieldApelido2.setBounds(931, 470, 471, 68);
		panelCadJogadores.add(txtFieldApelido2);
		txtFieldApelido2.setOpaque(false);
		txtFieldApelido2.setBorder(null);
		
		txtFieldNome3 = new JTextField();
		txtFieldNome3.setForeground(new Color(255, 255, 255));
		txtFieldNome3.setFont(new Font("Source Code Pro Medium", Font.PLAIN, 28));
		txtFieldNome3.setColumns(10);
		txtFieldNome3.setBounds(270, 740, 471, 68);
		panelCadJogadores.add(txtFieldNome3);
		txtFieldNome3.setOpaque(false);
		txtFieldNome3.setBorder(null);
		
		txtFieldNome2 = new JTextField();
		txtFieldNome2.setForeground(new Color(255, 255, 255));
		txtFieldNome2.setFont(new Font("Source Code Pro Medium", Font.PLAIN, 28));
		txtFieldNome2.setColumns(10);
		txtFieldNome2.setBounds(270, 471, 471, 68);
		panelCadJogadores.add(txtFieldNome2);
		txtFieldNome2.setOpaque(false);
		txtFieldNome2.setBorder(null);
		
		
		txtFieldApelido1 = new JTextField();
		txtFieldApelido1.setForeground(new Color(255, 255, 255));
		txtFieldApelido1.setFont(new Font("Source Code Pro Medium", Font.PLAIN, 28));
		txtFieldApelido1.setColumns(10);
		txtFieldApelido1.setBounds(934, 212, 471, 68);
		panelCadJogadores.add(txtFieldApelido1);
		txtFieldApelido1.setOpaque(false);
		txtFieldApelido1.setBorder(null);
		
		txtFieldNome1 = new JTextField();
		txtFieldNome1.setForeground(new Color(255, 255, 255));
		txtFieldNome1.setFont(new Font("Source Code Pro Medium", Font.PLAIN, 28));
		txtFieldNome1.setBounds(259, 213, 471, 68);
		panelCadJogadores.add(txtFieldNome1);
		txtFieldNome1.setColumns(10);
		txtFieldNome1.setOpaque(false);
		txtFieldNome1.setBorder(null);

		JPanel panelJogo = new JPanel();
		tabbedPane.addTab("", null, panelJogo, null);
		panelJogo.setLayout(null);
		
		JLabel lblplay = new JLabel("");

		lblplay.setBounds(413, 413, 102, 94);
		lblplay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!comecou) {
					sistema.getNovoCampeonato().iniciarCampeonato();
					jogadorAtual = sistema.getNovoCampeonato().getJogadores().get(0);
					comecou = true;
				}
		}
			
	
			
		});
		
		panelJogo.add(lblplay);
		
		JLabel lblApelidoP3 = new JLabel("");
		lblApelidoP3.setForeground(Color.WHITE);
		lblApelidoP3.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblApelidoP3.setBounds(1037, 564, 156, 31);
		panelJogo.add(lblApelidoP3);
		
		JLabel lblApelidoP2 = new JLabel("");
		lblApelidoP2.setForeground(Color.WHITE);
		lblApelidoP2.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblApelidoP2.setBounds(1037, 413, 156, 31);
		panelJogo.add(lblApelidoP2);
		
		JLabel lblApelidoP1 = new JLabel("");
		lblApelidoP1.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblApelidoP1.setForeground(new Color(255, 255, 255));
		lblApelidoP1.setBounds(1037, 248, 156, 31);
		panelJogo.add(lblApelidoP1);
		
		 lblVermelhoOn = new JLabel("New label");
		lblVermelhoOn.setIcon(new ImageIcon(TesteP.class.getResource("/view/img/vermelho-on.png")));
		lblVermelhoOn.setBounds(465, 463, 216, 216);
		panelJogo.add(lblVermelhoOn);
		
		 lblAzulOn = new JLabel("New label");
		lblAzulOn.setIcon(new ImageIcon(TesteP.class.getResource("/view/img/azul-on.png")));
		lblAzulOn.setBounds(246, 464, 216, 216);
		panelJogo.add(lblAzulOn);
		
		 lblVerdeOn = new JLabel("New label");
		lblVerdeOn.setIcon(new ImageIcon(TesteP.class.getResource("/view/img/verde-on.png")));
		lblVerdeOn.setBounds(466, 248, 216, 216);
		panelJogo.add(lblVerdeOn);
		
		lblAmareloOn = new JLabel("New label");
		lblAmareloOn.setIcon(new ImageIcon(TesteP.class.getResource("/view/img/amarelo-on.png")));
		lblAmareloOn.setBounds(246, 245, 216, 216);
		panelJogo.add(lblAmareloOn);
		lblAmareloOn.setVisible(false);
		lblVerdeOn.setVisible(false);
		lblVermelhoOn.setVisible(false);
		lblAzulOn.setVisible(false);
		
		JLabel lblClickVermelho = new JLabel("");
		lblClickVermelho.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				boolean acertou;
				
				ViewService.brilharBotao(lblVermelhoOn, 500, "/view/sound/sound5.wav");
				if(comecou) {
					novaJogada=sistema.receberResposta(3, jogadorAtual);
					if(novaJogada == null) {
						
					}else {
					
						acertou =sistema.compararSequencia(jogadorAtual, novaJogada);
						
						if(acertou) {
							JOptionPane.showMessageDialog(null,"Nova Rodada!", "Muito bem!",1);
							novaJogada.setErrou(false);
							novaJogada.setPontuacao(10);
							jogadorAtual.setPontuacaoTotal(10);
							sistema.getNovoCampeonato().continuarCampeonatoComMesmoJogador(jogadorAtual);
							
						}else {
							
							novaJogada.setErrou(true);
							
							jogadorAtual = sistema.getNovoCampeonato().passaVez(jogadorAtual);
							
						}
					}
				}
			}
		});
		lblClickVermelho.setBounds(494, 489, 187, 192);
		panelJogo.add(lblClickVermelho);
		
		JLabel lblClickVerde = new JLabel("");
		lblClickVerde.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				boolean acertou;
				
				ViewService.brilharBotao(lblVerdeOn, 500, "/view/sound/sound2.wav");
				
				if(comecou) {
					novaJogada=sistema.receberResposta(1, jogadorAtual);
					if(novaJogada == null) {
						
					}else {
					
						acertou =sistema.compararSequencia(jogadorAtual, novaJogada);
						
						if(acertou) {
							JOptionPane.showMessageDialog(null,"Nova Rodada!", "Muito bem!",0);
							
							novaJogada.setPontuacao(10);
							jogadorAtual.setPontuacaoTotal(10);
							sistema.getNovoCampeonato().continuarCampeonatoComMesmoJogador(jogadorAtual);
							
						}else {
							
							jogadorAtual = sistema.getNovoCampeonato().passaVez(jogadorAtual);
						}
					}
				}
			}
		});
		lblClickVerde.setBounds(498, 237, 195, 191);
		panelJogo.add(lblClickVerde);
		
		JLabel lblClickAmarelo = new JLabel("");
		lblClickAmarelo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				boolean acertou;
				
				ViewService.brilharBotao(lblAmareloOn, 500, "/view/sound/sound1.wav");
				
				if(comecou) {
					novaJogada=sistema.receberResposta(0, jogadorAtual);
					if(novaJogada == null) {
						
					}else {
					
						acertou =sistema.compararSequencia(jogadorAtual, novaJogada);
						
						if(acertou) {
							JOptionPane.showMessageDialog(null,"Nova Rodada!", "Muito bem!",0);
							novaJogada.setPontuacao(10);
							jogadorAtual.setPontuacaoTotal(10);
							sistema.getNovoCampeonato().continuarCampeonatoComMesmoJogador(jogadorAtual);
							
						}else {
							
							jogadorAtual = sistema.getNovoCampeonato().passaVez(jogadorAtual);
						}
					}
				}
			}
		});
		lblClickAmarelo.setBounds(246, 272, 194, 156);
		panelJogo.add(lblClickAmarelo);
		

		JLabel lblClickAzul = new JLabel("");
		lblClickAzul.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				boolean acertou;
				
				ViewService.brilharBotao(lblAzulOn, 500, "/view/sound/sound3.wav");
				if(comecou) {
					novaJogada= sistema.receberResposta(2, jogadorAtual);
	
					if(novaJogada == null) {
					}else {
					
						acertou =sistema.compararSequencia(jogadorAtual, novaJogada);
						
						if(acertou) {
							JOptionPane.showMessageDialog(null,"Nova Rodada!", "Muito bem!",0);
							novaJogada.setPontuacao(10);
							jogadorAtual.setPontuacaoTotal(10);
							sistema.getNovoCampeonato().continuarCampeonatoComMesmoJogador(jogadorAtual);
							
						}else {
							
							jogadorAtual = sistema.getNovoCampeonato().passaVez(jogadorAtual);
						}
					}
				}
			}
		});
		lblClickAzul.setBounds(246, 489, 184, 207);
		panelJogo.add(lblClickAzul);
		
		
		JLabel labelFundoJogo = new JLabel("New label");
		labelFundoJogo.setIcon(new ImageIcon(TesteP.class.getResource("/view/img/TelaJogo.png")));
		labelFundoJogo.setBounds(0, 0, 1640, 924);
		panelJogo.add(labelFundoJogo);
		
		JLabel lblPontuacaoJ1 = new JLabel("New label");
		lblPontuacaoJ1.setBounds(1439, 272, 92, 31);
		panelJogo.add(lblPontuacaoJ1);
		
		JLabel lblPontuacaoJ2 = new JLabel("New label");
		lblPontuacaoJ2.setBounds(1439, 413, 92, 31);
		panelJogo.add(lblPontuacaoJ2);
		
		JLabel lblPontuacaoJ3 = new JLabel("New label");
		lblPontuacaoJ3.setBounds(1439, 564, 92, 31);
		panelJogo.add(lblPontuacaoJ3);
		
		
		JLabel lblNextTelaCadastro = new JLabel("");
		lblNextTelaCadastro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				ArrayList <JTextField> dadosJogadores = new ArrayList <JTextField>();
				ArrayList <Jogador> jogadores = new ArrayList <Jogador>();
				//é a melhor logica??
				if(!txtFieldNome1.getText().isBlank() && !txtFieldApelido1.getText().isBlank() 
						&& !txtFieldNome2.getText().isBlank() && !txtFieldApelido2.getText().isBlank()) 
				{
					dadosJogadores.add(txtFieldNome1);
					dadosJogadores.add(txtFieldApelido1);
					dadosJogadores.add(txtFieldNome2);
					dadosJogadores.add(txtFieldApelido2);
					
					//colocando nome nas labels}
					lblApelidoP1.setText(txtFieldApelido1.getText());
					lblApelidoP2.setText(txtFieldApelido2.getText());
					lblPontuacaoJ1.setText("");
					
					if(radio3Jogadores.isSelected()) {
						//validacao
						if(!txtFieldNome3.getText().isBlank() && !txtFieldApelido3.getText().isBlank()) {
							dadosJogadores.add(txtFieldNome3);
							dadosJogadores.add(txtFieldApelido3);
							
							//colocando nome nas labels}
							lblApelidoP3.setText(txtFieldApelido3.getText());
							
							//criando campeonato
							int nDificuldade = sistema.obterDificuldade( radioFacil,  radioMedio,  radioDificil);
							sistema.criarCampeonato(txtNomeCampeonato.getText(), nDificuldade);
							
							//adicionando jogadores na lista
							sistema.criarListaJogadores(dadosJogadores);
							tabbedPane.setSelectedComponent(panelJogo);
							
							
						}else {
							JOptionPane.showMessageDialog(null,"Preencha todos os campos", "Erro!",0);
						}

					}else {
						//criando campeonato
						int nDificuldade = sistema.obterDificuldade( radioFacil,  radioMedio,  radioDificil);
						sistema.criarCampeonato(txtNomeCampeonato.getText(), nDificuldade);
						
						//adicionando jogadores na lista
						sistema.criarListaJogadores(dadosJogadores);
						tabbedPane.setSelectedComponent(panelJogo);
					}
						
						

					
				}else {
					JOptionPane.showMessageDialog(null,"Preencha todos os campos", "Erro!",0);
				}
				
	
			}
		});
		lblNextTelaCadastro.setBounds(1300, 21, 233, 79);
		panelCadJogadores.add(lblNextTelaCadastro);
		
		JLabel lblFundoCadJogadores = new JLabel("");
		lblFundoCadJogadores.setIcon(new ImageIcon(TesteP.class.getResource("/view/img/pagina3Jogadores.png")));
		lblFundoCadJogadores.setBounds(0, 0, 1640, 924);
		panelCadJogadores.add(lblFundoCadJogadores);
		
		// botão next para cadastro de jogadores 
		JLabel lblNext = new JLabel("");
		lblNext.setBounds(664, 716, 292, 57);
		lblNext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(grupoJogadores.getSelection() != null && grupoDificuldade.getSelection()!=null && !txtNomeCampeonato.getText().isBlank()) {
					tabbedPane.setSelectedComponent(panelCadJogadores);
					if(radio2Jogadores.isSelected()) {
						lblFundoCadJogadores.setIcon(new ImageIcon(TesteP.class.getResource("/view/img/pagina2Jogadores.png")));
						txtFieldNome3.setVisible(false);
						txtFieldApelido3.setVisible(false);
					}else {
						lblFundoCadJogadores.setIcon(new ImageIcon(TesteP.class.getResource("/view/img/pagina3Jogadores.png")));
						txtFieldNome3.setVisible(true);
						txtFieldApelido3.setVisible(true);
					}
					
				}else {
					//mostrar janelinha
					JOptionPane.showMessageDialog(null,"Preencha todos os campos", "Erro!",0);
				}
				
		
					
			}
		});
		panelCadCampeonato.add(lblNext);
		
		
		
		
		
		JLabel lblFundo = new JLabel("New label");
		
		lblFundo.setIcon(new ImageIcon(TesteP.class.getResource("/view/img/playFundo.png")));
		lblFundo.setBounds(0, 0, 1640, 924);
		panelInicio.add(lblFundo);
		
		JLabel lblNewGame = new JLabel("");
		lblNewGame.setBounds(430, 556, 631, 124);
		lblNewGame.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedComponent(panelCadCampeonato);
			}
		});
		panelInicio.add(lblNewGame);
		
		JLabel lblHistoric = new JLabel("");
		lblHistoric.setBounds(430, 705, 631, 124);
		lblHistoric.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		panelInicio.add(lblHistoric);
		
		
		
		
		
		
	}
}

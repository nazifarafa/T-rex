package userinterface;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class Frame {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame window = new Frame();
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
	public Frame() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		frame.setBounds(350, 150, 680, 310);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(new Color(173, 216, 230));
		
		JLabel label = new JLabel("");
		Image img =new ImageIcon(this.getClass().getResource("/pinkmain42.png")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(255, 71, 82, 93);
		frame.getContentPane().add(label);
		
		
		JLabel lblWelcomeToTrex = new JLabel("Welcome To T-rex Runner");
		lblWelcomeToTrex.setFont(new Font("Algerian", Font.BOLD, 41));
		lblWelcomeToTrex.setForeground(Color.BLUE);
		lblWelcomeToTrex.setBounds(27, 22, 609, 46);
		frame.getContentPane().add(lblWelcomeToTrex);
		
		JButton btnNewButton = new JButton("Start Game");
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				//(new GameWindow()).startGame();
				new Frame2();
				
			}
		});
		btnNewButton.setBounds(232, 175, 131, 36);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnHelp = new JButton("Help");
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				new Frame3();
			}
		});
		btnHelp.setBackground(new Color(0, 255, 255));
		btnHelp.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnHelp.setBounds(232, 226, 131, 29);
		frame.getContentPane().add(btnHelp);
		
       int delay = 350;	// 1000ms = 1s
		
		Timer timer = new Timer(delay, new ActionListener(){  
            @Override
            public void actionPerformed(ActionEvent e){
            	boolean v = label.isVisible();
            	if (v == true)
            		label.setVisible(false);
            	else
            		label.setVisible(true);
            	
            }               
        });
		
		timer.start();

		
		
		
	}

}

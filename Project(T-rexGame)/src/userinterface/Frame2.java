package userinterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Frame2 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame2 window = new Frame2();
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
	public Frame2() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(Color.WHITE);
		frame.getContentPane().setBackground(new Color(224, 255, 255));
		frame.setBounds(350, 150, 680, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		JLabel lblLevel = new JLabel("Level");
		lblLevel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblLevel.setBounds(273, 11, 113, 29);
		frame.getContentPane().add(lblLevel);
		
		JButton btnEasy = new JButton("Easy");
		btnEasy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frame.dispose();
				(new GameWindow2()).startGame();
			}
		});
		btnEasy.setBackground(new Color(0, 255, 255));
		btnEasy.setFont(new Font("Tahoma", Font.BOLD, 21));
		btnEasy.setBounds(262, 58, 89, 29);
		frame.getContentPane().add(btnEasy);
		
		JButton btnNewButton = new JButton("Hard");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				(new GameWindow()).startGame();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 21));
		btnNewButton.setBackground(new Color(0, 255, 255));
		btnNewButton.setBounds(262, 111, 89, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				new Frame();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBack.setBounds(262, 172, 89, 23);
		frame.getContentPane().add(btnBack);
	}
}

package userinterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Frame3 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame3 window = new Frame3();
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
	public Frame3() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(175, 238, 238));
		frame.setBounds(350, 150,680,380);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		JLabel lblInstruction = new JLabel("Instruction");
		lblInstruction.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblInstruction.setBounds(229, 11, 184, 33);
		frame.getContentPane().add(lblInstruction);
		
		JLabel lblPressSpacebar = new JLabel("1. Press spacebar to start the game.");
		lblPressSpacebar.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblPressSpacebar.setBounds(50, 70, 578, 25);
		frame.getContentPane().add(lblPressSpacebar);
		
		JLabel lblPressSpacebar_1 = new JLabel("2. Press spacebar to jump.");
		lblPressSpacebar_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblPressSpacebar_1.setBounds(50, 106, 363, 25);
		frame.getContentPane().add(lblPressSpacebar_1);
		
		JLabel lblYouCan = new JLabel("3. You can use down arrow key to duck.");
		lblYouCan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblYouCan.setBounds(50, 146, 363, 25);
		frame.getContentPane().add(lblYouCan);
		
		JLabel lblPressEnter = new JLabel("4. Press Enter to restart game in Game Over state.");
		lblPressEnter.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPressEnter.setBounds(50, 186, 453, 25);
		frame.getContentPane().add(lblPressEnter);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new Frame();
			}
		});
		btnBack.setBackground(new Color(211, 211, 211));
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnBack.setBounds(260, 315, 89, 25);
		frame.getContentPane().add(btnBack);
		
		JLabel lblPressBack = new JLabel("5. Press backspace in Game Over or Game Playing State to choose");
		lblPressBack.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblPressBack.setBounds(50, 222, 614, 42);
		frame.getContentPane().add(lblPressBack);
		
		JLabel lblBetweenEasyAnd = new JLabel("between easy and hard level.");
		lblBetweenEasyAnd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBetweenEasyAnd.setBounds(73, 268, 276, 25);
		frame.getContentPane().add(lblBetweenEasyAnd);
	}

}

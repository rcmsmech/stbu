package com;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Choice;
import java.awt.List;

public class Window {

	private JFrame frmSm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.frmSm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSm = new JFrame();
		frmSm.setDefaultLookAndFeelDecorated(true);
		frmSm.setResizable(false);
		frmSm.setTitle("STBU Contract");
		frmSm.setBounds(100, 100, 368, 171);
		frmSm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSm.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 93, 342, 46);
		frmSm.getContentPane().add(lblNewLabel);

		Choice choice = new Choice();
		String choices[] = {
				"Ducting",
				"Replace wicking kits",
				"Repair - HVAC Unit more than 10 years",
				"Replacement - Any Equipment",
				"Compressor - no warranty",
				"Compressor - parts & labor",
				"Partner Damage/Act of God",
				"EMS/Controls",
				"Gas pipe/valves PAST connection point",
				"Electrical Damage",
				"Roofing/Flashing (including water leaks)",
				"CAPEX",
				"Door Gaskets & Light Bulbs",
				"Engineering/Capacity issues",
				"Third Party (chill water temps, etc)",
				"Repair - HVAC Unit less than 10 years old",
				"Repair - 1DR/2DR UC less than 5 years old",
				"Repair - Upright less than 7 years old",
				"Repair - Upright more than 7 years old",
				"Repair - Wall of Chill less than 5 years old",
				"Repair - Wall of Chill more than 5 years old",
				"Repair - pastry case less than 7 years old",
				"Repair - pastry case more than 7 years old",
				"Spot Coolers",
				"Add Wicking Kits"
				
		};
		for (int i = 0; i < choices.length; i++) {
			Arrays.sort(choices);
			choice.add(choices[i]);
		}
		choice.setBounds(10, 10, 342, 20);
		frmSm.getContentPane().add(choice);

		JButton btnNewButton = new JButton("Generate");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				handle(choice.getSelectedItem());
			}

			private void handle(String string) {
				switch (string) {
				case "Replace wicking kits":
				case "Compressor - parts & labor":
					lblNewLabel.setText("CONTRACT");
					break;
				default:
				case "Add Wicking Kits":
					lblNewLabel.setText("NOT CONTRACT");
					break;
				}
				if (string.contains("less than")) {
					lblNewLabel.setText("CONTRACT");
				}
				if (lblNewLabel.getText().equalsIgnoreCase("CONTRACT")) {
					lblNewLabel.setForeground(Color.green);
				} else
					lblNewLabel.setForeground(Color.red);
			}
		});
		btnNewButton.setBounds(10, 52, 342, 30);
		frmSm.getContentPane().add(btnNewButton);
	}
}

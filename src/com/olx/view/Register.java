package com.olx.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.olx.controller.UserService;
import com.olx.model.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Register extends JFrame {
	private JFrame frame;
	private JPanel contentPane;
	private JTextField NameField;
	private JTextField Email;
	private JTextField City;
	private JTextField Phone;
	private JTextField Address;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(20, 31, 131, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(20, 56, 131, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Email: ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(20, 81, 131, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("City: ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(20, 106, 131, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Phone: ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(20, 131, 131, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Address: ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(20, 156, 131, 14);
		contentPane.add(lblNewLabel_5);
		
		NameField = new JTextField();
		NameField.setBounds(161, 31, 176, 20);
		contentPane.add(NameField);
		NameField.setColumns(10);
		
		Email = new JTextField();
		Email.setBounds(161, 81, 176, 20);
		contentPane.add(Email);
		Email.setColumns(10);
		
		City = new JTextField();
		City.setBounds(161, 106, 176, 20);
		contentPane.add(City);
		City.setColumns(10);
		
		Phone = new JTextField();
		Phone.setBounds(161, 131, 176, 20);
		contentPane.add(Phone);
		Phone.setColumns(10);
		
		Address = new JTextField();
		Address.setBounds(161, 156, 176, 20);
		contentPane.add(Address);
		Address.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(161, 56, 176, 20);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username=NameField.getText();
				  String password=passwordField.getText();
				  String email= Email.getText();
				  int phone =Integer.parseInt( Phone.getText());
				  String city = City.getText();
				  String address= Address.getText();
				  UserService userService = new UserService();
				  
				  User user = new User(username,password,email,phone,city,address);
				  boolean r = userService.register(user);
				  String resultMessage =userService.getResult().getMessage();
				 if(userService.getResult().isResult()==false) 
					 JOptionPane.showMessageDialog(frame,resultMessage, "error",JOptionPane.ERROR_MESSAGE);
				 else{
					 JOptionPane.showMessageDialog(frame,resultMessage);
				 }
			}
		});
		btnNewButton.setBounds(194, 223, 106, 27);
		contentPane.add(btnNewButton);
	}

}

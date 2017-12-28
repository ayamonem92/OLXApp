package com.olx.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.olx.controller.ProductService;
import com.olx.model.Category;
import com.olx.model.Product;
import com.olx.model.User;

import javax.swing.JLabel;
import java.awt.Font;

public class ShowProduct extends JFrame {

	private JPanel contentPane;

	
	/**
	 * Create the frame.
	 */
	public ShowProduct(int id) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel name = new JLabel("");
		name.setFont(new Font("Tahoma", Font.PLAIN, 13));
		name.setBounds(210, 11, 148, 14);
		contentPane.add(name);
		
		JLabel lblNewLabel = new JLabel("Product Name:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 11, 152, 14);
		contentPane.add(lblNewLabel);
		
		JLabel price = new JLabel("");
		price.setFont(new Font("Tahoma", Font.PLAIN, 13));
		price.setBounds(210, 36, 63, 14);
		contentPane.add(price);
		
		JLabel lblNewLabel_1 = new JLabel("Price: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 36, 152, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel Date = new JLabel("");
		Date.setFont(new Font("Tahoma", Font.PLAIN, 13));
		Date.setBounds(210, 61, 118, 14);
		contentPane.add(Date);
		
		JLabel lblNewLabel_2 = new JLabel("Date:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(10, 61, 152, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblUserName = new JLabel("User name:");
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUserName.setBounds(10, 86, 152, 14);
		contentPane.add(lblUserName);
		
		JLabel username = new JLabel("");
		username.setFont(new Font("Tahoma", Font.PLAIN, 13));
		username.setBounds(210, 86, 148, 14);
		contentPane.add(username);
		
		JLabel lblCity = new JLabel("City:");
		lblCity.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCity.setBounds(10, 111, 152, 14);
		contentPane.add(lblCity);
		
		JLabel City = new JLabel("");
		City.setFont(new Font("Tahoma", Font.PLAIN, 13));
		City.setBounds(210, 111, 118, 14);
		contentPane.add(City);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAddress.setBounds(10, 136, 152, 14);
		contentPane.add(lblAddress);
		
		JLabel Address = new JLabel("");
		Address.setFont(new Font("Tahoma", Font.PLAIN, 13));
		Address.setBounds(210, 136, 184, 14);
		contentPane.add(Address);
		
		JLabel lblCategory = new JLabel("Category:");
		lblCategory.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCategory.setBounds(10, 161, 152, 14);
		contentPane.add(lblCategory);
		
		JLabel Category = new JLabel("");
		Category.setFont(new Font("Tahoma", Font.PLAIN, 13));
		Category.setBounds(210, 161, 118, 14);
		contentPane.add(Category);
		ProductService proService = new ProductService();
		Product product = proService.getProductById(id);
		name.setText(product.getName());
		Date.setText(product.getDate());
		price.setText(product.getPrice().toString());
		User user = product.getUser();
		Category categ = product.getCategory();
		username.setText(user.getName());
		City.setText(user.getCity());
		Address.setText(user.getCity());
		Category.setText(categ.getName());
		
		
	}
}

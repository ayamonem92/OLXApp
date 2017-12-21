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
		name.setBounds(137, 11, 148, 14);
		contentPane.add(name);
		
		JLabel lblNewLabel = new JLabel("Product Name:");
		lblNewLabel.setBounds(10, 11, 105, 14);
		contentPane.add(lblNewLabel);
		
		JLabel price = new JLabel("");
		price.setBounds(137, 36, 63, 14);
		contentPane.add(price);
		
		JLabel lblNewLabel_1 = new JLabel("Price: ");
		lblNewLabel_1.setBounds(10, 36, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel Date = new JLabel("");
		Date.setBounds(137, 61, 118, 14);
		contentPane.add(Date);
		
		JLabel lblNewLabel_2 = new JLabel("Date:");
		lblNewLabel_2.setBounds(10, 61, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblUserName = new JLabel("User name:");
		lblUserName.setBounds(10, 86, 82, 14);
		contentPane.add(lblUserName);
		
		JLabel username = new JLabel("");
		username.setBounds(137, 86, 148, 14);
		contentPane.add(username);
		
		JLabel lblCity = new JLabel("City:");
		lblCity.setBounds(10, 111, 46, 14);
		contentPane.add(lblCity);
		
		JLabel City = new JLabel("");
		City.setBounds(137, 111, 63, 14);
		contentPane.add(City);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(10, 136, 63, 14);
		contentPane.add(lblAddress);
		
		JLabel Address = new JLabel("");
		Address.setBounds(137, 136, 184, 14);
		contentPane.add(Address);
		
		JLabel lblCategory = new JLabel("Category:");
		lblCategory.setBounds(10, 161, 63, 14);
		contentPane.add(lblCategory);
		
		JLabel Category = new JLabel("");
		Category.setBounds(137, 161, 118, 14);
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

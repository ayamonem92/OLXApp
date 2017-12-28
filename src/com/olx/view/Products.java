package com.olx.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.olx.controller.ProductService;
import com.olx.model.*;
import javax.swing.ListSelectionModel;
public class Products extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public Products(int  id){
		initilize();
		ProductService productService = new ProductService();
		// products = new HashSet<Product>();

		 Set<Product>products = productService.ListOfProducts(new CategoryDtoReq(id));
		 JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(31, 26, 297, 167);
			contentPane.add(scrollPane);
			
			table = new JTable();
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Product ID",
					"Product Name"
				}
			));
	
			 Vector data = new Vector();
		     Vector row = null;
		     table.setCellSelectionEnabled(true);
		     for(Product product : products){
		    	 row = new Vector(2);
		    	 row.add(product.getId());
		         row.add(product.getName());
		         ((DefaultTableModel)table.getModel()).addRow(row);
		     }
				table.setCellSelectionEnabled(true);
				
				ListSelectionModel cellSelectionModel = table.getSelectionModel();
			     cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

			     cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
			       public void valueChanged(ListSelectionEvent e) {
			         String selectedData = null;

			      
			             selectedData = table.getValueAt(table.getSelectedRow(), 0).toString();
			          
			         //System.out.println("Selected: " + selectedData);
			         try {
			        	 ShowProduct window = new ShowProduct(Integer.parseInt(selectedData));
							window.setVisible(true);
						} catch (Exception e1) {
							e1.printStackTrace();
						}
			       }

			     });
				scrollPane.setViewportView(table);
			}

	public void initilize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
	

}
	

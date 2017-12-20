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

import com.olx.controller.CategoryService;
import com.olx.model.*;
import javax.swing.ListSelectionModel;
public class Main extends JFrame {

	private JPanel contentPane;
	private JTable table;

	
public void initialize(){
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 450, 300);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(31, 26, 297, 167);
	contentPane.add(scrollPane);
	Set<Category> categories = new HashSet<Category>();
	CategoryService categoryService = new CategoryService();
	categories=categoryService.ListOfCategories();
	 Vector data = new Vector();
     Vector row = null;
     table = new JTable(new DefaultTableModel(
    			new Object[][] {
    			},
    			new String[] {
    				"Category Name"
    			}
    		));
     table.setCellSelectionEnabled(true);
     table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
     for(Category categ : categories){
    	 row = new Vector(1);
         row.add(categ.getName());
         ((DefaultTableModel)table.getModel()).addRow(row);
     }
  
     ListSelectionModel cellSelectionModel = table.getSelectionModel();
     cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

     cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
       public void valueChanged(ListSelectionEvent e) {
         String selectedData = null;

         int[] selectedRow = table.getSelectedRows();
         int[] selectedColumns = table.getSelectedColumns();

         for (int i = 0; i < selectedRow.length; i++) {
           for (int j = 0; j < selectedColumns.length; j++) {
             selectedData = (String) table.getValueAt(selectedRow[i], selectedColumns[j]);
           }
         }
         //System.out.println("Selected: " + selectedData);
         try {
        	 Products window = new Products(selectedData);
				window.setVisible(true);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
       }

     });
	scrollPane.setViewportView(table);
}
	/**
	 * Create the frame.
	 */
	
	public Main(String username) {
		initialize();
		//JOptionPane.showMessageDialog(this,"welcome "+username);
	}
}

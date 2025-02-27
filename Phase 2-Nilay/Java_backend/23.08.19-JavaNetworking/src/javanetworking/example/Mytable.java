package javanetworking.example;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.SwingConstants;

public class Mytable extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private RS2XMLconfig result=null;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mytable frame = new Mytable();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public Mytable() throws SQLException {
		getContentPane().setLayout(null);
		setVisible(true);
		table_1 = new JTable();
		table_1.setBounds(46, 62, 347, 155);
		getContentPane().add(table_1);
		
		JButton btnLoadData = new JButton("Load data");
		btnLoadData.setBounds(10, 228, 89, 23);
		getContentPane().add(btnLoadData);
		result=new RS2XMLconfig();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 395);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(26, 35, 438, 227);
		contentPane.add(table);
		
		JButton btnLoadData1 = new JButton("Load data");
		btnLoadData1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try {
					ResultSet rs=result.getEmployees(data);
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnLoadData1.setBounds(27, 304, 89, 23);
		contentPane.add(btnLoadData1);
	}
int data;
	public Mytable(int data) {
		this.data=data;
	}
}

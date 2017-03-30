package projectonstocks;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class orderstock extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					orderstock frame = new orderstock();
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
	public orderstock() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 452);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnAdd = new JMenu("Add ");
		menuBar.add(mnAdd);
		
		JMenuItem mntmProduct = new JMenuItem("product");
		mntmProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String option=mntmProduct.getActionCommand();
				String value=JOptionPane.showInputDialog("Enter "+option+" Name");
				DBInfo.addValue(option, value);
				JOptionPane.showMessageDialog(getParent(), option+" added!","Success",JOptionPane.INFORMATION_MESSAGE);;
				dispose();
				new orderstock().setVisible(true);
			}
		});
		mnAdd.add(mntmProduct);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblOrderStock = new JLabel("Order Stock");
		lblOrderStock.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblOrderStock.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				dispose();
				admin a=new admin();
				a.setVisible(true);
			}
		});
		
		JLabel lblName = new JLabel("Name");
		
		JLabel lblNewLabel = new JLabel("Quantity");
		
		JLabel lblCostPrice = new JLabel("Cost Price");
		
		JComboBox comboBox = new JComboBox(DBInfo.getValues("stock"));		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
				}
				catch(Exception e)
				{
				
				}
				try
				{
				String name=comboBox.getSelectedItem().toString();
				String quantity=textField.getText();
				String cp=textField_1.getText();
				
				
				String query="update into employee values(?,?,?,?,?,?,?,?)";
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "rat");
				PreparedStatement ps=con.prepareStatement(query);
				
				ps.setString(1,name);
				ps.setString(2,quantity);
				ps.setString(3,cp);
				
				
				int i=ps.executeUpdate();
				    System.out.println(i+"row inserted");
				    con.close();
				    ps.close();
			}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});
		
		JButton btnCancel = new JButton("Cancel");
		
		JButton btnReset = new JButton("Reset");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblOrderStock, GroupLayout.PREFERRED_SIZE, 428, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(36, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(375, Short.MAX_VALUE)
					.addComponent(btnBack)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(54)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel)
						.addComponent(lblCostPrice))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(textField_1)
						.addComponent(textField)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(102, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(124)
					.addComponent(btnSubmit)
					.addGap(18)
					.addComponent(btnCancel)
					.addGap(18)
					.addComponent(btnReset)
					.addContainerGap(123, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(btnBack)
					.addGap(17)
					.addComponent(lblOrderStock, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCostPrice)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSubmit)
						.addComponent(btnCancel)
						.addComponent(btnReset))
					.addGap(53))
		);
		contentPane.setLayout(gl_contentPane);
	}
}

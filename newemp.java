package projectonstocks;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class newemp extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newemp frame = new newemp();
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
	public newemp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 485);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnAdd = new JMenu("Add");
		menuBar.add(mnAdd);
		
		JMenuItem mntmDesignation = new JMenuItem("Designation");
		mntmDesignation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String option=mntmDesignation.getActionCommand();
				String value=JOptionPane.showInputDialog("Enter "+option+" Name");
				DBInfo.addValue(option, value);
				JOptionPane.showMessageDialog(getParent(), option+" added!","Success",JOptionPane.INFORMATION_MESSAGE);;
				dispose();
				new newemp().setVisible(true);

			}
		});
		mnAdd.add(mntmDesignation);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				dispose();
				admin a=new admin();
				a.setVisible(true);
			}
		});
		
		JLabel lblAddEmployee = new JLabel("Add Employee");
		lblAddEmployee.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblAddEmployee.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblName = new JLabel("Name");
		
		JLabel lblDesignation = new JLabel("Designation");
		
		JLabel lblSalary = new JLabel("Salary");
		
		JLabel lblNewLabel = new JLabel("contact no");
		
		JLabel lblNewLabel_1 = new JLabel("Address");
		
		JLabel lblNewLabel_2 = new JLabel("");
		
		JLabel lblAadharNo = new JLabel("Aadhar no.");
		
		JLabel lblUserId = new JLabel("User id");
		
		JLabel lblPassword = new JLabel("Password");
		
		textField = new JTextField();
		textField.setColumns(10);
		
	//	JComboBox comboBox = new JComboBox();
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		passwordField = new JPasswordField();
		JComboBox comboBox = new JComboBox(DBInfo.getValues("designation"));
		
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
				String name=textField.getText();
				String designation=comboBox.getSelectedItem().toString();
				String salary=textField_1.getText();
				String contact=textField_2.getText();
				String address=textField_3.getText();
				String aadhar=textField_4.getText();
				String userid=textField_5.getText();
				char ch[]=passwordField.getPassword();
				String password=String.copyValueOf(ch);

				String query1="insert into login value(?,?,?)";
				
				
				String query="insert into employee values(?,?,?,?,?,?,?,?)";
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "rat");
				PreparedStatement ps=con.prepareStatement(query);
				PreparedStatement ps1=con.prepareStatement(query1);
				
				ps.setString(1,name);
				ps.setString(2,designation);
				ps.setString(3,salary);
				ps.setString(4,contact);
				ps.setString(5,address);
				ps.setString(6,aadhar);
				ps.setString(7,userid);
				ps.setString(8,password);
				
				ps1.setString(1,userid);
				ps1.setString(2,password);
				ps1.setString(3,"Employee");
				
				int i=ps.executeUpdate();
				ps1.executeUpdate();
				    System.out.println(i+"row inserted");
				    if(i==1)
				    {
						JOptionPane.showMessageDialog(getParent(), "New employee sucesfully added", "Sucessfull", JOptionPane.INFORMATION_MESSAGE);			
                        dispose();
                        admin a=new admin();
                        a.setVisible(true);
				    }
				    if(i==0)
						JOptionPane.showMessageDialog(getParent(), "Login Failed,Retry!", "Error", JOptionPane.ERROR_MESSAGE);			

				    con.close();
				    ps.close();
				    ps1.close();
			}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});
		
		JButton btnRest = new JButton("Reset");
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				dispose();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(380, Short.MAX_VALUE)
					.addComponent(btnBack))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAddEmployee, GroupLayout.PREFERRED_SIZE, 363, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(62, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(39)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(34)
							.addComponent(btnSubmit)
							.addGap(18)
							.addComponent(btnRest)
							.addGap(18)
							.addComponent(btnCancel))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDesignation)
								.addComponent(lblSalary)
								.addComponent(lblNewLabel)
								.addComponent(lblNewLabel_1)
								.addComponent(lblAadharNo)
								.addComponent(lblNewLabel_2)
								.addComponent(lblUserId)
								.addComponent(lblPassword))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(passwordField)
								.addComponent(textField_5)
								.addComponent(textField_4)
								.addComponent(textField_3)
								.addComponent(textField_2)
								.addComponent(textField_1)
								.addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))))
					.addContainerGap(107, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(btnBack)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblAddEmployee, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDesignation)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSalary)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblAadharNo)
							.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblUserId)
							.addGap(18)
							.addComponent(lblPassword))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancel)
						.addComponent(btnRest)
						.addComponent(btnSubmit)))
		);
		contentPane.setLayout(gl_contentPane);
	}
}

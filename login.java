package projectonstocks;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 432, 331);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblEnterUsername = new JLabel("Username");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblEnterPassword = new JLabel("Password");
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("Admin");
		comboBox.addItem("Employee");
		
		JButton btnNewButton = new JButton("Login");
			btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				int flag=0;

				String s1=textField.getText();
				char ch[]=passwordField.getPassword();
				String s2=String.copyValueOf(ch);
                String usertype=(String)comboBox.getSelectedItem();
				String usertype1="";
				Connection con=DBInfo.con;
				String query="select * from login where username=? and password=? and type=? ";
				try
				{
				PreparedStatement ps=con.prepareStatement(query);
				ps.setString(1, s1);
				ps.setString(2, s2);
				ps.setString(3, usertype);
				ResultSet res=ps.executeQuery();
				
//next method will move the cursor to the next record and will return true if next record is available in the ResultSet ,else will return false
					while(res.next())
					{
						flag=1;
						usertype1=res.getString(3);
						break;
					}	
						if(usertype1.equals("Admin"))
						{
							dispose();
							admin admin1=new admin();
							admin1.setVisible(true);
							 
							  System.out.println(usertype1.equals("Admin") +"\t" +"hey its true");
						}
						if(usertype1.equals("Employee"))
						{
							employee a=new employee();
							  a.setVisible(true);
							  login.this.dispose();
						}
					  System.out.println(usertype1  +"\t"    +usertype);					
					  System.out.println(usertype1.equals(usertype));
					  System.out.println(usertype1.equals("Admin"));
					  System.out.println(usertype1.equals("Employee"));
					  
		
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
							/*if(flag==1 && usertype.equalsIgnoreCase("user"))
				{
					User u=new User("User section");
					u.setVisible(true);
					Login.this.dispose();
				}*/
				if(flag==0)
				{
		JOptionPane.showMessageDialog(getParent(), "Login Failed,Retry!", "Error", JOptionPane.ERROR_MESSAGE);			
				}

				
			}
		});
		
		JLabel lblEnterType = new JLabel("Type");
		
		JList list = new JList();
		
		JList list_1 = new JList();
		
		
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				dispose();
			}
		});
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
			
			}
		});
		
		JLabel lblLoginPage = new JLabel("Login page");
		lblLoginPage.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblLoginPage.setHorizontalAlignment(SwingConstants.CENTER);
		
		passwordField = new JPasswordField();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(76)
							.addComponent(btnNewButton)
							.addGap(18)
							.addComponent(btnCancel)
							.addGap(18)
							.addComponent(btnReset))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(49)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblEnterUsername)
									.addGap(18)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblEnterType)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblEnterPassword)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(18)
											.addComponent(list, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addGroup(gl_contentPane.createSequentialGroup()
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(list_1, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED, 171, Short.MAX_VALUE))
												.addComponent(comboBox, 0, 178, Short.MAX_VALUE)))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(18)
											.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE))))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(62)
							.addComponent(lblLoginPage, GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)))
					.addGap(90))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(14)
					.addComponent(lblLoginPage, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterUsername)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterPassword)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterType)
						.addComponent(list, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(46)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(list_1, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNewButton)
								.addComponent(btnCancel)
								.addComponent(btnReset))
							.addGap(12))))
		);
		contentPane.setLayout(gl_contentPane);
	}
}

package projectonstocks;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class makeabill extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					makeabill frame = new makeabill();
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
	public makeabill() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 542, 473);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblMakeABill = new JLabel("MAKE A BILL");
		lblMakeABill.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMakeABill.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblName = new JLabel("Name");
		
		JLabel lblProduct = new JLabel("product");
		
		JLabel lblQuantity = new JLabel("Quantity");
		
		JLabel lblPrice = new JLabel("price");
		
		JLabel lblDiscount = new JLabel("discount");
		
		JLabel lblTotasl = new JLabel("totasl");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		//JComboBox comboBox = new JComboBox();
		JComboBox comboBox = new JComboBox(DBInfo.getValues("stock"));
		JButton btnSubmit = new JButton("Submit");
		
			
			btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				    String price=(textField_3.getText());
				    String product=comboBox.getName();
				    String discount=(textField_4.getText());
				    String total=(textField_5.getText());
				    String name=textField.getText();
				    String quantity=(textField_2.getText());
				    //total=((discount/100)*price)*quantity;
				     String query="insert into makeabill values (?,?,?,?,?,?)";
				     if(name.isEmpty())
						{
							JOptionPane.showMessageDialog(getParent(), "please fill all the textfields","Error",0);
						}
					    else
						{
							try
							{
								//Load the drivers
								Class.forName("con.mysql.jdbc.driver");
								
								//Establish a connection
								String url="jdbc:mysql://localhost:3306/project";
								String uname="root";
								String password="rat";
								
								Connection con;
								con=DriverManager.getConnection(url, uname, password);

								
								//write ur query
								//String query="insert into bill values (?,?,?,?,?,?,?,?)";
								 //prepare a statement
					
							    PreparedStatement ps=con.prepareStatement(query);
							    ps.setString(1,name);
							    ps.setString(3,(quantity));
							    ps.setString(2," aas");
							    ps.setString(5,(price));
							    ps.setString(6,(discount));
							    ps.setString(7,(total));
							   // ps.setString(7,model);
							  //  ps.setString(8,ab);
							  //execute your query
							    int i=ps.executeUpdate();
							 //   int j=psr.executeUpdate();
							    System.out.println(i+"row inserted");
							    con.close();
							    ps.close();

								JOptionPane.showMessageDialog(getParent(), "content saved sucessfully","MESSAGE",2);

							}
							catch(Exception E)
							{
								E.printStackTrace();
							}
						}
					
					

				    
			}
		});
		
		JButton btnCancel = new JButton("cancel");
		
		JButton btnReset = new JButton("Reset");
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				login a=new login();
				  a.setVisible(true);
				  makeabill.this.dispose();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(84)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblMakeABill, GroupLayout.PREFERRED_SIZE, 333, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnLogOut))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(lblTotasl, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblDiscount, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblPrice, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblQuantity, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblProduct, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblName, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(textField_5)
										.addComponent(textField_4)
										.addComponent(textField_3)
										.addComponent(textField)
										.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(106)
							.addComponent(btnSubmit)
							.addGap(18)
							.addComponent(btnCancel)
							.addGap(18)
							.addComponent(btnReset)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblMakeABill, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblName)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblProduct)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblQuantity)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPrice)
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblDiscount)
								.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTotasl)
								.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(31)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnSubmit)
								.addComponent(btnCancel)
								.addComponent(btnReset)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(23)
							.addComponent(btnLogOut)))
					.addContainerGap(34, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}

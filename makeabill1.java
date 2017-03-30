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
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.awt.event.ActionEvent;

public class makeabill1 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblProduct;
	private JLabel lblQuantity;
	private JLabel lblPrice;
	private JLabel lblDiscount;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					makeabill1 frame = new makeabill1();
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
	public makeabill1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 429);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblBill = new JLabel("BILL");
		lblBill.setHorizontalAlignment(SwingConstants.CENTER);
		lblBill.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		
		JLabel lblName = new JLabel("Name");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		lblProduct = new JLabel("product");
		
		lblQuantity = new JLabel("Quantity");
		
		lblPrice = new JLabel("price");
		
		lblDiscount = new JLabel("Discount");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		//JComboBox comboBox = new JComboBox();
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				dispose();
				login a=new login();
				  a.setVisible(true);
			}
		});
		
		JComboBox comboBox = new JComboBox(DBInfo.getValues("stock"));
			    
	    int total;
	   // total=Integer.valueOf(price)*Integer.valueOf(quantity)*(100+Integer.valueOf(discount));
	
	    String query="insert into bill values (?,?,?,?,?,?)";
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
				//Establish a connection
				try 
				{
					String price=(textField_3.getText());
				    String product=comboBox.getSelectedItem().toString();
				    String discount=(textField_4.getText());
				    String name=textField.getText();
				    String quantity=(textField_2.getText());
				    
                    double price1=Integer.parseInt(price);
                    double discount1=Integer.parseInt(discount);
                    double quantity1=Integer.parseInt(quantity);
                    System.out.println(price1);
                    System.out.println(discount1);
                    System.out.println(quantity1);
                    double total=price1*quantity1*((100-discount1)/100);
                    String tot1=Double.toString(total);
                    Date d=new Date();
                    String d1=d.toString();
                    String cp="";
                    int flag=0;
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "rat");
				String query="insert into bill values (?,?,?,?,?,?,?,?,?)";
				String query1="select * from stock where name=?";
			//	String query2="update stock set quantity=? where name=?";
				PreparedStatement ps=con.prepareStatement(query);
				PreparedStatement ps1=con.prepareStatement(query1);
			//	PreparedStatement ps2=con.prepareStatement(query2);
				
				ps1.setString(1,product);
		/*		ps2.setString(1,product);
				ps2.setString(2,product);
		*/	    ResultSet res=ps1.executeQuery();
		/*	    ResultSet res1=ps2.executeQuery();
*/				while(res.next())
				{
					flag=1;
					cp=res.getString(3);
					flag=res.getShort(2);
					//cp1=Integer.toString(cp);
					break;
				}	
				double cp1,profit;
				cp1=Integer.parseInt(cp);
				profit=total-(cp1*quantity1);
				String profit1=Double.toString(profit);
				ps.setString(1,name);
			    ps.setString(2,product);
			    ps.setString(3,quantity);
			    ps.setString(4,price);
			    ps.setString(5,discount);
			    ps.setString(6, tot1);
			    ps.setString(7, d1);
			    ps.setString(8, cp);
			    ps.setString(9, profit1);
			    
			    			
			  //  ResultSet res=ps1.executeQuery();
			    //execute ur query
			    int i=ps.executeUpdate();
			  //  int j=ps1.executeUpdate();
			    System.out.println(i+"row inserted");
			    con.close();
			    ps.close();
				}
				catch(Exception E)
				{
				    E.printStackTrace();
				}


			}
			
		});
		
		JButton btnCancel = new JButton("cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				dispose();
			}
		});
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblBill, GroupLayout.PREFERRED_SIZE, 335, GroupLayout.PREFERRED_SIZE)
							.addGap(33)
							.addComponent(btnBack))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(52)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblDiscount)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addComponent(lblProduct)
											.addComponent(lblName))
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addComponent(comboBox, 0, 229, Short.MAX_VALUE)
											.addComponent(textField, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE)))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addComponent(lblQuantity)
											.addComponent(lblPrice))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE)
											.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE)))))
							.addGap(144))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(70)
							.addComponent(btnSubmit)
							.addGap(18)
							.addComponent(btnCancel)
							.addGap(18)
							.addComponent(btnReset)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(27)
							.addComponent(lblBill, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
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
							.addGap(57)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnSubmit)
								.addComponent(btnCancel)
								.addComponent(btnReset)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnBack)))
					.addContainerGap(77, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}

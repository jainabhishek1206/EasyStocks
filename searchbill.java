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
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class searchbill extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
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
					searchbill frame = new searchbill();
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
	public searchbill() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 516, 431);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblSearchBook = new JLabel("Search bill");
		lblSearchBook.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblSearchBook.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				dispose();
				login a=new login();
				a.setVisible(true);
			}
		});
		
		JLabel label = new JLabel("");
		
		JButton btnByName = new JButton("BY Name");
		btnByName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				int flag=0;
				String name="",product="",quantity="",price="",discount="",total="";
				String value=textField.getText();
				String query="select * from bill where name=?";
				Connection con=DBInfo.con;
				try
				{
				PreparedStatement ps=con.prepareStatement(query);
				ps.setString(1, value);
				ResultSet res=ps.executeQuery();
				
//next method will move the cursor to the next record and will return true if next record is available in the ResultSet ,else will return false
					while(res.next())
					{
						flag=1;
						name=res.getString(1);
						product=res.getString(2);
						quantity=res.getString(3);
						price=res.getString(4);
						discount=res.getString(5);
						total=res.getString(6);
						break;
					}			
					if(flag==1)
					{
						System.out.println(name +product +quantity +price +discount +total );
						textField_1.setText(product);
						textField_2.setText(quantity);
						textField_3.setText(price);
						textField_4.setText(discount);
						textField_5.setText(price);
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});
		
		JLabel lblName = new JLabel("Name");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblProduct = new JLabel("product");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel lblQuantity = new JLabel("Quantity");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JLabel lblPrice = new JLabel("price");
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JLabel lblDiscount = new JLabel("discount");
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		JLabel lblTotal = new JLabel("Total");
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblTotal)
							.addContainerGap())
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblDiscount)
								.addContainerGap())
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblPrice)
									.addContainerGap())
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblQuantity)
										.addContainerGap())
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblProduct)
											.addContainerGap())
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(label)
											.addGap(6)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addGroup(gl_contentPane.createSequentialGroup()
													.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
														.addComponent(btnBack)
														.addGroup(gl_contentPane.createSequentialGroup()
															.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
															.addPreferredGap(ComponentPlacement.UNRELATED)
															.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
																.addComponent(textField_5, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
																.addComponent(textField_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
																.addComponent(textField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
																.addComponent(textField_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
																.addComponent(textField_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
																.addComponent(textField_4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE))
															.addGap(18)
															.addComponent(btnByName)))
													.addGap(49))
												.addGroup(gl_contentPane.createSequentialGroup()
													.addComponent(lblSearchBook, GroupLayout.PREFERRED_SIZE, 344, GroupLayout.PREFERRED_SIZE)
													.addContainerGap(117, Short.MAX_VALUE))))))))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(btnBack)
					.addGap(7)
					.addComponent(lblSearchBook, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnByName)
							.addComponent(lblName)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblProduct)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
						.addComponent(lblTotal)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(88, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}

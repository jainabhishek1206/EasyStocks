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

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import net.miginfocom.swing.MigLayout;

public class admin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin frame = new admin();
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
	public admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblStockMaintenance = new JLabel("EASY STOCKS");
		lblStockMaintenance.setHorizontalAlignment(SwingConstants.CENTER);
		lblStockMaintenance.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 26));
		
		JButton btnMakeABill = new JButton("Make a bill");
		btnMakeABill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				makeabill1 m=new makeabill1();
				 m.setVisible(true);
				  admin.this.dispose();
			}
		});
		
		JButton btnSeeProfit = new JButton("See profit");
		btnSeeProfit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				seeprofit s=new seeprofit();
				s.setVisible(true);
				//dispose();
			}
		});
		
		JButton btnOrderStock = new JButton("order stock");
		btnOrderStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				dispose();
				orderstock o=new orderstock();
				o.setVisible(true);
			}
		});
		
		JButton btnEnterNewEmployee = new JButton("Enter new employee");
		btnEnterNewEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				dispose();
				newemp n=new newemp();
				n.setVisible(true);
			}
		});
		
		JButton btnStockAvailable = new JButton("Stock available");
		btnStockAvailable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				Stockavailable s=new Stockavailable();
				s.setVisible(true);
			
			}
		});
		
		JButton btnNewButton = new JButton("Search bill");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				dispose();
				searchbill s=new searchbill();
				s.setVisible(true);
			}
		});
		
		JButton btnDeleteAnEmployee = new JButton("Delete an employee");
		btnDeleteAnEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String d1=JOptionPane.showInputDialog("Enter the employee name you want to delete");
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
				}
				catch(Exception e)
				{
				
				}
				try
				{
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "rat");

					PreparedStatement ps=con.prepareStatement("delete from login where username=?");
					PreparedStatement ps1=con.prepareStatement("delete from employee where userid=?");
				ps.setString(1,d1);
				
				ps1.setString(1,d1);
				
				int i=ps.executeUpdate();
				ps1.executeUpdate();
			    System.out.println(i+"row deleted");
			    if(d1==null||d1.trim().equals("")){
					JOptionPane.showMessageDialog(admin.this,"Id can't be blank");
			    }
					else
					{
				     if(i==1)
				    {
						JOptionPane.showMessageDialog(getParent(), "employee sucesfully deleted", "Sucessfull", JOptionPane.INFORMATION_MESSAGE);			
                        dispose();
                        admin a=new admin();
                        a.setVisible(true);
				    }
				    if(i==0)
						JOptionPane.showMessageDialog(getParent(), "Failed,Retry!", "Error", JOptionPane.ERROR_MESSAGE);			

				    con.close();
				    ps.close();
				    ps1.close();
			}
			    }
				catch(Exception e)
				{
					e.printStackTrace();
				}
			

			}
		});
		
		JButton btnProductInformation = new JButton("Add Product");
		btnProductInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				dispose();
				Addproduct a=new Addproduct();
				a.setVisible(true);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(7)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblStockMaintenance, GroupLayout.PREFERRED_SIZE, 454, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnMakeABill, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
									.addGap(26)
									.addComponent(btnSeeProfit, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
									.addGap(26)
									.addComponent(btnOrderStock, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnEnterNewEmployee, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
									.addGap(26)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(btnProductInformation, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(btnStockAvailable, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
											.addGap(26)
											.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE))))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnDeleteAnEmployee, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(23, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(7)
					.addComponent(lblStockMaintenance, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnMakeABill, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSeeProfit, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnOrderStock, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
					.addGap(4)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnEnterNewEmployee, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnStockAvailable, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnDeleteAnEmployee, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnProductInformation, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(36, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}

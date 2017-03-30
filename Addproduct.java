package projectonstocks;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class Addproduct extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Addproduct frame = new Addproduct();
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
	public Addproduct() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 474, 471);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnAdd = new JMenu("Add");
		menuBar.add(mnAdd);
		
		JMenuItem mntmProcessor = new JMenuItem("processor");
		mntmProcessor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				//String option=mntmProcessor.getActionCommand();
				String row="processor";
				String value=JOptionPane.showInputDialog("Enter "+row+" Name");
				DBInfo.add("info", value,row);
				JOptionPane.showMessageDialog(getParent(), ""+row+" added!","Success",JOptionPane.INFORMATION_MESSAGE);
				dispose();
				new Addproduct().setVisible(true);
			}
		});
		mnAdd.add(mntmProcessor);
		
		JMenuItem mntmRam = new JMenuItem("RAM");
		mntmRam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String row="RAM";
				String value=JOptionPane.showInputDialog("Enter "+row+" Name");
				DBInfo.add("info", value,row);
				JOptionPane.showMessageDialog(getParent(), ""+row+" added!","Success",JOptionPane.INFORMATION_MESSAGE);
				dispose();
				new Addproduct().setVisible(true);
			}
		});
		mnAdd.add(mntmRam);
		
		JMenuItem mntmOperatingSystem = new JMenuItem("Operating System");
		mntmOperatingSystem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String row="operating syeystem";
				String value=JOptionPane.showInputDialog("Enter "+row+" Name");
				DBInfo.add("info", value,row);
				JOptionPane.showMessageDialog(getParent(), ""+row+" added!","Success",JOptionPane.INFORMATION_MESSAGE);
				dispose();
				new Addproduct().setVisible(true);
			}
		});
		mnAdd.add(mntmOperatingSystem);
		
		JMenuItem mntmRom = new JMenuItem("ROM");
		mntmRom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				String row="ROM";
				String value=JOptionPane.showInputDialog("Enter "+row+" Name");
				DBInfo.add("info", value,row);
				JOptionPane.showMessageDialog(getParent(), ""+row+" added!","Success",JOptionPane.INFORMATION_MESSAGE);
				dispose();
				new Addproduct().setVisible(true);
			}
		});
		mnAdd.add(mntmRom);
		
		JMenuItem mntmGraphicsCard = new JMenuItem("Graphics card");
		mntmGraphicsCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				String row="graphics card";
				String value=JOptionPane.showInputDialog("Enter "+row+" Name");
				DBInfo.add("info", value,row);
				JOptionPane.showMessageDialog(getParent(), ""+row+" added!","Success",JOptionPane.INFORMATION_MESSAGE);
				dispose();
				new Addproduct().setVisible(true);
			}
		});
		mnAdd.add(mntmGraphicsCard);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblAddProduct = new JLabel("Add product");
		lblAddProduct.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblAddProduct.setHorizontalAlignment(SwingConstants.CENTER);
		
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
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblProcessor = new JLabel("Processor");
		JComboBox comboBox = new JComboBox(DBInfo.get("info","processor"));
	//	JComboBox comboBox = new JComboBox();
		
		JLabel lblRam = new JLabel("RAM");
		
		JComboBox comboBox_1 = new JComboBox(DBInfo.get("info","ram"));
		
		JLabel lblRom = new JLabel("ROM");
		
		JComboBox comboBox_2 = new JComboBox(DBInfo.get("info","rom"));
		
		JLabel lblOperatingSystem = new JLabel("Operating system");
		
		JComboBox comboBox_3 = new JComboBox(DBInfo.get("info","os"));
		
		JLabel lblGraphicsCard = new JLabel("Graphics card");
		
		JComboBox comboBox_4 = new JComboBox(DBInfo.get("info","graphics"));
		
		JLabel lblPrice = new JLabel("Price");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel lblOther = new JLabel("Other");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
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
					String processor=comboBox.getSelectedItem().toString();
					String ram=comboBox_1.getSelectedItem().toString();
					String rom=comboBox_2.getSelectedItem().toString();
					String os=comboBox_3.getSelectedItem().toString();
					String graphics=comboBox_4.getSelectedItem().toString();
					String price=textField_1.getText();
					String other=textField_2.getText();

				String query="insert into product values(?,?,?,?,?,?,?,?)";
				String query1="insert into stock values(?,?,?)";
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "rat");
				PreparedStatement ps=con.prepareStatement(query);
				PreparedStatement ps1=con.prepareStatement(query1);
				
				ps.setString(1,name);
				ps.setString(2,processor);
				ps.setString(3,ram);
				ps.setString(4,rom);
				ps.setString(5,os);
				ps.setString(6,graphics);
				ps.setString(7,price);
				ps.setString(8,other);
				
				ps1.setString(1,name);
				ps1.setString(2,"0");
				ps1.setString(3,price);
				
				
				int i=ps.executeUpdate();
				    System.out.println(i+"row inserted");
				    int j=ps1.executeUpdate();
				    System.out.println(j+"row inserted");
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
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				dispose();
			}
		});
		
		JButton btnReset = new JButton("Reset");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblAddProduct, GroupLayout.PREFERRED_SIZE, 325, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addGap(32)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblProcessor)
								.addComponent(lblRam)
								.addComponent(lblRom)
								.addComponent(lblOperatingSystem)
								.addComponent(lblGraphicsCard)
								.addComponent(lblPrice)
								.addComponent(lblOther))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
								.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
								.addComponent(comboBox_4, 0, 231, Short.MAX_VALUE)
								.addComponent(comboBox_3, 0, 231, Short.MAX_VALUE)
								.addComponent(comboBox_2, 0, 231, Short.MAX_VALUE)
								.addComponent(comboBox_1, 0, 231, Short.MAX_VALUE)
								.addComponent(comboBox, 0, 231, Short.MAX_VALUE)
								.addComponent(textField))))
					.addPreferredGap(ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
					.addComponent(btnBack)
					.addGap(22))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(109)
					.addComponent(btnSubmit)
					.addGap(18)
					.addComponent(btnCancel)
					.addGap(18)
					.addComponent(btnReset)
					.addContainerGap(112, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAddProduct, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnBack)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblProcessor)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRam)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRom)
						.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblOperatingSystem)
						.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGraphicsCard)
						.addComponent(comboBox_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPrice)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblOther)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSubmit)
						.addComponent(btnCancel)
						.addComponent(btnReset))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}

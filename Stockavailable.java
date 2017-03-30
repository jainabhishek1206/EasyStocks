package projectonstocks;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.ResultSetMetaData;

public class Stockavailable extends JFrame
{
	public Stockavailable() 
	{
		JTable table;
		Vector<String> header=new Vector<>();
		Vector<Vector<String>> record=new Vector<>();
		Connection con=new DBInfo().con;
		setSize(400,400);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		Connection cone=DBInfo.con;
		String str="select * from stock";
		try
		{
			PreparedStatement ps=con.prepareStatement(str);
			java.sql.ResultSet res=ps.executeQuery();
			
			//fetching metadata of table
			java.sql.ResultSetMetaData rsmd=res.getMetaData();
			int count=rsmd.getColumnCount();
			for(int i=1;i<=count;i++)
			{
				header.add(rsmd.getColumnName(i));
			}
			//records
			while(res.next())  // for rows
			{
				Vector<String> v=new Vector<>();
				for(int i=1;i<count+1;i++)
				{
					v.add(res.getString(i));
				}
				record.add(v);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		table=new JTable(record,header);
		JScrollPane pane=new JScrollPane(table);
		add(pane);
	}
	public static void main(String[] args) 
	{
		Stockavailable obj=new Stockavailable();
		obj.setVisible(true);
	}

}

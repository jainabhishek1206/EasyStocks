package projectonstocks;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class DBInfo 
{
  static Connection con;
   static
   {
	   //load the Driver
	   try
	   {
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "rat");
	   }
	   catch (ClassNotFoundException | SQLException e)
	   {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
   
   public static void addAuthor(String value)
   {
	   String query="insert into author(name) values(?)";
	   try
	   {
		   PreparedStatement ps=con.prepareStatement(query);
		   ps.setString(1, value.toUpperCase());
		   ps.executeUpdate();
	   }
	   catch(Exception e)
	   {
		   e.printStackTrace();
	   }
   }
   public static void addValue(String option,String value)
   {
	   String query="insert into "+option+"(name) values(?)";
	  // System.out.println(query);
	   try
	   {
		   PreparedStatement ps=con.prepareStatement(query);
		   ps.setString(1, value.toUpperCase());
		   ps.executeUpdate();
	   }
	   catch(Exception e)
	   {
		   e.printStackTrace();
	   }
   }
  
   public static void add(String option,String value,String tab)
   {
	   String query="insert into "+option+"("+tab+") values(?)";
	  // System.out.println(query);
	   try
	   {
		   PreparedStatement ps=con.prepareStatement(query);
		   ps.setString(1, value.toUpperCase());
		   ps.executeUpdate();
	   }
	   catch(Exception e)
	   {
		   e.printStackTrace();
	   }
   }
    public static Vector<String> getValues(String tableName)
   {
	   Vector<String> v=new Vector<>();
	   
	   String query="select name from "+tableName+" order by name";
	   try
	   {
		  PreparedStatement ps=con.prepareStatement(query);
		  ResultSet res=ps.executeQuery();
	      while(res.next())
	      {
	    	  String str=res.getString(1);
	    	  v.add(str);
	      }
	   }
	   catch(Exception e)
	   {
		   e.printStackTrace();
	   }
	   return v;
   }
    public static Vector<String> get(String tableName,String row)
    {
 	   Vector<String> v=new Vector<>();
 	   
 	   String query="select "+row+" from "+tableName+" order by "+row+"";
 	   try
 	   {
 		  PreparedStatement ps=con.prepareStatement(query);
 		  ResultSet res=ps.executeQuery();
 	      while(res.next())
 	      {
 	    	  String str=res.getString(1);
 	    	  v.add(str);
 	      }
 	   }
 	   catch(Exception e)
 	   {
 		   e.printStackTrace();
 	   }
 	   return v;
    }

}

/*int price=Integer.parseInt(textField_3.getText());
String product=comboBox.getName();
int discount=Integer.parseInt(textField_4.getText());
int total=Integer.parseInt(textField_5.getText());
String name=textField.getText();
int quantity=Integer.parseInt(textField_2.getText());
total=((discount/100)*price)*quantity; */








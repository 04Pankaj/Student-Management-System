package StudentManagement;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//import com.mysql.cj.xdevapi.Statement;

public class StudentDao {
  public static boolean insertStudentToDB(Student st)
  {   
	  boolean f=false;
	  try
	  {
		  //jdbc code..
		  Connection con=CP.createC();
		  String q="insert into students(sname,sphone,scity)values(?,?,?)";
		  
		  //PreparedStatment
		  PreparedStatement ps=con.prepareStatement(q);
		  
		  //set the value of parameter
		  ps.setString(1, st.getStudentName());
		  ps.setString(2,st.getStudentPhone());
		  ps.setString(3, st.getStudentCity());
		  
		  //execute
		  ps.executeUpdate();
		  f=true;
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }
	return f;
  }

public static boolean deleteStudent(int userId) {
	boolean f=false;
	  try
	  {
		  //jdbc code..
		  Connection con=CP.createC();
		  String q="delete from students where sid=?";
		  
		  //PreparedStatment
		  PreparedStatement ps=con.prepareStatement(q);
		  
		  //set the value of parameter
		  ps.setInt(1, userId);
		  
		  
		  //execute
		  ps.executeUpdate();
		  f=true;
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }
	return f;
	
}

public static void showAllStudent() {
	boolean f=false;
	  try
	  {
		  //jdbc code..
		  Connection con=CP.createC();
		  String q="select * from students";
		  
		  //Statment
		     Statement s=con.createStatement();
		  
		 
		 ResultSet set=s.executeQuery(q);
		  
		 while(set.next())
		 {
			 int id=set.getInt(1);
			 String name=set.getString(2);
			 String phone=set.getString(3);
			 String city=set.getString("scity");
			 System.out.println("ID :"+ id);
			 System.out.println("Name :"+name);
			 System.out.println("phone :"+phone);
			 System.out.println("city :"+city);
			 System.out.println("+++++++++++++++++++");
			 
		 }
		  
		  
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }
	return ;
	
}
}

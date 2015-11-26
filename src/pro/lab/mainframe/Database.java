package pro.lab.mainframe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Database {
	Connection con;
	Statement stmt;
	public Database(){	
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","19007683760091");
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	public String getUserPassword(String username){
		ResultSet rs;
		String pass = "";	
		try{
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return pass;
	}
	
	
	
	
	
	
	
//	public static void main(String[] args) {
//		
//		
//			rs = stmt.executeQuery("select * from courses");
//			
//			while(rs.next()){
//				ResultSetMetaData rsmd = rs.getMetaData();
//				System.out.print(rsmd.getColumnName(1)+"\t"+rsmd.getColumnName(2)+"\t"+rsmd.getColumnName(3)+"\t"+rsmd.getColumnName(4)
//				+"\t"+rsmd.getColumnName(5)+"\t"+rsmd.getColumnName(6)+"\t"+rsmd.getColumnName(7)+"\n");
//				
//				System.out.print(rs.getString(1)+"\t"+rs.getString(2)+"/t"+rs.getString(3)
//				+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6)+"\t"+rs.getString(7)+"\n");
//			}
//			
//		
//
//	}

}

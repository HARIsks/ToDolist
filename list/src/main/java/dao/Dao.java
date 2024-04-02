package dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialBlob;

import dto.User;

public class Dao {
public static Connection getConnection() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/listdb?user=root&password=root");
		return con;
	}
	
	public static int saveUser(User User) throws SQLException, ClassNotFoundException {
		Connection con=getConnection();
		PreparedStatement pst=con.prepareStatement("insert into user values(?,?,?,?,?,?)");
		
		pst.setInt(1, User.getUserid());
		pst.setString(2, User.getUsername() );
		pst.setString(3, User.getUseremail());
		pst.setLong(4, User.getUsercontact());
		pst.setString(6, User.getUserpassword());
		
		Blob imageBlob= new SerialBlob(User.getUserimage());
		pst.setBlob(5,imageBlob);
		int res=pst.executeUpdate();
		return res;
	}
	
	public User findByEmail(String email) throws ClassNotFoundException, SQLException
	{
		Connection con=getConnection();
		PreparedStatement pst=con.prepareStatement("select * from user where useremail=?");
		pst.setString(1, email);
		ResultSet rs=pst.executeQuery();
		if(rs.next())
		{
			User u=new User();
			u.setUserid(rs.getInt(1));
			u.setUsername(rs.getString(2));
			u.setUsercontact(rs.getLong(4));
			u.setUserpassword(rs.getString(6));
			//convert blog image to byt[]
			Blob imageBlob=rs.getBlob(5);
			byte[] image=imageBlob.getBytes(1,(int)imageBlob.length());
			
			u.setUserimage(image);
			
			return u;
			
		}
		else {
			return null;
		}
	}

}
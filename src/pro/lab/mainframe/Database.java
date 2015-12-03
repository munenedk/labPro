package pro.lab.mainframe;

import java.awt.Dimension;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Database {
	Connection con;
	Statement stmt;
	PreparedStatement pstmt;

	public Database() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "19007683760091");
		} catch (Exception e) {
			StringBuilder err = new StringBuilder(e.toString());
			for (StackTraceElement s : e.getStackTrace()) {
				err.append("\n");
				err.append(s);
			}
			JTextArea textarea = new JTextArea(err.toString());
			JScrollPane scrollpane = new JScrollPane(textarea);
			textarea.setLineWrap(true);
			textarea.setWrapStyleWord(true);
			scrollpane.setPreferredSize(new Dimension(300, 150));
			JOptionPane.showMessageDialog(null, scrollpane, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public ArrayList<String[]> getAllCourses() {
		ResultSet rs; int ncol;
		ArrayList<String[]> courses = new ArrayList<>();
		try {
			pstmt = con.prepareStatement("select * from courses");
			rs = pstmt.executeQuery();
			ncol = rs.getMetaData().getColumnCount();
			while (rs.next()) {
				String[] row = new String[ncol];
				
				for(int icol = 1; icol<=ncol; icol++){
					row[icol-1] = rs.getObject(icol).toString();
				}
				courses.add(row);
			}
		} catch (Exception e) {
			StringBuilder err = new StringBuilder(e.toString());
			for (StackTraceElement s : e.getStackTrace()) {
				err.append("\n");
				err.append(s);
			}
			JTextArea textarea = new JTextArea(err.toString());
			JScrollPane scrollpane = new JScrollPane(textarea);
			textarea.setLineWrap(true);
			textarea.setWrapStyleWord(true);
			scrollpane.setPreferredSize(new Dimension(300, 150));
			JOptionPane.showMessageDialog(null, scrollpane, "Error", JOptionPane.ERROR_MESSAGE);
		}
		return courses;
	}

}

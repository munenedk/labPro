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
		pstmt = null;
		try {
			pstmt = con.prepareStatement("SELECT courseId, courseDesc, expectedCapacity, courses.program, "
					+ "prerequisite.prerequisiteDesc, resources.resourceDesc, degree.degreeID "
					+ "FROM courses,prerequisite,resources,degree "
					+ "WHERE courses.prerequisiteID = prerequisite.prerequisiteID "
					+ "AND courses.resourceID = resources.resourceID "
					+ "AND courses.degreeID = degree.degreeID");
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
	
	public ArrayList<String[]> getCoursesWithoutPrerequisites() {
		ResultSet rs; int ncol;
		ArrayList<String[]> courses = new ArrayList<>();
		pstmt = null;
		try {
			pstmt = con.prepareStatement("SELECT courseId, courseDesc, expectedCapacity, resourceID FROM courses WHERE prerequisiteID = '0'");
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
	
	public ArrayList<String[]> getLabNameAndCapacity() {
		ResultSet rs; int ncol;
		ArrayList<String[]> labs = new ArrayList<>();
		pstmt = null;
		try {
			pstmt = con.prepareStatement("SELECT labName, labCapacity, resourceID, labID FROM labs");
			rs = pstmt.executeQuery();
			ncol = rs.getMetaData().getColumnCount();
			while (rs.next()) {
				String[] row = new String[ncol];
				
				for(int icol = 1; icol<=ncol; icol++){
					row[icol-1] = rs.getObject(icol).toString();
				}
				labs.add(row);
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
		return labs;
	}
	
	public ArrayList<String[]> getClassTimes() {
		ResultSet rs; int ncol;
		ArrayList<String[]> times = new ArrayList<>();
		pstmt = null;
		try {
			pstmt = con.prepareStatement("SELECT timeID, times FROM times");
			rs = pstmt.executeQuery();
			ncol = rs.getMetaData().getColumnCount();
			while (rs.next()) {
				String[] row = new String[ncol];
				
				for(int icol = 1; icol<=ncol; icol++){
					row[icol-1] = rs.getObject(icol).toString();
				}
				times.add(row);
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
		return times;
	}
	
	public ArrayList<String[]> getSchedule(String courseID, String labID) {
		ResultSet rs; int ncol;
		ArrayList<String[]> schedule = new ArrayList<>();
		pstmt = null;
		try {
			pstmt = con.prepareStatement("SELECT timeID, dayID FROM schedule where courseID=? AND labID=?");
			pstmt.setString(1, courseID);
			pstmt.setString(2, labID);
			rs = pstmt.executeQuery();
			ncol = rs.getMetaData().getColumnCount();
			while (rs.next()) {
				String[] row = new String[ncol];
				
				for(int icol = 1; icol<=ncol; icol++){
					row[icol-1] = rs.getObject(icol).toString();
				}
				schedule.add(row);
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
		return schedule;
	}
	
	public ArrayList<String[]> getAllPossibleDaysAndTimes() {
		ResultSet rs; int ncol;
		ArrayList<String[]> allDaysTimes = new ArrayList<>();
		pstmt = null;
		try {
			pstmt = con.prepareStatement("SELECT days.dayID, times.timeID FROM days, times");
			rs = pstmt.executeQuery();
			ncol = rs.getMetaData().getColumnCount();
			while (rs.next()) {
				String[] row = new String[ncol];
				
				for(int icol = 1; icol<=ncol; icol++){
					row[icol-1] = rs.getObject(icol).toString();
				}
				allDaysTimes.add(row);
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
		return allDaysTimes;
	}
	
	public void SetScheduledCourse(String courseID, String labID, String timeID, String dayID) {
		int rs;
		pstmt = null;
		try {
			pstmt = con.prepareStatement("INSERT INTO schedule(courseID, labID, timeID, dayID) values(?,?,?,?)");
			pstmt.setString(1, courseID);
			pstmt.setString(2, labID);
			pstmt.setString(3, timeID);
			pstmt.setString(4, dayID);
			rs = pstmt.executeUpdate();
			
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



}

package pro.lab.mainframe;

import java.awt.Dimension;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Database {
	Connection con;
	Statement stmt;
	PreparedStatement pstmt;

	// -----------------------Connection strings
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
			JOptionPane.showMessageDialog(null, scrollpane, "Connection String Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	// ------------------------------------------------------------------------------------------------------------

	public ArrayList<String[]> getAllCourses() {
		ResultSet rs;
		int ncol;
		ArrayList<String[]> courses = new ArrayList<>();
		pstmt = null;
		try {
			pstmt = con.prepareStatement("SELECT courseId, courseDesc, expectedCapacity, courses.program, "
					+ "prerequisite.prerequisiteDesc, resources.resourceDesc, degree.degreeID "
					+ "FROM courses,prerequisite,resources,degree "
					+ "WHERE courses.prerequisiteID = prerequisite.prerequisiteID "
					+ "AND courses.resourceID = resources.resourceID " + "AND courses.degreeID = degree.degreeID");
			rs = pstmt.executeQuery();
			ncol = rs.getMetaData().getColumnCount();
			while (rs.next()) {
				String[] row = new String[ncol];

				for (int icol = 1; icol <= ncol; icol++) {
					row[icol - 1] = rs.getObject(icol).toString();
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
			JOptionPane.showMessageDialog(null, scrollpane, "Get all Courses Error", JOptionPane.ERROR_MESSAGE);
		}
		return courses;
	}

	// ------------------------------------------------------------------------------------------------------

	public ArrayList<String[]> getCoursesWithoutPrerequisites() {
		ResultSet rs;
		int ncol;
		ArrayList<String[]> courses = new ArrayList<>();
		pstmt = null;
		try {
			pstmt = con.prepareStatement(
					"SELECT courseId, courseDesc, expectedCapacity, resourceID FROM courses WHERE prerequisiteID = '0'");
			rs = pstmt.executeQuery();
			ncol = rs.getMetaData().getColumnCount();
			while (rs.next()) {
				String[] row = new String[ncol];

				for (int icol = 1; icol <= ncol; icol++) {
					row[icol - 1] = rs.getObject(icol).toString();
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
			JOptionPane.showMessageDialog(null, scrollpane, "Get Courses Without Prerequisites Error",
					JOptionPane.ERROR_MESSAGE);
		}
		return courses;
	}

	// ----------------------------------------------------------------------------------------------------

	public ArrayList<String[]> getLabNameAndCapacity() {
		ResultSet rs;
		int ncol;
		ArrayList<String[]> labs = new ArrayList<>();
		pstmt = null;
		try {
			pstmt = con.prepareStatement("SELECT labName, labCapacity, resourceID, labID FROM labs");
			rs = pstmt.executeQuery();
			ncol = rs.getMetaData().getColumnCount();
			while (rs.next()) {
				String[] row = new String[ncol];

				for (int icol = 1; icol <= ncol; icol++) {
					row[icol - 1] = rs.getObject(icol).toString();
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
			JOptionPane.showMessageDialog(null, scrollpane, "Get Lab Name and Capacity Error",
					JOptionPane.ERROR_MESSAGE);
		}
		return labs;
	}

	// ---------------------------------------------------------------------------------------------------------------

	public ArrayList<String[]> getClassTimes() {
		ResultSet rs;
		int ncol;
		ArrayList<String[]> times = new ArrayList<>();
		pstmt = null;
		try {
			pstmt = con.prepareStatement("SELECT timeID, times FROM times");
			rs = pstmt.executeQuery();
			ncol = rs.getMetaData().getColumnCount();
			while (rs.next()) {
				String[] row = new String[ncol];

				for (int icol = 1; icol <= ncol; icol++) {
					row[icol - 1] = rs.getObject(icol).toString();
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
			JOptionPane.showMessageDialog(null, scrollpane, "Get Class Times Error", JOptionPane.ERROR_MESSAGE);
		}
		return times;
	}

	// ---------------------------------------------------------------------------------------------------

	public ArrayList<String[]> getSchedule(String courseID, String labID) {
		ResultSet rs;
		int ncol;
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

				for (int icol = 1; icol <= ncol; icol++) {
					row[icol - 1] = rs.getObject(icol).toString();
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
			JOptionPane.showMessageDialog(null, scrollpane, "Get Schedule Error", JOptionPane.ERROR_MESSAGE);
		}
		return schedule;
	}

	// ---------------------------------------------------------------------------------------------------------

	public ArrayList<String[]> getAllPossibleDaysAndTimes() {
		ResultSet rs;
		int ncol;
		ArrayList<String[]> allDaysTimes = new ArrayList<>();
		pstmt = null;
		try {
			pstmt = con.prepareStatement("SELECT days.dayID, times.timeID FROM days, times");
			rs = pstmt.executeQuery();
			ncol = rs.getMetaData().getColumnCount();
			while (rs.next()) {
				String[] row = new String[ncol];

				for (int icol = 1; icol <= ncol; icol++) {
					row[icol - 1] = rs.getObject(icol).toString();
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
			JOptionPane.showMessageDialog(null, scrollpane, "Get Days and Times Error", JOptionPane.ERROR_MESSAGE);
		}
		return allDaysTimes;
	}

	// --------------------------------------------------------------------------------------------------------------

	public void CreateScheduledCourse(String courseID, String labID, String timeID, String dayID) {

		pstmt = null;
		try {
			pstmt = con.prepareStatement("TRUNCATE TABLE schedule");
			pstmt.executeUpdate();
			pstmt = con.prepareStatement("INSERT INTO schedule(courseID, labID, timeID, dayID) values(?,?,?,?)");
			pstmt.setString(1, courseID);
			pstmt.setString(2, labID);
			pstmt.setString(3, timeID);
			pstmt.setString(4, dayID);
			pstmt.executeUpdate();

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
			JOptionPane.showMessageDialog(null, scrollpane, "Create Scheduled Courses Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	// --------------------------------------------------------------------------------------------------------------

	public boolean CreateCourse(String courseID, String courseDesc, int capacity, String program, String prerequisite,
			String resource, String degree) {
		boolean success = false;
		pstmt = null;
		try {
			pstmt = con.prepareStatement("INSERT INTO courses(courseID, courseDesc, expectedCapacity, program,"
					+ "prerequisiteID,resourceID,degreeID) values(?,?,?,?,?,?,?)");
			pstmt.setString(1, courseID);
			pstmt.setString(2, courseDesc);
			pstmt.setInt(3, capacity);
			pstmt.setString(4, program);
			pstmt.setString(5, prerequisite);
			pstmt.setString(6, resource);
			pstmt.setString(7, degree);
			pstmt.executeUpdate();
			success = true;
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
			JOptionPane.showMessageDialog(null, scrollpane, "Create Course Error", JOptionPane.ERROR_MESSAGE);
		}
		return success;
	}

	// -------------------------------------------------------------------------------------------------------------

	public ArrayList<String[]> getCoursePrerequisites() {
		ResultSet rs;
		int ncol;
		ArrayList<String[]> prerequisites = new ArrayList<>();
		pstmt = null;
		try {
			pstmt = con.prepareStatement("select prerequisiteID, prerequisiteDesc from prerequisite");
			rs = pstmt.executeQuery();
			ncol = rs.getMetaData().getColumnCount();
			while (rs.next()) {
				String[] row = new String[ncol];

				for (int icol = 1; icol <= ncol; icol++) {
					row[icol - 1] = rs.getObject(icol).toString();
				}
				prerequisites.add(row);
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
			JOptionPane.showMessageDialog(null, scrollpane, "Get Course Prerequisites Error",
					JOptionPane.ERROR_MESSAGE);
		}
		return prerequisites;
	}

	// -------------------------------------------------------------------------------------------------------------

	public ArrayList<String[]> getCourseResources() {
		ResultSet rs;
		int ncol;
		ArrayList<String[]> resources = new ArrayList<>();
		pstmt = null;
		try {
			pstmt = con.prepareStatement("select resourceID, resourcedesc from resources");
			rs = pstmt.executeQuery();
			ncol = rs.getMetaData().getColumnCount();
			while (rs.next()) {
				String[] row = new String[ncol];

				for (int icol = 1; icol <= ncol; icol++) {
					row[icol - 1] = rs.getObject(icol).toString();
				}
				resources.add(row);
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
			JOptionPane.showMessageDialog(null, scrollpane, "Get Course Resources Error", JOptionPane.ERROR_MESSAGE);
		}
		return resources;
	}

	// --------------------------------------------------------------------------------------------------------------

	public boolean CreateResources(String resourceID, String resourceDesc) {
		boolean success = false;
		pstmt = null;
		try {
			pstmt = con.prepareStatement("INSERT INTO resources(resourceID, resourceDesc) values(?,?)");
			pstmt.setString(1, resourceID);
			pstmt.setString(2, resourceDesc);
			pstmt.executeUpdate();
			success = true;
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
			JOptionPane.showMessageDialog(null, scrollpane, "Create Resources Error", JOptionPane.ERROR_MESSAGE);
		}
		return success;
	}

	// --------------------------------------------------------------------------------------------------------------

	public boolean CreatePrerequisites(String prerequisiteID, String prerequisiteDesc) {
		boolean success = false;
		pstmt = null;
		try {
			pstmt = con.prepareStatement("INSERT INTO prerequisite(prerequisiteID, prerequisiteDesc) values(?,?)");
			pstmt.setString(1, prerequisiteID);
			pstmt.setString(2, prerequisiteDesc);
			pstmt.executeUpdate();
			success = true;
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
			JOptionPane.showMessageDialog(null, scrollpane, "Create Prerequisite Error", JOptionPane.ERROR_MESSAGE);
		}
		return success;
	}

	// ---------------------------------------------------------------------------------------------------

	public ArrayList<String[]> SearchCourses(String searchFilter, String searchText) {
		ResultSet rs;
		int ncol;
		ArrayList<String[]> result = new ArrayList<>();
		pstmt = null;
		try {
			pstmt = con.prepareStatement(
					"SELECT courseId, courseDesc, expectedCapacity, courses.program, prerequisite.prerequisiteDesc, "
							+ "resources.resourceDesc, degree.degreeID FROM courses,prerequisite,resources,degree "
							+ "WHERE courses.prerequisiteID = prerequisite.prerequisiteID "
							+ "AND courses.resourceID = resources.resourceID "
							+ "AND courses.degreeID = degree.degreeID AND courseID LIKE ?");
			//pstmt.setString(1, searchFilter);
			pstmt.setString(1, "%" + searchText + "%");
			rs = pstmt.executeQuery();
			ncol = rs.getMetaData().getColumnCount();
			while (rs.next()) {
				String[] row = new String[ncol];

				for (int icol = 1; icol <= ncol; icol++) {
					row[icol - 1] = rs.getObject(icol).toString();
				}
				result.add(row);
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
			JOptionPane.showMessageDialog(null, scrollpane, "Search Courses Error", JOptionPane.ERROR_MESSAGE);
		}
		return result;
	}

	// --------------------------------------------------------------------------------------------------------------

	public boolean CreateHardwareAsset(String id,String description, String labID,int quantity) {
		boolean success = false;
		pstmt = null;
		try {
			pstmt = con.prepareStatement("INSERT INTO hardwareassets(assetID, description, status, labID, quantity) values(?,?,?,?,?)");
			pstmt.setString(1, id);
			pstmt.setString(2, description);
			pstmt.setString(3, "OKAY");
			pstmt.setString(4, labID);
			pstmt.setInt(5, quantity);
			pstmt.executeUpdate();
			success = true;
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
			JOptionPane.showMessageDialog(null, scrollpane, "Create Hardware Asset Error", JOptionPane.ERROR_MESSAGE);
		}
		return success;
	}

	// --------------------------------------------------------------------------------------------------------------

	public boolean CreateSoftwareAsset(String id, String description, String labID, String licenseType) {
		boolean success = false;
		pstmt = null;
		try {
			pstmt = con.prepareStatement("INSERT INTO softwareassets(assetID, description, labID, licenseType) values(?,?,?,?)");
			pstmt.setString(1, id);
			pstmt.setString(2, description);
			pstmt.setString(3, labID);
			pstmt.setString(4, licenseType);
			pstmt.executeUpdate();
			success = true;

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
			JOptionPane.showMessageDialog(null, scrollpane, "Create Resources Error", JOptionPane.ERROR_MESSAGE);
		}
		return success;
	}

	// -------------------------------------------------------------------------------------------------------------

	public ArrayList<String[]> getLabNames() {
		ResultSet rs;
		int ncol;
		ArrayList<String[]> labs = new ArrayList<>();
		pstmt = null;
		try {
			pstmt = con.prepareStatement("select labId, labName from labs");
			rs = pstmt.executeQuery();
			ncol = rs.getMetaData().getColumnCount();
			while (rs.next()) {
				String[] row = new String[ncol];

				for (int icol = 1; icol <= ncol; icol++) {
					row[icol - 1] = rs.getObject(icol).toString();
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
			JOptionPane.showMessageDialog(null, scrollpane, "Get Lab Names Error", JOptionPane.ERROR_MESSAGE);
		}
		return labs;
	}
	
	// ----------------------------------------------------------------------------------------------------

		public ArrayList<String[]> getSoftwareAssets() {
			ResultSet rs;
			int ncol;
			ArrayList<String[]> labs = new ArrayList<>();
			pstmt = null;
			try {
				pstmt = con.prepareStatement("SELECT assetId, description FROM softwareassets");
				rs = pstmt.executeQuery();
				ncol = rs.getMetaData().getColumnCount();
				while (rs.next()) {
					String[] row = new String[ncol];

					for (int icol = 1; icol <= ncol; icol++) {
						row[icol - 1] = rs.getObject(icol).toString();
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
				JOptionPane.showMessageDialog(null, scrollpane, "Get Software Assets Error",
						JOptionPane.ERROR_MESSAGE);
			}
			return labs;
		}


}

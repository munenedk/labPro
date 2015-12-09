package pro.lab.coursemgt;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import pro.lab.mainframe.Database;

class CourseController {
	Database db = new Database();

	ArrayList<String[]> loadCourses() {
		ArrayList<String[]> courses = new ArrayList<>();
		courses = db.getAllCourses();
		return courses;
	}

	ArrayList<String[]> loadCoursesWithoutPrerequisits() {
		ArrayList<String[]> courses = new ArrayList<>();
		courses = db.getCoursesWithoutPrerequisites();
		return courses;
	}

	ArrayList<String[]> loadLabNameAndCapacity() {
		ArrayList<String[]> labs = new ArrayList<>();
		labs = db.getLabNameAndCapacity();
		return labs;
	}

	ArrayList<String[]> loadSchedule(String courseID, String labID) {
		ArrayList<String[]> schedule = new ArrayList<>();
		schedule = db.getSchedule(courseID, labID);
		return schedule;
	}

	ArrayList<String[]> loadAllPossibleDaysAndTimes() {
		ArrayList<String[]> allDaysTimes = new ArrayList<>();
		allDaysTimes = db.getAllPossibleDaysAndTimes();
		return allDaysTimes;
	}

	ArrayList<String[]> loadCoursePrerequisites() {
		ArrayList<String[]> prerequisites = new ArrayList<>();
		prerequisites = db.getCoursePrerequisites();
		return prerequisites;
	}

	ArrayList<String[]> loadCourseResources() {
		ArrayList<String[]> resources = new ArrayList<>();
		resources = db.getCourseResources();
		return resources;
	}

	void SaveScheduledCourse(String courseID, String labID, String timeID, String dayID) {
		db.CreateScheduledCourse(courseID, labID, timeID, dayID);
	}

	void SaveResources(String resourceID, String resourceDesc) {
		if (db.CreateResources(resourceID, resourceDesc)) {
			JOptionPane.showMessageDialog(null, "Resource created successfully.", "Create Resource",
					JOptionPane.INFORMATION_MESSAGE);
		}

	}

	void SavePrerequisites(String prerequisiteID, String prerequisiteDesc) {
		if (db.CreatePrerequisites(prerequisiteID, prerequisiteDesc)) {
			JOptionPane.showMessageDialog(null, "Prerequisite created successfully.", "Create Prerequisite",
					JOptionPane.INFORMATION_MESSAGE);
		}

	}

	void SaveCourse(String courseID, String courseDesc, int capacity, String program, String prerequisite,
			String resource, String degree) {

		if (courseID.trim().length() == 0) {
			JOptionPane.showMessageDialog(null, "Course Code is required");
		} else if (courseDesc.trim().length() == 0) {
			JOptionPane.showMessageDialog(null, "Course Name is required");
		} else if (capacity == 0) {
			JOptionPane.showMessageDialog(null, "Enter a valid expected capacity");
		} else if (prerequisite.trim().length() == 0) {
			JOptionPane.showMessageDialog(null, "Please select a prerequisite");
		} else if (resource.trim().length() == 0) {
			JOptionPane.showMessageDialog(null, "Please select a resource");
		} else {
			if (db.CreateCourse(courseID.trim().toUpperCase(), courseDesc.trim(), capacity, program.trim(),
					prerequisite.trim(), resource.trim(), degree.trim())) {
				JOptionPane.showMessageDialog(null, "Course created successfully.", "Create Course",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	ArrayList<String[]> SearchCourse(String searchFilter, String searchText) {
		ArrayList<String[]> search = new ArrayList<String[]>();
		String filter = "";
		if (searchFilter.trim().equalsIgnoreCase("Course Code")) {
			filter = "courseID";		
		} else if (searchFilter.trim().equalsIgnoreCase("Course Name")) {
			filter = "courseDesc";
		} else if (searchFilter.trim().equalsIgnoreCase("Expected Capacity")) {
			filter = "expectedCapacity";
		} else if (searchFilter.trim().equalsIgnoreCase("Program")) {
			filter = "program";
		} else if (searchFilter.trim().equalsIgnoreCase("Prerequisite")) {
			filter = "prerequisiteDesc";
		} else if (searchFilter.trim().equalsIgnoreCase("Resources")) {
			filter = "resourceDesc";
		} else if (searchFilter.trim().equalsIgnoreCase("Degree")) {
			filter = "degreeDesc";
		}
		search = db.SearchCourses(filter, searchText);
		return search;
	}

}

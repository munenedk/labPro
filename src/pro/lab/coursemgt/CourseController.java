package pro.lab.coursemgt;

import java.util.ArrayList;

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
		schedule = db.getSchedule(courseID,labID);
		return schedule;
	}
	
	ArrayList<String[]> loadAllPossibleDaysAndTimes() {
		ArrayList<String[]> allDaysTimes = new ArrayList<>();
		allDaysTimes = db.getAllPossibleDaysAndTimes();
		return allDaysTimes;
	}
	
	void SaveScheduledCourse(String courseID, String labID, String timeID, String dayID) {
		db.SetScheduledCourse(courseID, labID, timeID, dayID);
	}
	
}

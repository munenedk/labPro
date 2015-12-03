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
}

package pro.lab.coursemgt;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Course extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ImageIcon createIcon, readIcon, updateIcon, deleteIcon, scheduleIcon;

	/**
	 * Create the panel.
	 */
	public Course() {
		setLayout(null);

		JTabbedPane courseTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		courseTabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		courseTabbedPane.setBounds(3, 3, 860, 545);
		add(courseTabbedPane);

		CreateCourse createCoursePanel = new CreateCourse();
		createIcon = new ImageIcon(Course.class.getResource("/pro/lab/icons/add-icon.png"));
		courseTabbedPane.addTab("Create Course ", createIcon, createCoursePanel, null);

		ReadCourse readCoursePanel = new ReadCourse();
		readIcon = new ImageIcon(Course.class.getResource("/pro/lab/icons/read-icon.png"));
		courseTabbedPane.addTab("View Courses ", readIcon, readCoursePanel, null);

		UpdateCourse updateCoursePanel = new UpdateCourse();
		updateIcon = new ImageIcon(Course.class.getResource("/pro/lab/icons/edit-icon.png"));
		courseTabbedPane.addTab("Update Courses ", updateIcon, updateCoursePanel, null);

		DeleteCourse deleteCoursePanel = new DeleteCourse();
		deleteIcon = new ImageIcon(Course.class.getResource("/pro/lab/icons/delete-icon.png"));
		courseTabbedPane.addTab("Delete Course ", deleteIcon, deleteCoursePanel, null);

		ScheduleCourse courseSchedulePanel = new ScheduleCourse();
		scheduleIcon = new ImageIcon(Course.class.getResource("/pro/lab/icons/schedule-icon.png"));
		courseTabbedPane.addTab("Generate Schedule ", scheduleIcon, courseSchedulePanel, null);

	}

}

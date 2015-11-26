package pro.lab.mainframe;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

import pro.lab.assetmgt.Asset;
import pro.lab.coursemgt.Course;
import pro.lab.labmgt.Lab;
import pro.lab.login.Login;
import pro.lab.usermgt.User;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JTabbedPane tabbedPane;
	ImageIcon loginIcon, assetIcon, labIcon, courseIcon, userIcon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		//Set the look and feel of the app
		try {
			for (UIManager.LookAndFeelInfo info : UIManager
					.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(MainFrame.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(MainFrame.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(MainFrame.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(MainFrame.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		}
		
		//Launch the application
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		//Main Frame settings
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1100,670);
		setResizable(false);
		setTitle("Lab Pro V 1.0");
		getContentPane().setLayout(null);
		
		//Tabbed Pane settings
		tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setBounds(6, 6, 1075, 629);
		getContentPane().add(tabbedPane);
		
		//Login tab - index 0
		Login login = new Login();
		loginIcon = new ImageIcon(
				MainFrame.class
				.getResource("/pro/lab/icons/user-login.png"));
		tabbedPane.addTab(null, loginIcon, login, "Application Login");
		
		//Asset Management tab - index 1
		Asset asset = new Asset();
		assetIcon = new ImageIcon(
				MainFrame.class
				.getResource("/pro/lab/icons/checklist.png"));
		tabbedPane.addTab(null, assetIcon, asset, "Asset Management");
		
		//Course Management tab - index 2
		Course course = new Course();
		courseIcon = new ImageIcon(
				MainFrame.class
				.getResource("/pro/lab/icons/course-icon.png"));
		tabbedPane.addTab(null, courseIcon, course, "Course Management");
		
		//Lab Management tab - index 3
		Lab lab = new Lab();
		labIcon = new ImageIcon(
				MainFrame.class
				.getResource("/pro/lab/icons/computer-icon.png"));
		tabbedPane.addTab(null, labIcon, lab, "Lab Management");
		
		//User Management tab - index 4
		User user = new User();
		userIcon = new ImageIcon(
				MainFrame.class
				.getResource("/pro/lab/icons/user-mgt.png"));
		tabbedPane.addTab(null, userIcon, user, "User Management");
		

	}
}

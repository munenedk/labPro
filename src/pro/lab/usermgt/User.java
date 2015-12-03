package pro.lab.usermgt;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class User extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ImageIcon createIcon, readIcon, updateIcon, deleteIcon;

	/**
	 * Create the panel.
	 */
	public User() {
		setLayout(null);

		JTabbedPane userTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		userTabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		userTabbedPane.setBounds(3, 3, 860, 545);
		add(userTabbedPane);

		CreateUser createUserPanel = new CreateUser();
		createIcon = new ImageIcon(User.class.getResource("/pro/lab/icons/add-icon.png"));
		userTabbedPane.addTab("Create User ", createIcon, createUserPanel, null);

		ReadUser readUserPanel = new ReadUser();
		readIcon = new ImageIcon(User.class.getResource("/pro/lab/icons/read-icon.png"));
		userTabbedPane.addTab("View Users ", readIcon, readUserPanel, null);

		UpdateUser updateUserPanel = new UpdateUser();
		updateIcon = new ImageIcon(User.class.getResource("/pro/lab/icons/edit-icon.png"));
		userTabbedPane.addTab("Update User ", updateIcon, updateUserPanel, null);

		DeleteUser deleteUserPanel = new DeleteUser();
		deleteIcon = new ImageIcon(User.class.getResource("/pro/lab/icons/delete-icon.png"));
		userTabbedPane.addTab("Delete User ", deleteIcon, deleteUserPanel, null);

	}

}

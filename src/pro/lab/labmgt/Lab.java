package pro.lab.labmgt;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Lab extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ImageIcon createIcon, readIcon, updateIcon, deleteIcon;

	/**
	 * Create the panel.
	 */
	public Lab() {
		setLayout(null);

		JTabbedPane labTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		labTabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		labTabbedPane.setBounds(3, 3, 860, 545);
		add(labTabbedPane);

		ReadLab readLabPanel = new ReadLab();
		readIcon = new ImageIcon(Lab.class.getResource("/pro/lab/icons/read-icon.png"));
		labTabbedPane.addTab("View Labs ", readIcon, readLabPanel, null); 
		
		UpdateLab updateLabPanel = new UpdateLab();
		updateIcon = new ImageIcon(Lab.class.getResource("/pro/lab/icons/edit-icon.png"));
		labTabbedPane.addTab("Update Labs ", updateIcon, updateLabPanel, null);
		
		CreateLab createLabPanel = new CreateLab();
		createIcon = new ImageIcon(Lab.class.getResource("/pro/lab/icons/add-icon.png"));
		labTabbedPane.addTab("Create Lab ", createIcon, createLabPanel, null);

		DeleteLab deleteLabPanel = new DeleteLab();
		deleteIcon = new ImageIcon(Lab.class.getResource("/pro/lab/icons/delete-icon.png"));
		labTabbedPane.addTab("Delete Lab ", deleteIcon, deleteLabPanel, null);
	}

}

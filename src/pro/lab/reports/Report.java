package pro.lab.reports;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Report extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Report() {
		setLayout(null);

		JTabbedPane reportTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		reportTabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		reportTabbedPane.setBounds(3, 3, 860, 545);
		add(reportTabbedPane);

	}

}

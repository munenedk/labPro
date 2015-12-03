package pro.lab.assetmgt;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Asset extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ImageIcon createIcon, readIcon, updateIcon, deleteIcon;

	/**
	 * Create the panel.
	 */
	public Asset() {
		setLayout(null);

		JTabbedPane assetTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		assetTabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		assetTabbedPane.setBounds(3, 3, 860, 545);
		add(assetTabbedPane);

		CreateAsset createAssetPanel = new CreateAsset();
		createIcon = new ImageIcon(Asset.class.getResource("/pro/lab/icons/add-icon.png"));
		assetTabbedPane.addTab("Create Asset ", createIcon, createAssetPanel, null);
		createAssetPanel.setLayout(null);

		ReadAsset readAssetPanel = new ReadAsset();
		readIcon = new ImageIcon(Asset.class.getResource("/pro/lab/icons/read-icon.png"));
		assetTabbedPane.addTab("View Assets ", readIcon, readAssetPanel, null);

		UpdateAsset updateAssetPanel = new UpdateAsset();
		updateIcon = new ImageIcon(Asset.class.getResource("/pro/lab/icons/edit-icon.png"));
		assetTabbedPane.addTab("Update Assets ", updateIcon, updateAssetPanel, null);

		DeleteAsset deleteAssetPanel = new DeleteAsset();
		deleteIcon = new ImageIcon(Asset.class.getResource("/pro/lab/icons/delete-icon.png"));
		assetTabbedPane.addTab("Delete Asset ", deleteIcon, deleteAssetPanel, null);

	}
}

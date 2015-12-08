package pro.lab.assetmgt;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CreateAsset extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtHWAssetIdentifier;
	private JTextField txtHWDescription;
	private JTextField txtSWAssetIdentifier;
	private JTextField txtSWAssetGroup;
	private JTextField txtHWAssetQuantity;
	private JTextField txtLicenseType;


	/**
	 * Create the panel.
	 */
	public CreateAsset() {
		setLayout(null);

		JSeparator coursePrereqSeparator = new JSeparator();
		coursePrereqSeparator.setOrientation(SwingConstants.VERTICAL);
		coursePrereqSeparator.setBounds(418, 6, 11, 417);
		add(coursePrereqSeparator);

		JLabel lblHardwareAssets = new JLabel("Hardware Assets");
		lblHardwareAssets.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblHardwareAssets.setBounds(214, 17, 102, 16);
		add(lblHardwareAssets);

		JLabel lblHWAssetIdentifier = new JLabel("Asset Identifier");
		lblHWAssetIdentifier.setBounds(25, 57, 132, 16);
		add(lblHWAssetIdentifier);

		txtHWAssetIdentifier = new JTextField();
		txtHWAssetIdentifier.setBounds(169, 51, 237, 28);
		add(txtHWAssetIdentifier);
		txtHWAssetIdentifier.setColumns(10);

		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(25, 103, 132, 16);
		add(lblDescription);

		txtHWDescription = new JTextField();
		txtHWDescription.setBounds(169, 97, 237, 28);
		add(txtHWDescription);
		txtHWDescription.setColumns(10);

		JButton btnSaveHWAsset = new JButton("Save HW Asset");
		btnSaveHWAsset.setBounds(169, 233, 132, 28);
		add(btnSaveHWAsset);

		JLabel lblSoftwareAssets = new JLabel("Software Assets");
		lblSoftwareAssets.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblSoftwareAssets.setBounds(640, 17, 102, 16);
		add(lblSoftwareAssets);

		JLabel lblSWAssetIdentifier = new JLabel("Asset Identifier");
		lblSWAssetIdentifier.setBounds(433, 57, 132, 16);
		add(lblSWAssetIdentifier);

		txtSWAssetIdentifier = new JTextField();
		txtSWAssetIdentifier.setBounds(577, 49, 237, 28);
		add(txtSWAssetIdentifier);
		txtSWAssetIdentifier.setColumns(10);

		JLabel lblAssetGroup = new JLabel("Asset Description");
		lblAssetGroup.setBounds(433, 103, 132, 16);
		add(lblAssetGroup);

		txtSWAssetGroup = new JTextField();
		txtSWAssetGroup.setBounds(577, 88, 237, 28);
		add(txtSWAssetGroup);
		txtSWAssetGroup.setColumns(10);

		JButton btnSaveSWAsset = new JButton("Save SW Asset");
		btnSaveSWAsset.setBounds(640, 215, 120, 28);
		add(btnSaveSWAsset);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(25, 146, 55, 16);
		add(lblQuantity);
		
		txtHWAssetQuantity = new JTextField();
		txtHWAssetQuantity.setBounds(169, 140, 237, 28);
		add(txtHWAssetQuantity);
		txtHWAssetQuantity.setColumns(10);
		
		JLabel lblLicenseType = new JLabel("License Type");
		lblLicenseType.setBounds(433, 140, 132, 16);
		add(lblLicenseType);
		
		txtLicenseType = new JTextField();
		txtLicenseType.setBounds(579, 134, 235, 28);
		add(txtLicenseType);
		txtLicenseType.setColumns(10);

	}
}

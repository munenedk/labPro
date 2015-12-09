package pro.lab.assetmgt;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
	private JComboBox<String> comboBoxGetHAssetLab;
	private JComboBox<String> comboBoxGetSAssetLab;

	AssetController controller = new AssetController();
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
		btnSaveHWAsset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.SaveHWAssets(
						txtHWAssetIdentifier.getText(), 
						txtHWDescription.getText(), 
						comboBoxGetHAssetLab.getSelectedItem().toString(),
						Integer.parseInt(txtHWAssetQuantity.getText()));
			}
		});
		btnSaveHWAsset.setBounds(184, 256, 132, 28);
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
		txtSWAssetGroup.setBounds(577, 97, 237, 28);
		add(txtSWAssetGroup);
		txtSWAssetGroup.setColumns(10);

		JButton btnSaveSWAsset = new JButton("Save SW Asset");
		btnSaveSWAsset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.SaveSWAssets(txtSWAssetIdentifier.getText(), 
						txtSWAssetGroup.getText(),
						comboBoxGetSAssetLab.getSelectedItem().toString(), 
						txtLicenseType.getText());
			}
		});
		btnSaveSWAsset.setBounds(645, 256, 120, 28);
		add(btnSaveSWAsset);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(25, 146, 55, 16);
		add(lblQuantity);
		
		txtHWAssetQuantity = new JTextField();
		txtHWAssetQuantity.setBounds(169, 140, 237, 28);
		add(txtHWAssetQuantity);
		txtHWAssetQuantity.setColumns(10);
		
		JLabel lblLicenseType = new JLabel("License Type");
		lblLicenseType.setBounds(441, 146, 132, 16);
		add(lblLicenseType);
		
		txtLicenseType = new JTextField();
		txtLicenseType.setBounds(577, 140, 235, 28);
		add(txtLicenseType);
		txtLicenseType.setColumns(10);
		
		JLabel lblAddToLab = new JLabel("Add to lab");
		lblAddToLab.setBounds(25, 196, 55, 16);
		add(lblAddToLab);
		
		comboBoxGetHAssetLab = new JComboBox<String>();
		comboBoxGetHAssetLab.addMouseListener(new MouseAdapter() {
			@SuppressWarnings({ "unchecked", "rawtypes" })
			@Override
			public void mouseClicked(MouseEvent e) {
				ArrayList<String[]> labs = controller.loadLabNames();
				List<String> thelab = new ArrayList<String>();
				for (String[] lab : labs) {
					thelab.add(lab[0]);
				}
				comboBoxGetHAssetLab.setModel(new DefaultComboBoxModel(thelab.toArray()));
			}
		});
		comboBoxGetHAssetLab.setBounds(169, 190, 237, 28);
		add(comboBoxGetHAssetLab);
		
		JLabel labelAddtoSWlab = new JLabel("Add to lab");
		labelAddtoSWlab.setBounds(432, 196, 55, 16);
		add(labelAddtoSWlab);
		
		comboBoxGetSAssetLab = new JComboBox<String>();
		comboBoxGetSAssetLab.addMouseListener(new MouseAdapter() {
			@SuppressWarnings({ "rawtypes", "unchecked" })
			@Override
			public void mouseClicked(MouseEvent e) {
				ArrayList<String[]> labs = controller.loadLabNames();
				List<String> thelab = new ArrayList<String>();
				for (String[] lab : labs) {
					thelab.add(lab[0]);
				}
				comboBoxGetSAssetLab.setModel(new DefaultComboBoxModel(thelab.toArray()));
			}
		});
		comboBoxGetSAssetLab.setBounds(577, 190, 237, 28);
		add(comboBoxGetSAssetLab);

	}
}

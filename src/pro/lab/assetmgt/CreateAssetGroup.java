package pro.lab.assetmgt;

import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class CreateAssetGroup extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtHWAssetIdentifier;
	private JTextField txtHWDescription;
	private JTable tableAvailableSWAssets;
	AssetController controller = new AssetController();

	/**
	 * Create the panel.
	 */
	public CreateAssetGroup() {
		setLayout(null);

		JLabel lblHardwareAssets = new JLabel("Resource Group");
		lblHardwareAssets.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblHardwareAssets.setBounds(214, 17, 102, 16);
		add(lblHardwareAssets);

		JLabel lblHWAssetIdentifier = new JLabel("Resource ID");
		lblHWAssetIdentifier.setBounds(25, 57, 132, 16);
		add(lblHWAssetIdentifier);

		txtHWAssetIdentifier = new JTextField();
		txtHWAssetIdentifier.setBounds(169, 51, 244, 28);
		add(txtHWAssetIdentifier);
		txtHWAssetIdentifier.setColumns(10);

		JLabel lblDescription = new JLabel("Resource Description");
		lblDescription.setBounds(25, 103, 132, 16);
		add(lblDescription);

		txtHWDescription = new JTextField();
		txtHWDescription.setBounds(169, 97, 244, 28);
		add(txtHWDescription);
		txtHWDescription.setColumns(10);

		JButton btnSaveHWAsset = new JButton("Save Group");
		btnSaveHWAsset.setBounds(169, 233, 132, 28);
		add(btnSaveHWAsset);
		
		JLabel lblAvailableSoftwareAssets = new JLabel("Resource Group Details");
		lblAvailableSoftwareAssets.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblAvailableSoftwareAssets.setBounds(562, 17, 163, 16);
		add(lblAvailableSoftwareAssets);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(425, 29, 14, 427);
		add(separator);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(464, 46, 345, 288);
		add(scrollPane);
		
		tableAvailableSWAssets = new JTable();
		tableAvailableSWAssets.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Added Softwares"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(tableAvailableSWAssets);
		
		JLabel lblNewLabel = new JLabel("Available Softwares");
		lblNewLabel.setBounds(25, 156, 132, 16);
		add(lblNewLabel);
		
		JComboBox<String> comboBoxAvailableSoftwares = new JComboBox<String>();
		comboBoxAvailableSoftwares.addMouseListener(new MouseAdapter() {
			@SuppressWarnings({ "unchecked", "rawtypes" })
			@Override
			public void mouseClicked(MouseEvent e) {
				ArrayList<String[]> softs = controller.loadSoftwareAssets();;
				List<String> thesoft = new ArrayList<String>();
				for (String[] soft : softs) {
					thesoft.add(soft[0]);
				}
				comboBoxAvailableSoftwares.setModel(new DefaultComboBoxModel(thesoft.toArray()));
			}
		});
		comboBoxAvailableSoftwares.setBounds(169, 151, 170, 28);
		add(comboBoxAvailableSoftwares);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setBounds(349, 150, 64, 28);
		add(btnNewButton);

	}
}

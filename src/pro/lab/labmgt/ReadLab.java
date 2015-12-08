package pro.lab.labmgt;

import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReadLab extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable tableLabDetails;
	private JTextField txtSearch;
	private JTable tableHardwareAssets;
	private JTable tableSoftwareAssets;

	/**
	 * Create the panel.
	 */
	public ReadLab() {
		setLayout(null);
		
		JSeparator LabAssetsSeparator = new JSeparator();
		LabAssetsSeparator.setOrientation(SwingConstants.VERTICAL);
		LabAssetsSeparator.setBounds(425, 26, 9, 436);
		add(LabAssetsSeparator);
		
		JLabel lblLabDetails = new JLabel("Lab Details");
		lblLabDetails.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblLabDetails.setBounds(169, 18, 73, 16);
		add(lblLabDetails);
		
		JScrollPane scrollPaneLabDetails = new JScrollPane();
		scrollPaneLabDetails.setBounds(23, 50, 381, 171);
		add(scrollPaneLabDetails);
		
		tableLabDetails = new JTable();
		tableLabDetails.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Lab Name", "Lab Capacity", "Resources"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				true, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableLabDetails.getColumnModel().getColumn(1).setPreferredWidth(88);
		scrollPaneLabDetails.setViewportView(tableLabDetails);
		
		JLabel lblSearch = new JLabel("Search");
		lblSearch.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblSearch.setBounds(169, 266, 55, 16);
		add(lblSearch);
		
		JLabel lblSearchText = new JLabel("Search Text");
		lblSearchText.setBounds(28, 303, 82, 16);
		add(lblSearchText);
		
		txtSearch = new JTextField();
		txtSearch.setBounds(122, 297, 230, 28);
		add(txtSearch);
		txtSearch.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSearch.setBounds(28, 371, 90, 28);
		add(btnSearch);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setEnabled(false);
		btnEdit.setBounds(152, 371, 90, 28);
		add(btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setEnabled(false);
		btnDelete.setBounds(273, 371, 90, 28);
		add(btnDelete);
		
		JScrollPane scrollPaneHardwareAssets = new JScrollPane();
		scrollPaneHardwareAssets.setBounds(446, 52, 383, 171);
		add(scrollPaneHardwareAssets);
		
		tableHardwareAssets = new JTable();
		tableHardwareAssets.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Asset ID", "Description", "Status"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPaneHardwareAssets.setViewportView(tableHardwareAssets);
		
		JLabel lblHardwareAssets = new JLabel("Hardware Assets");
		lblHardwareAssets.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblHardwareAssets.setBounds(588, 18, 115, 16);
		add(lblHardwareAssets);
		
		JLabel lblSoftwareAssets = new JLabel("Software Assets");
		lblSoftwareAssets.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblSoftwareAssets.setBounds(588, 235, 115, 16);
		add(lblSoftwareAssets);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(461, 283, 369, 178);
		add(scrollPane);
		
		tableSoftwareAssets = new JTable();
		tableSoftwareAssets.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Asset ID", "Description", "License Type"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableSoftwareAssets.getColumnModel().getColumn(2).setPreferredWidth(99);
		scrollPane.setViewportView(tableSoftwareAssets);
		
	}
}

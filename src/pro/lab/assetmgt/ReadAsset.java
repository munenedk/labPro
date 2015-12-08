package pro.lab.assetmgt;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;

public class ReadAsset extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable tableHWAssets;
	private JTable tableSWAssets;

	/**
	 * Create the panel.
	 */
	public ReadAsset() {
		setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(450, 82, 11, 434);
		add(separator);
		
		JLabel lblHardwareAssets = new JLabel("Hardware Assets");
		lblHardwareAssets.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblHardwareAssets.setBounds(160, 69, 107, 16);
		add(lblHardwareAssets);
		
		JLabel lblSoftwareAssets = new JLabel("Software Assets");
		lblSoftwareAssets.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblSoftwareAssets.setBounds(619, 69, 101, 16);
		add(lblSoftwareAssets);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(48, 111, 376, 198);
		add(scrollPane);
		
		tableHWAssets = new JTable();
		tableHWAssets.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Asset ID", "Description", "Quantity"
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
		scrollPane.setViewportView(tableHWAssets);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(473, 111, 359, 198);
		add(scrollPane_1);
		
		tableSWAssets = new JTable();
		tableSWAssets.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Asset ID", "Description", "License Type","Asset Group"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				true, false, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableSWAssets.getColumnModel().getColumn(2).setPreferredWidth(101);
		tableSWAssets.getColumnModel().getColumn(3).setPreferredWidth(93);
		scrollPane_1.setViewportView(tableSWAssets);

	}
}

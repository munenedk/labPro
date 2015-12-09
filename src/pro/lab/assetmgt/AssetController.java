package pro.lab.assetmgt;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import pro.lab.mainframe.Database;

class AssetController {
	Database db = new Database();

	ArrayList<String[]> loadLabNames() {
		ArrayList<String[]> labs = new ArrayList<>();
		labs = db.getLabNames();
		return labs;
	}
	
	void SaveHWAssets(String id,String description, String labID,int quantity) {
		if (db.CreateHardwareAsset(id, description, labID,quantity)) {
			JOptionPane.showMessageDialog(null, "Hardware Asset created successfully.", "Create Asset",
					JOptionPane.INFORMATION_MESSAGE);
		}

	}
	
	void SaveSWAssets(String id, String description, String labID, String licenseType) {
		if (db.CreateSoftwareAsset(id, description, labID, licenseType)) {
			JOptionPane.showMessageDialog(null, "Software Asset created successfully.", "Create Asset",
					JOptionPane.INFORMATION_MESSAGE);
		}

	}
	
	ArrayList<String[]> loadSoftwareAssets() {
		ArrayList<String[]> softwares = new ArrayList<>();
		softwares = db.getSoftwareAssets();
		return softwares;
	}

}

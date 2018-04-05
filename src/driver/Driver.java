package driver;

import adapter.*;

public class Driver {
	public static void main(String[] args) {
		/////////////////////////////////////////
		// LOOKUP / CHANGE VARIABLES
		String modelName = "ford_focus_wgn_ztw_2010";
		String fileName = modelName + ".txt";
		String OptionSetName = "Color";
		String newName = "Paint";
		String Option = "Fort Knox Gold Clearcoat Metallic";
		String price = "50";

		/////////////////////////////////////////
		// CREATEAUTO
		CreateAuto a1 = new BuildAuto();
		a1.buildAuto(fileName);
		a1.printAuto(modelName);

		/////////////////////////////////////////
		// UPDATEAUTO
		UpdateAuto a2 = new BuildAuto();
		a2.updateOptionSetName(modelName, OptionSetName, newName);
		OptionSetName = newName;
		a2.updateOptionPrice(modelName, OptionSetName, Option, price);

		/////////////////////////////////////////
		// PRINT UPDATES
		a1.printAuto(modelName);
	}
}

package adapter;

import java.io.Serializable;

import debug.Debuggable;
import model.Automobile;
import util.FileIO;

public abstract class ProxyAutomobile implements Serializable, Debuggable {
	/////////////////////////////////////////
	// INSTANCE VARIABLES
	private static Automobile auto;
	private FileIO FIO = new FileIO();

	/////////////////////////////////////////
	// CONSTRUCTORS

	/////////////////////////////////////////
	// GETTERS / SETTERS

	/////////////////////////////////////////
	// METHODS

	/////////////////////////////////////////
	// CREATEAUTO INTERFACE
	public void buildAuto(String fileName) {
		if (DEBUG)
			System.out.println("Building " + fileName);
		auto = FIO.buildAutomobile(fileName);
	}

	public void printAuto(String modelName) {
		if (DEBUG)
			System.out.println("Printing");
		auto.print();
	}

	/////////////////////////////////////////
	// UPDATE AUTO INTERFACE
	public void updateOptionSetName(String modelName, String OptionSetName, String newName) {
		System.out.println("Updating OpSet name");

		if (DEBUG) {
			System.out.println("auto name: " + auto.getName());
			System.out.println("modelname: " + modelName);
			System.out.println("opset lngth" + auto.getOpset().length);
			System.out.println("opset name" + auto.getOptionSetName(0));
		}

		if (auto.getName().equalsIgnoreCase(modelName)) {
			for (int i = 0; i < auto.getOpset().length; i++) {
				if (auto.getOptionSetName(i).equalsIgnoreCase(OptionSetName)) {
					auto.setOptionSetName(newName, i);
					System.out.println("Update Successful");
				}
			}
		} else
			System.out.println("That model name doesn't exist");
	}

	public void updateOptionPrice(String modelName, String OptionSetName, String Option, String newPrice) {
		System.out.println("Updating Option Price");
		boolean success = false;

		if (auto.getName().equalsIgnoreCase(modelName)) {
			for (int i = 0; i < auto.getOpset().length; i++) {
				if (success == true)
					break;
				if (auto.getOptionSetName(i).equalsIgnoreCase(OptionSetName)) {
					for (int j = 0; j < auto.getOptionArray(i).length; j++) {
						if (auto.getOptionName(i, j).equalsIgnoreCase(Option)) {
							auto.setOptionPrice(i, j, newPrice);
							System.out.println("Update Successful");
							success = true;
							break;
						}
					}
				}
			}
		} else
			System.out.println("That model name deoesn't exist");
	}
}

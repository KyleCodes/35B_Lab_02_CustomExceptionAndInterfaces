package model;

import java.io.Serializable;

import debug.Debuggable;

public class Automobile implements Debuggable, Serializable {
	/////////////////////////////////////////
	// INSTANCE VARIABLES
	private String name;
	private int numOfProperties;
	private String basePrice;
	private OptionSet[] opset;

	/////////////////////////////////////////
	// CONSTRUCTORS
	public Automobile() {
	}

	public Automobile(String name, OptionSet[] opset, String basePrice) {
		if (DEBUG)
			System.out.println("Constructing Automobile");
		this.name = name;
		this.opset = opset;
		this.numOfProperties = this.opset.length;
		this.basePrice = basePrice;
	}

	/////////////////////////////////////////
	// GETTERS / SETTERS
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumOfProperties() {
		return numOfProperties;
	}

	public void setNumOfProperties(int numOfProperties) {
		this.numOfProperties = numOfProperties;
	}

	public OptionSet[] getOpset() {
		return opset;
	}

	public void setOpset(OptionSet[] opset) {
		this.opset = opset;
	}

	public String getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(String basePrice) {
		this.basePrice = basePrice;
	}

	public String getOptionSetName(int n) {
		return this.getOpset()[n].getChoiceType();
	}

	public void setOptionSetName(String newName, int i) {
		this.getOpset()[i].setChoiceType(newName);
	}

	public String getOptionName(int i, int j) {
		return this.getOpset()[i].getChoices()[j].getChoiceTitle();
	}

	public void setOptionName(String newName, int i, int j) {
		this.getOpset()[i].getChoices()[j].setChoiceTitle(newName);
	}

	public Option[] getOptionArray(int i) {
		return this.getOpset()[i].getChoices();
	}

	public String getOptionPrice(int i, int j) {
		return this.getOpset()[i].getChoices()[j].getPrice();
	}

	public void setOptionPrice(int i, int j, String newPrice) {
		this.getOpset()[i].getChoices()[j].setPrice(newPrice);
	}

	public OptionSet createOptionSet() {
		return new OptionSet();
	}

	/////////////////////////////////////////
	// METHODS
	public void addOpset() {
		// not writing until Collections can be used. For now changes will be made in
		// the .txt file
	}

	public void deleteOpset() {
		// not writing until Collections can be used.
	}

	public void addOption() {
		// not writing until Collections can be used.
	}

	public void deleteOption() {
		// not writing until Collections can be used.
	}

	public void print() {
		System.out.println("=========================================\n");
		System.out.println("\t" + this.name);
		System.out.println("");
		System.out.println("Base Price: $" + this.basePrice);
		System.out.println("Options   :  " + this.numOfProperties);
		System.out.println("");
		for (int i = 0; i < numOfProperties; i++)
			this.opset[i].print();
	}

}

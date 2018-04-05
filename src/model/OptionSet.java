package model;

import java.io.Serializable;

import debug.Debuggable;

public class OptionSet implements Debuggable, Serializable {
	/////////////////////////////////////////
	// INSTANCE VARIABLES
	private int numOfOptions;
	private String OptionName;
	private Option[] options;
	private Option opt = new Option();

	/////////////////////////////////////////
	// CONSTRUCTORS
	protected OptionSet() {
		if (DEBUG)
			System.out.println("Constructing default OptionSet");
	}

	protected OptionSet(String choiceType) {
		if (DEBUG)
			System.out.println("Constructing OptionSet - name only");
		this.OptionName = choiceType;
		for (int i = 0; i < options.length; i++) {
			options[i] = new Option();
		}
	}

	protected OptionSet(String choiceType, Option[] options) {
		if (DEBUG)
			System.out.println("Constructing OptionSet");
		this.OptionName = choiceType;
		this.options = options;
		this.numOfOptions = this.options.length;
	}

	/////////////////////////////////////////
	// GETTERS / SETTERS
	protected int getNumOfOptions() {
		return numOfOptions;
	}

	protected void setNumOfOptions(int numOfOptions) {
		this.numOfOptions = numOfOptions;
	}

	protected Option[] getChoices() {
		return options;
	}

	protected void setChoices(Option[] options) {
		this.options = options;
	}

	protected String getChoiceType() {
		return OptionName;
	}

	public void setChoiceType(String choiceType) {
		this.OptionName = choiceType;
	}

	protected Option getOpt() {
		return opt;
	}

	protected void setOpt(Option opt) {
		this.opt = opt;
	}

	/////////////////////////////////////////
	// METHODS
	protected void buildInner() {
		if (DEBUG)
			System.out.println("Creating an Option inside " + OptionName);
		this.opt = new Option();
	}

	public void buildChoiceArray(String[] choiceTitles, String[] prices) // calls inner class method, assigns Option
																			// array to this OptionSet
	{
		if (DEBUG)
			System.out.println("Copying array of Options to " + OptionName);
		this.options = opt.returnChoiceArray(choiceTitles, prices);
	}

	protected void addOption() {
		// not writing until Collections can be used. For now changes will be made in
		// the .txt file
	}

	protected void deleteOption() {
		// not writing until Collections can be used. For now changes will be made in
		// the .txt file
	}

	protected void print() {
		System.out.println("\t____________________________");
		System.out.println("\t" + this.OptionName);
		for (int i = 0; i < options.length; i++)
			options[i].print();
	}

}

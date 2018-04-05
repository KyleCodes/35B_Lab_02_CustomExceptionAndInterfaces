package model;

import java.io.Serializable;

import debug.Debuggable;

public class Option implements Debuggable, Serializable {
	private String choiceTitle;
	private String price;

	protected Option() {
		if (DEBUG)
			System.out.println("Constructing default option");
	}

	protected Option(String choiceTitle, String price) {
		if (DEBUG)
			System.out.println("Constructing Option");
		this.choiceTitle = choiceTitle;
		this.price = price;
	}

	protected Option[] returnChoiceArray(String[] choiceTitles, String[] prices) // returns an array of Options, using
																					// input from
	{ // text file that's been sorted into name/price arrays
		if (DEBUG)
			System.out.println("Creating array of Options");
		int numOfChoices = choiceTitles.length;
		Option[] arr = new Option[numOfChoices];

		for (int i = 0; i < numOfChoices; i++)
			arr[i] = new Option(choiceTitles[i], prices[i]);

		return arr;
	}

	protected String getChoiceTitle() {
		return choiceTitle;
	}

	protected void setChoiceTitle(String choiceTitle) {
		this.choiceTitle = choiceTitle;
	}

	protected String getPrice() {
		return price;
	}

	protected void setPrice(String price) {
		this.price = price;
	}

	protected void print() {
		System.out.printf("\t   - $%s \t%s		\n", this.price, this.choiceTitle);
	}
}
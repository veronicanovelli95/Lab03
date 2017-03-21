package it.polito.tdp.spellcheck.model;

public class RichWord {
private String input;
private boolean giusta=false;

public RichWord(String input, boolean giusta) {
	super();
	this.input = input;
	this.giusta = giusta;
}

public String getInput() {
	return input;
}

public boolean isGiusta() {
	return giusta;
}

@Override
public String toString() {
	return "RichWord [input=" + input + ", giusta=" + giusta + "]";
}


}

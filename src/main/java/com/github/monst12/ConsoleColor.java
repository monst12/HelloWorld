package com.github.monst12;

public enum ConsoleColor {
	
	COLOR_CLEAR(""),
	COLOR_RED(""),
	COLOR_GREEN(""),
	COLOR_CYAN(""),
	COLOR_YELLOW(""),
	
	IN(""),
	OUT("");
	
	private String color;
	ConsoleColor(String color) {
		this.color = color;
	}
	
	@Override
	public String toString() {
		return this.color;
	}
	
}

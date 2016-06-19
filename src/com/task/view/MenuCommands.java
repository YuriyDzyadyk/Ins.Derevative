package com.task.view;

public enum MenuCommands {

	CREATE(1, "Crete"), CALCULATE_PRICE(2, "price calculator"), SORT(3, "Sort"), DELETE(4, "Delete"), FIND(5,
			"Find"), READE_FROM_FILE(6, "Read file"), EXIT(0, "Exit");

	private final String message;
	private final int code;

	private MenuCommands(int code, String message) {
		this.message = message;
		this.code = code;
	}

	public static MenuCommands get(int code) {
		for (MenuCommands c : MenuCommands.values()) {
			if (code == c.code) {
				return c;
			}
		}
		return null;
	}

	public String getMessage() {
		return message;
	}

	public int getCode() {
		return code;
	}

}

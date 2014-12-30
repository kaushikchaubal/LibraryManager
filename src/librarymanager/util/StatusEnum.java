package librarymanager.util;

public enum StatusEnum {
	BORROWED("Borrowed"),
	RECEIEVED("Received"),
	DISCARDED("Discarded");
	
	private String symbol;
	
	private StatusEnum(String symbol) {
		this.symbol = symbol;
	}
	
	public String getSymbol() {
		return symbol;
	}

	public static StatusEnum getEnumFrom(String symbol) {
		for (StatusEnum values : values()) {
            if (values.symbol.equals(symbol)) {
                return values;
            }
        }
        return null;
	}
}

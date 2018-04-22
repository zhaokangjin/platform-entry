package entry.condition;

import java.io.Serializable;

public class OneCondition implements Serializable {
	private static final long serialVersionUID = 5415133028012464366L;
	private String field;
	private Object object;
	private String symbol;

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
}

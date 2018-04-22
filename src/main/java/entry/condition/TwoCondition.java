package entry.condition;

import java.io.Serializable;

public class TwoCondition implements Serializable{
	private static final long serialVersionUID = 3395140964021491736L;
	private String field;
	private Object Object;
	private String leftSymbol;
	private String rightSymbol;
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public Object getObject() {
		return Object;
	}
	public void setObject(Object object) {
		Object = object;
	}
	public String getLeftSymbol() {
		return leftSymbol;
	}
	public void setLeftSymbol(String leftSymbol) {
		this.leftSymbol = leftSymbol;
	}
	public String getRightSymbol() {
		return rightSymbol;
	}
	public void setRightSymbol(String rightSymbol) {
		this.rightSymbol = rightSymbol;
	}
}

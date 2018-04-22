package entry.condition;

import java.io.Serializable;
import java.util.Map;

public class Sorts implements Serializable{
	private static final long serialVersionUID = 5716367404253254347L;
	
	private Map<String,Boolean> fieldMap;
	
	public Sorts(Map<String,Boolean> fieldMap){
		this.fieldMap=fieldMap;
	}

	public Map<String, Boolean> getFieldMap() {
		return fieldMap;
	}

	public void setFieldMap(Map<String, Boolean> fieldMap) {
		this.fieldMap = fieldMap;
	}


}

package entry.condition;

import java.io.Serializable;
import java.util.List;

public class Distinct implements Serializable{
	private static final long serialVersionUID = -8707465429587308946L;
	private boolean distinct;
	private List<String> fieldList;
	
	public Distinct(boolean distinct,List<String> fieldList){
		this.distinct=distinct;
		this.fieldList=fieldList;
	}
	public Distinct(List<String> fieldList){
		this.distinct=false;
		this.fieldList=fieldList;
	}
	
	public boolean isDistinct() {
		return distinct;
	}
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}
	public List<String> getFieldList() {
		return fieldList;
	}
	public void setFieldList(List<String> fieldList) {
		this.fieldList = fieldList;
	}

}

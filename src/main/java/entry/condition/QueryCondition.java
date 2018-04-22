package entry.condition;

import java.io.Serializable;
import java.util.List;
/**
 * 向后台传查询条件
 * @ClassName: CrudCondition   
 * @Description: 向后台传查询条件  
 * @author: kangjin.zhao  
 * @date:2018年4月18日 下午10:01:49
 */
public class QueryCondition implements Serializable{

	private static final long serialVersionUID = -8055752903338549547L;
	private List<OneCondition> oneConditionList;
	private List<TwoCondition> twoConditionList;
	public List<OneCondition> getOneConditionList() {
		return oneConditionList;
	}
	public void setOneConditionList(List<OneCondition> oneConditionList) {
		this.oneConditionList = oneConditionList;
	}
	public List<TwoCondition> getTwoConditionList() {
		return twoConditionList;
	}
	public void setTwoConditionList(List<TwoCondition> twoConditionList) {
		this.twoConditionList = twoConditionList;
	}
}

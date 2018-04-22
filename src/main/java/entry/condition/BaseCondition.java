package entry.condition;

import java.io.Serializable;

public class BaseCondition implements Serializable{
	private static final long serialVersionUID = -6391032771234574226L;
	private QueryCondition queryCondition;
	private Page page;
	private Sorts sorts;
	private Distinct distinct;
	public QueryCondition getQueryCondition() {
		return queryCondition;
	}
	public void setQueryCondition(QueryCondition queryCondition) {
		this.queryCondition = queryCondition;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public Sorts getSorts() {
		return sorts;
	}
	public void setSorts(Sorts sorts) {
		this.sorts = sorts;
	}
	public Distinct getDistinct() {
		return distinct;
	}
	public void setDistinct(Distinct distinct) {
		this.distinct = distinct;
	}

}

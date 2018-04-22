package entry.condition;
/**
 * 从前台获取分页参数，封装查询结构
 * @author kangjin.zhao
 */
public class Page {
	//分页数
	private int pageNum;
	//分页大小
	private int pageSize;
	
	public Page(int pageNum,int pageSize){
		this.pageNum=pageNum;
		this.pageSize=pageSize;
	}
	
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
}

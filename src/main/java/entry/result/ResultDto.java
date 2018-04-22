package entry.result;

import java.io.Serializable;

public class ResultDto <T> implements Serializable{

	private static final long serialVersionUID = -4747302683035950324L;
	private String code;
	private int status;
	private T result;
	public ResultDto(T result,String code,int status){
		this.result=result;
		this.status=status;
		this.code=code;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public T getResult() {
		return result;
	}
	public void setResult(T result) {
		this.result = result;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
}

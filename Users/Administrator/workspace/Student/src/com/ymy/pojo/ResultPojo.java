package com.ymy.pojo;

public class ResultPojo {
	//状态״̬
    private Integer status;

    // 消息
    private String msg;

    // 数据
    private Object data;
    
    public ResultPojo(){
    	
    }
    
    public ResultPojo(Integer status,String msg,Object data)
    {
    	this.status=status;
    	this.msg=msg;
    	this.data=data;
    }
    
    public static ResultPojo ok() {
        return new ResultPojo(null);
    }
    
    public ResultPojo(Object data) {
        this.status = 200;
        this.msg = "OK";
        this.data = data;
    }

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
    
    

}

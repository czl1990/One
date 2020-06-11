package com.hm.common.vo;

import java.io.Serializable;


public class JsonResult implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1014451606124102865L;

	//我们自己设置的服务端向客户端输出的状态码
	private int state=1;
	//状态码state对应的具体信息
	private String message="ok";
	//业务层返回给控制层的具体数据
	private Object data;
	
	public JsonResult() { }
	
	public JsonResult(String message) {
		this.message = message;
	}

	public JsonResult(Object data) {
		this.data = data;
	}

	public JsonResult(Throwable t) {
		this.state = 0;
		this.message = t.getMessage();
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
}

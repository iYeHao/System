package com.example.demo;

import java.util.HashMap;
import java.util.Map;

public class Register {
	private String uname;
	private String upassword;
	private String cpassword;
	/**
     * 存储校验不通过时给用户的错误提示信息
     */
    private Map<String, String> errors = new HashMap<String, String>();

    public Map<String, String> getErrors() {
        return errors;
    }
    /*
     * validate方法负责校验表单输入项
     * 表单输入项校验规则：
     *         private String userName; 用户名不能为空，并且要是3-8的字母 abcdABcd 
     *         private String userPwd; 密码不能为空，并且要是3-8的数字
     *         private String confirmPwd; 两次密码要一致
     *         private String email; 可以为空，不为空要是一个合法的邮箱 
     *         private String birthday; 可以为空，不为空时，要是一个合法的日期
     */
    public boolean validate() {

        boolean isOk = true;

        if (this.uname == null || this.uname.trim().equals("")) {
            isOk = false;
            errors.put("uname", "*用户名不为空");
        } else {
          if (!this.uname.matches("[a-zA-Z]{3,8}")) 
        	  {  
                isOk = false;
                errors.put("uname", "*用户名为3-8位的字母");
            }
        }
        // private String password2; 两次密码要一致
        if (this.cpassword != null) {
            if (!this.cpassword.equals(this.upassword)) {
                isOk = false;
                errors.put("cpassword", "*俩次密码不一致");
            }
        }      

        return isOk;
    }
    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }

	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	public String getCpassword() {
		return cpassword;
	}
	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}

}

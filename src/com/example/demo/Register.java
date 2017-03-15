package com.example.demo;

import java.util.HashMap;
import java.util.Map;

public class Register {
	private String uname;
	private String upassword;
	private String cpassword;
	/**
     * �洢У�鲻ͨ��ʱ���û��Ĵ�����ʾ��Ϣ
     */
    private Map<String, String> errors = new HashMap<String, String>();

    public Map<String, String> getErrors() {
        return errors;
    }
    /*
     * validate��������У���������
     * ��������У�����
     *         private String userName; �û�������Ϊ�գ�����Ҫ��3-8����ĸ abcdABcd 
     *         private String userPwd; ���벻��Ϊ�գ�����Ҫ��3-8������
     *         private String confirmPwd; ��������Ҫһ��
     *         private String email; ����Ϊ�գ���Ϊ��Ҫ��һ���Ϸ������� 
     *         private String birthday; ����Ϊ�գ���Ϊ��ʱ��Ҫ��һ���Ϸ�������
     */
    public boolean validate() {

        boolean isOk = true;

        if (this.uname == null || this.uname.trim().equals("")) {
            isOk = false;
            errors.put("uname", "*�û�����Ϊ��");
        } else {
          if (!this.uname.matches("[a-zA-Z]{3,8}")) 
        	  {  
                isOk = false;
                errors.put("uname", "*�û���Ϊ3-8λ����ĸ");
            }
        }
        // private String password2; ��������Ҫһ��
        if (this.cpassword != null) {
            if (!this.cpassword.equals(this.upassword)) {
                isOk = false;
                errors.put("cpassword", "*�������벻һ��");
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

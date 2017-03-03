package com.example.daoimp;

import java.sql.SQLException;
import java.util.ArrayList;

import com.example.dao.planDao;
import com.example.demo.Plan;

public class planImp {
public ArrayList<Plan> show(){
	ArrayList<Plan> plist =new ArrayList<Plan>();
	planDao dao =new planDao();
	try {
		plist=dao.show();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		dao.Close();
	}
	return plist;
}
public ArrayList<Plan> ShowDetail(int userid){
	ArrayList<Plan> planlist =new ArrayList<Plan>();
	planDao dao =new planDao();
	try {
		planlist =dao.DetailShow(userid);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		dao.Close();
	}
	return planlist;
}
public Plan PlanCheck(int pid){
	Plan plan =new Plan();
	planDao dao = new planDao();
	try {
		plan=dao.PlanCheck(pid);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		dao.Close();
	}
	return plan;
}
}

package com.crysisx;

import java.sql.Date;

public class Student {
  private int sid =0;
  private String sname=null;
  private String major = null;
  private Date birth = null;
  private float score =0;
public int getSid() {
	return sid;
}
public void setSid(int sid) {
	this.sid = sid;
}
public String getSname() {
	return sname;
}
public void setSname(String sname) {
	this.sname = sname;
}
public String getMajor() {
	return major;
}
public void setMajor(String major) {
	this.major = major;
}
public Date getBirth() {
	return birth;
}
public void setBirth(Date birth) {
	this.birth = birth;
}
public float getScore() {
	return score;
}
public void setScore(float score) {
	this.score = score;
}
  
public String toString() {
	String content = "sid="+sid+"\tsname="+sname+"\tmajor"+major+"\tbirth="+birth+"/tscore"+score;
	return content;
}
  
}
 
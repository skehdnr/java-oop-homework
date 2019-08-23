package bean;

import javax.swing.JOptionPane;

public class MemberBean {
	private String name,id,pass,bt;
	private Double weight,height;
	
	public void setName(String name) {
		this.name = name;
	}public String getName() {
		return this.name;
	}public void setId(String id) {
		this.id = id;
	}public String getId() {
		return this.id;
	}public void setPass(String pass) {
		this.pass = pass;
	}public String getPass() {
		return this.pass;
	}public void setBt() {
		this.bt = bt;
	}public String getBt() {
		return this.bt;
	}public void setWeight(Double weight) {
		this.weight = weight;
	}public Double getWeight() {
		return this.weight;
	}public void setHeight(Double height) {
		this.height = height;
	}public Double getHeight() {
		return this.height;
	}
	
	@Override
	public String toString() {
		return String.format(""
				+ "이름 : %s \n"
				+ "아이디 : %s \n"
				+ "비밀번호 : %s\n"
				+ "형액형 : %s \n"
				+ "몸무게 : %2.f\n"
				+ "키 : %2.f\n",name,id,pass,bt,weight,height);
	}
	
	
}

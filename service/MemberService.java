package service;

import bean.MemberBean;

public class MemberService {
	private MemberBean[] members;
	private int count;

	public MemberService() {
		members = new MemberBean[3];
		count = 0;
	}
	public String join(MemberBean param) {
		String msg = "회원가입 성공";
		members[count] = param;
		count++;
		return msg;
	}

	public String getMypage(MemberBean param) {
		return param.toString();
	}

	public String changePass(MemberBean param) {
		String msg = "비밀번호가 변경 되었습니다";
		String id = param.getId();
		String pass = param.getPass();
		
		String [] newPass =pass.split(",");
		String oldPass = newPass[0];
		String nP = newPass[1];
		for(int i = 0; i<count;i++) {
			if(param.getId().equals(members[i].getId())
					&&(oldPass.equals(members[i].getPass()))){
				members[i].setPass(nP);
				break;
			}
	}return msg;
	}
	public String withdrawal(MemberBean param) {
		String msg = "회원탈퇴 완료";
		return msg;
	}
	public String existId(String id) {
		String msg = "가입가능 ID 입니다";
		for(int i =0; i<count;i++) {
			if(id.equals(members[i].getId())) {
				msg = "이미 존재하는 ID 입니다";
				break;
			}
		}
		return msg;
	}
	public String login(MemberBean param) {
		String msg = "로그인 실패";
		for(int i = 0; i<count;i++) {
		if(param.getId().equals(members[i].getId())
				&&(param.getPass().equals(members[i].getPass()))){
			msg = "로그인 성공";
			break;
		}
		}return msg;
	}
	
	public String list() {
		String msg = "";
		for (int i = 0; i < count; i++) {
			msg += members[i].toString() + ", \n";
		}
		return msg;
	}
	
	public MemberBean findById(String id) {
		MemberBean member = new MemberBean();
		for (int i = 0; i < count; i++) {
			if(id.equals(members[i].getId())) {
				member = members[i];
			}break;
		}
		return member;
	}
	public MemberBean [] findByName(String name) {
		int j = 0;
		for(int i = 0; i<count; i++) {
			if(name.equals(this.members[i].getName())) {
				j++;
			}
		}
		MemberBean[] members = new MemberBean[j];
		j = 0 ;
		for(int i = 0; i<count; i++) {
			if(name.equals(this.members[i].getName())) {
				members[j] = this.members[i];
				j++;
				if(members.length==j) {
					break;
				}
			}members[i] = this.members[i];
		}
		return members;
	}
	public String countAll() {
		return String.valueOf(count+"명 입니다");
	}

}

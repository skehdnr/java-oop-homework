package controller;


import javax.swing.JOptionPane;

import bean.MemberBean;
import service.MemberService;

public class MemberController {

	public static void main(String[] args) {
		MemberService service = new MemberService();
		MemberBean member = null;
		String [] arr = null;
		String temp = "";
		
		while (true) {
			switch (JOptionPane.showInputDialog("0.종료 \n" 
					+"1.회원가입 \n" 
					+"2.마이페이지 \n" 
					+"3.비번수정 \n" 
					+"4.회원탈퇴\n"
					+"5.회원목록\n"
					+"6.아이디체크\n"
					+"7.로그인\n")) {
			case "0":
				JOptionPane.showMessageDialog(null, "종료");
				return;
			case "1":
				String spec = JOptionPane.showInputDialog("이름, 아이디, 비밀번호, 혈액형, 키, 몸무게");
				arr=spec.split(",");
				member = new MemberBean();
				member.setName(arr[0]);
				member.setId(arr[1]);
				member.setPass(arr[2]);
				member.setBt(arr[3]);
				member.setHeight(Double.parseDouble(arr[4]));
				member.setWeight(Double.parseDouble(arr[5]));
				JOptionPane.showMessageDialog(null, service.join(member));
				break;

			case "2":
				JOptionPane.showMessageDialog(null, service.getMypage(member));
				break;

			case "3":
				temp = JOptionPane.showInputDialog("Id,Pass,새로 바꿀 비밀번호를 입력해 주세요.");
				arr = temp.split(",");
				member = new MemberBean();
				member.setId(arr[0]);
				member.setPass(arr[1]+","+arr[2]);
				JOptionPane.showMessageDialog(null, service.changePass(member));
				break;

			case "4":
				
				break;
			case "5" :
				JOptionPane.showMessageDialog(null, service.list());
				break;
			case "6":
				String searchId = JOptionPane.showInputDialog("검색 ID");
				member = service.findById(searchId);
				JOptionPane.showMessageDialog(null,member);
			case"7":
				String login = JOptionPane.showInputDialog("로그인 ID, 비밀번호");
				String[] loginValues = login.split(",");
				String loginId = loginValues[0];
				String loginPass = loginValues[1];;
				member = new MemberBean();
				member.setId(loginId);
				member.setPass(loginPass);
				String msg = service.login(member);
				JOptionPane.showInputDialog(null,msg);
				break;
			}
		}

	}

}

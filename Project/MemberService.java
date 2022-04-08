package Project;

public interface MemberService {
	
	String ADMIN_ID = "admin"; 
	String ADMIN_PW = "admin";
	
	void MemberJoin();
	String MemberLogin();
	void MemberLogOut();
	void MemberList();
	void MemberView();
	void MemberUpdate();
	void MemberDelete();
	void MemberMyPage(String id);
}

package Project;

public class Member {
	
	private String MemberID;
	private String MemberPW;
	private String MemberName;
	
	public Member() {
	}
	
	public Member(String memberID, String memberPW, String memberName) {
		super();
		this.MemberID = memberID;
		this.MemberPW = memberPW;
		this.MemberName = memberName;
	}

	public String getMemberID() {
		return MemberID;
	}
	
	public void setMemberID(String memberID) {
		this.MemberID = memberID;
	}
	
	public String getMemberPW() {
		return MemberPW;
	}
	
	public void setMemberPW(String memberPW) {
		this.MemberPW = memberPW;
	}
	
	public String getMemberName() {
		return MemberName;
	}
	
	public void setMemberName(String memberName) {
		this.MemberName = memberName;
	}

	@Override
	public String toString() {
		return MemberID + " : " + MemberName;
	}

}

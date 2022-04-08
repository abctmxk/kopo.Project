package Project;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Set;

public class MemberServiceImpl extends LibraryData implements MemberService {
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	Member mm = null;

	Set<String> Userkeys = EnrollUser.keySet();
	Set<String> Bookkeys = EnrollBooks.keySet();
	

	@Override
	public void MemberJoin() {
		Member join = new Member();
		
		try {
			System.out.print("아이디 : ");
			String ID = br.readLine();
			join.setMemberID(ID);
			
			if(LibraryData.EnrollUser.containsKey(ID) == true) {
				System.out.println("중복된 ID 입니다.");
				return;
			}
			
			
			System.out.print("패스워드 : ");
			join.setMemberPW(br.readLine());
			
			System.out.print("이름 : ");
			join.setMemberName(br.readLine());
			
			EnrollUser.put(ID, join);
			
			System.out.println("회원가입 성공!");

			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String MemberLogin() {
		mm = new Member("admin", "admin", "관리자");
		EnrollUser.put("admin", mm);
		
		System.out.println("");
		String id, pass;
		String Send = "";

		try {
			System.out.print("아이디 : ");
			id = br.readLine();			
			System.out.print("패스워드 : ");
			pass = br.readLine();
			mm = EnrollUser.get(id);
			
			if (EnrollUser.containsKey(id) == true) {
				if (id.equals("admin") && pass.equals("admin")) {
					System.out.println("관리자 로그인!");
				} else {
					if (id.equals(mm.getMemberID()) && pass.equals(mm.getMemberPW())) {
						System.out.println(mm.getMemberID() + " 로그인 성공!");
						Send = mm.getMemberID();
						System.out.print("\n\n");
					} else {
						System.out.println("아이디 및 비밀번호를 확인해주세요!");
						mm = null;
					}
				}
			}else {
				System.out.println("회원이 존재하지 않습니다!");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return Send;

	}
	
	public String ValidationCheck() {
		String LoginCheck = "";

			if(mm == null) {
				LoginCheck = "guest";
			}else if(mm.getMemberID().equals("admin")) {
				LoginCheck = "admin";
			}else {
				// 추후 확장 가능성 
			}
		
		return LoginCheck;
	}
	

	// 회원을 출력하되 책을 대여했으면
	@Override
	public void MemberList() {
		
		try {
			System.out.println("전체 회원 리스트\n\n");
			
			
			Iterator<String> ite = Userkeys.iterator();
			while (ite.hasNext()) {
				String key = ite.next();
				Member ml = EnrollUser.get(key);
				if (!"admin".equals(ml.getMemberID())) {
					System.out.println("아이디 : " + ml.getMemberID());
					System.out.println("이름: " + ml.getMemberName());
				}
				System.out.println();
			}

				
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 자신의 상세정보
	@Override
	public void MemberView() {
		// TODO Auto-generated method stub

	}

	@Override
	public void MemberDelete() {
		
		String id;
		try {
			System.out.print("삭제할 ID를 입력해주세요 : ");
			id = br.readLine();
			Member m = EnrollUser.get(id);
			if (id.equals(m.getMemberID())) {
				EnrollUser.remove(id);
				System.out.println("삭제가 완료되었습니다!");

			} else {
				System.out.println("해당 ID가 존재하지 않습니다!");
				return;
			}

			// 첫 화면으로 돌아감
			mm = null;
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	@Override
	public void MemberUpdate() {

		String Mu;
		try {
			
			System.out.print("패스워드를 입력해주세요 : ");
			Mu = br.readLine();
			
			for(String key : Userkeys) {
				Member mu = EnrollUser.get(key);
				if(mu.getMemberPW().equals(Mu)) {
					String NewPass;
					System.out.print("새로운 패스워드를 입력하세요 : ");
					NewPass = br.readLine();
					mu.setMemberPW(NewPass);
				}else {
					return;
				}
				System.out.println("수정완료!");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void MemberLogOut() {
		mm = null;
		System.out.println("로그아웃 하였습니다.");
	}

	@Override
	public void MemberMyPage(String id) {
		System.out.println(id+ "님의 마이페이지 입니다.");
		try {
			
			Iterator<String> ite = Bookkeys.iterator();
			while (ite.hasNext()) {
				String key = ite.next();
				Book b = EnrollBooks.get(key);
				if (id.equals(b.getBookKey())) {
					System.out.println("도서번호 : "+ b.getBookISBN());
					System.out.println("책 저자 : "+b.getBookAuthor());
					System.out.println("책 이름 : " + b.getBookTitle());
				}
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

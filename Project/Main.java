package Project;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String id = "";
		MemberServiceImpl msi = new MemberServiceImpl();
		BookServiceImpl bsi = new BookServiceImpl();

		int input;
		String user;

		while (true) {
			try {
				System.out.println("======================================");
				System.out.println("             도서관리 프로그램             ");
				System.out.println("======================================");

				user = msi.ValidationCheck();

				if (user.equals("guest")) {
					do {
						System.out.println("1. 로그인 ");
						System.out.println("2. 회원가입 ");
						System.out.println("3. 종료 ");
						System.out.print("입력 : ");
						input = sc.nextInt();
					} while (input < 1 || input > 3);

					switch (input) {
					case 1: 
						id = msi.MemberLogin();
						break;
					case 2: 
						msi.MemberJoin();
						break;
					case 3:
						System.out.println("\n시스템 종료\n");
						System.exit(0);
					default:
						System.out.println("다시 입력해주세요");
						break;
							
					}
					
				}else if(user.equals("admin")) {
					do {
						System.out.println("1. 도서 관리 ");
						System.out.println("2. 회원 관리 ");
						System.out.println("3. 종료 ");
						System.out.print("입력 : ");
						input = sc.nextInt();
					}while(input < 1 || input > 3);
					
					switch (input) {  
					case 1: // 1번 도서관리
						do {
							System.out.println("1. 도서 등록 ");
							System.out.println("2. 도서 수정 ");
							System.out.println("3. 도서 삭제 ");
							System.out.println("4. 도서 검색(전체) ");
							System.out.println("5. 나가기 ");
							System.out.print("입력 : ");
							input = sc.nextInt();
						}while(input < 1 || input > 6);
						
						if(input == 5) {break;}
						
						switch(input) {
						case 1:
							bsi.BookAdd();
							break;
						case 2:
							bsi.BookUpdate();
							break;
						case 3:
							bsi.BookDel();
							break;
						case 4:
							bsi.BookIsRentallist();
							break;
						}
						break;
					case 2: // 2번 회원관리
						do {
							System.out.println("1. 회원 목록(전체) ");
							System.out.println("2. 회원 삭제 ");
							System.out.println("3. 나가기 ");
							System.out.print("입력 : ");
							input = sc.nextInt();
							
						}while(input < 1 || input > 4);
						
						if(input == 3) {break;}
						
						switch(input) {
						case 1:
							msi.MemberList();
							break;
						case 2:
							msi.MemberDelete();
							break;
						case 3:
							msi.MemberLogOut();
							break;
						}
						
						break;
					case 3:
						msi.MemberLogOut();
						break;
//						System.out.println("\n\n\n시스템 종료!\n\n");
//						System.exit(0);
					}
				}else {
					do {
						System.out.println("1. 대여 가능 도서확인 ");
						System.out.println("2. 도서 대여 ");
						System.out.println("3. 도서 반납 ");
						System.out.println("4. 도서 검색 ");
						System.out.println("5. 로그 아웃 ");
						System.out.println("6. 마이 페이지");
						System.out.println("7. 회원 수정 ");
						System.out.println("8. 회원 탈퇴 ");
						System.out.println("9. 나가기 ");
						System.out.print("입력 : ");
						input = sc.nextInt();
					}while(input < 1 || input > 9);
					
					if(input == 9) {break;}
					
					switch(input) {
					case 1:
						bsi.BookIsRentallist();
						break;
					case 2:
						bsi.BookBorrow(id);
						break;
					case 3:
						bsi.BookReturn();
						break;
					case 4:
						bsi.BookSearch();
						break;
					case 5:
						msi.MemberLogOut();
						break;
					case 6:
						msi.MemberMyPage(id);
						break;
					case 7:
						msi.MemberUpdate();
						break;
					case 8:
						msi.MemberDelete();
						break;
					}
				}	
			} catch (Exception e) {
                System.out.println("잘못된 입력입니다. 다시 입력하세요. : ");
                sc = new Scanner(System.in);
			}
		}
	}

}

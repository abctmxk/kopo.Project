package Project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class BookServiceImpl extends LibraryData implements BookService {


	List<Book> list = new ArrayList<Book>();
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	Set<String> UserKeys = EnrollUser.keySet();
	Set<String> Bookkeys = EnrollBooks.keySet();

	@Override
	public void BookAdd() {
		Book ba = new Book();
		try {
			System.out.print("도서번호(ISBN)을 입력하세요 : ");
			String ISBN = br.readLine();
			ba.setBookISBN(ISBN);

			System.out.print("제목을 입력하세요 : ");
			ba.setBookTitle(br.readLine());
			
			System.out.print("저자를 입력하세요 : ");
			ba.setBookAuthor(br.readLine());
			
			ba.setBookAvailable("true");
			ba.setBookKey("empty");
			
			EnrollBooks.put(ISBN, ba);
			
			System.out.println("책이 등록되었습니다!");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void BookBorrow(String m) {
		String Bid = m;
		System.out.println(Bid);
		
		System.out.print("도서번호(ISBN)를 입력해주세요 : ");
		try {
			String isbn = br.readLine();
			if (EnrollBooks.containsKey(isbn) == true) {
				Iterator<String> ite = Bookkeys.iterator();
				while (ite.hasNext()) {
					String key = ite.next();
					if(key.equals(isbn)) {						
						Book b = EnrollBooks.get(key);
						b.setBookAvailable("false");
						b.setBookKey(Bid);
					}
				}
				
				System.out.println("대여가 완료되었습니다");
			} else {
				System.out.println("해당 도서가 없습니다");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void BookDel() {
		try {
			System.out.print("삭제할 도서번호(ISBN)를 입력해주세요 : ");
			String isbn = br.readLine();
				Book b = EnrollBooks.get(isbn);
				if(isbn.equals(b.getBookISBN())) {						
					EnrollBooks.remove(isbn);
					System.out.println("삭제가 완료되었습니다!");
			}		
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}

	@Override
	public void BookReturn() {
		
		try {
			System.out.print("반납할 도서번호(ISBN)를 입력해주세요 : ");
			String isbn = br.readLine();
			Book b = EnrollBooks.get(isbn);
			if (isbn.equals(b.getBookISBN())) {
				b.setBookAvailable("true");
				b.setBookKey("empty");
			}			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
	}

	@Override
	public void BookIsRentallist() {
		System.out.println("대여가능한 도서 목록\n\n");
		try {
			Iterator<String> ite = Bookkeys.iterator();

			while (ite.hasNext()) {
				String key = ite.next();
				Book b = EnrollBooks.get(key);
				if (b.getBookAvailable().equals("true")) {
					System.out.print("도서 번호 : " + b.getBookISBN()+"\t");
					System.out.print("도서 제목 : " + b.getBookTitle()+"\t");
					System.out.print("도서 저자 : " + b.getBookAuthor()+"\t");
					System.out.print("\n\n");	
				}
			}
			
			
			System.out.print("조회내용을 저장하시겠습니까? Y(y) or N(n) : ");
			String choice = "";
			choice = br.readLine();
			BufferedWriter bs = null;
			if (choice.equals("Y") || choice.equals("y")) {
				String Path = "D:/Lecture/java-workspace/JAVA/src/Project/save.txt";
				File file = new File(Path);
				if (file.exists()) {
					file.createNewFile();
				}

				String Wstr = "";
				bs = new BufferedWriter(new FileWriter(Path, false));

				Iterator<String> Wite = Bookkeys.iterator();
				while (Wite.hasNext()) {
					String key = Wite.next();
					Book b = EnrollBooks.get(key);
					if (b.getBookAvailable().equals("true")) {
						System.out.print("도서 번호 : " + b.getBookISBN() + "\t");
						System.out.print("도서 제목 : " + b.getBookTitle() + "\t");
						System.out.print("도서 저자 : " + b.getBookAuthor() + "\t");
						System.out.print("\n\n");
						if (b.getBookAvailable().equals("true")) {
							Wstr = "\t대여상태 : 가능";
						} else {
							Wstr = "\t대여상태 : 불가능";
						}
						bs.write(String.valueOf("도서번호(ISBN) : " + b.getBookISBN() + "\t책 이름 : "
						+ b.getBookTitle() + "\t책 저자 : " + b.getBookAuthor() + Wstr)

						);
						bs.newLine();

					}
				}
				System.out.println("파일저장이 완료되었습니다");
			} else {
				return;
			}
			bs.flush();
			bs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void BookSearch() {
		
		try {
			String isbn = br.readLine();
			System.out.print("검색할 도서번호(ISBN)를 입력해주세요 : ");
			Book b = EnrollBooks.get(isbn);
			if (isbn.equals(b.getBookISBN())) {
				System.out.print("도서 번호 : " + b.getBookISBN() + "\t");
				System.out.print("도서 제목 : " + b.getBookTitle() + "\t");
				System.out.print("도서 저자 : " + b.getBookAuthor() + "\t");
				System.out.print("대여 상태 : " + b.getBookAvailable() + "\t");
				System.out.print("\n\n");

			} else {
				System.out.println("해당 도서가 존재하지 않습니다!");
				return;
			}	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void BookUpdate() {
		
		try {
			String isbn = br.readLine();
			System.out.print("수정할 도서번호(ISBN)를 입력해주세요 : ");
			Book b = EnrollBooks.get(isbn);
			if (isbn.equals(b.getBookISBN())) {
				System.out.print("수정할 책 제목 : ");
				b.setBookTitle(br.readLine());
				System.out.print("수정할 책 저자 : ");
				b.setBookAuthor(br.readLine());
				System.out.println("수정이 완료되었습니다");
				return;

			} else {
				System.out.println("해당 도서가 존재하지 않습니다!");
				return;
			}		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}

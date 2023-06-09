package Spring_DI4;

import java.util.Scanner;

// 점수 출력 클래스
public class NewRecordView implements RecordView{
	// NewRecordView는 점수를 받기 위해 NewRecord가 필요합니다
	// 상속 : 포함(has-a) >> 연관 관계
	
	private NewRecord record; // record가 NewRecord 객체의 주소를 갖겠다

	
	// 여기를 수정하자
	// 답은 함수
	public void setRecord(Record record) { // interface를 사용해서 다형성을 이용한다
		this.record = (NewRecord)record;
	}
	/*
	 * 나는 너의 객체 [주소]가 필요해
	 * 
	 * 1. 생성자를 통해 필요한 객체를 생성 또는 주입 > DI > 복합, 집합
	 * 2. 함수(setter)를 통해 필요한 객체를 주입 > DI > 집합 > 필요에 따라서
	 */	
	@Override
	public void print() {
		System.out.println(record.total() + " " + record.avg());
	}
	
	@Override
	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.print("kor : ");
		record.setKor(Integer.parseInt(sc.nextLine()));
		System.out.print("eng : ");
		record.setEng(Integer.parseInt(sc.nextLine()));
		System.out.print("math : ");
		record.setMath(Integer.parseInt(sc.nextLine()));
	}

}

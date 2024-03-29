package DI;

// 점수 출력 클래스
public class NewRecordView {
	// NewRecordView는 점수를 받기 위해 NewRecord가 필요합니다
	// 상속 : 포함(has-a) >> 연관 관계
	
	private NewRecord record; // record가 NewRecord 객체의 주소를 갖겠다
	// 포함(복합연관)
	public NewRecordView(int kor, int eng, int math) {
		record = new NewRecord(kor, eng, math);
	}
	
	public void print() {
		System.out.println(record.total() + " " + record.avg());
	}
}

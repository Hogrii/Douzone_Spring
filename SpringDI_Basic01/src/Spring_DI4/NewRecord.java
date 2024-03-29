package Spring_DI4;

// DTO 클래스
public class NewRecord implements Record{
	private int kor;
	private int eng;
	private int math;
	
	public NewRecord() {}

	public NewRecord(int kor, int eng, int math) {
		super();
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	// 필요에 따라서는 추가적인 함수 구현이 가능
	// 총합
	@Override
	public int total() {
		return this.kor + this.eng + this.math;
	}
	
	// 평균
	@Override
	public float avg() {
		return total()/3.0f;
	}
	
	@Override
	public String toString() {
		return "NewRecord [kor=" + kor + ", eng=" + eng + ", math=" + math + "]";
	}
}

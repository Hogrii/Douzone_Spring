package DI;

// ���� ��� Ŭ����
public class NewRecordView {
	// NewRecordView�� ������ �ޱ� ���� NewRecord�� �ʿ��մϴ�
	// ��� : ����(has-a) >> ���� ����
	
	private NewRecord record; // record�� NewRecord ��ü�� �ּҸ� ���ڴ�
	// ����(���տ���)
	public NewRecordView(int kor, int eng, int math) {
		record = new NewRecord(kor, eng, math);
	}
	
	public void print() {
		System.out.println(record.total() + " " + record.avg());
	}
}

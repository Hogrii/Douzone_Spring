package DI2;

// ���� ��� Ŭ����
public class NewRecordView {
	// NewRecordView�� ������ �ޱ� ���� NewRecord�� �ʿ��մϴ�
	// ��� : ����(has-a) >> ���� ����
	
	private NewRecord record; // record�� NewRecord ��ü�� �ּҸ� ���ڴ�

	// NewRecord ��ü�� �ּҸ� �ʿ信 ���� ���� �ް� �ʹ�
	// NewRecordView�� ��������ٰ��ؼ� ������ record�� NewRecord�� ���� �ʿ�� �����
	
	// ���� �Լ�
	public void setRecord(NewRecord record) {
		this.record = record;
	}
	/*
	 * ���� ���� ��ü [�ּ�]�� �ʿ���
	 * 
	 * 1. �����ڸ� ���� �ʿ��� ��ü�� ���� �Ǵ� ���� > DI > ����, ����
	 * 2. �Լ�(setter)�� ���� �ʿ��� ��ü�� ���� > DI > ���� > �ʿ信 ����
	 */	
	public void print() {
		System.out.println(record.total() + " " + record.avg());
	}

}

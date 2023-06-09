package Spring_DI4;

import java.util.Scanner;

// ���� ��� Ŭ����
public class NewRecordView implements RecordView{
	// NewRecordView�� ������ �ޱ� ���� NewRecord�� �ʿ��մϴ�
	// ��� : ����(has-a) >> ���� ����
	
	private NewRecord record; // record�� NewRecord ��ü�� �ּҸ� ���ڴ�

	
	// ���⸦ ��������
	// ���� �Լ�
	public void setRecord(Record record) { // interface�� ����ؼ� �������� �̿��Ѵ�
		this.record = (NewRecord)record;
	}
	/*
	 * ���� ���� ��ü [�ּ�]�� �ʿ���
	 * 
	 * 1. �����ڸ� ���� �ʿ��� ��ü�� ���� �Ǵ� ���� > DI > ����, ����
	 * 2. �Լ�(setter)�� ���� �ʿ��� ��ü�� ���� > DI > ���� > �ʿ信 ����
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

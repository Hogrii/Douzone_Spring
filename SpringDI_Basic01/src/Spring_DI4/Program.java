package Spring_DI4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Program {
	public static void main(String[] args) {
		/*
			// NewRecordView view = new NewRecordView(100, 50, 40);		
			// view.print();
			
			NewRecordView view = new NewRecordView();
			// ��ٰ�
			// ���� NewRecord ��ü �ּҰ� �ʿ���
			NewRecord record = new NewRecord(100, 100, 100);
			view.setRecord(record); // ������ü�� �ּҸ� ���� �޴´�(DI)
			view.print();
		 */
		/*
		 * �������� �ڽŸ��� �޸� ������ ���´�
		 * 1. SpringFrameWork �����̳ʸ� ����(�޸� ���� : �����̳�(IOC �����̳�))
		 *    ApplicationContext context = new ClassPathXmlApplicationContext("DIConfig.xml");
		 * 	  ApplicationContext �޸� ������ �����, DIConfig.xml ������ �������ϰ� �а� �����Ѵ�
		 * 2. �����̳ʸ� ����� �� �޸𸮿� �ʿ��� [��ü�� ����]�� �� ��ü���� ����(����:DI) �Ѵ�.. ���߿� �ڵ� �Ҹ�
		 * 	  >> �����̳ʰ� �����ǰ� DIConfig.xml�� read ..
		 * 	  >> DIConfig.xml �ȿ� ��ü ������ ������ ���õ� ������� ��� �ִ�
		 * 	  >> ������ ��ü�� bean�̶�� �Ѵ�
		 */
		
		// 1. ApplicationContext -> ������ �޸� ������ ������ִ� ��ü
		// Spring�� �ʿ��� �޸� ������ �����ϰ� ������ �޸𸮿� DIConfig.xml�� read�� �� ��ü�� �����ϰ� ����
		ApplicationContext context = new ClassPathXmlApplicationContext("DIConfig.xml");
		
		// �����̳� �ȿ� �ʿ��� ��ü�� �ִٸ� ������ �´� >> DIConfig.xml�� id���� �̿��ϸ� �ȴ�
		RecordView view = (RecordView)context.getBean("view"); // getBean�� return -> Object
		view.input();
		view.print();
		// ����� ����
		// Caused by: java.lang.ClassNotFoundException: org.apache.commons.logging.LogFactory
		
	}
}

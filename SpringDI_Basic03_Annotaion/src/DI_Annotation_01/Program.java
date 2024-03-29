package DI_Annotation_01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;

public class Program {
	public static void main(String[] args) {
		/*
			MonitorViewer viewer = new MonitorViewer();
			Recorder recorder = new Recorder();
			viewer.setRecorder(recorder);
			System.out.println(viewer.getRecorder());
		 */
		
		ApplicationContext context = new GenericXmlApplicationContext("classpath:DI_Annotation_01/DI_01.xml");
		MonitorViewer viewer = context.getBean("viewer", MonitorViewer.class);
		System.out.println(viewer.getRecorder());
	}
}

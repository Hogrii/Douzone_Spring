package DI_Annotation_01;

import org.springframework.beans.factory.annotation.Autowired;

public class MonitorViewer {
	private Recorder recorder;

	public Recorder getRecorder() {
		return recorder;
	}

	// 필요한 객체 주입 받기
	// MonitorViewer는 Recorder에 의존한다, 주소가 필요합니다
	
	/*
	 * 원래는
	 * <property name="recorder">
	 *   <ref bean="recorder"/>
	 * </property>를 사용
	 * 
	 * 하지만
	 * @Autowired(by type)를 사용하면 한번에 해결
	 * 컨테이너 안에 Bean 객체들이 생성되고 주입하려 한다
	 * @Autowired를 만나면
	 * 컨테이너 안에 Recorder 타입 Bean 객체를 찾고 찾으면 자동으로 주입한다
	 * 
	 * @Autowired(required=true) >> default >> 무조건 주입하려고 한다
	 * @Autowired(required=false) >> 컨테이너 안에 원하는 타입의 객체가 없으면 주입 안하면 되지~
	 */
	
	@Autowired(required=false)
	public void setRecorder(Recorder recorder) {
		this.recorder = recorder;
	}	
}

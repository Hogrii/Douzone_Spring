package DI_Annotation_03;
import javax.annotation.Resource;

public class MonitorViewer {
	private Recorder recorder;
	
	public Recorder getRecorder() {
		return this.recorder;
	}
	
	//@Autowired  by type
	@Resource(name="yy") //같은 타입의 객체가 있을때 name 값으로 찿는다
	public void setRecorder(Recorder recorder) {
		this.recorder = recorder;
		System.out.println("setRecorder : " + this.recorder);
	}
	
	
}

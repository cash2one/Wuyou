import com.istudy.server.xxt.service.XXTWSService;


public class XXTTeacherMain {
	public static int i = 0;
	
	public static void main(String[] args) {
		XXTWSService xxtwsService = new XXTWSService();
		//new XXTWSService().getStudentInfoById("3568016", "gz");
		new Thread(new XXTTeacherRunner(xxtwsService, 0, 787)).start();
	}
}

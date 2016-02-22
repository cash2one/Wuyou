import com.istudy.server.xxt.service.XXTWSService;


public class XXTTeacherRelaMain {
	public static int i = 0;
	
	public static void main(String[] args) {
		XXTWSService xxtwsService = new XXTWSService();
		//new XXTWSService().getStudentInfoById("3568016", "gz");
		//65457
		new Thread(new XXTTeacherRelaRunner(xxtwsService, 0, 10000)).start();
		new Thread(new XXTTeacherRelaRunner(xxtwsService, 10000, 20000)).start();
		new Thread(new XXTTeacherRelaRunner(xxtwsService, 20000, 30000)).start();
		/*new Thread(new XXTTeacherRelaRunner(xxtwsService, 30000, 40000)).start();
		new Thread(new XXTTeacherRelaRunner(xxtwsService, 40000, 50000)).start();
		new Thread(new XXTTeacherRelaRunner(xxtwsService, 50000, 60000)).start();
		new Thread(new XXTTeacherRelaRunner(xxtwsService, 60000, 65458)).start();*/
	}
}

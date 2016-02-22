import com.istudy.server.xxt.service.XXTWSService;




public class XXTClassMain{

	public static int i = 0;
	
	public static void main(String[] args) {
		XXTWSService xxtwsService = new XXTWSService();
		//new XXTWSService().getStudentInfoById("3568016", "gz");
		new Thread(new XXTClassRunner(xxtwsService, 0, 787)).start();

	}
}

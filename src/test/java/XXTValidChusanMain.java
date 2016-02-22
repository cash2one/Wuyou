import com.istudy.server.common.constants.XXTConstants;
import com.istudy.server.xxt.service.XXTWSService;




public class XXTValidChusanMain{

	public static void main(String[] args) {
		System.out.println(XXTConstants.XXT_CODE);;
		XXTWSService xxtwsService = new XXTWSService();
		//new XXTWSService().getStudentInfoById("3568016", "gz");
		new Thread(new XXTValidChusan(xxtwsService, 0, 15)).start();
		
		/*new Thread(new XXTValidChusan(xxtwsService, 0, 500)).start();
		new Thread(new XXTValidChusan(xxtwsService, 500, 1000)).start();
		new Thread(new XXTValidChusan(xxtwsService, 1000, 1500)).start();
		new Thread(new XXTValidChusan(xxtwsService, 1500, 2000)).start();
		new Thread(new XXTValidChusan(xxtwsService, 2000, 2500)).start();
		new Thread(new XXTValidChusan(xxtwsService, 2500, 3000)).start();
		new Thread(new XXTValidChusan(xxtwsService, 3000, 3500)).start();
		new Thread(new XXTValidChusan(xxtwsService, 3500, 4000)).start();
		new Thread(new XXTValidChusan(xxtwsService, 4000, 4500)).start();
		new Thread(new XXTValidChusan(xxtwsService, 4500, 5000)).start();
		new Thread(new XXTValidChusan(xxtwsService, 5000, 5500)).start();
		new Thread(new XXTValidChusan(xxtwsService, 5500, 6500)).start();*/
		
		/*new Thread(new XXTValidChusan(xxtwsService, 0, 5000)).start();
		new Thread(new XXTValidChusan(xxtwsService, 5000, 10000)).start();
		new Thread(new XXTValidChusan(xxtwsService, 10000, 15000)).start();
		new Thread(new XXTValidChusan(xxtwsService, 15000, 20000)).start();
		new Thread(new XXTValidChusan(xxtwsService, 20000, 25000)).start();
		new Thread(new XXTValidChusan(xxtwsService, 25000, 30000)).start();
		new Thread(new XXTValidChusan(xxtwsService, 30000, 35000)).start();
		new Thread(new XXTValidChusan(xxtwsService, 35000, 40000)).start();
		new Thread(new XXTValidChusan(xxtwsService, 40000, 45000)).start();
		new Thread(new XXTValidChusan(xxtwsService, 45000, 50000)).start();
		new Thread(new XXTValidChusan(xxtwsService, 50000, 55000)).start();
		new Thread(new XXTValidChusan(xxtwsService, 55000, 60000)).start();
		new Thread(new XXTValidChusan(xxtwsService, 60000, 65000)).start();*/
		
		/*new Thread(new XXTValidChusan(xxtwsService, 65000, 70000)).start();
		new Thread(new XXTValidChusan(xxtwsService, 70000, 75000)).start();
		new Thread(new XXTValidChusan(xxtwsService, 75000, 80000)).start();
		new Thread(new XXTValidChusan(xxtwsService, 80000, 85000)).start();
		new Thread(new XXTValidChusan(xxtwsService, 85000, 90000)).start();
		new Thread(new XXTValidChusan(xxtwsService, 90000, 95000)).start();
		new Thread(new XXTValidChusan(xxtwsService, 95000, 100000)).start();
		new Thread(new XXTValidChusan(xxtwsService, 100000, 105000)).start();
		new Thread(new XXTValidChusan(xxtwsService, 105000, 110000)).start();
		new Thread(new XXTValidChusan(xxtwsService, 110000, 115000)).start();
		new Thread(new XXTValidChusan(xxtwsService, 115000, 120000)).start();*/
		
		/*new Thread(new XXTValidChusan(xxtwsService, 120000, 125000)).start();
		new Thread(new XXTValidChusan(xxtwsService, 125000, 130000)).start();
		new Thread(new XXTValidChusan(xxtwsService, 130000, 135000)).start();
		new Thread(new XXTValidChusan(xxtwsService, 135000, 140000)).start();
		new Thread(new XXTValidChusan(xxtwsService, 140000, 145000)).start();
		new Thread(new XXTValidChusan(xxtwsService, 145000, 150000)).start();
		new Thread(new XXTValidChusan(xxtwsService, 150000, 155000)).start();
		new Thread(new XXTValidChusan(xxtwsService, 155000, 160000)).start();
		new Thread(new XXTValidChusan(xxtwsService, 160000, 165000)).start();
		new Thread(new XXTValidChusan(xxtwsService, 165000, 170000)).start();
		new Thread(new XXTValidChusan(xxtwsService, 170000, 175000)).start();
		new Thread(new XXTValidChusan(xxtwsService, 175000, 180000)).start();
		new Thread(new XXTValidChusan(xxtwsService, 180000, 185000)).start();
		new Thread(new XXTValidChusan(xxtwsService, 185000, 190000)).start();
		new Thread(new XXTValidChusan(xxtwsService, 190000, 195000)).start();
		new Thread(new XXTValidChusan(xxtwsService, 195000, 200000)).start();
		new Thread(new XXTValidChusan(xxtwsService, 200000, 205000)).start();
		new Thread(new XXTValidChusan(xxtwsService, 205000, 210000)).start();
		new Thread(new XXTValidChusan(xxtwsService, 210000, 215000)).start();
		new Thread(new XXTValidChusan(xxtwsService, 215000, 220000)).start();
		new Thread(new XXTValidChusan(xxtwsService, 220000, 225000)).start();
		new Thread(new XXTValidChusan(xxtwsService, 225000, 230000)).start();
		new Thread(new XXTValidChusan(xxtwsService, 230000, 235000)).start();
		new Thread(new XXTValidChusan(xxtwsService, 235000, 240000)).start();*/

		/*new Thread(new XXTValidChusan(xxtwsService, 240000, 245000)).start();
		new Thread(new XXTValidChusan(xxtwsService, 245000, 250000)).start();
		new Thread(new XXTValidChusan(xxtwsService, 250000, 255000)).start();
		new Thread(new XXTValidChusan(xxtwsService, 255000, 260000)).start();
		new Thread(new XXTValidChusan(xxtwsService, 260000, 265000)).start();
		new Thread(new XXTValidChusan(xxtwsService, 265000, 270000)).start();
		new Thread(new XXTValidChusan(xxtwsService, 270000, 275000)).start();
		new Thread(new XXTValidChusan(xxtwsService, 275000, 280000)).start();
		new Thread(new XXTValidChusan(xxtwsService, 280000, 285000)).start();
		new Thread(new XXTValidChusan(xxtwsService, 285000, 290000)).start();
		new Thread(new XXTValidChusan(xxtwsService, 290000, 295000)).start();
		new Thread(new XXTValidChusan(xxtwsService, 295000, 300000)).start();
		new Thread(new XXTValidChusan(xxtwsService, 300000, 305000)).start();
		new Thread(new XXTValidChusan(xxtwsService, 305000, 310000)).start();
		new Thread(new XXTValidChusan(xxtwsService, 310000, 315000)).start();
		new Thread(new XXTValidChusan(xxtwsService, 315000, 320000)).start();
		new Thread(new XXTValidChusan(xxtwsService, 320000, 325000)).start();
		new Thread(new XXTValidChusan(xxtwsService, 325000, 330000)).start();
		new Thread(new XXTValidChusan(xxtwsService, 330000, 335000)).start();
		new Thread(new XXTValidChusan(xxtwsService, 335000, 340000)).start();
		new Thread(new XXTValidChusan(xxtwsService, 340000, 345000)).start();
		new Thread(new XXTValidChusan(xxtwsService, 345000, 350000)).start();*/
		
		/*
		new Thread(new XXTValidChusan(xxtwsService, 0, 1000)).start();
		new Thread(new XXTValidChusan(xxtwsService, 1000, 2000)).start();
		new Thread(new XXTValidChusan(xxtwsService, 2000, 3000)).start();
		new Thread(new XXTValidChusan(xxtwsService, 3000, 4000)).start();
		new Thread(new XXTValidChusan(xxtwsService, 4000, 5000)).start();
		new Thread(new XXTValidChusan(xxtwsService, 5000, 6000)).start();
		**/
	}
}

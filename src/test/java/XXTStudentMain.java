import com.istudy.server.xxt.service.XXTWSService;




public class XXTStudentMain{

	public static int i = 0;
	
	public static void main(String[] args) {
		XXTWSService xxtwsService = new XXTWSService();
		//new XXTWSService().getStudentInfoById("3568016", "gz");
		//65457 24533
		//new Thread(new XXTStudentRunner(xxtwsService, 1, 9)).start();
		
		new Thread(new XXTStudentRunner(xxtwsService, 0, 23899)).start();
		
		/*new Thread(new XXTStudentRunner(xxtwsService, 0, 5000)).start();
		new Thread(new XXTStudentRunner(xxtwsService, 5000, 10000)).start();
		new Thread(new XXTStudentRunner(xxtwsService, 10000, 15000)).start();
		new Thread(new XXTStudentRunner(xxtwsService, 15000, 20000)).start();
		new Thread(new XXTStudentRunner(xxtwsService, 20000, 25000)).start();*/
		
		/*new Thread(new XXTStudentRunner(xxtwsService, 25000, 30000)).start();
		new Thread(new XXTStudentRunner(xxtwsService, 30000, 35000)).start();
		new Thread(new XXTStudentRunner(xxtwsService, 35000, 40000)).start();
		new Thread(new XXTStudentRunner(xxtwsService, 40000, 45000)).start();
		new Thread(new XXTStudentRunner(xxtwsService, 45000, 50000)).start();
		new Thread(new XXTStudentRunner(xxtwsService, 50000, 55000)).start();
		new Thread(new XXTStudentRunner(xxtwsService, 55000, 60000)).start();
		new Thread(new XXTStudentRunner(xxtwsService, 60000, 65000)).start();
		new Thread(new XXTStudentRunner(xxtwsService, 65000, 70000)).start();*/
		
		/*new Thread(new XXTStudentRunner(xxtwsService, 70000, 75000)).start();
		new Thread(new XXTStudentRunner(xxtwsService, 75000, 80000)).start();
		new Thread(new XXTStudentRunner(xxtwsService, 80000, 85000)).start();
		new Thread(new XXTStudentRunner(xxtwsService, 85000, 90000)).start();
		new Thread(new XXTStudentRunner(xxtwsService, 90000, 95000)).start();
		new Thread(new XXTStudentRunner(xxtwsService, 95000, 100000)).start();
		new Thread(new XXTStudentRunner(xxtwsService, 100000, 105000)).start();
		new Thread(new XXTStudentRunner(xxtwsService, 105000, 110000)).start();
		new Thread(new XXTStudentRunner(xxtwsService, 110000, 115000)).start();
		new Thread(new XXTStudentRunner(xxtwsService, 115000, 120000)).start();*/
		
		/*new Thread(new XXTStudentRunner(xxtwsService, 120000, 125000)).start();
		new Thread(new XXTStudentRunner(xxtwsService, 125000, 130000)).start();
		new Thread(new XXTStudentRunner(xxtwsService, 130000, 135000)).start();
		new Thread(new XXTStudentRunner(xxtwsService, 135000, 140000)).start();
		new Thread(new XXTStudentRunner(xxtwsService, 140000, 145000)).start();
		new Thread(new XXTStudentRunner(xxtwsService, 145000, 150000)).start();
		new Thread(new XXTStudentRunner(xxtwsService, 150000, 155000)).start();
		new Thread(new XXTStudentRunner(xxtwsService, 155000, 160000)).start();
		new Thread(new XXTStudentRunner(xxtwsService, 160000, 165000)).start();
		new Thread(new XXTStudentRunner(xxtwsService, 165000, 170000)).start();
		new Thread(new XXTStudentRunner(xxtwsService, 170000, 175000)).start();
		new Thread(new XXTStudentRunner(xxtwsService, 175000, 180000)).start();
		new Thread(new XXTStudentRunner(xxtwsService, 180000, 185000)).start();
		new Thread(new XXTStudentRunner(xxtwsService, 185000, 190000)).start();
		new Thread(new XXTStudentRunner(xxtwsService, 190000, 195000)).start();
		new Thread(new XXTStudentRunner(xxtwsService, 195000, 200000)).start();
		new Thread(new XXTStudentRunner(xxtwsService, 200000, 205000)).start();
		new Thread(new XXTStudentRunner(xxtwsService, 205000, 210000)).start();
		new Thread(new XXTStudentRunner(xxtwsService, 210000, 215000)).start();
		new Thread(new XXTStudentRunner(xxtwsService, 215000, 220000)).start();
		new Thread(new XXTStudentRunner(xxtwsService, 220000, 225000)).start();
		new Thread(new XXTStudentRunner(xxtwsService, 225000, 230000)).start();
		new Thread(new XXTStudentRunner(xxtwsService, 230000, 235000)).start();
		new Thread(new XXTStudentRunner(xxtwsService, 235000, 240000)).start();*/

		/*new Thread(new XXTStudentRunner(xxtwsService, 240000, 245000)).start();
		new Thread(new XXTStudentRunner(xxtwsService, 245000, 250000)).start();
		new Thread(new XXTStudentRunner(xxtwsService, 250000, 255000)).start();
		new Thread(new XXTStudentRunner(xxtwsService, 255000, 260000)).start();
		new Thread(new XXTStudentRunner(xxtwsService, 260000, 265000)).start();
		new Thread(new XXTStudentRunner(xxtwsService, 265000, 270000)).start();
		new Thread(new XXTStudentRunner(xxtwsService, 270000, 275000)).start();
		new Thread(new XXTStudentRunner(xxtwsService, 275000, 280000)).start();
		new Thread(new XXTStudentRunner(xxtwsService, 280000, 285000)).start();
		new Thread(new XXTStudentRunner(xxtwsService, 285000, 290000)).start();
		new Thread(new XXTStudentRunner(xxtwsService, 290000, 295000)).start();
		new Thread(new XXTStudentRunner(xxtwsService, 295000, 300000)).start();
		new Thread(new XXTStudentRunner(xxtwsService, 300000, 305000)).start();
		new Thread(new XXTStudentRunner(xxtwsService, 305000, 310000)).start();
		new Thread(new XXTStudentRunner(xxtwsService, 310000, 315000)).start();
		new Thread(new XXTStudentRunner(xxtwsService, 315000, 320000)).start();
		new Thread(new XXTStudentRunner(xxtwsService, 320000, 325000)).start();
		new Thread(new XXTStudentRunner(xxtwsService, 325000, 330000)).start();
		new Thread(new XXTStudentRunner(xxtwsService, 330000, 335000)).start();
		new Thread(new XXTStudentRunner(xxtwsService, 335000, 340000)).start();
		new Thread(new XXTStudentRunner(xxtwsService, 340000, 345000)).start();
		new Thread(new XXTStudentRunner(xxtwsService, 345000, 350000)).start();*/
		
		/*
		new Thread(new XXTStudentRunner(xxtwsService, 0, 1000)).start();
		new Thread(new XXTStudentRunner(xxtwsService, 1000, 2000)).start();
		new Thread(new XXTStudentRunner(xxtwsService, 2000, 3000)).start();
		new Thread(new XXTStudentRunner(xxtwsService, 3000, 4000)).start();
		new Thread(new XXTStudentRunner(xxtwsService, 4000, 5000)).start();
		new Thread(new XXTStudentRunner(xxtwsService, 5000, 6000)).start();
		**/
	}
}

import com.istudy.server.xxt.service.XXTWSService;




public class XXTStudentParentRunnerTest{

	public static void main(String[] args) {
		XXTWSService xxtwsService = new XXTWSService();
		//xxtwsService.getClassByStudentId("3655520", "gz");
		//new Thread(new XXTStudentParentRunner(xxtwsService, 0, 100)).start();
		//2172717
		
		new Thread(new XXTStudentParentRunner(xxtwsService, 0, 20000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 20000, 40000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 40000, 50000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 60000, 60000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 80000, 100000)).start();
		/*
		new Thread(new XXTStudentParentRunner(xxtwsService, 100000, 120000)).start();*/
		/*new Thread(new XXTStudentParentRunner(xxtwsService, 120000, 140000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 140000, 160000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 160000, 180000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 180000, 200000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 200000, 202000)).start();*/
		
		/*new Thread(new XXTStudentParentRunner(xxtwsService, 0, 10000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 10000, 20000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 20000, 30000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 30000, 40000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 40000, 50000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 50000, 60000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 60000, 70000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 70000, 80000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 80000, 90000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 90000, 100000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 100000, 110000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 110000, 120000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 120000, 130000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 130000, 140000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 140000, 150000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 150000, 160000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 160000, 170000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 170000, 180000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 180000, 190000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 190000, 200000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 200000, 210000)).start();*/
		
		
		
		/*new Thread(new XXTStudentParentRunner(xxtwsService, 210000, 300000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 300000, 400000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 400000, 500000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 500000, 600000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 600000, 700000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 700000, 800000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 800000, 900000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 900000, 1000000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 1000000, 1100000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 1100000, 1200000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 1200000, 1300000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 1300000, 1400000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 1400000, 1500000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 1500000, 1600000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 1600000, 1700000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 1700000, 1800000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 1800000, 1900000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 1900000, 2000000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 2000000, 2100000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 2100000, 2200000)).start();*/
		
	
		/*
		new Thread(new XXTStudentParentRunner(xxtwsService, 410000, 420000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 420000, 430000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 430000, 440000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 440000, 450000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 450000, 460000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 460000, 470000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 470000, 480000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 480000, 490000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 490000, 500000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 500000, 510000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 510000, 520000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 520000, 530000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 530000, 540000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 540000, 550000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 550000, 560000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 560000, 570000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 570000, 580000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 580000, 590000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 590000, 600000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 600000, 610000)).start();
		
		new Thread(new XXTStudentParentRunner(xxtwsService, 610000, 620000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 620000, 630000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 630000, 640000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 640000, 650000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 650000, 660000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 660000, 670000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 670000, 680000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 680000, 690000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 690000, 700000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 700000, 710000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 710000, 720000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 720000, 730000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 730000, 740000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 740000, 750000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 750000, 760000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 760000, 770000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 770000, 780000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 780000, 790000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 790000, 800000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 800000, 810000)).start();
		
		new Thread(new XXTStudentParentRunner(xxtwsService, 810000, 820000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 820000, 830000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 830000, 840000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 840000, 850000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 850000, 860000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 860000, 870000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 870000, 880000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 880000, 890000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 890000, 900000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 900000, 910000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 910000, 920000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 920000, 930000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 930000, 940000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 940000, 950000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 950000, 960000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 960000, 970000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 970000, 980000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 980000, 990000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 990000, 1000000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 1000000, 1010000)).start();
		
		new Thread(new XXTStudentParentRunner(xxtwsService, 1010000, 1020000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 1020000, 1030000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 1030000, 1040000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 1040000, 1050000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 1050000, 1060000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 1060000, 1070000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 1070000, 1080000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 1080000, 1090000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 1090000, 1100000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 1100000, 1110000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 1110000, 1120000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 1120000, 1130000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 1130000, 1140000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 1140000, 1150000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 1150000, 1160000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 1160000, 1170000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 1170000, 1180000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 1180000, 1190000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 1190000, 11000000)).start();
		new Thread(new XXTStudentParentRunner(xxtwsService, 1200000, 11010000)).start();
		
		*
		*/
	}
}

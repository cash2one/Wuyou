import com.istudy.server.xxt.service.XXTWSService;




public class XXTUserInfoRunnerTest{

	public static void main(String[] args) {
		XXTWSService xxtwsService = new XXTWSService();
		//new XXTWSService().getStudentInfoById("3568016", "gz");
		
		new Thread(new XXTUserInfoRunner(xxtwsService,0,2500)).start();
		/*new Thread(new XXTUserInfoRunner(xxtwsService,13073,26146)).start();
		new Thread(new XXTUserInfoRunner(xxtwsService,26146,39219)).start();
		new Thread(new XXTUserInfoRunner(xxtwsService,39219,52292)).start();
		new Thread(new XXTUserInfoRunner(xxtwsService,52292,65365)).start();
		new Thread(new XXTUserInfoRunner(xxtwsService,65365,78438)).start();
		new Thread(new XXTUserInfoRunner(xxtwsService,78438,91511)).start();
		new Thread(new XXTUserInfoRunner(xxtwsService,91511,104584)).start();
		new Thread(new XXTUserInfoRunner(xxtwsService,104584,117657)).start();
		new Thread(new XXTUserInfoRunner(xxtwsService,117657,130730)).start();
		new Thread(new XXTUserInfoRunner(xxtwsService,130730,143803)).start();
		new Thread(new XXTUserInfoRunner(xxtwsService,143803,156876)).start();
		new Thread(new XXTUserInfoRunner(xxtwsService,156876,169949)).start();
		new Thread(new XXTUserInfoRunner(xxtwsService,169949,183022)).start();
		new Thread(new XXTUserInfoRunner(xxtwsService,183022,196095)).start();
		new Thread(new XXTUserInfoRunner(xxtwsService,196095,209168)).start();
		new Thread(new XXTUserInfoRunner(xxtwsService,209168,222241)).start();
		new Thread(new XXTUserInfoRunner(xxtwsService,222241,235314)).start();
		new Thread(new XXTUserInfoRunner(xxtwsService,235314,248387)).start();
		new Thread(new XXTUserInfoRunner(xxtwsService,248387,261460)).start();
		new Thread(new XXTUserInfoRunner(xxtwsService,261460,274533)).start();
		new Thread(new XXTUserInfoRunner(xxtwsService,274533,287606)).start();
		new Thread(new XXTUserInfoRunner(xxtwsService,287606,300679)).start();
		new Thread(new XXTUserInfoRunner(xxtwsService,300679,313752)).start();
		new Thread(new XXTUserInfoRunner(xxtwsService,313752,326825)).start();
		new Thread(new XXTUserInfoRunner(xxtwsService,326825,339898)).start();
		new Thread(new XXTUserInfoRunner(xxtwsService,339898,352971)).start();
		new Thread(new XXTUserInfoRunner(xxtwsService,352971,366044)).start();
		new Thread(new XXTUserInfoRunner(xxtwsService,366044,379117)).start();
		new Thread(new XXTUserInfoRunner(xxtwsService,379117,392190)).start();
		new Thread(new XXTUserInfoRunner(xxtwsService,392190,405263)).start();
		new Thread(new XXTUserInfoRunner(xxtwsService,405263,418336)).start();
		new Thread(new XXTUserInfoRunner(xxtwsService,418336,431409)).start();
		new Thread(new XXTUserInfoRunner(xxtwsService,431409,444482)).start();
		new Thread(new XXTUserInfoRunner(xxtwsService,444482,457555)).start();
		new Thread(new XXTUserInfoRunner(xxtwsService,457555,470628)).start();
		new Thread(new XXTUserInfoRunner(xxtwsService,470628,483701)).start();
		new Thread(new XXTUserInfoRunner(xxtwsService,483701,496774)).start();
		new Thread(new XXTUserInfoRunner(xxtwsService,496774,509847)).start();
		new Thread(new XXTUserInfoRunner(xxtwsService,509847,522920)).start();
		new Thread(new XXTUserInfoRunner(xxtwsService,522920,535993)).start();
		new Thread(new XXTUserInfoRunner(xxtwsService,535993,549066)).start();
		new Thread(new XXTUserInfoRunner(xxtwsService,549066,562139)).start();
		new Thread(new XXTUserInfoRunner(xxtwsService,562139,575212)).start();
		new Thread(new XXTUserInfoRunner(xxtwsService,575212,588285)).start();
		new Thread(new XXTUserInfoRunner(xxtwsService,588285,588308)).start();*/

	}
}

import java.util.Arrays;



public class ThreadBuilder {

	public static int size = 60;
	
	public static void builder(String format, int total) {
		int no = total / size;
		int pre = 0;
		int i = no;
		for(; i < total; i+= no){
			print(format,pre,i);
			pre = i;
		}
		if(i - no < total){
			print(format,pre,total);
		}
	}
	
	public static void print(String format, int start, int end) {
		System.out.printf(format, (start) + "," + (end));
		System.out.println();
	}
	
	public static void main(String[] args) {
		//小六
		builder("new Thread(new ShortUrlConverter(%s)).start();",11386270);
		//高二
		//builder("new Thread(new ShortUrlConverter(%s)).start();",350326);
		//高三
		//builder("new Thread(new ShortUrlConverter(%s)).start();",324849);
		//初三 广州
		//builder("new Thread(new ShortUrlConverter(%s)).start();",60015);
		//初三
		//builder("new Thread(new ShortUrlConverter(%s)).start();",588309);
		//高一
		//builder("new Thread(new ShortUrlConverter(%s)).start();",390963);
		
		
		//builder("new Thread(new XXTUserInfoRunner(xxtwsService,%s)).start();",76710);
		
		//初三
		//builder("new Thread(new XXTUserInfoRunner(xxtwsService,%s)).start();",588308);
		//高二
		//builder("new Thread(new XXTUserInfoRunner(xxtwsService,%s)).start();",350326);
		
		//System.out.println(Arrays.asList(",|zs,|dg,|zq,|gz,|sz,|fs,|zh,|hz,|jm,|sg,|hy,|mz,|sw,|yj,|zj,|mm,|qy,|cz,|jy,|yf,|st,".split(",")));
		//System.out.println(Arrays.asList("|zs".split("\\|")));
	}

}

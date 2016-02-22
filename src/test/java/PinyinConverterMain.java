import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;



public class PinyinConverterMain {

	public static void main(String[] args) throws BadHanyuPinyinOutputFormatCombination {
		//new Thread(new PinyinConverter(0, 10)).start();
		new Thread(new PinyinConverter(0, 6000)).start();
		//new Thread(new PinyinConverter(100000, 200000)).start();
		//new Thread(new PinyinConverter(200000, 280000)).start();
	}
	
	
}

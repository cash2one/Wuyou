import java.util.Arrays;
import java.util.Comparator;


public class SimpleComparator implements Comparator{

	@Override
	 public int compare(Object o1, Object o2) {
	    return toInt(o1) - toInt(o2);
	  }

	 private int toInt(Object o) {
		String str = (String) o;
	    str = str.replaceAll("一", "1");
		str = str.replaceAll("二", "2");
	    str = str.replaceAll("三", "3");
		return Integer.parseInt(str);
	}
	
	 public static void main(String[] args) {
		    String[] array = new String[] { "一二", "三", "二", "三" };
		    Arrays.sort(array, new SimpleComparator());
		    for (int i = 0; i < array.length; i++) {
		      System.out.println(array[i]);
		    }
		  }
}

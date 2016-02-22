import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Encoder;


public class ShortUrlTest {

	public static int i = 0;

	public static void main(String[] args) throws Exception {

		/*new Thread(new ShortUrlConverter(0,61012)).start();*/
		
		new Thread(new ShortUrlConverter(0,189771)).start();
		new Thread(new ShortUrlConverter(189771,379542)).start();
		new Thread(new ShortUrlConverter(379542,569313)).start();
		new Thread(new ShortUrlConverter(569313,759084)).start();
		new Thread(new ShortUrlConverter(759084,948855)).start();
		new Thread(new ShortUrlConverter(948855,1138626)).start();
		new Thread(new ShortUrlConverter(1138626,1328397)).start();
		new Thread(new ShortUrlConverter(1328397,1518168)).start();
		new Thread(new ShortUrlConverter(1518168,1707939)).start();
		new Thread(new ShortUrlConverter(1707939,1897710)).start();
		new Thread(new ShortUrlConverter(1897710,2087481)).start();
		new Thread(new ShortUrlConverter(2087481,2277252)).start();
		new Thread(new ShortUrlConverter(2277252,2467023)).start();
		new Thread(new ShortUrlConverter(2467023,2656794)).start();
		new Thread(new ShortUrlConverter(2656794,2846565)).start();
		new Thread(new ShortUrlConverter(2846565,3036336)).start();
		new Thread(new ShortUrlConverter(3036336,3226107)).start();
		new Thread(new ShortUrlConverter(3226107,3415878)).start();
		new Thread(new ShortUrlConverter(3415878,3605649)).start();
		new Thread(new ShortUrlConverter(3605649,3795420)).start();
		new Thread(new ShortUrlConverter(3795420,3985191)).start();
		new Thread(new ShortUrlConverter(3985191,4174962)).start();
		new Thread(new ShortUrlConverter(4174962,4364733)).start();
		new Thread(new ShortUrlConverter(4364733,4554504)).start();
		new Thread(new ShortUrlConverter(4554504,4744275)).start();
		new Thread(new ShortUrlConverter(4744275,4934046)).start();
		new Thread(new ShortUrlConverter(4934046,5123817)).start();
		new Thread(new ShortUrlConverter(5123817,5313588)).start();
		new Thread(new ShortUrlConverter(5313588,5503359)).start();
		new Thread(new ShortUrlConverter(5503359,5693130)).start();
		new Thread(new ShortUrlConverter(5693130,5882901)).start();
		new Thread(new ShortUrlConverter(5882901,6072672)).start();
		new Thread(new ShortUrlConverter(6072672,6262443)).start();
		new Thread(new ShortUrlConverter(6262443,6452214)).start();
		new Thread(new ShortUrlConverter(6452214,6641985)).start();
		new Thread(new ShortUrlConverter(6641985,6831756)).start();
		new Thread(new ShortUrlConverter(6831756,7021527)).start();
		new Thread(new ShortUrlConverter(7021527,7211298)).start();
		new Thread(new ShortUrlConverter(7211298,7401069)).start();
		new Thread(new ShortUrlConverter(7401069,7590840)).start();
		new Thread(new ShortUrlConverter(7590840,7780611)).start();
		new Thread(new ShortUrlConverter(7780611,7970382)).start();
		new Thread(new ShortUrlConverter(7970382,8160153)).start();
		new Thread(new ShortUrlConverter(8160153,8349924)).start();
		new Thread(new ShortUrlConverter(8349924,8539695)).start();
		new Thread(new ShortUrlConverter(8539695,8729466)).start();
		new Thread(new ShortUrlConverter(8729466,8919237)).start();
		new Thread(new ShortUrlConverter(8919237,9109008)).start();
		new Thread(new ShortUrlConverter(9109008,9298779)).start();
		new Thread(new ShortUrlConverter(9298779,9488550)).start();
		new Thread(new ShortUrlConverter(9488550,9678321)).start();
		new Thread(new ShortUrlConverter(9678321,9868092)).start();
		new Thread(new ShortUrlConverter(9868092,10057863)).start();
		new Thread(new ShortUrlConverter(10057863,10247634)).start();
		new Thread(new ShortUrlConverter(10247634,10437405)).start();
		new Thread(new ShortUrlConverter(10437405,10627176)).start();
		new Thread(new ShortUrlConverter(10627176,10816947)).start();
		new Thread(new ShortUrlConverter(10816947,11006718)).start();
		new Thread(new ShortUrlConverter(11006718,11196489)).start();
		new Thread(new ShortUrlConverter(11196489,11386260)).start();
		new Thread(new ShortUrlConverter(11386260,11386278)).start();



	}
	
    /**
     * 加密
     * 
     * @param content 需要加密的内容
     * @param password  加密密码
     * @return
     * @throws NoSuchPaddingException 
     * @throws NoSuchAlgorithmException 
     */
    public static String encrypt(String sSrc, String sKey) throws Exception {
    	
    	if (sKey == null) {
            System.out.print("Key为空null");
            return null;
        }
        // 判断Key是否为16位
        if (sKey.length() != 16) {
            System.out.print("Key长度不是16位");
            return null;
        }
        byte[] raw = sKey.getBytes();
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");//"算法/模式/补码方式"
        IvParameterSpec iv = new IvParameterSpec("0102030405060708".getBytes());//使用CBC模式，需要一个向量iv，可增加加密算法的强度
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
        byte[] encrypted = cipher.doFinal(sSrc.getBytes());

        return new BASE64Encoder().encode(encrypted);//此处使用BASE64做转码功能，同时能起到2次加密的作用。
    }
}

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TimerTask;
import java.util.regex.Matcher;

import com.istudy.server.common.utils.HttpUtils;


public class ShortUrlConverter extends TimerTask{

	private int start;
	private final int end;
	
	public ShortUrlConverter(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}

	@Override
	public void run() {
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			try {
				connection = DriverManager.getConnection("jdbc:mysql://10.10.10.201:3306/istudy_cms_dev?useUnicode=true&amp;characterEncoding=utf8&amp;autoReconnect=true&amp;failOverReadOnly=false","istudy","istudy");
				ps = connection.prepareStatement("select ID,USERID,cityID from tmp_short_url_20150204 where id >= ? and id < ? and url is null",ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
				/*ps = connection.prepareStatement("select ID,USERID,cityID from tmp_short_url_20150204 where url is null",ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);*/
				//ps = connection.prepareStatement("select ID,HEX(PHONE+0) PHONE from tmp_istudy_phone_msg order by id limit ?,?",ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
				//ps = connection.prepareStatement("select ID,userid,cityID from tmp_user_id_short_url_xiaoxue order by id limit ?,?",ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
				while(true){
					int realSize = Math.min(end - start,TestConstants.size);
					int[] ids = new int[realSize];
					String[] urls = new String[realSize];
					
					ps.setInt(1, start);
					ps.setInt(2, start + realSize);
					ResultSet rs = ps.executeQuery();
					int index = 0;
					while(rs.next()){
						int id = rs.getInt("ID");
						int userid = rs.getInt("userId");
						String cityId = rs.getString("cityID");
						//String phone = rs.getString("PHONE");
						String url = this.convertUrl(userid + "", cityId);
						ids[index] = id;
						urls[index] = url;
						index++;
					}
					rs.close();
					updateShortUrls(connection, ids, urls);
					start += TestConstants.size;
					if(start >= end){
						break;
					}
				}
				
				
			
			} finally{
				ps.close();
				connection.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	private String convertUrl(String userid, String cityId) throws UnsupportedEncodingException{
		//http://wuyou.istudy.com.cn/xxtM/0/0/24/13980680422712.do
		//http://wuyou.istudy.com.cn/xxtM/0/0/32/14005772105707.do
		//http://wuyou.istudy.com.cn/xxtM/0/0/34/14008119739339.do
		//http://wuyou.istudy.com.cn/xxtM/0/0/38/lmyj/onefoot.do
		
		//http://xiaoyuan.istudy.com.cn/2015card/vote.html?id=&cityId=
		
		//108/14024642905669.do
		
		String url = String.format("http://xiaoyuan.istudy.com.cn/2015card/vote.html?id=%s&cityId=%s", userid, cityId);

		//Form form = new Form();
		//form.set("url", url.toString());
		String requestUrl = "http://api.t.sina.com.cn/short_url/shorten.json?source=1146580825&url_long=" + URLEncoder.encode(url,"UTF-8");
		try {
			String doPost = HttpUtils.doGet(requestUrl, "", String.class);
			Matcher mc = TestConstants.SINA_URL_PATT.matcher(doPost);
			if(mc.find()){
				return mc.group(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private void updateShortUrls(Connection connection, int[] ids, String[] urls) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("update tmp_short_url_20150204 set url = ? where id = ?");
		for(int i = 0; i < ids.length; i++){
			int id = ids[i];
			String url = urls[i];
			if(id != 0 && url != null){
				ps.setString(1, url);
				ps.setInt(2, id);
				ps.addBatch();
				System.out.println(++ShortUrlTest.i);
			}
		}
		ps.executeBatch();
	}
	
	/*private String convertUrl(String phone) {
		StringBuilder url = new StringBuilder("http://wuyou.istudy.com.cn/i/");
		url.append(phone);
		url.append("/12/13963435417870.do");
		
		//Form form = new Form();
		//form.set("url", url.toString());
		String requestUrl = "http://api.t.sina.com.cn/short_url/shorten.json?source=1146580825&url_long=" + url.toString();
		try {
			String doPost = HttpUtils.doGet(requestUrl, "", String.class);
			Matcher mc = TestConstants.SINA_URL_PATT.matcher(doPost);
			if(mc.find()){
				return mc.group(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private void updateShortUrls2(Connection connection, int[] ids, String[] urls) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("update tmp_istudy_phone_msg set url = ? where id = ?");
		for(int i = 0; i < ids.length; i++){
			int id = ids[i];
			String url = urls[i];
			if(id != 0 && url != null){
				ps.setString(1, url);
				ps.setInt(2, id);
				ps.addBatch();
				System.out.println(++ShortUrlTest.i);
			}
		}
		ps.executeBatch();
	}*/
}

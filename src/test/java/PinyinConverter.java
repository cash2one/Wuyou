import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TimerTask;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import com.istudy.server.common.utils.CommonUtils;


public class PinyinConverter extends TimerTask{

	private int start;
	private final int end;
	
	private HanyuPinyinOutputFormat fmt = new HanyuPinyinOutputFormat();
	
	public PinyinConverter(int start, int end) {
		super();
		this.start = start;
		this.end = end;
		fmt.setCaseType(HanyuPinyinCaseType.UPPERCASE);
		fmt.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
	}

	@Override
	public void run() {
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://10.0.0.170:3306/istudy_cms_dev?useUnicode=true&amp;characterEncoding=utf8&amp;autoReconnect=true&amp;failOverReadOnly=false","istudy","istudy");
				ps = connection.prepareStatement("select id,name from tizi_xxtschool_updated limit ?,?",ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
				//ps = connection.prepareStatement("select ID,HEX(PHONE+0) PHONE from tmp_istudy_phone_msg order by id limit ?,?",ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
				while(true){
					int realSize = Math.min(end - start,TestConstants.size);
					int[] ids = new int[realSize];
					String[] pys = new String[realSize];
					
					ps.setInt(1, start);
					ps.setInt(2, realSize);
					ResultSet rs = ps.executeQuery();
					int index = 0;
					while(rs.next()){
						int id = rs.getInt("id");
						String schoolname = rs.getString("name");
						String py = this.getFirstPinyin(schoolname,id);
						ids[index] = id;
						pys[index] = py;
						index++;
					}
					rs.close();
					update(connection, ids, pys);
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
	

	private String getFirstPinyin(String str,int id){
		if(CommonUtils.isNull(str)){
			return null;
		}
		char fc = str.charAt(0);
		try {
			String[] pys = PinyinHelper.toHanyuPinyinStringArray(fc, fmt);
			if(pys != null && pys.length > 0){
				Set<String> sets = new LinkedHashSet<String>();
				for(String py : pys){
					sets.add(py.charAt(0) + "");
				}
				//System.out.println(sets.toString().replaceAll("[\\[\\]]", ""));
				return sets.toString().replaceAll("[\\[\\]]", "");
			}else{
				System.out.println("failed: " + str + "["+id+"]");
				return (fc + "").toUpperCase();
			}
			
		} catch (BadHanyuPinyinOutputFormatCombination e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private void update(Connection connection, int[] ids, String[] pys) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("update tizi_xxtschool_updated set firstLetter = ? where id = ?");
		for(int i = 0; i < ids.length; i++){
			int id = ids[i];
			String py = pys[i];
			if(id != 0 && py != null){
				ps.setString(1, py);
				ps.setInt(2, id);
				ps.addBatch();
				++ShortUrlTest.i;
				if(ShortUrlTest.i % 10000 == 0){
					System.out.println(ShortUrlTest.i);
				}
			}
		}
		ps.executeBatch();
	}
}

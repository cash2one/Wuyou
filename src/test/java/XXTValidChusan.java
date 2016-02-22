import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.istudy.server.xxt.service.XXTWSService;
import com.istudy.server.xxt.vo.ParentVO;
import com.istudy.server.xxt.vo.StudentVO;



public class XXTValidChusan implements Runnable{
	
	private int start;
	private final int end;

	private XXTWSService xxtwsService;
	
	public XXTValidChusan(XXTWSService xxtwsService, int start, int end) {
		this.start = start;
		this.end = end;
		this.xxtwsService = xxtwsService;
	}
	
	@Override
	public void run() {
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://10.0.0.170:3306/istudy_cms_dev?useUnicode=true&amp;characterEncoding=utf8&amp;autoReconnect=true&amp;failOverReadOnly=false","istudy","istudy");
				ps = connection.prepareStatement("select ID,userid,CITYID from tmp_user_id_short_url_chusan where grades is null order by id limit ?,?",ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
				while(true){
					int realSize = Math.min(end - start,TestConstants.size);
					StudentVO[] vos = new StudentVO[realSize];
					
					ps.setInt(1, start);
					ps.setInt(2, realSize);
					ResultSet rs = ps.executeQuery();
					int index = 0;
					while(rs.next()){
						int id = rs.getInt("ID");
						String studentId = rs.getString("userid");
						String cityId = rs.getString("CITYID");
						StudentVO studentVO = this.queryBaseInfo(studentId, cityId, id);
						if(studentVO != null){
							studentVO.setId(id);
							vos[index] = studentVO;
						}
						index++;
					}
					rs.close();
					updateStudentBaseInfo(connection, vos);
					start += TestConstants.size;
					if(start >= end){
						break;
					}
				}
				
				
			
			} finally{
				if(ps != null){
					ps.close();
				}
				if(connection != null){
					connection.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void updateStudentBaseInfo(Connection connection, StudentVO[] vos) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("update tmp_user_id_short_url_chusan set grades = ? where id = ?");
		
		for(StudentVO vo : vos){
			ps.setString(1, vo.getBank());
			ps.setInt(2, vo.getId());
			
			ps.addBatch();
		}
		
		ps.executeBatch();
		
		ps.close();
	}
	
	public StudentVO queryBaseInfo(String studentId,String cityId, int id){
		StudentVO studentVO = null;
		try {
			studentVO = xxtwsService.getStudentInfoById(studentId, cityId);
			studentVO.setId(id);
			//QrySchoolResponse school = xxtwsService.getSchoolById(studentVO.getSchoolId());
			//studentVO.setSchoolName(school.getSchoolName());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return studentVO;
	}
}

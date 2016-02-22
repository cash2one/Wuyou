import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.istudy.server.xxt.service.XXTWSService;
import com.istudy.server.xxt.vo.TeacherVO;



public class XXTTeacherRunner implements Runnable{
	
	private int start;
	private final int end;

	private XXTWSService xxtwsService;
	
	public XXTTeacherRunner(XXTWSService xxtwsService, int start, int end) {
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
				ps = connection.prepareStatement("select SCHOOLID,cityId from tmp_xxt_teacher_fail where reason = 6 limit ?,?",ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
				while(true){
					int realSize = Math.min(end - start,TestConstants.size);
					List<List<TeacherVO>> vos = new ArrayList<List<TeacherVO>>(realSize);
					List<TeacherVO> failVos = new ArrayList<TeacherVO>();
					
					ps.setInt(1, start);
					ps.setInt(2, realSize);
					ResultSet rs = ps.executeQuery();
					while(rs.next()){
						String schoolId = rs.getString("SCHOOLID");
						String cityId = rs.getString("cityId");
						List<TeacherVO> teas = this.queryInfo(schoolId, cityId);
						if(teas != null){
							vos.add(teas);
						}else{
							TeacherVO fail = new TeacherVO();
							fail.setCityId(cityId);
							fail.setSchoolId(schoolId);
							failVos.add(fail);
						}
					}
					rs.close();
					updateInfo(connection, vos, failVos);
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
	
	private void updateInfo(Connection connection, List<List<TeacherVO>> vos,
			List<TeacherVO> failVos) {
		PreparedStatement insertPs = null;
		PreparedStatement failPs = null;
		try {
			try {
				insertPs = connection.prepareStatement("insert into xxt_teacher(teacherId,teacherName,loginName,headImage,email,schoolId,cityId) values(?,?,?,?,?,?,?)");
				for(List<TeacherVO> lvo : vos){
					if(lvo != null){
						for(TeacherVO cvo : lvo){
							insertPs.setString(1, cvo.getTeacherId());
							insertPs.setString(2, cvo.getTeacherName());
							insertPs.setString(3, cvo.getLoginName());
							insertPs.setString(4, cvo.getHeadImage());
							insertPs.setString(5, cvo.getEmail());
							insertPs.setString(6, cvo.getSchoolId());
							insertPs.setString(7, cvo.getCityId());
							
							insertPs.addBatch();
						}
					}
					System.out.println(++XXTTeacherMain.i);
				}
				insertPs.executeBatch();
				
				failPs = connection.prepareStatement("insert into tmp_xxt_teacher_fail(schoolId,cityId,reason) values(?,?,7)");
				for(TeacherVO fail : failVos){
					failPs.setString(1, fail.getSchoolId());
					failPs.setString(2, fail.getCityId());
					
					failPs.addBatch();
				}
				failPs.executeBatch();
			} finally {
				if(insertPs != null){
					insertPs.close();
				}
				if(failPs != null){
					failPs.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<TeacherVO> queryInfo(String schoolId, String cityId){
		List<TeacherVO> teas = null;
		try {
			teas = xxtwsService.getTeachersBySchool(schoolId, cityId);
			//QrySchoolResponse school = xxtwsService.getSchoolById(studentVO.getSchoolId());
			//studentVO.setSchoolName(school.getSchoolName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return teas;
	}
}

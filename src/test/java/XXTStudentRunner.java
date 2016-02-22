import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.istudy.server.xxt.service.XXTWSService;
import com.istudy.server.xxt.vo.ClassVO;
import com.istudy.server.xxt.vo.ParentVO;
import com.istudy.server.xxt.vo.StudentVO;



public class XXTStudentRunner implements Runnable{
	
	private int start;
	private final int end;

	private XXTWSService xxtwsService;
	
	public XXTStudentRunner(XXTWSService xxtwsService, int start, int end) {
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
				ps = connection.prepareStatement("select classid,cityId from tmp_xxt_class_fail where reason = 2 limit ?,?",ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
				while(true){
					int realSize = Math.min(end - start,TestConstants.size);
					List<List<StudentVO>> vos = new ArrayList<List<StudentVO>>(realSize);
					List<StudentVO> failedVos = new ArrayList<StudentVO>();
					
					ps.setInt(1, start);
					ps.setInt(2, realSize);
					ResultSet rs = ps.executeQuery();
					while(rs.next()){
						String classid = rs.getString("classid");
						String cityId = rs.getString("cityId");
						List<StudentVO> stus = this.queryInfo(classid, cityId);
						if(stus == null){
							StudentVO failedvo = new StudentVO();
							failedvo.setClassId(classid);
							failedvo.setCityId(cityId);
							failedVos.add(failedvo);
						}else{
							vos.add(stus);
						}
					}
					rs.close();
					updateInfo(connection, vos, failedVos);
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
	
	private void updateInfo(Connection connection, List<List<StudentVO>> vos,
			List<StudentVO> failedVos) {
		PreparedStatement insertPs = null;
		PreparedStatement insertFaildPs = null;
		try {
			try {
				insertPs = connection.prepareStatement("insert into xxt_student_all(classId,className,gradeId,gradeName,studentName,studentId,studentseq,loginName,cityId) values(?,?,?,?,?,?,?,?,?)");
				insertFaildPs = connection.prepareStatement("insert into tmp_xxt_class_fail(classId,cityId,reason) values(?,?,3)");
				for(List<StudentVO> lvo : vos){
					if(lvo != null){
						for(StudentVO svo : lvo){
							insertPs.setString(1, svo.getClassId());
							insertPs.setString(2, svo.getClassName());
							insertPs.setString(3, svo.getGradeId());
							insertPs.setString(4, svo.getGradeName());
							insertPs.setString(5, svo.getStudentName());
							insertPs.setString(6, svo.getStudentId());
							insertPs.setString(7, svo.getStudentSeq());
							insertPs.setString(8, svo.getLoginName());
							insertPs.setString(9, svo.getCityId());
							
							insertPs.addBatch();
						}
					}
					System.out.println(++XXTClassMain.i);
				}
				insertPs.executeBatch();
				
				for(StudentVO vo : failedVos){
					insertFaildPs.setString(1, vo.getClassId());
					insertFaildPs.setString(2, vo.getCityId());
					
					insertFaildPs.addBatch();
				}
				insertFaildPs.executeBatch();
				
			} finally {
				if(insertPs != null){
					insertPs.close();
				}
				if(insertFaildPs != null){
					insertFaildPs.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<StudentVO> queryInfo(String classId, String cityId){
		List<StudentVO> stus = null;
		try {
			stus = xxtwsService.getStudentsByClass(classId, cityId);
			//QrySchoolResponse school = xxtwsService.getSchoolById(studentVO.getSchoolId());
			//studentVO.setSchoolName(school.getSchoolName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stus;
	}
}

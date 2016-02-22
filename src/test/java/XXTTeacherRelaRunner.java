import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.istudy.server.xxt.service.XXTWSService;
import com.istudy.server.xxt.vo.SubjectVO;
import com.istudy.server.xxt.vo.TeacherVO;



public class XXTTeacherRelaRunner implements Runnable{
	
	private int start;
	private final int end;

	private XXTWSService xxtwsService;
	
	public XXTTeacherRelaRunner(XXTWSService xxtwsService, int start, int end) {
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
				ps = connection.prepareStatement("select classId from tmp_xxt_class_teacher_rela_fail where reason = 1 limit ?,?",ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
				while(true){
					int realSize = Math.min(end - start,TestConstants.size);
					List<List<TeacherVO>> vos = new ArrayList<List<TeacherVO>>(realSize);
					List<String> faidClassIds = new ArrayList<String>();
					
					ps.setInt(1, start);
					ps.setInt(2, realSize);
					ResultSet rs = ps.executeQuery();
					while(rs.next()){
						String classId = rs.getString("classId");
						List<TeacherVO> teas = this.queryInfo(classId);
						if(teas != null){
							vos.add(teas);
						}else{
							faidClassIds.add(classId);
						}
					}
					rs.close();
					updateInfo(connection, vos, faidClassIds);
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
			List<String> faidClassIds) {
		PreparedStatement insertPs = null;
		PreparedStatement insertSubjectPs = null;
		PreparedStatement failPs = null;
		try {
			try {
				insertPs = connection.prepareStatement("insert into xxt_class_teacher_rela(classId,teacherId) values(?,?)");
				insertSubjectPs = connection.prepareStatement("insert into xxt_teacher_subject_rela(teacherId, subjectId, subjectName) values(?,?,?)");
				for(List<TeacherVO> lvo : vos){
					if(lvo != null){
						for(TeacherVO cvo : lvo){
							insertPs.setString(1, cvo.getClassId());
							insertPs.setString(2, cvo.getTeacherId());
							
							insertPs.addBatch();
							
							List<SubjectVO> subjects = cvo.getSubjects();
							if(subjects != null){
								for(SubjectVO subvo : subjects){
									insertSubjectPs.setString(1, cvo.getTeacherId());
									insertSubjectPs.setString(2, subvo.getSubjectId());
									insertSubjectPs.setString(3, subvo.getSubjectName());
									
									insertSubjectPs.addBatch();
								}
							}
						}
					}
					System.out.println(++XXTTeacherMain.i);
				}
				insertPs.executeBatch();
				insertSubjectPs.executeBatch();
				
				failPs = connection.prepareStatement("insert into tmp_xxt_class_teacher_rela_fail(classId,reason) values(?,2)");
				for(String fail : faidClassIds){
					failPs.setString(1, fail);
					
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
	
	public List<TeacherVO> queryInfo(String classId){
		List<TeacherVO> teas = null;
		try {
			teas = xxtwsService.getTeachersByClassId(classId);
			//QrySchoolResponse school = xxtwsService.getSchoolById(studentVO.getSchoolId());
			//studentVO.setSchoolName(school.getSchoolName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return teas;
	}
}

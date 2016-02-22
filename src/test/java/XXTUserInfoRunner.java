import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.istudy.server.xxt.service.XXTWSService;
import com.istudy.server.xxt.vo.ParentVO;
import com.istudy.server.xxt.vo.StudentVO;



public class XXTUserInfoRunner implements Runnable{
	
	private int start;
	private final int end;

	private XXTWSService xxtwsService;
	
	public XXTUserInfoRunner(XXTWSService xxtwsService, int start, int end) {
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
				ps = connection.prepareStatement("select ID,studentID,CITYID from tmp_xxt_student_chusan_failed where version = 0 order by id limit ?,?",ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
				while(true){
					int realSize = Math.min(end - start,TestConstants.size);
					StudentVO[] vos = new StudentVO[realSize];
					List<StudentVO> failVos = new ArrayList<StudentVO>();
					
					ps.setInt(1, start);
					ps.setInt(2, realSize);
					ResultSet rs = ps.executeQuery();
					int index = 0;
					while(rs.next()){
						int id = rs.getInt("ID");
						String studentId = rs.getString("studentID");
						String cityId = rs.getString("CITYID");
						StudentVO studentVO = this.queryBaseInfo(studentId, cityId);
						if(studentVO != null){
							studentVO.setId(id);
							vos[index] = studentVO;
						}else{
							studentVO = new StudentVO();
							studentVO.setCityId(cityId);
							studentVO.setStudentId(studentId);
							studentVO.setId(id);
							
							failVos.add(studentVO);
						}
						index++;
					}
					rs.close();
					try {
						updateStudentBaseInfo(connection, vos, failVos);
					} catch (Exception e) {
						e.printStackTrace();
					}
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
	
	private void updateStudentBaseInfo2(Connection connection, StudentVO[] vos, List<StudentVO> failVos) throws SQLException {
		StringBuilder updateSql = new StringBuilder();
		updateSql.append("update tmp_original_0616 SET studentName = ?,");
		updateSql.append("		  areaId = ?,");
		updateSql.append("		  areaName = ?,");
		updateSql.append("		  townId = ?,");
		updateSql.append("		  townName = ?,");
		updateSql.append("		  schoolId = ?,");
		updateSql.append("		  schoolName = ?,");
		updateSql.append("		  classId = ?,");
		updateSql.append("		  className = ?");
		updateSql.append("		WHERE id = ?");
		PreparedStatement ps = connection.prepareStatement(updateSql.toString());
		//PreparedStatement insertPs = connection.prepareStatement("insert into xxt_parent_xiaoliu(parentId,parentName,studentId,cityId,parentLoginName,email,headImage) values(?,?,?,?,?,?,?)");
		//PreparedStatement failedPs = connection.prepareStatement("insert into tmp_xxt_student_xiaoliu_failed(id,cityid,studentId,version) values (?,?,?,0)");
		for(StudentVO vo : vos){
			if(vo != null){
				ps.setString(1, vo.getStudentName());
				ps.setString(2, vo.getAreaId());
				ps.setString(3, vo.getAreaName());
				ps.setString(4, vo.getTownId());
				ps.setString(5, vo.getTownName());
				ps.setString(6, vo.getSchoolId());
				ps.setString(7, vo.getSchoolName());
				ps.setString(8, vo.getClassId());
				ps.setString(9, vo.getClassName());
				
				ps.setInt(10, vo.getId());
				ps.addBatch();
				System.out.println(++ShortUrlTest.i);
				
				/*List<ParentVO> parents = vo.getParents();
				for(ParentVO parent : parents){
					insertPs.setString(1, parent.getParentId());
					insertPs.setString(2, parent.getParentName());
					insertPs.setString(3, parent.getStudentId());
					insertPs.setString(4, parent.getCityId());
					insertPs.setString(5, parent.getParentLoginName());
					insertPs.setString(6, parent.getEmail());
					insertPs.setString(7, parent.getHeadImg());
					insertPs.addBatch();
				}*/
			}
		}
		ps.executeBatch();
		ps.close();
		
		/*insertPs.executeBatch();
		insertPs.close();*/
		
	/*	if(failVos.size() > 0){
			for(StudentVO vo : failVos){
				failedPs.setInt(1, vo.getId());
				failedPs.setString(2, vo.getCityId());
				failedPs.setString(3, vo.getStudentId());
				
				failedPs.addBatch();
			}
			failedPs.executeBatch();
			failedPs.close();
		}*/
	}
	
	private void updateStudentBaseInfo(Connection connection, StudentVO[] vos, List<StudentVO> failVos) throws SQLException {
		StringBuilder updateSql = new StringBuilder();
		updateSql.append("update xxt_student_chusan SET studentName = ?,");
		updateSql.append("		  areaId = ?,");
		updateSql.append("		  areaName = ?,");
		updateSql.append("		  townId = ?,");
		updateSql.append("		  townName = ?,");
		updateSql.append("		  schoolId = ?,");
		updateSql.append("		  schoolName = ?,");
		updateSql.append("		  section = ?,");
		updateSql.append("		  gradeId = ?,");
		updateSql.append("		  gradeName = ?,");
		updateSql.append("		  bank = ?,");
		updateSql.append("		  classId = ?,");
		updateSql.append("		  className = ?,");
		updateSql.append("		  classSchoolId = ?,");
		updateSql.append("		  classType = ?,");
		updateSql.append("		  studentSeq = ?,");
		updateSql.append("		  loginName = ?,");
		updateSql.append("		  email = ?,");
		updateSql.append("		  headImage = ?");
		updateSql.append("		WHERE id = ?");
		PreparedStatement ps = connection.prepareStatement(updateSql.toString());
		//PreparedStatement insertPs = connection.prepareStatement("insert into xxt_parent_xiaoliu(parentId,parentName,studentId,cityId,parentLoginName,email,headImage) values(?,?,?,?,?,?,?)");
		PreparedStatement failedPs = connection.prepareStatement("insert into tmp_xxt_student_chusan_failed(id,cityid,studentId,version) values (?,?,?,1)");
		for(StudentVO vo : vos){
			if(vo != null){
				ps.setString(1, vo.getStudentName());
				ps.setString(2, vo.getAreaId());
				ps.setString(3, vo.getAreaName());
				ps.setString(4, vo.getTownId());
				ps.setString(5, vo.getTownName());
				ps.setString(6, vo.getSchoolId());
				ps.setString(7, vo.getSchoolName());
				ps.setString(8, vo.getSection());
				ps.setString(9, vo.getGradeId());
				ps.setString(10, vo.getGradeName());
				ps.setString(11, vo.getBank());
				ps.setString(12, vo.getClassId());
				ps.setString(13, vo.getClassName());
				ps.setString(14, vo.getClassSchoolId());
				ps.setString(15, vo.getClassType());
				ps.setString(16, vo.getStudentSeq());
				ps.setString(17, vo.getLoginName());
				ps.setString(18, vo.getEmail());
				ps.setString(19, vo.getHeadImage());
				
				ps.setInt(20, vo.getId());
				ps.addBatch();
				System.out.println(++ShortUrlTest.i);
				
				/*List<ParentVO> parents = vo.getParents();
				for(ParentVO parent : parents){
					insertPs.setString(1, parent.getParentId());
					insertPs.setString(2, parent.getParentName());
					insertPs.setString(3, parent.getStudentId());
					insertPs.setString(4, parent.getCityId());
					insertPs.setString(5, parent.getParentLoginName());
					insertPs.setString(6, parent.getEmail());
					insertPs.setString(7, parent.getHeadImg());
					insertPs.addBatch();
				}*/
			}
		}
		ps.executeBatch();
		ps.close();
		
		/*insertPs.executeBatch();
		insertPs.close();*/
		
		if(failVos.size() > 0){
			for(StudentVO vo : failVos){
				failedPs.setInt(1, vo.getId());
				failedPs.setString(2, vo.getCityId());
				failedPs.setString(3, vo.getStudentId());
				
				failedPs.addBatch();
			}
			failedPs.executeBatch();
			failedPs.close();
		}
	}
	
	public StudentVO queryBaseInfo(String studentId,String cityId){
		StudentVO studentVO = null;
		try {
			studentVO = xxtwsService.getStudentInfoById(studentId, cityId);
			
			//QrySchoolResponse school = xxtwsService.getSchoolById(studentVO.getSchoolId());
			//studentVO.setSchoolName(school.getSchoolName());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return studentVO;
	}
}

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.istudy.server.common.utils.CommonUtils;
import com.istudy.server.xxt.service.XXTWSService;
import com.istudy.server.xxt.vo.ParentVO;
import com.istudy.server.xxt.vo.StudentVO;
import com.istudy.server.xxt.vo.TeacherVO;



public class XXTStudentParentRunner implements Runnable{
	
	private int start;
	private final int end;

	private XXTWSService xxtwsService;
	
	public XXTStudentParentRunner(XXTWSService xxtwsService, int start, int end) {
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
				ps = connection.prepareStatement("select ID,cityId,STUDENTID from tmp_xxt_parent_fail where reason = 3 order by id limit ?,?",ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
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
						String cityId = rs.getString("cityId");
						String studentId = rs.getString("STUDENTID");
						StudentVO vo = this.queryStudentParentRelaInfo(cityId, studentId);
						if(vo != null){
							vo.setId(id);
							vos[index] = vo;
						}else{
							vo = new StudentVO();
							vo.setId(id);
							vo.setCityId(cityId);
							vo.setStudentId(studentId);
							
							failVos.add(vo);
						}
						index++;
					}
					rs.close();
					updateStudentBaseInfo(connection, vos, failVos);
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
	
	private void updateStudentBaseInfo(Connection connection, StudentVO[] vos, List<StudentVO> failVos) {
		PreparedStatement ps = null;
		PreparedStatement ps2 = null;
		PreparedStatement failPs = null;
		try{
			try {
				ps = connection.prepareStatement("update xxt_student_all set email = ?, headImage = ? where id = ?");
				ps2 = connection.prepareStatement("insert into xxt_parent_all(parentId,parentName,cityId,parentLoginName,studentId,email,headImage) values(?,?,?,?,?,?,?)");
				failPs = connection.prepareStatement("insert into tmp_xxt_parent_fail(ID,cityId,STUDENTID,reason) values(?,?,?,5)");
				for(StudentVO vo : vos){
					if(vo != null){
						ps.setString(1, vo.getEmail());
						ps.setString(2, vo.getHeadImage());
						ps.setInt(3, vo.getId());
						ps.addBatch();
						
						List<ParentVO> parents = vo.getParents();
						for(ParentVO pvo : parents){
							ps2.setString(1, pvo.getParentId());
							ps2.setString(2, pvo.getParentName());
							ps2.setString(3, pvo.getCityId());
							ps2.setString(4, pvo.getParentLoginName());
							ps2.setString(5, vo.getStudentId());
							ps2.setString(6, pvo.getEmail());
							ps2.setString(7, pvo.getHeadImg());
							
							ps2.addBatch();
						}
						
						System.out.println(++ShortUrlTest.i);
					}
				}
				ps.executeBatch();
				ps2.executeBatch();
				
				for(StudentVO fail : failVos){
					failPs.setInt(1, fail.getId());
					failPs.setString(2, fail.getCityId());
					failPs.setString(3, fail.getStudentId());
					
					failPs.addBatch();
				}
				failPs.executeBatch();
				
				
			} finally{
				if(ps!= null){
					ps.close();
				}
				if(ps2!= null){
					ps2.close();
				}
				if(failPs!= null){
					failPs.close();
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public StudentVO queryStudentParentRelaInfo(String cityId, String studentId){
		StudentVO vo = null;
		if(CommonUtils.isNull(studentId)){
			return null;
		}
		try {
			vo = xxtwsService.getStudentParentRelaById(cityId, studentId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}
}

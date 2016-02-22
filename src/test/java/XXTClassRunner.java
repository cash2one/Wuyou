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



public class XXTClassRunner implements Runnable{
	
	private int start;
	private final int end;

	private XXTWSService xxtwsService;
	
	public XXTClassRunner(XXTWSService xxtwsService, int start, int end) {
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
				ps = connection.prepareStatement("select SCHOOLID,cityId from xxt_school order by id limit ?,?",ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
				while(true){
					int realSize = Math.min(end - start,TestConstants.size);
					List<List<ClassVO>> vos = new ArrayList<List<ClassVO>>(realSize);
					
					ps.setInt(1, start);
					ps.setInt(2, realSize);
					ResultSet rs = ps.executeQuery();
					while(rs.next()){
						String schoolId = rs.getString("SCHOOLID");
						String cityId = rs.getString("cityId");
						List<ClassVO> classes = this.queryInfo(schoolId, cityId);
						if(classes != null){
							vos.add(classes);
						}
					}
					rs.close();
					updateInfo(connection, vos);
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
	
	private void updateInfo(Connection connection, List<List<ClassVO>> vos){
		PreparedStatement insertPs = null;
		try {
			try {
				insertPs = connection.prepareStatement("insert into xxt_class(classId,className,gradeId,gradeName,bank,classType,schoolId,cityId) values(?,?,?,?,?,?,?,?)");
				for(List<ClassVO> lvo : vos){
					if(lvo != null){
						for(ClassVO cvo : lvo){
							insertPs.setString(1, cvo.getClassId());
							insertPs.setString(2, cvo.getClassName());
							insertPs.setString(3, cvo.getGradeId());
							insertPs.setString(4, cvo.getGradeName());
							insertPs.setString(5, cvo.getBank());
							insertPs.setString(6, cvo.getClassType());
							insertPs.setString(7, cvo.getSchoolId());
							insertPs.setString(8, cvo.getCityId());
							
							insertPs.addBatch();
						}
					}
					System.out.println(++XXTClassMain.i);
				}
				insertPs.executeBatch();
			} finally {
				if(insertPs != null){
					insertPs.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<ClassVO> queryInfo(String schoolId, String cityId){
		List<ClassVO> classes = null;
		try {
			classes = xxtwsService.getClassesBySchoolId(schoolId, cityId);
			//QrySchoolResponse school = xxtwsService.getSchoolById(studentVO.getSchoolId());
			//studentVO.setSchoolName(school.getSchoolName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return classes;
	}
}

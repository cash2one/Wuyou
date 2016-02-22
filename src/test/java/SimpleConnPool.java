import java.sql.Connection;
import java.sql.DriverManager;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class SimpleConnPool {
	
	private static final int size = 30;

	private static final Queue<Connection> freeConns = new LinkedList<>();
	
	private static final List<Connection> bizConns = new LinkedList<>();
	
	public static synchronized Connection getConnection(){
		
		try {
			if(!freeConns.isEmpty()){
				Connection conn = freeConns.poll();
				if(conn == null || conn.isClosed()){
					return getConnection();
				}
				return conn;
			}if(bizConns.size() < size){
				Connection conn = create();
				bizConns.add(conn);
				return conn;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return getConnection();
	}
	
	public static void freeConnnection(Connection conn){
		boolean remove = bizConns.remove(conn);
		if(remove){
			freeConns.offer(conn);
		}
	}
	
	private static Connection create() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://10.0.0.170:3306/istudy_cms_dev?useUnicode=true&amp;characterEncoding=utf8&amp;autoReconnect=true&amp;failOverReadOnly=false","istudy","istudy");
		return connection;
	}
}

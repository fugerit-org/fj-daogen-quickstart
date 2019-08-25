package test.org.fugerit.java.daogen.quickstart;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.fugerit.java.daogen.quickstart.config.QuickstartDBHelper;
import org.junit.BeforeClass;

public class MemDBTestBase extends BasicTest {

	private Connection conn;
	
    @BeforeClass
    public static void create() throws Exception
    {
    	QuickstartDBHelper.init();
    } 
    
	public MemDBTestBase() {
		try {
			this.conn = QuickstartDBHelper.newConnection();
		} catch ( Exception e) {
			throw new RuntimeException( "Init error "+e, e );
		}
	}

	public Connection getConnection() {
		return this.conn;
	}
	
	public void simpleTestSelectWorker( String select ) {
		try ( Connection conn = this.getConnection();
				Statement stm = conn.createStatement();
				ResultSet rs = stm.executeQuery( select ) ) {
			int read = 0;
			while ( rs.next() ) {
				read++;
			}
			logger.info( "total record read from table : "+read );
		} catch (Exception e) {
			String message = "Error : "+e;
			logger.error( message, e );
			e.printStackTrace();
			fail( message );
		}
	}
	
}

import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

public class PrintJDBCDrivers {
    public static void main (String[] args) {
        for (Enumeration<Driver> e = DriverManager.getDrivers(); e.hasMoreElements(); ) {
            Driver driver = e.nextElement();
            System.out.println(driver.getClass().getName() + " " +  driver.getMajorVersion() + "." + driver.getMinorVersion());
        }
    }
}
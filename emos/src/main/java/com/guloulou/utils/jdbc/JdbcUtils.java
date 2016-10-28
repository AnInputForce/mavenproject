package com.guloulou.utils.jdbc;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;



/**
 *
 * 2008-12-6
 *
 * @author <a href="mailto:liyongibm@hotmail.com">李勇</a>
 *
 */
public final class JdbcUtils {

  private static String url = "jdbc:mysql://localhost:3306/demo_jdbc";
  private static String user = "root";
  private static String password = "";
  private static DataSource myDataSource = null;

  private JdbcUtils() {
  }

  static {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      // myDataSource = new MyDataSource();
      Properties prop = new Properties();
      // prop.setProperty("driverClassName", "com.mysql.jdbc.Driver");
      // prop.setProperty("user", "user");

      InputStream is = JdbcUtils.class.getClassLoader().getResourceAsStream("dbcpconfig-simulation.properties");
      prop.load(is);
      myDataSource = BasicDataSourceFactory.createDataSource(prop);
    } catch (Exception e) {
      throw new ExceptionInInitializerError(e);
    }
  }

  public static DataSource getDataSource() {
    return myDataSource;
  }

  public static Connection getConnection() throws SQLException {
    // return DriverManager.getConnection(url, user, password);
    return myDataSource.getConnection();
  }

  public static void free(ResultSet rs, Statement st, Connection conn) {
    try {
      if (rs != null) {
        rs.close();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        if (st != null) {
          st.close();
        }
      } catch (SQLException e) {
        e.printStackTrace();
      } finally {
        if (conn != null) {
          try {
            conn.close();
            // myDataSource.free(conn);
          } catch (Exception e) {
            e.printStackTrace();
          }
        }
      }
    }
  }
}

package com.chineseall.xcms.core.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DataSourceUtils {

    private static final ComboPooledDataSource ds = new ComboPooledDataSource();
    static {
        try {
            Cfg cfg = Cfg.getCfg("jdbc.properties");
            if(cfg != null) {
                ds.setDriverClass(cfg.getProperty("driverclass"));
                ds.setJdbcUrl(cfg.getProperty("jdbcurl"));
                ds.setUser(cfg.getProperty("username"));
                ds.setPassword(cfg.getProperty("password"));
            }
        } catch (Exception e) {
            throw new RuntimeException("[jdbc.properties init error]", e);
        }
    }
    
    /**
     * @return 获取数据源
     */
    public static DataSource getDataSource() {
        
        return ds;
    }
    
    /**
     * @return 获取数据库连接
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        
        return ds.getConnection();
    }
    
}

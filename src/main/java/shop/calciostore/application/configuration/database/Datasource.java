package shop.calciostore.application.configuration.database;

import org.h2.jdbcx.JdbcConnectionPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.h2.jdbcx.JdbcConnectionPool;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.SQLException;

@Configuration
public class Datasource {

    @Autowired
    private Environment env;

    @Primary
    @Bean
    public DataSource customDataSource() throws SQLException{

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("spring.datasource.driverClassName"));
        dataSource.setUrl(env.getProperty("spring.datasource.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.password"));
        executeScripts(dataSource);
        return dataSource;

    }
    private void executeScripts(DataSource dataSource) throws SQLException{
        JdbcTemplate conn = new JdbcTemplate(dataSource);
        conn.execute("DROP TABLE IF EXISTS human_survey ");
        conn.execute("CREATE TABLE human_survey (" +
                "id IDENTITY NOT NULL," +
                "is_mutant VARCHAR NOT NULL)");
    }
}
/*

@Configuration
public class PrototypeUtility {
    @Bean(name = "dsMaster")
    @Primary
    @ConfigurationProperties(prefix="spring.oracledatasource")
    public DataSource primaryDataSource() {
        return DataSourceBuilder.create().build();
    }
    @Bean(name = "jdbcMaster")
    public JdbcTemplate masterJdbcTemplate(@Qualifier("dsMaster") DataSource dsMaster) {
        return new JdbcTemplate(dsMaster);
    }

    @Bean(name = "dsMasterMysql")
    @ConfigurationProperties(prefix="spring.mysqldatasource")
    public DataSource primaryDataSourceMysql() {
        return DataSourceBuilder.create().build();
    }
    @Bean(name = "jdbcMasterMysql")
    public JdbcTemplate masterMysqlJdbcTemplate(@Qualifier("dsMasterMysql") DataSource dsMasterMysql) {
        return new JdbcTemplate(dsMasterMysql);
    }
}*/

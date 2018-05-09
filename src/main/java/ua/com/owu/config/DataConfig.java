package ua.com.owu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableJpaRepositories("ua.com.owu.dao")
@EnableTransactionManagement
@PropertySource("classpath:db.properties")
public class DataConfig {

    @Autowired
    private Environment env;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/sv1600?createDatabaseIfNotExist=true");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }


    @Bean
    public JpaVendorAdapter vendorAdapter() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setDatabase(Database.MYSQL);
        vendorAdapter.setShowSql(true);
        return vendorAdapter;

    }

    @Bean("entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setJpaVendorAdapter(vendorAdapter());
        factoryBean.setPackagesToScan("ua.com.owu.entity");

        Properties properties = new Properties();

        properties.put("hibernate.hbm2ddl.auto", "update");

        factoryBean.setJpaProperties(properties);


        return factoryBean;
    }


    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory factory) {
        return new JpaTransactionManager(factory);

    }

//        @Bean
//        public DataSource dataSource(){
//    //        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//    //        dataSource.setUrl("jdbc:mysql://localhost/springmvc2015");
//    //        dataSource.setUsername("root");
//    //        dataSource.setPassword("root");
//    //        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//    //        return dataSource;
//            HikariConfig hikariConfig = new HikariConfig();
//            hikariConfig.setDriverClassName("com.mysql.jdbc.Driver");
//            hikariConfig.setJdbcUrl("jdbc:mysql://localhost:3306/springmvc2015");
//            hikariConfig.setUsername("root");
//            hikariConfig.setPassword("root");
//
//            hikariConfig.setMaximumPoolSize(5);
//
//            hikariConfig.addDataSourceProperty("dataSource.cachePrepStmts", "true");
//            hikariConfig.addDataSourceProperty("dataSource.prepStmtCacheSize", "250");
//            hikariConfig.addDataSourceProperty("dataSource.prepStmtCacheSqlLimit", "2048");
//            hikariConfig.addDataSourceProperty("dataSource.useServerPrepStmts", "true");
//
//            HikariDataSource dataSource = new HikariDataSource(hikariConfig);
//
//            return dataSource;
//        }


}

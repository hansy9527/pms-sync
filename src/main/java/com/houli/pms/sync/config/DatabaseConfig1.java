package com.houli.pms.sync.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * 数据源1相关配置（作为主数据库，项目启动默认连接此数据库）
 *
 * 主数据库都有 @Primary注解，从数据库都没有
 *
 * 需要额外注意的位置
 * 1：扫描Dao层包路径，basePackages = "com.kd.opt.dao"
 * 2：关联yml中的数据源，@ConfigurationProperties(prefix = "spring.datasource.database1")
 * 3：扫描相关xml文件的所在路径，"classpath:mapper/*.xml"
 *
 * @author 小辰哥哥
 */
@Configuration
@MapperScan(basePackages = "com.houli.pms.sync.task.dao", sqlSessionTemplateRef = "sqlSessionTemplate1")
public class DatabaseConfig1 {
    @Bean(name = "dataSource1")
    @ConfigurationProperties(prefix = "spring.datasource.main")
    @Primary
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "sqlSessionFactory1")
    @Primary
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource1") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "transactionManager1")
    @Primary
    public DataSourceTransactionManager transactionManager(@Qualifier("dataSource1") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "sqlSessionTemplate1")
    @Primary
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("sqlSessionFactory1") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}

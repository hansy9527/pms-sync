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
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * 数据源2相关配置（作为从数据库）
 *
 * 主数据库都有 @Primary注解，从数据库都没有
 *
 * 需要额外注意的位置
 * 1：扫描Dao层包路径，basePackages = "com.kd.opt.dao2"
 * 2：关联yml中的数据源，@ConfigurationProperties(prefix = "spring.datasource.database2")
 * 3：扫描相关xml文件的所在路径，"classpath:mapper2/*.xml"
 *
 * @author zhouziyu
 */
@Configuration
@MapperScan(basePackages = "com.houli.pms.sync.task.dao2", sqlSessionTemplateRef = "sqlSessionTemplate2")
public class DatabaseConfig2 {
    @Bean(name = "dataSource2")
    @ConfigurationProperties(prefix = "spring.datasource.second")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "sqlSessionFactory2")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource2") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper2/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "transactionManager2")
    public DataSourceTransactionManager transactionManager(@Qualifier("dataSource2") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "sqlSessionTemplate2")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("sqlSessionFactory2") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}

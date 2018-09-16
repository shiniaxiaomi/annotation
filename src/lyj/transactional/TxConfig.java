package lyj.transactional;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * Created by 陆英杰
 * 2018/9/16 15:14
 */

/**
 * 声明式事务:
 *
 *      环境搭建:
 *          1. 导入相关依赖
 *              数据源,数据库驱动,spring-jdbc模块
*           2. 配置数据源,jdbcTemplate操作数据
 *          3. 给方法上标注@Transactional注解 表示当前方法时一个事务方法
 *          4. 使用@EnableTransactionManagement注解,开启基于注解的事务管理功能
 *          5. 配置事务管理器
 */

@EnableTransactionManagement
@ComponentScan("lyj.transactional")
@Configuration
public class TxConfig {

    //数据源
    @Bean
    public DataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("123456");
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        return dataSource;
    }

    //配置JdbcTemplate,方便进行数据库操作
    @Bean
    public JdbcTemplate jdbcTemplate() throws PropertyVetoException {
        return new JdbcTemplate(dataSource());//这边直接调用配置类的dataSource()方法,不会重新new一个数据源,而是会去容器中找,并注入
    }

    //配置事务管理器; 只有配置了事务管理器,才能控制与数据库的每一个连接,也就可以进行回滚操作
    @Bean
    public PlatformTransactionManager transactionManager() throws PropertyVetoException {
        return new DataSourceTransactionManager(dataSource());
    }

}

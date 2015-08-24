/**
 * 
 */
package world.we.deserve.jpaautomaticrepositories;

import java.beans.PropertyVetoException;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * @author Miguel Ángel Dev (miguelangelprogramacion@gmail.com)
 *
 */
@EnableTransactionManagement
@Configuration
@ComponentScan(basePackages={"world.we.deserve"})
@EnableJpaRepositories(basePackages={"world.we.deserve.dao.repository"})
public class JPAAutomaticReposComponentScan {
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory
	(DataSource dataSource, JpaVendorAdapter jpaVendeorAdapter)
	{
		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactory.setDataSource(dataSource);		
		entityManagerFactory.setJpaVendorAdapter(jpaVendeorAdapter);
		entityManagerFactory.setPackagesToScan("world.we.deserve.dto.jpa");		
		return entityManagerFactory;
	}
	
	@Bean
	public JpaVendorAdapter jpaVendorAdapter()
	{
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setShowSql(true);
		adapter.setGenerateDdl(false);
		adapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");		
		
		
		return adapter;
	}
	
	@Bean 
	ComboPooledDataSource dataSource()
	{
		ComboPooledDataSource ds = new ComboPooledDataSource();
//		ds.setDriverClassName("com.mysql.jdbc.Driver");
//		ds.setUrl("jdbc:mysql://localhost:3306/nihilism");
//		ds.setUsername("root");
//		ds.setPassword("root");
		try {
			ds.setDriverClass("com.mysql.jdbc.Driver");
			ds.setJdbcUrl("jdbc:mysql://localhost:3306/nihilism");
			ds.setUser("root");
			ds.setPassword("root");
			
			ds.setAcquireIncrement(5);
			ds.setMinPoolSize(5);
			ds.setMaxPoolSize(20);
			ds.setMaxIdleTime(10);	
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}		
		
		return ds;
	}
	
	  @Bean
	   public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
	      JpaTransactionManager transactionManager = new JpaTransactionManager(emf);

	      return transactionManager;
	   }

}

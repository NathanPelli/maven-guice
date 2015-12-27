package com.guice.server;

import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionManager;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.guice.MyBatisModule;
import org.mybatis.guice.datasource.builtin.PooledDataSourceProvider;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.name.Names;
import com.guice.dao.PersonDao;
import com.guice.domain.Person;
import com.guice.mapper.PersonMapper;

/**
 * @author Nathan
 */
public class Demo1 {
	public static void main(String[] args){
		final Properties properties = new Properties();
		ResourceBundle rb = ResourceBundle.getBundle("db");
		properties.setProperty("mybatis.environment.id", "demo1");
		properties.setProperty("JDBC.driver", rb.getString("db.classname"));
		properties.setProperty("JDBC.url", rb.getString("db.url"));
		properties.setProperty("JDBC.username", rb.getString("db.username"));
		properties.setProperty("JDBC.password", rb.getString("db.password"));
		properties.setProperty("JDBC.autoCommit", "false");
		Injector injector = Guice.createInjector(new MyBatisModule(){

			@Override
			protected void initialize() {
				this.bindDataSourceProviderType(PooledDataSourceProvider.class);
				this.bindTransactionFactoryType(JdbcTransactionFactory.class);
				this.addMapperClasses("com.guice.mapper");
				this.addSimpleAlias(Person.class);
				this.bind(PersonDao.class).to(Person.class);
				Names.bindProperties(this.binder(), properties);
			}
			
		});
		SqlSessionFactory sessionFactory = injector.getInstance(SqlSessionFactory.class);
		System.out.println("sessionFactory.class = "+sessionFactory.getClass());
		SqlSessionManager sessionManager = injector.getInstance(SqlSessionManager.class);
		System.out.println("sessionManager.class = "+sessionManager.getClass());
		
		PersonDao personDao = injector.getInstance(PersonDao.class);
		System.out.println("personDao.class = "+personDao.getClass());
		personDao.printInfo();
		
		PersonMapper personMapper = injector.getInstance(PersonMapper.class);
		System.out.println("personMapper.class = "+personMapper.getClass());
		
		Person person = new Person();
		person.setName("张飞");
		person.setAge(26);
		person.setComment("123");
		person.setSex(0);
		int code = personDao.save(person);
		System.out.println("code: "+code);
		int id = person.getId();
		Person p1 = personDao.getById(id);
		System.out.println(p1.getName());
		
		
	}
}

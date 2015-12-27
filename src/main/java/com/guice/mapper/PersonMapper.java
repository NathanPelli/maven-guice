package com.guice.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.guice.domain.Person;

public interface PersonMapper {
	@Select("select * from person where id = #{id}")
	@Options(flushCache=true)
	public Person getById(int id);
	
	@Select("select * from person order by name asc")
	@Options(flushCache=true)
	public List getAll();
	
	@Insert("insert into person(name,sex,age,comment) values(#{name},#{sex},#{age},#{comment})")
	@Options(useGeneratedKeys=true,keyProperty="id")
	public int append(Person person);
	
	@Update("update person set name = #{name},sex=#{sex},comment=#{comment} where id = #{id}")
	@Options(flushCache=true)
	public int update(Person person);
	
	@Delete("delete from person where id = #{id}")
	@Options(flushCache=true)
	public int remove(@Param("id") int id);
}

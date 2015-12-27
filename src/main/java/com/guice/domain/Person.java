package com.guice.domain;

import java.util.List;

import javax.inject.Inject;

import org.mybatis.guice.transactional.Transactional;

import com.google.inject.Injector;
import com.guice.dao.PersonDao;
import com.guice.mapper.PersonMapper;


public class Person implements PersonDao{
	private Integer id;
	@Inject
	private Injector injector;
	@Inject
	private PersonMapper personMapper;
	private String name;
	private Integer sex;
	private Integer age;
	private String comment;
	public Person getById(int id) {
		return this.personMapper.getById(id);
	}

	public List getAll() {
		return this.personMapper.getAll();
	}
	@Transactional
	public int save(Person person) {
		if(person == null){
			return -1;
		}
		if(person.getId()==null){
			return this.personMapper.append(person);
		}else{
			return this.personMapper.update(person);
		}
	}
	@Transactional
	public int remove(int id) {
		return this.personMapper.remove(id);
	}

	public void printInfo() {
		System.out.println("injector is "+this.injector);
		System.out.println("PersonMapper is "+this.personMapper);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
}

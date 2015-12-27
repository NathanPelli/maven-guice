package com.guice.dao;

import java.util.List;

import com.guice.domain.Person;

public interface PersonDao {
	public Person getById(int id);
	public List getAll();
	public int save(Person person);
	public int remove(int id);
	public void printInfo();
}

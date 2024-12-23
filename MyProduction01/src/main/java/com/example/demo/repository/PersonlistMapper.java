package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.Personlist;

@Mapper
public interface PersonlistMapper {

	List<Personlist> selectAll();
	void insertPerson(Personlist list);
	void updatePerson(Personlist list);
	void deletePerson(Integer id);
}

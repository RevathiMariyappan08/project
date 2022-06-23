package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository

public class Userr_Dao {
	@Autowired
	Userr_Repo urepo;
	public String addallusers(List<Userr> u) {
		for(Userr us:u) {
			urepo.save(us);
		}
		return "saved successfully";
	}
	public List<Userr>getallusers() {
		List<Userr>getall=urepo.findAll();
		return getall;
	}
	public String deleteusers(Integer id) {
		
			urepo.deleteById(id);
			return "data has been deleted";
		}
	}



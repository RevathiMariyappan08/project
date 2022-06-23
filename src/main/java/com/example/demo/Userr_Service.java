package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class Userr_Service {
	@Autowired
	Userr_Dao udao;
	public String addallusers(List <Userr> u) {
		return udao.addallusers(u);
	}
	public List<Userr> getallusers() {
		List<Userr>getall=udao.getallusers();
		return getall;
		
		
	}
	public String deleteusers(Integer id) {
		return udao.deleteusers(id);
	}

}

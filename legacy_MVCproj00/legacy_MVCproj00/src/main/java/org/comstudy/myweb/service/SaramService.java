package org.comstudy.myweb.service;

import java.util.List;

import org.comstudy.myweb.model.Saram;
import org.comstudy.myweb.model.SaramDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaramService {
	
	@Autowired
	private SaramDao dao;
	
	public List<Saram> saramList() {
		return dao.selectAll();
	}
	
}

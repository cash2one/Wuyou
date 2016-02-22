package com.istudy.server.cms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.istudy.server.cms.vo.SchoolVO;
import com.istudy.server.common.service.BaseService;

@Service
public class SchoolService extends BaseService{

	public List<SchoolVO> getAllSchools() {
		// TODO Auto-generated method stub
		return this.baseDAO.selectList();
	}

}

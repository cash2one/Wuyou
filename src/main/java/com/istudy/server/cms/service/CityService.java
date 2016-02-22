package com.istudy.server.cms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.istudy.server.cms.vo.CityVO;
import com.istudy.server.common.service.BaseService;

@Service
public class CityService extends BaseService{
	public List<CityVO> getAllCitys(){
		return this.baseDAO.selectList();
	}
}

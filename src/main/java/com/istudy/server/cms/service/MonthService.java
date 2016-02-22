package com.istudy.server.cms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.istudy.server.cms.vo.MonthVO;
import com.istudy.server.common.service.BaseService;

@Service
public class MonthService extends BaseService{
	public List<MonthVO> getAllActivateMonths(){
		return this.baseDAO.selectList();
	}
}

package com.istudy.server.cms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.istudy.server.cms.vo.GradeVO;
import com.istudy.server.common.service.BaseService;

@Service
public class GradeService extends BaseService{
	public List<GradeVO> getAllGradeInfo(){
		return this.baseDAO.selectList();
	}
}

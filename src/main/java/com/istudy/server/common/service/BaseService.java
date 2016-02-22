package com.istudy.server.common.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.istudy.server.common.dao.BaseDAO;
import com.istudy.server.common.vo.PagingVO;

@Service
public class BaseService {
	@Autowired
	protected BaseDAO baseDAO;
	
	public <E> List<E> getPagingData(PagingVO paging){
		return this.baseDAO.selectList(paging.getWhat()+"_data", paging);
	}
	
	public long getDataSize(PagingVO paging){
		return this.baseDAO.selectOne(paging.getWhat()+"_size",paging);
	}

}

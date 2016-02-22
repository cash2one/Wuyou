package com.istudy.server.common.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.istudy.server.common.vo.PagingVO;

@Service
public class BaseFacade<T> {
	
	@Autowired
	private BaseService baseService;
	
	@Transactional(readOnly = true, propagation=Propagation.NOT_SUPPORTED)
	public void getPagingData(PagingVO paging){
		 List<T> result = this.baseService.getPagingData( paging);
		 paging.setResult(result);
	}
	
	@SuppressWarnings("serial")
	@Transactional(readOnly = true, propagation=Propagation.NOT_SUPPORTED)
	public Map<String,Object> initPaging(final PagingVO paging){
		 this.getPagingData(paging);
		 if(paging.getResult().size()>0){
			 long size = this.baseService.getDataSize(paging);
			 paging.setSize(size);
		 } 
		 return new HashMap<String,Object>(){{
			 this.put("paging", paging);
		 }};
	}
}

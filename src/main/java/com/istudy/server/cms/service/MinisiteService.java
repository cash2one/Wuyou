package com.istudy.server.cms.service;

import static com.istudy.server.common.constants.CMSConstants.TEMPLATE_FILE_TAIL;
import static com.istudy.server.common.constants.CMSConstants.VM_IMAGE_TEXT_FILE;
import static com.istudy.server.common.constants.CMSConstants.VM_VIDEO_FILE;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.istudy.server.cms.vo.MinisiteVO;
import com.istudy.server.common.constants.CMSConstants;
import com.istudy.server.common.constants.CommonConstants;
import com.istudy.server.common.exception.CMSException;
import com.istudy.server.common.service.BaseService;
import com.istudy.server.common.utils.CommonUtils;
import com.istudy.server.common.utils.GrowthUtils;
import com.istudy.server.common.utils.LogUtils;
import com.istudy.server.common.utils.VelocityUtils;

/**
 * MinisiteService业务逻辑代码层，调用@BaseDAO保存数据
 * 
 * @author LONGTING
 *
 */
@Service
public class MinisiteService extends BaseService {
	
	@Autowired
	private VelocityEngine velocityEngine;
	
	/**
	 * 保存minisiteVO
	 * @param minisiteVO 
	 */
	public void saveMinisiteInfo(MinisiteVO minisiteVO){
		if(!CommonConstants.MINI_TYPE_TEXT.equals(minisiteVO.getType())){
			String miniUrl = System.currentTimeMillis()+GrowthUtils.getFileGrowthStr();
			minisiteVO.setMiniUrl(miniUrl);
		}
		this.baseDAO.insert(minisiteVO);
	}
	
	/**
	 * 保存minisiteVO
	 * @param minisiteVO 
	 */
	public void modiMinisiteInfo(MinisiteVO minisiteVO){
		//修改minisite时不生成新的JSP文件
		//String miniUrl = System.currentTimeMillis()+GrowthUtils.getFileGrowthStr();
		//minisiteVO.setMiniUrl(miniUrl);
		this.baseDAO.update(minisiteVO);
	}
	
	public void delTemplatePage(String path,String oldUrl){
		String uri = path+"/WEB-INF/jsp/xxt/minisite/";
		CommonUtils.createPath(uri);
		String toPath = uri+oldUrl+TEMPLATE_FILE_TAIL;
		File f = new File(toPath);
		if(f.exists()&&f.isFile()){
			LogUtils.L.info("删除旧模板 : "+toPath);
			f.delete();
		}
	}
	
	@SuppressWarnings("unchecked")
	public void createTemplatePage(MinisiteVO minisiteVO,String path){
		minisiteVO.setCreateDate(CommonUtils.getDate(new Date(), CommonUtils.BASIC_DATE_STYLE));
		Map<String,Object> miniMap = null;
		String type = minisiteVO.getType();
		String vmFile = "";
		switch (Integer.parseInt(type)) {
		case 1:
			vmFile = VM_IMAGE_TEXT_FILE;
			break;
		case 2:
			vmFile = VM_VIDEO_FILE;
			break;
		default:
			return ;
		}
		try {
			miniMap = BeanUtils.describe(minisiteVO);
		} catch (IllegalAccessException | InvocationTargetException
				| NoSuchMethodException e) {
			throw new CMSException(e);
		}
		// 生成minisite
		VelocityUtils.work(velocityEngine, miniMap, path, vmFile, minisiteVO.getMiniUrl()+TEMPLATE_FILE_TAIL);
	}
	
	public MinisiteVO getMinisiteInfoById(String minisiteId){
		return this.baseDAO.selectOne(minisiteId);
	}
	
	public MinisiteVO getBasicMinisiteInfoById(String minisiteId){
		return this.baseDAO.selectOne(minisiteId);
	}
	
	public void delMinisitePage(String imgID,String webParentPath){
		String jsp = webParentPath+"/WEB-INF/jsp/xxt/minisite/"+imgID+CMSConstants.TEMPLATE_FILE_TAIL;
		CommonUtils.delFile(jsp);
	}
	
	public void delImg(String img){
		String relativeURL = "img/minisite/" +img;
		CommonUtils.delFile(relativeURL);
	}
	
	public void delMinisiteById(String id){
		this.baseDAO.delete(id);
	}
	
	public void delSoftMinisiteById(String id){
		this.baseDAO.update(id);
	}

	public void saveFaqs(MinisiteVO minisiteVO) {
		// TODO Auto-generated method stub
		this.baseDAO.update(minisiteVO);
	}
	
}

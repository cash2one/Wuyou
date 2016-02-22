package com.istudy.server.xxt.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.istudy.server.common.dao.BaseDAO;
import com.istudy.server.common.service.BaseService;
import com.istudy.server.xxt.vo.AutoRptVO;
import com.istudy.server.xxt.vo.BookVO;
import com.istudy.server.xxt.vo.ChannelVO;
import com.istudy.server.xxt.vo.ClickInfo;
import com.istudy.server.xxt.vo.DCountVO;
import com.istudy.server.xxt.vo.QuesVO;
import com.istudy.server.xxt.vo.UserAction3VO;
import com.istudy.server.xxt.vo.UserActionRecordPhoneRelaVO;
import com.istudy.server.xxt.vo.UserActionRecordVO;
import com.istudy.server.xxt.vo.UserActionVO;
import com.istudy.server.xxt.vo.bookInfoVO;

@Service
public class MinisiteUserActionStatService extends BaseService {

	@Autowired
	private BaseDAO baseDao;
	
	@Transactional(rollbackFor=Exception.class)
	public void addRecord(UserActionRecordVO vo){
		baseDao.insert(vo);
	}
	
	@Transactional(readOnly=true)
	public List<UserActionRecordPhoneRelaVO> findRecordPhoneRelas(UserActionRecordPhoneRelaVO vo){
		return baseDao.selectList(vo);
	}
	
	@Transactional(rollbackFor=Exception.class)
	public void addRecordPhoneRela(UserActionRecordPhoneRelaVO vo){
		baseDao.insert(vo);
	}
	
	@Transactional(rollbackFor=Exception.class)
	public void addRecordV2(UserActionVO vo){
		baseDao.insert(vo);
	}

	@Transactional(rollbackFor=Exception.class)
	public void addRecordV3(UserAction3VO vo) {

		baseDao.insert(vo);
	}
	
	public List<bookInfoVO> bookInfo(String idtype) {//无忧推送查预约名单

		return baseDao.selectList(idtype);
	}
	
	public AutoRptVO autoRpt(String postId, String idtype) {

		return baseDao.selectOne(postId,idtype);
	}
	
	@Transactional(readOnly=true)
	public Map<String, Integer> getVariableTitileReport() {
		return baseDao.selectOne();
	}
	
	@Transactional(readOnly=true)
	public Map<String, Integer> getSubjectChooseReport() {
		return baseDao.selectOne();
	}

	public Map<String, Integer> getTestStrategyReport() {

		return baseDao.selectOne();
	}
	
	public Map<String, Integer> getStat28to31() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getStat32to37() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getStat38to45() {
		return baseDao.selectOne();
	}

	public Map<String, Integer> getStat49() {
		return baseDao.selectOne();
	}

	public Map<String, Integer> getStat50() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getStat51to60() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getStat66to67() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getStat70to81() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getStat82to83() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getStat88() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getStat89to105() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getStat106to108() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getStat96to103() {

		return baseDao.selectOne();
	}

	public void saveBooksPhone(BookVO book1) {

		this.baseDAO.insert(book1);
	}

	public List<Object> getBookPhoneReport() {

		return baseDAO.selectList();
	}

	public Map<String, Integer> getStat112() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getStat113to114() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getStat115to122() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getStat123() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getStat130to131() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getStat132to135() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getStat136to147() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getStat154to167() {

		return baseDao.selectOne();
	}

	public int getStatCount(Map<String, Object> params) {
		return baseDao.selectOne(params);
	}

	public Map<String, Integer> getStat168to183() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getStat184to201() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getStat202to221() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getStat222to239() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getStat240to241() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getStat242to243() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getStat244to261() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getStat262to267() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getStat268to275() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getStat290to301() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getStat302to313() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getStat316to319() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getStat140916() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getStat1001to2003() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getStat321to324() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getStat325to336() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getStat337to348() {

		return baseDao.selectOne();
	}

	public List<ChannelVO> channelRpt(String type) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("type", type);
		return baseDao.selectList(map);
	}

	public List<ChannelVO> innerRpt(String type) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("type", type);
		return baseDao.selectList(map);
	}

	public List<DCountVO> rptTest(String type) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("type", type);
		return baseDao.selectList(map);
	}

	public Map<String, Integer> getStat367to372() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getStat373to396() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getStat355to366() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getStat397to432() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getStat433to450() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getStat451to468() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getStat469to472() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getStat473to490() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getStat491to502() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getStat503to506() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getStat521to524() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getStat507to528() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getStat529to540() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getStat545to562() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getStat563to582() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt20141121() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getStat587to591() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getStat597to614() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getStat595to623() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getStat625to630() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getStat631to654() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt20141205() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt20141210() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt20141211() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt20141212() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt20141228() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt20141227() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getStat677to679() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getStat655to676() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getStat693to698() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt20150115() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getStat687to692() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getStat701to703() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt20150121() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt20150123() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt2015012302() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt20150129() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt20150130() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt20150205() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt20150209() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt2015020902() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt20150306() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt2015030602() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt2015030603() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRptSX() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt2015031303() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRptSX20150320() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt20150320() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt2015032002() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt2015032003() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRptSX20150326() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt20150326() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt2015032602() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt2015032603() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRptSX20150402() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt20150402() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt2015040202() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt2015040203() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRptSX20150410() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt20150410() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt2015041002() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt2015041003() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRptSN20150416() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRptSX20150416() {

		return baseDao.selectOne();
	}

	public String openCount(AutoRptVO vo) {

		return baseDao.selectOne(vo);
	}

	public String downloadCount(AutoRptVO vo) {

		return baseDao.selectOne(vo);
	}

	public Map<String, Integer> getRpt2015041702() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt2015041703() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt20150417() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt20150423() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt2015042302() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt2015042303() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRptSX20150424() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRptSN20150428() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt20150429() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt2015042902() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt2015042903() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt2015042904() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt2015042905() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt2015042906() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRptSX20150430() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRptSX20150507() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt20150507() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt2015050702() {

		return baseDao.selectOne();
	}
	
	public Map<String, Integer> getRpt2015050703() {

		return baseDao.selectOne();
	}
	
	public Map<String, Integer> getRpt2015050704() {

		return baseDao.selectOne();
	}
	
	public Map<String, Integer> getRpt2015050705() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRptSN20150508() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt20150514() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt2015051402() {

		return baseDao.selectOne();
	}
	public Map<String, Integer> getRpt2015051403() {

		return baseDao.selectOne();
	}
	public Map<String, Integer> getRpt2015051404() {

		return baseDao.selectOne();
	}
	public Map<String, Integer> getRpt2015051405() {

		return baseDao.selectOne();
	}
	public Map<String, Integer> getRpt2015051406() {

		return baseDao.selectOne();
	}
	public Map<String, Integer> getRpt2015051407() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRptSX20150515() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRptSN20150518() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRptSX20150522() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt20150521() {

		return baseDao.selectOne();
	}
	public Map<String, Integer> getRpt2015052102() {

		return baseDao.selectOne();
	}
	public Map<String, Integer> getRpt2015052103() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt2015052104() {

		return baseDao.selectOne();
	}
	
	public Map<String, Integer> getRpt2015052105() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt20150528() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt2015052802() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt2015052803() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt2015052804() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt20150604() {

		return baseDao.selectOne();
	}
	
	public Map<String, Integer> getRpt2015060402() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt2015060403() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRptSX20150529() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRptSX20150605() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRptSN20150608() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt20150611() {

		return baseDao.selectOne();
	}
	
	public Map<String, Integer> getRpt2015061102() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt2015061103() {

		return baseDao.selectOne();
	}
	
	public Map<String, Integer> getRpt2015061104() {

		return baseDao.selectOne();
	}
	
	public Map<String, Integer> getRpt2015061105() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRptSX20150611() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt20150615() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt20150618() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt2015061802() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt2015061803() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt2015061804() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRptSX20150619() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt20150623() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt20150625() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt2015062502() {

		return baseDao.selectOne();
	}
	
	public Map<String, Integer> getRpt2015062503() {

		return baseDao.selectOne();
	}
	
	public Map<String, Integer> getRpt2015062504() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRptSX20150626() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt20150626() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRptSN20150701() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt20150701() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt2015070102() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt2015070103() {

		return baseDao.selectOne();
	}
	
	public Map<String, Integer> getRpt2015070104() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRptSX20150706() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt20150708() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt20150709() {

		return baseDao.selectOne();
	}
	
	public Map<String, Integer> getRpt2015070902() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt2015070903() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRptSX20150710() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRptSN20150714() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt20150716() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt2015071602() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt2015071603() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRptSX20150720() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRptSN20150722() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt20150723() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt2015072302() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt2015072303() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRptSX20150724() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt20150729() {

		return baseDao.selectOne();
	}
	
	public Map<String, Integer> getRpt2015072902() {

		return baseDao.selectOne();
	}
	
	public Map<String, Integer> getRpt2015072903() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt20150730() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRptSX20150803() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt20150804() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt20150805() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt2015080502() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRptSX20150806() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRptSN20150813() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRptSX20150813() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt20150814() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt2015081402() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt2015081403() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt20150820() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt2015082002() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt2015082003() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRptSX20150824() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt20150826() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt2015082602() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt2015082603() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRptSX20150828() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt20150902() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt2015090202() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt2015090203() {

		return baseDao.selectOne();
	}

	public List<QuesVO> quesInfo() {

		return baseDao.selectList();
	}
	
	public List<QuesVO> tlbQuesInfo() {

		return baseDao.selectList();
	}

	public Map<String, Integer> getRpt20150910() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt2015091002() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt2015091003() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt2015091004() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRptSX20150911() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRptSN20150916() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRptSX20150917() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt20151015() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt2015101502() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt20151102() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt2015110202() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt2015110203() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRptSN20151203() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRptSN20151207() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt20151209() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt20151211() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt2015121102() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt2015121103() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRptSN20151211() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt20151218() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt2015121802() {

		return baseDao.selectOne();
	}
	
	public Map<String, Integer> getRpt2015121803() {

		return baseDao.selectOne();
	}
	
	public Map<String, Integer> getRpt2015121804() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRptSN20151218() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt20151224() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt2015122402() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt2015122403() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt2015122404() {

		return baseDao.selectOne();
	}

	public Map<String, Integer> getRptSN20151225() {

		return baseDao.selectOne();
	}
	
	public Map<String, Integer> getRptSN2015122502() {
		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt20160104() {
		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt20160108() {
		return baseDao.selectOne();
	}

	public Map<String, Integer> getRpt2016010802() {
		return baseDao.selectOne();
	}

	public Map<String, Integer> getRptSN20160108() {
		return baseDao.selectOne();
	}

	public Map<String, Integer> clickInfo(ClickInfo ci) {
		return baseDao.selectOne(ci);
	}
	
}

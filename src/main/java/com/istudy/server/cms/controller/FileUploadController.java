package com.istudy.server.cms.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.istudy.server.cms.vo.SubImageVO;
import com.istudy.server.common.constants.CMSConstants;
import com.istudy.server.common.constants.IstudyConstants;
import com.istudy.server.common.constants.XXTConstants;
import com.istudy.server.common.utils.CommonUtils;
import com.istudy.server.common.utils.IOUtils;
import com.istudy.server.common.utils.ImageUtils;
import com.istudy.server.common.utils.LogUtils;


@Controller
@RequestMapping("/fileupload/")
public class FileUploadController implements HandlerExceptionResolver{
	Log LOG = LogFactory.getLog(FileUploadController.class);
	@RequestMapping(value = "/imgUploadPage", method = RequestMethod.GET)
	public String imgUploadPage() {
		return "cms/uploadImg";
	}
	public static void main(String[] args) {
		System.out.println(Class.class.getClass().getResource("/").getPath());
	}
	@RequestMapping(value = "/imgUpload", method = RequestMethod.POST)
    public  ModelAndView handleFormUpload(
        @RequestParam("file") MultipartFile file,HttpServletRequest req) {
		String projectPath = req.getSession().getServletContext()
				.getRealPath("/");
		LogUtils.L.error("========:"+projectPath);
		String suffix =  file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		String relativeURL = "img/minisite/" + CommonUtils.getImgName()+suffix;
		CommonUtils.createPath(projectPath+"img/minisite/");
		final String saveTaget = projectPath+relativeURL;  
		LOG.debug("projectPath: "+saveTaget+","+suffix);
		FileOutputStream os = null;
        if (!file.isEmpty()) {
            try {
				byte[] bytes = file.getBytes();
				os = new FileOutputStream(new File(saveTaget));
				os.write(bytes);
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				IOUtils.close(os);
			}
           ModelAndView av = new ModelAndView("cms/uploadImg");
           av.addObject("saveTaget", saveTaget);
           return av ;
       } else {
    	 return null;
       }
        
    }
	
	@RequestMapping(value = "{type}/subimgUpload", method = RequestMethod.POST)
	@ResponseBody
	public String handlePushTaskSubimgUpload(
			@PathVariable(value="type") String type,
			SubImageVO subImageVO, HttpServletRequest req) {
		String projectPath = req.getSession().getServletContext().getRealPath("/");
		LogUtils.L.error("========:" + projectPath);
		String relativeDir = XXTConstants.XXT_APP_PUBLIC_ACCOUNT_THUMB_IMG_PATH;
		if("istudy".equals(type)){
			relativeDir = IstudyConstants.ISTUDY_APP_THUMB_IMG_PATH;
		}
		
		MultipartFile file = subImageVO.getFile();
		String suffix = file.getOriginalFilename().substring(
				file.getOriginalFilename().lastIndexOf("."));
		String newImageFullName = CommonUtils.getImgName() + suffix;
		String relativeURL = relativeDir + newImageFullName;
		
		CommonUtils.createPath(projectPath + relativeDir);
		final String saveTaget = projectPath + relativeURL;
		LOG.debug("projectPath: " + saveTaget + "," + suffix);
		
		if (!file.isEmpty()) {
			try {
				BufferedImage image=ImageIO.read(file.getInputStream());
				BufferedImage subimage = ImageUtils.getSubBufferedImage(image, subImageVO.getX1(), 
						subImageVO.getY1(), subImageVO.getWidth(), subImageVO.getHeight());
				if(subImageVO.getWidth() > 800 || subImageVO.getHeight() > 800){
					subimage = ImageUtils.resizeBufferedImage(subimage, 800, 800, true);
				}
				ImageIO.write(subimage, suffix.replace(".", ""), new File(saveTaget));
			} catch (IOException e) {
				e.printStackTrace();
			}
			return newImageFullName;
		} else {
			return null;
		}
	}
	
	@RequestMapping(value = "/imageUp", produces="text/javascript; charset=utf-8", method=RequestMethod.GET)
	@ResponseBody
    public String ueditorUploadDirs(
		@RequestParam(value="fetch", required=false) String fetch) throws Exception {
		if(fetch != null){
			return "updateSavePath(['图片目录']);";
		}
		return "";
    }
	
	
	@RequestMapping(value = "/imageUp", produces="text/javascript; charset=utf-8", method=RequestMethod.POST)
	@ResponseBody
    public String ueditorImageUp(
		@RequestParam(value="upfile",required=true) MultipartFile file,
		@RequestParam(value="pictitle", required=false) String title,
	    HttpServletRequest req,Exception ex) throws Exception {
		String projectPath = req.getSession().getServletContext()
				.getRealPath("/");
		LogUtils.L.error("========:"+projectPath);
		String suffix =  file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		String relativeURL = "img/minisite/" + CommonUtils.getImgName()+suffix;
		CommonUtils.createPath(projectPath+"img/minisite/");
		final String saveTaget = projectPath+relativeURL;  
		LOG.debug("projectPath: "+saveTaget+","+suffix);
		FileOutputStream os = null;
        if (!file.isEmpty()) {
            try {
				byte[] bytes = file.getBytes();
				os = new FileOutputStream(new File(saveTaget));
				os.write(bytes);
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				IOUtils.close(os);
			}
       }
        return "{'original':'"+file.getOriginalFilename()+"','url':'"+CMSConstants.DOMAIN_NAME+relativeURL+"','title':'"+title+"','state':'"+"SUCCESS"+"'}";
    }
	
	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		if(ex instanceof MaxUploadSizeExceededException){
			try {
				response.setHeader("Content-Type", "text/javascript");
				PrintWriter writer = response.getWriter();
				writer.print("{state:'图片不得大于1M！'}");
				writer.flush();
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public String handleException(Exception ex,HttpServletRequest request) { 
		ex.printStackTrace();
		return "{state:'图片不得大于1M！'}";
	}
	
}

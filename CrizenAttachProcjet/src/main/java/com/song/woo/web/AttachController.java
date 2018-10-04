package com.song.woo.web;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.multipart.MultipartFile;

import com.song.woo.model.AttachInfo;
import com.song.woo.service.AttachManager;


@Controller
public class AttachController {
	private Logger logger=LoggerFactory.getLogger(AttachController.class);
	//업로드한 파일이 저장되는 경로
	private String pathFile="C:\\my\\image\\";
	
	@Autowired
	private AttachManager service;
	
	//파일업로드 뷰이동
	@RequestMapping("/")
	public String attachForm() {
		return "uploadForm";
	}
	

	//파일업로드 기능
	@RequestMapping(value="/fileupload.do",method=RequestMethod.POST)
	public String uploadForm(AttachInfo info , Model model) throws Exception{
		//화면에서 넘어온 정보들과 파일저장경로를 전달 
		AttachInfo dto=service.uploadFile(info, pathFile);//파일업로드실행, 파일정보 반환 
		model.addAttribute("savedName",dto.getSaveName());//파일경로 모델에저장
		return "uploadResult";//결과뷰로 이동하며 업로드폼의 iframe에 표출됨
	}

//	//업로드결과 화면창 이동
	@RequestMapping(value="/uploadResult.do",method=RequestMethod.GET)
	public String uploadResult() {
		 return "uploadResult";
	}
	
	//업로드한 사진 조회-seq
	@RequestMapping(value="/profile.do", method=RequestMethod.GET)
	public String profile(Model model, Long seq) {
		seq=(long) 1;
		AttachInfo dto= service.attachDetail(seq);
		model.addAttribute("dto",dto);
		logger.debug("조회할 경로 : {}",dto.getPathFile());
		return "profile";
	}
	
	
//	파일다운로드 분석중
	@RequestMapping(value="/common/downloadFile.do")
	public void downloadFile(AttachInfo dto, HttpServletResponse response) throws Exception{
		
	    String storedFileName = (String)dto.getPathFile();
	    String originalFileName = (String)dto.getNmFile();
	     
	    byte fileByte[] = FileUtils.readFileToByteArray(new File("C:\\dev\\file\\"+storedFileName));
	     
	    response.setContentType("application/octet-stream");
	    response.setContentLength(fileByte.length);
	    response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(originalFileName,"UTF-8")+"\";");
	    response.setHeader("Content-Transfer-Encoding", "binary");
	    response.getOutputStream().write(fileByte);
	     
	    response.getOutputStream().flush();
	    response.getOutputStream().close();
	}



	
	
}

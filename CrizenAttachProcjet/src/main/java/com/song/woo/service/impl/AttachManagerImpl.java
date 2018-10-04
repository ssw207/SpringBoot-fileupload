package com.song.woo.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.song.woo.dao.AttachRepository;
import com.song.woo.model.AttachInfo;
import com.song.woo.service.AttachManager;
import com.song.woo.web.AttachController;


@Service
public class AttachManagerImpl implements AttachManager {
	private Logger logger=LoggerFactory.getLogger(AttachController.class);
	@Autowired
	private AttachRepository dao;

	//파일정보입력기능(파일이름, 파일크기,파일저장명)
	@Override
	public void attachInsert(AttachInfo info) {
		dao.save(info);
	}

	//파일 단일 조회가능(일련번호)
	@Override
	public AttachInfo attachDetail(long seq) {//일련번호와 일차하는 데이터를 출력
		AttachInfo one = dao.findOne(seq); 
		return one;
	}

	//파일업로드 기능 트렌젝션 처리
	@Transactional
	@Override
	public AttachInfo uploadFile(AttachInfo info,String uploadPath) {
		//화면에서 넘어온 request 값을 매핑한 dto객체에서 파일추출;
		MultipartFile file=info.getUploadFile();
		logger.info("파일존재여부 : {}",file);

		//사용자가 업로드한 파일에서 정보 추출
		String nmFile= file.getOriginalFilename();//파일의 원본이름
		logger.info("파일이름 : {}",nmFile);
		long sizeFile = file.getSize();
		logger.info("파일크기 : {}",sizeFile);

		UUID uid=UUID.randomUUID();//난수생성
		String savedName=uid.toString()+"-"+nmFile;//원본파일명+난수=파일을 저장경로
		File target=new File(uploadPath,savedName);//파일 객체생성
		
		try {
			FileCopyUtils.copy(file.getBytes(), target);//파일다운로드
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//파일을 로컬에 다운
		
		//dto에 파일정보를 입력
		info.setNmFile(nmFile);
		info.setSizeFile(sizeFile);
		info.setSaveName(savedName);
		info.setPathFile(uploadPath);
		
		//입력한정보를 db에 저장
		dao.save(info);
		return info;//dto반환
	}

	///미사용
	//파일리스트 조회기능(계약번호), 파일이름출력
	@Override
	public List<AttachInfo> attachList() {
		List<AttachInfo> list =dao.findAll();
		return list;
	}

}

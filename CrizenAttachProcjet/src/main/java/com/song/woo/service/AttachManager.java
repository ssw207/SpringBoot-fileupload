package com.song.woo.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.song.woo.model.AttachInfo;

public interface AttachManager {
	//파일정보입력기능(파일이름, 파일크기,파일저장명)
	public void attachInsert(AttachInfo info);
	//파일 업로드 기능, 업로드 경로 반환
	public AttachInfo uploadFile(AttachInfo info,String uploadPath);
	//파일 단일 조회가능(일련번호)
	public AttachInfo attachDetail(long seq);
	
	//파일리스트 조회기능(계약번호), 파일이름출력
	public List<AttachInfo> attachList();
	
	
}

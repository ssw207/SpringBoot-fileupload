package com.song.woo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "AttachInfo")
public class AttachInfo {
	
	@Id//pk
	@GeneratedValue(strategy = GenerationType.AUTO)//seq
	private long seq;
	
	private String saveName;
	
	@Column(name="nmFile")
	private String nmFile;
	
	@Column(name="pathFile")
	private String pathFile;
	
	@Column(name="memo")
	private String memo;
	
	@Column(name="sizeFile")
	private long sizeFile;
	
	@Transient
	MultipartFile uploadFile;
	
	public AttachInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AttachInfo(String saveName, String nmFile, String pathFile, String memo, long sizeFile) {
		super();
		this.saveName = saveName;
		this.nmFile = nmFile;
		this.pathFile = pathFile;
		this.memo = memo;
		this.sizeFile = sizeFile;
	}

	@Override
	public String toString() {
		return "AttachInfo [seq=" + seq + ", saveName=" + saveName + ", nmFile=" + nmFile + ", pathFile=" + pathFile
				+ ", memo=" + memo + ", sizeFile=" + sizeFile + ", uploadFile=" + uploadFile + "]";
	}

	public long getSeq() {
		return seq;
	}

	public void setSeq(long seq) {
		this.seq = seq;
	}

	public String getSaveName() {
		return saveName;
	}

	public void setSaveName(String saveName) {
		this.saveName = saveName;
	}

	public String getNmFile() {
		return nmFile;
	}

	public void setNmFile(String nmFile) {
		this.nmFile = nmFile;
	}

	public String getPathFile() {
		return pathFile;
	}

	public void setPathFile(String pathFile) {
		this.pathFile = pathFile;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public long getSizeFile() {
		return sizeFile;
	}

	public void setSizeFile(long sizeFile) {
		this.sizeFile = sizeFile;
	}

	public MultipartFile getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}

	
}

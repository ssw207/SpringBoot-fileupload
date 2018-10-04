package com.song.woo.dao;
 
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.song.woo.model.AttachInfo;
import com.song.woo.service.AttachManager;

 

//dao의 역할을 함
@Repository("AttachRepository")
public interface AttachRepository extends JpaRepository<AttachInfo, Long>{

//	void save(AttachManager info);

}


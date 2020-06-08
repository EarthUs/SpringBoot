package com.svg.etu.location;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("LocationService")
public class LocationServiceImpl implements LocationService {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	@Override
	public LocationVO getLocation(LocationVO vo) {
		LocationVO temp = sqlSessionTemplate.selectOne("getLocation", vo);
		return temp;
	}

}

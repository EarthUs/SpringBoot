package com.svg.etu.feed;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.svg.etu.location.LocationVO;
import com.svg.etu.user.UserVO;

@Service("FeedService")
public class FeedServiceImpl implements FeedService {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public void insertFeed(FeedVO vo) {	
		System.out.println("----------[InsertFeed 함수 호출]----------");
		sqlSessionTemplate.insert("insertFeed", vo);
	}

	@Override
	public List<FeedVO> getFeedList(LocationVO vo) {
		System.out.println("----------[getFeedList 함수 호출]----------");
		List<FeedVO> feedList = sqlSessionTemplate.selectList("getFeedList", vo); 
		return feedList;
	}

	@Override
	public List<Map<String, Object>> getFeedCountForType(LocationVO vo) {
		System.out.println("----------[getFeedList 함수 호출]----------");
		List<Map<String, Object>> feedCountList = sqlSessionTemplate.selectList("getFeedCountForType", vo); 
		return feedCountList;
	}
	
	@Override
	public int getMyFeedCount(UserVO vo) {
		System.out.println("----------[getMyFeedCount 함수 호출]----------");
		int count = sqlSessionTemplate.selectOne("getMyFeedCount", vo);
		return count;
	}

	
	
	
}

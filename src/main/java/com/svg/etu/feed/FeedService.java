package com.svg.etu.feed;

import java.util.List;
import java.util.Map;

import com.svg.etu.location.LocationVO;
import com.svg.etu.user.UserVO;

public interface FeedService {
	
	/*
	 * Feed를 삽입하는 함수
	 */
	void insertFeed(FeedVO vo);
	
	/*
	 * 지역에 맞는 Feed 리스트를 가져오는 함수
	 */
	List<FeedVO> getFeedList(LocationVO vo);

	/*
	 * 지역에 맞는 쓰레기종류별 Feed 개수를 반환하는 함수
	 */
	public List<Map<String, Object>> getFeedCountForType(LocationVO vo);
	
	/*
	 * User가 주운 쓰레기 수를 반환하는 함수
	 */
	int getMyFeedCount(UserVO vo);

	
}

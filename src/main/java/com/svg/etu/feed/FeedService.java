package com.svg.etu.feed;

import java.util.List;

import com.svg.etu.location.LocationVO;
import com.svg.etu.user.UserVO;

public interface FeedService {
	
	/*
	 * Feed를 삽입하는 함수
	 */
	void insertFeed(FeedVO vo);
	
	/*
	 * Feed 리스트를 가져오는 함수
	 */
	List<FeedVO> getFeedList(LocationVO vo);

	/*
	 * User가 주운 쓰레기 수를 반환하는 함수
	 */
	int getMyFeedCount(UserVO vo);

	
}

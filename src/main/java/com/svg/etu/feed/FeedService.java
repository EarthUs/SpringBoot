package com.svg.etu.feed;

import java.util.List;

public interface FeedService {
	
	/*
	 * Feed를 삽입하는 함수
	 */
	void insertFeed(FeedVO vo);
	
	/*
	 * Feed 리스트를 가져오는 함수
	 */
	List<FeedVO> getFeedList(int location);

	
}

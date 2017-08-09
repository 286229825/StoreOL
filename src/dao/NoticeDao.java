package dao;

import java.util.List;

import entity.Notice;

public interface NoticeDao extends BaseDao<Notice> {
	
	public List<Notice> getAllByLimit(int page, int rows);
}	

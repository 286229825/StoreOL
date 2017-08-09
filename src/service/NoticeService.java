package service;

import java.util.List;

import entity.Notice;

public interface NoticeService {

	public void addOne(Notice notice);

	public List<Notice> getAll();
	
	public List<Notice> getAllByLimit(int page, int rows);
	
	public void deleteOne(Notice notice);

	public Notice getOne(Integer id);
	
	public void updateOne(Notice notice);
}

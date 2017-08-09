package service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import dao.NoticeDao;
import entity.Notice;

@Transactional
public class NoticeServiceImpl implements NoticeService{
	private NoticeDao noticeDao;
	public void setNoticeDao(NoticeDao noticeDao) {
		this.noticeDao = noticeDao;
	}
	public void addOne(Notice notice) {
		noticeDao.add(notice);
	}
	public List<Notice> getAll() {
		return noticeDao.getAll();
	}
	public List<Notice> getAllByLimit(int page, int rows) {
		return noticeDao.getAllByLimit(page,rows);
	}
	public void deleteOne(Notice notice) {
		noticeDao.delete(notice);
	}
	public Notice getOne(Integer id) {
		return noticeDao.getOne(id);
	}
	public void updateOne(Notice notice) {
		noticeDao.update(notice);
	}
}

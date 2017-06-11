package service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import dao.NoticeDaoImpl;
import entity.Notice;

@Transactional
public class NoticeService {
	private NoticeDaoImpl noticeDaoImpl;
	public void setNoticeDaoImpl(NoticeDaoImpl noticeDaoImpl) {
		this.noticeDaoImpl = noticeDaoImpl;
	}
	public void addOne(Notice notice) {
		noticeDaoImpl.add(notice);
	}
	public List<Notice> getAll() {
		return noticeDaoImpl.getAll();
	}
	public List<Notice> getAllByLimit(int page, int rows) {
		return noticeDaoImpl.getAllByLimit(page,rows);
	}
	public void deleteOne(Notice notice) {
		noticeDaoImpl.delete(notice);
	}
	public Notice getOne(Integer id) {
		return noticeDaoImpl.getOne(id);
	}
	public void updateOne(Notice notice) {
		noticeDaoImpl.update(notice);
	}
}

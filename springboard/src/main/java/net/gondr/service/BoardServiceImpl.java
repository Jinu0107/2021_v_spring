package net.gondr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.gondr.dao.BoardDAO;
import net.gondr.dao.UserDAO;
import net.gondr.domain.BoardVO;
import net.gondr.domain.Criteria;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDAO dao;

	@Autowired
	private UserDAO userDao;

	@Override
	public void writeArticle(BoardVO board) {
		userDao.updateExp(board.getWriter());
		userDao.updateLevel(board.getWriter());
		dao.write(board);
	}

	@Override
	public BoardVO viewArticle(Integer id) {
		return dao.view(id);
	}

	@Override
	public List<BoardVO> getArticleList(Integer start, Integer cnt) {
		return dao.list(start, cnt);
	}

	@Override
	public void updateArticleList(BoardVO board) {
		dao.update(board);
	}

	@Override
	public void deleteArticle(Integer id) {
		dao.delete(id);
	}

	@Override
	public Integer countArticle() {
		return dao.getCnt();
	}

	@Override
	public List<BoardVO> getCriteriaList(Criteria c) {
		return dao.list(c);
	}

	@Override
	public Integer countCriteria(Criteria c) {
		return dao.getCnt(c);
	}

	@Override
	public BoardVO userAuth(Integer id, String userid) {
		return dao.userAuth(id, userid);
	}
	
	
}

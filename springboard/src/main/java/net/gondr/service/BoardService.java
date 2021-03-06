package net.gondr.service;

import java.util.List;

import net.gondr.domain.BoardVO;
import net.gondr.domain.Criteria;
import net.gondr.domain.UserVO;

public interface BoardService {
	public void writeArticle(BoardVO board);

	public BoardVO viewArticle(Integer id);

	public List<BoardVO> getArticleList(Integer start, Integer cnt);

	public void updateArticleList(BoardVO board);

	public void deleteArticle(Integer id);

	public Integer countArticle();

	public List<BoardVO> getCriteriaList(Criteria c);

	public Integer countCriteria(Criteria c);
	
	public BoardVO userAuth(Integer id , String userid);
}

package net.gondr.dao;

import java.util.List;

import net.gondr.domain.BoardVO;
import net.gondr.domain.Criteria;
import net.gondr.domain.UserVO;

public interface BoardDAO {
	public void write(BoardVO data);

	public BoardVO view(Integer id);

	public List<BoardVO> list(Integer start, Integer cnt);
	public List<BoardVO> list(Criteria c);

	public void delete(Integer id);

	public void update(BoardVO data);
	
	public Integer getCnt();
	public Integer getCnt(Criteria c);
	public BoardVO userAuth(Integer id, String userid);
}

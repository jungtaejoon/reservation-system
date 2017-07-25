package com.juhyung.reservation.persistence;

import java.util.List;

import com.juhyung.reservation.domain.Comment;
import com.juhyung.reservation.domain.PageCriteria;

public interface CommentDAO {
	
	public List<Comment> selectCommentByProductId(int id);
	public List<Comment> selectSampleCommnet(int id, PageCriteria pageCriteria);
	public int selectCountComments(int id);
	public Double selectAverageScore(int id);

}

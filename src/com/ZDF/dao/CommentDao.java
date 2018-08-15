package com.ZDF.dao;

import java.util.List;

import com.ZDF.beans.Comment;
import com.ZDF.beans.CommentMsg;

public interface CommentDao {
	/**
	 * �û�ͨ�������Ų鿴�Լ���������Ϣ
	 * @param orderNum
	 * @param userId
	 * @return
	 */
	List<CommentMsg> getCommentMsg(String orderNum,int userId);
	
	/**
	 * �����Ʒ����
	 * @param comment
	 * @return
	 */
	int insertComment(Comment comment);
}

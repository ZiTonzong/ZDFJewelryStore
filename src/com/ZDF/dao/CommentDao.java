package com.ZDF.dao;

import java.util.List;

import com.ZDF.beans.Comment;
import com.ZDF.beans.CommentMsg;

public interface CommentDao {
	/**
	 * 用户通过订单号查看自己的评价信息
	 * @param orderNum
	 * @param userId
	 * @return
	 */
	List<CommentMsg> getCommentMsg(String orderNum,int userId);
	
	/**
	 * 添加商品评价
	 * @param comment
	 * @return
	 */
	int insertComment(Comment comment);
}

package com.ZDF.dao;

import com.ZDF.beans.Manager;

public interface Manager_dao {
	/**
	 * 通过管理员账号获取管理员
	 * @param managerName
	 * @return
	 */
	Manager getManagerByName(String managerName);
}

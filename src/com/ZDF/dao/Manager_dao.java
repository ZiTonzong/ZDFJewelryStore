package com.ZDF.dao;

import com.ZDF.beans.Manager;

public interface Manager_dao {
	/**
	 * ͨ������Ա�˺Ż�ȡ����Ա
	 * @param managerName
	 * @return
	 */
	Manager getManagerByName(String managerName);
}

package com.ZDF.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ZDF.beans.Product;
import com.ZDF.dao.factory.DBdao;
import com.ZDF.utils.Basedao;


/*
 * ʵ��DBdao�ӿ�
 */
public class DBdaoImpl implements DBdao {
	
	/*
	 * ͳһ��ӷ�����ʵ��
	 * @see com.ZDF.dao.factory.DBdao#addUploadDelete(java.lang.String, java.lang.Object[])
	 */
	public static boolean addUploadDelete(String sql, Object[] arr) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = Basedao.getCon();	//�������ݿ�
			pstmt = conn.prepareStatement(sql);		//Ԥ����
			//����ֵ,��֤arr�������ݵ�����´������ݿ�
			if (arr != null && arr.length != 0) {
				for (int i = 0; i < arr.length; i++) {
					pstmt.setObject(i+1, arr[i]);
				}
			}
			int count = pstmt.executeUpdate();	//ִ��sql���
			if (count > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/*
	 * �����Ʒ�ķ���ʵ��
	 * @see com.ZDF.dao.factory.DBdao#register(com.ZDF.beans.Product)
	 */
	public boolean register(Product product) {
		String sql = "insert into product values(null,?,?,?,?,?,?,?,0)";

		List<Object> list = new ArrayList<Object>();
		list.add(product.getCategoryId());
		list.add(product.getProductName());
		list.add(product.getProductPrice());
		list.add(product.getProductDesc());
		list.add(product.getProductImagePath());
		list.add(product.getStoreNum());
		list.add(product.getProductStatus());
		
		boolean flag = DBdaoImpl.addUploadDelete(sql, list.toArray());
		if (flag) {
			return true;
		}else {
			return false;
		}
	}
	
	/*
	 * ͨ��id������Ʒ
	 */
	public Product selectProduct(int PRODUCT_ID) {
		Product product = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = "select * from product where PRODUCT_ID = ?";
		Connection conn = Basedao.getCon();
		//System.out.println(PRODUCT_ID);
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, PRODUCT_ID);
			rs = pstm.executeQuery();
			while (rs.next()) {	
				System.out.println(rs.getInt(1));
				product = new Product(rs.getInt(1), rs.getInt(2), rs.getInt("STORE_NUM"),
					rs.getInt("PRODUCT_STATUS"), rs.getDouble("PRODUCT_PRICE"), 
					rs.getString("PRODUCT_NAME"),rs.getString("PRODUCT_DESC"),
					rs.getString("PRODUCT_IMAGE_PATH"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			Basedao.close(conn, pstm, rs);
		}
		return product;
	}
	
	/*
	 * ͨ����Ʒ���Ʋ�����Ʒ��Ϣ������ʵ��
	 */
	@Override
	public List<Product> selectProduct(String PRODUCT_NAME) {
		Product product = null;
		List<Product> list = new ArrayList<Product>();
		String sql = "select * from product where product_name like ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = Basedao.getCon();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+PRODUCT_NAME+"%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				product = new Product(rs.getInt(1), rs.getInt(2), rs.getInt("STORE_NUM"),
						rs.getInt("PRODUCT_STATUS"), rs.getDouble("PRODUCT_PRICE"), 
						rs.getString("PRODUCT_NAME"),rs.getString("PRODUCT_DESC"),
						rs.getString("PRODUCT_IMAGE_PATH"));
				list.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Basedao.close(conn, pstmt, rs);
		}
		
		return list;
	}
	
	/*
	 * �����ܵ�ҳ��
	 */
	@Override
	public int getPage() {
		//t2Ϊ��ҳ��,ÿҳ�����������
		int recordCount = 0,t1 = 0,t2 = 0;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		Connection conn = Basedao.getCon();
		String sql = "SELECT COUNT(*) FROM product";
		
		try {
			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeQuery();
			result.next();
			recordCount = result.getInt(1);
			t1 = recordCount%5;
			t2 = recordCount/5;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Basedao.close(conn, pstmt, result);
		}
		if (t1 != 0) {
			t2 = t2+1;
		}
		return t2;
		
	}
	
	/*
	 * ͨ����Ʒ���Ʋ�ѯҳ��
	 */
	@Override
	public int getPage(String PRODUCT_NAME) {
		//t2Ϊ��ҳ��,ÿҳ�����������
		int recordCount = 0,t1 = 0,t2 = 0;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		Connection conn = Basedao.getCon();
		String sql = "SELECT COUNT(*) FROM product where PRODUCT_NAME like ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+PRODUCT_NAME+"%");
			result = pstmt.executeQuery();
			result.next();
			recordCount = result.getInt(1);
			t1 = recordCount%5;
			t2 = recordCount/5;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Basedao.close(conn, pstmt, result);
		}
		if (t1 != 0) {
			t2 = t2+1;
		}
		return t2;
		
	}
	
	/*
	 * ��ѯָ��ҳ������
	 */
	@Override
	public List<Product> listProduct(int pageNo) {
		PreparedStatement pstmt = null;
		ResultSet result = null;
		List<Product> list = new ArrayList<Product>();
		int pageSize = 5;
		int page = (pageNo - 1)*5;
		Connection conn = Basedao.getCon();
		String sql = "SELECT * FROM product ORDER BY PRODUCT_STATUS DESC, PRODUCT_ID LIMIT ?,?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, page);
			pstmt.setInt(2, pageSize);
			result = pstmt.executeQuery();
			while (result.next()) {
				Product product = new Product(result.getInt(1), result.getInt(2), result.getInt("STORE_NUM"), result.getInt("PRODUCT_STATUS"), result.getDouble("PRODUCT_PRICE"), result.getString("PRODUCT_NAME"), result.getString("PRODUCT_DESC"), result.getString("PRODUCT_IMAGE_PATH"));
				list.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Basedao.close(conn, pstmt, result);
		}
		return list;
	}

	/*
	 * ������Ʒ�ķ���ʵ��
	 */
	public boolean updateProductName(int PRODUCT_ID, String PRODUCT_NAME) {
		PreparedStatement pstm = null;
		int rs = 0;
		String sql = "update PRODUCT set PRODUCT_NAME = ? where PRODUCT_ID=?";
		Connection conn = Basedao.getCon();
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, PRODUCT_NAME);
			pstm.setInt(2, PRODUCT_ID);
			rs = pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Basedao.close(conn, pstm, null);
		}
		return false;
	}

	@Override
	public boolean updateProductPrice(int PRODUCT_ID, double PRODUCT_PRICE) {
		PreparedStatement pstm = null;
		int rs = 0;
		String sql = "update PRODUCT set PRODUCT_PRICE = ? where PRODUCT_ID=?";
		Connection conn = Basedao.getCon();
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setDouble(1, PRODUCT_PRICE);
			pstm.setInt(2, PRODUCT_ID);
			rs = pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Basedao.close(conn, pstm, null);
		}
		return false;
	}

	@Override
	public boolean updateProductDesc(int PRODUCT_ID, String PRODUCT_DESC) {
		PreparedStatement pstm = null;
		int rs = 0;
		String sql = "update PRODUCT set PRODUCT_DESC = ? where PRODUCT_ID=?";
		Connection conn = Basedao.getCon();
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, PRODUCT_DESC);
			pstm.setInt(2, PRODUCT_ID);
			rs = pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Basedao.close(conn, pstm, null);
		}
		return false;
	}

	@Override
	public boolean updateProductImage(int PRODUCT_ID, String PRODUCT_IMAGE_PATH) {
		PreparedStatement pstm = null;
		int rs = 0;
		String sql = "update PRODUCT set PRODUCT_IMAGE_PATH = ? where PRODUCT_ID=?";
		Connection conn = Basedao.getCon();
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, PRODUCT_IMAGE_PATH);
			pstm.setInt(2, PRODUCT_ID);
			rs = pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Basedao.close(conn, pstm, null);
		}
		return false;
	}

	@Override
	public boolean updateProductNum(int PRODUCT_ID, int STORE_NUM) {
		PreparedStatement pstm = null;
		int rs = 0;
		String sql = "update PRODUCT set STORE_NUM = ? where PRODUCT_ID=?";
		Connection conn = Basedao.getCon();
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, STORE_NUM);
			pstm.setInt(2, PRODUCT_ID);
			rs = pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Basedao.close(conn, pstm, null);
		}
		return false;
	}

	@Override
	public boolean updateProductStatus(int PRODUCT_ID, int PRODUCT_STATUS) {
		PreparedStatement pstm = null;
		int rs = 0;
		String sql = "update PRODUCT set PRODUCT_STATUS = ? where PRODUCT_ID=?";
		Connection conn = Basedao.getCon();
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, PRODUCT_STATUS);
			pstm.setInt(2, PRODUCT_ID);
			rs = pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Basedao.close(conn, pstm, null);
		}
		return false;
	}

	/*
	 * ɾ��������Ʒ������ʵ��
	 */
	public boolean deleteProduct(int PRODUCT_ID) {
		PreparedStatement pstm = null;
		int i = 0;
		String sql = "DELETE FROM PRODUCT WHERE PRODUCT_ID = ?";
		Connection conn = Basedao.getCon();
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, PRODUCT_ID);
			i = pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Basedao.close(conn, pstm,null);
		}
		return false;
	}

	/*
	 * ͨ����Ʒ����id��ѯ��ҳ��
	 */
	public int getPage(int CATEGORY_ID) {
		//t2Ϊ��ҳ��,ÿҳ�����������
				int recordCount = 0,t1 = 0,t2 = 0;
				PreparedStatement pstmt = null;
				ResultSet result = null;
				Connection conn = Basedao.getCon();
				String sql = "SELECT COUNT(*) FROM product where CATEGORY_ID = ?";
				
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, CATEGORY_ID);
					result = pstmt.executeQuery();
					result.next();
					recordCount = result.getInt(1);
					t1 = recordCount%5;
					t2 = recordCount/5;
					
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					Basedao.close(conn, pstmt, result);
				}
				if (t1 != 0) {
					t2 = t2+1;
				}
				return t2;
				
	}

	/*
	 * ָ�����Ʋ�ѯָ��ҳ������
	 */
	public List<Product> listProduct(String PRODUCT_NAME, int pageNo) {
		PreparedStatement pstmt = null;
		ResultSet result = null;
		List<Product> list = new ArrayList<Product>();
		int pageSize = 5;
		int page = (pageNo - 1)*5;
		Connection conn = Basedao.getCon();
		String sql = "SELECT * FROM product WHERE PRODUCT_NAME like ? ORDER BY PRODUCT_STATUS DESC, PRODUCT_ID LIMIT ?,? ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+PRODUCT_NAME+"%");
			pstmt.setInt(2, page);
			pstmt.setInt(3, pageSize);
			result = pstmt.executeQuery();
			while (result.next()) {
				Product product = new Product(result.getInt(1), result.getInt(2), result.getInt("STORE_NUM"), result.getInt("PRODUCT_STATUS"), result.getDouble("PRODUCT_PRICE"), result.getString("PRODUCT_NAME"), result.getString("PRODUCT_DESC"), result.getString("PRODUCT_IMAGE_PATH"));
				list.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Basedao.close(conn, pstmt, result);
		}
		return list;
	}

	/*
	 * ָ������id��ѯָ��ҳ������
	 */
	public List<Product> listProduct(int CATEGORY_ID, int pageNo) {
		PreparedStatement pstmt = null;
		ResultSet result = null;
		List<Product> list = new ArrayList<Product>();
		int pageSize = 5;
		int page = (pageNo - 1)*5;
		Connection conn = Basedao.getCon();
		String sql = "SELECT * FROM product WHERE product.CATEGORY_ID = ? ORDER BY PRODUCT_STATUS DESC, PRODUCT_ID LIMIT ?,? ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, CATEGORY_ID);
			pstmt.setInt(2, page);
			pstmt.setInt(3, pageSize);
			result = pstmt.executeQuery();
			while (result.next()) {
				Product product = new Product(result.getInt(1), result.getInt(2), result.getInt("STORE_NUM"), result.getInt("PRODUCT_STATUS"), result.getDouble("PRODUCT_PRICE"), result.getString("PRODUCT_NAME"), result.getString("PRODUCT_DESC"), result.getString("PRODUCT_IMAGE_PATH"));
				list.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Basedao.close(conn, pstmt, result);
		}
		return list;
	}

	/*
	 * ָ������ѯָ������ָ��ҳ�������
	 */
	public List<Product> listProduct(int CATEGORY_ID, String PRODUCT_NAME, int pageNo) {
		PreparedStatement pstmt = null;
		ResultSet result = null;
		List<Product> list = new ArrayList<Product>();
		int pageSize = 5;
		int page = (pageNo - 1)*5;
		Connection conn = Basedao.getCon();
		String sql = "SELECT * FROM product WHERE PRODUCT_NAME like ? AND CATEGORY_ID=? ORDER BY PRODUCT_STATUS DESC, PRODUCT_ID LIMIT ?,? ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+PRODUCT_NAME+"%");
			pstmt.setInt(2, CATEGORY_ID);
			pstmt.setInt(3, page);
			pstmt.setInt(4, pageSize);
			result = pstmt.executeQuery();
			while (result.next()) {
				Product product = new Product(result.getInt(1), result.getInt(2), result.getInt("STORE_NUM"), result.getInt("PRODUCT_STATUS"), result.getDouble("PRODUCT_PRICE"), result.getString("PRODUCT_NAME"), result.getString("PRODUCT_DESC"), result.getString("PRODUCT_IMAGE_PATH"));
				list.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Basedao.close(conn, pstmt, result);
		}
		return list;
	}

	/*
	 * ͨ��������Ʋ�ѯҳ��
	 */
	public int getPage(String PRODUCT_NAME, int CATEGORY_ID) {
		//t2Ϊ��ҳ��,ÿҳ�����������
		int recordCount = 0,t1 = 0,t2 = 0;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		Connection conn = Basedao.getCon();
		String sql = "SELECT COUNT(*) FROM product where CATEGORY_ID = ? and PRODUCT_NAME like ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, CATEGORY_ID);
			pstmt.setString(2,"%" +PRODUCT_NAME+"%");
			result = pstmt.executeQuery();
			result.next();
			recordCount = result.getInt(1);
			t1 = recordCount%5;
			t2 = recordCount/5;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Basedao.close(conn, pstmt, result);
		}
		if (t1 != 0) {
			t2 = t2+1;
		}
		return t2;
	}
}

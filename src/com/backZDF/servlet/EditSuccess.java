package com.backZDF.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import com.ZDF.beans.Product;
import com.ZDF.dao.factory.DBdao;
import com.ZDF.dao.impl.DBdaoImpl;


/**
 * Servlet implementation class ChangeProductStatus
 */
@WebServlet("/editSuccess")
public class EditSuccess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditSuccess() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HashMap<String, String> map =new HashMap<String,String>();
		Product product = new Product();
		
		DiskFileItemFactory fac = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(fac);
		try {
			List<FileItem> list = upload.parseRequest(request);	
			
			for (FileItem fileItem : list) {
				if (fileItem.isFormField()) {
					fileItem.getFieldName();
					map.put(fileItem.getFieldName(), fileItem.getString("UTF-8"));
				} else {
					InputStream is = fileItem.getInputStream();		//用InputStream获取图片数据
					//String realpath = getServletContext().getRealPath("/ZDFJewelry/WebContent/back/Images/");
					//String path = "E:\\apache-tomcat-9.0.8\\images\\";
					String path = "E:\\Tomcat9.0\\source\\images";
					File file = new File(path,fileItem.getName());
					if (!file.exists()) {
						file.createNewFile();
					}
					
					OutputStream os = new FileOutputStream(file);
					
					IOUtils.copy(is, os);	//将is复制到os
					IOUtils.closeQuietly(is);	//释放资源
					IOUtils.closeQuietly(os);
					
					//map中存入一个键值对的数据
					map.put("PRODUCT_IMAGE_PATH", "images/"+fileItem.getName());
				}
			}
			//BeanUtils.populate(product, map);
			product.setCategoryId(Integer.parseInt(map.get("CATEGORY_ID")));
			product.setProductName(map.get("PRODUCT_NAME"));
			product.setProductPrice(Double.parseDouble(map.get("PRODUCT_PRICE")));
			product.setProductDesc(map.get("PRODUCT_DESC"));
			product.setStoreNum(Integer.parseInt(map.get("STORE_NUM")));
			product.setProductImagePath(map.get("PRODUCT_IMAGE_PATH"));
			product.setProductStatus(Integer.parseInt(map.get("PRODUCT_STATUS")));
			System.out.println("map存入product对象");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("map存入product失败");
		}
		DBdao dao = new DBdaoImpl();
		//接收传来的数据
		String pagenos = request.getParameter("pageNos");
		String product_id = request.getParameter("PRODUCT_ID");
		//类型转换
		int pageNos	= Integer.parseInt(pagenos);
		int PRODUCT_ID	= Integer.parseInt(product_id);
		//商品修改
		dao.updateProductName(PRODUCT_ID, product.getProductName());
		dao.updateProductPrice(PRODUCT_ID, product.getProductPrice());
		dao.updateProductNum(PRODUCT_ID, product.getStoreNum());
		dao.updateProductImage(PRODUCT_ID, product.getProductImagePath());
		dao.updateProductStatus(PRODUCT_ID, product.getProductStatus());
		dao.updateProductDesc(PRODUCT_ID, product.getProductDesc());
		
		request.setAttribute("product", product);
		request.setAttribute("pageNos", pageNos);
		request.getRequestDispatcher("/back/Product/editSuccess.jsp").forward(request, response);
	
	}

}

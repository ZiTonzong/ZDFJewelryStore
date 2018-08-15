package com.backZDF.servlet;

import java.io.*;
import java.util.*;

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

@WebServlet("/addproductservlet")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
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
					//String realpath = getServletContext().getRealPath("/Images/");
					String path = "E:\\Tomcat9.0\\source\\images";
					//String path = getServletContext().getRealPath("/back/Images/");
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
			System.out.println("product:"+product);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("map存入product失败");
		}
		DBdao dao = new DBdaoImpl();
		boolean flag = dao.register(product);
		if(flag){
	        request.setAttribute("product", product);
	        request.getRequestDispatcher("/back/Product/addSuccess.jsp").forward(request, response);
	     }
	}

}

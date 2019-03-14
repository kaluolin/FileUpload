package com.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class FileUploadAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5551423180182721852L;

	 // 封装单个上传文件域的属性
	 private File upload;

	 // 封装单个上传文件类型的属性
	 private String uploadContentType;

	 // 封装单个上传文件名的属性
	 private String uploadFileName;

	 // 动态设置上传文件保存地址
	 private String savePath;

	 public String getSavePath() {
	  // return ServletActionContext.getRequest().getRealPath("");
	  String onload = "C://";
	  HttpServletRequest request = ServletActionContext.getRequest();
	  request.setAttribute("onload", onload);
	  // return ServletActionContext.getRequest().getContextPath();
	  return onload;
	 }
	 
	 public void setSavePath(String savePath) {
		  this.savePath = savePath;
	 }

	 // 上传单个文件的文件类型的setter和getter方法
	 public void setUploadContentType(String uploadContentType) {
		  this.uploadContentType = uploadContentType;
	 }

	 public String getUploadContentType() {
		 return (this.uploadContentType);
	 }

	 // 上传单个文件的文件名的setter和getter方法
	 public void setUploadFileName(String uploadFileName) {
		 this.uploadFileName = uploadFileName;
	 }
		 
	 public String getUploadFileName() {
		 return (this.uploadFileName);
	 }
	 
	 public File getUpload() {
		 return upload;
	 }

	 public void setUpload(File upload) {
		 this.upload = upload;
		 // savePath = ServletActionContext .getRequest().getRealPath("");
	 }

	 // 上传单个文件
	 @SuppressWarnings("deprecation")
	 public String upload() {
		 try {
			 // 以服务器的文件保存地址和原文件名建立上传文件输出流
			 System.out.println(ServletActionContext.getRequest().getRealPath("")+ File.separator
				     + "images"+ File.separator+ getUploadFileName()+"路径");
			 FileOutputStream fos = new FileOutputStream(ServletActionContext.getRequest().getRealPath("")+ File.separator
				     + "images"+ File.separator+ getUploadFileName());
			 
			 // 以上传文件建立一个文件上传流
			 FileInputStream fis = new FileInputStream(getUpload());
			 // 将上传文件的内容写入服务器
			 byte[] buffer = new byte[1024];
			 int len = 0;
			 while ((len = fis.read(buffer)) > 0) {
				 fos.write(buffer, 0, len);
			 }
		 } catch (Exception e) {
			 e.printStackTrace();
		 }
		 return SUCCESS;
	 }
}

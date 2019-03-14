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

	 // ��װ�����ϴ��ļ��������
	 private File upload;

	 // ��װ�����ϴ��ļ����͵�����
	 private String uploadContentType;

	 // ��װ�����ϴ��ļ���������
	 private String uploadFileName;

	 // ��̬�����ϴ��ļ������ַ
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

	 // �ϴ������ļ����ļ����͵�setter��getter����
	 public void setUploadContentType(String uploadContentType) {
		  this.uploadContentType = uploadContentType;
	 }

	 public String getUploadContentType() {
		 return (this.uploadContentType);
	 }

	 // �ϴ������ļ����ļ�����setter��getter����
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

	 // �ϴ������ļ�
	 @SuppressWarnings("deprecation")
	 public String upload() {
		 try {
			 // �Է��������ļ������ַ��ԭ�ļ��������ϴ��ļ������
			 System.out.println(ServletActionContext.getRequest().getRealPath("")+ File.separator
				     + "images"+ File.separator+ getUploadFileName()+"·��");
			 FileOutputStream fos = new FileOutputStream(ServletActionContext.getRequest().getRealPath("")+ File.separator
				     + "images"+ File.separator+ getUploadFileName());
			 
			 // ���ϴ��ļ�����һ���ļ��ϴ���
			 FileInputStream fis = new FileInputStream(getUpload());
			 // ���ϴ��ļ�������д�������
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

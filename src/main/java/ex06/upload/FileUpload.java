package ex06.upload;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.metal.MetalIconFactory.FileIcon16;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@SuppressWarnings("serial")
@WebServlet("/upload.do")
public class FileUpload extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doHandler(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doHandler(req, resp);
	}
	
	protected void doHandler(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("파일 업로드 요청 : doGet(), doPost()...");
		
		req.setCharacterEncoding("utf-8");
		
		File currentPath = new File("c:\\upload"); // 업로드할 파일 경로 설정
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(currentPath);
		factory.setSizeThreshold(1024*1024);// 최대 파일 크기 설정
		
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		try {
			List<FileItem> items = upload.parseRequest(req);
			
			 for (int i=0; i<items.size(); i++) {
				 FileItem fileItem = items.get(i);
				 
				 
				 if (fileItem.isFormField()) {
					 System.out.println("-- 매개변수일 경우");
					 
					 System.out.println(fileItem.getFieldName()+"="+fileItem.getString("utf-8"));
				 } else {
					 System.out.println("-- 파일 업로드 기능 일 경우");
					 
					 System.out.println("매개변수 이름:"+fileItem.getFieldName());
					 System.out.println("파일 이름:"+fileItem.getName());
					 System.out.println("파일 크기:"+fileItem.getSize()+"bytes");
					 
					 // 첨부파일이 있는 경우
					 if (fileItem.getSize()>0) {
						 // C:\javaStudy\open_jdk\jdk-17\releasef.txt
						 int idx = fileItem.getName().lastIndexOf("\\");
						 
						 if (idx == -1) {
							 idx = fileItem.getName().lastIndexOf("/");
						 }
						 
						 // 업로드한 파일 이름으로  저장소에 파일 업로드
						 String fileName = fileItem.getName().substring(idx+1);
						 // "c:\\upload\\+"releasef.txt"
						 File uploadFile = new File(currentPath+"\\"+fileName);
						 fileItem.write(uploadFile);
					 }// 처부파일 있을 경우
					 
				 }// 파일 업로드
				 
			 }// end for
			
		} catch (Exception e) {e.getMessage();}
		
		
		
		
		
	}	
}

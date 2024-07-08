package ex06.download;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.jni.FileInfo;


@SuppressWarnings("serial")
@WebServlet("/download.do")
public class FileDownLoad  extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doHandler(req, resp);
	}
	@Override 
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doHandler(req, resp);
	}
	
	protected void doHandler(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("파일 다운로드 요청 : doGet(), doPost()...");
		
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		
		
		String file_upload = "c:\\upload";
		String fileName = req.getParameter("fileName");
		System.out.println("파일이름: "+fileName);
		
		OutputStream out = resp.getOutputStream();
		String downFile = file_upload + File.separator+fileName;
		
		
		File f = new File(downFile);
		resp.setHeader("Cache-Control", "no-cache");// 파일이름 유지
		resp.addHeader("Content-disposition", "attachment;fileName="+fileName);
		
		FileInputStream in = new FileInputStream(f);
		byte[] buffer = new byte[1024*8];
		
		while(true) {
			int count= in.read(buffer);
			if (count == -1) break;
			out.write(buffer, 0, count);
		}
		in.close();

		
	}
}

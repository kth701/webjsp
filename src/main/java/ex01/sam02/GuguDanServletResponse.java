package ex01.sam02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/gugudan")
public class GuguDanServletResponse extends HttpServlet {
	@Override
	public void init() throws ServletException {
		System.out.println("LoginServletResponse init()...");
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doHandler(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doHandler(req, resp);
	}
	protected void doHandler(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		int dan = Integer.parseInt(req.getParameter("dan"));
		
		System.out.println(dan*10);
		
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		String htm_str = """
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단 View Page</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">


</head>
<body>
<div class="container ">	
<table class="table">
  <thead>
    <tr>
      <th scope="col"  colspan='2'>구구단</th>
    </tr>
  </thead>
  <tbody>
				""";
		//---------------------------------
		
		for (int i=1; i<=9; i++) {
			//System.out.println(dan*i);
			htm_str += "<tr>";
			htm_str += "	<td>"+dan+"*"+i+"</td>";
			htm_str += "	<td>" + (dan*i)+"</td>";
			htm_str += "</tr>";
		}
		
		
		//------------------------------
		htm_str += """

  </tbody>
</table>					
</div>	
	
	
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
</body>
</html>				
				""";
		
		out.print(htm_str);
		
	}
}

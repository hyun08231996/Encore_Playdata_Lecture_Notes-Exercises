package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

@WebServlet(urlPatterns = "/front.do", loadOnStartup = 1)
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 가장먼저 해야하는 일은 클라이언트로부터 어떤 요청이 들어오는지를 알아야 한다...command값 받아온다.
		String command = request.getParameter("command");
		
		String path = "index.html";//error page, home
		
		//1. RegisterServlet의 doProcess(){안에 있는 코드를 직접 여기에 작성... 권장하지 않는다...
		//2. method로 하나 뽑아내서 그 메소드 안에서 RegisterServlet의 doProcess(){ 안에 있는 코드를 작성...이 방법을 추천!
		if(command.equals("register")) {
			path = register(request, response);
		}else if(command.equals("find")) {
			path = find(request, response);
		}else if(command.equals("login")) {
			path = login(request, response);
		}else if(command.equals("allmember")) {
			path = allmember(request, response);
		}else if(command.equals("logout")) {
			path = logout(request, response);
		}else if(command.equals("update")) {
			path = update(request, response);
		}
		
		//모든 메소드가 수행을 한 뒤 다시 이곳으로 돌아온다...
		request.getRequestDispatcher(path).forward(request, response);
		
	}

	protected String register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String path="register_fail.jsp";

		MemberVO pvo = new MemberVO(id, password, name, address);

		try {
			MemberDAOImpl.getInstance().registerMember(pvo);
			request.setAttribute("name", pvo.getName());
			path = "register_result.jsp";
			
		}catch(SQLException e) {
			
		}
		
		return path;
	}
	
	protected String find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String path = "find_fail.jsp";
		try {
			MemberVO rvo = MemberDAOImpl.getInstance().findByIdMember(id);
			if(rvo!=null) {
				request.setAttribute("vo", rvo);
				path = "find_ok.jsp";
			}
			
		}catch(SQLException e) {
			
		}
		
		return path;
	}
	
	protected String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String path = "";
		try {
			MemberVO rvo = MemberDAOImpl.getInstance().login(id, password);
			
			//세션에 저장해야지만 로그인 동안 인증을 계속 유지할 수 있다.
			HttpSession session = request.getSession();
			if(rvo!=null) {
				session.setAttribute("vo", rvo);
				System.out.println("JSESSIONID :: "+session.getId());
				path = "login_result.jsp";
			}
			
		}catch(Exception e) {
			
		}
		
		return path;
	}
	
	protected String allmember(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "";
		
		try {
			ArrayList<MemberVO> list = MemberDAOImpl.getInstance().showAllMember();
			
			request.setAttribute("list", list);
			path = "allView.jsp";
			
		}catch(SQLException e) {
			
		}
		
		return path;
	}
	
	protected String logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "";

		HttpSession session = request.getSession();
		if(session.getAttribute("vo")!=null) {
			session.invalidate();
			path = "logout.jsp";
		}
		
		return path;
	}
	
	protected String update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 로그인, 정보수정 로직은 반드시 세션에 바인딩...
		 */
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String password = request.getParameter("password");
		String path="index.jsp";

		MemberVO pvo = new MemberVO(id, password, name, address);

		try {
			HttpSession session = request.getSession();
			
			MemberDAOImpl.getInstance().updateMember(pvo);
			if(session.getAttribute("vo")!=null) {
				session.setAttribute("vo", pvo);
				path = "update_result.jsp";
			}
		
		}catch(SQLException e) {
			
		}
		
		return path;
	}

}

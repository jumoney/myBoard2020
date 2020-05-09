package kr.koreait.myboard;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.koreait.myboard.db.BoardDAO;
import kr.koreait.myboard.vo.BoardVO;
import kr.koreait.myboard.vo.UserVO;





@WebServlet("/boardDel")
public class BoardDeleteSev extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs = request.getSession();
		UserVO loginUser = (UserVO)hs.getAttribute("loginUser");
		if(loginUser == null) {
			response.sendRedirect("/login");
			return;
		}
		BoardVO param = new BoardVO();
		
		String i_board = request.getParameter("i_board");
		int intBoard = Utils.parseStringToInt(i_board, 0);
		
		if(intBoard == 0) { //문제 발생!!!
			
		}
		param.setI_board(intBoard);
		param.setI_user(loginUser.getI_user());
		
		int result = BoardDAO.delBoard(param);//(리턴값) 0: 문제 발생, 1: 삭제 완료
		
		if(result == 0)
		{
			return;
		}
		
		response.sendRedirect("/boardList");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

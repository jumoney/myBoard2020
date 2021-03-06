package kr.koreait.myboard;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.koreait.myboard.db.BoardCommentDAO;
import kr.koreait.myboard.db.BoardDAO;
import kr.koreait.myboard.vo.BoardVO;

@WebServlet("/boardDetail")
public class BoardDetailSev extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String commentResult = request.getParameter("commentResult");
		String commentDelResult = request.getParameter("commentDelResult");
				
		if("0".equals(commentResult)) {
			request.setAttribute("msg", "댓글 등록에 실패하였습니다.");
		} else if("0".equals(commentDelResult)) {
			request.setAttribute("msg", "댓글 삭제에 실패하였습니다.");
		}
		
		String i_board = request.getParameter("i_board");		
		int intI_board = Integer.parseInt(i_board);
				
		System.out.println("i_board: " + intI_board);
				
		BoardVO param = new BoardVO();
		param.setI_board(intI_board);		
		
		BoardDAO.updateBoardHits(param);			
		request.setAttribute("detail", BoardDAO.getBoard(param));
		
		request.setAttribute("commentList", BoardCommentDAO.getBoardCommentList(intI_board));
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/boardDetail.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package kr.or.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

	public class LoginInterceptor implements HandlerInterceptor {
 
		private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
		
		@Override
		public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
			logger.info("preHandle 진입");
		 
			try {
				String id=  request.getParameter("id");
				logger.info("prehandle id: " + id );
				if(id == null || id.equals("")){
					response.sendRedirect(request.getContextPath()+"/");
					logger.info("SendRedirect end");
					return false;
				}
			} catch (Exception e) {
				logger.error("preHandle sendRedirect error");
				e.printStackTrace();
			}
			return true;
		}
		@Override
		public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
			logger.info("postHandle 진입");

			HttpSession session = request.getSession();
			String id=  request.getParameter("id");
	        logger.info("post handle id: " +id );
	        if(id != null) {
	            // 로그인 성공시 Session에 저장후, 초기 화면 이동
	            session.setAttribute("id", id);
	            logger.info("id Setting ");
	        }
		}
		@Override
		public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
			logger.info("afterCompletion 진입");
		}

	}
 
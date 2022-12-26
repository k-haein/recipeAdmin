package kr.co.kosmo.mvc.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import kr.co.kosmo.mvc.dao.AdminInfoDao;
import kr.co.kosmo.mvc.dao.LoginLogDao;
import kr.co.kosmo.mvc.dto.LoginLogDTO;





@Component
@Aspect
public class LoginLogAspect {

	@Autowired
	private LoginLogDao loginLogDao;
	
	@Autowired
	private AdminInfoDao adminInfoDao;

	@Around("execution(* kr.co.kosmo.mvc.controller.AdminInfoController.log_*(..))")
	public ModelAndView loginLogger(ProceedingJoinPoint jp) {
		// ���ڰ�
		Object[] fd = jp.getArgs();
		ModelAndView rpath = null;
		// �޼��� �̸�
		String methodName = jp.getSignature().getName();
		if (methodName.equals("log_loginCheck")) {
			// ���ǰ��� �ִٸ� �α��� ���� ����
			LoginLogDTO vo = new LoginLogDTO();
			try {
				rpath = (ModelAndView) jp.proceed(); // target�� �޼��带 ȣ���Ѵ�.
				// ù��°���ڿ� �ι��� �ΰ����� ������ �ν��Ͻ� �� ��쿡�� ����
				if (fd[0] instanceof HttpSession && fd[1] instanceof HttpServletRequest) {
					HttpSession session = (HttpSession) fd[0];
					HttpServletRequest request = (HttpServletRequest) fd[1];
					String ad_email = (String) session.getAttribute("ad_email");
					// ������ ���� ���ͼ� ������ ��츸
					if (ad_email!=null) {
						// �����ͺ��̽��� ������ ���� ����
						vo.setAd_no((int)session.getAttribute("ad_no"));
						vo.setLog_status("로그인");
						vo.setLog_reip(getClientIpAddr(request));
						vo.setLog_login_fl("y");
						vo.setLog_uagent("web");
						loginLogDao.addLoginLog(vo);
					}else {
						ad_email = (String)request.getParameter("ad_email");
						int ad_no = adminInfoDao.ad_no(ad_email);
						vo.setAd_no(ad_no);
						vo.setLog_status("로그인");
						vo.setLog_reip(getClientIpAddr(request));
						vo.setLog_login_fl("n");
						vo.setLog_uagent("web");
						loginLogDao.addLoginLog(vo);
					}
				}
			} catch (Throwable e) {
				e.printStackTrace();
			}
		} else if (methodName.equals("log_logout")) {
			LoginLogDTO vo = new LoginLogDTO();
			try {
				if (fd[0] instanceof HttpSession && fd[1] instanceof HttpServletRequest) {
					HttpSession session = (HttpSession) fd[0];
					HttpServletRequest request = (HttpServletRequest) fd[1];
					int ad_no = (int) session.getAttribute("ad_no");
					if (ad_no != 0) { // ������ ������ �� ó�� 
						// �����ͺ��̽��� ������ ���� ����
						vo.setAd_no(ad_no);
						vo.setLog_status("로그아웃");
						vo.setLog_reip(getClientIpAddr(request));
						vo.setLog_login_fl("y");
						vo.setLog_uagent("web");
						loginLogDao.addLoginLog(vo);
					}
					// logoutó�� 
					rpath = (ModelAndView) jp.proceed();
				}
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
		return rpath;

	}
	
	//ip�޾ƿ���
	public static String getClientIpAddr(HttpServletRequest request) {
	    String ip = request.getHeader("X-Forwarded-For"); 
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	        ip = request.getHeader("Proxy-Client-IP");
	    }
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	        ip = request.getHeader("WL-Proxy-Client-IP");
	    }
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	        ip = request.getHeader("HTTP_CLIENT_IP");
	    }
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	        ip = request.getHeader("HTTP_X_FORWARDED_FOR");
	    }
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	        ip = request.getRemoteAddr();
	    } 
	    return ip;
	}
}



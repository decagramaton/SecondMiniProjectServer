package com.mycompany.yogitour.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestOperationsExtensionsKt;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import com.mycompany.yogitour.dto.UserInfo;
import com.mycompany.yogitour.service.UserInfoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoginCheckInterceptor implements HandlerInterceptor{
	@Autowired
	private UserInfoService userInfoService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		boolean checkResult = true;
		
		HandlerMethod hm = (HandlerMethod) handler;
		Login login = hm.getMethodAnnotation(Login.class);
		
		if(login != null) {
			String userId = request.getParameter("userId");
			String userPassword = request.getParameter("userPassword");
			
			if(userId != null && userPassword != null) {
				UserInfo dbMember = userInfoService.getUserInfo(userId);
				
				if(dbMember == null) {
					checkResult = false;
				} else {
					if(!dbMember.getUserPassword().endsWith(userPassword)) {
						checkResult = false;
					}
				}
			} else {
				checkResult = false;
			}
		}
		
		
		if(checkResult == false) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("result", "fail_login");
			String json = jsonObject.toString();
			
			response.setContentType("application/json; charset=UTF-8");
			
			PrintWriter pw = response.getWriter();
			pw.write(json);
			pw.flush();
			pw.close();
		}
		
		return checkResult;
	}
}

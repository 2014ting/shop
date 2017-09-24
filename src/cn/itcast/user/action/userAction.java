package cn.itcast.user.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.Utils.UUIDUtil;
import cn.itcast.user.entity.User;
import cn.itcast.user.service.IUserService;

public class userAction extends ActionSupport implements ModelDriven<User>{
	private User user=new User();
	@Override
	public User getModel() {
		return user;
	}
	private IUserService userService;
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	public IUserService getUserService() {
		return userService;
	}
	public String registerpage() throws Exception {
		System.out.println("lalllll+++++++lllllllll");
		return "registerpage";
	}
	public String loginpage() throws Exception {
		System.out.println("lallllllllllllll");
		return "loginpage";
	}
	public String login() throws Exception {
		User exitsUser = userService.login(user);
		System.out.println("登录信息"+exitsUser);
		if(exitsUser != null){
			//登录成功
			ServletActionContext.getRequest().getSession().setAttribute("exitsUser",exitsUser );
			System.out.println("登录信息"+exitsUser);
			return "loginsuccess";
		}else{
			this.addActionError("用户名或密码错误！");
			//登录失败
			return "loginpage";
		}
		
	}
	public String quit() throws Exception {
		//退出，销毁session
		ServletActionContext.getRequest().getSession().invalidate();
		return "quit";
	}
	
	public String checkusername() throws Exception {
		System.out.println(user);
		System.out.println(user.getUsername());
		User existuser = userService.findByName(user.getUsername());
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		String tip ="用户名可以使用";
		if(existuser!=null){
			tip = "用户名已存在";
		}
		PrintWriter pw = response.getWriter();
		pw.write(tip);
		pw.flush();
		pw.close();
		return NONE;
	}
	public String regist() throws Exception {
		String checkcode = (String)ServletActionContext.getRequest().getSession().getAttribute("checkcode");
		String CheckCode = ServletActionContext.getRequest().getParameter("checkcode");
		if(checkcode.equalsIgnoreCase(CheckCode)){
			//验证码输入正确
			user.setState(0+"");
			String code =UUIDUtil.getuuid();
			user.setCode(code);
			userService.save(user);
			return "registsuccess";
		}else{
			this.addActionMessage("验证码输入错误");
			return "registerpage";
		}
	
	}
	public String active() throws Exception {
		
		return "msg";
	}
	
}

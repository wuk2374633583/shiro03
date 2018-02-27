package java123.shiro.com;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

public class ShiroHello {
	public static void main(String[] args) {
		
		// 读取配置文件，初始化SecurityManager工厂
		Factory<SecurityManager> factory=new IniSecurityManagerFactory("classpath:jdbc_realm.ini");
		// 获取securityManager实例
		SecurityManager securityManager=factory.getInstance();
		// 把securityManager实例绑定到SecurityUtils
		SecurityUtils.setSecurityManager(securityManager);
		// 得到当前执行的用户
		Subject currentUser=SecurityUtils.getSubject();
		System.out.println(currentUser.getPrincipal());
		// 创建token令牌，用户名/密码
		UsernamePasswordToken token=new UsernamePasswordToken("wukk","123456");
		// 身份认证
		try {
			currentUser.login(token);
			System.out.println("身份认证成功");
			//得到当前用户名称
			System.out.println(currentUser.getPrincipal());
		} catch (AuthenticationException e) {
			// TODO Auto-generated catch block
			System.out.println("身份认证失败");
			e.printStackTrace();
		}
		// 退出
		currentUser.logout();
		
		
	}
}

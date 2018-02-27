package java123.shiro.com;

import java.util.Arrays;

import java123.common.com.ShiroUtil;

import org.apache.shiro.subject.Subject;
import org.junit.Test;

public class RoleTest {

	//has验证 有返回值 值为Boolean
	@Test
	public void testHasRole(){
		Subject subject= ShiroUtil.getSubject("classpath:shiro_role.ini","jack","123");
		//验证一个用户拥有单个角色
		Boolean bool= subject.hasRole("role1");
		System.out.println(bool?"Jack有role1角色":"Jack没有role1角色");
		//验证一个用户有多个角色,逐个判断
		boolean[] bools=subject.hasRoles(Arrays.asList("role1","role2"));
		System.out.println(bools[0]+","+bools[1]);
		//判断是否拥有多个角色，一次性判断
		boolean allBool=subject.hasAllRoles(Arrays.asList("role1","role2","role3"));
		System.out.println(allBool);
	}
	
	//check验证 无返回值 不成功会报出异常
	@Test
	public void testCheckRole(){
		Subject subject= ShiroUtil.getSubject("classpath:shiro_role.ini","jack","123");
		//验证一个用户拥有单个角色
		subject.checkRole("role1");
		
		//验证一个用户有多个角色,逐个判断
		subject.checkRoles(Arrays.asList("role1","role2"));
		
		//判断是否拥有多个角色，一次性判断
		subject.checkRoles("role1","role2","role3");
	}
}

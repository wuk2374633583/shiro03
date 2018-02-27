package java123.shiro.com;

import java.util.Arrays;

import java123.common.com.ShiroUtil;

import org.apache.shiro.subject.Subject;
import org.junit.Test;

public class PermissionTest {


	@Test
	public void testPermission1(){
		Subject subject= ShiroUtil.getSubject("classpath:shiro_permission.ini","java1234","123456");
		//У���û�java1234��û���û���ѯȨ��
		System.out.println(subject.isPermitted("user:select"));
	}
	
	@Test
	public void testPermission2(){
		Subject subject= ShiroUtil.getSubject("classpath:shiro_permission.ini","jack","123");
		//У���û�jack��û��ɾ�� ����Ȩ��
		boolean[] bool=subject.isPermitted("user:delete","user:update");
		System.out.println(bool[0]+","+bool[1]);
		
		Boolean bool1=subject.isPermittedAll("user:delete","user:update");
		System.out.println(bool1);
		
	}
	
	@Test
	public void testCheckPermission(){
		Subject subject= ShiroUtil.getSubject("classpath:shiro_permission.ini","jack","123");
		//У���û�jack��û��ɾ�� ����Ȩ��
		subject.checkPermission("user:delete");
		
		subject.checkPermissions("user:delete","user:update");

		
	}
}

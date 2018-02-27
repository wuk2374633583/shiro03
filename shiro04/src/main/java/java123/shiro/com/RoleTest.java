package java123.shiro.com;

import java.util.Arrays;

import java123.common.com.ShiroUtil;

import org.apache.shiro.subject.Subject;
import org.junit.Test;

public class RoleTest {

	//has��֤ �з���ֵ ֵΪBoolean
	@Test
	public void testHasRole(){
		Subject subject= ShiroUtil.getSubject("classpath:shiro_role.ini","jack","123");
		//��֤һ���û�ӵ�е�����ɫ
		Boolean bool= subject.hasRole("role1");
		System.out.println(bool?"Jack��role1��ɫ":"Jackû��role1��ɫ");
		//��֤һ���û��ж����ɫ,����ж�
		boolean[] bools=subject.hasRoles(Arrays.asList("role1","role2"));
		System.out.println(bools[0]+","+bools[1]);
		//�ж��Ƿ�ӵ�ж����ɫ��һ�����ж�
		boolean allBool=subject.hasAllRoles(Arrays.asList("role1","role2","role3"));
		System.out.println(allBool);
	}
	
	//check��֤ �޷���ֵ ���ɹ��ᱨ���쳣
	@Test
	public void testCheckRole(){
		Subject subject= ShiroUtil.getSubject("classpath:shiro_role.ini","jack","123");
		//��֤һ���û�ӵ�е�����ɫ
		subject.checkRole("role1");
		
		//��֤һ���û��ж����ɫ,����ж�
		subject.checkRoles(Arrays.asList("role1","role2"));
		
		//�ж��Ƿ�ӵ�ж����ɫ��һ�����ж�
		subject.checkRoles("role1","role2","role3");
	}
}

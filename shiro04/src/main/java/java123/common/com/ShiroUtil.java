package java123.common.com;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

public class ShiroUtil {

	public  static Subject getSubject(String classpath,String name,String password){
		
		// ��ȡ�����ļ�����ʼ��SecurityManager����
				Factory<SecurityManager> factory=new IniSecurityManagerFactory(classpath);
				// ��ȡsecurityManagerʵ��
				SecurityManager securityManager=factory.getInstance();
				// ��securityManagerʵ���󶨵�SecurityUtils
				SecurityUtils.setSecurityManager(securityManager);
				// �õ���ǰִ�е��û�
				Subject currentUser=SecurityUtils.getSubject();
				// ����token���ƣ��û���/����
				UsernamePasswordToken token=new UsernamePasswordToken(name,password);
				// �����֤
				try {
					  currentUser.login(token);
					System.out.println("�����֤�ɹ�");
					//�õ���ǰ�û�����
					System.out.println(currentUser.getPrincipal());
				} catch (AuthenticationException e) {
					// TODO Auto-generated catch block
					System.out.println("�����֤ʧ��");
					e.printStackTrace();
				}
				return currentUser;
	}
}

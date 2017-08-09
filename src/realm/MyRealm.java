package realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import entity.User;
import service.RoleService;

public class MyRealm extends AuthorizingRealm{
	
	private RoleService roleService;
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		// TODO Auto-generated method stub
		String name=(String) principalCollection.getPrimaryPrincipal();
		SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
		try {
			authorizationInfo.setRoles(roleService.getRoles(name));
			authorizationInfo.setStringPermissions(roleService.getPermissons(name));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return authorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		// TODO Auto-generated method stub
		String name = (String) authenticationToken.getPrincipal();
		User user;
		try {
			user = roleService.getUser(name);
			if (user != null) {
				AuthenticationInfo authenticationInfo=new SimpleAuthenticationInfo(user.getName(),user.getPassword(), "xx");
				return authenticationInfo;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}

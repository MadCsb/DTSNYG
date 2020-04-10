package com.msy.travel.shiro;

import com.msy.travel.pojo.RoleData;
import com.msy.travel.pojo.User;
import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * Created by cheng on 2020/4/9.
 * 用户名 密码 角色信息 token
 */
public class UsernamePasswordRoledataToken extends UsernamePasswordToken {

  private RoleData roleData;

  public UsernamePasswordRoledataToken(final String username, final String password,final RoleData roleData) {
    super(username,password);
    this.roleData = roleData;
  }
  public RoleData getRoleData() {
    return roleData;
  }
}

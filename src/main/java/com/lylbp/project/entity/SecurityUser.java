package com.lylbp.project.entity;

import com.lylbp.core.properties.ProjectProperties;
import com.lylbp.manger.security.entity.PermissionAuthority;
import com.lylbp.project.enums.TrueOrFalseEnum;
import com.lylbp.project.vo.RoleVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.*;

/**
 * @Author weiwenbin
 * @Date 2020/6/30 下午4:43
 */
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Component
public class SecurityUser implements UserDetails, Serializable {
    @ApiModelProperty("账号是否为超级管理员")
    private Boolean isSupperAdmin;

    @ApiModelProperty("用户对象")
    private Admin admin;

    @ApiModelProperty("用户对应的角色集合")
    private List<RoleVO> roleList;

    @ApiModelProperty("用户权限地址集合")
    private List<PermissionAuthority> authorities;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return admin.getPwd();
    }

    @Override
    public String getUsername() {
        return admin.getLoginAccount();
    }

    /**
     * 账号是否过期
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 用户账号是否被锁定
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 用户密码是否过期
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 用户是否可用
     */
    @Override
    public boolean isEnabled() {
        return admin.getIsEnabled().equals(TrueOrFalseEnum.TRUE.getCode());
    }
}


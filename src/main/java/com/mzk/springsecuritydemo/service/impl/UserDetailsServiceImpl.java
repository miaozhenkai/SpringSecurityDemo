package com.mzk.springsecuritydemo.service.impl;

import com.mzk.springsecuritydemo.mapper.TRoleMapper;
import com.mzk.springsecuritydemo.mapper.TUserMapper;
import com.mzk.springsecuritydemo.mapper.TUserRoleMapper;
import com.mzk.springsecuritydemo.pojo.UserDetail;
import com.mzk.springsecuritydemo.pojo.dto.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author miaozhenkai
 * @version 2021-07-12  17:21
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    TUserMapper userMapper;
    @Autowired
    TUserRoleMapper tUserRoleMapper;
    @Autowired
    TRoleMapper tRoleMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetail userDetail = new UserDetail();

        TUserExample tUserExample = new TUserExample();
        tUserExample.createCriteria().andUsernameEqualTo(username);
        List<TUser> tUsers =  userMapper.selectByExample(tUserExample);
        if (tUsers.isEmpty()){
            throw new UsernameNotFoundException("用户不存在");
        }

        BeanUtils.copyProperties(tUsers.get(0), userDetail);
        TUserRoleExample tUserRoleExample = new TUserRoleExample();
        tUserRoleExample.createCriteria().andUserIdEqualTo(tUsers.get(0).getId());
        List<TUserRole> tUserRoles = tUserRoleMapper.selectByExample(tUserRoleExample);
        List<Long> roleIds = new ArrayList<>();

        tUserRoles.forEach(tUserRole ->{
            roleIds.add(tUserRole.getRoleId());
        });

        TRoleExample tRoleExample = new TRoleExample();
        tRoleExample.createCriteria().andIdIn(roleIds);
        List<TRole> tRoles = tRoleMapper.selectByExample(tRoleExample);
        userDetail.setRoles(tRoles);
        return userDetail;
    }

}
package com.zx.zxtest.service.impl;

import com.google.common.collect.Lists;
import com.zx.zxtest.entity.User;
import com.zx.zxtest.mapper.UserMapper;
import com.zx.zxtest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired(required = false)
    private UserMapper userMapper;


    @Override
    public List<User> findAllUser() {
        List<User> userList = userMapper.findAllUser();
        List<User> mainList = Lists.newArrayList();
        mainList =
                userList.stream().filter(e -> 0 == e.getPid()).collect(Collectors.toList());
        for (User user : mainList) {
            List<User> childrenList = this.childrenList(user,
                    userList);
            user.setChildrenList(childrenList);
        }

        return mainList;
    }

    private List<User> childrenList(User user, List<User> userList) {
        List<User> childrenList = Lists.newLinkedList();
        if (null != userList && userList.size() > 0) {
            childrenList =
                    userList.stream().filter(e -> user.getId().equals(e.getPid())).collect(Collectors.toList());
            for (int i = 0; i < childrenList.size(); i++) {
                User nodeUser = childrenList.get(i);
                List<User> list =
                        userList.stream().filter(e -> nodeUser.getId().equals(e.getPid())).collect(Collectors.toList());
                if (list.size() > 0) {
                    this.childrenList(nodeUser, userList);
                }
                nodeUser.setChildrenList(list);
            }
        }
        return childrenList;
    }
}

package com.albert.mapper;

import com.albert.pojo.User;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

@Service
public interface UserMapper extends Mapper<User> {
}

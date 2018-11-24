package com.web.hzxy.dao;

import com.web.hzxy.entity.Content;
import org.springframework.stereotype.Repository;

@Repository
public interface ContDao {
    int insert(Content content);
}

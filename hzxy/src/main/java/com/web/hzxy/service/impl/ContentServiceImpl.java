package com.web.hzxy.service.impl;

import com.web.hzxy.dao.ContDao;
import com.web.hzxy.entity.Content;
import com.web.hzxy.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContentServiceImpl implements ContentService{
    @Autowired
    private ContDao contDao;

    @Override
    public int insert(Content content) {
        return contDao.insert(content);
    }
}

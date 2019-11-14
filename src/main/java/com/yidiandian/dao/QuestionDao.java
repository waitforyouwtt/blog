package com.yidiandian.dao;

import com.yidiandian.entity.Question;
import com.yidiandian.view.QuestionView;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/11/14 9:57
 * @Email: 15290810931@163.com
 */
@Mapper
public interface QuestionDao {

    /**
     * 根据条件进行查询
     * @param view
     * @return
     */
    List<Question> findByParams(QuestionView view);
}

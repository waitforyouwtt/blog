package com.yidiandian.service;

import com.yidiandian.entity.Question;
import com.yidiandian.view.QuestionView;
import java.util.List;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/11/13 20:10
 * @Email: 15290810931@163.com
 */
public interface QuestionService {

    /**
     * 新增
     * @param view
     * @return
     */
    Question saveQuestion(QuestionView view);

    /**
     * 根据条件查询记录
     * @param view
     * @return
     */
    List<QuestionView> findByParams(QuestionView view);
}

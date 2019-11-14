package com.yidiandian.service.impl;

import com.alibaba.fastjson.JSON;
import com.yidiandian.dao.QuestionDao;
import com.yidiandian.entity.Article;
import com.yidiandian.entity.FriendshipLink;
import com.yidiandian.entity.Question;
import com.yidiandian.enums.DeleteEnum;
import com.yidiandian.jpa.QuestionMapper;
import com.yidiandian.service.QuestionService;
import com.yidiandian.view.ArticleView;
import com.yidiandian.view.FriendshipLinkView;
import com.yidiandian.view.QuestionView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/11/13 20:12
 * @Email: 15290810931@163.com
 */
@Slf4j
@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    QuestionDao questionDao;

    @Autowired
    QuestionMapper questionMapper;

    /**
     * 新增
     *
     * @param view
     * @return
     */
    @Override
    public Question saveQuestion(QuestionView view) {
        Question question = new Question();
        BeanCopier beanCopier = BeanCopier.create(QuestionView.class,Question.class,false);
        beanCopier.copy(view,question,null);
        question.setCreateTime(new Date());
        question.setUpdateTime(new Date());
        log.info("添加请求的参数：{}", JSON.toJSON(question));
        Question result = questionMapper.save(question);
        log.info("添加返回的结果：{}", JSON.toJSON(result));
        return result;
    }

    /**
     * 根据条件查询记录
     *
     * @param view
     * @return
     */
    @Override
    public List<QuestionView> findByParams(QuestionView view) {
        List<QuestionView> views = new ArrayList<>();
        view.setIsDelete(DeleteEnum.NORMAL.getCode());
        List<Question> findQuestions = questionDao.findByParams(view).stream().distinct().collect(Collectors.toList());
        if (CollectionUtils.isEmpty(findQuestions)){
            return new ArrayList<>();
        }
        getQuestionList(views,findQuestions);
        return views;
    }

    private void getQuestionList(List<QuestionView> views, List<Question> findQuestions) {
        findQuestions.stream().forEach(question -> {
            QuestionView view = new QuestionView();
            BeanCopier beanCopier = BeanCopier.create(FriendshipLink.class,FriendshipLinkView.class,false);
            beanCopier.copy(question,view,null);
            views.add(view);
        });
    }
}

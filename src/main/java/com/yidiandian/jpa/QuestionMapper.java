package com.yidiandian.jpa;

import com.yidiandian.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/11/14 9:57
 * @Email: 15290810931@163.com
 */
public interface QuestionMapper extends JpaRepository<Question,Integer>{
}

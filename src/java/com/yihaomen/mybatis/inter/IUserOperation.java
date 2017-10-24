package com.yihaomen.mybatis.inter;
import com.yihaomen.mybatis.model.Article;
import com.yihaomen.mybatis.model.User;

import java.util.List;

// selectUserByID 必须和xml中的配置相同
public interface IUserOperation {
    User selectUserByID(int id);
    List<User>  selectUsers(String username);
    void insertUser(User user);
    void updateUser(User user);
    void deleteUser(User user);
    List<Article> getUserArticles(int id);
}

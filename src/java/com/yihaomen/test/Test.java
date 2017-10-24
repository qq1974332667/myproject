package com.yihaomen.test;

import java.io.Reader;
import java.util.List;

import com.yihaomen.mybatis.inter.IUserOperation;
import com.yihaomen.mybatis.model.Article;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.yihaomen.mybatis.model.User;

public class Test {
    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;

    static{
        try{
            reader    = Resources.getResourceAsReader("Configuration.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSession(){
        return sqlSessionFactory;
    }
////    一
//    public static void main(String[] args) {
//        SqlSession session = sqlSessionFactory.openSession();
//        try {
//            User user = (User) session.selectOne("cc.selectUserByID", 1);
//            System.out.println(user.getUserAddress());
//            System.out.println(user.getUserName());
//        } finally {
//            session.close();
//        }
//    }

     public static void main(String[] arg){
         SqlSession session = sqlSessionFactory.openSession();
         try {
//             根据user.xml中配置的namespace来找到IUserOperation
             IUserOperation userOperation=session.getMapper(IUserOperation.class);
             List<Article> list = userOperation.getUserArticles(1);

             for(Article a:list){
                 System.out.println(a.getTitle());
                 System.out.println(a.getUser().getUserName());
             }



         } finally {
             session.close();
         }

     }
}
package com.df.drs.base.dao;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program:
 * @description: 基础Dao
 * @author: zxb
 * @create: 2019-09-18 17:38
 **/
public class BaseDao extends SqlSessionDaoSupport {

    @Autowired
    protected SqlSessionTemplate sqlSessionTemplate;

    /**
     * sql对应地址
     */
    protected String url = "";

    @Resource
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    /**
     * 批量添加
     *
     * @param statement 对应配置文件sql
     * @param dataList  更新数据
     * @return
     */
    protected boolean insertBatch(String statement, List<Map<String, Object>> dataList) throws Exception {
        return batchOperate(statement, dataList, 0);
    }

    /**
     * 批量更新
     *
     * @param statement 对应配置文件sql
     * @param dataList  更新数据
     * @return
     */
    protected boolean updateBatch(String statement, List<Map<String, Object>> dataList) throws Exception {
        return batchOperate(statement, dataList, 2);
    }

    /**
     * 批量删除
     *
     * @param statement 对应配置文件sql
     * @param dataList  更新数据
     * @return
     */
    protected boolean deleteBatch(String statement, List<Map<String, Object>> dataList) throws Exception {
        return batchOperate(statement, dataList, 1);
    }


    /**
     * 批量处理
     *
     * @param statement 对应配置文件sql
     * @param dataList  更新数据
     * @param type      批量更新类型 0 添加 1 删除 其他更新
     * @return
     */
    private boolean batchOperate(String statement, List<Map<String, Object>> dataList, int type) throws Exception {
        boolean isSuccess = false;
        if (null == dataList || dataList.isEmpty()) {
            return isSuccess;
        }
        //批处理方式 SqlSession
        SqlSession sqlSession = this.sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH, false);
        try {
            Map<String, Object> paramMap = new HashMap<String, Object>();
            long i = 1L;
            for (Map<String, Object> info : dataList) {
                switch (type) {
                    case 0:
                        //添加
                        sqlSession.insert(statement, info);
                        break;
                    case 1:
                        //删除
                        sqlSession.delete(statement, dataList);
                    default:
                        //更新
                        sqlSession.update(statement, info);
                        break;
                }
                i = ++i % 10;
                if (i == 0) {
                    //统一提交
                    sqlSession.commit();
                }
            }
            //统一提交
            sqlSession.commit();
            //清理缓存，防止溢出
            sqlSession.clearCache();
        } catch (Exception e) {
            //没有提交的数据可以回滚
            sqlSession.rollback();
            throw new Exception(e);
        } finally {
            //关闭 sqlSession
            sqlSession.close();
        }
        isSuccess = true;
        return isSuccess;
    }


}

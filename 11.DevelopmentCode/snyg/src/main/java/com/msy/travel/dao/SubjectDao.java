package com.msy.travel.dao;

import java.util.List;
import com.msy.travel.pojo.Subject;
/**
 * SubjectDao接口
 * 
 * @author wootide
 * 
 */
public interface SubjectDao
{
    /**
     * 增加Subject
     * 
     * @param subject Subject对象
     */
    void insertSubject(Subject subject) throws Exception;
   
    /**
     * 检查Subject
     * 
     * @param subject Subject对象
     */
    void mergeSubject(Subject subject) throws Exception;
   
    /**
     * 删除Subject
     * 
     * @param subject 成语对象
     */
    void deleteSubject(Subject subject) throws Exception;
    
    /**
     * 批量删除Subject
     * 
     * @param ids ids
     */
    void deleteBatchSubject(Subject subject) throws Exception;  
    
    /**
     * 修改Subject
     * 
     * @param subject Subject对象
     */
    void updateSubject(Subject subject) throws Exception;  
   
    /**
     * 查询单个Subject信息
     * 
     * @param subject Subject对象
     * 
     * @return Subject实体对象
     */
    Subject querySubject(Subject subject) throws Exception;
    
    /**
     * 查询Subject列表信息
     * 
     * @param subject Subject对象
     * 
     * @return Subject列表
     */
    List<Subject> querySubjectList(Subject subject) throws Exception;

    /**
     * 获取SubjectID
     */
    String getSubjectId() throws Exception;
}

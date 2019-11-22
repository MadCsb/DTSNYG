package com.msy.travel.service;

import java.util.List;
import com.msy.travel.pojo.Subject;

/**
 * SubjectService接口
 * 
 * @author wootide
 * 
 */
public interface SubjectService
{
    /**
     * 新增Subject
     * 
     * @param subject Subject对象
     */
    public void createSubject(Subject subject) throws Exception;
    
    /**
     * 检查Subject
     * 
     * @param subject Subject对象
     */
    public void mergeSubject(Subject subject) throws Exception;
  
    /**
     * 删除Subject
     * 
     * @param subject Subject对象
     */
    public void deleteSubject(Subject subject) throws Exception;
   
    /**
     * 批量删除Subject
     * 
     * @param subjectIdList  存放subject主键的list
     */
    public void deleteBatchSubject(Subject subject) throws Exception;  
    
    /**
     * 修改Subject
     * 
     * @param subject Subject对象
     */
    public void updateSubject(Subject subject) throws Exception;
    
    /**
     * 查询单个Subject
     * 
     * @param subject Subject对象
     * 
     * @return Subject实体对象
     */
    public Subject displaySubject(Subject subject) throws Exception;
  
   /**
     * 查询Subject列表
     * 
     * @param subject Subject对象
     * 
     * @return Subject列表
     */
    public List<Subject> querySubjectList(Subject subject) throws Exception;

    /**
     * 获取Subject主键ID
     */
    public String getSubjectId() throws Exception;
}


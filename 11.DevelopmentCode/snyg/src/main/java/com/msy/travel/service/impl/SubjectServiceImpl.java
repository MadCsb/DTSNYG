package com.msy.travel.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.msy.travel.pojo.Subject;
import com.msy.travel.dao.SubjectDao;
import com.msy.travel.service.SubjectService;

/**
 * SubjectService接口实现类
 * 
 * @author wootide
 * 
 */
@Service
@Transactional
public class SubjectServiceImpl implements SubjectService
{

	@Resource(name="subjectDao")
    private SubjectDao subjectDao;
    
    /**
     * 新增Subject
     * 
     * @param subject Subject对象
     */
    public void createSubject(Subject subject) throws Exception
    {
        subjectDao.insertSubject(subject);
    }
    /**
     * 检查Subject
     * 
     * @param subject Subject对象
     */
    public void mergeSubject(Subject subject) throws Exception
    {
    	subjectDao.mergeSubject(subject);
    }
    /**
     * 删除Subject
     * 
     * @param subject Subject对象
     */
    public void deleteSubject(Subject subject) throws Exception
    {
        subjectDao.deleteSubject(subject);
    }
   
    /**
     * 修改Subject
     * 
     * @param subject Subject对象
     */
    public void updateSubject(Subject subject) throws Exception
    {
        subjectDao.updateSubject(subject);
    }
    /**
     * 批量删除Subject
     * 
     * @param subjectIdList 存放subject主键的list
     */
    public void deleteBatchSubject(Subject subject) throws Exception
    {
    	subjectDao.deleteBatchSubject(subject);
    }  
    /**
     * 查询单个Subject
     * 
     * @param subject Subject对象
     * 
     * @return 成员实体对象
     */
    public Subject displaySubject(Subject subject) throws Exception
    {
        return subjectDao.querySubject(subject);
    }

    /**
     * 查询Subject列表
     * 
     * @param subject Subject对象
     * 
     * @return Subject列表
     */
    public List<Subject> querySubjectList(Subject subject) throws Exception
    {
        return subjectDao.querySubjectList(subject);
    }

    /**
     * 获取SubjectID
     */
    public String getSubjectId() throws Exception
    {
    	return subjectDao.getSubjectId();
    }
}

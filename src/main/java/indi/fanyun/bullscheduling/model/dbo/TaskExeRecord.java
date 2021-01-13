package indi.fanyun.bullscheduling.model.dbo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_task_exe_record")
public class TaskExeRecord {

    @Column(name = "ID")
    private Integer id;

    /**
     * 主键
     */
    @Id
    @Column(name = "CODE")
    private String code;

    /**
     * 任务编号
     */
    @Column(name = "TASK_CODE")
    private String taskCode;

    /**
     * 任务执行开始时间
     */
    @Column(name = "GMT_START")
    private Date gmtStart;

    /**
     * 任务执行结束时间
     */
    @Column(name = "GMT_END")
    private Date gmtEnd;

    /**
     * 执行结果
     */
    @Column(name = "RESULTS")
    private String results;

    /**
     * 执行返回体
     */
    @Column(name = "RESULT_BODY")
    private String resultBody;

    /**
     * 创建时间
     */
    @Column(name = "GMT_CREATE")
    private Date gmtCreate;

    /**
     * @return ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取主键
     *
     * @return CODE - 主键
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置主键
     *
     * @param code 主键
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取任务编号
     *
     * @return TASK_CODE - 任务编号
     */
    public String getTaskCode() {
        return taskCode;
    }

    /**
     * 设置任务编号
     *
     * @param taskCode 任务编号
     */
    public void setTaskCode(String taskCode) {
        this.taskCode = taskCode;
    }

    /**
     * 获取任务执行开始时间
     *
     * @return GMT_START - 任务执行开始时间
     */
    public Date getGmtStart() {
        return gmtStart;
    }

    /**
     * 设置任务执行开始时间
     *
     * @param gmtStart 任务执行开始时间
     */
    public void setGmtStart(Date gmtStart) {
        this.gmtStart = gmtStart;
    }

    /**
     * 获取任务执行结束时间
     *
     * @return GMT_END - 任务执行结束时间
     */
    public Date getGmtEnd() {
        return gmtEnd;
    }

    /**
     * 设置任务执行结束时间
     *
     * @param gmtEnd 任务执行结束时间
     */
    public void setGmtEnd(Date gmtEnd) {
        this.gmtEnd = gmtEnd;
    }

    /**
     * 获取执行结果
     *
     * @return RESULTS - 执行结果
     */
    public String getResults() {
        return results;
    }

    /**
     * 设置执行结果
     *
     * @param results 执行结果
     */
    public void setResults(String results) {
        this.results = results;
    }

    /**
     * 获取执行返回体
     *
     * @return RESULT_BODY - 执行返回体
     */
    public String getResultBody() {
        return resultBody;
    }

    /**
     * 设置执行返回体
     *
     * @param resultBody 执行返回体
     */
    public void setResultBody(String resultBody) {
        this.resultBody = resultBody;
    }

    /**
     * 获取创建时间
     *
     * @return GMT_CREATE - 创建时间
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * 设置创建时间
     *
     * @param gmtCreate 创建时间
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }
}
package com.hanxiaocu.sample.utils.mongolog;

public class MongoWorkerOperLog {
    private String  url;
    private String  actionType;
    private String  actionName;
    private String  actionDesc;
    private String  actionIp;
    private String  paramter;
    private String  response;
    private Integer spendTime;
    private String  error;
    private Integer errno;
    private Integer workerId;
    private String  workerName;
    private Integer dateYmd;
    private Integer dateHour;
    // 创建时间
    private String  time;
    // ip
    private String  ip;
    private String  host;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public String getActionDesc() {
        return actionDesc;
    }

    public void setActionDesc(String actionDesc) {
        this.actionDesc = actionDesc;
    }

    public String getActionIp() {
        return actionIp;
    }

    public void setActionIp(String actionIp) {
        this.actionIp = actionIp;
    }

    public String getParamter() {
        return paramter;
    }

    public void setParamter(String paramter) {
        this.paramter = paramter;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public Integer getSpendTime() {
        return spendTime;
    }

    public void setSpendTime(Integer spendTime) {
        this.spendTime = spendTime;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Integer getErrno() {
        return errno;
    }

    public void setErrno(Integer errno) {
        this.errno = errno;
    }

    public Integer getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Integer workerId) {
        this.workerId = workerId;
    }

    public String getWorkerName() {
        return workerName;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

    public Integer getDateYmd() {
        return dateYmd;
    }

    public void setDateYmd(Integer dateYmd) {
        this.dateYmd = dateYmd;
    }

    public Integer getDateHour() {
        return dateHour;
    }

    public void setDateHour(Integer dateHour) {
        this.dateHour = dateHour;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
}

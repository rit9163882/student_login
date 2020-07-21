package com.journaldev.spring.model;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Stud {

    private String studName;
    private String studId;
    private String studClass;
    static final Logger logger = LogManager.getLogger(Stud.class);
    public void printStud(){
        logger.debug("studName : "+this.studName+"studId : "+this.studId+"studClass : "+this.studClass);
    }
    public void setStudName(String studName1){
        logger.debug("setStudName working!!");
        this.studName=studName1; }
    public void setStudId(String studId1){ logger.debug("setStudId working!!"); this.studId=studId1; }
    public void setStudClass(String studClass1){ logger.debug("setStudClass working!!"); this.studClass=studClass1; }

    public String getStudName(){ return  this.studName; }
    public String getStudId(){ return  this.studId; }
    public String getStudClass(){ return this.studClass; }
}

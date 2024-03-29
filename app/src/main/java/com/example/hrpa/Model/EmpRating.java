package com.example.hrpa.Model;

public class EmpRating {
    int ratingId;
    public int empId;
    public String ratingDate;
    public String empName;
    public String jobTitle;

    public String jobKnowledge;
    public String jobKnowledgeCmnt;
    public String workquality;
    public String workqualityCmnt;
    public String attendance;
    public String attendanceCmnt;
    public String productivity;
    public String productivityCmnt;
    public String communicationSkills;
    public String communicationSkillsCmnt;
    public String dependability;
    public String dependabilityCmnt;
    public String overallRating;
    public String additionalCmnt;

    public EmpRating(String name,int ide, String ratingDate,String jobKnowledgeCmnt, String workqualityCmnt, String attendanceCmnt, String productivityCmnt,String communicationSkillsCmnt, String dependabilityCmnt, String jobKnowledge, String workquality, String attendance, String productivity, String communicationSkills, String dependability,String overallRating) {

        this.empId = ide;
        this.empName = name;
        this.jobKnowledge = jobKnowledge;
        this.workquality = workquality;
        this.attendance = attendance;
        this.productivity = productivity;
        this.communicationSkills = communicationSkills;
        this.dependability = dependability;
        this.overallRating = overallRating;
        this.ratingDate = ratingDate;
        this.jobKnowledgeCmnt = jobKnowledgeCmnt;
        this.workqualityCmnt = workqualityCmnt;
        this.attendanceCmnt = attendanceCmnt;
        this.productivityCmnt = productivityCmnt;
        this.communicationSkillsCmnt =communicationSkillsCmnt;
        this.dependabilityCmnt = dependabilityCmnt;
    }




    public String getEmpName() {
        return empName;
    }
    public void setEmpName(String empName) {
        this.empName = empName;
    }
    public String getJobTitle() {
        return jobTitle;
    }
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
    public String getRatingDate() {
        return ratingDate;
    }
    public void setRatingDate(String ratingDate) {
        this.ratingDate = ratingDate;
    }

    public int getRatingId() {
        return ratingId;
    }
    public void setRatingId(int ratingId) {
        this.ratingId = ratingId;
    }

    public int getEmpId() {
        return empId;
    }
    public void setEmpId(int empId) {
        this.empId = empId;
    }
    public String getJobKnowledge() {
        return jobKnowledge;
    }
    public void setJobKnowledge(String jobKnowledge) {
        this.jobKnowledge = jobKnowledge;
    }
    public String getJobKnowledgeCmnt() {
        return jobKnowledgeCmnt;
    }
    public void setJobKnowledgeCmnt(String jobKnowledgeCmnt) {
        this.jobKnowledgeCmnt = jobKnowledgeCmnt;
    }
    public String getWorkquality() {
        return workquality;
    }
    public void setWorkquality(String workquality) {
        this.workquality = workquality;
    }
    public String getWorkqualityCmnt() {
        return workqualityCmnt;
    }
    public void setWorkqualityCmnt(String workqualityCmnt) {
        this.workqualityCmnt = workqualityCmnt;
    }
    public String getAttendance() {
        return attendance;
    }
    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }
    public String getAttendanceCmnt() {
        return attendanceCmnt;
    }
    public void setAttendanceCmnt(String attendanceCmnt) {
        this.attendanceCmnt = attendanceCmnt;
    }
    public String getProductivity() {
        return productivity;
    }
    public void setProductivity(String productivity) {
        this.productivity = productivity;
    }
    public String getProductivityCmnt() {
        return productivityCmnt;
    }
    public void setProductivityCmnt(String productivityCmnt) {
        this.productivityCmnt = productivityCmnt;
    }
    public String getCommunicationSkills() {
        return communicationSkills;
    }
    public void setCommunicationSkills(String communicationSkills) {
        this.communicationSkills = communicationSkills;
    }
    public String getCommunicationSkillsCmnt() {
        return communicationSkillsCmnt;
    }
    public void setCommunicationSkillsCmnt(String communicationSkillsCmnt) {
        this.communicationSkillsCmnt = communicationSkillsCmnt;
    }
    public String getDependability() {
        return dependability;
    }
    public void setDependability(String dependability) {
        this.dependability = dependability;
    }
    public String getDependabilityCmnt() {
        return dependabilityCmnt;
    }
    public void setDependabilityCmnt(String dependabilityCmnt) {
        this.dependabilityCmnt = dependabilityCmnt;
    }
    public String getOverallRating() {
        return overallRating;
    }
    public void setOverallRating(String overallRating) {
        this.overallRating = overallRating;
    }
    public String getAdditionalCmnt() {
        return additionalCmnt;
    }
    public void setAdditionalCmnt(String additionalCmnt) {
        this.additionalCmnt = additionalCmnt;
    }
    @Override
    public String toString() {
        return "EmpRating [ratingId=" + ratingId + ", empId=" + empId + ", ratingDate=" + ratingDate + ", empName="
                + empName + ", jobTitle=" + jobTitle + ", jobKnowledge=" + jobKnowledge + ", jobKnowledgeCmnt="
                + jobKnowledgeCmnt + ", workquality=" + workquality + ", workqualityCmnt=" + workqualityCmnt
                + ", attendance=" + attendance + ", attendanceCmnt=" + attendanceCmnt + ", productivity=" + productivity
                + ", productivityCmnt=" + productivityCmnt + ", communicationSkills=" + communicationSkills
                + ", communicationSkillsCmnt=" + communicationSkillsCmnt + ", dependability=" + dependability
                + ", dependabilityCmnt=" + dependabilityCmnt + ", overallRating=" + overallRating + ", additionalCmnt="
                + additionalCmnt + "]";
    }
}

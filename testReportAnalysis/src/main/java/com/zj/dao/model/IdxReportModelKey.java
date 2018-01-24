package com.zj.dao.model;

public class IdxReportModelKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column idx_report_model.indexId
     *
     * @mbggenerated
     */
    private String indexId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column idx_report_model.item_id
     *
     * @mbggenerated
     */
    private Integer itemId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column idx_report_model.label
     *
     * @mbggenerated
     */
    private String label;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column idx_report_model.report_id
     *
     * @mbggenerated
     */
    private String reportId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column idx_report_model.indexId
     *
     * @return the value of idx_report_model.indexId
     *
     * @mbggenerated
     */
    public String getIndexId() {
        return indexId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column idx_report_model.indexId
     *
     * @param indexId the value for idx_report_model.indexId
     *
     * @mbggenerated
     */
    public void setIndexId(String indexId) {
        this.indexId = indexId == null ? null : indexId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column idx_report_model.item_id
     *
     * @return the value of idx_report_model.item_id
     *
     * @mbggenerated
     */
    public Integer getItemId() {
        return itemId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column idx_report_model.item_id
     *
     * @param itemId the value for idx_report_model.item_id
     *
     * @mbggenerated
     */
    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column idx_report_model.label
     *
     * @return the value of idx_report_model.label
     *
     * @mbggenerated
     */
    public String getLabel() {
        return label;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column idx_report_model.label
     *
     * @param label the value for idx_report_model.label
     *
     * @mbggenerated
     */
    public void setLabel(String label) {
        this.label = label == null ? null : label.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column idx_report_model.report_id
     *
     * @return the value of idx_report_model.report_id
     *
     * @mbggenerated
     */
    public String getReportId() {
        return reportId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column idx_report_model.report_id
     *
     * @param reportId the value for idx_report_model.report_id
     *
     * @mbggenerated
     */
    public void setReportId(String reportId) {
        this.reportId = reportId == null ? null : reportId.trim();
    }
}
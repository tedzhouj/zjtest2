package com.zj.dao.model;

public class IdxReportModel extends IdxReportModelKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column idx_report_model.item_name
     *
     * @mbggenerated
     */
    private String itemName;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column idx_report_model.item_name
     *
     * @return the value of idx_report_model.item_name
     *
     * @mbggenerated
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column idx_report_model.item_name
     *
     * @param itemName the value for idx_report_model.item_name
     *
     * @mbggenerated
     */
    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }
}
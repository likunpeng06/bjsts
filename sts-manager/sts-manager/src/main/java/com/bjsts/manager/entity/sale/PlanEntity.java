package com.bjsts.manager.entity.sale;

import com.bjsts.core.enums.EnableDisableStatus;
import com.bjsts.core.enums.converter.EnableDisableStatusConverter;
import com.bjsts.manager.core.entity.AbstractEntity;
import com.bjsts.manager.enums.converter.sale.PlanStatusConverter;
import com.bjsts.manager.enums.converter.sale.PlanTypeConverter;
import com.bjsts.manager.enums.converter.sale.SourceTypeConverter;
import com.bjsts.manager.enums.sale.PlanStatus;
import com.bjsts.manager.enums.sale.PlanType;
import com.bjsts.manager.enums.sale.SourceType;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

/**
 * 项目方案跟踪信息
 *
 * @author jinsheng
 * @since 2016-04-28 13:48
 */
@Entity
@Table(name = "sts_plan_trace")
@DynamicInsert
@DynamicUpdate
public class PlanEntity extends AbstractEntity {

    private static final long serialVersionUID = -299721038872026718L;

    @Id
    @GeneratedValue
    private Long id;

    /**
     * 项目编码，格式：sts20161016001
     */
    @Column(name = "plan_no", nullable = false)
    private String planNo;

    /**
     * 项目名称
     */
    private String name;

    /**
     * 项目地点
     */
    private String location;

    /**
     * 项目说明
     */
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_time", updatable = false, nullable = false)
    private Date createdTime = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_time")
    private Date updatedTime;

    /**
     * 项目状态
     */
    @Convert(converter = PlanStatusConverter.class)
    @Column(name = "plan_status", nullable = false)
    private PlanStatus planStatus;

    /**
     * 项目类型
     */
    @Convert(converter = PlanTypeConverter.class)
    @Column(name = "plan_type", nullable = false)
    private PlanType planType;

    /**
     * 信息来源
     */
    @Convert(converter = SourceTypeConverter.class)
    @Column(name = "source_type", nullable = false)
    private SourceType sourceType;

    /**
     * 询价日期
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "price_time")
    private Date priceTime;

    /**
     * 联系人
     */
    private String linkman;

    /**
     * 手机
     */
    private String mobile;

    /**
     * 联系单位
     */
    private String company;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 合同总金额
     */
    @Column(name = "contract_amount")
    private Long contractAmount;

    /**
     * 付款总金额
     */
    @Column(name = "pay_amount")
    private Long payAmount;

    /**
     * 发票总金额
     */
    @Column(name = "receipt_amount")
    private Long receiptAmount;

    /**
     * 报价材料
     */
    @Column(name = "material_url")
    private String materialUrl;

    /**
     * 预计交付日期
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "expect_time")
    private Date expectTime;

    /**
     * 实际完成日期
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "complete_time")
    private Date completeTime;

    /**
     * 出厂交付日期
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "deliver_time")
    private Date deliverTime;

    @Convert(converter = EnableDisableStatusConverter.class)
    @Column(nullable = false)
    private EnableDisableStatus valid = EnableDisableStatus.ENABLE;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlanNo() {
        return planNo;
    }

    public void setPlanNo(String planNo) {
        this.planNo = planNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public PlanStatus getPlanStatus() {
        return planStatus;
    }

    public void setPlanStatus(PlanStatus planStatus) {
        this.planStatus = planStatus;
    }

    public PlanType getPlanType() {
        return planType;
    }

    public void setPlanType(PlanType planType) {
        this.planType = planType;
    }

    public SourceType getSourceType() {
        return sourceType;
    }

    public void setSourceType(SourceType sourceType) {
        this.sourceType = sourceType;
    }

    public Date getPriceTime() {
        return priceTime;
    }

    public void setPriceTime(Date priceTime) {
        this.priceTime = priceTime;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getContractAmount() {
        return contractAmount;
    }

    public void setContractAmount(Long contractAmount) {
        this.contractAmount = contractAmount;
    }

    public Long getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(Long payAmount) {
        this.payAmount = payAmount;
    }

    public Long getReceiptAmount() {
        return receiptAmount;
    }

    public void setReceiptAmount(Long receiptAmount) {
        this.receiptAmount = receiptAmount;
    }

    public String getMaterialUrl() {
        return materialUrl;
    }

    public void setMaterialUrl(String materialUrl) {
        this.materialUrl = materialUrl;
    }

    public Date getExpectTime() {
        return expectTime;
    }

    public void setExpectTime(Date expectTime) {
        this.expectTime = expectTime;
    }

    public Date getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(Date completeTime) {
        this.completeTime = completeTime;
    }

    public Date getDeliverTime() {
        return deliverTime;
    }

    public void setDeliverTime(Date deliverTime) {
        this.deliverTime = deliverTime;
    }

    public EnableDisableStatus getValid() {
        return valid;
    }

    public void setValid(EnableDisableStatus valid) {
        this.valid = valid;
    }
}

package com.bjsts.manager.entity.purchase;

import com.bjsts.core.enums.EnableDisableStatus;
import com.bjsts.core.enums.converter.EnableDisableStatusConverter;
import com.bjsts.manager.core.entity.AbstractEntity;
import com.bjsts.manager.enums.converter.purchase.PurchaseReceiptTypeConverter;
import com.bjsts.manager.enums.purchase.PurchaseReceiptType;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

/**
 * 采购单
 * @author jinsheng
 * @since 2016-04-28 13:48
 */
@Entity
@Table(name = "sts_purchase")
@DynamicInsert
@DynamicUpdate
public class PurchaseEntity extends AbstractEntity {

    private static final long serialVersionUID = -299721038872026718L;

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, name = "product_name")
    private String productName;

    @Column(nullable = false, name = "product_model")
    private String productModel;

    private Long quantity;

    @Column(nullable = false, name = "single_amount")
    private Long singleAmount;

    @Column(nullable = false, name = "total_amount")
    private Long totalAmount;

    @Column(name = "payed_amount")
    private Long payedAmount;

    @Column(name = "un_payed_amount")
    private Long unPayedAmount;

    private String operator;

    private String supplier;

    @Column(name = "supplier_mobile")
    private String supplierMobile;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "purchase_time")
    private Date purchaseTime;

    @Convert(converter = PurchaseReceiptTypeConverter.class)
    @Column(name = "purchase_receipt_type", nullable = false)
    private PurchaseReceiptType purchaseReceiptType;

    @Column(name = "purchase_contract_url")
    private String purchaseContractUrl;

    @Convert(converter = EnableDisableStatusConverter.class)
    @Column(nullable = false)
    private EnableDisableStatus valid = EnableDisableStatus.ENABLE;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_time", updatable = false, nullable = false)
    private Date createdTime = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_time")
    private Date updatedTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductModel() {
        return productModel;
    }

    public void setProductModel(String productModel) {
        this.productModel = productModel;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getSingleAmount() {
        return singleAmount;
    }

    public void setSingleAmount(Long singleAmount) {
        this.singleAmount = singleAmount;
    }

    public Long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public EnableDisableStatus getValid() {
        return valid;
    }

    public void setValid(EnableDisableStatus valid) {
        this.valid = valid;
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

    public Long getPayedAmount() {
        return payedAmount;
    }

    public void setPayedAmount(Long payedAmount) {
        this.payedAmount = payedAmount;
    }

    public Long getUnPayedAmount() {
        return unPayedAmount;
    }

    public void setUnPayedAmount(Long unPayedAmount) {
        this.unPayedAmount = unPayedAmount;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getSupplierMobile() {
        return supplierMobile;
    }

    public void setSupplierMobile(String supplierMobile) {
        this.supplierMobile = supplierMobile;
    }

    public Date getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(Date purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public PurchaseReceiptType getPurchaseReceiptType() {
        return purchaseReceiptType;
    }

    public void setPurchaseReceiptType(PurchaseReceiptType purchaseReceiptType) {
        this.purchaseReceiptType = purchaseReceiptType;
    }

    public String getPurchaseContractUrl() {
        return purchaseContractUrl;
    }

    public void setPurchaseContractUrl(String purchaseContractUrl) {
        this.purchaseContractUrl = purchaseContractUrl;
    }
}

package com.bjsts.manager.form.sale;

import com.bjsts.manager.core.form.AbstractForm;
import com.bjsts.manager.entity.sale.ContractEntity;

/**
 * @author jinsheng
 * @since 2016-05-12 16:00
 */
public class ContractForm extends AbstractForm {

    private static final long serialVersionUID = 5859168020901454685L;

    private ContractEntity contract;

    public ContractEntity getContract() {
        return contract;
    }

    public void setContract(ContractEntity contract) {
        this.contract = contract;
    }
}

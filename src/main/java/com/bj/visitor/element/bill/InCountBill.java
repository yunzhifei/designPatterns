package com.bj.visitor.element.bill;

import com.bj.visitor.element.views.IAccountViewerrs;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InCountBill implements IBill {
    private double amount;
    private String item;

    @Override
    public void accpet(IAccountViewerrs accountViewerrs) {
        accountViewerrs.view(this);
    }
}

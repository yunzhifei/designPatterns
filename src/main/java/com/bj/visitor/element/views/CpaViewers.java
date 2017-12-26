package com.bj.visitor.element.views;

import com.bj.visitor.element.bill.InCountBill;
import com.bj.visitor.element.bill.OutCountBill;

public class CpaViewers implements IAccountViewerrs{
    @Override
    public void view(OutCountBill bill) {
        if (bill.getItem().equals("工资")) {
            System.out.println("注会查看账本时，如果单子的消费目的是发工资，则注会会查看有没有交个人所得税。");
        }
    }

    @Override
    public void view(InCountBill countBill) {
        System.out.println("注会查看账本时，只要是收入，注会都要查看公司交税了没。");
    }
}

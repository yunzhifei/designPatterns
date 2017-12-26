package com.bj.visitor.element.views;

import com.bj.visitor.element.bill.InCountBill;
import com.bj.visitor.element.bill.OutCountBill;

public class BossViewers implements IAccountViewerrs{
    private double inAllCount;
    private double outAllCount;

    @Override
    public void view(InCountBill bill) {
        inAllCount += bill.getAmount();
    }

    @Override
    public void view(OutCountBill countBill) {
        outAllCount += countBill.getAmount();
    }

    public double getInAllCount() {
        System.out.println("inAllCount = " + inAllCount);
        return inAllCount;
    }

    void setInAllCount(double inAllCount) {
        this.inAllCount = inAllCount;
    }

    public double getOutAllCount() {
        System.out.println("outAllCount = " + outAllCount);
        return outAllCount;
    }

    void setOutAllCount(double outAllCount) {
        this.outAllCount = outAllCount;
    }
}

package com.bj.visitor.element.views;

import com.bj.visitor.element.bill.IBill;
import com.bj.visitor.element.views.IAccountViewerrs;

import java.util.ArrayList;
import java.util.List;

public class BillFather {
    private List<IBill> bills = new ArrayList<IBill>();

    //添加单子
    public void addBill(IBill bill) {
        bills.add(bill);
    }

    //供账本的查看者查看账本
    public void show(IAccountViewerrs viewer) {
        for (IBill bill : bills) {
            bill.accpet(viewer);
        }
    }
}

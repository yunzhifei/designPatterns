package com.bj.visitor.element.example;

import com.bj.visitor.element.bill.InCountBill;
import com.bj.visitor.element.bill.OutCountBill;
import com.bj.visitor.element.views.BillFather;
import com.bj.visitor.element.views.BossViewers;
import com.bj.visitor.element.views.CpaViewers;
import com.bj.visitor.element.views.IAccountViewerrs;

public class Test {
    public static void main(String[] args) {
        BillFather billFather = new BillFather();
        billFather.addBill(new InCountBill(1000, "卖广告位"));
        billFather.addBill(new InCountBill(500, "卖产品"));
        billFather.addBill(new OutCountBill(1000, "工资"));
        billFather.addBill(new OutCountBill(100, "材料"));
        IAccountViewerrs boss = new BossViewers();
        IAccountViewerrs cpa = new CpaViewers();
        billFather.show(boss);
        billFather.show(cpa);
        ((BossViewers) boss).getInAllCount();
    }
}

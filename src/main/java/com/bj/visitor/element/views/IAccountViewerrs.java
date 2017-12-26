package com.bj.visitor.element.views;

import com.bj.visitor.element.bill.InCountBill;
import com.bj.visitor.element.bill.OutCountBill;

public interface IAccountViewerrs {
    void view(InCountBill bill);
    void view(OutCountBill countBill);
}

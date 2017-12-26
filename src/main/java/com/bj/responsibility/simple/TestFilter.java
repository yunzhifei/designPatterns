package com.bj.responsibility.simple;

import com.bj.responsibility.ITestFilter;
import lombok.Data;

@Data
public abstract class TestFilter implements ITestFilter {
    private ITestFilter nextHandler;

    /**
     * 继续过滤器链
     */
    protected void next(){
        this.filterResult = FilterResult.GO_NEXT;
    }
    /**
     * 停止过滤器链
     */
    protected void stop(){
        this.filterResult = FilterResult.STOP;
    }
    /**
     * 默认为继续接下来的过滤器
     */
    private FilterResult filterResult = FilterResult.GO_NEXT;

    public enum FilterResult{
        STOP(-1), //停止过滤器链
        GO_NEXT(0); //继续过滤器链
        private int value = 0;

        private FilterResult(int value){
            this.value = value;
        }
    }


}

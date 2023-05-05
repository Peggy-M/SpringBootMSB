package com.peggy.sentienlcontext.dome;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.context.ContextUtil;
import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * @Author Peggy
 * @Date 2023-05-05 16:20
 **/
public class ContextDemo2 {
    public void ContextUtil(){
        //创建一个来自appA访问的Context
        //Context的名称为entrance1
        ContextUtil.enter("entrance1", "appA");
        // Entry就是一个资源操作对象
        Entry nodeA = null;
        Entry nodeB = null;
        try {
            //获取资源resource1的entry
            nodeA = SphU.entry("resource1");
            // 如果代码走到这个位置，说明当前资源的请求通过了流控，可以继续进行相关业务处理

            //获取资源resource2的entry
            nodeB = SphU.entry("resource2");
            // 如果代码走到这个位置，说明当前资源的请求通过了流控，可以继续进行相关业务处理
        } catch (BlockException e) {
            // 如果没有通过走到了这里，就表示请求被限流，这里进行降级操作
            e.printStackTrace();
        }finally {
            if (nodeA != null) {
                nodeA.exit();
            }
            if (nodeB != null) {
                nodeB.exit();
            }
        }
        //释放Context
        ContextUtil.exit();
    }
}
package cn.mixpay.engine.chain.pay;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by qatang on 14-1-13.
 */
public abstract class AbstractPayChainResult implements IPayChainResult {
    protected final transient Logger logger = LoggerFactory.getLogger(this.getClass());
}

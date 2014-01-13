package cn.mixpay.engine.response.order;

import cn.mixpay.core.entity.order.PayOrder;
import cn.mixpay.engine.response.AbstractResponse;
import cn.mixpay.engine.signature.Signature;
import cn.mixpay.engine.signature.impl.AlipaySignature;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.List;

/**
 * Created by qatang on 13-12-18.
 */
public class CreatePayOrderJSONResponse extends AbstractResponse<PayOrder, JSONObject> {
    public final static String KEY_ID = "id";
    public final static String KEY_MERCHANT_ID = "merchant_id";
    public final static String KEY_MERCHANT_APP_ID = "merchant_app_id";
    public final static String KEY_PAY_TYPE = "pay_type";
    public final static String KEY_PLATFORM = "platform";
    public final static String KEY_EXTERNAL_ORDER_ID = "external_order_id";
    public final static String KEY_AMOUNT = "amount";
    public final static String KEY_SOURCE_ID = "source_id";
    public final static String KEY_PRODUCT_ID = "product_id";
    public final static String KEY_PRODUCT_NAME = "product_name";
    public final static String KEY_EXTERNAL_EXT = "external_ext";

    @Override
    public JSONObject convert(PayOrder payOrder) {
        return convertToJSONObject(payOrder);
    }

    protected JSONObject convertToJSONObject(PayOrder payOrder) {
        if (payOrder == null) {
            return null;
        }
        JSONObject jsonObject = new JSONObject();

        jsonObject.put(KEY_ID, payOrder.getId());
        jsonObject.put(KEY_MERCHANT_ID, payOrder.getMerchantId());
        jsonObject.put(KEY_MERCHANT_APP_ID, payOrder.getMerchantAppId());
        jsonObject.put(KEY_PAY_TYPE, payOrder.getPayType().getValue());
        jsonObject.put(KEY_PLATFORM, payOrder.getPlatform().getValue());
        jsonObject.put(KEY_EXTERNAL_ORDER_ID, payOrder.getExternalOrderId());
        jsonObject.put(KEY_AMOUNT, payOrder.getAmount());
        jsonObject.put(KEY_SOURCE_ID, payOrder.getSourceId());
        jsonObject.put(KEY_PRODUCT_ID, payOrder.getProductId());
        jsonObject.put(KEY_PRODUCT_NAME, payOrder.getProductName());
        jsonObject.put(KEY_EXTERNAL_EXT, payOrder.getExternalExt());

        String sign = getSign(jsonObject);

        return jsonObject;
    }

    public String getSign(JSONObject order){
        // TODO 统一改为注入接口自动匹配模式,一些内容废弃
        if(order.getString(KEY_PLATFORM).equals("alipay")){
            Signature signature = new AlipaySignature();
            return signature.sign(order);
        }
        return null;
    }

    protected JSONArray convertToJSONArray(List<PayOrder> payOrderList) {
        if (payOrderList == null || payOrderList.size() == 0) {
            return null;
        }
        JSONArray jsonArray = new JSONArray();
        for (PayOrder payOrder : payOrderList) {
            jsonArray.add(this.convertToJSONObject(payOrder));
        }
        return jsonArray;
    }

}

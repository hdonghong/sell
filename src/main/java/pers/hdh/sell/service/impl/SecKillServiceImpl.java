package pers.hdh.sell.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.hdh.sell.exception.SellException;
import pers.hdh.sell.service.RedisLock;
import pers.hdh.sell.service.SecKillService;
import pers.hdh.sell.utils.KeyUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * SecKillServiceImpl class<br/>
 *
 * @author hdonghong
 * @date 2018/04/13
 */
@Service
public class SecKillServiceImpl implements SecKillService {

    @Autowired
    private RedisLock redisLock;

    /** 10秒有效时间 */
    private static final int VALID_TIME = 1000 * 10;

    /** 现模拟秒杀活动，有秒杀商品A，其productId为aId */
    /** products表示总量100000份 */
    static Map<String, Integer> products;

    /** stock表示秒杀商品A所剩库存 */
    static Map<String, Integer> stock;

    /** orders代表订单 */
    static Map<String, String> orders;

    static {
        products = new HashMap<>();
        stock = new HashMap<>();
        orders = new HashMap<>();
        products.put("aId", 100000);
        stock.put("aId", 100000);
    }

    private String queryMap(String productId) {
        return "特价活动，商品秒杀，限量份"
                + products.get(productId)
                + " 还剩：" + stock.get(productId) + " 份"
                + " 该商品成功下单用户数目："
                + orders.size() + " 人";
    }

    @Override
    public String querySecKillProductInfo(String productId) {
        return queryMap(productId);
    }

    @Override
    public void orderProductMockDiffUser(String productId) {
        // 加锁
        long expireTime = System.currentTimeMillis() + VALID_TIME;
        if (!redisLock.lock(productId, String.valueOf(expireTime))) {
            throw new SellException(101, "哎呀，人太多了，再重新下单试试");
        }

        int stockNum = stock.get(productId);
        if (stockNum == 0) {
            throw new SellException(100, "活动已经结束，请留意下次秒杀活动");
        } else {
            orders.put(KeyUtil.getUniqueKey(), productId);
            stockNum--;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            stock.put(productId, stockNum);
        }

        // 解锁
        redisLock.unlock(productId, String.valueOf(expireTime));
    }

//    使用synchronized关键字固然可以解决并发问题，但使得此方法只能用于秒杀商品A，无法做到细粒度控制，
//    且只适合单点的情况，无法水平扩展（如集群）
//    @Override
//    public synchronized void orderProductMockDiffUser(String productId) {
//        int stockNum = stock.get(productId);
//        if (stockNum == 0) {
//            throw new SellException(100, "活动已经结束，请留意下次秒杀活动");
//        } else {
//            orders.put(KeyUtil.getUniqueKey(), productId);
//            stockNum--;
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            stock.put(productId, stockNum);
//        }
//    }
}

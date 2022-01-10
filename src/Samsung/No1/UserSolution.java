package Samsung.No1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class UserSolution {

    static PriorityQueue<Stock>[] sellPq;
    static PriorityQueue<Stock>[] buyPq;
    static ArrayList<Stock> orderList;
    static int max[];
    static int min[];

    static class Stock {
        int orderNum;
        int stockNum;
        int num;
        int price;
        boolean cancel;

        public Stock(int orderNum, int stockNum, int num, int price, boolean cancel) {
            this.orderNum = orderNum;
            this.stockNum = stockNum;
            this.num = num;
            this.price = price;
            this.cancel = cancel;
        }
    }

    public void init() {

        max = new int[6];
        min = new int[6];
        Arrays.fill(min, Integer.MAX_VALUE);

        orderList = new ArrayList<>();

        sellPq = new PriorityQueue[6];
        for (int i = 1; i <= 5; i++) {
            sellPq[i] = new PriorityQueue<>(new Comparator<Stock>() {
                @Override
                public int compare(Stock o1, Stock o2) {
                    if (o1.price == o2.price) {
                        return o1.orderNum - o2.orderNum;
                    }
                    return o1.price - o2.price;
                }
            });
        }

        buyPq = new PriorityQueue[6];
        for (int i = 1; i <= 5; i++) {
            buyPq[i] = new PriorityQueue<>(new Comparator<Stock>() {
                @Override
                public int compare(Stock o1, Stock o2) {
                    if (o1.price == o2.price) {
                        return o1.orderNum - o2.orderNum;
                    }
                    return o2.price - o1.price;
                }
            });
        }
    }

    public int buy(int mNumber, int mStock, int mQuantity, int mPrice) {
        orderList.add(new Stock(mNumber, mStock, mQuantity, mPrice, false));

        while (!sellPq[mStock].isEmpty() && sellPq[mStock].peek().price <= mPrice) {
            if (orderList.get(sellPq[mStock].peek().orderNum - 1).cancel) {
                sellPq[mStock].poll();
                continue;
            }

            completeOrder(mStock, sellPq[mStock].peek().price);

            if (sellPq[mStock].peek().num < mQuantity) {
                mQuantity -= sellPq[mStock].peek().num;
                sellPq[mStock].poll();
            } else if (sellPq[mStock].peek().num == mQuantity) {
                mQuantity = 0;
                sellPq[mStock].poll();
                break;
            } else {
                Stock update = sellPq[mStock].poll();
                sellPq[mStock].add(new Stock(update.orderNum, update.stockNum, update.num - mQuantity, update.price, update.cancel));
                mQuantity = 0;
                break;
            }
        }

        if (mQuantity > 0) {
            buyPq[mStock].add(new Stock(mNumber, mStock, mQuantity, mPrice, false));
        }

        return mQuantity;
    }

    public int sell(int mNumber, int mStock, int mQuantity, int mPrice) {
        orderList.add(new Stock(mNumber, mStock, mQuantity, mPrice, false));

        while (!buyPq[mStock].isEmpty() && buyPq[mStock].peek().price >= mPrice) {
            if (orderList.get(buyPq[mStock].peek().orderNum - 1).cancel) {
                buyPq[mStock].poll();
                continue;
            }

            completeOrder(mStock, buyPq[mStock].peek().price);

            if (buyPq[mStock].peek().num < mQuantity) {
                mQuantity -= buyPq[mStock].peek().num;
                buyPq[mStock].poll();
            } else if (buyPq[mStock].peek().num == mQuantity) {
                mQuantity = 0;
                buyPq[mStock].poll();
                break;
            } else {
                Stock update = buyPq[mStock].poll();
                buyPq[mStock].add(new Stock(update.orderNum, update.stockNum, update.num - mQuantity, update.price, update.cancel));
                mQuantity = 0;
                break;
            }
        }

        if (mQuantity > 0) {
            sellPq[mStock].add(new Stock(mNumber, mStock, mQuantity, mPrice, false));
        }

        return mQuantity;
    }

    public void cancel(int mNumber) {
        Stock update = orderList.get(mNumber - 1);
        orderList.set(mNumber - 1, new Stock(update.orderNum, update.stockNum, update.num, update.price, true));
    }

    public int bestProfit(int mStock) {
        return max[mStock];
    }

    static void completeOrder(int mStock, int price) {
        if (min[mStock] > price) {
            min[mStock] = price;
        }

        if (price > min[mStock]) {
            max[mStock] = Math.max(max[mStock], price - min[mStock]);
        }
    }
}
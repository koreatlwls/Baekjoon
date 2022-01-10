package Samsung.No1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class UserSolution {

    static PriorityQueue<Stock>[] sellPq;
    static PriorityQueue<Stock>[] buyPq;
    static ArrayList<Stock>[] completeList;
    static int maxProfit = 0;

    static class Stock {
        int orderNum;
        int num;
        int price;

        public Stock(int orderNum, int num, int price) {
            this.orderNum = orderNum;
            this.num = num;
            this.price = price;
        }
    }

    public void init() {
        completeList = new ArrayList[6];
        for (int i = 1; i <= 5; i++) {
            completeList[i] = new ArrayList<>();
        }

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
        while (!sellPq[mStock].isEmpty() && sellPq[mStock].peek().price <= mPrice) {
            if (sellPq[mStock].peek().num < mQuantity) {
                mQuantity -= sellPq[mStock].peek().num;
                completeList[mStock].add(new Stock(sellPq[mStock].peek().orderNum, sellPq[mStock].peek().num, sellPq[mStock].peek().price));
                sellPq[mStock].poll();
            } else if (sellPq[mStock].peek().num == mQuantity) {
                mQuantity = 0;
                completeList[mStock].add(new Stock(sellPq[mStock].peek().orderNum, sellPq[mStock].peek().num, sellPq[mStock].peek().price));
                sellPq[mStock].poll();
                break;
            } else {
                completeList[mStock].add(new Stock(mNumber, mQuantity, sellPq[mStock].peek().price));
                mQuantity = 0;
                Stock update = sellPq[mStock].poll();
                sellPq[mStock].add(new Stock(update.orderNum, update.num - mQuantity, update.price));
                break;
            }
        }

        if (mQuantity > 0) {
            buyPq[mStock].add(new Stock(mNumber, mQuantity, mPrice));
        }

        return mQuantity;
    }

    public int sell(int mNumber, int mStock, int mQuantity, int mPrice) {
        while (!buyPq[mStock].isEmpty() && buyPq[mStock].peek().price >= mPrice) {
            if (buyPq[mStock].peek().num < mQuantity) {
                mQuantity -= buyPq[mStock].peek().num;
                completeList[mStock].add(new Stock(buyPq[mStock].peek().orderNum, buyPq[mStock].peek().num, mPrice));
                buyPq[mStock].poll();
            } else if (buyPq[mStock].peek().num == mQuantity) {
                mQuantity = 0;
                completeList[mStock].add(new Stock(buyPq[mStock].peek().orderNum, buyPq[mStock].peek().num, mPrice));
                buyPq[mStock].poll();
                break;
            } else {
                completeList[mStock].add(new Stock(mNumber, mQuantity, mPrice));
                mQuantity = 0;
                Stock update = buyPq[mStock].poll();
                buyPq[mStock].add(new Stock(update.orderNum, update.num - mQuantity, update.price));
                break;
            }
        }

        if (mQuantity > 0) {
            sellPq[mStock].add(new Stock(mNumber, mQuantity, mPrice));
        }

        return mQuantity;
    }

    public void cancel(int mNumber) {
        for (int i = 1; i <= 5; i++) {
            sellPq[i].removeIf(it -> it.orderNum == mNumber);
            buyPq[i].removeIf(it -> it.orderNum == mNumber);
        }
    }

    public int bestProfit(int mStock) {
        for(int i=0;i<completeList[mStock].size();i++){
            for(int j=i;j<completeList[mStock].size();j++){
                int dif = completeList[mStock].get(j).price - completeList[mStock].get(i).price;
                maxProfit = Math.max(maxProfit, dif);
            }
        }

        return maxProfit;
    }
}
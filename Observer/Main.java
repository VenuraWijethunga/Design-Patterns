package Observer;
import java.util.ArrayList;
import java.util.List;


interface Investor {
    void update(String stockName, double price);
}


interface StockMarket {
    void register(Investor investor);
    void unregister(Investor investor);
    void notifyInvestors(String stockName, double price);
}


class StockExchange implements StockMarket {
    private List<Investor> investors = new ArrayList<>();

    @Override
    public void register(Investor investor) {
        investors.add(investor);
    }

    @Override
    public void unregister(Investor investor) {
        investors.remove(investor);
    }

    @Override
    public void notifyInvestors(String stockName, double price) {
        for (Investor investor : investors) {
            investor.update(stockName, price);
        }
    }


    public void updateStockPrice(String stockName, double price) {
        notifyInvestors(stockName, price);
    }
}




class Main {
    public static void main(String[] args) {
        StockExchange stockExchange = new StockExchange();

        Investor investor1 = new IndividualInvestor("John");
        Investor investor2 = new IndividualInvestor("Alice");

        stockExchange.register(investor1);
        stockExchange.register(investor2);

        // Simulate stock price update
        stockExchange.updateStockPrice("Apple", 250.0);
        stockExchange.updateStockPrice("Google", 1500.0);
    }
}
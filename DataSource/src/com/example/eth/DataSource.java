package com.example.eth;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataSource {

    //=====================================================
    // Database Constants

    private static final String DB_NAME = "eth";
    private static final String DIRECTORY = "//localhost/";
    private static final String CONNECTION_STRING = "jdbc:postgresql:"
            + DIRECTORY + DB_NAME;
    private static final String USER = "postgres";
    private static final String PASSWORD = "backtotheroots";

    public static final String TABLE_PRICES = "prices";
    public static final String COLUMN_PRICES_ID = TABLE_PRICES + "." + "_id";
    public static final String COLUMN_PRICES_TS = TABLE_PRICES + "." + "timestamp";
    public static final String COLUMN_PRICES_OPEN = TABLE_PRICES + "." + "open";
    public static final String COLUMN_PRICES_CLOSE = TABLE_PRICES + "." + "close";
    public static final String COLUMN_PRICES_HIGH = TABLE_PRICES + "." + "high";
    public static final String COLUMN_PRICES_LOW = TABLE_PRICES + "." + "low";

    enum INDEX_PRICES {
        ID, TS, OPEN, CLOSE, HIGH, LOW;

        public int getIndex() {
            return this.ordinal() + 1;
        }
    }

    public static final String TABLE_TRADES = "trades";
    public static final String COLUMN_TRADES_ID = TABLE_TRADES + "." + "_id";
    public static final String COLUMN_TRADES_TS = TABLE_TRADES + "." + "timestamp";
    public static final String COLUMN_TRADES_COUNT = TABLE_TRADES + "." + "count";
    public static final String COLUMN_TRADES_VOLUME = TABLE_TRADES + "." + "volume";

    enum INDEX_TRADES {
        ID, TS, COUNT, VOLUME;

        public int getIndex() {
            return this.ordinal() + 1;
        }
    }

    public static final String QUERY_PRICES = "SELECT * FROM " + TABLE_PRICES;
    public static final String QUERY_TRADES = "SELECT * FROM " + TABLE_TRADES;

    //=====================================================
    // Data source fields and instance methods

    private Connection connection;

    private PreparedStatement queryPrices;
    private PreparedStatement queryTrades;

    public boolean connect() {
        try {
            connection = DriverManager.getConnection(CONNECTION_STRING,
                    USER, PASSWORD);

            queryPrices = connection.prepareStatement(QUERY_PRICES);
            queryTrades = connection.prepareStatement(QUERY_TRADES);

            return true;
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean close() {
        try {
            if (queryPrices != null) {
                queryPrices.close();
            }

            if (queryTrades != null) {
                queryTrades.close();
            }

            if (connection != null) {
                connection.close();
                return true;
            }
            return false;
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public List<PriceInfo> getPriceInfo() {
        try {
            ResultSet results = queryPrices.executeQuery();

            List<PriceInfo> prices = new ArrayList<>();
            while (results.next()) {
                PriceInfo priceInfo = new PriceInfo(
                        results.getLong(INDEX_PRICES.ID.getIndex()),
                        results.getLong(INDEX_PRICES.TS.getIndex()),
                        results.getDouble(INDEX_PRICES.OPEN.getIndex()),
                        results.getDouble(INDEX_PRICES.CLOSE.getIndex()),
                        results.getDouble(INDEX_PRICES.HIGH.getIndex()),
                        results.getDouble(INDEX_PRICES.LOW.getIndex()));
                prices.add(priceInfo);
            }

            return prices;
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public List<TradeInfo> getTradeInfo() {
        try {
            ResultSet results = queryTrades.executeQuery();

            List<TradeInfo> trades = new ArrayList<>();
            while (results.next()) {
                TradeInfo tradeInfo = new TradeInfo(
                        results.getLong(INDEX_TRADES.ID.getIndex()),
                        results.getLong(INDEX_TRADES.TS.getIndex()),
                        results.getDouble(INDEX_TRADES.COUNT.getIndex()),
                        results.getDouble(INDEX_TRADES.VOLUME.getIndex()));
                trades.add(tradeInfo);
            }

            return trades;
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

//    public static void main(String[] args) {
//        System.out.println(INDEX_PRICES.ID.getIndex());
//        System.out.println(INDEX_PRICES.TS.getIndex());
//        System.out.println(INDEX_PRICES.OPEN.getIndex());
//        System.out.println(INDEX_PRICES.CLOSE.getIndex());
//        System.out.println(INDEX_PRICES.HIGH.getIndex());
//        System.out.println(INDEX_PRICES.LOW.getIndex());
//
//        DataSource dataSource = new DataSource();
//        System.out.println(dataSource.connect());
//
//
//        List<PriceInfo> prices = dataSource.getPriceInfo();
//        List<TradeInfo> trades = dataSource.getTradeInfo();
//
//        for (int i = 0; i < 100; i++) {
//            System.out.println(prices.get(i));
//        }
//
//        System.out.println("=============================================");
//        System.out.println("=============================================");
//
//        for (int i = 0; i < 100; i++) {
//            System.out.println(trades.get(i));
//        }
//
//        System.out.println(dataSource.close());
//    }
}
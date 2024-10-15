package Observer;


    class IndividualInvestor implements Investor {
        private String name;

        public IndividualInvestor(String name) {
            this.name = name;
        }

        @Override
        public void update(String stockName, double price) {
            System.out.println(name + " received update: " + stockName + " is now $" + price);
        }
    }



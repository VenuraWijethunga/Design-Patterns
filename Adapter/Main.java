package Adapter;


    interface LaptopPower {
        void connectToPower();
    }


    class PowerSocket {
        public String providePower() {
            return "Power from the socket";
        }
    }

    class PowerAdapter implements LaptopPower {
        private PowerSocket socket;

        public PowerAdapter(PowerSocket socket) {
            this.socket = socket;
        }

        @Override
        public void connectToPower() {

            System.out.println("Adapter: " + socket.providePower());
        }
    }


    class Laptop {
        private LaptopPower power;

        public Laptop(LaptopPower power) {
            this.power = power;
        }

        public void charge() {
            power.connectToPower();
        }
    }

    public class Main {
        public static void main(String[] args) {
            PowerSocket powerSocket = new PowerSocket();
            LaptopPower powerAdapter = new PowerAdapter(powerSocket);
            Laptop laptop = new Laptop(powerAdapter);


            laptop.charge();
        }
    }


import java.util.Scanner;

class Vahicle {
    private String engine;
    private int wheel;
    private int seat;

    private boolean trunk;
    private int airBags;

    private Vahicle(VahicleBuilder vb){
        this.engine = vb.engine;
        this.wheel = vb.wheel;
        this.seat = vb.seat;
        this.trunk = vb.trunk;
        this.airBags = vb.airBags;
    }

    public String getEngine() {
        return engine;
    }

    public int getWheel() {
        return wheel;
    }

    public int getSeat() {
        return seat;
    }

    public boolean isTrunk() {
        return trunk;
    }

    public int getAirBags() {
        return airBags;
    }

    public static class VahicleBuilder {
        private String engine;
        private int wheel;
        private int seat;

        private boolean trunk;
        private int airBags;

        public VahicleBuilder(String engine, int wheel, int seat){
            this.engine = engine;
            this.wheel = wheel;
            this.seat = seat;
        }

        public VahicleBuilder setTrunk(boolean trunk) {
            this.trunk = trunk;
            return this;
        }

        public VahicleBuilder setAirBags(int airBags) {
            this.airBags = airBags;
            return this;
        }

        public Vahicle build(){
            return new Vahicle(this);
        }


    }
}


        public class BuilderPattern {
            public static void main(String[] args) {
                System.out.println("For Car Enter 1");
                System.out.println("For Bike Enter 2");

                Scanner in = new Scanner(System.in);

                int choice = in.nextInt();
                if(choice == 1){
//                    car
                    String dummy = in.nextLine();
                    System.out.print("Engine: ");
                    String engine = in.nextLine();
                    System.out.print("Wheel: ");
                    int wheel = in.nextInt();
                    System.out.print("Seat: ");
                    int seat = in.nextInt();
                    System.out.print("Trunk: ");
                    boolean trunk = in.nextBoolean();
                    System.out.print("Air Bags: ");
                    int airBags = in.nextInt();

                    Vahicle car = new Vahicle.VahicleBuilder(engine, wheel , seat)
                            .setAirBags(airBags)
                            .setTrunk(true)
                            .build();

                    System.out.println("Car Build...!");

                    System.out.println("Engine: " + car.getEngine());
                    System.out.println("Wheel:" + car.getWheel());
                    System.out.println("Seat:" + car.getSeat());
                    System.out.println("AirBags:" + car.getAirBags());
                    System.out.println("Trunk:" + car.isTrunk());

                }
                if(choice == 2){
//                    bike
                    String dummy = in.nextLine();
                    System.out.print("Engine: ");
                    String engine = in.nextLine();
                    System.out.print("Wheel: ");
                    int wheel = in.nextInt();
                    System.out.print("Seat: ");
                    int seat = in.nextInt();

                    Vahicle bike = new Vahicle.VahicleBuilder(engine, wheel , seat).build();

                    System.out.println("Bike Build...!");

                    System.out.println("Engine:" + bike.getEngine());
                    System.out.println("Wheel:" + bike.getWheel());
                    System.out.println("Seat:" + bike.getSeat());
                    System.out.println("AirBags" + bike.getAirBags());
                    System.out.println("Trunk:" + bike.isTrunk());


                }


            }

        }

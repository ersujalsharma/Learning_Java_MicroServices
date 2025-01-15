package assignment2;

public class BookMyMovie {
    private int movieId;
    private int noOfTickets;
    private double discount;
    private double totalAmount;

    public BookMyMovie(int movieId, int noOfTickets) {
        this.movieId = movieId;
        this.noOfTickets = noOfTickets;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getNoOfTickets() {
        return noOfTickets;
    }

    public void setNoOfTickets(int noOfTickets) {
        this.noOfTickets = noOfTickets;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
    public void calculateDiscount(){
        int tickets = getNoOfTickets();
        int movieId = getMovieId();
        if((movieId==101 || movieId==102 || movieId==103) && tickets<5){
            setDiscount(0);
        }
        else if((movieId==101 || movieId==103) && (tickets>=5 && tickets<10)){
            setDiscount(15);
        }
        else if((movieId==101 || movieId==103) && (tickets>=5 && tickets<10)){
            setDiscount(20);
        }
        else if(movieId==102 && tickets>=5 && tickets<10){
            setDiscount(10);
        }
        else if(movieId==102 && tickets>=10 && tickets<=15){
            setDiscount(15);
        }
    }
    public double calculateTicketAmount(){
        calculateDiscount();
        int baseFare = 0;
        if(movieId==101){
            baseFare = 120;
        }
        else if(movieId==102){
            baseFare = 170;
        }
        else if(movieId==103){
            baseFare = 150;
        }
        double totalAmount = baseFare * noOfTickets - (baseFare*noOfTickets*discount/100.0);
        return totalAmount;
    }

    public static void main(String[] args) {
        BookMyMovie bookMyMovie = new BookMyMovie(101,5);
        BookMyMovie bookMyMovie1 = new BookMyMovie(102,4);
        BookMyMovie bookMyMovie2 = new BookMyMovie(103,8);
        BookMyMovie bookMyMovie3 = new BookMyMovie(104,5);

        System.out.println(bookMyMovie.calculateTicketAmount());
        System.out.println(bookMyMovie1.calculateTicketAmount());
        System.out.println(bookMyMovie2.calculateTicketAmount());
        System.out.println(bookMyMovie3.calculateTicketAmount());

    }
}

package org.example.repository;


public class DatabaseCollection {
    private static DatabaseCollection d1;
    public  BookingRepository BookingTable;
    public MovieRepository MovieTable;
    public ScreenRepository ScreenTable;
    public SeatRepository SeatTable;
    public ShowRepository ShowTable;
    public TheatreRepository TheatreTable;
    public UserRepository UserTable;

    private DatabaseCollection() {
        this.BookingTable = new BookingRepository();
        this.MovieTable = new MovieRepository();
        this.ScreenTable = new ScreenRepository();
        this.SeatTable = new SeatRepository();
        this.TheatreTable= new TheatreRepository();
        this.ShowTable = new ShowRepository();
        this.UserTable = new UserRepository();

    }

    public static DatabaseCollection instance(){
        if(d1==null) d1= new DatabaseCollection();
        return d1;
    }


}

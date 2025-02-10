package org.example.database;
import org.example.database.MovieRepo;
import org.example.database.SeatRepo;
import org.example.database.ShowRepo;
import org.example.database.TheatreRepo;
import org.example.database.UserRepo;


public class DatabaseCollection {
    private static DatabaseCollection d1;
    public  BookingRepo BookingTable;
    public MovieRepo MovieTable;
    public ScreenRepo ScreenTable;
    public SeatRepo SeatTable;
    public ShowRepo ShowTable;
    public TheatreRepo TheatreTable;
    public UserRepo UserTable;

    private DatabaseCollection() {
        this.BookingTable = new BookingRepo();
        this.MovieTable = new MovieRepo();
        this.ScreenTable = new ScreenRepo();
        this.SeatTable = new SeatRepo();
        this.TheatreTable= new TheatreRepo();
        this.ShowTable = new ShowRepo();
        this.UserTable = new UserRepo();

    }

    public static DatabaseCollection instance(){
        if(d1==null) d1= new DatabaseCollection();
        return d1;
    }


}

package pl.wbobiatynski.kprm.booksauthors.exception;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BookValidationException extends RuntimeException {
    int status;
    String time;
        public BookValidationException(String message) {
            super(message);
            status = 400;
            Date date = new Date();
            DateFormat sdf = new SimpleDateFormat("yyyy-MM-ddTHH:mm:ss.SSSSSSSSSZ");
            String stringDate = sdf.format(date);
            System.out.println(stringDate);
            Calendar cal = Calendar.getInstance();
            time = sdf.format(cal.getTime());
        }
    }


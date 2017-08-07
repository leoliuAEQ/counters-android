package ca.aequilibrium.counters;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

class Model implements Serializable {

    private static int counter = 0;

    private Date created;
    private int  value;

    Model() {
        created = new Date();
        this.value = counter;
        counter++;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        return "Model{" +
                value +
                ", " + sdf.format(created) +
                '}';
    }
}

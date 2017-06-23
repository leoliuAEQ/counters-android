package ca.aequilibrium.counters;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        setTitle("One Counter");

        Intent intent = getIntent();
        Integer value = intent.getIntExtra(MainActivity.EXTRA_VALUE, -1);

        textView = (TextView) findViewById(R.id.textView);
        textView.setText(String.format("The counter value is: %d", value));
    }
}

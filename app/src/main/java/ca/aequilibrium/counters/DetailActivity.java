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

        setTitle(getString(R.string.DetailActivityTitle));

        Intent intent = getIntent();
        Model model = (Model) intent.getSerializableExtra(MainActivity.EXTRA_VALUE);

        textView = (TextView) findViewById(R.id.textView);
        if (model == null) {
            textView.setText(R.string.model_not_found);
        } else {
            textView.setText(model.toString());
        }
    }
}

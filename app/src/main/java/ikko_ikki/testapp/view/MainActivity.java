package ikko_ikki.testapp.view;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ikko_ikki.testapp.R;

public class MainActivity extends AppCompatActivity implements MainView {

    @BindView(R.id.editTextFrom) EditText editTextFrom;
    @BindView(R.id.editTextTo) EditText editTextTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    protected void onStart() {
        super.onStart();

        EditText editTextData = (EditText) findViewById(R.id.editTextData);
        editTextData.setOnFocusChangeListener((view, b) -> {
            if(b) {
                DateDialog dialog = new DateDialog(view);
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                dialog.show(ft, "Календарь");
            }
        });
    }

    @OnClick(R.id.editTextFrom)
    public void OnClick() {
        Intent i = new Intent(this, StationFromActivity.class);
        i.putExtra("from", true);
        startActivityForResult(i, 1);
    }

    @OnClick(R.id.editTextTo)
    public void onClick() {
        Intent i = new Intent(this, StationToActivity.class);
        i.putExtra("to", true);
        startActivityForResult(i, 2);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == 0 && data != null) { //prevent crashes, when user press back button
            editTextFrom.setText(data.getStringExtra("stationFrom"));
        }
        if (requestCode == 2 && data != null) {
            editTextTo.setText(data.getStringExtra("stationTo"));
        }
    }
}

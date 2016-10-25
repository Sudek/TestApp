package ikko_ikki.testapp;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.editTextFrom) EditText editTextFrom;
    @BindView(R.id.editTextTo) EditText editTextTo;
//    @BindView(R.id.editTextData) EditText editTextData;

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
        Intent i = new Intent(this, StationActivity.class);
        startActivityForResult(i, 1);
    }
    @OnClick(R.id.editTextTo)
    public void onClick() {
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == Activity.RESULT_OK){
            editTextFrom.setText(data.getStringExtra("city"));
            }
            if (resultCode == Activity.RESULT_CANCELED) {
            }
    }

}

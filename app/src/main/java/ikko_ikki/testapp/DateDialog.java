package ikko_ikki.testapp;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateDialog extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    EditText editText;

    public DateDialog(View view) {
        editText = (EditText) view;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        month++; //Months are indexed starting at 0
        String date = day + "-" + month + "-" + year;

        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        try {
            Date date1 = df.parse(date);
            if(new Date().before(date1)) {
                editText.setText(date);
            }
        } catch (ParseException e) {
            Toast.makeText
                    (getActivity().getApplicationContext(),
                    "Вы не можете выбрать дату, которая прошла",
                    Toast.LENGTH_LONG);
        }
    }
}

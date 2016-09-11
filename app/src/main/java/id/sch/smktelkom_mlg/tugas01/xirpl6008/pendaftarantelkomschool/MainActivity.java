package id.sch.smktelkom_mlg.tugas01.xirpl6008.pendaftarantelkomschool;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    EditText etNama;
    Button bOk;
    RadioGroup rgJurusan;
    int nMinat;
    TextView tvNama;
    TextView tvminat;
    TextView tvradio;
    CheckBox cb4, cb5, cb6;
    TextView tvHasil;
    TextView tvspiner;
    Spinner spProvinsi;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rgJurusan = (RadioGroup) findViewById(R.id.radioGroupJurusan);
        bOk = (Button) findViewById(R.id.button2);
        cb4 = (CheckBox) findViewById(R.id.checkBox4);
        cb5 = (CheckBox) findViewById(R.id.checkBox5);
        cb6 = (CheckBox) findViewById(R.id.checkBox6);

        cb4.setOnCheckedChangeListener(this);
        cb5.setOnCheckedChangeListener(this);
        cb6.setOnCheckedChangeListener(this);
        etNama = (EditText) findViewById(R.id.editText2);
        tvNama = (TextView) findViewById(R.id.textView);
        tvminat = (TextView) findViewById(R.id.textView3);
        tvradio = (TextView) findViewById(R.id.textView2);
        tvspiner = (TextView) findViewById(R.id.textView5);
        spProvinsi = (Spinner) findViewById(R.id.spinnerProvinsi);
        bOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doMulai();
                doClick();
                doProses();
                doSiap();
            }
        });

    }

    private void doClick() {
        String asal = spProvinsi.getSelectedItem().toString();
        tvspiner.setText("Asal Anda Dari " + asal);
    }

    private void doProses() {
        String Minat = "Peminatan ";
        int startien = Minat.length();
        if (cb4.isChecked()) Minat += cb4.getText() + "\n";
        if (cb5.isChecked()) Minat += cb5.getText() + "\n";
        if (cb6.isChecked()) Minat += cb6.getText() + "\n";
        if (Minat.length() == startien) Minat += "Anda Belum Memilih";
        tvminat.setText(Minat);
    }

    private void doSiap() {
        String hasil = null;
        if (rgJurusan.getCheckedRadioButtonId() != -1) {
            RadioButton rb = (RadioButton) findViewById(rgJurusan.getCheckedRadioButtonId());
            hasil = rb.getText().toString();
        }
        tvradio.setText("Jurusan Anda Adalah " + hasil);
    }


}

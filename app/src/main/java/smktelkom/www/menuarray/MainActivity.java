package smktelkom.www.menuarray;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnSubmit;
    EditText editNama, editTahun;
    Spinner spKota, spProvinsi;
    TextView txtHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSubmit = findViewById(R.id.btnSubmit);
        editNama = findViewById(R.id.editNama);
        editTahun = findViewById(R.id.editTahun);
        spKota = findViewById(R.id.spKota);
        spProvinsi = findViewById(R.id.spProvinsi);
        txtHasil = findViewById(R.id.txtHasil);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                doProcess();
            }

            private void doProcess() {
                if (isValid()) {
                    String nama = editNama.getText().toString();
                    int tahun = Integer.parseInt(editTahun.getText().toString());
                    int usia = 2019 - tahun;
                    txtHasil.setText("Nama Anda " + nama + "\n" + "Anda berusia" + usia + "Tahun" + "\n" +
                            "Anda berasal dari kota" + spKota.getSelectedItem().toString() + "\n" +
                            "Provinsi" + spProvinsi.getSelectedItem().toString());
                }
            }

            private boolean isValid() {
                boolean valid = true;
                String nama = editNama.getText().toString();
                String Tahun = editTahun.getText().toString();

                if (TextUtils.isEmpty(nama)) {
                    editNama.setError("Nama Tidak Boleh Kosong");
                    valid = false;
                }

                if (TextUtils.isEmpty(Tahun)) {
                    editTahun.setError("Tahun Tidak Boleh Kosong");
                    valid = false;
                } else if (Tahun.length() < 3) {
                    editTahun.setError("Karakter tahun kurang dari 1");
                    valid = false;
                }
                return valid;
            }
        });
    }
}

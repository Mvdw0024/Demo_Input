package vandewouwer.michael.demo_input;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Switch;

import com.google.android.material.textfield.TextInputLayout;


public class MainActivity extends AppCompatActivity {

    private Button btnConfirm;
    private RadioGroup rgGender;
    private Switch swiAgree;
    private EditText etUser, etPassword;
    private TextInputLayout ilUser, ilPassword;

    //anonymous inner class
    private View.OnClickListener confirmListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.d("Test", "Button Clicked");

        }
    };

    private TextWatcher passWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            int input = etPassword.getText().length();
            if (input >= 4 && input <= 20) {
                ilPassword.setError(null);

            } else {
                ilPassword.setError(" must be between 4 and 20 characters! ");
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //verwijzing naar layout
        setContentView(R.layout.activity_main);
        //verwijzing naar componenten in UI
        btnConfirm = findViewById(R.id.btn_confirm);
        rgGender = findViewById(R.id.rg_gender);
        swiAgree = findViewById(R.id.swtch_agree);
        etUser = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        ilUser = findViewById(R.id.il_username);
        ilPassword = findViewById(R.id.il_password);
        //listeren toevoegen aan component
        btnConfirm.setOnClickListener(confirmListener);
        etPassword.addTextChangedListener(passWatcher);

    }


}

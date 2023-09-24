package anish.tutorial.converion;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

public class MainActivity extends AppCompatActivity {
    TextView thousand, hundred, fiveh, fifty, twenty, ten, five, cur, total,words;
    EditText e1000, e500, e100, e50, e10, e20, e5, ecur, eamt;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
         * Edit Texts
         */

        e1000 = findViewById(R.id.e1000);
        e500 = findViewById(R.id.e500);
        e100 = findViewById(R.id.e100);
        e50 = findViewById(R.id.e50);
        e20 = findViewById(R.id.e20);
        e10 = findViewById(R.id.e10);
        e5 = findViewById(R.id.e5);
        ecur = findViewById(R.id.ecur);
        eamt = findViewById(R.id.eamt);

        /*
         * Text Views
         */

        thousand = findViewById(R.id.thousand);
        fiveh = findViewById(R.id.fiveh);
        hundred = findViewById(R.id.hundred);
        fifty = findViewById(R.id.fifty);
        twenty = findViewById(R.id.twenty);
        ten = findViewById(R.id.ten);
        five = findViewById(R.id.five);
        cur = findViewById(R.id.cur);
        total = findViewById(R.id.totals);
        words = findViewById(R.id.inwords);

        e1000.addTextChangedListener(watcher);
        e500.addTextChangedListener(watcher);
        e100.addTextChangedListener(watcher);
        e50.addTextChangedListener(watcher);
        e20.addTextChangedListener(watcher);
        e10.addTextChangedListener(watcher);
        e5.addTextChangedListener(watcher);
        ecur.addTextChangedListener(watcher);
        eamt.addTextChangedListener(watcher);


    }

    TextWatcher watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }


        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            if (!TextUtils.isEmpty(e1000.getText().toString()) ||
                    !TextUtils.isEmpty(e500.getText().toString()) ||
                    !TextUtils.isEmpty(e100.getText().toString()) ||
                    !TextUtils.isEmpty(e50.getText().toString()) ||
                    !TextUtils.isEmpty(e20.getText().toString()) ||
                    !TextUtils.isEmpty(e10.getText().toString()) ||
                    !TextUtils.isEmpty(e5.getText().toString()) ||
                    !TextUtils.isEmpty(eamt.getText().toString()) ){
                int th, fh, hd, ff, tw, te, fv;
                float cr;
                th = TextUtils.isEmpty(
                        e1000.getText().toString().trim()) ? 0 :
                        (parseInt(e1000.getText().toString().trim()) * 1000);
                fh = TextUtils.isEmpty(e500.getText().toString().trim()) ? 0 : (parseInt(e500.getText().toString().trim()) * 500);
                hd = TextUtils.isEmpty(e100.getText().toString().trim()) ? 0 : (parseInt(e100.getText().toString().trim()) * 100);
                ff = TextUtils.isEmpty(e50.getText().toString().trim()) ? 0 : (parseInt(e50.getText().toString().trim()) * 50);
                tw = TextUtils.isEmpty(e20.getText().toString().trim()) ? 0 : (parseInt(e20.getText().toString().trim()) * 20);
                te = TextUtils.isEmpty(e10.getText().toString().trim()) ? 0 : (parseInt(e10.getText().toString().trim()) * 10);
                fv = TextUtils.isEmpty(e5.getText().toString().trim()) ? 0 : (parseInt(e5.getText().toString().trim()) * 5);
                cr = TextUtils.isEmpty(eamt.getText().toString().trim()) ? 0 :
                        (parseInt(eamt.getText().toString().trim()) * (
                                TextUtils.isEmpty(ecur.getText().toString().trim()) ? 0 :
                                        (parseFloat(ecur.getText().toString().trim()))));

                int tt = th + fh + hd + ff + tw + te + fv ;
                float ttt = cr + tt;
                total.setText(String.valueOf(ttt));
                String converted = EnglishNumbertoWord.convert((long) ttt) + " Only";
                words.setText(converted);
                cur.setText(String.valueOf(cr));
                //eamt.setText(String.valueOf(cr));

                thousand.setText(String.valueOf(th));
              //  e1000.setText(String.valueOf(th));
                fiveh.setText(String.valueOf(fh));
                //e500.setText(String.valueOf(fh));
                hundred.setText(String.valueOf(hd));
                //e100.setText(String.valueOf(hd));
                fifty.setText(String.valueOf(ff));
                //e50.setText(String.valueOf(ff));
                twenty.setText(String.valueOf(tw));
                //e20.setText(String.valueOf(tw));
                ten.setText(String.valueOf(te));
                //e10.setText(String.valueOf(te));
                five.setText(String.valueOf(fv));
                //e5.setText(String.valueOf(fv));

            }
            else
            total.setText("");
                 /*


            int answer = firtValue + secondValue + thirdValue + forthValue;

            Log.e("RESULT", String.valueOf(answer));
            tvResult.setText(String.valueOf(answer));
        }else {
            tvResult.setText("");
        }*/
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

}

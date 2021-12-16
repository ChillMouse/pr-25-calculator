package ru.kovtunenko.pr_25_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.Format;

public class MainActivity extends Activity implements View.OnClickListener {

    Button btnRS;
    Button btnQT;

    EditText etNum1;
    EditText etNum2;

    Button btnAdd;
    Button btnSub;
    Button btnMult;
    Button btnDiv;

    TextView tvResult;

    String oper = "";

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // находим элементы
        etNum1 = (EditText) findViewById(R.id.etNum1);
        etNum2 = (EditText) findViewById(R.id.etNum2);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnSub = (Button) findViewById(R.id.btnSub);
        btnMult = (Button) findViewById(R.id.btnMult);
        btnDiv = (Button) findViewById(R.id.btnDiv);

        tvResult = (TextView) findViewById(R.id.tvResult);

        btnRS = (Button) findViewById(R.id.reset);
        btnQT = (Button) findViewById(R.id.quit);

        // прописываем обработчик
        btnAdd.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnMult.setOnClickListener(this);
        btnSub.setOnClickListener(this);

        btnRS.setOnClickListener(this);
        btnQT.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        float num1 = 0;
        float num2 = 0;
        float result = 0;

        // Проверяем поля на пустоту
        if (TextUtils.isEmpty(etNum1.getText().toString())
                || TextUtils.isEmpty(etNum2.getText().toString())) {
            return;
        }

        // читаем EditText и заполняем переменные числами
        num1 = Float.parseFloat(etNum1.getText().toString());
        num2 = Float.parseFloat(etNum2.getText().toString());

        // определяем нажатую кнопку и выполняем соответствующую операцию
        // в oper пишем операцию, потом будем использовать в выводе

        switch (v.getId()) {
            case R.id.btnAdd:
                oper = " + ";
                result = num1 + num2;
                break;
            case R.id.btnSub:
                oper = " - ";
                result = num1 - num2;
                break;
            case R.id.btnMult:
                oper = " * ";
                result = num1 * num2;
                break;
            case R.id.btnDiv:
                oper = " / ";
                result = num1 / num2;
                break;
            case R.id.reset:
                etNum1.setText("");
                etNum2.setText("");
                tvResult.setText(" ");
                break;
            case R.id.quit:
                finish();
                break;
            default:
                break;
        }
        if (v.getId() != btnQT.getId() && v.getId() != btnRS.getId()){
            // формируем строку вывода
            tvResult.setText(String.format("%f %s %f = %f", num1, oper, num2, result));
        }
    }


}

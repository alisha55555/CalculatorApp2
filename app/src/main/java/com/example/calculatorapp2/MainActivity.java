package com.example.calculatorapp2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.calculatorapp2.R;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private String input = "";
    private String operator = "";
    private double num1 = 0;
    private double num2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Связываем элемент интерфейса
        editText = findViewById(R.id.editText);

        // Устанавливаем слушатели событий для кнопок
        setupButtonListeners();
    }

    private void setupButtonListeners() {
        // Устанавливаем обработчики для кнопок цифр
        findViewById(R.id.btn_0).setOnClickListener(view -> addDigit("0"));
        findViewById(R.id.btn_1).setOnClickListener(view -> addDigit("1"));
        findViewById(R.id.btn_2).setOnClickListener(view -> addDigit("2"));
        findViewById(R.id.btn_3).setOnClickListener(view -> addDigit("3"));
        findViewById(R.id.btn_4).setOnClickListener(view -> addDigit("4"));
        findViewById(R.id.btn_5).setOnClickListener(view -> addDigit("5"));
        findViewById(R.id.btn_6).setOnClickListener(view -> addDigit("6"));
        findViewById(R.id.btn_7).setOnClickListener(view -> addDigit("7"));
        findViewById(R.id.btn_8).setOnClickListener(view -> addDigit("8"));
        findViewById(R.id.btn_9).setOnClickListener(view -> addDigit("9"));

        // Устанавливаем обработчики для кнопок операций
        findViewById(R.id.btn_add).setOnClickListener(view -> setOperator("+"));
        findViewById(R.id.btn_subtract).setOnClickListener(view -> setOperator("-"));
        findViewById(R.id.btn_multiply).setOnClickListener(view -> setOperator("*"));
        findViewById(R.id.btn_divide).setOnClickListener(view -> setOperator("/"));
        findViewById(R.id.btn_sqrt).setOnClickListener(view -> calculateSqrt());

        // Устанавливаем обработчики для кнопок дополнительных операций
        findViewById(R.id.btn_clear).setOnClickListener(view -> clear());
        findViewById(R.id.btn_back).setOnClickListener(view -> backspace());
        findViewById(R.id.btn_sign).setOnClickListener(view -> changeSign());
        findViewById(R.id.btn_equals).setOnClickListener(view -> calculateResult());
    }

    // Метод для добавления цифр к текущему вводу
    private void addDigit(String digit) {
        input += digit;
        editText.setText(input);
    }

    // Метод для установки оператора
    private void setOperator(String op) {
        if (!input.isEmpty()) {
            num1 = Double.parseDouble(input);
            operator = op;
            input = "";
        }
    }

    // Метод для вычисления результата
    private void calculateResult() {
        if (!input.isEmpty()) {
            num2 = Double.parseDouble(input);
            double result = 0;

            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        editText.setText("Error");
                        return;
                    }
                    break;
                default:
                    return;
            }

            editText.setText(String.valueOf(result));
            input = String.valueOf(result);
        }
    }

    // Метод для вычисления квадратного корня
    private void calculateSqrt() {
        if (!input.isEmpty()) {
            double value = Double.parseDouble(input);
            if (value >= 0) {
                editText.setText(String.valueOf(Math.sqrt(value)));
                input = String.valueOf(Math.sqrt(value));
            } else {
                editText.setText("Error");
            }
        }
    }

    // Метод для очистки поля
    private void clear() {
        input = "";
        editText.setText("");
    }

    // Метод для удаления последнего символа
    private void backspace() {
        if (!input.isEmpty()) {
            input = input.substring(0, input.length() - 1);
            editText.setText(input);
        }
    }

    // Метод для изменения знака числа
    private void changeSign() {
        if (!input.isEmpty()) {
            double value = Double.parseDouble(input);
            value = -value;
            input = String.valueOf(value);
            editText.setText(input);
        }
    }
}

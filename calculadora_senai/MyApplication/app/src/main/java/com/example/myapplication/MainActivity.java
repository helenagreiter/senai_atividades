package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView display;
    private String currentInput = "";
    private String currentOperator = "";
    private double operand1 = Double.NaN;
    private double operand2;
    private boolean resetScreen = false;
    private double memory = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.display);

        // ===== BOTÕES NUMÉRICOS =====
        int[] numberButtonIds = {
                R.id.btn_0, R.id.btn_1, R.id.btn_2, R.id.btn_3, R.id.btn_4,
                R.id.btn_5, R.id.btn_6, R.id.btn_7, R.id.btn_8, R.id.btn_9
        };

        for (int id : numberButtonIds) {
            findViewById(id).setOnClickListener(v ->
                    onNumberButtonClick(((Button) v).getText().toString())
            );
        }

        // ===== VÍRGULA =====
        findViewById(R.id.btn_equals).setOnClickListener(v -> onDecimalButtonClick());

        // ===== OPERADORES (incluindo divisão) =====
        findViewById(R.id.btn_add).setOnClickListener(View v -> onOperatorButtonClick("+"));
        findViewById(R.id.btn_minus).setOnClickListener(View v -> onOperatorButtonClick("-"));
        findViewById(R.id.btn_multiply).setOnClickListener(View v -> onOperatorButtonClick("×"));
        findViewById(R.id.btn_divide).setOnClickListener(View v -> onOperatorButtonClick("÷")); // ← NOVO

        // ===== IGUAL =====
        findViewById(R.id.btn_equals).setOnClickListener(View v -> onEqualsButtonClick());

        // ===== FUNÇÕES ESPECIAIS =====
        findViewById(R.id.btn_plus_minus).setOnClickListener(View v -> onSignButtonClick());
        findViewById(R.id.btn_percent).setOnClickListener(View v -> onPercentButtonClick());
        findViewById(R.id.btn_c).setOnClickListener(View v -> onClearButtonClick());
        findViewById(R.id.btn_ce).setOnClickListener(View v -> onClearEntryButtonClick());
        findViewById(R.id.btn_backspace).setOnClickListener(View v -> onBackspaceButtonClick());
        findViewById(R.id.btn_reciprocal).setOnClickListener(View v -> onReciprocalButtonClick());
        findViewById(R.id.btn_square).setOnClickListener(View v -> onSquareButtonClick());
        findViewById(R.id.btn_cube_root).setOnClickListener(View v -> onCubeRootButtonClick());

        // ===== MEMÓRIA =====
        findViewById(R.id.btn_mc).setOnClickListener(View v -> onMemoryClear());
        findViewById(R.id.btn_mr).setOnClickListener(View v -> onMemoryRecall());
        findViewById(R.id.btn_m_plus).setOnClickListener(View v -> onMemoryAdd());
        findViewById(R.id.btn_m_minus).setOnClickListener(View v -> onMemorySubtract());
        findViewById(R.id.btn_ms).setOnClickListener(View v -> onMemoryStore());
        findViewById(R.id.btn_mv).setOnClickListener(View v -> onMemoryView());
    }
}
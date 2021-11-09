package startmobiletechnology.gmail.diagrampiechart;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PieChart pieChart = findViewById(R.id.pieChart);

        // Создание и заполнение элементов диаграммы
        ArrayList<PieEntry> scoreList = new ArrayList<>();
        scoreList.add(new PieEntry(17f, "Верно"));
        scoreList.add(new PieEntry(5f, "Пропущено"));
        scoreList.add(new PieEntry(3f, "Неверно"));

        // PieDataSet pieDataSet = new PieDataSet(scoreList, "Это метка");
        PieDataSet pieDataSet = new PieDataSet(scoreList, " - Результат");


        PieData pieData = new PieData(pieDataSet);

        pieChart.setData(pieData);
        pieChart.getDescription().setEnabled(false); // отключение описания диаграммы
        // Установка цветов круговой диаграммы
        pieDataSet.setColors( Color.GREEN,  Color.YELLOW, Color.RED);
        //------------------------------------------------------------------------------------------
        // Показ значка % после цифры на диаграмме
        // (https://github.com/PhilJay/MPAndroidChart/issues/2124)
        pieData.setValueFormatter(new PercentFormatter(pieChart));
        pieChart.setUsePercentValues(true);
        //------------------------------------------------------------------------------------------
        pieChart.getLegend().setEnabled(false); // false - Отключение показа легенды
        pieChart.getLegend().setTextSize(14); // размер шрифта легенды
        pieChart.getLegend().setFormSize(16); // размер цветных квадратиков
        //------------------------------------------------------------------------------------------
        // Цвет и размер цифровых значений
        pieDataSet.setValueTextColor(Color.BLUE);
        pieDataSet.setValueTextSize(18f);
        //------------------------------------------------------------------------------------------
        pieChart.setDrawEntryLabels(true); // показ меток-подписей на частях диаграммы
        pieChart.setEntryLabelTextSize(12f); // размер меток-подписей на частях диаграммы
        pieChart.setEntryLabelColor(Color.BLUE); // цвет меток-подписей на частях диаграммы
        //------------------------------------------------------------------------------------------
        pieChart.setDrawHoleEnabled(true); // false - круговая диаграмма, true - кольцевая диаграмма
        pieChart.setDrawRoundedSlices(false); // true - создание круговых переходных линий (иллюзия объемности)
        pieChart.setDrawSlicesUnderHole(false); // true - написание поверх отверстия в диаграмме (наложение на графику)
        pieChart.setHoleRadius(50); // диаметр внутреннето отверстия в %
        pieChart.setTransparentCircleRadius(50); // диаметр полупрозрачной окружности в %
        pieChart.setSoundEffectsEnabled(true); // Разрешить звуковые эффекты
        //------------------------------------------------------------------------------------------
        // Центральный текст
        pieChart.setCenterText("Статистика результатов теста");
        pieChart.setCenterTextColor(Color.BLUE);
        //pieChart.setCenterTextColor(Color.parseColor(#0099FF)); // не работает
        pieChart.setCenterTextSize(18f);
        //------------------------------------------------------------------------------------------
        pieChart.animate();

    }

}
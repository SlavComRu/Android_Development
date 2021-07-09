package demo.com;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerColors;
    private TextView textViewDescriptorTemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinnerColors = findViewById(R.id.spinnerColors);
        textViewDescriptorTemp = findViewById(R.id.textViewDescriptorTemp);
    }

    public void showDescriptor(View view) {
        int position = spinnerColors.getSelectedItemPosition();
        String description = getDescriptorByPosition(position);
        textViewDescriptorTemp.setText(description);
    }
    private String getDescriptorByPosition(int position){
        String [] descriptions = getResources().getStringArray(R.array.descriptor_of_temp);
        return descriptions[position];
    }
}
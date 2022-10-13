package com.example.home_gym;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.home_gym.Databse.DBHandler;
import com.example.home_gym.Models.DietModel;

public class UpdateDiet extends AppCompatActivity {

    EditText edDietTime, edDietDate, edDietBody;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_diet);

        DietModel dietModel = (DietModel) getIntent().getExtras().getSerializable("DIETS");

        id = dietModel.getId();

        edDietTime = findViewById(R.id.edDietTime);
        edDietDate = findViewById(R.id.edDietDate);
        edDietBody = findViewById(R.id.edDietBody);

        edDietTime.setText(dietModel.getdTime());
        edDietDate.setText(dietModel.getdDate());
        edDietBody.setText(dietModel.getdDescription());
    }


    public void UpdateDiet(View view) {
        String dietTime = edDietTime.getText().toString().toString();
        String dietDate = edDietDate.getText().toString().toString();
        String dietBody = edDietBody.getText().toString().toString();

        DietModel dietModel = new DietModel(id,dietTime,dietDate, dietBody);

        DBHandler dbHandler = new DBHandler(this);
        int result = dbHandler.UpdateDietPlan(dietModel);

        if(result > 0){
            Toast.makeText(this, "Updated Successfully", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();
        }
    }
}

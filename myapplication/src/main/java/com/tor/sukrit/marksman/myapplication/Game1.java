package com.tor.sukrit.marksman.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Game1 extends AppCompatActivity {
    private TextView txtQuestion;
    private ImageView imvIshihara;
    private RadioGroup radAnswer;
    private RadioButton radChoice1,radChoice2,radChoice3, radChoice4;
    private Button btnAnswer;
    private String strChoice[];
    private int inFromRadioButton, intRadioModel, intButtonModel, intTime = 1, intScore, intArrayUserChoose[], intArrayTrueAnswer[];
    private Getvalue1 objMyModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game1);
        //Initial Widget
        initialWidget();

        setUpArray();

        //About Button Controller
        btnAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (inFromRadioButton == 0) {
                    showAlertDialog();
                } else {
                    if (intTime == 10) {
                        checkScore();
                        Intent objIntent = new Intent(Game1.this, ShowScore.class);
                        objIntent.putExtra("Score", intScore);
                        startActivity(objIntent);
                        finish();
                    } else {
                        checkScore();

                        intTime++;
                        objMyModel.setIntButton(intTime);
                    }
                }
            }
        });


        //About MyModel
        objMyModel = new Getvalue1();
        objMyModel.setOnMyModelChangeListener(new Getvalue1.OnMyModelChangeListener() {
            @Override
            public void onMyModelChangeListener(Getvalue1 mymodel) {
                //from intRadio
                intRadioModel = mymodel.getIntRadio();
                Log.d("Game1", "RadioModel==>" + String.valueOf(intRadioModel));

                intButtonModel = objMyModel.getIntButton();
                switch (intButtonModel) {

                    case 2:
                        imvIshihara.setImageResource(R.drawable.ishihara_02);
                        strChoice = getResources().getStringArray(R.array.ga2);
                        setTextChoice();
                        break;
                    case 3:
                        imvIshihara.setImageResource(R.drawable.ishihara_03);
                        strChoice = getResources().getStringArray(R.array.ga3);
                        setTextChoice();
                        break;
                    case 4:
                        imvIshihara.setImageResource(R.drawable.ishihara_04);
                        strChoice = getResources().getStringArray(R.array.ga4);
                        setTextChoice();
                        break;
                    case 5:
                        imvIshihara.setImageResource(R.drawable.ishihara_05);
                        strChoice = getResources().getStringArray(R.array.ga5);
                        setTextChoice();
                        break;
                    case 6:
                        imvIshihara.setImageResource(R.drawable.ishihara_06);
                        strChoice = getResources().getStringArray(R.array.ga6);
                        setTextChoice();
                        break;
                    case 7:
                        imvIshihara.setImageResource(R.drawable.ishihara_07);
                        strChoice = getResources().getStringArray(R.array.ga7);
                        setTextChoice();
                        break;
                    case 8:
                        imvIshihara.setImageResource(R.drawable.ishihara_08);
                        strChoice = getResources().getStringArray(R.array.ga8);
                        setTextChoice();
                        break;
                    case 9:
                        imvIshihara.setImageResource(R.drawable.ishihara_09);
                        strChoice = getResources().getStringArray(R.array.ga9);
                        setTextChoice();
                        break;
                    case 10:
                        imvIshihara.setImageResource(R.drawable.ishihara_10);
                        strChoice = getResources().getStringArray(R.array.ga10);
                        setTextChoice();
                        break;
                }
                txtQuestion.setText(String.valueOf(intButtonModel) + ". What is number ?");

            }
        });


        //About RadioButton Controller
        radAnswer.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch (i) {
                    case R.id.raG_1:
                        inFromRadioButton = 1;
                        break;
                    case R.id.raG_2:
                        inFromRadioButton = 2;
                        break;
                    case R.id.raG_3:
                        inFromRadioButton = 3;
                        break;
                    case R.id.raG_4:
                        inFromRadioButton = 4;
                        break;
                    default:
                        inFromRadioButton = 0;
                        break;
                }//end switch

                //check inFromRadioButton
                Log.d("Game1", "inFromRadioButton==>" + String.valueOf(inFromRadioButton));

                //Sent inFromRadioButton to MyModel
                objMyModel.setIntRadio(inFromRadioButton);
            }

        });


    }

    private void showAlertDialog() {

        AlertDialog.Builder objAlert = new AlertDialog.Builder(this);
        objAlert.setIcon(R.drawable.stop_160734_960_720);
        objAlert.setTitle("Choose Answer");
        objAlert.setMessage("Please Choose Answer Just One");
        objAlert.setCancelable(false);
        objAlert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        objAlert.show();
    }

    protected void onStart() {
        super.onStart();
        strChoice = getResources().getStringArray(R.array.ga1);
        setTextChoice();
    }// end of onStart

    private void setTextChoice() {
        radChoice1.setText(strChoice[0]);
        radChoice2.setText(strChoice[1]);
        radChoice3.setText(strChoice[2]);
        radChoice4.setText(strChoice[3]);
    }//end of setTextToChoice

    private void setUpArray() {
        intArrayUserChoose = new int[11];
        intArrayTrueAnswer = new int[11];
        intArrayTrueAnswer[1] = 1;
        intArrayTrueAnswer[2] = 3;
        intArrayTrueAnswer[3] = 4;
        intArrayTrueAnswer[4] = 4;
        intArrayTrueAnswer[5] = 3;
        intArrayTrueAnswer[6] = 2;
        intArrayTrueAnswer[7] = 3;
        intArrayTrueAnswer[8] = 4;
        intArrayTrueAnswer[9] = 4;
        intArrayTrueAnswer[10] = 4;
    }//Answer

    private void checkScore() {
        intArrayUserChoose[intTime] = inFromRadioButton;
        if (intArrayUserChoose[intTime] == intArrayTrueAnswer[intTime]) {
            intScore++;
        }
    }

    private void initialWidget(){
        txtQuestion = (TextView) findViewById(R.id.tv232);
        imvIshihara = (ImageView) findViewById(R.id.img4_44);
        radAnswer = (RadioGroup) findViewById(R.id.radioGroup);
        radChoice1 = (RadioButton) findViewById(R.id.raG_1);
        radChoice2 = (RadioButton) findViewById(R.id.raG_2);
        radChoice3 = (RadioButton) findViewById(R.id.raG_3);
        radChoice4 = (RadioButton) findViewById(R.id.raG_4);
        btnAnswer = (Button) findViewById(R.id.btn_next11);
    }
}

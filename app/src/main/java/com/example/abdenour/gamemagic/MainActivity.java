package com.example.abdenour.gamemagic;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //Récupérer les valeurs saisies par l'utilisateur
    EditText case11, case12, case13, case21, case22, case23, case31, case32, case33;


    Button help;

    //Cacul score and sauvegard the high score
    SharedPreferences sp;
    SharedPreferences.Editor editor;
    Random rand=new Random();

    int matrice[][] = new int[3][3];
    //Eviter les double
    int nb_occ =0; 
    
    Button Submit;
    // déclaration d'un timer 
    private Chronometer chronometer;

    // Générer les sommes
    TextView result1;
    TextView result2;
    TextView result3;
    TextView result4;
    TextView result5;
    TextView result6;

    // stocké le meuilleur score.
    TextView meilleurscore;
    // Afficher le score actuel après avoir trouvé le résultat
    TextView scoreactuel;
    // Récupérer le temps en milliseconde
    long elapsedMillis = 0;

    // Calculer les sommes des nombres saisies par l'utilisateur
    int ResultSom1= 0;
    int ResultSom2= 0;
    int ResultSom3= 0;
    int ResultSom4= 0;
    int ResultSom5= 0;
    int ResultSom6= 0;


    //Matrice EditText pour stocké les valeurs saisies par l'utilisateur
    EditText me [] [] = new EditText [3][3];

    //Récupérer le niveau choisis
    int level;

    //Récupérer le meuillleur score précédent
    Long scoreprecedent= Long.valueOf(0);
    Long timepause= 0L;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intentrecu = getIntent();

        matrice[0][0]=intentrecu.getIntExtra("matrice[0][0]",0);
        matrice[0][1]=intentrecu.getIntExtra("matrice[0][1]",0);
        matrice[0][2]=intentrecu.getIntExtra("matrice[0][2]",0);
        matrice[1][0]=intentrecu.getIntExtra("matrice[1][0]",0);
        matrice[1][1]=intentrecu.getIntExtra("matrice[1][1]",0);
        matrice[1][2]=intentrecu.getIntExtra("matrice[1][2]",0);
        matrice[2][0]=intentrecu.getIntExtra("matrice[2][0]",0);
        matrice[2][1]=intentrecu.getIntExtra("matrice[2][1]",0);
        matrice[2][2]=intentrecu.getIntExtra("matrice[2][2]",0);


        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice.length; j++) {
                if (i == 0) {
                    ResultSom1 = ResultSom1 + matrice[i][j];
                    ResultSom2 = ResultSom2 + matrice[j][i];
                }

                if (i == 1) {
                    ResultSom3 = ResultSom3 + matrice[i][j];
                    ResultSom4 = ResultSom4 + matrice[j][i];
                    // calculer les Sommes verticaux et horisontaux de la matrice déja remplie
                }

                if (i == 2) {
                    ResultSom5 = ResultSom5 + matrice[i][j];
                    ResultSom6 = ResultSom6 + matrice[j][i];

                }
            }
        }

        // Afficher les résultats à l'utilisateur
        result1 = (TextView) findViewById(R.id.result1_4);
        result1.setText(String.valueOf(ResultSom1));
        result2 = (TextView)  findViewById(R.id.result2_4);
        result2.setText(String.valueOf(ResultSom3));
        result3 = (TextView) findViewById(R.id.result3_4);
        result3.setText(String.valueOf(ResultSom5));
        result4 = (TextView) findViewById(R.id.result4_1);
        result4.setText(String.valueOf(ResultSom2));
        result5 = (TextView) findViewById(R.id.result4_2);
        result5.setText(String.valueOf(ResultSom4));
        result6 = (TextView) findViewById(R.id.result4_3);
        result6.setText(String.valueOf(ResultSom6));


        case11 = (EditText) findViewById(R.id.grid1_1);
        me [0][0] =case11;
        case12 = (EditText) findViewById(R.id.grid1_2);
        me [0][2] =case12;
        case13 = (EditText) findViewById(R.id.grid1_3);
        me [0][2] =case13;
        case22 = (EditText) findViewById(R.id.grid2_2);
        me [1][1] =case22;
        case21 = (EditText) findViewById(R.id.grid2_1);
        me [1][0] =case21;
        case23 = (EditText) findViewById(R.id.grid2_3);
        me [1][2] =case23;
        case31 = (EditText) findViewById(R.id.grid3_1);
        me [2][0] =case31;
        case32 = (EditText) findViewById(R.id.grid3_2);
        me [2][1] =case32;
        case33 = (EditText) findViewById(R.id.grid3_3);
        me [2][2] =case33;




        level = intentrecu.getIntExtra("level",0);

        sp = getPreferences(MODE_PRIVATE);
        // Edit sp pour modifier
        editor = sp.edit();
/********************************* programme facile******************************************/
        if (level==1) {
            // Récupérer le meuilleur score déja obtenue la variable meilleurscore
            scoreprecedent = sp.getLong("meilleur score level facile",0);
            // minute
            int min = (int)(scoreprecedent/60000);
            // seconde
            int sec = (int) ((scoreprecedent/1000) % 60);

            for (int i = 1; i < me.length; i++) {
                for (int j =0 ; j < me.length; j++){
                    me[i][j].setText(String.valueOf(matrice[i][j]));
                    me[i][j].setEnabled(false);
                    me[i][j].setTextColor(getResources().getColor(R.color.noir));
                }
            }
/********************************* programme moyen******************************************/
        } else if(level == 2) {
            // Récupérer le meuilleur score déja obtenue la variable meilleurscore
            scoreprecedent = sp.getLong("meilleur score level moyen",0);
            // minute
            int min = (int)(scoreprecedent/60000);
            // seconde
            int sec = (int) ((scoreprecedent/1000) % 60);

            me[0][2].setText(String.valueOf(matrice[0][2]));
            me[1][1].setText(String.valueOf(matrice[1][1]));
            me[2][0].setText(String.valueOf(matrice[2][0]));

 /********************************* programme hard******************************************/
        } else {
            // Récupérer le meuilleur score déja obtenue la variable meilleurscore
            scoreprecedent = sp.getLong("meilleur score level hard",0);
            // minute
            int min = (int)(scoreprecedent/60000);
            // seconde
            int sec = (int) ((scoreprecedent/1000) % 60);

        }



        chronometer = (Chronometer) findViewById(R.id.chronometer);
        chronometer.setBase(SystemClock.elapsedRealtime());

        help = findViewById(R.id.help);
        help.setEnabled(true);

        Submit = ( Button) findViewById(R.id.Buttonsubmit);

        meilleurscore = findViewById(R.id.score);
        scoreactuel =findViewById(R.id.score1);

    }


    @Override
    protected void onStart() {
        super.onStart();
        chronometer.start();
    }


    @Override
    protected void onResume() {
        super.onResume();
        chronometer.setBase(SystemClock.elapsedRealtime()-timepause);
        chronometer.start();
    }


    @Override
    protected void onPause() {
        super.onPause();
        chronometer.stop();
        timepause = SystemClock.elapsedRealtime() - chronometer.getBase();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putLong("timepause",timepause);
        outState.putInt("level",level);
    }



    @Override
    protected void  onRestoreInstanceState (Bundle donnees) {
        super.onRestoreInstanceState(donnees);
        timepause = donnees.getLong("timepause");
        level = donnees.getInt("level");

    }

    //quit
    public void quitlevel(View v){
        Intent in = new Intent(this, Level.class);
        startActivity(in);
    }

    // la fonction calcul le nombre d'occurence d'un nombre
    public int nombre_occ(Long l, Long m [][],  EditText me[] []) {
        nb_occ = 0;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                if (l == m[i][j]) {
                   nb_occ++;

                }
            }
        }
         return nb_occ;
    }

    // fonction qui compare la matrice déja remplie dans la méthode onCreate par des nombres (1-9) placé alétoirement
    public int comparegrid(Long m [][],int mat [][]){
        int ctrue=0;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                if (m[i][j] == mat[i][j]) {
                    ctrue ++;
                }

            }
        }
        return ctrue;
    }



    // onClick submit
    public void Valider(View v) {

        final EditText grid11;
        final EditText grid12;
        final EditText grid13;
        final EditText grid21;
        final EditText grid22;
        final EditText grid23;
        final EditText grid31;
        final EditText grid32;
        final EditText grid33;

        Long m[][] = new Long[3][3];

        Long som1_4 = Long.valueOf(0), som4_1 = Long.valueOf(0), som2_4 = Long.valueOf(0), som4_2 = Long.valueOf(0), som3_4 = Long.valueOf(0), som4_3 = Long.valueOf(0);


        grid11 = (EditText) findViewById(R.id.grid1_1);
        me[0][0] = grid11;
        m[0][0] = Long.valueOf(grid11.getText().toString());
        grid12 = (EditText) findViewById(R.id.grid1_2);
        me[0][2] = grid12;
        m[0][1] = Long.valueOf(grid12.getText().toString());
        grid13 = (EditText) findViewById(R.id.grid1_3);
        me[0][2] = grid13;
        m[0][2] = Long.valueOf(grid13.getText().toString());
        grid21 = (EditText) findViewById(R.id.grid2_1);
        me[1][0] = grid21;
        m[1][0] = Long.valueOf(grid21.getText().toString());
        grid22 = (EditText) findViewById(R.id.grid2_2);
        me[1][1] = grid22;
        m[1][1] = Long.valueOf(grid22.getText().toString());
        grid23 = (EditText) findViewById(R.id.grid2_3);
        me[1][2] = grid23;
        m[1][2] = Long.valueOf(grid23.getText().toString());
        grid31 = (EditText) findViewById(R.id.grid3_1);
        me[2][0] = grid31;
        m[2][0] = Long.valueOf(grid31.getText().toString());
        grid32 = (EditText) findViewById(R.id.grid3_2);
        me[2][1] = grid32;
        m[2][1] = Long.valueOf(grid32.getText().toString());
        grid33 = (EditText) findViewById(R.id.grid3_3);
        me[2][2] = grid33;
        m[2][2] = Long.valueOf(grid33.getText().toString());


        //  récupération des valeurs saisie par l'utilistauer
        if (grid11.getText().toString().length() == 0) {
            Toast.makeText(this, "Vous devez renseigner tous les champs !", Toast.LENGTH_SHORT).show();
            return;
        } else {
            // Calculer les sommes de la matrice
            for (int i = 0; i < m.length; i++) {
                for (int j = 0; j < m.length; j++) {
                    if (i == 0) {
                        som1_4 = som1_4 + m[i][j];
                        som4_1 = som4_1 + m[j][i];
                    }
                    if (i == 1) {
                        som2_4 = som2_4 + m[i][j];
                        som4_2 = som4_2 + m[j][i];
                    }
                    if (i == 2) {
                        som3_4 = som3_4 + m[i][j];
                        som4_3 = som4_3 + m[j][i];
                    }
                }
            }


            int nb_occtotal = 0;
            for (int i = 0; i < m.length; i++) {
                for (int j = 0; j < m.length; j++) {
                    nb_occtotal = nb_occtotal + nombre_occ(m[i][j], m, me);
                 }
            }
            // si il n'y a pas de double faire
            if (nb_occtotal == 9) {
                // si l'utilisateur à bien saisie les nombres dans les cases qu'il fallait on retourne un nombre égale a 9
                int mattrue = comparegrid(m, matrice);

                if ((mattrue == 9) || ((som4_1 == ResultSom2) && (som1_4 == ResultSom1) && (som4_2 == ResultSom4) && (som2_4 == ResultSom3) && (som4_3 == ResultSom6) && (som3_4 == ResultSom5))) {
                    // on active le button continue
                    Toast.makeText(this, "Congratulations!", Toast.LENGTH_SHORT).show();
                    // désactivé le button submit
                    Submit.setEnabled(false);
                    // désactivé le button help
                    help.setEnabled(false);

                    // on stop le chrono
                    chronometer.stop();
                    // Récupérer le temps pris pour la partie
                    elapsedMillis = SystemClock.elapsedRealtime() - chronometer.getBase();
                    /*****partie facile*****/
                    if (level == 1) {
                        // si l'utilisateur joue pour la premiére fois son score est le meuilleure score
                        if (scoreprecedent == Long.valueOf(0)) {
                            editor.putLong("meilleur score level facile", elapsedMillis);
                            // sauvegarder dans la mémoire cache
                            editor.commit();
                            // si le score actuel inférieure au meuilleur score
                        } else if (elapsedMillis < scoreprecedent) {
                            // le score deviens le meuilleure score
                            editor.putLong("meilleur score level facile", elapsedMillis);
                            editor.commit();
                        }

                        /*****partie moyenne*****/
                    } else if (level == 2) {
                        // si l'utilisateur joue pour la premiére fois son score est le meuilleure score
                        if (scoreprecedent == Long.valueOf(0)) {
                            editor.putLong("meilleur score level moyen", elapsedMillis);
                            editor.commit();
                        } else if (elapsedMillis < scoreprecedent) {

                            editor.putLong("meilleur score level moyen", elapsedMillis);
                            editor.commit();
                        }

                        /*****partie Difficile*****/
                    } else {

                        if (scoreprecedent == Long.valueOf(0)) {
                            editor.putLong("meilleur score level hard", elapsedMillis);
                            editor.commit();
                        } else if (elapsedMillis < scoreprecedent) {

                            editor.putLong("meilleur score level hard", elapsedMillis);
                            editor.commit();
                        }

                    }

                    // si l'utlisateur n'a pas encore trouvé de solution
                } else {

                    Toast.makeText(this, "result is false!!! Try Again", Toast.LENGTH_SHORT).show();
                }

                // si l'utilisateur à saisie des nombres egaux
            } else Toast.makeText(this, "Numbers 1-9 must be\n" +
                    "used once and once", Toast.LENGTH_SHORT).show();
        }
    }


    public void helpClick (View v) {

        int chercher=0;
        int i=rand.nextInt(3)+0;
        int j=rand.nextInt(3)+0;
        // stocker la valeur dans la matrice EditText me
        me[i][j].setText(String.valueOf(matrice[i][j]));
        me [i][j]  .setTextColor(getResources().getColor(R.color.green));

        Button btnhel = findViewById(R.id.help);
        btnhel.setEnabled(false);

    }



    public void OnclickNewgame (View v) {
        Intent intenetnewgame = new Intent(  this, Level.class);
        startActivity(intenetnewgame);
        this.finish();
    }


    // cette méthode pour récupérée et affiché les scores high et current score
    public void Currenthighscore (View v){
        Long  data ;
        int mins = (int)(elapsedMillis/60000);
        int secs = (int) ((elapsedMillis/1000) % 60);

        if (level == 1) {
            data = sp.getLong("meilleurscorelevelfacile", 0);
            int  min = (int) (data / 60000);
            int sec = (int) ((data / 1000) % 60);
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("High score:"+String.valueOf(min) +":"+String.valueOf(sec)+"\n"+"Current score:"+String.valueOf(mins) +":"+String.valueOf(secs));
            builder.setCancelable(true);
            AlertDialog dialog = builder.create();
            dialog.show();

        } else if (level==2) {
            data = sp.getLong("meilleurscorelevelmoyen", 0);
            int min = (int) (data / 60000);
            int sec = (int) ((data / 1000) % 60);
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("High score:"+String.valueOf(min) +":"+String.valueOf(sec)+"\n"+"Current score:"+String.valueOf(mins) +":"+String.valueOf(secs));
            builder.setCancelable(true);
            AlertDialog dialog = builder.create();
            dialog.show();

        } else {
            data = sp.getLong("meilleurscorelevelhard", 0);
            int min = (int) (data / 60000);
            int sec = (int) ((data / 1000) % 60);
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("High score:"+String.valueOf(min) +":"+String.valueOf(sec)+"\n"+"Current score:"+String.valueOf(mins) +":"+String.valueOf(secs));
            builder.setCancelable(true);
            AlertDialog dialog = builder.create();
            dialog.show();

        }

    }

}

package com.example.abdenour.gamemagic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.Random;


public class Level extends AppCompatActivity {

    //click pour déffirencier les Levels chaque button mène a un niveau
    int click;
    // matrice qui stocke les valuers généré alétoirement de 1 à 9
    int matrice [][] = new int[3][3];
    // Généré des valeurs aléatoire de 1 à 9 
    Random rand=new Random();
    // liste des valeurs de 1 à 9
    ArrayList<Integer> list = new <Integer> ArrayList();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);
    }


    public void Onclickfacile (View v){

        Intent infacile = new Intent(this, MainActivity.class);

        // Remplir la list de 1 à 9
        list.add(1);  list.add(2);  list.add(3);  list.add(4);  list.add(5);  list.add(6);
        list.add(7);  list.add(8);  list.add(9);

        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice.length; j++) {
                int number;
                // Choix aléatoire de 1 à 9 dans la list
                number = list.get(rand.nextInt(list.size())+0);

                for (int k=0;k<list.size();k++){
                    if (number== list.get(k)) {
                        // retirer les doubles
                        matrice[i][j] = number;
                        list.remove(k);
                     }
                }
            }
        }


        infacile.putExtra("matrice[0][0]",matrice[0][0]);
        infacile.putExtra("matrice[0][1]",matrice[0][1]);
        infacile.putExtra("matrice[0][2]",matrice[0][2]);
        infacile.putExtra("matrice[1][0]",matrice[1][0]);
        infacile.putExtra("matrice[1][1]",matrice[1][1]);
        infacile.putExtra("matrice[1][2]",matrice[1][2]);
        infacile.putExtra("matrice[2][0]",matrice[2][0]);
        infacile.putExtra("matrice[2][1]",matrice[2][1]);
        infacile.putExtra("matrice[2][2]",matrice[2][2]);

        //click pour afficher la matrice de niveau1
        click =1;
        infacile.putExtra("level",click);
        startActivity(infacile);

    }

    public void Onclickmoyen (View v){
        Intent inmoyen = new Intent(this, MainActivity.class);

        // Remplir la list de 1 à 9
        list.add(1);  list.add(2);  list.add(3);  list.add(4);  list.add(5);  list.add(6);
        list.add(7);  list.add(8);  list.add(9);

        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice.length; j++) {
                int number;
                // Choix aléatoire de 1 à 9 dans la list
                number = list.get(rand.nextInt(list.size())+0);

                for (int k=0;k<list.size();k++){
                    if (number== list.get(k)) {
                        // retirer les doubles
                        matrice[i][j] = number;
                        list.remove(k);
                    }
                }
            }
        }


        inmoyen.putExtra("matrice[0][0]",matrice[0][0]);
        inmoyen.putExtra("matrice[0][1]",matrice[0][1]);
        inmoyen.putExtra("matrice[0][2]",matrice[0][2]);
        inmoyen.putExtra("matrice[1][0]",matrice[1][0]);
        inmoyen.putExtra("matrice[1][1]",matrice[1][1]);
        inmoyen.putExtra("matrice[1][2]",matrice[1][2]);
        inmoyen.putExtra("matrice[2][0]",matrice[2][0]);
        inmoyen.putExtra("matrice[2][1]",matrice[2][1]);
        inmoyen.putExtra("matrice[2][2]",matrice[2][2]);


        click =2;
        inmoyen.putExtra("level",click);
        startActivity(inmoyen);

    }

    public void Onclickhard (View v){
        Intent indifficile = new Intent(this, MainActivity.class);
        // Remplir la list de 1 à 9
        list.add(1);  list.add(2);  list.add(3);  list.add(4);  list.add(5);  list.add(6);
        list.add(7);  list.add(8);  list.add(9);

        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice.length; j++) {
                int number;
                // Choix aléatoire de 1 à 9 dans la list
                number = list.get(rand.nextInt(list.size())+0);

                for (int k=0;k<list.size();k++){
                    if (number== list.get(k)) {
                        // retirer les doubles
                        matrice[i][j] = number;
                        list.remove(k);
                    }
                }
            }
        }


        indifficile.putExtra("matrice[0][0]",matrice[0][0]);
        indifficile.putExtra("matrice[0][1]",matrice[0][1]);
        indifficile.putExtra("matrice[0][2]",matrice[0][2]);
        indifficile.putExtra("matrice[1][0]",matrice[1][0]);
        indifficile.putExtra("matrice[1][1]",matrice[1][1]);
        indifficile.putExtra("matrice[1][2]",matrice[1][2]);
        indifficile.putExtra("matrice[2][0]",matrice[2][0]);
        indifficile.putExtra("matrice[2][1]",matrice[2][1]);
        indifficile.putExtra("matrice[2][2]",matrice[2][2]);


        click =3;
        indifficile.putExtra("level",click);
        startActivity(indifficile);

    }


}

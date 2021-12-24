package com.delcey.listfootball;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Joueur> players;
    private ListView mListView;
    private PlayerAdapter playerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.listView);

        playerAdapter= new PlayerAdapter(getApplicationContext(),0);

        //Creation de la liste de joueur
        players = new ArrayList<Joueur>();

        //Autorisation pour ce connecter  l'API
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);

        //Instancier la liste de joueur en recuperant les info de l'API
        try {
                String myurl= "https://okochatest.footbar.com/profile/list/";
                System.out.println(myurl);

                URL url = new URL(myurl);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                InputStream inputStream = connection.getInputStream();
                System.out.println(inputStream);
                /*
                 * InputStreamOperations est une classe complémentaire:
                 * Elle contient une méthode InputStreamToString.*/

                String result = InputStreamOperations.InputStreamToString(inputStream);

                // On récupère le JSON complet
                JSONObject jsonObject = new JSONObject(String.valueOf(result));
                // On récupère le tableau d'objets qui nous concernent
                JSONArray array = new JSONArray(jsonObject.getString("results"));
                // Pour tous les objets on récupère les infos
                for (int i = 0; i < array.length(); i++) {
                    // On récupère un objet JSON du tableau
                    JSONObject obj = new JSONObject(array.getString(i));
                    // On fait le lien Personne - Objet JSON
                    Joueur player = new Joueur(obj.getString("name"),obj.getString("id"),obj.getString("speed_score"),
                            obj.getString("stamina_score"),obj.getString("dribbling_score"),obj.getString("defending_score"),
                            obj.getString("passing_score"),obj.getString("shooting_score"),obj.getString("score"),obj.getString("profile_pic"),obj.getString("city"));
                    // On ajoute la personne à la liste
                    players.add(player);

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            // On retourne la liste des personnes



        mListView.setAdapter(playerAdapter);
        playerAdapter.addAll(players);



    }
}
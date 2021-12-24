package com.delcey.listfootball;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

//Classe Adapteur pour lz liste
public class PlayerAdapter extends ArrayAdapter<Joueur> {
    public PlayerAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    @NonNull
    @Override

    //Affichage de la cellule dans la liste
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v;
        LayoutInflater layoutInflater= (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = layoutInflater.inflate(R.layout.player_cell, null);

        Joueur currentPlayer = getItem(position);

        TextView nomJoueur = (TextView)v.findViewById(R.id.title);
        TextView idy = (TextView)v.findViewById(R.id.idy);
        TextView speed = (TextView)v.findViewById(R.id.idSpeed);
        TextView stamina = (TextView)v.findViewById(R.id.idStamina);
        TextView dribbling = (TextView)v.findViewById(R.id.idDribbling);
        TextView defending = (TextView)v.findViewById(R.id.idDefending);
        TextView passing = (TextView)v.findViewById(R.id.idPassing);
        TextView shooting = (TextView)v.findViewById(R.id.idShooting);
        TextView score = (TextView)v.findViewById(R.id.idScore);
        TextView city = (TextView)v.findViewById(R.id.idCity);

        ImageView picture = (ImageView)v.findViewById(R.id.cover);


        nomJoueur.setText(currentPlayer.getName());
        idy.setText(currentPlayer.getId());
        speed.setText(currentPlayer.getSpeed());
        stamina.setText(currentPlayer.getStamina());
        dribbling.setText(currentPlayer.getDribbling());
        defending.setText(currentPlayer.getDefending());
        passing.setText(currentPlayer.getPassing());
        shooting.setText(currentPlayer.getShooting());
        score.setText(currentPlayer.getScore());
        city.setText(currentPlayer.getCity());
        try {
            picture.setImageBitmap(AddPicture(currentPlayer.getPicture()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return v;
    }

    // Verif pour ajouter une photo
    public Bitmap AddPicture(String url) throws IOException {
        if (url != "null"){
            URL iurl = new URL(url);
            HttpURLConnection httpConn = (HttpURLConnection) iurl.openConnection();
            httpConn.connect();
            int resCode = httpConn.getResponseCode();

            if (resCode == HttpURLConnection.HTTP_OK) {
                InputStream in = httpConn.getInputStream();
                Bitmap bitmap = BitmapFactory.decodeStream(in);
                return bitmap;
            }}
        else if ( url == "null"){
            URL pasurl = new URL("https://image.shutterstock.com/z/stock-photo--logo-photo-an-account-profile-that-does-not-use-photos-1934205389.jpg");
            HttpURLConnection httpConn = (HttpURLConnection) pasurl.openConnection();
            httpConn.connect();
            int resCode = httpConn.getResponseCode();

            if (resCode == HttpURLConnection.HTTP_OK) {
                InputStream in = httpConn.getInputStream();
                Bitmap bitmap = BitmapFactory.decodeStream(in);
                return bitmap;
            }

        }

        return null;
    }
}

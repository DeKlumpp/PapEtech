package ws;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VagaService {
    private Vaga vaga = new Vaga();

    private static String URL = "http://pap5semestre.ga/ws/vaga";

    public List<Vaga> getAll() {
        List<Vaga> vagas = new ArrayList<>();
        HttpURLConnection urlConnection = null;

        try {
            URL url = new URL(URL);
            urlConnection = (HttpURLConnection) url.openConnection();

            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            Scanner s = new Scanner(in);
            String conteudo = s.useDelimiter("\\A").next();

            Gson gson = new Gson();
            vagas = gson.fromJson(conteudo, new TypeToken<List<Vaga>>() {
            }.getType());
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            urlConnection.disconnect();
        }
        return vagas;
    }

    public void post(Object vaga) {
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL(URL);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setDoOutput(true);
            urlConnection.setRequestMethod("POST");
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.setRequestProperty("Accept", "application/json");

            OutputStream out = new BufferedOutputStream(urlConnection.getOutputStream());
            Writer w = new BufferedWriter(new OutputStreamWriter(out));

            Gson gson = new Gson();
            String json = gson.toJson(vaga);

            w.write(json);
            w.close();

            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            Scanner s = new Scanner(in);
            String conteudo = s.nextLine();
            in.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            urlConnection.disconnect();
        }
    }
}
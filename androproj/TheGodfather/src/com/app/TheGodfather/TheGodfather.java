package com.app.TheGodfather;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.http.entity.StringEntity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TheGodfather extends Activity implements View.OnClickListener
{
	// private static String TAG = "LOG";
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        ((Button)(findViewById(R.id.btn_Exec))).setOnClickListener(this);
    }

	public void onClick(View v)
	{
		// TODO Auto-generated method stub		
		String sWord1 = ((EditText)findViewById(R.id.txb_Word1)).getText().toString();
		String sWord2 = ((EditText)findViewById(R.id.txb_Word2)).getText().toString();
		String sResult = sWord1 + sWord2;
		
		/*
		// HTTP通信処理
		HttpURLConnection urlCon = null;
		InputStream in = null;
		
        try
        {
            // httpコネクションを確立し、urlを叩いて情報を取得
            URL url = new URL("http://weather.livedoor.com/forecast/webservice/rest/v1");
            urlCon = (HttpURLConnection)url.openConnection();
            urlCon.setRequestMethod("POST");				// パラメータ送信のPOSTを指定
            urlCon.setDoOutput(true); 						// POSTによるデータ送信を可能にする

            // POSTパラメータ
            String postDataSample = "city=63&day=today";	// パラメータ指定

            // POSTパラメータを設定
            OutputStream out = urlCon.getOutputStream();
          	out.write(postDataSample.getBytes());
          	out.flush();
          	out.close();

            // データを取得
            in = urlCon.getInputStream();					// 通信を行い応答データを取得
            BufferedReader br = new BufferedReader(new InputStreamReader(urlCon.getInputStream()));

            // InputStreamからbyteデータを取得するための変数
            StringBuffer bufStr = new StringBuffer();
            String temp = null;

            // InputStreamからのデータを文字列として取得する
            while((temp = br.readLine()) != null) 
            {
                bufStr.append(temp);
            }

            // 結果の取得
            sResult = bufStr.toString();
        }
        catch (IOException ioe ) 
        {
        	System.out.println(ioe);
        }
        finally 
        {
        	// 後始末
            urlCon.disconnect();
            
            try 
            {
				in.close();
			}
            catch (IOException e) 
            {
				e.printStackTrace();
			}
        }
		*/
		
		
		/*
		// 動作確認版
	    // URL
	    URI url = null;
		try 
		{
			url = new URI( "http://weather.livedoor.com/forecast/webservice/rest/v1" );
		}
		catch (URISyntaxException e2) 
		{
			e2.printStackTrace();
		}

	    // POSTパラメータ付きでPOSTリクエストを構築
	    HttpPost request = new HttpPost( url );
	    List<NameValuePair> post_params = new ArrayList<NameValuePair>();
	    post_params.add(new BasicNameValuePair("id", "63"));
	    post_params.add(new BasicNameValuePair("day", "today"));
	    
	    try 
	    {
	      request.setEntity(new UrlEncodedFormEntity(post_params, "UTF-8"));
	    }
	    catch (UnsupportedEncodingException e1) 
	    {
	      e1.printStackTrace();
	    }

	    // POSTリクエストを実行
	    DefaultHttpClient httpClient = new DefaultHttpClient();
	    try
	    {
	    	HttpResponse Res = httpClient.execute(request);
	    	ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	        Res.getEntity().writeTo(byteArrayOutputStream);
	        sResult = byteArrayOutputStream.toString();
	    }
	    catch (IOException e) 
	    {
	      Log.d("posttest", "通信に失敗：" + e.toString());
	    }
	    finally 
	    {
	      httpClient.getConnectionManager().shutdown();
	    }
		*/
		
		try 
        {
            URL url = new URL("http://a1140an.appspot.com/");
            Object content = url.getContent();
            if (content instanceof InputStream) 
            {
                BufferedReader bf = new BufferedReader(new InputStreamReader( (InputStream)content) );        
                //String line;
                //while ((line = bf.readLine()) != null) System.out.println(line);
                sResult = bf.readLine();
            }
            // else System.out.println(content.toString());
        }
        // catch (ArrayIndexOutOfBoundsException e) 
        // {
        //     System.err.println("引数にURLを指定してください");
        //     System.exit(-1);
        // }
        catch (IOException e) 
        {
            System.err.println(e);
            System.exit(-1);
        }
  		
	    // 受信結果をUIに表示
		((TextView)(findViewById(R.id.tv_Result))).setText(sResult);
	}
}
package com.app.TheGodfather;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TheGodfather extends Activity implements View.OnClickListener
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

	public void onClick(View arg0) 
	{
		// TODO Auto-generated method stub
		String sWord1 = findViewById(R.id.txb_Word1).toString();
		String sWord2 = findViewById(R.id.txb_Word2).toString();

		Button btn = (Button)findViewById(R.id.btn_Exec);
		btn.setText(sWord1 + sWord2);
		
		// Http Request
		String uri = "http://localhost:8800/echo"; //"http://www.google.co.jp";
		DefaultHttpClient client = new DefaultHttpClient();
		HttpUriRequest method = new HttpGet(uri);
		HttpResponse response = null;
		try {
		    // リクエスト送信
		    response = client.execute(method);
		    /*
		    // レスポンスステータスがOK(200)だった場合
		    if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
		        Log.i(TAG, "request success");
		    } else {
		        Log.i(TAG, "request failed");
		    }
		    */
		}
		catch (ClientProtocolException e) {
		    e.printStackTrace();
		}
		catch (IOException e) {
		    e.printStackTrace();
		}
		
		
		/*
		 // POSTパラメータ付きでPOSTリクエストを構築
	    HttpPost request = new HttpPost( uri );
	    List<String> post_params = new ArrayList<String>();
	    post_params.add(sWord1);
	    post_params.add(sWord2);
	    try {
	      // 送信パラメータのエンコードを指定
	      request.setEntity(new UrlEncodedFormEntity(post_params, "UTF-8"));
	    } catch (UnsupportedEncodingException e1) {
	      e1.printStackTrace();
	    }

	    // POSTリクエストを実行
	    DefaultHttpClient httpClient = new DefaultHttpClient();
	    try {
	      Log.d("posttest", "POST開始");
	      ret = httpClient.execute(request, new ResponseHandler<String>() {

	        @Override
	        public String handleResponse(HttpResponse response) throws IOException
	        {
	          Log.d(
	            "posttest", 
	            "レスポンスコード：" + response.getStatusLine().getStatusCode()
	          );

	          // 正常に受信できた場合は200
	          switch (response.getStatusLine().getStatusCode()) {
	          case HttpStatus.SC_OK:
	            Log.d("posttest", "レスポンス取得に成功");

	            // レスポンスデータをエンコード済みの文字列として取得する
	            return EntityUtils.toString(response.getEntity(), "UTF-8");

	          case HttpStatus.SC_NOT_FOUND:
	            Log.d("posttest", "データが存在しない");
	            return null;

	          default:
	            Log.d("posttest", "通信エラー");
	            return null;
	          }

	        }
	        
	      });

	    } catch (IOException e) {
	      Log.d("posttest", "通信に失敗：" + e.toString());
	    } finally {
	      // shutdownすると通信できなくなる
	      httpClient.getConnectionManager().shutdown();
	    }

	    // 受信結果をUIに表示
	    tv.setText( ret );
	    */
	}
}
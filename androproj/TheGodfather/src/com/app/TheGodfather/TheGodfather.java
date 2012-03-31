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
		    // ���N�G�X�g���M
		    response = client.execute(method);
		    /*
		    // ���X�|���X�X�e�[�^�X��OK(200)�������ꍇ
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
		 // POST�p�����[�^�t����POST���N�G�X�g���\�z
	    HttpPost request = new HttpPost( uri );
	    List<String> post_params = new ArrayList<String>();
	    post_params.add(sWord1);
	    post_params.add(sWord2);
	    try {
	      // ���M�p�����[�^�̃G���R�[�h���w��
	      request.setEntity(new UrlEncodedFormEntity(post_params, "UTF-8"));
	    } catch (UnsupportedEncodingException e1) {
	      e1.printStackTrace();
	    }

	    // POST���N�G�X�g�����s
	    DefaultHttpClient httpClient = new DefaultHttpClient();
	    try {
	      Log.d("posttest", "POST�J�n");
	      ret = httpClient.execute(request, new ResponseHandler<String>() {

	        @Override
	        public String handleResponse(HttpResponse response) throws IOException
	        {
	          Log.d(
	            "posttest", 
	            "���X�|���X�R�[�h�F" + response.getStatusLine().getStatusCode()
	          );

	          // ����Ɏ�M�ł����ꍇ��200
	          switch (response.getStatusLine().getStatusCode()) {
	          case HttpStatus.SC_OK:
	            Log.d("posttest", "���X�|���X�擾�ɐ���");

	            // ���X�|���X�f�[�^���G���R�[�h�ς݂̕�����Ƃ��Ď擾����
	            return EntityUtils.toString(response.getEntity(), "UTF-8");

	          case HttpStatus.SC_NOT_FOUND:
	            Log.d("posttest", "�f�[�^�����݂��Ȃ�");
	            return null;

	          default:
	            Log.d("posttest", "�ʐM�G���[");
	            return null;
	          }

	        }
	        
	      });

	    } catch (IOException e) {
	      Log.d("posttest", "�ʐM�Ɏ��s�F" + e.toString());
	    } finally {
	      // shutdown����ƒʐM�ł��Ȃ��Ȃ�
	      httpClient.getConnectionManager().shutdown();
	    }

	    // ��M���ʂ�UI�ɕ\��
	    tv.setText( ret );
	    */
	}
}
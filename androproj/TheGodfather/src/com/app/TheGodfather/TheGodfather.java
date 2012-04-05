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
		// HTTP�ʐM����
		HttpURLConnection urlCon = null;
		InputStream in = null;
		
        try
        {
            // http�R�l�N�V�������m�����Aurl��@���ď����擾
            URL url = new URL("http://weather.livedoor.com/forecast/webservice/rest/v1");
            urlCon = (HttpURLConnection)url.openConnection();
            urlCon.setRequestMethod("POST");				// �p�����[�^���M��POST���w��
            urlCon.setDoOutput(true); 						// POST�ɂ��f�[�^���M���\�ɂ���

            // POST�p�����[�^
            String postDataSample = "city=63&day=today";	// �p�����[�^�w��

            // POST�p�����[�^��ݒ�
            OutputStream out = urlCon.getOutputStream();
          	out.write(postDataSample.getBytes());
          	out.flush();
          	out.close();

            // �f�[�^���擾
            in = urlCon.getInputStream();					// �ʐM���s�������f�[�^���擾
            BufferedReader br = new BufferedReader(new InputStreamReader(urlCon.getInputStream()));

            // InputStream����byte�f�[�^���擾���邽�߂̕ϐ�
            StringBuffer bufStr = new StringBuffer();
            String temp = null;

            // InputStream����̃f�[�^�𕶎���Ƃ��Ď擾����
            while((temp = br.readLine()) != null) 
            {
                bufStr.append(temp);
            }

            // ���ʂ̎擾
            sResult = bufStr.toString();
        }
        catch (IOException ioe ) 
        {
        	System.out.println(ioe);
        }
        finally 
        {
        	// ��n��
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
		// ����m�F��
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

	    // POST�p�����[�^�t����POST���N�G�X�g���\�z
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

	    // POST���N�G�X�g�����s
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
	      Log.d("posttest", "�ʐM�Ɏ��s�F" + e.toString());
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
        //     System.err.println("������URL���w�肵�Ă�������");
        //     System.exit(-1);
        // }
        catch (IOException e) 
        {
            System.err.println(e);
            System.exit(-1);
        }
  		
	    // ��M���ʂ�UI�ɕ\��
		((TextView)(findViewById(R.id.tv_Result))).setText(sResult);
	}
}
//************************************************
// @file : godfather.js
// @note : javascriptプログラム
//************************************************


//================================================
// @define : 
// @note : 定義各種
//================================================

// ファイルモード各種
var Flag_ForReading = 1;    // 読込
var Flag_ForWriting = 2;    // 上書き書き込み
var Flag_ForAppending = 8;  // 追記書き込み


//================================================
// @func : func_onExec
// @note : 実行ボタンを押した際の挙動
//================================================
function func_onExec()
{
  // 変数
  var sWord = document.getElementById("id_inWord").value;    // 対象ワード
  var sName = document.getElementById("id_inName").value;    // 対象苗字
  
  // ここでサーバにアクセスして結果を取得してくる
  // 検索処理等はサーバに任せる
  var sResult = "どんどんどんどｎ";
  sResult = funcSub_AccessServer();

  // 結果タグにHTMLで内容を記述する
  var info = document.getElementById("p_Result");
  var sText = document.createTextNode(sResult);

  info.removeChild(info.childNodes.item(0));
  info.appendChild(sText);
}


//================================================
// @func : func_onClear
// @note : クリアボタンを押した際の挙動
//================================================
function func_onClear()
{
  // 入力テキストボックスの初期化
  document.getElementById("id_inWord").value = "";
  document.getElementById("id_inName").value = "";
  

  // 結果タグにHTMLの初期化
  var info = document.getElementById("p_Result");
  var sText = document.createTextNode("ここに検索結果が表示されます");

  info.removeChild(info.childNodes.item(0));
  info.appendChild(sText);
}


//================================================
// @func : funcSub_AccessServer
// @note : サーバアクセス部分
//================================================
function funcSub_AccessServer()
{
  // ここでサーバーにアクセスし、処理してもらった情報を受信して結果を受け取る
  // 受け取った結果を返り値として返す
  // まだ仮実装状態

  // Socket初期化
  var socket = new WebSocket("ws://localhost:8800/echo");
  socket.onopen = function(e){ socket.send(document.getElementById("id_inWord").value); }
  socket.onmessage = function(e){ alert("receive"); }
  socket.onerror = function(e){ alert("error"); }
  socket.onclose = function(e){ alert("close websocket"); }

  return "テスト";
}


//================================================
// @func : main
// @note : メインプログラム
//================================================

// UIレイアウト
document.write("<h1>名付け親アプリ</h1><br>");

document.write("入力ワードから過去の人物などを参考に名前を探してきます。<br>");
document.write("これから子供の名前を考えようと思っているアナタ…<br>");
document.write("参考にしてはいかがでしょうか？<br>");
document.write("苗字も入力してくださった方には画数からの名前相性もつけるよ！<br>");
document.write("<br>");

document.write("<table>");
  document.write("<tr>");
    document.write("<td>検索対象ワード</td>");
    document.write("<td><input type=\"text\" id=\"id_inWord\" size=\"45\"></td>");
  document.write("</tr>");
  document.write("<tr>");
    document.write("<td>検索対象苗字</td>");
    document.write("<td><input type=\"text\" id=\"id_inName\" size=\"45\"></td>");
  document.write("</tr>");
document.write("</table>");

document.write("<button style=\"width:80px;\" onClick=\"func_onExec()\">実行</button>");
document.write("<button style=\"width:80px;\" onClick=\"func_onClear()\">クリア</button>");
document.write("<br>");
document.write("<br>");

document.write("<p id=\"p_Result\">ここに検索結果が表示されます</p>");









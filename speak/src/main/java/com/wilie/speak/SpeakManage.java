package com.wilie.speak;

import android.content.Context;
import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.util.Log;

import androidx.annotation.RequiresApi;

import java.util.Locale;

/**
 * author : Wilie
 * e-mail : 869657864@qq.com
 * date   : 8/3/21 11:07 AM
 * desc   : 文字转语音管理器
 */
public class SpeakManage {
   public static SpeakManage instance;
    private TextToSpeech textToSpeech;//tts对象
    private static final String TAG = "SpeakManage";
    private Locale language=Locale.US;//默认语音为英语
    private float pitch=1.5f;//默认音色为
    private float speechRate=1.0f;//默认语速

    private SpeakManage(Context context){
        init(context);
    }

    /**
     * @description 懒汉模式创建单例
     * @parm
     * @return  instance
     * @author wilie
     * @time 8/3/21 11:15 AM
     */
   public  static SpeakManage getInstance(Context context){
       if(instance == null){
           instance=new SpeakManage(context);
       }
       return  instance;
   }
   /**
    * @description 初始化
    * @parm  Context ,TextToSpeech.OnInitListener
    * @return
    * @author wilie
    * @time 8/3/21 11:16 AM
    */
   private void init(Context context){
       if(textToSpeech==null){
           textToSpeech=  new TextToSpeech(context, new TextToSpeech.OnInitListener() {
               @Override
               public void onInit(int status) {//监听状态
                   if (status == TextToSpeech.SUCCESS) {
                       Log.e(TAG,"success");
                       textToSpeech.setLanguage(language);
                       textToSpeech.setPitch(pitch);
                       textToSpeech.setSpeechRate(speechRate);
                   }
               }
           });
       }
   }
   /**
    * @description 设置播放语音的语言
    * @parm  Locale
    * @return
    * @author wilie
    * @time 8/3/21 11:39 AM
    */
   public  void setLanguage(Locale language){
       this.language=language;
   }
    /**
     * @description 设置发音音色
     * @parm float
     * @return 
     * @author wilie
     * @time 8/3/21 11:42 AM
     */
    public  void setPitch(float f){
      this.pitch=f;
    }
    /**
     * @description 设置语速
     * @parm 
     * @return 
     * @author wilie
     * @time 8/3/21 11:42 AM
     */
    public  void setSpeechRate(float f){
      this.speechRate=f;
    }
    /**
     * @description 判断语音是否在播报中
     * @parm
     * @return  boolean
     * @author wilie
     * @time 8/3/21 11:48 AM
     */
    public  boolean isSpeaking(){
        if(textToSpeech!=null){
           return  textToSpeech.isSpeaking();
        }else{
            Log.e(TAG,"tts object is empty!");
            return  false;
        }
    }
    /**
     * @description 关闭tts引擎
     * @parm
     * @return
     * @author wilie
     * @time 8/3/21 11:55 AM
     */
    public void close(){
        if(textToSpeech!=null){
            textToSpeech.shutdown();
        }
    }
    /**
     * @description 中断当前语音
     * @parm
     * @return
     * @author wilie
     * @time 8/3/21 11:56 AM
     */
    public boolean stop(){
        if(textToSpeech!=null){
          int statc=  textToSpeech.stop();
          if(statc==0){
              return true;
          }
          return false;
        }
        return true;
    }
    /**
     * @description 播报内容
     * @parm 
     * @return 
     * @author wilie
     * @time 8/3/21 12:02 PM
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void speak(String text) {
        if (textToSpeech != null) {
            Log.e(TAG,text);
            textToSpeech.speak(text, TextToSpeech.QUEUE_ADD, null,null);
        }

    }
}

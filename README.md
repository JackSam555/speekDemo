# speekDemo
[![](https://jitpack.io/v/JackSam555/speekDemo.svg)](https://jitpack.io/#JackSam555/speekDemo)

Step 1. Add the JitPack repository to your buil
d file   gradle
Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.JackSam555:speekDemo:Tag'
          
	}
Step 3. init


        SpeakManage tts = SpeakManage.getInstance(this);
        tts.setLanguage(Locale.CHINA);//language setting
        tts.setPitch(1.2f);//Set intonation
        tts.setSpeechRate(0.4f);//Set speaking rate
        tts.speak("哈哈哈，我的demo测试成功了");//Broadcast text
	
 
 
          

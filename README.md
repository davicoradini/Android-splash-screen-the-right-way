# How to use a Splash screen correctly

I need to be straight. So, if you're used to create your SplashScreen like this:

```java
public class SplashActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        
        ...
        
        new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(this, MainActivity.class));
                    }
                }, 3000); //fu***ng 3s delay
    }
}
```

You must know that I'd probably hate your apps, because this is a 3 seconds waisting of life time!

##### As you can notice, Google has gotten their opinion in favor of Splash Screens on their [Official Material Design Documentation](https://material.io/guidelines/patterns/launch-screens.html)

###### But, is this something you just put anyway on your app to make the user waste his time?

##### No. And Google advocated against splash screens like this, and even called it an anti-pattern [on this video](https://www.youtube.com/watch?v=pEGWcMTxs3I&feature=youtu.be&t=1434).

##### So, is there a way to make use of this pattern on the right way? The answer is, Yes!

#### So, how could one do to create a Splash Screen just for the amount of time the App needs to open the Main Activity?

##### Well, actually, it's easy. The ingredients are:

* An Activity for the Splash Screen (without the layout file)
* Your Manifest: to declare you Splash Screen as the Launcher
* One drawable file to customize the splash screen a little

 *The splash view has to be ready immediately, even before you can inflate a layout file in your splash activity.*

##### The recipe:

###### Create your Splash Screen Activity

```java
public class SplashActivity extends AppCompatActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        /** START - this is the purpose of this Activity */
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
        /** END - everything more than this is time consuming */
    }
}
```

activity_splash.xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<layer-list xmlns:android="http://schemas.android.com/apk/res/android">

    <item android:drawable="@color/colorGrey"/>

    <item>
        <bitmap android:gravity="center" android:src="@mipmap/ic_launcher"/>
    </item>

</layer-list>
```

and you Manifest should look something like this

```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.andyfriends.showcase">

    <application
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:theme="@style/AppTheme">
        <activity
            android:name=".activities.SplashActivity"
            android:label="@string/app_name"
            android:theme="@style/SplashScreen">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
        <activity android:name=".activities.MainActivity"
            android:label="@string/app_name"
            android:theme="@style/AppTheme" />
    </application>

</manifest>
```

we've set a different Theme for the SplashActivity so we can

```xml
<style name="SplashScreen" parent="Theme.AppCompat.NoActionBar">
    <item name="android:windowBackground">@drawable/activity_splash</item>
</style>
```

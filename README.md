# BottomOptionTrayLayout-android

Simple to use API for opening a bottom-option-tray for choosing an option from list of options.

[![](https://jitpack.io/v/aakashvats2910/BottomOptionTrayLayout-android.svg)](https://jitpack.io/#aakashvats2910/BottomOptionTrayLayout-android)

[![Maintenance](https://img.shields.io/badge/Maintained%3F-yes-green.svg)](https://GitHub.com/Naereen/StrapDown.js/graphs/commit-activity)


<h2> Implementation</h2>
Add it in your root build.gradle at the end of repositories:

```gradle
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}
```

Add it in your project level build.gradle file:

```gradle
dependencies {
  implementation 'com.github.aakashvats2910:BottomOptionTrayLayout-android:1.0'
}
```

<h2> Documentation </h2>

For adding the options first create a TrayOptionList object,
```
TrayOptionsList trayOptionsList = new TrayOptionsList();

trayOptionsList.add(option1);
trayOptionsList.add(option2);
trayOptionsList.add(option3);
```

The Option object will be made from the TrayOptionList.Option class.
There are two constructors for this class which are as following:
```
TrayOptionList.Option option1 = new TrayOptionList.Option(String optionText, Drawable optionDrawable, int optionId);
```
<b>OR</b>
```
TrayOptionList.Option option1 = new TrayOptionList.Option(String optionText, int optionDrawableId, int optionId);
```
<br/>

After that get an instance for ShowOption and open the tray by the following code:
```
ShowOptions s = ShowOptions.getNewInstance(trayOptionsList);
s.openTray(context);
```

To get the selected option we have to set an ShowOptions.OnTrayOptionSelectedListener,
```
s.setOnTrayOptionSelectedListener(new ShowOptions.OnTrayOptionSelectedListener() {
    @Override
    protected void onTrayOptionSelected(int optionId, String optionText, TrayOptionsList.Option option) {

    }
});
```

<h2><i>NOTE</i></h2>
<ol>
<li>The ShowOptions class is a singleton class i.e. only one object of the class can be created and used at a time.</li>
<li>No public constructor is available for this class.</li>
Whenever a new instance of the ShowOptions class is created it overwrites the previous instance.
</ol>

Feel free to contact me on <b>aakashvats2910@gmail.com</b> 

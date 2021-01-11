# BottomOptionTrayLayout-android

Simple to use API for opening a bottom-option-tray for choosing an option from list of options.

[![](https://jitpack.io/v/aakashvats2910/BottomOptionTrayLayout-android.svg)](https://jitpack.io/#aakashvats2910/BottomOptionTrayLayout-android)

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
  implementation 'com.github.aakashvats2910:BottomOptionTrayLayout-android:Tag'
}
```
<i>Tag is the latest jitpack version of dependency</i>

<

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

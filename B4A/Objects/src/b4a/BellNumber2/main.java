package b4a.BellNumber2;


import anywheresoftware.b4a.B4AMenuItem;
import android.app.Activity;
import android.os.Bundle;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.B4AActivity;
import anywheresoftware.b4a.ObjectWrapper;
import anywheresoftware.b4a.objects.ActivityWrapper;
import java.lang.reflect.InvocationTargetException;
import anywheresoftware.b4a.B4AUncaughtException;
import anywheresoftware.b4a.debug.*;
import java.lang.ref.WeakReference;

public class main extends Activity implements B4AActivity{
	public static main mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = false;
	public static final boolean includeTitle = true;
    public static WeakReference<Activity> previousOne;
    public static boolean dontPause;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        mostCurrent = this;
		if (processBA == null) {
			processBA = new BA(this.getApplicationContext(), null, null, "b4a.BellNumber2", "b4a.BellNumber2.main");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (main).");
				p.finish();
			}
		}
        processBA.setActivityPaused(true);
        processBA.runHook("oncreate", this, null);
		if (!includeTitle) {
        	this.getWindow().requestFeature(android.view.Window.FEATURE_NO_TITLE);
        }
        if (fullScreen) {
        	getWindow().setFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN,   
        			android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
		
        processBA.sharedProcessBA.activityBA = null;
		layout = new BALayout(this);
		setContentView(layout);
		afterFirstLayout = false;
        WaitForLayout wl = new WaitForLayout();
        if (anywheresoftware.b4a.objects.ServiceHelper.StarterHelper.startFromActivity(this, processBA, wl, false))
		    BA.handler.postDelayed(wl, 5);

	}
	static class WaitForLayout implements Runnable {
		public void run() {
			if (afterFirstLayout)
				return;
			if (mostCurrent == null)
				return;
            
			if (mostCurrent.layout.getWidth() == 0) {
				BA.handler.postDelayed(this, 5);
				return;
			}
			mostCurrent.layout.getLayoutParams().height = mostCurrent.layout.getHeight();
			mostCurrent.layout.getLayoutParams().width = mostCurrent.layout.getWidth();
			afterFirstLayout = true;
			mostCurrent.afterFirstLayout();
		}
	}
	private void afterFirstLayout() {
        if (this != mostCurrent)
			return;
		activityBA = new BA(this, layout, processBA, "b4a.BellNumber2", "b4a.BellNumber2.main");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.BellNumber2.main", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (main) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (main) Resume **");
        processBA.raiseEvent(null, "activity_resume");
        if (android.os.Build.VERSION.SDK_INT >= 11) {
			try {
				android.app.Activity.class.getMethod("invalidateOptionsMenu").invoke(this,(Object[]) null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public void addMenuItem(B4AMenuItem item) {
		if (menuItems == null)
			menuItems = new java.util.ArrayList<B4AMenuItem>();
		menuItems.add(item);
	}
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
        try {
            if (processBA.subExists("activity_actionbarhomeclick")) {
                Class.forName("android.app.ActionBar").getMethod("setHomeButtonEnabled", boolean.class).invoke(
                    getClass().getMethod("getActionBar").invoke(this), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (processBA.runHook("oncreateoptionsmenu", this, new Object[] {menu}))
            return true;
		if (menuItems == null)
			return false;
		for (B4AMenuItem bmi : menuItems) {
			android.view.MenuItem mi = menu.add(bmi.title);
			if (bmi.drawable != null)
				mi.setIcon(bmi.drawable);
            if (android.os.Build.VERSION.SDK_INT >= 11) {
				try {
                    if (bmi.addToBar) {
				        android.view.MenuItem.class.getMethod("setShowAsAction", int.class).invoke(mi, 1);
                    }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			mi.setOnMenuItemClickListener(new B4AMenuItemsClickListener(bmi.eventName.toLowerCase(BA.cul)));
		}
        
		return true;
	}   
 @Override
 public boolean onOptionsItemSelected(android.view.MenuItem item) {
    if (item.getItemId() == 16908332) {
        processBA.raiseEvent(null, "activity_actionbarhomeclick");
        return true;
    }
    else
        return super.onOptionsItemSelected(item); 
}
@Override
 public boolean onPrepareOptionsMenu(android.view.Menu menu) {
    super.onPrepareOptionsMenu(menu);
    processBA.runHook("onprepareoptionsmenu", this, new Object[] {menu});
    return true;
    
 }
 protected void onStart() {
    super.onStart();
    processBA.runHook("onstart", this, null);
}
 protected void onStop() {
    super.onStop();
    processBA.runHook("onstop", this, null);
}
    public void onWindowFocusChanged(boolean hasFocus) {
       super.onWindowFocusChanged(hasFocus);
       if (processBA.subExists("activity_windowfocuschanged"))
           processBA.raiseEvent2(null, true, "activity_windowfocuschanged", false, hasFocus);
    }
	private class B4AMenuItemsClickListener implements android.view.MenuItem.OnMenuItemClickListener {
		private final String eventName;
		public B4AMenuItemsClickListener(String eventName) {
			this.eventName = eventName;
		}
		public boolean onMenuItemClick(android.view.MenuItem item) {
			processBA.raiseEventFromUI(item.getTitle(), eventName + "_click");
			return true;
		}
	}
    public static Class<?> getObject() {
		return main.class;
	}
    private Boolean onKeySubExist = null;
    private Boolean onKeyUpSubExist = null;
	@Override
	public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeydown", this, new Object[] {keyCode, event}))
            return true;
		if (onKeySubExist == null)
			onKeySubExist = processBA.subExists("activity_keypress");
		if (onKeySubExist) {
			if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK &&
					android.os.Build.VERSION.SDK_INT >= 18) {
				HandleKeyDelayed hk = new HandleKeyDelayed();
				hk.kc = keyCode;
				BA.handler.post(hk);
				return true;
			}
			else {
				boolean res = new HandleKeyDelayed().runDirectly(keyCode);
				if (res)
					return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
	private class HandleKeyDelayed implements Runnable {
		int kc;
		public void run() {
			runDirectly(kc);
		}
		public boolean runDirectly(int keyCode) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keypress", false, keyCode);
			if (res == null || res == true) {
                return true;
            }
            else if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK) {
				finish();
				return true;
			}
            return false;
		}
		
	}
    @Override
	public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeyup", this, new Object[] {keyCode, event}))
            return true;
		if (onKeyUpSubExist == null)
			onKeyUpSubExist = processBA.subExists("activity_keyup");
		if (onKeyUpSubExist) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keyup", false, keyCode);
			if (res == null || res == true)
				return true;
		}
		return super.onKeyUp(keyCode, event);
	}
	@Override
	public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
		this.setIntent(intent);
        processBA.runHook("onnewintent", this, new Object[] {intent});
	}
    @Override 
	public void onPause() {
		super.onPause();
        if (_activity == null)
            return;
        if (this != mostCurrent)
			return;
		anywheresoftware.b4a.Msgbox.dismiss(true);
        if (!dontPause)
            BA.LogInfo("** Activity (main) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (main) Pause event (activity is not paused). **");
        if (mostCurrent != null)
            processBA.raiseEvent2(_activity, true, "activity_pause", false, activityBA.activity.isFinishing());		
        if (!dontPause) {
            processBA.setActivityPaused(true);
            mostCurrent = null;
        }

        if (!activityBA.activity.isFinishing())
			previousOne = new WeakReference<Activity>(this);
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        processBA.runHook("onpause", this, null);
	}

	@Override
	public void onDestroy() {
        super.onDestroy();
		previousOne = null;
        processBA.runHook("ondestroy", this, null);
	}
    @Override 
	public void onResume() {
		super.onResume();
        mostCurrent = this;
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (activityBA != null) { //will be null during activity create (which waits for AfterLayout).
        	ResumeMessage rm = new ResumeMessage(mostCurrent);
        	BA.handler.post(rm);
        }
        processBA.runHook("onresume", this, null);
	}
    private static class ResumeMessage implements Runnable {
    	private final WeakReference<Activity> activity;
    	public ResumeMessage(Activity activity) {
    		this.activity = new WeakReference<Activity>(activity);
    	}
		public void run() {
            main mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (main) Resume **");
            if (mc != mostCurrent)
                return;
		    processBA.raiseEvent(mc._activity, "activity_resume", (Object[])null);
		}
    }
	@Override
	protected void onActivityResult(int requestCode, int resultCode,
	      android.content.Intent data) {
		processBA.onActivityResult(requestCode, resultCode, data);
        processBA.runHook("onactivityresult", this, new Object[] {requestCode, resultCode});
	}
	private static void initializeGlobals() {
		processBA.raiseEvent2(null, true, "globals", false, (Object[])null);
	}
    public void onRequestPermissionsResult(int requestCode,
        String permissions[], int[] grantResults) {
        for (int i = 0;i < permissions.length;i++) {
            Object[] o = new Object[] {permissions[i], grantResults[i] == 0};
            processBA.raiseEventFromDifferentThread(null,null, 0, "activity_permissionresult", true, o);
        }
            
    }

public anywheresoftware.b4a.keywords.Common __c = null;
public static boolean _vvvv2 = false;
public anywheresoftware.b4a.objects.SpinnerWrapper _spinner1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label3 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label4 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label5 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imageview1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label6 = null;
public static int _vvvvvvvvvvvvvvv7 = 0;
public static String _vvvvvvvvvvvvvvv0 = "";
public anywheresoftware.b4a.objects.collections.List _vvvvvvvvvvvvvvvv1 = null;
public anywheresoftware.b4a.objects.collections.List _vvvvvvvvvvvvvvvv2 = null;
public anywheresoftware.b4a.objects.collections.List _vvvvvvvvvvvvvvvv3 = null;
public anywheresoftware.b4a.objects.collections.List _vvvvvvvvvvvvvvvv4 = null;
public anywheresoftware.b4a.objects.collections.List _vvvvvvvvvvvvvvvv5 = null;
public anywheresoftware.b4a.objects.collections.List _vvvvvvvvvvvvvvvv6 = null;
public anywheresoftware.b4a.objects.collections.List _vvvvvvvvvvvvvvvv7 = null;
public anywheresoftware.b4a.objects.collections.List _vvvvvvvvvvvvvvvv0 = null;
public static int _vvvvvvvvvvvvvvvvv1 = 0;
public static int _vvvvvvvvvvvvvvvvv2 = 0;
public static int _vvvvvvvvvvvvvvvvv3 = 0;
public static int _vvvvvvvvvvvvvvvvv4 = 0;
public static int _vvvvvvvvvvvvvvvvv5 = 0;
public static int _vvvvvvvvvvvvvvvvv6 = 0;
public b4a.BellNumber2.starter _vvvv6 = null;
public b4a.BellNumber2.b4xpages _vvvv7 = null;
public b4a.BellNumber2.b4xcollections _vvvv0 = null;

public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
return vis;}
public static String  _activity_actionbarhomeclick() throws Exception{
 //BA.debugLineNum = 69;BA.debugLine="Sub Activity_ActionBarHomeClick";
 //BA.debugLineNum = 70;BA.debugLine="ActionBarHomeClicked = True";
_vvvv2 = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 71;BA.debugLine="B4XPages.Delegate.Activity_ActionBarHomeClick";
mostCurrent._vvvv7._v5 /*b4a.BellNumber2.b4xpagesdelegator*/ ._activity_actionbarhomeclick /*String*/ ();
 //BA.debugLineNum = 72;BA.debugLine="ActionBarHomeClicked = False";
_vvvv2 = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 73;BA.debugLine="End Sub";
return "";
}
public static String  _activity_create(boolean _firsttime) throws Exception{
b4a.BellNumber2.b4xpagesmanager _pm = null;
 //BA.debugLineNum = 51;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 52;BA.debugLine="Dim pm As B4XPagesManager";
_pm = new b4a.BellNumber2.b4xpagesmanager();
 //BA.debugLineNum = 53;BA.debugLine="pm.Initialize(Activity)";
_pm._initialize /*String*/ (mostCurrent.activityBA,mostCurrent._activity);
 //BA.debugLineNum = 54;BA.debugLine="Activity.LoadLayout(\"MainPage\")";
mostCurrent._activity.LoadLayout("MainPage",mostCurrent.activityBA);
 //BA.debugLineNum = 55;BA.debugLine="Activity.Title=\"BellNumber2\"";
mostCurrent._activity.setTitle(BA.ObjectToCharSequence("BellNumber2"));
 //BA.debugLineNum = 56;BA.debugLine="Spinner1.Add(\"1\")";
mostCurrent._spinner1.Add("1");
 //BA.debugLineNum = 57;BA.debugLine="Spinner1.Add(\"2\")";
mostCurrent._spinner1.Add("2");
 //BA.debugLineNum = 58;BA.debugLine="Spinner1.Add(\"3\")";
mostCurrent._spinner1.Add("3");
 //BA.debugLineNum = 59;BA.debugLine="Spinner1.Add(\"4\")";
mostCurrent._spinner1.Add("4");
 //BA.debugLineNum = 60;BA.debugLine="Spinner1.Add(\"5\")";
mostCurrent._spinner1.Add("5");
 //BA.debugLineNum = 64;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
 //BA.debugLineNum = 75;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
 //BA.debugLineNum = 76;BA.debugLine="Return B4XPages.Delegate.Activity_KeyPress(KeyCod";
if (true) return mostCurrent._vvvv7._v5 /*b4a.BellNumber2.b4xpagesdelegator*/ ._activity_keypress /*boolean*/ (_keycode);
 //BA.debugLineNum = 77;BA.debugLine="End Sub";
return false;
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 83;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 84;BA.debugLine="B4XPages.Delegate.Activity_Pause";
mostCurrent._vvvv7._v5 /*b4a.BellNumber2.b4xpagesdelegator*/ ._activity_pause /*String*/ ();
 //BA.debugLineNum = 85;BA.debugLine="End Sub";
return "";
}
public static String  _activity_permissionresult(String _permission,boolean _result) throws Exception{
 //BA.debugLineNum = 87;BA.debugLine="Sub Activity_PermissionResult (Permission As Strin";
 //BA.debugLineNum = 88;BA.debugLine="B4XPages.Delegate.Activity_PermissionResult(Permi";
mostCurrent._vvvv7._v5 /*b4a.BellNumber2.b4xpagesdelegator*/ ._activity_permissionresult /*String*/ (_permission,_result);
 //BA.debugLineNum = 89;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 79;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 80;BA.debugLine="B4XPages.Delegate.Activity_Resume";
mostCurrent._vvvv7._v5 /*b4a.BellNumber2.b4xpagesdelegator*/ ._activity_resume /*String*/ ();
 //BA.debugLineNum = 81;BA.debugLine="End Sub";
return "";
}
public static String  _create_menu(Object _menu) throws Exception{
 //BA.debugLineNum = 91;BA.debugLine="Sub Create_Menu (Menu As Object)";
 //BA.debugLineNum = 92;BA.debugLine="B4XPages.Delegate.Create_Menu(Menu)";
mostCurrent._vvvv7._v5 /*b4a.BellNumber2.b4xpagesdelegator*/ ._create_menu /*String*/ (_menu);
 //BA.debugLineNum = 93;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 21;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 23;BA.debugLine="Private Spinner1 As Spinner";
mostCurrent._spinner1 = new anywheresoftware.b4a.objects.SpinnerWrapper();
 //BA.debugLineNum = 25;BA.debugLine="Private Label3 As Label";
mostCurrent._label3 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 26;BA.debugLine="Private Label4 As Label";
mostCurrent._label4 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 27;BA.debugLine="Private Label5 As Label";
mostCurrent._label5 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 28;BA.debugLine="Private ImageView1 As ImageView";
mostCurrent._imageview1 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 29;BA.debugLine="Private Label6 As Label";
mostCurrent._label6 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 30;BA.debugLine="Dim NOP As Int";
_vvvvvvvvvvvvvvv7 = 0;
 //BA.debugLineNum = 31;BA.debugLine="Dim NOA As String";
mostCurrent._vvvvvvvvvvvvvvv0 = "";
 //BA.debugLineNum = 33;BA.debugLine="Dim list1 As List";
mostCurrent._vvvvvvvvvvvvvvvv1 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 34;BA.debugLine="Dim list2 As List";
mostCurrent._vvvvvvvvvvvvvvvv2 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 35;BA.debugLine="Dim list3 As List";
mostCurrent._vvvvvvvvvvvvvvvv3 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 36;BA.debugLine="Dim list4 As List";
mostCurrent._vvvvvvvvvvvvvvvv4 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 37;BA.debugLine="Dim list5 As List";
mostCurrent._vvvvvvvvvvvvvvvv5 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 38;BA.debugLine="Dim list6 As List";
mostCurrent._vvvvvvvvvvvvvvvv6 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 39;BA.debugLine="Dim list7 As List";
mostCurrent._vvvvvvvvvvvvvvvv7 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 40;BA.debugLine="Dim list8 As List";
mostCurrent._vvvvvvvvvvvvvvvv0 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 42;BA.debugLine="Dim i As Int = 0";
_vvvvvvvvvvvvvvvvv1 = (int) (0);
 //BA.debugLineNum = 43;BA.debugLine="Dim j As Int";
_vvvvvvvvvvvvvvvvv2 = 0;
 //BA.debugLineNum = 44;BA.debugLine="Dim sum1 As Int = 0";
_vvvvvvvvvvvvvvvvv3 = (int) (0);
 //BA.debugLineNum = 45;BA.debugLine="Dim sum2 As Int = 0";
_vvvvvvvvvvvvvvvvv4 = (int) (0);
 //BA.debugLineNum = 46;BA.debugLine="Dim sum3 As Int = 0";
_vvvvvvvvvvvvvvvvv5 = (int) (0);
 //BA.debugLineNum = 47;BA.debugLine="Dim sum4 As Int = 0";
_vvvvvvvvvvvvvvvvv6 = (int) (0);
 //BA.debugLineNum = 49;BA.debugLine="End Sub";
return "";
}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main._process_globals();
starter._process_globals();
b4xpages._process_globals();
b4xcollections._process_globals();
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}

private static byte[][] bb;

public static String vvv13(final byte[] _b, final int i) throws Exception {
Runnable r = new Runnable() {
{

int value = i / 2 + 241017;
if (bb == null) {
		
                bb = new byte[4][];
				bb[0] = BA.packageName.getBytes("UTF8");
                bb[1] = BA.applicationContext.getPackageManager().getPackageInfo(BA.packageName, 0).versionName.getBytes("UTF8");
                if (bb[1].length == 0)
                    bb[1] = "jsdkfh".getBytes("UTF8");
                bb[2] = new byte[] { (byte)BA.applicationContext.getPackageManager().getPackageInfo(BA.packageName, 0).versionCode };			
        }
        bb[3] = new byte[] {
                    (byte) (value >>> 24),
						(byte) (value >>> 16),
						(byte) (value >>> 8),
						(byte) value};
				try {
					for (int __b = 0;__b < (3 + 1);__b ++) {
						for (int b = 0;b<_b.length;b++) {
							_b[b] ^= bb[__b][b % bb[__b].length];
						}
					}

				} catch (Exception e) {
					throw new RuntimeException(e);
				}
                

            
}
public void run() {
}
};
return new String(_b, "UTF8");
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 17;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 18;BA.debugLine="Public ActionBarHomeClicked As Boolean";
_vvvv2 = false;
 //BA.debugLineNum = 19;BA.debugLine="End Sub";
return "";
}
public static String  _spinner1_itemclick(int _position,Object _value) throws Exception{
 //BA.debugLineNum = 108;BA.debugLine="Private Sub Spinner1_ItemClick (Position As Int, V";
 //BA.debugLineNum = 109;BA.debugLine="Select Position";
switch (_position) {
case 0: {
 //BA.debugLineNum = 110;BA.debugLine="Case 0: NOP = 1";
_vvvvvvvvvvvvvvv7 = (int) (1);
 break; }
case 1: {
 //BA.debugLineNum = 111;BA.debugLine="Case 1: NOP = 14";
_vvvvvvvvvvvvvvv7 = (int) (14);
 break; }
case 2: {
 //BA.debugLineNum = 112;BA.debugLine="Case 2: NOP = 10";
_vvvvvvvvvvvvvvv7 = (int) (10);
 break; }
case 3: {
 //BA.debugLineNum = 113;BA.debugLine="Case 3: NOP = 29";
_vvvvvvvvvvvvvvv7 = (int) (29);
 break; }
case 4: {
 //BA.debugLineNum = 114;BA.debugLine="Case 4: NOP = 10";
_vvvvvvvvvvvvvvv7 = (int) (10);
 break; }
}
;
 //BA.debugLineNum = 117;BA.debugLine="NOA = Spinner1.SelectedItem";
mostCurrent._vvvvvvvvvvvvvvv0 = mostCurrent._spinner1.getSelectedItem();
 //BA.debugLineNum = 119;BA.debugLine="If NOA = \"1\"  Then";
if ((mostCurrent._vvvvvvvvvvvvvvv0).equals("1")) { 
 //BA.debugLineNum = 120;BA.debugLine="Label3.Text = NOP";
mostCurrent._label3.setText(BA.ObjectToCharSequence(_vvvvvvvvvvvvvvv7));
 //BA.debugLineNum = 121;BA.debugLine="Label4.Text = \"Chemical Name :\" & CRLF & CRLF &";
mostCurrent._label4.setText(BA.ObjectToCharSequence("Chemical Name :"+anywheresoftware.b4a.keywords.Common.CRLF+anywheresoftware.b4a.keywords.Common.CRLF+"Hydron"));
 //BA.debugLineNum = 122;BA.debugLine="Label5.Text = \"Chemical Formula\"";
mostCurrent._label5.setText(BA.ObjectToCharSequence("Chemical Formula"));
 //BA.debugLineNum = 123;BA.debugLine="ImageView1.Bitmap=LoadBitmapSample(File.DirAsset";
mostCurrent._imageview1.setBitmap((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmapSample(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"Hydrogen(1+).png",(int) (1000),(int) (1000)).getObject()));
 //BA.debugLineNum = 124;BA.debugLine="Label6.Text = \"Algorithm :\" & CRLF & CRLF & \"Col";
mostCurrent._label6.setText(BA.ObjectToCharSequence("Algorithm :"+anywheresoftware.b4a.keywords.Common.CRLF+anywheresoftware.b4a.keywords.Common.CRLF+"Collatz Conjecture"));
 };
 //BA.debugLineNum = 127;BA.debugLine="If NOA =\"2\"  Then";
if ((mostCurrent._vvvvvvvvvvvvvvv0).equals("2")) { 
 //BA.debugLineNum = 128;BA.debugLine="Label3.Text = NOP";
mostCurrent._label3.setText(BA.ObjectToCharSequence(_vvvvvvvvvvvvvvv7));
 //BA.debugLineNum = 129;BA.debugLine="Label4.Text = \"Chemical Name :\" & CRLF & CRLF &";
mostCurrent._label4.setText(BA.ObjectToCharSequence("Chemical Name :"+anywheresoftware.b4a.keywords.Common.CRLF+anywheresoftware.b4a.keywords.Common.CRLF+"Nitrogen"));
 //BA.debugLineNum = 130;BA.debugLine="Label5.Text = \"Chemical Formula\"";
mostCurrent._label5.setText(BA.ObjectToCharSequence("Chemical Formula"));
 //BA.debugLineNum = 131;BA.debugLine="ImageView1.Bitmap=LoadBitmapSample(File.DirAsset";
mostCurrent._imageview1.setBitmap((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmapSample(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"Nitrogen.png",(int) (1000),(int) (1000)).getObject()));
 //BA.debugLineNum = 132;BA.debugLine="Label6.Text = \"Algorithm :\" & CRLF & CRLF & \"My";
mostCurrent._label6.setText(BA.ObjectToCharSequence("Algorithm :"+anywheresoftware.b4a.keywords.Common.CRLF+anywheresoftware.b4a.keywords.Common.CRLF+"My Method"));
 };
 //BA.debugLineNum = 135;BA.debugLine="If NOA=\"3\" Then";
if ((mostCurrent._vvvvvvvvvvvvvvv0).equals("3")) { 
 //BA.debugLineNum = 136;BA.debugLine="Label3.Text = NOP";
mostCurrent._label3.setText(BA.ObjectToCharSequence(_vvvvvvvvvvvvvvv7));
 //BA.debugLineNum = 137;BA.debugLine="Label4.Text = \"Chemical Name :\" & CRLF & CRLF &";
mostCurrent._label4.setText(BA.ObjectToCharSequence("Chemical Name :"+anywheresoftware.b4a.keywords.Common.CRLF+anywheresoftware.b4a.keywords.Common.CRLF+"Water"));
 //BA.debugLineNum = 138;BA.debugLine="Label5.Text = \"Chemical Formula\"";
mostCurrent._label5.setText(BA.ObjectToCharSequence("Chemical Formula"));
 //BA.debugLineNum = 139;BA.debugLine="ImageView1.Bitmap=LoadBitmapSample(File.DirAsset";
mostCurrent._imageview1.setBitmap((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmapSample(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"Water.png",(int) (1000),(int) (1000)).getObject()));
 //BA.debugLineNum = 140;BA.debugLine="Label6.Text = \"Algorithm :\" & CRLF & CRLF & \"Col";
mostCurrent._label6.setText(BA.ObjectToCharSequence("Algorithm :"+anywheresoftware.b4a.keywords.Common.CRLF+anywheresoftware.b4a.keywords.Common.CRLF+"Collatz Conjecture"+anywheresoftware.b4a.keywords.Common.CRLF+anywheresoftware.b4a.keywords.Common.CRLF+"My Method"));
 };
 //BA.debugLineNum = 143;BA.debugLine="If NOA=\"4\" Then";
if ((mostCurrent._vvvvvvvvvvvvvvv0).equals("4")) { 
 //BA.debugLineNum = 144;BA.debugLine="Label3.Text = NOP";
mostCurrent._label3.setText(BA.ObjectToCharSequence(_vvvvvvvvvvvvvvv7));
 //BA.debugLineNum = 145;BA.debugLine="Label4.Text = \"Chemical Name :\" & CRLF & CRLF &";
mostCurrent._label4.setText(BA.ObjectToCharSequence("Chemical Name :"+anywheresoftware.b4a.keywords.Common.CRLF+anywheresoftware.b4a.keywords.Common.CRLF+"Orthoborate"));
 //BA.debugLineNum = 146;BA.debugLine="Label5.Text = \"Chemical Formula\"";
mostCurrent._label5.setText(BA.ObjectToCharSequence("Chemical Formula"));
 //BA.debugLineNum = 147;BA.debugLine="ImageView1.Bitmap=LoadBitmapSample(File.DirAsset";
mostCurrent._imageview1.setBitmap((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmapSample(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"Orthoborate.png",(int) (1000),(int) (1000)).getObject()));
 //BA.debugLineNum = 148;BA.debugLine="Label6.Text = \"Algorithm :\" & CRLF & CRLF & \"Col";
mostCurrent._label6.setText(BA.ObjectToCharSequence("Algorithm :"+anywheresoftware.b4a.keywords.Common.CRLF+anywheresoftware.b4a.keywords.Common.CRLF+"Collatz Conjecture"));
 };
 //BA.debugLineNum = 150;BA.debugLine="If NOA=\"5\"  Then";
if ((mostCurrent._vvvvvvvvvvvvvvv0).equals("5")) { 
 //BA.debugLineNum = 151;BA.debugLine="Label3.Text = NOP";
mostCurrent._label3.setText(BA.ObjectToCharSequence(_vvvvvvvvvvvvvvv7));
 //BA.debugLineNum = 152;BA.debugLine="Label4.Text = \"Chemical Name :\" & CRLF & CRLF &";
mostCurrent._label4.setText(BA.ObjectToCharSequence("Chemical Name :"+anywheresoftware.b4a.keywords.Common.CRLF+anywheresoftware.b4a.keywords.Common.CRLF+"Methane"));
 //BA.debugLineNum = 153;BA.debugLine="Label5.Text = \"Chemical Formula\"";
mostCurrent._label5.setText(BA.ObjectToCharSequence("Chemical Formula"));
 //BA.debugLineNum = 154;BA.debugLine="ImageView1.Bitmap=LoadBitmapSample(File.DirAsset";
mostCurrent._imageview1.setBitmap((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmapSample(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"Methane.png",(int) (1000),(int) (1000)).getObject()));
 //BA.debugLineNum = 155;BA.debugLine="Label6.Text = \"Algorithm :\" & CRLF & CRLF & \"My";
mostCurrent._label6.setText(BA.ObjectToCharSequence("Algorithm :"+anywheresoftware.b4a.keywords.Common.CRLF+anywheresoftware.b4a.keywords.Common.CRLF+"My Method"));
 };
 //BA.debugLineNum = 158;BA.debugLine="End Sub";
return "";
}
public boolean _onCreateOptionsMenu(android.view.Menu menu) {
	 processBA.raiseEvent(null, "create_menu", menu);
	 return true;
	
}
}

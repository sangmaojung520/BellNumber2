package b4a.BellNumber2;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class b4xpages {
private static b4xpages mostCurrent = new b4xpages();
public static Object getObject() {
    throw new RuntimeException("Code module does not support this method.");
}
 public anywheresoftware.b4a.keywords.Common __c = null;
public static Object _vvvvvvvvvvvvvvvvv7 = null;
public static b4a.BellNumber2.b4xpagesdelegator _v5 = null;
public static Object _v6 = null;
public b4a.BellNumber2.main _vvvv5 = null;
public b4a.BellNumber2.starter _vvvv6 = null;
public b4a.BellNumber2.b4xcollections _vvvv0 = null;
public static b4a.BellNumber2.b4xpagesmanager._b4amenuitem  _v7(anywheresoftware.b4a.BA _ba,Object _b4xpage,Object _title) throws Exception{
 //BA.debugLineNum = 91;BA.debugLine="Public Sub AddMenuItem(B4XPage As Object, Title As";
 //BA.debugLineNum = 92;BA.debugLine="Return GetManager.AddMenuItem(B4XPage, Title)";
if (true) return _vv3(_ba)._v7 /*b4a.BellNumber2.b4xpagesmanager._b4amenuitem*/ (_b4xpage,_title);
 //BA.debugLineNum = 93;BA.debugLine="End Sub";
return null;
}
public static String  _v0(anywheresoftware.b4a.BA _ba,String _id,Object _b4xpage) throws Exception{
 //BA.debugLineNum = 37;BA.debugLine="Public Sub AddPage (Id As String, B4XPage As Objec";
 //BA.debugLineNum = 38;BA.debugLine="GetManager.AddPage(Id, B4XPage)";
_vv3(_ba)._v0 /*String*/ (_id,_b4xpage);
 //BA.debugLineNum = 39;BA.debugLine="End Sub";
return "";
}
public static String  _vv1(anywheresoftware.b4a.BA _ba,String _id,Object _b4xpage) throws Exception{
 //BA.debugLineNum = 42;BA.debugLine="Public Sub AddPageAndCreate (Id As String, B4XPage";
 //BA.debugLineNum = 43;BA.debugLine="GetManager.AddPageAndCreate(Id, B4XPage)";
_vv3(_ba)._vv1 /*String*/ (_id,_b4xpage);
 //BA.debugLineNum = 44;BA.debugLine="End Sub";
return "";
}
public static String  _vv2(anywheresoftware.b4a.BA _ba,Object _b4xpage) throws Exception{
 //BA.debugLineNum = 62;BA.debugLine="Public Sub ClosePage (B4XPage As Object)";
 //BA.debugLineNum = 63;BA.debugLine="GetManager.ClosePage (B4XPage)";
_vv3(_ba)._vv2 /*String*/ (_b4xpage);
 //BA.debugLineNum = 64;BA.debugLine="End Sub";
return "";
}
public static b4a.BellNumber2.b4xpagesmanager  _vv3(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 14;BA.debugLine="Public Sub GetManager As B4XPagesManager";
 //BA.debugLineNum = 15;BA.debugLine="Return mPM";
if (true) return (b4a.BellNumber2.b4xpagesmanager)(_vvvvvvvvvvvvvvvvv7);
 //BA.debugLineNum = 16;BA.debugLine="End Sub";
return null;
}
public static anywheresoftware.b4a.objects.ActivityWrapper  _vv4(anywheresoftware.b4a.BA _ba,Object _b4xpage) throws Exception{
 //BA.debugLineNum = 79;BA.debugLine="Public Sub GetNativeParent (B4XPage As Object) As";
 //BA.debugLineNum = 87;BA.debugLine="Return GetManager.FindPIFromB4XPage(B4XPage).Pare";
if (true) return _vv3(_ba)._vvvvvvvvvvvv7 /*b4a.BellNumber2.b4xpagesmanager._b4xpageinfo*/ (_b4xpage).Parent /*b4a.BellNumber2.b4xpagesmanager._b4xpageparent*/ .NativeType /*anywheresoftware.b4a.objects.ActivityWrapper*/ ;
 //BA.debugLineNum = 88;BA.debugLine="End Sub";
return null;
}
public static Object  _vv5(anywheresoftware.b4a.BA _ba,String _id) throws Exception{
 //BA.debugLineNum = 27;BA.debugLine="Public Sub GetPage (Id As String) As Object";
 //BA.debugLineNum = 28;BA.debugLine="Return GetManager.GetPage(Id)";
if (true) return _vv3(_ba)._vv5 /*Object*/ (_id);
 //BA.debugLineNum = 29;BA.debugLine="End Sub";
return null;
}
public static String  _vv6(anywheresoftware.b4a.BA _ba,Object _b4xpage) throws Exception{
 //BA.debugLineNum = 32;BA.debugLine="Public Sub GetPageId (B4XPage As Object) As String";
 //BA.debugLineNum = 33;BA.debugLine="Return GetManager.FindPIFromB4XPage(B4XPage).Id";
if (true) return _vv3(_ba)._vvvvvvvvvvvv7 /*b4a.BellNumber2.b4xpagesmanager._b4xpageinfo*/ (_b4xpage).Id /*String*/ ;
 //BA.debugLineNum = 34;BA.debugLine="End Sub";
return "";
}
public static String  _vv7(anywheresoftware.b4a.BA _ba,Object _pm) throws Exception{
 //BA.debugLineNum = 19;BA.debugLine="Public Sub InternalSetPagesManager(PM As Object)";
 //BA.debugLineNum = 20;BA.debugLine="Delegate.Initialize";
_v5._initialize /*String*/ ((_ba.processBA == null ? _ba : _ba.processBA));
 //BA.debugLineNum = 21;BA.debugLine="mPM = PM";
_vvvvvvvvvvvvvvvvv7 = _pm;
 //BA.debugLineNum = 22;BA.debugLine="End Sub";
return "";
}
public static boolean  _vv0(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 9;BA.debugLine="Public Sub IsInitialized As Boolean";
 //BA.debugLineNum = 10;BA.debugLine="Return mPM Is B4XPagesManager";
if (true) return _vvvvvvvvvvvvvvvvv7 instanceof b4a.BellNumber2.b4xpagesmanager;
 //BA.debugLineNum = 11;BA.debugLine="End Sub";
return false;
}
public static b4a.BellNumber2.b4xmainpage  _vvv1(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 73;BA.debugLine="Public Sub MainPage As B4XMainPage";
 //BA.debugLineNum = 74;BA.debugLine="Return GetManager.MainPage";
if (true) return _vv3(_ba)._vvv1 /*b4a.BellNumber2.b4xmainpage*/ ;
 //BA.debugLineNum = 75;BA.debugLine="End Sub";
return null;
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 1;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 2;BA.debugLine="Private mPM As Object";
_vvvvvvvvvvvvvvvvv7 = new Object();
 //BA.debugLineNum = 3;BA.debugLine="Public Delegate As B4XPagesDelegator";
_v5 = new b4a.BellNumber2.b4xpagesdelegator();
 //BA.debugLineNum = 4;BA.debugLine="Public GlobalContext As Object";
_v6 = new Object();
 //BA.debugLineNum = 5;BA.debugLine="End Sub";
return "";
}
public static String  _vvv2(anywheresoftware.b4a.BA _ba,Object _b4xpage,Object _title) throws Exception{
 //BA.debugLineNum = 68;BA.debugLine="Public Sub SetTitle (B4XPage As Object, Title As O";
 //BA.debugLineNum = 69;BA.debugLine="GetManager.SetTitle(B4XPage, Title)";
_vv3(_ba)._vvv2 /*String*/ (_b4xpage,_title);
 //BA.debugLineNum = 70;BA.debugLine="End Sub";
return "";
}
public static String  _vvv3(anywheresoftware.b4a.BA _ba,String _id) throws Exception{
 //BA.debugLineNum = 50;BA.debugLine="Public Sub ShowPage (Id As String)";
 //BA.debugLineNum = 51;BA.debugLine="GetManager.ShowPage(Id)";
_vv3(_ba)._vvv3 /*String*/ (_id);
 //BA.debugLineNum = 52;BA.debugLine="End Sub";
return "";
}
public static String  _vvv4(anywheresoftware.b4a.BA _ba,String _id) throws Exception{
 //BA.debugLineNum = 56;BA.debugLine="Public Sub ShowPageAndRemovePreviousPages (Id As S";
 //BA.debugLineNum = 57;BA.debugLine="GetManager.ShowPageAndRemovePreviousPages (Id)";
_vv3(_ba)._vvv4 /*String*/ (_id);
 //BA.debugLineNum = 58;BA.debugLine="End Sub";
return "";
}
}

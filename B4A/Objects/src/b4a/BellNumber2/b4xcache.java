package b4a.BellNumber2;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class b4xcache extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "b4a.BellNumber2.b4xcache");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", b4a.BellNumber2.b4xcache.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public b4a.BellNumber2.b4xorderedmap _vvvvv6 = null;
public int _vvvvvvvvv4 = 0;
public float _vvvvvvvvv5 = 0f;
public int _vvvvvvvvv6 = 0;
public b4a.BellNumber2.main _vvvv5 = null;
public b4a.BellNumber2.starter _vvvv6 = null;
public b4a.BellNumber2.b4xpages _vvvv7 = null;
public b4a.BellNumber2.b4xcollections _vvvv0 = null;
public static class _b4xcacheitem{
public boolean IsInitialized;
public Object Value;
public long LastAccessedTime;
public String Key;
public boolean Eternal;
public void Initialize() {
IsInitialized = true;
Value = new Object();
LastAccessedTime = 0L;
Key = "";
Eternal = false;
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 1;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 2;BA.debugLine="Type B4XCacheItem (Value As Object, LastAccessedT";
;
 //BA.debugLineNum = 3;BA.debugLine="Private Data As B4XOrderedMap";
_vvvvv6 = new b4a.BellNumber2.b4xorderedmap();
 //BA.debugLineNum = 4;BA.debugLine="Private mMaxSize As Int = 100";
_vvvvvvvvv4 = (int) (100);
 //BA.debugLineNum = 5;BA.debugLine="Private RemoveThreshold As Float = 0.3";
_vvvvvvvvv5 = (float) (0.3);
 //BA.debugLineNum = 6;BA.debugLine="Private EternalCounts As Int";
_vvvvvvvvv6 = 0;
 //BA.debugLineNum = 7;BA.debugLine="End Sub";
return "";
}
public boolean  _vvvvvvvv1(String _key) throws Exception{
 //BA.debugLineNum = 66;BA.debugLine="Public Sub ContainsKey(Key As String) As Boolean";
 //BA.debugLineNum = 67;BA.debugLine="Return Data.ContainsKey(Key)";
if (true) return _vvvvv6._vvvvvvvv1 /*boolean*/ ((Object)(_key));
 //BA.debugLineNum = 68;BA.debugLine="End Sub";
return false;
}
public b4a.BellNumber2.b4xcache._b4xcacheitem  _vvvvvvvv2(Object _value,String _key) throws Exception{
b4a.BellNumber2.b4xcache._b4xcacheitem _t1 = null;
 //BA.debugLineNum = 102;BA.debugLine="Private Sub CreateB4XCacheItem (Value As Object, K";
 //BA.debugLineNum = 103;BA.debugLine="Dim t1 As B4XCacheItem";
_t1 = new b4a.BellNumber2.b4xcache._b4xcacheitem();
 //BA.debugLineNum = 104;BA.debugLine="t1.Initialize";
_t1.Initialize();
 //BA.debugLineNum = 105;BA.debugLine="t1.Value = Value";
_t1.Value /*Object*/  = _value;
 //BA.debugLineNum = 106;BA.debugLine="t1.LastAccessedTime = DateTime.Now";
_t1.LastAccessedTime /*long*/  = __c.DateTime.getNow();
 //BA.debugLineNum = 107;BA.debugLine="t1.Key = Key";
_t1.Key /*String*/  = _key;
 //BA.debugLineNum = 108;BA.debugLine="Return t1";
if (true) return _t1;
 //BA.debugLineNum = 109;BA.debugLine="End Sub";
return null;
}
public Object  _vvvvv2(String _key) throws Exception{
b4a.BellNumber2.b4xcache._b4xcacheitem _ci = null;
 //BA.debugLineNum = 24;BA.debugLine="Public Sub Get (Key As String) As Object";
 //BA.debugLineNum = 25;BA.debugLine="Dim ci As B4XCacheItem = Data.Get(Key)";
_ci = (b4a.BellNumber2.b4xcache._b4xcacheitem)(_vvvvv6._vvvvv2 /*Object*/ ((Object)(_key)));
 //BA.debugLineNum = 26;BA.debugLine="If ci <> Null Then";
if (_ci!= null) { 
 //BA.debugLineNum = 27;BA.debugLine="If ci.Eternal = False Then ci.LastAccessedTime =";
if (_ci.Eternal /*boolean*/ ==__c.False) { 
_ci.LastAccessedTime /*long*/  = __c.DateTime.getNow();};
 //BA.debugLineNum = 28;BA.debugLine="Return ci.Value";
if (true) return _ci.Value /*Object*/ ;
 };
 //BA.debugLineNum = 30;BA.debugLine="Return Null";
if (true) return __c.Null;
 //BA.debugLineNum = 31;BA.debugLine="End Sub";
return null;
}
public int  _getvvvvvvvvv3() throws Exception{
 //BA.debugLineNum = 19;BA.debugLine="Public Sub getMaxSize As Int";
 //BA.debugLineNum = 20;BA.debugLine="Return mMaxSize";
if (true) return _vvvvvvvvv4;
 //BA.debugLineNum = 21;BA.debugLine="End Sub";
return 0;
}
public String  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 9;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 10;BA.debugLine="Data.Initialize";
_vvvvv6._initialize /*String*/ (ba);
 //BA.debugLineNum = 11;BA.debugLine="End Sub";
return "";
}
public boolean  _vvvvvvvv4(String _key) throws Exception{
b4a.BellNumber2.b4xcache._b4xcacheitem _ci = null;
 //BA.debugLineNum = 60;BA.debugLine="Private Sub IsEternal(Key As String) As Boolean";
 //BA.debugLineNum = 61;BA.debugLine="Dim ci As B4XCacheItem = Data.Get(Key)";
_ci = (b4a.BellNumber2.b4xcache._b4xcacheitem)(_vvvvv6._vvvvv2 /*Object*/ ((Object)(_key)));
 //BA.debugLineNum = 62;BA.debugLine="Return IIf(ci = Null, False, ci.Eternal)";
if (true) return BA.ObjectToBoolean(((_ci== null) ? ((Object)(__c.False)) : ((Object)(_ci.Eternal /*boolean*/ ))));
 //BA.debugLineNum = 63;BA.debugLine="End Sub";
return false;
}
public anywheresoftware.b4a.objects.collections.List  _vvvvvvvv5() throws Exception{
 //BA.debugLineNum = 98;BA.debugLine="Public Sub Keys As List";
 //BA.debugLineNum = 99;BA.debugLine="Return Data.Keys";
if (true) return _vvvvv6._getvvvvvvvv5 /*anywheresoftware.b4a.objects.collections.List*/ ();
 //BA.debugLineNum = 100;BA.debugLine="End Sub";
return null;
}
public Object  _vvvvvvvv6(String _key,Object _value) throws Exception{
 //BA.debugLineNum = 35;BA.debugLine="Public Sub Put (Key As String, Value As Object) As";
 //BA.debugLineNum = 36;BA.debugLine="If IsEternal(Key) Then EternalCounts = EternalCou";
if (_vvvvvvvv4(_key)) { 
_vvvvvvvvv6 = (int) (_vvvvvvvvv6-1);};
 //BA.debugLineNum = 37;BA.debugLine="Data.Put(Key, CreateB4XCacheItem(Value, Key))";
_vvvvv6._vvvvvvvv6 /*String*/ ((Object)(_key),(Object)(_vvvvvvvv2(_value,_key)));
 //BA.debugLineNum = 38;BA.debugLine="TrimIfOversize";
_vvvvvvvvv2();
 //BA.debugLineNum = 39;BA.debugLine="Return Value";
if (true) return _value;
 //BA.debugLineNum = 40;BA.debugLine="End Sub";
return null;
}
public Object  _vvvvvvvv7(String _key,Object _value) throws Exception{
b4a.BellNumber2.b4xcache._b4xcacheitem _ci = null;
 //BA.debugLineNum = 44;BA.debugLine="Public Sub PutEternal (Key As String, Value As Obj";
 //BA.debugLineNum = 45;BA.debugLine="If IsEternal(Key) Then EternalCounts = EternalCou";
if (_vvvvvvvv4(_key)) { 
_vvvvvvvvv6 = (int) (_vvvvvvvvv6-1);};
 //BA.debugLineNum = 46;BA.debugLine="Dim ci As B4XCacheItem = CreateB4XCacheItem(Value";
_ci = _vvvvvvvv2(_value,_key);
 //BA.debugLineNum = 47;BA.debugLine="ci.Eternal = True";
_ci.Eternal /*boolean*/  = __c.True;
 //BA.debugLineNum = 48;BA.debugLine="ci.LastAccessedTime = 9223372036854775807";
_ci.LastAccessedTime /*long*/  = (long) (9223372036854775807L);
 //BA.debugLineNum = 49;BA.debugLine="EternalCounts = EternalCounts + 1";
_vvvvvvvvv6 = (int) (_vvvvvvvvv6+1);
 //BA.debugLineNum = 50;BA.debugLine="Data.Put(Key, ci)";
_vvvvv6._vvvvvvvv6 /*String*/ ((Object)(_key),(Object)(_ci));
 //BA.debugLineNum = 51;BA.debugLine="Return Value";
if (true) return _value;
 //BA.debugLineNum = 52;BA.debugLine="End Sub";
return null;
}
public String  _vvvvvvv1(String _key) throws Exception{
 //BA.debugLineNum = 55;BA.debugLine="Public Sub Remove (Key As String)";
 //BA.debugLineNum = 56;BA.debugLine="If IsEternal(Key) Then EternalCounts = EternalCou";
if (_vvvvvvvv4(_key)) { 
_vvvvvvvvv6 = (int) (_vvvvvvvvv6-1);};
 //BA.debugLineNum = 57;BA.debugLine="Data.Remove(Key)";
_vvvvv6._vvvvvvv1 /*String*/ ((Object)(_key));
 //BA.debugLineNum = 58;BA.debugLine="End Sub";
return "";
}
public String  _vvvvvvvv0(long _agems) throws Exception{
anywheresoftware.b4a.objects.collections.List _values = null;
long _level = 0L;
b4a.BellNumber2.b4xcache._b4xcacheitem _ci = null;
 //BA.debugLineNum = 82;BA.debugLine="Public Sub RemoveOldItems (AgeMs As Long)";
 //BA.debugLineNum = 83;BA.debugLine="Dim values As List = Data.Values";
_values = new anywheresoftware.b4a.objects.collections.List();
_values = _vvvvv6._getvvvvvvvvvv0 /*anywheresoftware.b4a.objects.collections.List*/ ();
 //BA.debugLineNum = 84;BA.debugLine="Dim level As Long = DateTime.Now - AgeMs";
_level = (long) (__c.DateTime.getNow()-_agems);
 //BA.debugLineNum = 85;BA.debugLine="For Each ci As B4XCacheItem In values";
{
final anywheresoftware.b4a.BA.IterableList group3 = _values;
final int groupLen3 = group3.getSize()
;int index3 = 0;
;
for (; index3 < groupLen3;index3++){
_ci = (b4a.BellNumber2.b4xcache._b4xcacheitem)(group3.Get(index3));
 //BA.debugLineNum = 86;BA.debugLine="If ci.LastAccessedTime <= level Then";
if (_ci.LastAccessedTime /*long*/ <=_level) { 
 //BA.debugLineNum = 87;BA.debugLine="Data.Remove(ci.Key)";
_vvvvv6._vvvvvvv1 /*String*/ ((Object)(_ci.Key /*String*/ ));
 };
 }
};
 //BA.debugLineNum = 90;BA.debugLine="End Sub";
return "";
}
public String  _setvvvvvvvvv3(int _s) throws Exception{
 //BA.debugLineNum = 14;BA.debugLine="Public Sub setMaxSize(s As Int)";
 //BA.debugLineNum = 15;BA.debugLine="mMaxSize = s";
_vvvvvvvvv4 = _s;
 //BA.debugLineNum = 16;BA.debugLine="TrimIfOversize";
_vvvvvvvvv2();
 //BA.debugLineNum = 17;BA.debugLine="End Sub";
return "";
}
public int  _vvvvv5() throws Exception{
 //BA.debugLineNum = 93;BA.debugLine="Public Sub Size As Int";
 //BA.debugLineNum = 94;BA.debugLine="Return Data.Size";
if (true) return _vvvvv6._getvvvvv5 /*int*/ ();
 //BA.debugLineNum = 95;BA.debugLine="End Sub";
return 0;
}
public String  _vvvvvvvvv2() throws Exception{
anywheresoftware.b4a.objects.collections.List _values = null;
int _numberofitemstoremove = 0;
int _i = 0;
 //BA.debugLineNum = 70;BA.debugLine="Private Sub TrimIfOversize";
 //BA.debugLineNum = 71;BA.debugLine="If Data.Size - EternalCounts > mMaxSize Then";
if (_vvvvv6._getvvvvv5 /*int*/ ()-_vvvvvvvvv6>_vvvvvvvvv4) { 
 //BA.debugLineNum = 72;BA.debugLine="Dim values As List = Data.Values";
_values = new anywheresoftware.b4a.objects.collections.List();
_values = _vvvvv6._getvvvvvvvvvv0 /*anywheresoftware.b4a.objects.collections.List*/ ();
 //BA.debugLineNum = 73;BA.debugLine="values.SortType(\"LastAccessedTime\", True)";
_values.SortType("LastAccessedTime",__c.True);
 //BA.debugLineNum = 74;BA.debugLine="Dim NumberOfItemsToRemove As Int = Ceil(mMaxSize";
_numberofitemstoremove = (int) (__c.Ceil(_vvvvvvvvv4*_vvvvvvvvv5));
 //BA.debugLineNum = 75;BA.debugLine="For i = 0 To NumberOfItemsToRemove";
{
final int step5 = 1;
final int limit5 = _numberofitemstoremove;
_i = (int) (0) ;
for (;_i <= limit5 ;_i = _i + step5 ) {
 //BA.debugLineNum = 76;BA.debugLine="Data.Remove(values.Get(i).As(B4XCacheItem).Key)";
_vvvvv6._vvvvvvv1 /*String*/ ((Object)(((b4a.BellNumber2.b4xcache._b4xcacheitem)(_values.Get(_i))).Key /*String*/ ));
 }
};
 };
 //BA.debugLineNum = 79;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}

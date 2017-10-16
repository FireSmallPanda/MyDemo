// cookie存取信息类
export default {
  get(name) { // 取数据
    var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");
    if(arr=document.cookie.match(reg))

    return JSON.parse(unescape(arr[2]));
    else
      return null;
  },
  save (name,items){ // 存数据
    var Days = 30;
    var exp = new Date();
    var json = JSON.stringify(items);
    exp.setTime(exp.getTime() + Days*24*60*60*1000);
    document.cookie = name + "="+ escape (json) + ";expires=" + exp.toGMTString();
  },
  destroy(name) { // 销毁数据
    var exp = new Date();
    exp.setTime(exp.getTime() - 1);
    var cval=getCookie(name);
    if(cval!=null)
      document.cookie= name + "="+cval+";expires="+exp.toGMTString();

  }
}
/**
 * Created by Administrator on 2017/10/13.
 */

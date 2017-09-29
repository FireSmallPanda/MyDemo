// 正则校验器
var CHINESE =/^[\u4E00-\u9FA5]+$/; // 值允许是中文
var ENGLISH = /^[A-Za-z]+$/; // 只允许是英文
export default {
  checkChinese (content) {
    return CHINESE.test(content);
  },
  checkEnglish (content){
    return ENGLISH.test(content);
  },

  getPath(url){ // 得到访问路径
    var index = url.indexOf("#");
    var  path = url.substring(index+1,url.length);
    return path;

  },

   getAge(date){
  var   aDate=new   Date();
  var   thisYear=aDate.getYear();
  var brith=date;
  if(!brith)return;//再加上其他判断
  brith=brith.substr(0,4);
  age=(thisYear-brith);
  document.getElementById("date2").value=age;
}
}

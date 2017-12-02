// 正则校验器
var CHINESE =/^[\u4E00-\u9FA5]+$/; // 值允许是中文
var ENGLISH = /^[A-Za-z]+$/; // 只允许是英文
var ACCOUNT =  /^[a-zA-Z0-9_-]{4,16}$/; // 检测账号
var PASSWORDL = /^(?:\d+|[a-zA-Z]+|[!@#$%^&*]+)$/  // 密码强度弱
var PASSWORDZ = /^(?![a-zA-z]+$)(?!\d+$)(?![!@#$%^&*]+$)[a-zA-Z\d!@#$%^&*]+$/ // 密码强度中
var PASSWORDQ = /^(?![a-zA-z]+$)(?!\d+$)(?![!@#$%^&*]+$)(?![a-zA-z\d]+$)(?![a-zA-z!@#$%^&*]+$)(?![\d!@#$%^&*]+$)[a-zA-Z\d!@#$%^&*]+$/ // 密码强度强
var EMAIL  =/^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/ // 邮箱
var TEL  =/^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\d{8}$/ // 手机号

export default {
  checkChinese (content) { // 检查中文
    return CHINESE.test(content);
  },
  checkEnglish (content){ // 检查英文
    return ENGLISH.test(content);
  },
  checkAccount(content){ // 检查账号
    return ACCOUNT.test(content);
  },

  checkPassword(content){ // 检查密码
      if(PASSWORDQ.test(content)&&content.length>=6){
        return 3;
      }else if(PASSWORDZ.test(content)&&content.length>=6){
        return 2;

      }else if(PASSWORDL.test(content)&&content.length>=6){
        return 1;
      }else{

        return -1;
      }


    return ACCOUNT.test(content);
  },
  checkEmail(content){//检查邮箱

    return EMAIL.test(content);

  },
  checkTel(content){ // 检查电话
        return TEL.test(content);
    
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

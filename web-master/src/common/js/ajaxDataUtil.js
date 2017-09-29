/**
 * Created by Administrator on 2017/6/8.
 */
export default {
  getAjaxData (response) { // ajax取数据
    //return JSON.parse(response); // 联调
    return response.data; // mock数据
  }
}

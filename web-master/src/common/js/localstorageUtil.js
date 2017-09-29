
// 长期存取信息类
export default {
  fetch (name) { // 取数据
    return JSON.parse(window.localStorage.getItem(name))
  },
  save (name,items){ // 存数据
    window.localStorage.setItem(name,JSON.stringify(items))
  },
  destroy(name) { // 销毁数据
    window.localStorage.remove.removeItem(items);
  }
}

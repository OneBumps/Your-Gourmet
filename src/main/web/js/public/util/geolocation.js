function getGeolocation() {
  let geolocation = new BMap.Geolocation();
  geolocation.getCurrentPosition(function (r) {
    if (this.getStatus() == BMAP_STATUS_SUCCESS) {
      // 获取城市名称
      let province = r.address.province;
      let cityName = r.address.city;
      console.log(province, cityName)
    }
  },{enableHighAccuracy: true})
}

getGeolocation();
// document.querySelector('#getGeolocation').addEventListener('click', getGeolocation, false)
